package mao.aggregate_pay_transaction_api.feign;

import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_transaction_api.dto.PlatformChannelDTO;
import mao.aggregate_pay_transaction_api.fallback.PayChannelParamFeignClientFallbackFactory;
import mao.aggregate_pay_transaction_api.fallback.PlatformChannelFeignClientFallbackFactory;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_api.feign
 * Interface(接口名): PlatformChannelFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 23:10
 * Version(版本): 1.0
 * Description(描述)： 服务类型 FeignClient
 */

@FeignClient(value = "aggregate-pay-transaction-service", path = "/PlatformChannel",fallbackFactory = PlatformChannelFeignClientFallbackFactory.class)
public interface PlatformChannelFeignClient
{
    /**
     * 获取平台所有服务类型
     *
     * @return {@link R}<{@link List}<{@link PlatformChannelDTO}>>
     */
    @GetMapping
    R<List<PlatformChannelDTO>> queryAll();


    /**
     * 为app绑定平台服务类型
     *
     * @param appId                应用id
     * @param platformChannelCodes 平台服务类型
     */
    @PutMapping("/bind")
    R<Boolean> bindPlatformChannelForApp(@RequestParam String appId, @RequestParam String platformChannelCodes);


    /**
     * 查询应用是否已经绑定了某个服务类型
     *
     * @param appId           应用程序id
     * @param platformChannel 平台通道
     * @return boolean
     */
    @GetMapping("/bind")
    R<Boolean> queryAppBindPlatformChannel(@RequestParam String appId, @RequestParam String platformChannel);
}
