package mao.sms_manage.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.listener
 * Class(类名): MyListener
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 21:00
 * Version(版本): 1.0
 * Description(描述)： 自定义消息监听器，用于监听Redis频道中的消息
 */

@Slf4j
@Component
public class MyListener implements MessageListener
{
    /**
     * 监听方法
     *
     * @param message 消息
     * @param pattern 模式
     */
    @Override
    public void onMessage(Message message, byte[] pattern)
    {
        log.info("接收到消息：" + message);
    }
}
