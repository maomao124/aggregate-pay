package mao.aggregate_pay_log.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.aggregate_pay_log.entity.OptLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_log.mapper
 * Interface(接口名): OptLogMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 14:17
 * Version(版本): 1.0
 * Description(描述)： 操作日志
 */

@Mapper
public interface OptLogMapper extends BaseMapper<OptLog>
{

}
