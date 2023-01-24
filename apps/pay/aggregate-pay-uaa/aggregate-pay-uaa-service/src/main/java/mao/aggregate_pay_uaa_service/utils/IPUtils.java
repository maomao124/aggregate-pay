package mao.aggregate_pay_uaa_service.utils;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.utils
 * Class(类名): IPUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/24
 * Time(创建时间)： 17:01
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class IPUtils
{
    /**
     * 存放登录人ip地址的threadLocal，注意要释放
     */
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();


    /**
     * 设置ip地址
     *
     * @param ip 知识产权
     */
    public static void setIP(String ip)
    {
        threadLocal.set(ip);
    }

    /**
     * 获得ip地址
     *
     * @return {@link String}
     */
    public static String getIP()
    {
        return threadLocal.get();
    }

    /**
     * 删除ip地址
     */
    public static void removeIP()
    {
        threadLocal.remove();
    }
}
