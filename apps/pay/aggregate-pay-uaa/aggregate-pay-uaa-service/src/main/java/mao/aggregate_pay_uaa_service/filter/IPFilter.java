package mao.aggregate_pay_uaa_service.filter;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_uaa_service.utils.IPUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.filter
 * Class(类名): IPFilter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/24
 * Time(创建时间)： 18:06
 * Version(版本): 1.0
 * Description(描述)： mvc的拦截器无法实现在登录前获取ip地址，所以使用过滤器实现
 */

@Slf4j
@Component
public class IPFilter extends OncePerRequestFilter
{

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException
    {
        String ip = httpServletRequest.getRemoteAddr();
        IPUtils.setIP(ip);
        log.debug("ip地址：" + ip + "  访问uaa服务");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        IPUtils.removeIP();
    }
}
