package mao.sms_sdk.config;

import lombok.extern.slf4j.Slf4j;
import mao.sms_sdk.service.SmsSendService;
import mao.sms_sdk.service.impl.SmsSendServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_sdk.config
 * Class(类名): SmsConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/27
 * Time(创建时间)： 21:33
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
@EnableConfigurationProperties(SmsConfigurationProperties.class)
public class SmsConfig
{
    /**
     * 短信发送服务
     *
     * @return {@link SmsSendService}
     */
    @Bean
    public SmsSendService smsSendService()
    {
        return new SmsSendServiceImpl();
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 SmsConfig");
    }
}
