package mao.sms_server.redismq;

import lombok.extern.slf4j.Slf4j;
import mao.sms_entity.model.ServerTopic;
import mao.sms_server.factory.SmsConnectLoader;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.redismq
 * Class(类名): HighServerReceiver
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/3
 * Time(创建时间)： 20:48
 * Version(版本): 1.0
 * Description(描述)： Redis发布订阅
 * 订阅者，通过Redis的发布订阅模式监听通道相关消息
 */

@Slf4j
@Component
public class HighServerReceiver implements MessageListener
{
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private SmsConnectLoader smsConnectLoader;

    /**
     * 消息监听
     *
     * @param message 消息
     * @param pattern 模式
     */
    @Override
    public void onMessage(Message message, byte[] pattern)
    {
        //消息监听，根据消息内容调用smsConnectLoader进行通道初始化或者通道更新

        //将消息体进行反序列化，得到json字符串
        String jsonMsg = stringRedisTemplate.getDefaultSerializer().deserialize(message.getBody()).toString();
        //将json字符串封装成ServerTopic对象
        ServerTopic serverTopic = ServerTopic.load(jsonMsg);

        switch (serverTopic.getOption())
        {
            case ServerTopic.INIT_CONNECT://初始化通道
                smsConnectLoader.initConnect();
                break;
            case ServerTopic.USE_NEW_CONNECT://更新通道
                smsConnectLoader.changeNewConnect();
            default:
                break;
        }

    }
}
