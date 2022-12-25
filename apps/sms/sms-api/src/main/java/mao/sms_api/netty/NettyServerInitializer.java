package mao.sms_api.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.netty
 * Class(类名): NettyServerInitializer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/25
 * Time(创建时间)： 19:43
 * Version(版本): 1.0
 * Description(描述)： 服务端初始化
 */

@Slf4j
public class NettyServerInitializer extends ChannelInitializer<SocketChannel>
{

    /**
     * 初始化channel
     */
    @Override
    public void initChannel(SocketChannel ch)
    {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
        pipeline.addLast(new NettyServerHandler());
        log.info("初始化 NettyServer channel");
    }
}
