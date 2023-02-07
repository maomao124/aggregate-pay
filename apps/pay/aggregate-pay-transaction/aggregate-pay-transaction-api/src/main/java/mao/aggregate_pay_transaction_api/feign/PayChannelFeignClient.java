package mao.aggregate_pay_transaction_api.feign;

import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_transaction_api.dto.PayChannelDTO;
import mao.aggregate_pay_transaction_api.fallback.PayChannelFeignClientFallbackFactory;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_api.feign
 * Interface(接口名): PayChannelFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/15
 * Time(创建时间)： 22:05
 * Version(版本): 1.0
 * Description(描述)： 支付聚道feign接口
 */

@FeignClient(value = "aggregate-pay-transaction-service", path = "/PayChannel", fallbackFactory = PayChannelFeignClientFallbackFactory.class)
public interface PayChannelFeignClient
{
    /**
     * 根据平台服务类型获取支付渠道列表
     *
     * @param platformChannelCode 平台渠道代码
     * @return {@link R}<{@link List}<{@link PayChannelDTO}>>
     */
    @GetMapping("/platformChannelCode/{platformChannelCode}")
    R<List<PayChannelDTO>> queryPayChannelByPlatformChannel(@PathVariable String platformChannelCode);
}
