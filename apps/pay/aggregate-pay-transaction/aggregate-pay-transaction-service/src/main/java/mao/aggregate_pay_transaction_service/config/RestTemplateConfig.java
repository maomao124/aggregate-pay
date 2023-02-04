package mao.aggregate_pay_transaction_service.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.config
 * Class(类名): RestTemplateConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/4
 * Time(创建时间)： 21:33
 * Version(版本): 1.0
 * Description(描述)： RestTemplate配置
 */

@Slf4j
@Configuration
public class RestTemplateConfig
{
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 RestTemplateConfig");
    }
}
