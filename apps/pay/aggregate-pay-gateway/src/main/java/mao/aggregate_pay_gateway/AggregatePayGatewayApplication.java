package mao.aggregate_pay_gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@EnableZuulProxy
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class AggregatePayGatewayApplication
{
    /**
     * 服务启动类
     *
     * @param args 参数
     * @throws UnknownHostException 未知主机异常
     */
    public static void main(String[] args) throws UnknownHostException
    {
        //获取开始时间
        long start = System.currentTimeMillis();
        //启动
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AggregatePayGatewayApplication.class, args);
        //环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //获取应用名称
        String appName = environment.getProperty("spring.application.name");
        //获取端口号
        String port = environment.getProperty("server.port");
        //获取主机地址
        String hostAddress = InetAddress.getLocalHost().getHostAddress();

        //启动完成后在控制台提示项目启动成功，并且输出当前服务对应的swagger接口文档访问地址
        //http://localhost:8080/doc.html
        log.info("应用{}启动成功!", appName);
        log.info("启动耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

}
