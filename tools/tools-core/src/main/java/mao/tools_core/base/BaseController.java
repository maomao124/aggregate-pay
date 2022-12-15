package mao.tools_core.base;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mao.tools_core.context.BaseContextHandler;
import mao.tools_core.exception.BaseExceptionCode;
import mao.tools_core.exception.BizException;
import mao.tools_core.utils.AntiSqlFilter;
import mao.tools_core.utils.NumberHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static mao.tools_core.utils.DateUtils.DEFAULT_DATE_TIME_FORMAT;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.base
 * Class(类名): BaseController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 14:04
 * Version(版本): 1.0
 * Description(描述)： Controller的父类
 */

public class BaseController
{
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

    /**
     * 当前页
     */
    protected static final String CURRENT = "current";
    /**
     * 每页显示条数
     */
    protected static final String SIZE = "size";
    /**
     * 排序字段 ASC
     */
    protected static final String PAGE_ASCS = "ascs";
    /**
     * 排序字段 DESC
     */
    protected static final String PAGE_DESCS = "descs";

    /**
     * 开始创建时间
     */
    protected static final String START_CREATE_TIME = "startCreateTime";

    /**
     * 最终创建时间
     */
    protected static final String END_CREATE_TIME = "endCreateTime";
    /**
     * 默认每页条目20,最大条目数100
     */
    int DEFAULT_LIMIT = 20;
    int MAX_LIMIT = 100;

    /**
     * 成功返回
     *
     * @param data 数据
     * @return {@link R}<{@link T}>
     */
    public <T> R<T> success(T data)
    {
        return R.success(data);
    }

    /**
     * 成功
     *
     * @return {@link R}<{@link Boolean}>
     */
    public R<Boolean> success()
    {
        return R.success();
    }

    /**
     * 失败返回
     *
     * @param msg 失败消息
     * @return {@link R}<{@link T}>
     */
    public <T> R<T> fail(String msg)
    {
        return R.fail(msg);
    }

    /**
     * 失败
     *
     * @param msg  失败消息
     * @param args 参数
     * @return {@link R}<{@link T}>
     */
    public <T> R<T> fail(String msg, Object... args)
    {
        return R.fail(msg, args);
    }

    /**
     * 失败返回
     *
     * @param code 代码
     * @param msg  失败消息
     * @return {@link R}<{@link T}>
     */
    public <T> R<T> fail(int code, String msg)
    {
        return R.fail(code, msg);
    }

    /**
     * 失败
     *
     * @param exceptionCode 异常代码
     * @return {@link R}<{@link T}>
     */
    public <T> R<T> fail(BaseExceptionCode exceptionCode)
    {
        return R.fail(exceptionCode);
    }

    /**
     * 失败
     *
     * @param exception 业务异常
     * @return {@link R}<{@link T}>
     */
    public <T> R<T> fail(BizException exception)
    {
        return R.fail(exception);
    }

    /**
     * 失败
     *
     * @param throwable throwable
     * @return {@link R}<{@link T}>
     */
    public <T> R<T> fail(Throwable throwable)
    {
        return R.fail(throwable);
    }

    /**
     * 有效失败
     *
     * @param msg 失败消息
     * @return {@link R}<{@link T}>
     */
    public <T> R<T> validFail(String msg)
    {
        return R.validFail(msg);
    }

    /**
     * 有效失败
     *
     * @param msg  失败消息
     * @param args 参数
     * @return {@link R}<{@link T}>
     */
    public <T> R<T> validFail(String msg, Object... args)
    {
        return R.validFail(msg, args);
    }

    /**
     * 有效失败
     *
     * @param exceptionCode 异常代码
     * @return {@link R}<{@link T}>
     */
    public <T> R<T> validFail(BaseExceptionCode exceptionCode)
    {
        return R.validFail(exceptionCode);
    }

    /**
     * 获取当前用户id
     */
    protected Long getUserId()
    {
        return BaseContextHandler.getUserId();
    }

    /**
     * 获得账户
     *
     * @return {@link String}
     */
    protected String getAccount()
    {
        return BaseContextHandler.getAccount();
    }

    /**
     * 得到名字
     *
     * @return {@link String}
     */
    protected String getName()
    {
        return BaseContextHandler.getName();
    }


    /**
     * 获取页面号
     *
     * @return {@link Integer}
     */
    protected Integer getPageNo()
    {
        return NumberHelper.intValueOf(request.getParameter(CURRENT), 1);
    }

    /**
     * 获取每页显示的页面大小
     *
     * @return {@link Integer}
     */
    protected Integer getPageSize()
    {
        return NumberHelper.intValueOf(request.getParameter(SIZE), DEFAULT_LIMIT);
    }

    /**
     * 获取分页对象
     *
     * @return {@link Page}<{@link T}>
     */
    protected <T> Page<T> getPage()
    {
        // 页数
        Integer pageNo = getPageNo();
        // 分页大小
        Integer pageSize = getPageSize();
        // 是否查询分页
        return buildPage(pageNo, pageSize);
    }

    /**
     * 构建页面
     *
     * @param pageNo   页面号码
     * @param pageSize 页面大小
     * @return {@link Page}<{@link T}>
     */
    private <T> Page<T> buildPage(long pageNo, long pageSize)
    {
        // 是否查询分页
        pageSize = pageSize > MAX_LIMIT ? MAX_LIMIT : pageSize;
        Page<T> page = new Page<>(pageNo, pageSize);
        //if (openSort)
        //{
        //被弃用
        //page.setAsc(getParameterSafeValues(PAGE_ASCS));
        //page.setDesc(getParameterSafeValues(PAGE_DESCS));
        //}
        return page;
    }

    /**
     *
     * 获取安全参数(SQL ORDER BY 过滤)
     *
     * @param parameter 参数
     * @return {@link String[]}
     */
    protected String[] getParameterSafeValues(String parameter)
    {
        return AntiSqlFilter.getSafeValues(request.getParameterValues(parameter));
    }

    /**
     * 得到开始创建时间
     *
     * @return {@link LocalDateTime}
     */
    protected LocalDateTime getStartCreateTime()
    {
        return getLocalDateTime(START_CREATE_TIME);
    }

    /**
     * 得到最终创建时间
     *
     * @return {@link LocalDateTime}
     */
    protected LocalDateTime getEndCreateTime()
    {
        return getLocalDateTime(END_CREATE_TIME);
    }

    /**
     * 得到当地日期时间
     *
     * @param endCreateTime 最终创建时间
     * @return {@link LocalDateTime}
     */
    private LocalDateTime getLocalDateTime(String endCreateTime)
    {
        String startCreateTime = request.getParameter(endCreateTime);
        if (StrUtil.isBlank(startCreateTime))
        {
            return null;
        }
        String safeValue = AntiSqlFilter.getSafeValue(startCreateTime);
        if (StrUtil.isBlank(safeValue))
        {
            return null;
        }
        return LocalDateTime.parse(safeValue, DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT));
    }
}
