package mao.aggregate_pay_entity.enums;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_entity.enums
 * Class(类名): BrowserType
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/30
 * Time(创建时间)： 20:55
 * Version(版本): 1.0
 * Description(描述)： 浏览器类型
 */

public enum BrowserType
{
    /**
     * 支付宝
     */
    ALIPAY,

    /**
     * 微信
     */
    WECHAT,

    /**
     * 电脑浏览器
     */
    PC_BROWSER,

    /**
     * 手机浏览器
     */
    MOBILE_BROWSER;


    /**
     * 根据UA获取浏览器类型
     *
     * @param userAgent userAgent
     * @return 浏览器类型
     */
    public static BrowserType getBrowserTypeByUA(String userAgent)
    {
        if (userAgent != null && userAgent.contains("AlipayClient"))
        {
            return BrowserType.ALIPAY;
        }
        else if (userAgent != null && userAgent.contains("MicroMessenger"))
        {
            return BrowserType.WECHAT;
        }
        else
        {
            return BrowserType.MOBILE_BROWSER;
        }
    }
}
