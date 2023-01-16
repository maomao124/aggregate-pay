package mao.aggregate_pay_transaction_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_transaction_api.dto.PayChannelDTO;
import mao.aggregate_pay_transaction_api.dto.PlatformChannelDTO;
import mao.aggregate_pay_transaction_service.entity.PayChannel;
import mao.aggregate_pay_transaction_service.mapper.PayChannelMapper;
import mao.aggregate_pay_transaction_service.mapper.PlatformChannelMapper;
import mao.aggregate_pay_transaction_service.service.PayChannelService;
import mao.tools_core.base.R;
import mao.tools_redis_cache.entity.RedisData;
import mao.tools_redis_cache.utils.RedisUtils;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service.impl
 * Class(类名): PayChannelServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 22:37
 * Version(版本): 1.0
 * Description(描述)： 支付聚道服务实现类
 */

@Slf4j
@Service
public class PayChannelServiceImpl extends ServiceImpl<PayChannelMapper, PayChannel> implements PayChannelService
{
    @Resource
    private PlatformChannelMapper platformChannelMapper;

    @Resource
    private RedisUtils redisUtils;

    @Override
    public List<PayChannelDTO> queryPayChannelByPlatformChannel(String platformChannelCode)
    {
        RedisData redisData = redisUtils.query("pay:List_PayChannelDTO:queryPayChannelByPlatformChannel:",
                "pay:List_PayChannelDTO:queryPayChannelByPlatformChannel:lock:", platformChannelCode,
                RedisData.class, new Function<String, RedisData>()
                {
                    @Override
                    public RedisData apply(String s)
                    {
                        List<PayChannelDTO> payChannelDTOS = platformChannelMapper.selectPayChannelByPlatformChannel(platformChannelCode);
                        RedisData redisData = new RedisData();
                        redisData.setData(payChannelDTOS);
                        return redisData;
                    }
                },
                300L, TimeUnit.MINUTES, 60);
        return (List<PayChannelDTO>) redisData.getData();

    }
}
