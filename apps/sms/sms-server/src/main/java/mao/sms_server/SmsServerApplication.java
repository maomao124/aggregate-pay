package mao.sms_server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@EnableAsync
@EnableDiscoveryClient
@EnableHystrix
@EnableTransactionManagement
@EnableScheduling
@SpringBootApplication
public class SmsServerApplication
{

    public static void main(String[] args) throws UnknownHostException
    {
        long start = System.currentTimeMillis();
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SmsServerApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String appName = environment.getProperty("spring.application.name");
        String port = environment.getProperty("server.port");
        String hostAddress = InetAddress.getLocalHost().getHostAddress();

        //启动完成后在控制台提示项目启动成功，并且输出当前服务对应的swagger接口文档访问地址
        //http://localhost:8080/doc.html
        log.info("应用{}启动成功!swagger地址：http://{}:{}/doc.html", appName, hostAddress, port);
        log.info("数据库监控地址：http://{}:{}/druid",hostAddress, port);
        log.info("启动耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

}
