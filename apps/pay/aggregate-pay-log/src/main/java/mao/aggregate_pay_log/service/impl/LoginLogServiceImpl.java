package mao.aggregate_pay_log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mao.aggregate_pay_entity.entity.LoginLog;
import mao.aggregate_pay_log.mapper.LoginLogMapper;
import mao.aggregate_pay_log.service.LoginLogService;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_log.service.impl
 * Class(类名): LoginLogServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/24
 * Time(创建时间)： 15:25
 * Version(版本): 1.0
 * Description(描述)： 登录日志服务实现类
 */

@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService
{

}
