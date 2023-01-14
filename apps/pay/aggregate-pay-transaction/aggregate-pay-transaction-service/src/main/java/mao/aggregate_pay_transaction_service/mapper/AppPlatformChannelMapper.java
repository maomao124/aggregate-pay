package mao.aggregate_pay_transaction_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.aggregate_pay_transaction_service.entity.AppPlatformChannel;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.mapper
 * Interface(接口名): AppPlatformChannelMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 21:58
 * Version(版本): 1.0
 * Description(描述)： 应用选择了平台中的哪些支付渠道
 */

@Mapper
public interface AppPlatformChannelMapper extends BaseMapper<AppPlatformChannel>
{

}
