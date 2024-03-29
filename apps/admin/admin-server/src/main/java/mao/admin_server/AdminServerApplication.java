package mao.admin_server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@EnableAdminServer
@SpringBootApplication
public class AdminServerApplication
{

    /**
     * 服务启动类
     *
     * @param args 参数
     * @throws UnknownHostException 未知主机异常
     */
    public static void main
    (String[] args) throws UnknownHostException
    {
        //获取开始时间
        long start = System.currentTimeMillis();
        //启动
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AdminServerApplication.class, args);
        //环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //获取应用名称
        String appName = environment.getProperty("spring.application.name");
        //获取端口号
        String port = environment.getProperty("server.port");
        //获取主机地址
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        //获取上下文
        String contextPath = environment.getProperty("server.servlet.context-path");
        //判断上下文
        if (contextPath == null || contextPath.length() == 0 || contextPath.equals("/"))
        {
            contextPath = "";
        }
        log.info("应用{}启动成功!swagger地址：http://{}:{}{}/wallboard  或者：http://127.0.0.1:{}{}/wallboard",
                appName, hostAddress, port, contextPath, port, contextPath);
        log.info("启动耗时：" + (System.currentTimeMillis() - start) + "ms");

    }

}
