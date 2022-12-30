package mao.sms_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_api.service.SignatureService;
import mao.sms_dao.mapper.SignatureMapper;
import mao.sms_entity.entity.SignatureEntity;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_redis_cache.utils.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.service.impl
 * Class(类名): SignatureServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/25
 * Time(创建时间)： 14:32
 * Version(版本): 1.0
 * Description(描述)： 短信签名
 */

@Slf4j
@Service
public class SignatureServiceImpl extends ServiceImpl<SignatureMapper, SignatureEntity> implements SignatureService
{
    @Resource
    private RedisUtils redisUtils;

    @Override
    public SignatureEntity getByCode(String signature)
    {
        return redisUtils.query("sms:SignatureEntity:getByCode:", "sms:SignatureEntity:getByCode:lock:",
                signature, SignatureEntity.class, new Function<String, SignatureEntity>()
                {
                    @Override
                    public SignatureEntity apply(String s)
                    {
                        return baseMapper.selectOne(Wraps.<SignatureEntity>lbQ().eq(SignatureEntity::getCode, signature));
                    }
                }, 60L, TimeUnit.SECONDS, 30);
    }

}
