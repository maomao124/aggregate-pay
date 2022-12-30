package mao.sms_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_dao.mapper.ReceiveLogMapper;
import mao.sms_dao.mapper.SendLogMapper;
import mao.sms_entity.entity.ReceiveLogEntity;
import mao.sms_entity.entity.SendLogEntity;
import mao.sms_server.service.SendLogService;
import mao.tools_databases.mybatis.conditions.Wraps;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.service.impl
 * Class(类名): SendLogServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/30
 * Time(创建时间)： 22:28
 * Version(版本): 1.0
 * Description(描述)： 日志
 */

@Slf4j
@Service
public class SendLogServiceImpl extends ServiceImpl<SendLogMapper, SendLogEntity> implements SendLogService
{
    @Resource
    private ReceiveLogMapper receiveLogMapper;

    @Override
    public boolean save(SendLogEntity entity)
    {
        ReceiveLogEntity receiveLogEntity = new ReceiveLogEntity();
        receiveLogEntity.setStatus(entity.getStatus());
        receiveLogMapper.update(receiveLogEntity, Wraps.<ReceiveLogEntity>lbQ()
                .eq(ReceiveLogEntity::getApiLogId, entity.getApiLogId()));
        return super.save(entity);
    }
}
