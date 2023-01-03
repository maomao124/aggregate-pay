package mao.sms_server.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.factory
 * Class(类名): ServerRegister
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/2
 * Time(创建时间)： 14:23
 * Version(版本): 1.0
 * Description(描述)： 服务注册器，将短信发送服务注册到Redis中，定时服务上报，定时服务检查
 */

@Component
@Slf4j
@Order(value = 100)
public class ServerRegister implements CommandLineRunner
{
    /**
     * 服务器id
     * 当前服务实例的唯一标识，可以使用UUID随机生成
     */
    public static String SERVER_ID = null;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 项目启动时自动执行此方法，将当前服务实例注册到redis
     *
     * @param args 参数
     */
    @Override
    public void run(String... args)
    {
        //服务注册器，项目启动时将当前服务id注册到Redis中，使用Redis的Hash结构，key为SERVER_ID_HASH，Hash结构的key为服务id，value为时间戳

        //为当前服务实例生成一个服务唯一标识
        SERVER_ID = UUID.randomUUID().toString();
        log.info("生成当前服务实例id:" + SERVER_ID);

        stringRedisTemplate.opsForHash().put("SERVER_ID_HASH", SERVER_ID, System.currentTimeMillis());
    }

    /**
     * 定时服务报告
     * 报告服务信息证明服务存在 每三分钟报告一次，并传入当前时间戳
     */
    @Scheduled(cron = "1 0/3 * * * ?")
    public void serverReport()
    {
        //服务注册器，每三分钟报告一次，并传入当前时间戳
        log.info("定时上报，服务id：{}，时间戳：{}", SERVER_ID, System.currentTimeMillis());
        stringRedisTemplate.opsForHash().put("SERVER_ID_HASH", SERVER_ID, System.currentTimeMillis());
    }

    /**
     * 定时服务检查
     * 每十分钟检查一次服务列表，清空超过五分钟没有报告的服务
     */
    @Scheduled(cron = "30 0/10 * * * ?")
    public void checkServer()
    {
        //服务注册器，定时服务检查，每十分钟检查一次服务列表，清空超过五分钟没有报告的服务

        log.info("进行服务实例的检查，执行当前任务的服务为：{}", SERVER_ID);

        //获得Redis中注册的所有服务实例id
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries("SERVER_ID_HASH");

        //获取当前系统时间戳
        long current = System.currentTimeMillis();
        List<String> removeKeys = new ArrayList<>();
        map.forEach((key, value) ->
        {//key为服务实例id，value为上报的系统时间戳
            long parseLong = Long.parseLong(value.toString());
            if (current - parseLong > (1000 * 60 * 5))
            {
                //当前服务实例超过5分钟没有上报
                removeKeys.add(key.toString());
            }
        });

        //清理服务实例
        removeKeys.forEach(key ->
        {
            log.info("清理服务实例：{}", key);
            stringRedisTemplate.opsForHash().delete("SERVER_ID_HASH", key);
        });
    }
}
