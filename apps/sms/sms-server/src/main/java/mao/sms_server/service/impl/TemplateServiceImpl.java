package mao.sms_server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_dao.mapper.ConfigTemplateMapper;
import mao.sms_dao.mapper.TemplateMapper;
import mao.sms_entity.entity.ConfigSignatureEntity;
import mao.sms_entity.entity.ConfigTemplateEntity;
import mao.sms_entity.entity.SignatureEntity;
import mao.sms_entity.entity.TemplateEntity;
import mao.sms_server.service.TemplateService;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_redis_cache.utils.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.service.impl
 * Class(类名): TemplateServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/31
 * Time(创建时间)： 14:17
 * Version(版本): 1.0
 * Description(描述)： 模板
 */

@Slf4j
@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateMapper, TemplateEntity> implements TemplateService
{
    @Resource
    private ConfigTemplateMapper configTemplateMapper;

    @Resource
    private RedisUtils redisUtils;


    @Override
    public TemplateEntity getByCode(String template)
    {
        return redisUtils.query("sms:TemplateEntity:getByCode:", "sms:TemplateEntity:getByCode:lock:",
                template, TemplateEntity.class, new Function<String, TemplateEntity>()
                {
                    @Override
                    public TemplateEntity apply(String s)
                    {
                        return getOne(Wraps.<TemplateEntity>lbQ().eq(TemplateEntity::getCode, template));
                    }
                }, 60L, TimeUnit.SECONDS, 30);
    }

    @Override
    public String getConfigCodeByCode(String id, String template)
    {
        String redisId = template + "_" + id + "_code";
        String result = redisUtils.query("sms:String:getConfigCodeByCode2:", "sms:String:getConfigCodeByCode2:lock",
                redisId, String.class, new Function<String, String>()
                {
                    @Override
                    public String apply(String s)
                    {
                        TemplateEntity signatureEntity = baseMapper.selectOne(Wraps.<TemplateEntity>lbQ()
                                .eq(TemplateEntity::getCode, template));

                        if (signatureEntity == null)
                        {
                            return "";
                        }
                        ConfigTemplateEntity configSignatureEntity = configTemplateMapper.selectOne(Wraps.<ConfigTemplateEntity>lbQ()
                                .eq(ConfigTemplateEntity::getConfigId, id)
                                .eq(ConfigTemplateEntity::getTemplateId, signatureEntity.getId()));

                        return configSignatureEntity != null ? configSignatureEntity.getConfigTemplateCode() : "";
                    }
                }, 60L, TimeUnit.SECONDS, 30);
        if (result == null)
        {
            return "";
        }
        return result;
    }
}
