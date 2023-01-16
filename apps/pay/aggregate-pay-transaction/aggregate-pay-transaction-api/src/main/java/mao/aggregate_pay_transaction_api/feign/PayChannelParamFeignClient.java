package mao.aggregate_pay_transaction_api.feign;

import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_transaction_api.dto.PayChannelParamDTO;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_api.feign
 * Interface(接口名): PayChannelParamFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/16
 * Time(创建时间)： 20:45
 * Version(版本): 1.0
 * Description(描述)： 原始的支付聚道参数feign接口
 */

@FeignClient(value = "aggregate-pay-transaction-service", path = "/PayChannelParam")
public interface PayChannelParamFeignClient
{
    /**
     * 保存支付通道参数
     *
     * @param payChannelParam 支付通道参数
     * @return {@link R}<{@link Boolean}>
     */
    @ApiOperation("保存支付通道参数")
    @PostMapping
    R<Boolean> savePayChannelParam(@RequestBody PayChannelParamDTO payChannelParam);


    /**
     * 获取指定应用指定服务类型下所包含的原始支付渠道参数列表
     *
     * @param appId           应用id
     * @param platformChannel 服务类型
     * @return {@link List}<{@link PayChannelParamDTO}>
     */
    @GetMapping("/queryPayChannelParamByAppAndPlatform")
    R<List<PayChannelParamDTO>> queryPayChannelParamByAppAndPlatform(@RequestParam String appId,
                                                                     @RequestParam String platformChannel);


    /**
     * 获取指定应用指定服务类型下所包含的某个原始支付参数
     *
     * @param appId           应用id
     * @param platformChannel 服务类型
     * @param payChannel      支付渠道
     * @return {@link R}<{@link PayChannelParamDTO}>
     */
    @GetMapping("/queryParamByAppPlatformAndPayChannel")
    R<PayChannelParamDTO> queryParamByAppPlatformAndPayChannel(@RequestParam String appId,
                                                               @RequestParam String platformChannel,
                                                               @RequestParam String payChannel);
}
