package mao.aggregate_pay_uaa_service.interceptor;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_uaa_service.utils.IPUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.interceptor
 * Class(类名): IPHandlerInterceptor
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/24
 * Time(创建时间)： 17:08
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
//@Component
public class IPHandlerInterceptor extends HandlerInterceptorAdapter
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String ip = request.getRemoteAddr();
        IPUtils.setIP(ip);
        log.debug("ip地址：" + ip + "  访问uaa服务");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception
    {
        IPUtils.removeIP();
    }
}
