package mao.aggregate_pay_log.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.aggregate_pay_entity.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_log.mapper
 * Interface(接口名): LoginLogMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/24
 * Time(创建时间)： 15:24
 * Version(版本): 1.0
 * Description(描述)： 登录日志
 */

@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog>
{

}
