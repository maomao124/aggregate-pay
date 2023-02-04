package mao.aggregate_pay_payment_agent_service.producer;


import mao.aggregate_pay_payment_agent_api.dto.PaymentResponseDTO;


/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_service.producer
 * Interface(接口名): PayProducer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/3
 * Time(创建时间)： 23:40
 * Version(版本): 1.0
 * Description(描述)： 发送支付相关消息的接口
 */

public interface PayProducer
{
    /**
     * 向消息队列发送消息（查询支付宝、微信订单状态）
     *
     * @param paymentResponseDTO PaymentResponseDTO
     */
    void payOrderNotice(PaymentResponseDTO<String> paymentResponseDTO);


    /**
     * 发送消息（支付结果）
     *
     * @param paymentResponseDTO PaymentResponseDTO
     */
    void payResultNotice(PaymentResponseDTO<String> paymentResponseDTO);
}
