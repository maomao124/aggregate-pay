package mao.aggregate_pay_payment_agent_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.dto
 * Class(类名): TradeCreateResponse
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 19:44
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TradeCreateResponse implements Serializable
{
    /**
     * 原始支付渠道交易号，目前了解的情况是：支付宝直接返回，微信在支付结果通知才给返回
     */
    private String payChannelTradeNo;

    /**
     * 预支付响应内容 json字符串
     */
    private String responseContent;
}
