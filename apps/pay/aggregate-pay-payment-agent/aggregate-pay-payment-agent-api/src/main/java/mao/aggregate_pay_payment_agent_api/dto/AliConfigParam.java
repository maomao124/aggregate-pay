package mao.aggregate_pay_payment_agent_api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.dto
 * Class(类名): AliConfigParam
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 19:52
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
public class AliConfigParam implements Serializable
{
    /**
     * 应用id
     */
    public String appId;

    /**
     * 私钥
     */
    public String rsaPrivateKey;

    /**
     * 异步回调通知
     */
    public String notifyUrl;

    /**
     * 同步回调通知
     */
    public String returnUrl;

    /**
     * 支付宝网关
     */
    public String url;

    /**
     * 编码方式 UTF-8。
     */
    public String charset;

    /**
     * 格式JSON
     */
    public String format;

    /**
     * 支付宝公钥
     */
    public String alipayPublicKey;

    /**
     * 日志保存路径
     */
    public String logPath;

    /**
     * RSA2 户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
     */
    public String signType;
}
