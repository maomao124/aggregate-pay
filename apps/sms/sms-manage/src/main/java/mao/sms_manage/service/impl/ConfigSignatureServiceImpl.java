package mao.sms_manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_entity.dto.ConfigDTO;
import mao.sms_entity.entity.ConfigSignatureEntity;
import mao.sms_dao.mapper.ConfigSignatureMapper;
import mao.sms_manage.service.ConfigSignatureService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service.impl
 * Class(类名): ConfigSignatureServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/20
 * Time(创建时间)： 21:00
 * Version(版本): 1.0
 * Description(描述)： 配置 签名
 */

@Slf4j
@Service
public class ConfigSignatureServiceImpl extends ServiceImpl<ConfigSignatureMapper, ConfigSignatureEntity> implements ConfigSignatureService
{

    @Override
    public void merge(ConfigDTO entity)
    {
        //判断签名id集合是否为空
        if (!CollectionUtils.isEmpty(entity.getSignatureIds()))
        {
            //空
            LambdaQueryWrapper<ConfigSignatureEntity> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ConfigSignatureEntity::getConfigId, entity.getId());
            // 数据库中的关联项
            List<ConfigSignatureEntity> dbList = this.list(wrapper);
            List<String> dbSignatureIds = dbList.stream().map(ConfigSignatureEntity::getSignatureId).collect(Collectors.toList());
            // 删除
            List<String> deleteIds = dbSignatureIds.stream().filter(item -> !entity.getSignatureIds().contains(item)).collect(Collectors.toList());
            // 新增
            List<String> addIds = entity.getSignatureIds().stream().filter(item -> !dbSignatureIds.contains(item)).collect(Collectors.toList());

            if (!CollectionUtils.isEmpty(deleteIds))
            {
                wrapper.in(ConfigSignatureEntity::getSignatureId, deleteIds);
                this.remove(wrapper);
                log.info("删除成功 config:{} deleteIds:{}", entity.getId(), deleteIds);
            }
            if (!CollectionUtils.isEmpty(addIds))
            {
                List<ConfigSignatureEntity> configSignatureEntities = addIds.stream().map(item ->
                {
                    ConfigSignatureEntity configSignatureEntity = new ConfigSignatureEntity();
                    configSignatureEntity.setConfigId(entity.getId());
                    configSignatureEntity.setSignatureId(item);
                    return configSignatureEntity;
                }).collect(Collectors.toList());
                this.saveBatch(configSignatureEntities);
                log.info("新增成功 config:{} addIds:{}", entity.getId(), addIds);
            }
        }
    }
}
