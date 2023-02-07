package mao.aggregate_pay_transaction_api.config;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_transaction_api.fallback.PayChannelFeignClientFallbackFactory;
import mao.aggregate_pay_transaction_api.fallback.PayChannelParamFeignClientFallbackFactory;
import mao.aggregate_pay_transaction_api.fallback.PlatformChannelFeignClientFallbackFactory;
import mao.aggregate_pay_transaction_api.fallback.TransactionFeignClientFallbackFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_api.config
 * Class(类名): FeignConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/7
 * Time(创建时间)： 14:12
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class TransactionFeignConfig
{

    /**
     * PayChannelFeignClientFallbackFactory
     *
     * @return {@link PayChannelFeignClientFallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public PayChannelFeignClientFallbackFactory payChannelFeignClientFallbackFactory()
    {
        log.debug("feign PayChannelFeignClientFallbackFactory");
        return new PayChannelFeignClientFallbackFactory();
    }

    /**
     * PayChannelParamFeignClientFallbackFactory
     *
     * @return {@link PayChannelParamFeignClientFallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public PayChannelParamFeignClientFallbackFactory payChannelParamFeignClientFallbackFactory()
    {
        log.debug("feign PayChannelParamFeignClientFallbackFactory");
        return new PayChannelParamFeignClientFallbackFactory();
    }

    /**
     * PlatformChannelFeignClientFallbackFactory
     *
     * @return {@link PlatformChannelFeignClientFallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public PlatformChannelFeignClientFallbackFactory platformChannelFeignClientFallbackFactory()
    {
        log.debug("feign PlatformChannelFeignClientFallbackFactory");
        return new PlatformChannelFeignClientFallbackFactory();
    }

    /**
     * TransactionFeignClientFallbackFactory
     *
     * @return {@link TransactionFeignClientFallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public TransactionFeignClientFallbackFactory transactionFeignClientFallbackFactory()
    {
        log.debug("feign TransactionFeignClientFallbackFactory");
        return new TransactionFeignClientFallbackFactory();
    }


    @PostConstruct
    public void init()
    {
        log.info("初始化 TransactionFeignConfig");
    }
}
