package mao.aggregate_pay_merchant_application.handler;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.BusinessException;
import mao.aggregate_pay_common.domain.CommonErrorCode;
import mao.aggregate_pay_common.domain.ErrorCode;
import mao.aggregate_pay_common.domain.RestErrorResponse;
import mao.tools_core.exception.BizException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.handler
 * Class(类名): GlobalExceptionHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/10
 * Time(创建时间)： 22:22
 * Version(版本): 1.0
 * Description(描述)： 全局异常处理
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler
{
    /**
     * 处理异常
     *
     * @param e Exception
     * @return {@link RestErrorResponse}
     */
    @ExceptionHandler(value = Exception.class)
    public RestErrorResponse processException(Exception e)
    {
        //解析异常信息
        //如果是系统自定义异常，直接取出errCode和errMessage
        if (e instanceof BusinessException)
        {
            log.info(e.getMessage(), e);
            //解析系统自定义异常信息
            BusinessException businessException = (BusinessException) e;
            ErrorCode errorCode = businessException.getErrorCode();
            //错误代码
            int code = errorCode.getCode();
            //错误信息
            String desc = errorCode.getDesc();
            return new RestErrorResponse(String.valueOf(code), desc);
        }
        //系统业务异常
        if (e instanceof BizException)
        {
            log.info(e.getMessage(), e);
            int code = ((BizException) e).getCode();
            //错误信息
            String desc = e.getMessage();
            return new RestErrorResponse(String.valueOf(code), desc);
        }

        log.error("系统异常：", e);
        return new RestErrorResponse(String.valueOf(CommonErrorCode.UNKNOWN.getCode()), CommonErrorCode.UNKNOWN.getDesc());

    }
}
