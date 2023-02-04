package mao.aggregate_pay_transaction_service.consumer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_payment_agent_api.dto.PaymentResponseDTO;
import mao.aggregate_pay_payment_agent_api.enums.TradeStatus;
import mao.aggregate_pay_transaction_service.constants.RocketMQConstants;
import mao.aggregate_pay_transaction_service.service.TransactionService;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.consumer
 * Class(类名): TransactionPayConsumer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/4
 * Time(创建时间)： 15:05
 * Version(版本): 1.0
 * Description(描述)： 消费者
 */

@Slf4j
@Component
@RocketMQMessageListener(topic = RocketMQConstants.TOPIC_RESULT, consumerGroup = "pay_group")
public class TransactionPayConsumer implements RocketMQListener<MessageExt>
{

    @Resource
    private TransactionService transactionService;

    @Override
    public void onMessage(MessageExt messageExt)
    {
        //消息体
        String body = new String(messageExt.getBody(), StandardCharsets.UTF_8);
        //json转换成对象
        PaymentResponseDTO<String> res = JSON.parseObject(body, PaymentResponseDTO.class);
        log.debug("接收支付结果消息：" + body);
        //订单状态
        TradeStatus tradeState = res.getTradeState();
        //订单号，不是平台的订单号
        String payChannelTradeNo = res.getTradeNo();
        //平台的订单号
        String tradeNo = res.getOutTradeNo();
        switch (tradeState)
        {
            //支付成功
            case SUCCESS:
                //支付成功时，修改订单状态为支付成功
                transactionService.updateOrderTradeNoAndTradeState(tradeNo,
                        payChannelTradeNo, "2");
                return;
            //交易关闭
            case REVOKED:
                //支付关闭时，修改订单状态为关闭
                transactionService.updateOrderTradeNoAndTradeState(tradeNo,
                        payChannelTradeNo, "4");
                return;
            //交易失败
            case FAILED:
                //支付失败时，修改订单状态为失败
                transactionService.updateOrderTradeNoAndTradeState(tradeNo,
                        payChannelTradeNo, "5");
                return;
            //未知状态
            default:
                throw new RuntimeException(String.format("无法解析支付结果:%s ", body));
        }
    }

}
