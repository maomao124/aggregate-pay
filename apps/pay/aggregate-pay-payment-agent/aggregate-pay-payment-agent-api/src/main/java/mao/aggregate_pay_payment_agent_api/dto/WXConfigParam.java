package mao.aggregate_pay_payment_agent_api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.dto
 * Class(类名): WXConfigParam
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 19:54
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@NoArgsConstructor
public class WXConfigParam implements Serializable
{
    /**
     * 应用id
     */
    private String appId;

    /**
     * 是APPID对应的接口密码，用于获取接口调用凭证access_token时使用。
     */
    private String appSecret;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * key
     */
    private String key;

    /**
     * 回调地址
     */
    public String returnUrl;
}
