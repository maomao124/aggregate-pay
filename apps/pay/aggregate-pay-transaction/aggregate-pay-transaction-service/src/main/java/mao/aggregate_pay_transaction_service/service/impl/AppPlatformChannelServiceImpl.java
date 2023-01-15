package mao.aggregate_pay_transaction_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_transaction_service.entity.AppPlatformChannel;
import mao.aggregate_pay_transaction_service.mapper.AppPlatformChannelMapper;
import mao.aggregate_pay_transaction_service.service.AppPlatformChannelService;
import mao.tools_databases.mybatis.conditions.Wraps;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service.impl
 * Class(类名): AppPlatformChannelServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/15
 * Time(创建时间)： 14:33
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class AppPlatformChannelServiceImpl extends ServiceImpl<AppPlatformChannelMapper, AppPlatformChannel> implements AppPlatformChannelService
{

    @Override
    public boolean queryAppBindPlatformChannel(String appId, String platformChannel)
    {
        //查询
        int count = this.count(Wraps.<AppPlatformChannel>lbQ().eq(AppPlatformChannel::getAppId, appId)
                .eq(AppPlatformChannel::getPlatformChannel, platformChannel));
        //判断并返回
        if (count <= 0)
        {
            return false;
        }
        return true;
    }
}
