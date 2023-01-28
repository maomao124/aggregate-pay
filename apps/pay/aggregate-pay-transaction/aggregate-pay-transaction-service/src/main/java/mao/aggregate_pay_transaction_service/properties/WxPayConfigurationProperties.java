package mao.aggregate_pay_transaction_service.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.properties
 * Class(类名): WxPayConfigurationProperties
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/28
 * Time(创建时间)： 14:10
 * Version(版本): 1.0
 * Description(描述)： 微信支付
 */


@Component
@ConfigurationProperties(prefix = "wxpay")
public class WxPayConfigurationProperties
{
    /**
     * 应用程序id
     */
    private String appID;

    /**
     * 商户id
     */
    private String mchID;

    /**
     * 应用程序秘钥
     */
    private String appSecret;

    /**
     * key
     */
    private String key;

    /**
     * 申请授权码地址
     */
    private String wxOAuth2RequestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize";

    /**
     * 授权回调地址
     */
    private String wxOAuth2CodeReturnUrl;

    /**
     * Instantiates a new Wx pay configuration properties.
     */
    public WxPayConfigurationProperties()
    {

    }

    /**
     * Instantiates a new Wx pay configuration properties.
     *
     * @param appID                 the app id
     * @param mchID                 the mch id
     * @param appSecret             the app secret
     * @param key                   the key
     * @param wxOAuth2RequestUrl    the wx o auth 2 request url
     * @param wxOAuth2CodeReturnUrl the wx o auth 2 code return url
     */
    public WxPayConfigurationProperties(String appID, String mchID, String appSecret, String key, String wxOAuth2RequestUrl, String wxOAuth2CodeReturnUrl)
    {
        this.appID = appID;
        this.mchID = mchID;
        this.appSecret = appSecret;
        this.key = key;
        this.wxOAuth2RequestUrl = wxOAuth2RequestUrl;
        this.wxOAuth2CodeReturnUrl = wxOAuth2CodeReturnUrl;
    }


    /**
     * Gets app id.
     *
     * @return the app id
     */
    public String getAppID()
    {
        return appID;
    }

    /**
     * Sets app id.
     *
     * @param appID the app id
     */
    public void setAppID(String appID)
    {
        this.appID = appID;
    }

    /**
     * Gets mch id.
     *
     * @return the mch id
     */
    public String getMchID()
    {
        return mchID;
    }

    /**
     * Sets mch id.
     *
     * @param mchID the mch id
     */
    public void setMchID(String mchID)
    {
        this.mchID = mchID;
    }

    /**
     * Gets app secret.
     *
     * @return the app secret
     */
    public String getAppSecret()
    {
        return appSecret;
    }

    /**
     * Sets app secret.
     *
     * @param appSecret the app secret
     */
    public void setAppSecret(String appSecret)
    {
        this.appSecret = appSecret;
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public String getKey()
    {
        return key;
    }

    /**
     * Sets key.
     *
     * @param key the key
     */
    public void setKey(String key)
    {
        this.key = key;
    }

    /**
     * Gets wx o auth 2 request url.
     *
     * @return the wx o auth 2 request url
     */
    public String getWxOAuth2RequestUrl()
    {
        return wxOAuth2RequestUrl;
    }

    /**
     * Sets wx o auth 2 request url.
     *
     * @param wxOAuth2RequestUrl the wx o auth 2 request url
     */
    public void setWxOAuth2RequestUrl(String wxOAuth2RequestUrl)
    {
        this.wxOAuth2RequestUrl = wxOAuth2RequestUrl;
    }

    /**
     * Gets wx o auth 2 code return url.
     *
     * @return the wx o auth 2 code return url
     */
    public String getWxOAuth2CodeReturnUrl()
    {
        return wxOAuth2CodeReturnUrl;
    }

    /**
     * Sets wx o auth 2 code return url.
     *
     * @param wxOAuth2CodeReturnUrl the wx o auth 2 code return url
     */
    public void setWxOAuth2CodeReturnUrl(String wxOAuth2CodeReturnUrl)
    {
        this.wxOAuth2CodeReturnUrl = wxOAuth2CodeReturnUrl;
    }
}
