package mao.aggregate_pay_merchant_application.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_merchant_application.handler.AssertResult;
import mao.aggregate_pay_transaction_api.dto.PayChannelDTO;
import mao.aggregate_pay_transaction_api.dto.PayChannelParamDTO;
import mao.aggregate_pay_transaction_api.dto.PlatformChannelDTO;
import mao.aggregate_pay_transaction_api.feign.PayChannelFeignClient;
import mao.aggregate_pay_transaction_api.feign.PayChannelParamFeignClient;
import mao.aggregate_pay_transaction_api.feign.PlatformChannelFeignClient;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.tools_log.annotation.SysLog;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.controller
 * Class(类名): PlatformParamController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 23:21
 * Version(版本): 1.0
 * Description(描述)： 商户平台‐渠道和支付参数
 */

@Slf4j
@RestController
@Api(value = "商户平台‐渠道和支付参数相关", tags = "商户平台‐渠道和支付参数")
public class PlatformParamController
{
    @Resource
    private PlatformChannelFeignClient platformChannelFeignClient;

    @Resource
    private PayChannelFeignClient payChannelFeignClient;

    @Resource
    private PayChannelParamFeignClient payChannelParamFeignClient;


    /**
     * 获取平台所有服务类型
     *
     * @return {@link List}<{@link PlatformChannelDTO}>
     */
    @ApiOperation("获取平台服务类型")
    @GetMapping(value = "/my/platform‐channels")
    public List<PlatformChannelDTO> queryPlatformChannel()
    {
        //远程调用
        R<List<PlatformChannelDTO>> r = platformChannelFeignClient.queryAll();
        //断言结果
        AssertResult.handler(r);
        //返回
        return r.getData();
    }

    /**
     * 根据平台服务类型获取支付渠道列表
     *
     * @param platformChannelCode 服务类型编码
     * @return {@link List}<{@link PayChannelDTO}>
     */
    @ApiOperation("根据平台服务类型获取支付渠道列表")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "platformChannelCode", value = "服务类型编码", required =
                            true, dataType = "String", paramType = "path")
            })
    @GetMapping(value = "/my/pay‐channels/platform‐channel/{platformChannelCode}")
    public List<PayChannelDTO> queryPayChannelByPlatformChannel(@PathVariable String platformChannelCode)
    {
        //远程调用
        R<List<PayChannelDTO>> r = payChannelFeignClient.queryPayChannelByPlatformChannel(platformChannelCode);
        //断言
        AssertResult.handler(r);
        //返回
        return r.getData();
    }


    /**
     * 商户配置支付渠道参数
     *
     * @param payChannelParam 支付通道参数
     */
    @SysLog(value = "商户配置支付渠道参数", recordResponseParam = false)
    @ApiOperation("商户配置支付渠道参数")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "payChannelParam", value = "商户配置支付渠道参数", required =
                            true, dataType = "PayChannelParamDTO", paramType = "body")
            })
    @RequestMapping(value = "/my/pay‐channel‐params", method = {RequestMethod.POST, RequestMethod.PUT})
    public void createPayChannelParam(@RequestBody PayChannelParamDTO payChannelParam)
    {
        //设置商户id，商户id不能从请求里拿
        //todo
        Long merchantId = 12243556L;
        payChannelParam.setMerchantId(merchantId);
        //校验
        if (StringUtils.isBlank(payChannelParam.getAppId()) ||
                StringUtils.isBlank(payChannelParam.getPlatformChannelCode()) ||
                StringUtils.isBlank(payChannelParam.getPayChannel()))
        {
            throw new BizException("传入对象为空或者缺少必要的参数");
        }
        //远程调用
        R<Boolean> r = payChannelParamFeignClient.savePayChannelParam(payChannelParam);
        //断言结果
        AssertResult.handler(r);
    }


    /**
     * 获取指定应用指定服务类型下所包含的原始支付渠道参数列表
     *
     * @param appId           应用id
     * @param platformChannel 平台支付渠道编码
     * @return {@link List}<{@link PayChannelParamDTO}>
     */
    @ApiOperation("获取指定应用指定服务类型下所包含的原始支付渠道参数列表")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "appId", value = "应用id", required = true,
                            dataType = "String", paramType = "path"),
                    @ApiImplicitParam(name = "platformChannel", value = "服务类型",
                            required = true, dataType = "String", paramType = "path")})
    @GetMapping(value = "/my/pay‐channel‐params/apps/{appId}/platform‐ channels/{platformChannel}")
    public List<PayChannelParamDTO> queryPayChannelParam(@PathVariable String appId,
                                                         @PathVariable String platformChannel)
    {
        //查询
        R<List<PayChannelParamDTO>> r = payChannelParamFeignClient.queryPayChannelParamByAppAndPlatform(appId, platformChannel);
        //断言结果
        AssertResult.handler(r);
        //返回
        return r.getData();
    }


    /**
     * 获取指定应用指定服务类型下所包含的某个原始支付参数
     *
     * @param appId           应用id
     * @param platformChannel 平台支付渠道编码
     * @param payChannel      实际支付渠道编码
     * @return {@link PayChannelParamDTO}
     */
    @ApiOperation("获取指定应用指定服务类型下所包含的某个原始支付参数")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "appId", value = "应用id",
                            required = true, dataType = "String", paramType = "path"),
                    @ApiImplicitParam(name = "platformChannel", value = "平台支付渠道编码",
                            required = true, dataType = "String", paramType = "path"),
                    @ApiImplicitParam(name = "payChannel", value = "实际支付渠道编码",
                            required = true, dataType = "String", paramType = "path")})
    @GetMapping(value = "/my/pay‐channel‐params/apps/{appId}/platform‐ channels/{platformChannel}/pay‐channels/{payChannel}")
    public PayChannelParamDTO queryPayChannelParam(@PathVariable String appId,
                                                   @PathVariable String platformChannel, @PathVariable String payChannel)
    {
        //查询
        R<PayChannelParamDTO> r = payChannelParamFeignClient.queryParamByAppPlatformAndPayChannel(appId, platformChannel, payChannel);
        //断言结果
        AssertResult.handler(r);
        //返回
        return r.getData();
    }


}
