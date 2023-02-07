package mao.aggregate_pay_user_api.config;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_user_api.fallback.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.config
 * Class(类名): UserFeignConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/7
 * Time(创建时间)： 14:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class UserFeignConfig
{
    /**
     * AuthorizationFeignClientFallbackFactory
     *
     * @return {@link AuthorizationFeignClientFallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public AuthorizationFeignClientFallbackFactory authorizationFeignClientFallbackFactory()
    {
        log.debug("feign AuthorizationFeignClientFallbackFactory");
        return new AuthorizationFeignClientFallbackFactory();
    }

    /**
     * AuthorizationFeignClientV2FallbackFactory
     *
     * @return {@link AuthorizationFeignClientV2FallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public AuthorizationFeignClientV2FallbackFactory authorizationFeignClientV2FallbackFactory()
    {
        log.debug("feign AuthorizationFeignClientV2FallbackFactory");
        return new AuthorizationFeignClientV2FallbackFactory();
    }

    /**
     * ResourceFeignClientFallbackFactory
     *
     * @return {@link ResourceFeignClientFallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public ResourceFeignClientFallbackFactory resourceFeignClientFallbackFactory()
    {
        log.debug("feign ResourceFeignClientFallbackFactory");
        return new ResourceFeignClientFallbackFactory();
    }

    /**
     * ResourceFeignClientV2FallbackFactory
     *
     * @return {@link ResourceFeignClientV2FallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public ResourceFeignClientV2FallbackFactory resourceFeignClientV2FallbackFactory()
    {
        log.debug("feign ResourceFeignClientV2FallbackFactory");
        return new ResourceFeignClientV2FallbackFactory();
    }

    /**
     * TenantFeignClientFallbackFactory
     *
     * @return {@link TenantFeignClientFallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public TenantFeignClientFallbackFactory tenantFeignClientFallbackFactory()
    {
        log.debug("feign TenantFeignClientFallbackFactory");
        return new TenantFeignClientFallbackFactory();
    }

    /**
     * TenantFeignClientV2FallbackFactory
     *
     * @return {@link TenantFeignClientV2FallbackFactory}
     */
    @Bean
    @ConditionalOnMissingBean
    public TenantFeignClientV2FallbackFactory tenantFeignClientV2FallbackFactory()
    {
        log.debug("feign TenantFeignClientV2FallbackFactory");
        return new TenantFeignClientV2FallbackFactory();
    }


    @PostConstruct
    public void init()
    {
        log.info("初始化 UserFeignConfig");
    }
}
