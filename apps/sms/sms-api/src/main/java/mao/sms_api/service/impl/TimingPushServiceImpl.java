package mao.sms_api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_api.service.TimingPushService;
import mao.sms_dao.mapper.TimingPushMapper;
import mao.sms_entity.entity.TimingPushEntity;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.service.impl
 * Class(类名): TimingPushServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 20:37
 * Version(版本): 1.0
 * Description(描述)： 定时发送
 */

@Slf4j
@Service
public class TimingPushServiceImpl extends ServiceImpl<TimingPushMapper, TimingPushEntity> implements TimingPushService
{

}
