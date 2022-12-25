package mao.sms_api.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.netty
 * Class(类名): NettyServer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/25
 * Time(创建时间)： 19:45
 * Version(版本): 1.0
 * Description(描述)： netty服务启动类
 */

@Slf4j
@Component
@SuppressWarnings("all")
public class NettyServer implements CommandLineRunner
{
    private static NettyServer nettyServer;

    @PostConstruct
    public void init()
    {
        nettyServer = this;
        log.info("初始化 NettyServer");
    }


    /**
     * 端口
     */
    @Value("${netty.port:10001}")
    private int port;

    private EventLoopGroup mainGroup;
    private EventLoopGroup subGroup;
    private ServerBootstrap server;
    private ChannelFuture future;

    /**
     * 启动
     */
    public void start()
    {
        mainGroup = new NioEventLoopGroup(2);
        subGroup = new NioEventLoopGroup(4);
        try
        {
            server = new ServerBootstrap();
            server.group(mainGroup, subGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 60000)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new NettyServerInitializer());

            // 绑定端口,开始接收进来的连接
            future = server.bind(port).sync();
            log.info("netty服务启动: [port:" + port + "]");
            // 等待服务器socket关闭
            future.channel().closeFuture().sync();
        }
        catch (Exception e)
        {
            log.error("netty服务启动异常-" + e.getMessage());
        }
        finally
        {
            mainGroup.shutdownGracefully();
            subGroup.shutdownGracefully();
        }
    }


    @Override
    public void run(String... args)
    {
        new Thread("Netty")
        {
            @Override
            public void run()
            {
                nettyServer.start();
            }
        }.start();
    }
}
