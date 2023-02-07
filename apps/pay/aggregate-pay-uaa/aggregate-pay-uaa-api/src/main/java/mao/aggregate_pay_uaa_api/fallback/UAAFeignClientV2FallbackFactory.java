package mao.aggregate_pay_uaa_api.fallback;


import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_uaa_api.feign.UAAFeignClientV2;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_api.fallback
 * Class(类名): UAAFeignClientV2FallbackFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/7
 * Time(创建时间)： 14:18
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class UAAFeignClientV2FallbackFactory implements FallbackFactory<UAAFeignClientV2>
{

    @Override
    public UAAFeignClientV2 create(Throwable throwable)
    {
        return new UAAFeignClientV2()
        {
            @Override
            public R<Map<String, ?>> checkToken(String value)
            {
                log.error("认证和授权服务不可用或者服务异常", throwable);
                throw BizException.wrap("认证和授权服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> createClientDetails(Map<String, String> map)
            {
                log.error("认证和授权服务不可用或者服务异常", throwable);
                throw BizException.wrap("认证和授权服务不可用或者服务异常");
            }

            @Override
            public R<Map<String, String>> getClientDetailsByClientId(String appId)
            {
                log.error("认证和授权服务不可用或者服务异常", throwable);
                throw BizException.wrap("认证和授权服务不可用或者服务异常");
            }
        };
    }
}
