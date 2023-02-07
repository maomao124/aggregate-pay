package mao.aggregate_pay_transaction_api.fallback;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_transaction_api.dto.PlatformChannelDTO;
import mao.aggregate_pay_transaction_api.feign.PlatformChannelFeignClient;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_api.fallback
 * Class(类名): PlatformChannelFeignClientFallbackFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/7
 * Time(创建时间)： 14:08
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class PlatformChannelFeignClientFallbackFactory implements FallbackFactory<PlatformChannelFeignClient>
{

    @Override
    public PlatformChannelFeignClient create(Throwable throwable)
    {
        return new PlatformChannelFeignClient()
        {
            @Override
            public R<List<PlatformChannelDTO>> queryAll()
            {
                log.error("交易服务不可用或者服务异常", throwable);
                throw BizException.wrap("交易服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> bindPlatformChannelForApp(String appId, String platformChannelCodes)
            {
                log.error("交易服务不可用或者服务异常", throwable);
                throw BizException.wrap("交易服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> queryAppBindPlatformChannel(String appId, String platformChannel)
            {
                log.error("交易服务不可用或者服务异常", throwable);
                throw BizException.wrap("交易服务不可用或者服务异常");
            }
        };
    }
}
