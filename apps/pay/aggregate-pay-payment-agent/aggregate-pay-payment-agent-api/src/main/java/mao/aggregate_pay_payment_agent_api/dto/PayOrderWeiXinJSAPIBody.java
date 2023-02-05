package mao.aggregate_pay_payment_agent_api.dto;

import lombok.Data;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.dto
 * Class(类名): PayOrderWeiXinJSAPIBody
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/5
 * Time(创建时间)： 14:32
 * Version(版本): 1.0
 * Description(描述)： 支付代理服务controller 的 createPayOrderByWeChatJSAPI方法的请求体
 */

@Data
public class PayOrderWeiXinJSAPIBody
{
    /**
     * 微信配置参数
     */
    private WXConfigParam wxConfigParam;

    /**
     * 微信支付
     */
    private WeChatBean weChatBean;

}
