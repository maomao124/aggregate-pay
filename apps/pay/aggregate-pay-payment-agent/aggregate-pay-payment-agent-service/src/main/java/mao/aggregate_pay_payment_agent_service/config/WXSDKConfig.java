package mao.aggregate_pay_payment_agent_service.config;

import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayConstants;
import mao.aggregate_pay_payment_agent_api.dto.WXConfigParam;
import org.springframework.util.Assert;

import java.io.InputStream;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_service.config
 * Class(类名): WXSDKConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 20:02
 * Version(版本): 1.0
 * Description(描述)： 微信支付参数
 */

public class WXSDKConfig extends WXPayConfig
{

    private final WXConfigParam param;

    /**
     * 微信支付参数
     *
     * @param param 参数
     */
    public WXSDKConfig(WXConfigParam param)
    {
        Assert.notNull(param, "微信支付参数不能为空");
        this.param = param;
    }

    /**
     * 得到参数
     *
     * @return {@link WXConfigParam}
     */
    public WXConfigParam getParam()
    {
        return param;
    }

    /**
     * 得到应用程序id
     *
     * @return {@link String}
     */
    public String getAppID()
    {
        return param.getAppId();
    }

    /**
     * 得到商户id
     *
     * @return {@link String}
     */
    @Override
    protected String getMchID()
    {
        return param.getMchId();
    }

    /**
     * 得到key
     *
     * @return {@link String}
     */
    @Override
    protected String getKey()
    {
        return param.getKey();
    }


    /**
     * 得到应用程序秘钥
     *
     * @return {@link String}
     */
    public String getAppSecret()
    {
        return param.getAppSecret();
    }

    public InputStream getCertStream()
    {
        return null;
    }

    public int getHttpConnectTimeoutMs()
    {
        return 8000;
    }

    public int getHttpReadTimeoutMs()
    {
        return 10000;
    }

    @Override
    protected IWXPayDomain getWXPayDomain()
    {
        return new IWXPayDomain()
        {
            @Override
            public void report(String s, long l, Exception e)
            {

            }

            @Override
            public DomainInfo getDomain(WXPayConfig wxPayConfig)
            {
                //api.mch.weixin.qq.com
                return new DomainInfo(WXPayConstants.DOMAIN_API, true);
            }
        };
    }
}
