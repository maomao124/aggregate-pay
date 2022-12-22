package mao.sms_manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_entity.dto.ConfigDTO;
import mao.sms_entity.entity.ConfigTemplateEntity;
import mao.sms_dao.mapper.ConfigTemplateMapper;
import mao.sms_manage.service.ConfigTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service.impl
 * Class(类名): ConfigTemplateServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/21
 * Time(创建时间)： 20:35
 * Version(版本): 1.0
 * Description(描述)： 配置—模板
 */

@Slf4j
@Service
public class ConfigTemplateServiceImpl extends ServiceImpl<ConfigTemplateMapper, ConfigTemplateEntity> implements ConfigTemplateService
{
    @Override
    public void merge(ConfigDTO entity)
    {
        if (!CollectionUtils.isEmpty(entity.getTemplateIds()))
        {
            LambdaQueryWrapper<ConfigTemplateEntity> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ConfigTemplateEntity::getConfigId, entity.getId());

            // 数据库中的关联项
            List<ConfigTemplateEntity> dbList = this.list(wrapper);
            List<String> dbTemplateIds = dbList.stream().map(ConfigTemplateEntity::getTemplateId).collect(Collectors.toList());
            // 删除
            List<String> deleteIds = dbTemplateIds.stream().filter(item -> !entity.getTemplateIds().contains(item)).collect(Collectors.toList());
            // 新增
            List<String> addIds = entity.getTemplateIds().stream().filter(item -> !dbTemplateIds.contains(item)).collect(Collectors.toList());


            if (!CollectionUtils.isEmpty(deleteIds))
            {
                wrapper.in(ConfigTemplateEntity::getTemplateId, deleteIds);
                this.remove(wrapper);
                log.info("删除成功 config:{} deleteIds:{}", entity.getId(), deleteIds);
            }
            if (!CollectionUtils.isEmpty(addIds))
            {
                List<ConfigTemplateEntity> configTemplateEntities = addIds.stream().map(item ->
                {
                    ConfigTemplateEntity configTemplateEntity = new ConfigTemplateEntity();
                    configTemplateEntity.setConfigId(entity.getId());
                    configTemplateEntity.setTemplateId(item);
                    return configTemplateEntity;
                }).collect(Collectors.toList());
                this.saveBatch(configTemplateEntities);
                log.info("新增成功 config:{} addIds:{}", entity.getId(), addIds);
            }
        }
    }
}
