package mao.sms_manage.config;

import lombok.extern.slf4j.Slf4j;
import mao.sms_manage.listener.MyListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.config
 * Class(类名): SubscriberConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 20:59
 * Version(版本): 1.0
 * Description(描述)： 订阅发布模式的容器配置
 */

@Slf4j
@Configuration
@AutoConfigureAfter({MyListener.class})
public class SubscriberConfig
{
    @Autowired
    private MyListener myListener;

    /**
     * 创建消息监听容器
     *
     * @param redisConnectionFactory redis连接工厂
     * @return {@link RedisMessageListenerContainer}
     */
    @Bean
    public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory)
    {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);

        //可以添加多个监听订阅频道
        //当前监听的是通道：MYTOPIC
        redisMessageListenerContainer.addMessageListener(new MessageListenerAdapter(myListener), new PatternTopic("MYTOPIC"));

        return redisMessageListenerContainer;
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 SubscriberConfig 订阅发布模式的容器配置");
    }
}
