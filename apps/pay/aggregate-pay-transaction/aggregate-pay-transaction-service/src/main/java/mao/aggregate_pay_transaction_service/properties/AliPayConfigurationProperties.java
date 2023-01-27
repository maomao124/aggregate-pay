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
     * 编码
     */
    private String charSet = "UTF-8";

    /**
     * 服务网关地址
     */
    private String serverUrl = "https://openapi.alipaydev.com/gateway.do";

    /**
     * 加密方法
     */
    private String encryptionMethod = "RSA2";

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
     * @param charSet          字符组
     * @param serverUrl        服务器url
     * @param encryptionMethod 加密方法
     * @param appId            应用程序id
     * @param appPrivateKey    应用私钥
     * @param alipayPublicKey  支付宝公钥
     */
    public AliPayConfigurationProperties(String charSet, String serverUrl, String encryptionMethod, String appId, String appPrivateKey, String alipayPublicKey)
    {
        this.charSet = charSet;
        this.serverUrl = serverUrl;
        this.encryptionMethod = encryptionMethod;
        this.appId = appId;
        this.appPrivateKey = appPrivateKey;
        this.alipayPublicKey = alipayPublicKey;
    }

    /**
     * 获取字符设置
     *
     * @return {@link String}
     */
    public String getCharSet()
    {
        return charSet;
    }

    /**
     * 字符集合
     *
     * @param charSet 字符组
     */
    public void setCharSet(String charSet)
    {
        this.charSet = charSet;
    }

    /**
     * 获取服务器url
     *
     * @return {@link String}
     */
    public String getServerUrl()
    {
        return serverUrl;
    }

    /**
     * 设置服务器url
     *
     * @param serverUrl 服务器url
     */
    public void setServerUrl(String serverUrl)
    {
        this.serverUrl = serverUrl;
    }

    /**
     * 得到加密方法
     *
     * @return {@link String}
     */
    public String getEncryptionMethod()
    {
        return encryptionMethod;
    }

    /**
     * 设置加密方法
     *
     * @param encryptionMethod 加密方法
     */
    public void setEncryptionMethod(String encryptionMethod)
    {
        this.encryptionMethod = encryptionMethod;
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
