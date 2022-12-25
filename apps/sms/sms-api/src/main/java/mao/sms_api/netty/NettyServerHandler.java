package mao.sms_api.netty;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import mao.sms_api.service.impl.SmsSendServiceImpl;
import mao.sms_entity.dto.SmsParamsDTO;
import mao.tools_core.utils.SpringUtils;
import org.apache.commons.lang.StringUtils;

import java.net.InetSocketAddress;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.netty
 * Class(类名): NettyServerHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/25
 * Time(创建时间)： 19:39
 * Version(版本): 1.0
 * Description(描述)： 服务端处理器
 */

@Slf4j
public class NettyServerHandler extends SimpleChannelInboundHandler<String>
{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg)
    {
        //接收应用系统的报文并解析，调用Service将消息保存到消息缓冲区
        log.info("开始解析报文:{}", msg);
        String resp = "success";
        try
        {
            //开始将String类型的报文转换为SmsParamsDTO类型的对象
            SmsParamsDTO smsParamsDTO = parseMessage(msg);
            if (smsParamsDTO == null)
            {
                //报文解析失败，不能发送短信
                log.error("报文解析失败");
                return;
            }
            //从Spring容器中获取SmsSendServiceImpl,将信息保存到消息缓冲区
            SpringUtils.getBean(SmsSendServiceImpl.class).send(smsParamsDTO);
        }
        catch (Exception e)
        {
            resp = e.getMessage();
        }
        //向客户端写回数据
        ctx.writeAndFlush(resp + "\n");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx)
    {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = inetSocketAddress.getAddress().getHostAddress();
        log.info("收到客户端[ip:" + clientIp + "]连接");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
    {
        //当出现异常就关闭连接
        ctx.close();
    }

    /**
     * 解析报文
     * 设备不同报文也不同，直接使用json格式传输
     */
    private SmsParamsDTO parseMessage(String body)
    {
        //判断报文是否为空
        if (org.apache.commons.lang.StringUtils.isBlank(body))
        {
            log.warn("报文为空");
            return null;
        }
        body = body.trim();
        // 其它格式的报文需要解析后放入SmsParamsDTO实体
        SmsParamsDTO message = JSON.parseObject(body, SmsParamsDTO.class);
        if (message == null || org.apache.commons.lang.StringUtils.isBlank(message.getMobile()) ||
                org.apache.commons.lang.StringUtils.isBlank(message.getSignature()) ||
                StringUtils.isBlank(message.getTemplate()))
        {
            log.warn("报文内容异常");
            return null;
        }

        return message;
    }
}
