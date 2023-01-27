package mao.aggregate_pay_transaction_service.properties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.properties
 * Class(类名): AliPayConfigurationProperties
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/27
 * Time(创建时间)： 20:56
 * Version(版本): 1.0
 * Description(描述)： 支付宝支付配置
 */

@Component
@ConfigurationProperties(prefix = "alipay")
public class AliPayConfigurationProperties
{
    /**
     * 应用程序id
     */
    private String appId;

    /**
     * 应用私钥
     */
    private String appPrivateKey;

    /**
     * 支付宝公钥
     */
    private String alipayPublicKey;


    /**
     * 阿里支付配置属性
     */
    public AliPayConfigurationProperties()
    {

    }

    /**
     * 阿里支付配置属性
     *
     * @param appId           应用程序id
     * @param appPrivateKey   应用私钥
     * @param alipayPublicKey 支付宝公钥
     */
    public AliPayConfigurationProperties(String appId, String appPrivateKey, String alipayPublicKey)
    {
        this.appId = appId;
        this.appPrivateKey = appPrivateKey;
        this.alipayPublicKey = alipayPublicKey;
    }

    /**
     * 得到应用程序id
     *
     * @return {@link String}
     */
    public String getAppId()
    {
        return appId;
    }

    /**
     * 设置应用程序id
     *
     * @param appId 应用程序id
     */
    public void setAppId(String appId)
    {
        this.appId = appId;
    }

    /**
     * 得到应用私钥
     *
     * @return {@link String}
     */
    public String getAppPrivateKey()
    {
        return appPrivateKey;
    }

    /**
     * 设置应用程序私钥
     *
     * @param appPrivateKey 应用私钥
     */
    public void setAppPrivateKey(String appPrivateKey)
    {
        this.appPrivateKey = appPrivateKey;
    }

    /**
     * 获取支付宝公钥
     *
     * @return {@link String}
     */
    public String getAlipayPublicKey()
    {
        return alipayPublicKey;
    }

    /**
     * 设置支付宝公钥
     *
     * @param alipayPublicKey 支付宝公钥
     */
    public void setAlipayPublicKey(String alipayPublicKey)
    {
        this.alipayPublicKey = alipayPublicKey;
    }
}
