package mao.tools_common.handler;

import cn.hutool.core.util.StrUtil;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.tools_core.exception.ExceptionCode;
import mao.tools_core.utils.StrPool;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.handler
 * Class(类名): DefaultGlobalExceptionHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 20:29
 * Version(版本): 1.0
 * Description(描述)： 默认的全局异常处理
 */

public abstract class DefaultGlobalExceptionHandler
{
    private static final Logger log = LoggerFactory.getLogger(DefaultGlobalExceptionHandler.class);

    /**
     * 业务异常
     *
     * @param ex      业务异常
     * @param request 请求
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler(BizException.class)
    public R<String> bizException(BizException ex, HttpServletRequest request)
    {
        log.warn("BizException:", ex);
        return R.result(ex.getCode(), StrPool.EMPTY, ex.getMessage()).setPath(request.getRequestURI());
    }

    /**
     * http消息不可读异常
     *
     * @param ex      http消息不可读异常
     * @param request 请求
     * @return {@link R}
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R httpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request)
    {
        log.warn("HttpMessageNotReadableException:", ex);
        String message = ex.getMessage();
        if (StrUtil.containsAny(message, "Could not read document:"))
        {
            String msg = String.format("无法正确的解析json类型的参数：%s",
                    StrUtil.subBetween(message, "Could not read document:", " at "));
            return R.result(ExceptionCode.PARAM_EX.getCode(), StrPool.EMPTY, msg).setPath(request.getRequestURI());
        }
        return R.result(ExceptionCode.PARAM_EX.getCode(), StrPool.EMPTY,
                ExceptionCode.PARAM_EX.getMsg()).setPath(request.getRequestURI());
    }

    /**
     * 绑定异常
     *
     * @param ex      绑定异常
     * @param request 请求
     * @return {@link R}
     */
    @ExceptionHandler(BindException.class)
    public R bindException(BindException ex, HttpServletRequest request)
    {
        log.warn("BindException:", ex);
        try
        {
            String msgs = ex.getBindingResult().getFieldError().getDefaultMessage();
            if (StrUtil.isNotEmpty(msgs))
            {
                return R.result(ExceptionCode.PARAM_EX.getCode(), StrPool.EMPTY, msgs).setPath(request.getRequestURI());
            }
        }
        catch (Exception ignored)
        {
        }
        StringBuilder msg = new StringBuilder();
        List<FieldError> fieldErrors = ex.getFieldErrors();
        fieldErrors.forEach((oe) ->
                msg.append("参数:[").append(oe.getObjectName())
                        .append(".").append(oe.getField())
                        .append("]的传入值:[").append(oe.getRejectedValue()).append("]与预期的字段类型不匹配.")
        );
        return R.result(ExceptionCode.PARAM_EX.getCode(), StrPool.EMPTY, msg.toString()).setPath(request.getRequestURI());
    }


    /**
     * 方法参数类型不匹配异常
     *
     * @param ex      方法参数类型不匹配异常
     * @param request 请求
     * @return {@link R}
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public R methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, HttpServletRequest request)
    {
        log.warn("MethodArgumentTypeMismatchException:", ex);
        MethodArgumentTypeMismatchException eee = (MethodArgumentTypeMismatchException) ex;
        StringBuilder msg = new StringBuilder("参数：[").append(eee.getName())
                .append("]的传入值：[").append(eee.getValue())
                .append("]与预期的字段类型：[").append(Objects.requireNonNull(eee.getRequiredType()).getName()).append("]不匹配");
        return R.result(ExceptionCode.PARAM_EX.getCode(), StrPool.EMPTY, msg.toString()).setPath(request.getRequestURI());
    }

    /**
     * 非法状态异常
     *
     * @param ex      非法状态异常
     * @param request 请求
     * @return {@link R}
     */
    @ExceptionHandler(IllegalStateException.class)
    public R illegalStateException(IllegalStateException ex, HttpServletRequest request)
    {
        log.warn("IllegalStateException:", ex);
        return R.result(ExceptionCode.ILLEGALA_ARGUMENT_EX.getCode(), StrPool.EMPTY,
                ExceptionCode.ILLEGALA_ARGUMENT_EX.getMsg()).setPath(request.getRequestURI());
    }

