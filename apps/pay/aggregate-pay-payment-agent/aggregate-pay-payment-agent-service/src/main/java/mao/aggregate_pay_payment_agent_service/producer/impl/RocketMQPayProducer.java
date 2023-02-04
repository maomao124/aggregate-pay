package mao.aggregate_pay_payment_agent_service.producer.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_payment_agent_api.dto.PaymentResponseDTO;
import mao.aggregate_pay_payment_agent_service.constants.RocketMQConstants;
import mao.aggregate_pay_payment_agent_service.producer.PayProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_service.producer.impl
 * Class(类名): RocketMQPayProducer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/3
 * Time(创建时间)： 23:39
 * Version(版本): 1.0
 * Description(描述)： 发送支付相关消息的类
 */

@Slf4j
@Component
public class RocketMQPayProducer implements PayProducer
{
    @Resource
    private RocketMQTemplate rocketMQTemplate;


    /**
     * 向消息队列发送消息（查询支付宝、微信订单状态）
     *
     * @param paymentResponseDTO PaymentResponseDTO
     */
    public void payOrderNotice(PaymentResponseDTO<String> paymentResponseDTO)
    {
        //发送延迟消息
        Message<PaymentResponseDTO<String>> message = MessageBuilder.withPayload(paymentResponseDTO).build();
        //延迟第3级发送（延迟10秒）
        rocketMQTemplate.syncSend(RocketMQConstants.TOPIC_ORDER, message, 6000, 3);
        log.info("支付渠道代理服务向mq发送订单查询的消息：{}", JSON.toJSONString(paymentResponseDTO));
    }


    /**
     * 发送消息（支付结果）
     *
     * @param paymentResponseDTO PaymentResponseDTO
     */
    public void payResultNotice(PaymentResponseDTO<String> paymentResponseDTO)
    {
        rocketMQTemplate.convertAndSend(RocketMQConstants.TOPIC_RESULT, paymentResponseDTO);
        log.info("支付渠道代理服务向mq支付结果消息：{}", JSON.toJSONString(paymentResponseDTO));
    }
}
