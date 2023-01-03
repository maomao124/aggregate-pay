package mao.sms_server.redismq;

import lombok.extern.slf4j.Slf4j;
import mao.sms_server.factory.SmsFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.redismq
 * Class(类名): HighSmsListener
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/3
 * Time(创建时间)： 20:44
 * Version(版本): 1.0
 * Description(描述)： 监听消息队列：TOPIC_HIGH_SMS，高优先级的短信，如验证码之类的短信
 */

@Slf4j
@Component
public class HighSmsListener extends Thread
{
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private SmsFactory smsFactory;


    private final String queueKey = "TOPIC_HIGH_SMS";

    /**
     * 队列出队超时时间
     */
    @Value("${spring.redis.queue.pop.timeout:8000}")
    private Long popTimeout = 8000L;

    @PostConstruct
    private void init()
    {
        this.start();
    }

    @Override
    public void run()
    {
        //监听TOPIC_HIGH_SMS队列，如果有消息则调用短信发送工厂发送实时短信

        log.info("监听队列：{}中的短信消息", queueKey);

        //持续监听，所以需要使用死循环
        while (true)
        {
            String message = stringRedisTemplate.opsForList().rightPop(queueKey, popTimeout, TimeUnit.MILLISECONDS);
            if (message != null)
            {
                //队列中有消息，需要发送短信
                log.info("队列：{}中收到短信发送消息：{}", queueKey, message);
                //调用短信发送工厂发送短信
                smsFactory.send(message);
            }
        }
    }
}
