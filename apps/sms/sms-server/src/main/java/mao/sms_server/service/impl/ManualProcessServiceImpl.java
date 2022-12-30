package mao.sms_server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_dao.mapper.ManualProcessMapper;
import mao.sms_entity.entity.ManualProcessEntity;
import mao.sms_server.service.ManualProcessService;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.service.impl
 * Class(类名): ManualProcessServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/30
 * Time(创建时间)： 22:22
 * Version(版本): 1.0
 * Description(描述)： 人工处理任务
 */

@Slf4j
@Service
public class ManualProcessServiceImpl extends ServiceImpl<ManualProcessMapper, ManualProcessEntity> implements ManualProcessService
{

}
