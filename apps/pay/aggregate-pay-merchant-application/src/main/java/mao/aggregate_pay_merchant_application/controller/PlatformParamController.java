package mao.aggregate_pay_merchant_application.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_merchant_application.handler.AssertResult;
import mao.aggregate_pay_transaction_api.dto.PlatformChannelDTO;
import mao.aggregate_pay_transaction_api.feign.PlatformChannelFeignClient;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
