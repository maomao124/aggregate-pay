package mao.tools_user.interceptor;

import lombok.extern.slf4j.Slf4j;
import mao.tools_core.constants.BaseContextConstants;
import mao.tools_core.context.BaseContextHandler;
import mao.tools_core.utils.StrHelper;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.interceptor
 * Class(类名): ContextHandlerInterceptor
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:43
 * Version(版本): 1.0
 * Description(描述)：
 * <p>
 * 网关：
 * 获取token，并解析，然后将所有的用户、应用信息封装到请求头
 * <p>
 * 拦截器：
 * 解析请求头数据， 将用户信息、应用信息封装到BaseContextHandler
 * 考虑请求来源是否网关（ip等）
 */

@Slf4j
public class ContextHandlerInterceptor extends HandlerInterceptorAdapter
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        try
        {
            if (!(handler instanceof HandlerMethod))
            {
                log.info("not exec!!! url={}", request.getRequestURL());
                return super.preHandle(request, response, handler);
            }
            String userId = getHeader(request, BaseContextConstants.JWT_KEY_USER_ID);
            String account = getHeader(request, BaseContextConstants.JWT_KEY_ACCOUNT);
            String name = getHeader(request, BaseContextConstants.JWT_KEY_NAME);
            String orgId = getHeader(request, BaseContextConstants.JWT_KEY_ORG_ID);
            String stationId = getHeader(request, BaseContextConstants.JWT_KEY_STATION_ID);
            BaseContextHandler.setUserId(userId);
            BaseContextHandler.setAccount(account);
            BaseContextHandler.setName(name);
            BaseContextHandler.setOrgId(orgId);
            BaseContextHandler.setStationId(stationId);
        }
        catch (Exception e)
        {
            log.warn("解析token信息时，发生异常. ", e);
        }
        return super.preHandle(request, response, handler);
    }

    private String getHeader(HttpServletRequest request, String name)
    {
        String value = request.getHeader(name);
        if (StringUtils.isEmpty(value))
        {
            return null;
        }
        return StrHelper.decode(value);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception
    {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
