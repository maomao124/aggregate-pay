package mao.aggregate_pay_log.consumer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_entity.entity.OptLog;
import mao.aggregate_pay_log.service.OptLogService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_log.consumer
 * Class(类名): RocketMQOptLogCustomer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/24
 * Time(创建时间)： 21:48
 * Version(版本): 1.0
 * Description(描述)： 操作日志，消息队列消费者
 * <p>
 * RocketMQMessageListener注解参数说明：
 * - consumerGroup：消费者订阅组，它是必需的，并且必须是唯一的
 * - topic：主题名字，生产发送的主题名
 * - consumeMode：消费模式，可选择并发或有序接收消息；默认CONCURRENTLY同时接收异步传递的消息
 * - messageModel：消息模式，默认CLUSTERING集群消费；如果希望所有订阅者都接收消息，可以设置广播BROADCASTING
 * - consumeThreadMax：消费者最大线程数，默认64
 * - consumeTimeout：消息阻塞最长时间，默认15分钟
 * - nameServer：服务器地址，默认读取配置文件地址，可以单独为消费者设置指定位置
 * - selectorExpression：消费指定的Tag标签的业务消息
 */

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "pay_group", topic = "pay_opt_log_topic")
public class RocketMQOptLogCustomer implements RocketMQListener<String>
{
    @Resource
    private OptLogService optLogService;

    @Override
    public void onMessage(String optLogJson)
    {
        OptLog optLog = JSON.parseObject(optLogJson, OptLog.class);
        log.debug("消费者监听到一条消息  消息主题[pay_opt_log_topic]");
        optLogService.save(optLog);
    }
}
