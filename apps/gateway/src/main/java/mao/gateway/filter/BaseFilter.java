package mao.gateway.filter;

import cn.hutool.core.util.StrUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import mao.tools_common.config.IgnoreTokenConfig;
import mao.tools_core.base.R;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.gateway.filter
 * Class(类名): BaseFilter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/13
 * Time(创建时间)： 14:08
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public abstract class BaseFilter extends ZuulFilter
{
    @Value("${server.servlet.context-path}")
    protected String zuulPrefix;// /api

    /**
     * 判断当前请求uri是否需要忽略（直接放行）
     *
     * @return boolean
     */
    protected boolean isIgnoreToken()
    {
        //动态获取当前请求的uri
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String uri = request.getRequestURI();
        uri = StrUtil.subSuf(uri, zuulPrefix.length());
        uri = StrUtil.subSuf(uri, uri.indexOf("/", 1));
        return IgnoreTokenConfig.isIgnoreToken(uri);
    }

    /**
     * 错误响应
     * 网关抛异常，不再进行路由，而是直接返回到前端
     *
     * @param errMsg         错误消息
     * @param errCode        错误代码
     * @param httpStatusCode http状态代码
     */
    protected void errorResponse(String errMsg, int errCode, int httpStatusCode)
    {
        RequestContext currentContext = RequestContext.getCurrentContext();
        //设置响应状态码
        currentContext.setResponseStatusCode(httpStatusCode);
        //设置响应头信息
        currentContext.addZuulResponseHeader("Content-Type", "application/json;charset=utf-8");
        if (currentContext.getResponseBody() == null)
        {
            //设置响应体
            currentContext.setResponseBody(R.fail(errCode, errMsg).toString());
            //不进行路由，直接返回
            currentContext.setSendZuulResponse(false);
        }
    }
}