    /**
     * 失踪servlet请求参数异常
     *
     * @param ex      失踪servlet请求参数异常
     * @param request 请求
     * @return {@link R}
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public R missingServletRequestParameterException(MissingServletRequestParameterException ex, HttpServletRequest request)
    {
        log.warn("MissingServletRequestParameterException:", ex);
        StringBuilder msg = new StringBuilder();
        msg.append("缺少必须的[").append(ex.getParameterType()).append("]类型的参数[").append(ex.getParameterName()).append("]");
        return R.result(ExceptionCode.ILLEGALA_ARGUMENT_EX.getCode(),
                StrPool.EMPTY, msg.toString()).setPath(request.getRequestURI());
    }

    /**
     * 空指针异常
     *
     * @param ex      空指针异常
     * @param request 请求
     * @return {@link R}
     */
    @ExceptionHandler(NullPointerException.class)
    public R nullPointerException(NullPointerException ex, HttpServletRequest request)
    {
        log.warn("NullPointerException:", ex);
        return R.result(ExceptionCode.NULL_POINT_EX.getCode(), StrPool.EMPTY,
                ExceptionCode.NULL_POINT_EX.getMsg()).setPath(request.getRequestURI());
    }

    /**
     * 非法参数异常
     *
     * @param ex      非法参数异常
     * @param request 请求
     * @return {@link R}
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public R illegalArgumentException(IllegalArgumentException ex, HttpServletRequest request)
    {
        log.warn("IllegalArgumentException:", ex);
        return R.result(ExceptionCode.ILLEGALA_ARGUMENT_EX.getCode(), StrPool.EMPTY,
                ExceptionCode.ILLEGALA_ARGUMENT_EX.getMsg()).setPath(request.getRequestURI());
    }

    /**
     * http媒体类型不支持异常
     *
     * @param ex      http媒体类型不支持异常
     * @param request 请求
     * @return {@link R}
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public R httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex, HttpServletRequest request)
    {
        log.warn("HttpMediaTypeNotSupportedException:", ex);
        MediaType contentType = ex.getContentType();
        if (contentType != null)
        {
            StringBuilder msg = new StringBuilder();
            msg.append("请求类型(Content-Type)[").append(contentType.toString()).append("] 与实际接口的请求类型不匹配");
            return R.result(ExceptionCode.MEDIA_TYPE_EX.getCode(), StrPool.EMPTY, msg.toString()).setPath(request.getRequestURI());
        }
        return R.result(ExceptionCode.MEDIA_TYPE_EX.getCode(),
                StrPool.EMPTY, "无效的Content-Type类型").setPath(request.getRequestURI());
    }

    /**
     * 失踪servlet请求部分异常
     *
     * @param ex      失踪servlet请求部分异常
     * @param request 请求
     * @return {@link R}
     */
    @ExceptionHandler(MissingServletRequestPartException.class)
    public R missingServletRequestPartException(MissingServletRequestPartException ex, HttpServletRequest request)
    {
        log.warn("MissingServletRequestPartException:", ex);
        return R.result(ExceptionCode.REQUIRED_FILE_PARAM_EX.getCode(), StrPool.EMPTY,
                ExceptionCode.REQUIRED_FILE_PARAM_EX.getMsg()).setPath(request.getRequestURI());
    }

    /**
     * servlet异常
     *
     * @param ex      servlet异常
     * @param request 请求
     * @return {@link R}
     */
    @ExceptionHandler(ServletException.class)
    public R servletException(ServletException ex, HttpServletRequest request)
    {
        log.warn("ServletException:", ex);
        String msg = "UT010016: Not a multi part request";
        if (msg.equalsIgnoreCase(ex.getMessage()))
        {
            return R.result(ExceptionCode.REQUIRED_FILE_PARAM_EX.getCode(), StrPool.EMPTY,
                    ExceptionCode.REQUIRED_FILE_PARAM_EX.getMsg());
        }
        return R.result(ExceptionCode.SYSTEM_BUSY.getCode(), StrPool.EMPTY, ex.getMessage()).setPath(request.getRequestURI());
    }

    /**
     * 多部分异常
     *
     * @param ex      多部分异常
     * @param request 请求
     * @return {@link R}
     */
    @ExceptionHandler(MultipartException.class)
    public R multipartException(MultipartException ex, HttpServletRequest request)
    {
        log.warn("MultipartException:", ex);
        return R.result(ExceptionCode.REQUIRED_FILE_PARAM_EX.getCode(), StrPool.EMPTY,
                ExceptionCode.REQUIRED_FILE_PARAM_EX.getMsg()).setPath(request.getRequestURI());
    }

