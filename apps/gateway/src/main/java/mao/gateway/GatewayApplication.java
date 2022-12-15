package mao.gateway;

import lombok.extern.slf4j.Slf4j;
import mao.tools_jwt.client.EnableAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@EnableZuulProxy
@EnableAuthClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients({"mao"})
public class GatewayApplication
{

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GatewayApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String appName = environment.getProperty("spring.application.name");
        log.info("应用{}启动成功!", appName);
        log.info("启动耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

}
