package mao.sms_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_dao.mapper.ConfigSignatureMapper;
import mao.sms_dao.mapper.SignatureMapper;
import mao.sms_entity.entity.ConfigSignatureEntity;
import mao.sms_entity.entity.SignatureEntity;
import mao.sms_server.service.SignatureService;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_redis_cache.utils.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.service.impl
 * Class(类名): SignatureServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/31
 * Time(创建时间)： 13:57
 * Version(版本): 1.0
 * Description(描述)： 签名
 */

@Slf4j
@Service
public class SignatureServiceImpl extends ServiceImpl<SignatureMapper, SignatureEntity> implements SignatureService
{

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private ConfigSignatureMapper configSignatureMapper;


    @Override
    public SignatureEntity getByCode(String signature)
    {
        return redisUtils.query("sms:SignatureEntity:getByCode:", "sms:SignatureEntity:getByCode:lock:",
                signature, SignatureEntity.class, new Function<String, SignatureEntity>()
                {
                    @Override
                    public SignatureEntity apply(String s)
                    {
                        return getOne(Wraps.<SignatureEntity>lbQ().eq(SignatureEntity::getCode, signature));
                    }
                }, 60L, TimeUnit.SECONDS, 30);
    }

    @Override
    public String getConfigCodeByCode(String id, String signature)
    {
        String redisId = signature + "_" + id + "_code";
        return redisUtils.query("sms:String:getConfigCodeByCode:", "sms:String:getConfigCodeByCode:lock",
                redisId, String.class, new Function<String, String>()
                {
                    @Override
                    public String apply(String s)
                    {
                        SignatureEntity signatureEntity = baseMapper.selectOne(Wraps.<SignatureEntity>lbQ()
                                .eq(SignatureEntity::getCode, signature));

                        ConfigSignatureEntity configSignatureEntity = configSignatureMapper.selectOne(Wraps.<ConfigSignatureEntity>lbQ()
                                .eq(ConfigSignatureEntity::getConfigId, id)
                                .eq(ConfigSignatureEntity::getSignatureId, signatureEntity.getId()));

                        return configSignatureEntity != null ? configSignatureEntity.getConfigSignatureCode() : "";
                    }
                }, 60L, TimeUnit.SECONDS, 30);
    }
}
