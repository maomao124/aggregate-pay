package mao.aggregate_pay_payment_agent_api.feign;

import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_payment_agent_api.dto.PayOrderByAliWAPBody;
import mao.aggregate_pay_payment_agent_api.dto.PayOrderWeiXinJSAPIBody;
import mao.aggregate_pay_payment_agent_api.dto.PaymentResponseDTO;
import mao.aggregate_pay_payment_agent_api.fallback.PayChannelAgentFeignClientFallbackFactory;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.feign
 * Interface(接口名): PayChannelAgentFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 20:44
 * Version(版本): 1.0
 * Description(描述)： 支付代理服务feign接口
 */

@FeignClient(value = "aggregate-pay-payment-agent-service", path = "/pay/agent", fallbackFactory = PayChannelAgentFeignClientFallbackFactory.class)
public interface PayChannelAgentFeignClient
{
    /**
     * 调用支付宝手机WAP下单接口
     *
     * @param payOrderByAliWAPBody 请求体内容
     * @return {@link R}<{@link PaymentResponseDTO}<{@link String}>>
     */
    @PostMapping("/createPayOrderByAliWAP")
    @ApiOperation(value = "调用支付宝手机WAP下单接口", tags = "调用支付宝手机WAP下单接口")
    R<PaymentResponseDTO<String>> createPayOrderByAliWAP(@RequestBody PayOrderByAliWAPBody payOrderByAliWAPBody);


    /**
     * 微信jsapi下单接口请求
     *
     * @param payOrderWeiXinJSAPIBody 请求体
     * @return {@link R}<{@link Map}<{@link String}, {@link String}>>
     */
    @PostMapping("/createPayOrderByWeChatJSAPI")
    @ApiOperation(value = "微信jsapi下单接口请求", notes = "微信jsapi下单接口请求")
    R<Map<String, String>> createPayOrderByWeChatJSAPI(@RequestBody PayOrderWeiXinJSAPIBody payOrderWeiXinJSAPIBody);
}
