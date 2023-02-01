package mao.aggregate_pay_payment_agent_service.service;

import mao.aggregate_pay_payment_agent_api.dto.AliConfigParam;
import mao.aggregate_pay_payment_agent_api.dto.AlipayBean;
import mao.aggregate_pay_payment_agent_api.dto.PaymentResponseDTO;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_service.service
 * Interface(接口名): PayChannelAgentService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 20:17
 * Version(版本): 1.0
 * Description(描述)： 支付代理服务
 */

public interface PayChannelAgentService
{
    /**
     * 调用支付宝手机WAP下单接口
     *
     * @param aliConfigParam 支付渠道参数
     * @param alipayBean     请求支付参数
     * @return {@link PaymentResponseDTO}
     */
    PaymentResponseDTO<String> createPayOrderByAliWAP(AliConfigParam aliConfigParam, AlipayBean alipayBean);
}
