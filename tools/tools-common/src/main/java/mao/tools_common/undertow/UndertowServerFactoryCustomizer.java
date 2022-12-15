package mao.tools_common.undertow;

import io.undertow.connector.ByteBufferPool;
import io.undertow.server.DefaultByteBufferPool;
import io.undertow.websockets.jsr.WebSocketDeploymentInfo;
import org.springframework.boot.web.embedded.undertow.UndertowDeploymentInfoCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.xnio.OptionMap;
import org.xnio.Options;
import org.xnio.Xnio;
import org.xnio.XnioWorker;

import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.undertow
 * Class(类名): UndertowServerFactoryCustomizer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 20:42
 * Version(版本): 1.0
 * Description(描述)： 设置Undertow服务器 XnioWorker Buffers
 * 解决启动时警告：[io.undertow.websockets.jsr.handleDeployment:68] --> UT026010: Buffer pool was not set on WebSocketDeploymentInfo,
 * the default pool will be used
 */

public class UndertowServerFactoryCustomizer implements WebServerFactoryCustomizer<UndertowServletWebServerFactory>
{
    /**
     * 定制
     *
     * @param factory 工厂
     */
    @Override
    public void customize(UndertowServletWebServerFactory factory)
    {
        UndertowDeploymentInfoCustomizer undertowDeploymentInfoCustomizer = deploymentInfo ->
        {
            WebSocketDeploymentInfo info = (WebSocketDeploymentInfo)
                    deploymentInfo.getServletContextAttributes().get(WebSocketDeploymentInfo.ATTRIBUTE_NAME);
            XnioWorker worker = getXnioWorker();
            ByteBufferPool buffers = new DefaultByteBufferPool(Boolean.getBoolean("io.undertow.websockets.direct-buffers"),
                    1024, 100, 12);
            info.setWorker(worker);
            info.setBuffers(buffers);
        };
        factory.addDeploymentInfoCustomizers(undertowDeploymentInfoCustomizer);
    }

    /**
     * 获取XnioWorker
     *
     * @return {@link XnioWorker}
     */
    private XnioWorker getXnioWorker()
    {
        XnioWorker worker = null;
        try
        {
            worker = Xnio.getInstance().createWorker(OptionMap.create(Options.THREAD_DAEMON, true));
        }
        catch (IOException ignored)
        {
        }
        return worker;
    }
}
