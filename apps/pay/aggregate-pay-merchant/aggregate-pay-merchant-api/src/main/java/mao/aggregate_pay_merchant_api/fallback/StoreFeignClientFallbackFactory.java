package mao.aggregate_pay_merchant_api.fallback;

import feign.hystrix.FallbackFactory;
import mao.aggregate_pay_merchant_api.feign.StoreFeignClient;
import mao.tools_core.exception.BizException;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.fallback
 * Class(类名): StoreFeignClientFallbackFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/6
 * Time(创建时间)： 22:47
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class StoreFeignClientFallbackFactory implements FallbackFactory<StoreFeignClient>
{

    @Override
    public StoreFeignClient create(Throwable throwable)
    {
        throw BizException.wrap("商户服务不可用或者服务异常");
    }
}
