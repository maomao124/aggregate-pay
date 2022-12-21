package mao.sms_manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_entity.dto.ConfigDTO;
import mao.sms_entity.entity.ConfigEntity;
import mao.sms_entity.mapper.ConfigMapper;
import mao.sms_entity.model.ServerTopic;
import mao.sms_manage.service.ConfigService;
import mao.tools_databases.mybatis.conditions.Wraps;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service.impl
 * Class(类名): ConfigServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/20
 * Time(创建时间)： 19:35
 * Version(版本): 1.0
 * Description(描述)： 通道配置实现类
 */

@Slf4j
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, ConfigEntity> implements ConfigService
{

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public ConfigEntity getByName(String name)
    {
        return this.getOne(Wraps.<ConfigEntity>lbQ().eq(ConfigEntity::getName, name));
    }

    @Override
    public void getNewLevel(ConfigDTO entity)
    {
        //查询水平最高的一个
        ConfigEntity configEntity = this.getOne(Wraps.<ConfigEntity>lbQ().eq(ConfigEntity::getIsEnable, 1)
                .eq(ConfigEntity::getIsActive, 1)
                .orderByDesc(ConfigEntity::getLevel)
                .last(" limit 1"));
        //判断是否为空
        if (configEntity == null)
        {
            //为空，水平设置成1
            entity.setLevel(1);
        }
        else
        {
            //不为空，水平加1
            entity.setLevel(configEntity.getLevel() + 1);
        }
    }

    @Override
    public void sendUpdateMessage()
    {
        Map map = redisTemplate.opsForHash().entries("SERVER_ID_HASH");
        log.info("所有的短信发送服务实例：" + map);
        //当前时间戳
        long currentTimeMillis = System.currentTimeMillis();
        //遍历
        for (Object key : map.keySet())
        {
            Object value = map.get(key);
            long parseLong = Long.parseLong(value.toString());
            if (currentTimeMillis - parseLong < (1000 * 60 * 5))
            {
                //删除redis中缓存的可用通道，因为通道优先级发生变化，redis中缓存的可用通道需要重新加载
                redisTemplate.delete("listForConnect");
                //说明当前这个实例状态正常
                ServerTopic serverTopic = ServerTopic.builder().option(ServerTopic.INIT_CONNECT).value(key.toString()).build();
                //发送消息
                redisTemplate.convertAndSend("TOPIC_HIGH_SERVER", serverTopic.toString());
                return;
            }
        }
    }
}
