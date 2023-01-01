package mao.sms_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_dao.mapper.ConfigMapper;
import mao.sms_dao.mapper.SendLogMapper;
import mao.sms_entity.dto.ConfigDTO;
import mao.sms_entity.entity.ConfigEntity;
import mao.sms_entity.entity.SendLogEntity;
import mao.sms_server.service.ConfigService;
import mao.tools_core.utils.DateUtils;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_redis_cache.entity.RedisData;
import mao.tools_redis_cache.utils.RedisUtils;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.service.impl
 * Class(类名): ConfigServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/31
 * Time(创建时间)： 21:55
 * Version(版本): 1.0
 * Description(描述)： 通道配置
 */

@Slf4j
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, ConfigEntity> implements ConfigService
{

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Resource
    private RedisUtils redisUtils;

    @Resource
    private SendLogMapper sendLogMapper;

    @Resource
    private DozerUtils dozerUtils;

    @Override
    public List<ConfigEntity> listForConnect()
    {
        //获取Redis的通道列表
        RedisData data = redisUtils.query("sms:List_ConfigEntity:listForConnect:", "sms:List_ConfigEntity:listForConnect:lock",
                "-1", RedisData.class, s ->
                {
                    LambdaQueryWrapper<ConfigEntity> wrapper = new LambdaQueryWrapper<>();
                    wrapper.eq(ConfigEntity::getChannelType, 1);
                    wrapper.eq(ConfigEntity::getIsActive, 1);
                    wrapper.eq(ConfigEntity::getIsEnable, 1);
                    wrapper.orderByAsc(ConfigEntity::getLevel);
                    List<ConfigEntity> configEntityList = list(wrapper);
                    RedisData redisData = new RedisData();
                    redisData.setData(configEntityList);
                    return redisData;
                }, 60L, TimeUnit.SECONDS, 30);
        return (List<ConfigEntity>) data.getData();
    }

    @Override
    public List<ConfigEntity> listForNewConnect()
    {
        //获取Redis中的可用通道
        List<ConfigEntity> configEntityList = this.listForConnect();
        //判断是否需要继续进行下去
        if (configEntityList.size() == 0)
        {
            log.debug("集合为空");
            return configEntityList;
        }
        //降级第一级别通道
        Iterator<ConfigEntity> configEntityIterator = configEntityList.iterator();
        ConfigEntity firstConfigEntity = null;
        if (configEntityIterator.hasNext())
        {
            firstConfigEntity = configEntityIterator.next();
            log.debug("当前第一级别通道:{}", firstConfigEntity);
        }
        //排除第一级别配置，查询可用通道配置
        List<ConfigEntity> list = baseMapper.selectList(Wraps.<ConfigEntity>lbQ()
                .ne(ConfigEntity::getId, firstConfigEntity.getId())
                .eq(ConfigEntity::getIsActive, 1)
                .orderByAsc(ConfigEntity::getLevel));
        log.debug("全部开启通道:{}", list);

        //获取当前时间前一个小时的时间
        List<ConfigDTO> configDTOS = new ArrayList<>();
        //获取当前时间
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, -1);
        Date finalDate = calendar.getTime();

        //通道是否发送过短信标识
        AtomicBoolean finded = new AtomicBoolean(false);

        //记录每个可用通道最近一个小时内的发送成功的次数
        list.forEach(configEntity ->
        {
            ConfigDTO configDTO = new ConfigDTO();
            dozerUtils.map(configEntity, configDTO);
            List<SendLogEntity> logList = sendLogMapper.selectList(Wraps.<SendLogEntity>lbQ()
                    .eq(SendLogEntity::getConfigId, configEntity.getId())
                    .ge(SendLogEntity::getCreateTime, DateUtils.formatAsDateTime(finalDate))
                    .orderByDesc(SendLogEntity::getCreateTime));
            if (!CollectionUtils.isEmpty(logList))
            {
                if (logList.get(0).getStatus() == 1)
                {
                    configDTO.setLastSuccessNumInAnHour(logList.size());
                    finded.set(true);
                }
            }
            configDTOS.add(configDTO);
        });
        //根据最近一小时内发送成功进行通道排序
        configDTOS.sort(Comparator.comparing(ConfigDTO::getLastSuccessNumInAnHour,
                Collections.reverseOrder()).thenComparing(ConfigDTO::getLevel, Collections.reverseOrder()));
        log.debug("第一轮排序后:{}", configDTOS);

        //如果最近一个小时内没有发送成功的通道，执行以下排序方案:
        //查找最后一次发送成功的通道，进行排序
        if (!finded.get())
        {
            configDTOS.forEach(configDTO ->
            {
                SendLogEntity logEntity = sendLogMapper.selectOne(Wraps.<SendLogEntity>lbQ()
                        .eq(SendLogEntity::getConfigId, configDTO.getId())
                        .orderByDesc(SendLogEntity::getCreateTime)
                        .last(" LIMIT 1"));
                if (logEntity != null)
                {
                    configDTO.setLastSuccessNum(1);
                }
            });
            //次数相同，按级别排序
            configDTOS.sort(Comparator.comparing(ConfigDTO::getLastSuccessNum,
                    Collections.reverseOrder()).thenComparing(ConfigDTO::getLevel));
            log.info("第二轮排序后:{}", configDTOS);
        }

        int level = 1;
        list.clear();
        for (ConfigDTO configDTO : configDTOS)
        {
            ConfigEntity configEntity = dozerUtils.map(configDTO, ConfigEntity.class);
            configEntity.setLevel(level++);
            list.add(configEntity);
        }

        // 查询不可用通道
        List<ConfigEntity> unActiveList = baseMapper.selectList(Wraps.<ConfigEntity>lbQ()
                .ne(ConfigEntity::getId, firstConfigEntity.getId())
                .eq(ConfigEntity::getIsActive, 0)
                .orderByAsc(ConfigEntity::getLevel));

        for (ConfigEntity configEntity : unActiveList)
        {
            configEntity.setLevel(level++);
            list.add(configEntity);
        }

        // 原第一通道置位不可用 并将排序推后
        firstConfigEntity.setLevel(99);
        firstConfigEntity.setIsEnable(0);
        list.add(firstConfigEntity);

        log.info("listForNewConnect value: {}", list);
        return list;
    }

    @Override
    public boolean updateBatchById(Collection<ConfigEntity> entityList)
    {
        boolean result = super.updateBatchById(entityList);
        if (result)
        {
            stringRedisTemplate.delete("sms:List_ConfigEntity:listForConnect:-1");
        }
        return result;
    }
}
