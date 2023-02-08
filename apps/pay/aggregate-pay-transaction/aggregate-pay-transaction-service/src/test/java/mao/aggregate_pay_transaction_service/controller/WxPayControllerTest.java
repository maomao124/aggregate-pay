package mao.aggregate_pay_transaction_service.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;

import mao.aggregate_pay_transaction_service.properties.WxPayConfigurationProperties;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {WxPayController.class, WxPayConfigurationProperties.class})
@ExtendWith(SpringExtension.class)
class WxPayControllerTest
{
    @Autowired
    private WxPayConfigurationProperties wxPayConfigurationProperties;

    @Autowired
    private WxPayController wxPayController;

    /**
     * Method under test: {@link WxPayController#getWXOAuth2Code(javax.servlet.http.HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWXOAuth2Code() throws UnsupportedEncodingException
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController.getWXOAuth2Code(WxPayController.java:66)
        //   In order to prevent getWXOAuth2Code(HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getWXOAuth2Code(HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        WxPayController wxPayController = new WxPayController();
        wxPayController.getWXOAuth2Code(new Response());
    }

    /**
     * Method under test: {@link WxPayController#getWXOAuth2Code(javax.servlet.http.HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWXOAuth2Code2() throws UnsupportedEncodingException
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController.getWXOAuth2Code(WxPayController.java:66)
        //   In order to prevent getWXOAuth2Code(HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getWXOAuth2Code(HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        WxPayController wxPayController = new WxPayController();
        Response response = mock(Response.class);
        doNothing().when(response).addDateHeader((String) any(), anyLong());
        response.addDateHeader("%s?appid=%s&scope=snsapi_base&state=%s&redirect_uri=%s", 42L);
        wxPayController.getWXOAuth2Code(response);
    }

    /**
     * Method under test: default or parameterless constructor of {@link WXPayConfigCustom}
     */
    @Test
    void testWXPayConfigCustomConstructor()
    {
        assertNull(((new WxPayController()).new WXPayConfigCustom()).getCertStream());
    }

    /**
     * Method under test: {@link WXPayConfigCustom#getAppID()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWXPayConfigCustomGetAppID()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController$WXPayConfigCustom.getAppID(WxPayController.java:149)
        //   In order to prevent getAppID()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAppID().
        //   See https://diff.blue/R013 to resolve this issue.

        ((new WxPayController()).new WXPayConfigCustom()).getAppID();
    }

    /**
     * Method under test: {@link WXPayConfigCustom#getAppID()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWXPayConfigCustomGetAppID2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController.access$000(WxPayController.java:46)
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController$WXPayConfigCustom.getAppID(WxPayController.java:149)
        //   In order to prevent getAppID()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAppID().
        //   See https://diff.blue/R013 to resolve this issue.

        WxPayController wxPayController = null;
        (wxPayController.new WXPayConfigCustom()).getAppID();
    }

    /**
     * Method under test: {@link WXPayConfigCustom#getKey()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWXPayConfigCustomGetKey()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController$WXPayConfigCustom.getKey(WxPayController.java:161)
        //   In order to prevent getKey()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getKey().
        //   See https://diff.blue/R013 to resolve this issue.

        ((new WxPayController()).new WXPayConfigCustom()).getKey();
    }

    /**
     * Method under test: {@link WXPayConfigCustom#getKey()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWXPayConfigCustomGetKey2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController.access$000(WxPayController.java:46)
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController$WXPayConfigCustom.getKey(WxPayController.java:161)
        //   In order to prevent getKey()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getKey().
        //   See https://diff.blue/R013 to resolve this issue.

        WxPayController wxPayController = null;
        (wxPayController.new WXPayConfigCustom()).getKey();
    }

    /**
     * Method under test: {@link WXPayConfigCustom#getMchID()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWXPayConfigCustomGetMchID()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController$WXPayConfigCustom.getMchID(WxPayController.java:155)
        //   In order to prevent getMchID()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getMchID().
        //   See https://diff.blue/R013 to resolve this issue.

        ((new WxPayController()).new WXPayConfigCustom()).getMchID();
    }

    /**
     * Method under test: {@link WXPayConfigCustom#getMchID()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWXPayConfigCustomGetMchID2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController.access$000(WxPayController.java:46)
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController$WXPayConfigCustom.getMchID(WxPayController.java:155)
        //   In order to prevent getMchID()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getMchID().
        //   See https://diff.blue/R013 to resolve this issue.

        WxPayController wxPayController = null;
        (wxPayController.new WXPayConfigCustom()).getMchID();
    }

    /**
     * Method under test: {@link WXPayConfigCustom#getWXPayDomain()}
     */
    @Test
    void testWXPayConfigCustomGetWXPayDomain()
    {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by getWXPayDomain()
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        ((new WxPayController()).new WXPayConfigCustom()).getWXPayDomain();
    }

    /**
     * Method under test: {@link WxPayController#wxjspay(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWxjspay() throws Exception
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController$WXPayConfigCustom.getAppID(WxPayController.java:149)
        //       at com.github.wxpay.sdk.WXPay.fillRequestData(WXPay.java:87)
        //       at com.github.wxpay.sdk.WXPay.unifiedOrder(WXPay.java:364)
        //       at com.github.wxpay.sdk.WXPay.unifiedOrder(WXPay.java:340)
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController.wxjspay(WxPayController.java:126)
        //   In order to prevent wxjspay(HttpServletRequest, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   wxjspay(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        WxPayController wxPayController = new WxPayController();
        MockHttpServletRequest request = new MockHttpServletRequest();
        wxPayController.wxjspay(request, new Response());
    }

    /**
     * Method under test: {@link WxPayController#wxjspay(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWxjspay2() throws Exception
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController.wxjspay(WxPayController.java:123)
        //   In order to prevent wxjspay(HttpServletRequest, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   wxjspay(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        WxPayController wxPayController = new WxPayController();
        wxPayController.wxjspay(null, new Response());
    }

    /**
     * Method under test: {@link WxPayController#wxjspay(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWxjspay3() throws Exception
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController$WXPayConfigCustom.getAppID(WxPayController.java:149)
        //       at com.github.wxpay.sdk.WXPay.fillRequestData(WXPay.java:87)
        //       at com.github.wxpay.sdk.WXPay.unifiedOrder(WXPay.java:364)
        //       at com.github.wxpay.sdk.WXPay.unifiedOrder(WXPay.java:340)
        //       at mao.aggregate_pay_transaction_service.controller.WxPayController.wxjspay(WxPayController.java:126)
        //   In order to prevent wxjspay(HttpServletRequest, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   wxjspay(HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        WxPayController wxPayController = new WxPayController();
        DefaultMultipartHttpServletRequest defaultMultipartHttpServletRequest = mock(
                DefaultMultipartHttpServletRequest.class);
        when(defaultMultipartHttpServletRequest.getParameter((String) any())).thenReturn("https://example.org/example");
        wxPayController.wxjspay(defaultMultipartHttpServletRequest, new Response());
    }

    /**
     * Method under test: {@link WxPayController#wxOAuth2CodeReturn(String, String, javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testWxOAuth2CodeReturn() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/wxpay/wx‐oauth‐code‐return‐test")
                .param("code", "foo")
                .param("state", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.wxPayController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

