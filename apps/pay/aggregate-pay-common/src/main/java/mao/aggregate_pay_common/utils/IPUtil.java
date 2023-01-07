package mao.aggregate_pay_common.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): IPUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 20:53
 * Version(版本): 1.0
 * Description(描述)： ip地址工具类
 */

public class IPUtil
{
    /**
     * 得到ip地址
     *
     * @param request HttpServletRequest
     * @return {@link String}
     */
    public static String getIpAddr(HttpServletRequest request)
    {

        String ip = request.getHeader("x-forwarded-for");
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip))
        {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.contains(","))
            {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1") || ip.endsWith("0:0:0:0:0:0:1"))
            {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try
                {
                    inet = InetAddress.getLocalHost();
                }
                catch (UnknownHostException e)
                {
                    e.printStackTrace();
                }
                if (inet != null)
                {
                    ip = inet.getHostAddress();
                }
            }
        }
        return ip;
    }

}
