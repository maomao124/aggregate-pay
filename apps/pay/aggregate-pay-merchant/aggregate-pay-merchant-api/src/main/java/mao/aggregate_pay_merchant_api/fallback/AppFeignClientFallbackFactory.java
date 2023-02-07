package mao.aggregate_pay_merchant_api.fallback;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_merchant_api.dto.AppDTO;
import mao.aggregate_pay_merchant_api.feign.AppFeignClient;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.fallback
 * Class(类名): AppFeignClientFallbackFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/6
 * Time(创建时间)： 22:33
 * Version(版本): 1.0
 * Description(描述)： 降级
 */

@Slf4j
public class AppFeignClientFallbackFactory implements FallbackFactory<AppFeignClient>
{

    @Override
    public AppFeignClient create(Throwable throwable)
    {
        return new AppFeignClient()
        {
            @Override
            public R<AppDTO> createApp(Long merchantId, AppDTO app)
            {
                log.error("商户服务不可用或者服务异常", throwable);
                throw BizException.wrap("商户服务不可用或者服务异常");
            }

            @Override
            public R<List<AppDTO>> queryAppByMerchantId(Long merchantId)
            {
                log.error("商户服务不可用或者服务异常", throwable);
                throw BizException.wrap("商户服务不可用或者服务异常");
            }

            @Override
            public R<AppDTO> getAppById(String id)
            {
                throw BizException.wrap("商户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> queryAppInMerchant(String appId, Long merchantId)
            {
                log.error("商户服务不可用或者服务异常", throwable);
                throw BizException.wrap("商户服务不可用或者服务异常");
            }
        };
    }
}
