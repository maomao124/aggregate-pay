package mao.aggregate_pay_transaction_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_transaction_api.dto.PayChannelDTO;
import mao.aggregate_pay_transaction_service.service.PayChannelService;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.controller
 * Class(类名): PayChannelController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/15
 * Time(创建时间)： 21:58
 * Version(版本): 1.0
 * Description(描述)： 支付聚道controller
 */

@Api(value = "支付聚道", tags = "支付聚道")
@RestController
@RequestMapping("/PayChannel")
public class PayChannelController
{

    @Resource
    private PayChannelService payChannelService;

    /**
     * 根据平台服务类型获取支付渠道列表
     *
     * @param platformChannelCode 平台渠道代码
     * @return {@link R}<{@link List}<{@link PayChannelDTO}>>
     */
    @ApiOperation("根据平台服务类型获取支付渠道列表")
    @GetMapping("/platformChannelCode/{platformChannelCode}")
    public R<List<PayChannelDTO>> queryPayChannelByPlatformChannel(@PathVariable String platformChannelCode)
    {
        List<PayChannelDTO> payChannelDTOS = payChannelService.queryPayChannelByPlatformChannel(platformChannelCode);
        return R.success(payChannelDTOS);
    }
}
