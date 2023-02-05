package mao.aggregate_pay_payment_agent_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_payment_agent_api.dto.*;
import mao.aggregate_pay_payment_agent_service.service.PayChannelAgentService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_service.controller
 * Class(类名): PayChannelAgentController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 20:33
 * Version(版本): 1.0
 * Description(描述)： 支付代理服务
 */

@Slf4j
@RestController
@RequestMapping("/pay/agent")
@Api(value = "支付代理", tags = "支付代理")
public class PayChannelAgentController extends BaseController
{

    @Resource
    private PayChannelAgentService payChannelAgentService;

    /**
     * 调用支付宝手机WAP下单接口
     *
     * @param payOrderByAliWAPBody 请求体内容
     * @return {@link R}<{@link PaymentResponseDTO}<{@link String}>>
     */
    @PostMapping("/createPayOrderByAliWAP")
    @ApiOperation(value = "调用支付宝手机WAP下单接口", notes = "调用支付宝手机WAP下单接口")
    public R<PaymentResponseDTO<String>> createPayOrderByAliWAP(@RequestBody PayOrderByAliWAPBody payOrderByAliWAPBody)
    {
        PaymentResponseDTO<String> payOrderByAliWAP =
                payChannelAgentService.createPayOrderByAliWAP(
                        payOrderByAliWAPBody.getAliConfigParam(),
                        payOrderByAliWAPBody.getAlipayBean());
        return success(payOrderByAliWAP);
    }


    /**
     * 微信jsapi下单接口请求
     *
     * @param payOrderWeiXinJSAPIBody 请求体
     * @return {@link R}<{@link Map}<{@link String}, {@link String}>>
     */
    @PostMapping("/createPayOrderByWeChatJSAPI")
    @ApiOperation(value = "微信jsapi下单接口请求", notes = "微信jsapi下单接口请求")
    public R<Map<String, String>> createPayOrderByWeChatJSAPI(@RequestBody PayOrderWeiXinJSAPIBody payOrderWeiXinJSAPIBody)
    {
        Map<String, String> payOrderByWeChatJSAPI =
                payChannelAgentService.createPayOrderByWeChatJSAPI(payOrderWeiXinJSAPIBody.getWxConfigParam(),
                        payOrderWeiXinJSAPIBody.getWeChatBean());
        return success(payOrderByWeChatJSAPI);
    }
}
