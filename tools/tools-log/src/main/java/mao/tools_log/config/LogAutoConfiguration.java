package mao.tools_log.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_log.aspect.SysLogAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：logback_spring_boot_starter_demo
 * Package(包名): mao.tools_log.config
 * Class(类名): LogAutoConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/31
 * Time(创建时间)： 22:29
 * Version(版本): 1.0
 * Description(描述)：
 * <p>
 * 启动条件：
 * 1，存在web环境
 * 2，配置文件中log.enabled=true
 * 3，配置文件中不存在：log.enabled 值
 */

@Slf4j
@EnableAsync
@Configuration
@ConditionalOnWebApplication
@ConditionalOnProperty(name = "log.enabled", havingValue = "true", matchIfMissing = true)
public class LogAutoConfiguration
{

    @Bean
    @ConditionalOnMissingBean
    public SysLogAspect sysLogAspect()
    {
        return new SysLogAspect();
    }


    @PostConstruct
    public void init()
    {
        log.info("初始化 LogAutoConfiguration");
    }

}

