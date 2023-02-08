package mao.aggregate_pay_uaa_service.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.netty.channel.local.LocalAddress;
import io.undertow.conduits.DebuggingStreamSinkConduit;
import io.undertow.conduits.DebuggingStreamSourceConduit;
import io.undertow.server.DefaultByteBufferPool;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.protocol.ajp.AjpServerConnection;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.core.DeploymentImpl;
import io.undertow.servlet.core.DeploymentManagerImpl;
import io.undertow.servlet.core.ServletContainerImpl;
import io.undertow.servlet.spec.HttpServletRequestImpl;
import io.undertow.servlet.spec.ServletContextImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.xnio.StreamConnection;
import org.xnio.XnioIoThread;
import org.xnio.channels.EmptyStreamSourceChannel;
import org.xnio.conduits.ConduitStreamSinkChannel;
import org.xnio.conduits.ConduitStreamSourceChannel;
import org.xnio.conduits.StreamSinkConduit;
import org.xnio.conduits.StreamSourceConduit;

class WebUtilsTest
{
    /**
     * Method under test: {@link WebUtils#setIp(String)}
     */
    @Test
    void testSetIp()
    {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by setIp(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        WebUtils.setIp("127.0.0.1");
    }

    /**
     * Method under test: {@link WebUtils#getIp()}
     */
    @Test
    void testGetIp()
    {
        assertNull(WebUtils.getIp());
    }

    /**
     * Method under test: {@link WebUtils#retrieveClientIp(javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testRetrieveClientIp()
    {
        assertEquals("127.0.0.1", WebUtils.retrieveClientIp(new MockHttpServletRequest()));
    }

    /**
     * Method under test: {@link WebUtils#retrieveClientIp(javax.servlet.http.HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRetrieveClientIp2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_uaa_service.utils.WebUtils.retrieveClientIp(WebUtils.java:55)
        //   In order to prevent retrieveClientIp(HttpServletRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   retrieveClientIp(HttpServletRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        WebUtils.retrieveClientIp(null);
    }

    /**
     * Method under test: {@link WebUtils#retrieveClientIp(javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testRetrieveClientIp3()
    {
        StreamSinkConduit streamSinkConduit = mock(StreamSinkConduit.class);
        doNothing().when(streamSinkConduit).setWriteReadyHandler((org.xnio.conduits.WriteReadyHandler) any());
        DebuggingStreamSinkConduit conduit = new DebuggingStreamSinkConduit(new DebuggingStreamSinkConduit(
                new DebuggingStreamSinkConduit(new DebuggingStreamSinkConduit(streamSinkConduit))));
        ConduitStreamSinkChannel conduitStreamSinkChannel = new ConduitStreamSinkChannel(
                new EmptyStreamSourceChannel(mock(XnioIoThread.class)), conduit);

        StreamSourceConduit streamSourceConduit = mock(StreamSourceConduit.class);
        doNothing().when(streamSourceConduit).setReadReadyHandler((org.xnio.conduits.ReadReadyHandler) any());
        DebuggingStreamSourceConduit conduit1 = new DebuggingStreamSourceConduit(new DebuggingStreamSourceConduit(
                new DebuggingStreamSourceConduit(new DebuggingStreamSourceConduit(streamSourceConduit))));
        ConduitStreamSourceChannel conduitStreamSourceChannel = new ConduitStreamSourceChannel(
                new EmptyStreamSourceChannel(mock(XnioIoThread.class)), conduit1);

        StreamConnection streamConnection = mock(StreamConnection.class);
        when(streamConnection.getPeerAddress()).thenReturn(new LocalAddress("42"));
        doNothing().when(streamConnection).setCloseListener((org.xnio.ChannelListener<? super StreamConnection>) any());
        when(streamConnection.getSourceChannel()).thenReturn(conduitStreamSourceChannel);
        when(streamConnection.getSinkChannel()).thenReturn(conduitStreamSinkChannel);
        HttpServerExchange exchange = new HttpServerExchange(new AjpServerConnection(streamConnection,
                new DefaultByteBufferPool(true, 3), mock(HttpHandler.class), null, 3));
        ServletContainerImpl servletContainer = new ServletContainerImpl();
        DeploymentInfo deployment = new DeploymentInfo();
        DeploymentManagerImpl deploymentManager = new DeploymentManagerImpl(deployment, new ServletContainerImpl());

        DeploymentInfo deploymentInfo = new DeploymentInfo();
        assertEquals("",
                WebUtils.retrieveClientIp(new HttpServletRequestImpl(exchange, new ServletContextImpl(servletContainer,
                        new DeploymentImpl(deploymentManager, deploymentInfo, new ServletContainerImpl())))));
        verify(streamConnection).getPeerAddress();
        verify(streamConnection, atLeast(1)).getSinkChannel();
        verify(streamConnection).getSourceChannel();
        verify(streamConnection).setCloseListener((org.xnio.ChannelListener<? super StreamConnection>) any());
        verify(streamSourceConduit).setReadReadyHandler((org.xnio.conduits.ReadReadyHandler) any());
        verify(streamSinkConduit).setWriteReadyHandler((org.xnio.conduits.WriteReadyHandler) any());
    }

    /**
     * Method under test: {@link WebUtils#retrieveClientIp(javax.servlet.http.HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRetrieveClientIp4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at io.undertow.server.HttpServerExchange.getSourceAddress(HttpServerExchange.java:983)
        //       at io.undertow.servlet.spec.HttpServletRequestImpl.getRemoteAddr(HttpServletRequestImpl.java:898)
        //       at mao.aggregate_pay_uaa_service.utils.WebUtils.retrieveClientIp(WebUtils.java:66)
        //   In order to prevent retrieveClientIp(HttpServletRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   retrieveClientIp(HttpServletRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        StreamSourceConduit streamSourceConduit = mock(StreamSourceConduit.class);
        doNothing().when(streamSourceConduit).setReadReadyHandler((org.xnio.conduits.ReadReadyHandler) any());
        DebuggingStreamSourceConduit conduit = new DebuggingStreamSourceConduit(new DebuggingStreamSourceConduit(
                new DebuggingStreamSourceConduit(new DebuggingStreamSourceConduit(streamSourceConduit))));
        new ConduitStreamSourceChannel(new EmptyStreamSourceChannel(mock(XnioIoThread.class)), conduit);

        StreamSinkConduit streamSinkConduit = mock(StreamSinkConduit.class);
        doNothing().when(streamSinkConduit).setWriteReadyHandler((org.xnio.conduits.WriteReadyHandler) any());
        DebuggingStreamSinkConduit conduit1 = new DebuggingStreamSinkConduit(new DebuggingStreamSinkConduit(
                new DebuggingStreamSinkConduit(new DebuggingStreamSinkConduit(streamSinkConduit))));
        new ConduitStreamSinkChannel(new EmptyStreamSourceChannel(mock(XnioIoThread.class)), conduit1);

        HttpServerExchange exchange = new HttpServerExchange(null);
        ServletContainerImpl servletContainer = new ServletContainerImpl();
        DeploymentInfo deployment = new DeploymentInfo();
        DeploymentManagerImpl deploymentManager = new DeploymentManagerImpl(deployment, new ServletContainerImpl());

        DeploymentInfo deploymentInfo = new DeploymentInfo();
        WebUtils.retrieveClientIp(new HttpServletRequestImpl(exchange, new ServletContextImpl(servletContainer,
                new DeploymentImpl(deploymentManager, deploymentInfo, new ServletContainerImpl()))));
    }
}

