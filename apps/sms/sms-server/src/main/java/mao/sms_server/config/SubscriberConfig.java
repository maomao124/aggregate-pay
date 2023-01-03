package mao.sms_server.config;

import lombok.extern.slf4j.Slf4j;
import mao.sms_server.redismq.HighServerReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.config
 * Class(类名): SubscriberConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/3
 * Time(创建时间)： 20:58
 * Version(版本): 1.0
 * Description(描述)： 订阅发布模式的容器配置
 */

@Slf4j
@Configuration
@AutoConfigureAfter({HighServerReceiver.class})
public class SubscriberConfig
{

    @Resource
    private HighServerReceiver highServerReceiver;

    /**
     * 创建消息监听容器
     *
     * @param redisConnectionFactory RedisConnectionFactory
     * @return {@link RedisMessageListenerContainer}
     */
    @Bean
    public RedisMessageListenerContainer getRedisMessageListenerContainer(@Autowired RedisConnectionFactory redisConnectionFactory)
    {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);

        //可以添加多个监听订阅通道
        //当前监听的是通道：TOPIC_HIGH_SERVER
        redisMessageListenerContainer.addMessageListener(new MessageListenerAdapter(highServerReceiver), new PatternTopic("TOPIC_HIGH_SERVER"));

        return redisMessageListenerContainer;
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 SubscriberConfig");
    }
}
