package mao.tools_log.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：logback_spring_boot_starter_demo
 * Package(包名): mao.tools_log.init
 * Class(类名): ApplicationLoggerInitializer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/31
 * Time(创建时间)： 21:43
 * Version(版本): 1.0
 * Description(描述)：
 * <p>
 * 通过环境变量的形式注入 logging.file
 * 自动维护 Spring Boot Admin Logger Viewer
 */

public class ApplicationLoggerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>
{

    private static final Logger log = LoggerFactory.getLogger(ApplicationLoggerInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext)
    {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String logBase = environment.getProperty("logging.path", "/data/projects/logs");
        String appName = environment.getProperty("spring.application.name");
        // spring boot admin 直接加载日志
        System.setProperty("logging.file", String.format("%s/%s/root.log", logBase, appName));

        // nacos的日志文件路径
        System.setProperty("nacos.logging.path", String.format("%s/%s", logBase, appName));
        //这里设置了无效，跟启动时，传递 -Dcom.alibaba.nacos.naming.log.level=warn 一样，可能是nacos的bug
//        System.setProperty("com.alibaba.nacos.naming.log.level", "warn");
//        System.setProperty("com.alibaba.nacos.config.log.level", "info");
    }


    @PostConstruct
    public void init()
    {
        log.info("初始化 ApplicationLoggerInitializer");
    }
}
