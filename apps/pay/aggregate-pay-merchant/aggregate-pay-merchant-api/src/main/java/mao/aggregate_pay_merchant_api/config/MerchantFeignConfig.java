package mao.aggregate_pay_merchant_api.config;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_merchant_api.fallback.AppFeignClientFallbackFactory;
import mao.aggregate_pay_merchant_api.fallback.MerchantFeignClientFallbackFactory;
import mao.aggregate_pay_merchant_api.fallback.StaffFeignClientFallbackFactory;
import mao.aggregate_pay_merchant_api.fallback.StoreFeignClientFallbackFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.config
 * Class(类名): FeignConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/6
 * Time(创建时间)： 22:50
 * Version(版本): 1.0
 * Description(描述)： feign配置
 */

@Slf4j
@Configuration
public class MerchantFeignConfig
{

    /**
     * AppFeignClientFallbackFactory
     *
     * @return {@link AppFeignClientFallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public AppFeignClientFallbackFactory appFeignClientFallbackFactory()
    {
        log.debug("feign AppFeignClientFallbackFactory");
        return new AppFeignClientFallbackFactory();
    }


    /**
     * MerchantFeignClientFallbackFactory
     *
     * @return {@link MerchantFeignClientFallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public MerchantFeignClientFallbackFactory merchantFeignClientFallbackFactory()
    {
        log.debug("feign MerchantFeignClientFallbackFactory");
        return new MerchantFeignClientFallbackFactory();
    }


    /**
     * StaffFeignClientFallbackFactory
     *
     * @return {@link StaffFeignClientFallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public StaffFeignClientFallbackFactory staffFeignClientFallbackFactory()
    {
        log.debug("feign StaffFeignClientFallbackFactory");
        return new StaffFeignClientFallbackFactory();
    }

    /**
     * StoreFeignClientFallbackFactory
     *
     * @return {@link StoreFeignClientFallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public StoreFeignClientFallbackFactory storeFeignClientFallbackFactory()
    {
        log.debug("feign StoreFeignClientFallbackFactory");
        return new StoreFeignClientFallbackFactory();
    }


    @PostConstruct
    public void init()
    {
        log.info("初始化 MerchantFeignConfig");
    }

}
