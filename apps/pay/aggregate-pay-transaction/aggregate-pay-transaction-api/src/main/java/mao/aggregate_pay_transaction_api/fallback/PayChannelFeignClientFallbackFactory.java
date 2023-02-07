package mao.aggregate_pay_transaction_api.fallback;

import feign.hystrix.FallbackFactory;
import mao.aggregate_pay_transaction_api.dto.PayChannelDTO;
import mao.aggregate_pay_transaction_api.feign.PayChannelFeignClient;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_api.fallback
 * Class(类名): PayChannelFeignClientFallbackFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/7
 * Time(创建时间)： 14:05
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class PayChannelFeignClientFallbackFactory implements FallbackFactory<PayChannelFeignClient>
{

    @Override
    public PayChannelFeignClient create(Throwable throwable)
    {
        return new PayChannelFeignClient()
        {
            @Override
            public R<List<PayChannelDTO>> queryPayChannelByPlatformChannel(String platformChannelCode)
            {
                throw BizException.wrap("交易服务不可用或者服务异常");
            }
        };
    }
}
