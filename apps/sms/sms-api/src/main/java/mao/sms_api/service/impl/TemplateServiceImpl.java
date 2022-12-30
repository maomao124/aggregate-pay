package mao.sms_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_api.service.TemplateService;
import mao.sms_dao.mapper.TemplateMapper;
import mao.sms_entity.entity.TemplateEntity;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_redis_cache.utils.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.service.impl
 * Class(类名): TemplateServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/25
 * Time(创建时间)： 18:24
 * Version(版本): 1.0
 * Description(描述)： 短信模板
 */


@Slf4j
@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateMapper, TemplateEntity> implements TemplateService
{

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
                        return baseMapper.selectOne(Wraps.<TemplateEntity>lbQ().eq(TemplateEntity::getCode, template));
                    }
                }, 60L, TimeUnit.SECONDS, 30);
    }

}
