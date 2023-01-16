package mao.aggregate_pay_transaction_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_transaction_api.dto.PayChannelParamDTO;
import mao.aggregate_pay_transaction_service.service.PayChannelParamService;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.controller
 * Class(类名): PayChannelParamController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/16
 * Time(创建时间)： 20:32
 * Version(版本): 1.0
 * Description(描述)： 原始的支付聚道参数Controller
 */

@Slf4j
@RestController
@Api(value = "支付聚道参数", tags = "支付聚道参数")
@RequestMapping("/PayChannelParam")
public class PayChannelParamController
{
    @Resource
    private PayChannelParamService payChannelParamService;

    /**
     * 保存支付通道参数
     *
     * @param payChannelParam 支付通道参数
     * @return {@link R}<{@link Boolean}>
     */
    @ApiOperation("保存支付通道参数")
    @PostMapping
    public R<Boolean> savePayChannelParam(@RequestBody PayChannelParamDTO payChannelParam)
    {
        return payChannelParamService.savePayChannelParam(payChannelParam);
    }


    /**
     * 获取指定应用指定服务类型下所包含的原始支付渠道参数列表
     *
     * @param appId           应用id
     * @param platformChannel 服务类型
     * @return {@link List}<{@link PayChannelParamDTO}>
     */
    @ApiOperation("获取指定应用指定服务类型下所包含的原始支付渠道参数列表")
    @GetMapping("/queryPayChannelParamByAppAndPlatform")
    public R<List<PayChannelParamDTO>> queryPayChannelParamByAppAndPlatform(@RequestParam String appId,
                                                                            @RequestParam String platformChannel)
    {
        return payChannelParamService.queryPayChannelParamByAppAndPlatform(appId, platformChannel);
    }


    /**
     * 获取指定应用指定服务类型下所包含的某个原始支付参数
     *
     * @param appId           应用id
     * @param platformChannel 服务类型
     * @param payChannel      支付渠道
     * @return {@link R}<{@link PayChannelParamDTO}>
     */
    @ApiOperation("获取指定应用指定服务类型下所包含的某个原始支付参数")
    @GetMapping("/queryParamByAppPlatformAndPayChannel")
    public R<PayChannelParamDTO> queryParamByAppPlatformAndPayChannel(@RequestParam String appId,
                                                                      @RequestParam String platformChannel,
                                                                      @RequestParam String payChannel)
    {
        return payChannelParamService.queryParamByAppPlatformAndPayChannel(appId, platformChannel, payChannel);
    }
}
