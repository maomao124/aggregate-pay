package mao.sms_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mao.sms_api.service.PlatformService;
import mao.sms_dao.mapper.PlatformMapper;
import mao.sms_entity.entity.PlatformEntity;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_j2cache.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.service.impl
 * Class(类名): PlatformServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 20:43
 * Version(版本): 1.0
 * Description(描述)： 平台
 */

public class PlatformServiceImpl extends ServiceImpl<PlatformMapper, PlatformEntity> implements PlatformService
{
    @Resource
    private RedisUtils redisUtils;

    @Override
    public PlatformEntity getByAccessKeyId(String accessKeyId)
    {
        return redisUtils.query("sms:getByAccessKeyId:", "sms:getByAccessKeyId:lock:",
                accessKeyId, PlatformEntity.class, new Function<String, PlatformEntity>()
        {
            @Override
            public PlatformEntity apply(String s)
            {
                return baseMapper.selectOne(Wraps.<PlatformEntity>lbQ()
                        .eq(PlatformEntity::getAccessKeyId, accessKeyId));
            }
        }, 120L, TimeUnit.SECONDS, 30);
    }
}
