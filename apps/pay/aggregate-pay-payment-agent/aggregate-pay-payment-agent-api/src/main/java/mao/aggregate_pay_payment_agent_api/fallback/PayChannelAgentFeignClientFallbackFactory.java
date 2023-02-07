package mao.aggregate_pay_payment_agent_api.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_payment_agent_api.dto.PayOrderByAliWAPBody;
import mao.aggregate_pay_payment_agent_api.dto.PayOrderWeiXinJSAPIBody;
import mao.aggregate_pay_payment_agent_api.dto.PaymentResponseDTO;
import mao.aggregate_pay_payment_agent_api.feign.PayChannelAgentFeignClient;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;

import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.fallback
 * Class(类名): PayChannelAgentFeignClientFallbackFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/7
 * Time(创建时间)： 13:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class PayChannelAgentFeignClientFallbackFactory implements FallbackFactory<PayChannelAgentFeignClient>
{

    @Override
    public PayChannelAgentFeignClient create(Throwable throwable)
    {
        return new PayChannelAgentFeignClient()
        {
            @Override
            public R<PaymentResponseDTO<String>> createPayOrderByAliWAP(PayOrderByAliWAPBody payOrderByAliWAPBody)
            {
                throw new BizException("支付聚道代理服务不可用或者异常");
            }

            @Override
            public R<Map<String, String>> createPayOrderByWeChatJSAPI(PayOrderWeiXinJSAPIBody payOrderWeiXinJSAPIBody)
            {
                throw new BizException("支付聚道代理服务不可用或者异常");
            }
        };
    }
}
