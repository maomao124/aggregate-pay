package mao.aggregate_pay_payment_agent_service.consumer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_payment_agent_api.dto.AliConfigParam;
import mao.aggregate_pay_payment_agent_api.dto.PaymentResponseDTO;
import mao.aggregate_pay_payment_agent_api.dto.WXConfigParam;
import mao.aggregate_pay_payment_agent_api.enums.TradeStatus;
import mao.aggregate_pay_payment_agent_service.constants.RocketMQConstants;
import mao.aggregate_pay_payment_agent_service.producer.PayProducer;
import mao.aggregate_pay_payment_agent_service.service.PayChannelAgentService;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_service.consumer
 * Class(类名): PayConsumer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/4
 * Time(创建时间)： 14:22
 * Version(版本): 1.0
 * Description(描述)： 支付结果查询相关的消费者，接收支付结果查询消息
 * <p>
 * 消息队列 RocketMQ 默认允许每条消息最多重试 16 次，每次重试的间隔时间如下：
 * <p>
 * <p>
 * | 第几次重试 | 与上次重试的间隔时间 | 第几次重试 | 与上次重试的间隔时间 |
 * | :--------: | :------------------: | :--------: | :------------------: |
 * |     1      |        10 秒         |     9      |        7 分钟        |
 * |     2      |        30 秒         |     10     |        8 分钟        |
 * |     3      |        1 分钟        |     11     |        9 分钟        |
 * |     4      |        2 分钟        |     12     |       10 分钟        |
 * |     5      |        3 分钟        |     13     |       20 分钟        |
 * |     6      |        4 分钟        |     14     |       30 分钟        |
 * |     7      |        5 分钟        |     15     |        1 小时        |
 * |     8      |        6 分钟        |     16     |        2 小时        |
 * <p>
 * 如果消息重试 16 次后仍然失败，消息将不再投递。
 * 如果严格按照上述重试时间间隔计算，某条消息在一直消费失败的前提下，将会在接下来的 4 小时 46 分钟之内进行 16 次重试，
 * 超过这个时间范围消息将不再重试投递。
 */

@Slf4j
@Component
@RocketMQMessageListener(topic = RocketMQConstants.TOPIC_ORDER, consumerGroup = "pay_group")
public class PayConsumer implements RocketMQListener<MessageExt>
{

    @Resource
    private PayChannelAgentService payChannelAgentService;

    @Resource
    private PayProducer payProducer;

    @Override
    public void onMessage(MessageExt messageExt)
    {
        //取出消息内容
        String body = new String(messageExt.getBody(), StandardCharsets.UTF_8);
        //打印
        log.debug("开始消费支付结果查询消息：" + body);
        PaymentResponseDTO<String> response = JSON.parseObject(body, PaymentResponseDTO.class);
        //平台订单号
        String outTradeNo = response.getOutTradeNo();
        //消息
        String msg = response.getMsg();
        //内容
        String configParamJson = response.getContent();
        //判断是支付宝还是微信
        PaymentResponseDTO<String> paymentResponseDTO = new PaymentResponseDTO<>();
        if ("ALIPAY_WAP".equals(msg))
        {
            //主动查询支付宝支付结果
            //json转对象
            AliConfigParam aliConfigParam = JSON.parseObject(configParamJson, AliConfigParam.class);
            //查询
            paymentResponseDTO = payChannelAgentService.queryPayOrderByAli(aliConfigParam, outTradeNo);
        }
        else if ("WX_JSAPI".equals(msg))
        {
            //查询微信支付结果
            //json转对象
            WXConfigParam wxConfigParam = JSON.parseObject(configParamJson, WXConfigParam.class);
            //查询
            paymentResponseDTO = payChannelAgentService.queryPayOrderByWeChat(wxConfigParam, outTradeNo);
        }

        //这里可以获取消息的重试次数，如果超过了16次，就保存到数据库里人工处理

        //返回查询获得的支付状态
        if (TradeStatus.UNKNOWN.equals(paymentResponseDTO.getTradeState()) || TradeStatus.USERPAYING
                .equals(paymentResponseDTO.getTradeState()))
        {
            //在支付状态未知或支付中，抛出异常会重新消费此消息
            log.debug("支付状态未知，等待重试");
            throw new RuntimeException("支付状态未知，等待重试");
        }


        //发送支付结果消息
        payProducer.payResultNotice(paymentResponseDTO);
    }
}