    /**
     * jsr 规范中的验证异常
     *
     * @param ex      jsr 规范中的验证异常
     * @param request 请求
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public R<String> constraintViolationException(ConstraintViolationException ex, HttpServletRequest request)
    {
        log.warn("ConstraintViolationException:", ex);
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        String message = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
        return R.result(ExceptionCode.BASE_VALID_PARAM.getCode(), StrPool.EMPTY, message).setPath(request.getRequestURI());
    }

    /**
     * spring 封装的参数验证异常， 在conttoller中没有写result参数时，会进入
     *
     * @param ex      MethodArgumentNotValidException
     * @param request 请求
     * @return {@link Object}
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request)
    {
        log.warn("MethodArgumentNotValidException:", ex);
        return R.result(ExceptionCode.BASE_VALID_PARAM.getCode(), StrPool.EMPTY,
                Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage()).setPath(request.getRequestURI());
    }

    /**
     * 其他异常
     *
     * @param ex      Exception
     * @param request 请求
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler(Exception.class)
    public R<String> otherExceptionHandler(Exception ex, HttpServletRequest request)
    {
        log.warn("Exception:", ex);
        if (ex.getCause() instanceof BizException)
        {
            return this.bizException((BizException) ex.getCause(), request);
        }
        return R.result(ExceptionCode.SYSTEM_BUSY.getCode(), StrPool.EMPTY,
                ExceptionCode.SYSTEM_BUSY.getMsg()).setPath(request.getRequestURI());
    }


    /**
     * 不支持异常处理http请求异常
     * 返回状态码:405
     *
     * @param ex      HttpRequestMethodNotSupportedException
     * @param request 请求
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public R<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex,
                                                                  HttpServletRequest request)
    {
        log.warn("HttpRequestMethodNotSupportedException:", ex);
        return R.result(ExceptionCode.METHOD_NOT_ALLOWED.getCode(), StrPool.EMPTY,
                ExceptionCode.METHOD_NOT_ALLOWED.getMsg()).setPath(request.getRequestURI());
    }


    /**
     * 持久性异常
     *
     * @param ex      PersistenceException
     * @param request 请求
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler(PersistenceException.class)
    public R<String> persistenceException(PersistenceException ex, HttpServletRequest request)
    {
        log.warn("PersistenceException:", ex);
        if (ex.getCause() instanceof BizException)
        {
            BizException cause = (BizException) ex.getCause();
            return R.result(cause.getCode(), StrPool.EMPTY, cause.getMessage());
        }
        return R.result(ExceptionCode.SQL_EX.getCode(), StrPool.EMPTY,
                ExceptionCode.SQL_EX.getMsg()).setPath(request.getRequestURI());
    }

    /**
     * mybatis系统异常
     *
     * @param ex      MyBatisSystemException
     * @param request 请求
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler(MyBatisSystemException.class)
    public R<String> myBatisSystemException(MyBatisSystemException ex, HttpServletRequest request)
    {
        log.warn("PersistenceException:", ex);
        if (ex.getCause() instanceof PersistenceException)
        {
            return this.persistenceException((PersistenceException) ex.getCause(), request);
        }
        return R.result(ExceptionCode.SQL_EX.getCode(), StrPool.EMPTY,
                ExceptionCode.SQL_EX.getMsg()).setPath(request.getRequestURI());
    }

    /**
     * sql异常
     *
     * @param ex      SQLException
     * @param request 请求
     * @return {@link R}
     */
    @ExceptionHandler(SQLException.class)
    public R sqlException(SQLException ex, HttpServletRequest request)
    {
        log.warn("SQLException:", ex);
        return R.result(ExceptionCode.SQL_EX.getCode(), StrPool.EMPTY,
                ExceptionCode.SQL_EX.getMsg()).setPath(request.getRequestURI());
    }

    /**
     * 违反数据完整性异常
     *
     * @param ex      DataIntegrityViolationException
     * @param request 请求
     * @return {@link R}
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public R dataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request)
    {
        log.warn("DataIntegrityViolationException:", ex);
        return R.result(ExceptionCode.SQL_EX.getCode(), StrPool.EMPTY,
                ExceptionCode.SQL_EX.getMsg()).setPath(request.getRequestURI());
    }
}
