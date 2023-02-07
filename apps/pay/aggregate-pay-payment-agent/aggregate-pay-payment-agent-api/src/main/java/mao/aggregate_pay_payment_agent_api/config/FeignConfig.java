package mao.aggregate_pay_payment_agent_api.config;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_payment_agent_api.fallback.PayChannelAgentFeignClientFallbackFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.config
 * Class(类名): FeignConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/7
 * Time(创建时间)： 14:02
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class FeignConfig
{
    @Bean
    @ConditionalOnMissingBean
    public PayChannelAgentFeignClientFallbackFactory payChannelAgentFeignClientFallbackFactory()
    {
        log.debug("feign PayChannelAgentFeignClientFallbackFactory");
        return new PayChannelAgentFeignClientFallbackFactory();
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 FeignConfig");
    }
}
