package mao.sms_server.job;

import lombok.extern.slf4j.Slf4j;
import mao.sms_dao.mapper.TimingPushMapper;
import mao.sms_entity.entity.TimingPushEntity;
import mao.sms_server.factory.SmsFactory;
import mao.tools_databases.mybatis.conditions.Wraps;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.job
 * Class(类名): SendTimingSmsImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/3
 * Time(创建时间)： 14:16
 * Version(版本): 1.0
 * Description(描述)： 定时短信业务处理器
 */

@Slf4j
@Component
public class SendTimingSmsImpl implements SendTimingSms
{
    @Resource
    private TimingPushMapper timingPushMapper;

    @Resource
    private SmsFactory smsFactory;


    @Async
    @Override
    public void execute(String timing) throws InterruptedException
    {
        //查询数据库获取本次需要发送的定时短信
        List<TimingPushEntity> timingPushEntityList = timingPushMapper.selectList(Wraps.<TimingPushEntity>lbQ()
                //设置查询条件，状态为0，表示未处理
                .eq(TimingPushEntity::getStatus, 0)
                //设置查询条件，发送时间等值查询
                .eq(TimingPushEntity::getTiming, timing)
                //设置排序条件
                .orderByAsc(TimingPushEntity::getCreateTime));

        if (timingPushEntityList != null && timingPushEntityList.size() > 0)
        {
            log.info("本次定时任务需要发送的定时短信条数为：{}", timingPushEntityList.size());
            timingPushEntityList.forEach(timingPushEntity ->
            {
                //2、调用短信工厂发送短信
                smsFactory.send(timingPushEntity.getRequest());

                //3、更新短信发送状态为“已处理”
                timingPushEntity.setStatus(1);
                timingPushMapper.updateById(timingPushEntity);
            });
        }
    }
}
