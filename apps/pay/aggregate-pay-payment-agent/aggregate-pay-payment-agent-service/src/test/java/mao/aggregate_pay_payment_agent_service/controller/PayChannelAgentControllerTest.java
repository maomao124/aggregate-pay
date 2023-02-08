package mao.aggregate_pay_payment_agent_service.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import mao.aggregate_pay_payment_agent_api.dto.AliConfigParam;
import mao.aggregate_pay_payment_agent_api.dto.AlipayBean;
import mao.aggregate_pay_payment_agent_api.dto.PayOrderByAliWAPBody;
import mao.aggregate_pay_payment_agent_api.dto.PayOrderWeiXinJSAPIBody;
import mao.aggregate_pay_payment_agent_api.dto.WXConfigParam;
import mao.aggregate_pay_payment_agent_api.dto.WeChatBean;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PayChannelAgentControllerTest
{
    /**
     * Method under test: {@link PayChannelAgentController#createPayOrderByAliWAP(PayOrderByAliWAPBody)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByAliWAP()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_payment_agent_service.controller.PayChannelAgentController.createPayOrderByAliWAP(PayChannelAgentController.java:52)
        //   In order to prevent createPayOrderByAliWAP(PayOrderByAliWAPBody)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByAliWAP(PayOrderByAliWAPBody).
        //   See https://diff.blue/R013 to resolve this issue.

        PayChannelAgentController payChannelAgentController = new PayChannelAgentController();

        AliConfigParam aliConfigParam = new AliConfigParam();
        aliConfigParam.setAlipayPublicKey("Alipay Public Key");
        aliConfigParam.setAppId("42");
        aliConfigParam.setCharset("UTF-8");
        aliConfigParam.setFormat("Format");
        aliConfigParam.setLogPath("Log Path");
        aliConfigParam.setNotifyUrl("https://example.org/example");
        aliConfigParam.setReturnUrl("https://example.org/example");
        aliConfigParam.setRsaPrivateKey("Rsa Private Key");
        aliConfigParam.setSignType("Sign Type");
        aliConfigParam.setUrl("https://example.org/example");

        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setAttach("Attach");
        alipayBean.setBody("Not all who wander are lost");
        alipayBean.setExpireTime("Expire Time");
        alipayBean.setOutTradeNo("Out Trade No");
        alipayBean.setProductCode("Product Code");
        alipayBean.setStoreId(123L);
        alipayBean.setSubject("Hello from the Dreaming Spires");
        alipayBean.setTimestamp("Timestamp");
        alipayBean.setTotalAmount("10");

        PayOrderByAliWAPBody payOrderByAliWAPBody = new PayOrderByAliWAPBody();
        payOrderByAliWAPBody.setAliConfigParam(aliConfigParam);
        payOrderByAliWAPBody.setAlipayBean(alipayBean);
        payChannelAgentController.createPayOrderByAliWAP(payOrderByAliWAPBody);
    }

    /**
     * Method under test: {@link PayChannelAgentController#createPayOrderByAliWAP(PayOrderByAliWAPBody)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByAliWAP2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_payment_agent_service.controller.PayChannelAgentController.createPayOrderByAliWAP(PayChannelAgentController.java:52)
        //   In order to prevent createPayOrderByAliWAP(PayOrderByAliWAPBody)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByAliWAP(PayOrderByAliWAPBody).
        //   See https://diff.blue/R013 to resolve this issue.

        PayChannelAgentController payChannelAgentController = new PayChannelAgentController();

        AliConfigParam aliConfigParam = new AliConfigParam();
        aliConfigParam.setAlipayPublicKey("Alipay Public Key");
        aliConfigParam.setAppId("42");
        aliConfigParam.setCharset("UTF-8");
        aliConfigParam.setFormat("Format");
        aliConfigParam.setLogPath("Log Path");
        aliConfigParam.setNotifyUrl("https://example.org/example");
        aliConfigParam.setReturnUrl("https://example.org/example");
        aliConfigParam.setRsaPrivateKey("Rsa Private Key");
        aliConfigParam.setSignType("Sign Type");
        aliConfigParam.setUrl("https://example.org/example");

        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setAttach("Attach");
        alipayBean.setBody("Not all who wander are lost");
        alipayBean.setExpireTime("Expire Time");
        alipayBean.setOutTradeNo("Out Trade No");
        alipayBean.setProductCode("Product Code");
        alipayBean.setStoreId(123L);
        alipayBean.setSubject("Hello from the Dreaming Spires");
        alipayBean.setTimestamp("Timestamp");
        alipayBean.setTotalAmount("10");

        AliConfigParam aliConfigParam1 = new AliConfigParam();
        aliConfigParam1.setAlipayPublicKey("Alipay Public Key");
        aliConfigParam1.setAppId("42");
        aliConfigParam1.setCharset("UTF-8");
        aliConfigParam1.setFormat("Format");
        aliConfigParam1.setLogPath("Log Path");
        aliConfigParam1.setNotifyUrl("https://example.org/example");
        aliConfigParam1.setReturnUrl("https://example.org/example");
        aliConfigParam1.setRsaPrivateKey("Rsa Private Key");
        aliConfigParam1.setSignType("Sign Type");
        aliConfigParam1.setUrl("https://example.org/example");

        AlipayBean alipayBean1 = new AlipayBean();
        alipayBean1.setAttach("Attach");
        alipayBean1.setBody("Not all who wander are lost");
        alipayBean1.setExpireTime("Expire Time");
        alipayBean1.setOutTradeNo("Out Trade No");
        alipayBean1.setProductCode("Product Code");
        alipayBean1.setStoreId(123L);
        alipayBean1.setSubject("Hello from the Dreaming Spires");
        alipayBean1.setTimestamp("Timestamp");
        alipayBean1.setTotalAmount("10");
        PayOrderByAliWAPBody payOrderByAliWAPBody = mock(PayOrderByAliWAPBody.class);
        when(payOrderByAliWAPBody.getAliConfigParam()).thenReturn(aliConfigParam1);
        when(payOrderByAliWAPBody.getAlipayBean()).thenReturn(alipayBean1);
        doNothing().when(payOrderByAliWAPBody).setAliConfigParam((AliConfigParam) any());
        doNothing().when(payOrderByAliWAPBody).setAlipayBean((AlipayBean) any());
        payOrderByAliWAPBody.setAliConfigParam(aliConfigParam);
        payOrderByAliWAPBody.setAlipayBean(alipayBean);
        payChannelAgentController.createPayOrderByAliWAP(payOrderByAliWAPBody);
    }

    /**
     * Method under test: {@link PayChannelAgentController#createPayOrderByWeChatJSAPI(PayOrderWeiXinJSAPIBody)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByWeChatJSAPI()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_payment_agent_service.controller.PayChannelAgentController.createPayOrderByWeChatJSAPI(PayChannelAgentController.java:70)
        //   In order to prevent createPayOrderByWeChatJSAPI(PayOrderWeiXinJSAPIBody)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByWeChatJSAPI(PayOrderWeiXinJSAPIBody).
        //   See https://diff.blue/R013 to resolve this issue.

        PayChannelAgentController payChannelAgentController = new PayChannelAgentController();

        WeChatBean weChatBean = new WeChatBean();
        weChatBean.setAppid("Appid");
        weChatBean.setAttach("Attach");
        weChatBean.setBody("Not all who wander are lost");
        weChatBean.setMchId("42");
        weChatBean.setNonceStr("Nonce Str");
        weChatBean.setNotifyUrl("https://example.org/example");
        weChatBean.setOpenId("42");
        weChatBean.setOutTradeNo("Out Trade No");
        weChatBean.setSign("Sign");
        weChatBean.setSpbillCreateIp("Spbill Create Ip");
        weChatBean.setStoreId(123L);
        weChatBean.setTotalFee(1);
        weChatBean.setTradeType("Trade Type");

        WXConfigParam wxConfigParam = new WXConfigParam();
        wxConfigParam.setAppId("42");
        wxConfigParam.setAppSecret("App Secret");
        wxConfigParam.setKey("Key");
        wxConfigParam.setMchId("42");
        wxConfigParam.setReturnUrl("https://example.org/example");

        PayOrderWeiXinJSAPIBody payOrderWeiXinJSAPIBody = new PayOrderWeiXinJSAPIBody();
        payOrderWeiXinJSAPIBody.setWeChatBean(weChatBean);
        payOrderWeiXinJSAPIBody.setWxConfigParam(wxConfigParam);
        payChannelAgentController.createPayOrderByWeChatJSAPI(payOrderWeiXinJSAPIBody);
    }

    /**
     * Method under test: {@link PayChannelAgentController#createPayOrderByWeChatJSAPI(PayOrderWeiXinJSAPIBody)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByWeChatJSAPI2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_payment_agent_service.controller.PayChannelAgentController.createPayOrderByWeChatJSAPI(PayChannelAgentController.java:70)
        //   In order to prevent createPayOrderByWeChatJSAPI(PayOrderWeiXinJSAPIBody)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByWeChatJSAPI(PayOrderWeiXinJSAPIBody).
        //   See https://diff.blue/R013 to resolve this issue.

        PayChannelAgentController payChannelAgentController = new PayChannelAgentController();

        WeChatBean weChatBean = new WeChatBean();
        weChatBean.setAppid("Appid");
        weChatBean.setAttach("Attach");
        weChatBean.setBody("Not all who wander are lost");
        weChatBean.setMchId("42");
        weChatBean.setNonceStr("Nonce Str");
        weChatBean.setNotifyUrl("https://example.org/example");
        weChatBean.setOpenId("42");
        weChatBean.setOutTradeNo("Out Trade No");
        weChatBean.setSign("Sign");
        weChatBean.setSpbillCreateIp("Spbill Create Ip");
        weChatBean.setStoreId(123L);
        weChatBean.setTotalFee(1);
        weChatBean.setTradeType("Trade Type");

        WXConfigParam wxConfigParam = new WXConfigParam();
        wxConfigParam.setAppId("42");
        wxConfigParam.setAppSecret("App Secret");
        wxConfigParam.setKey("Key");
        wxConfigParam.setMchId("42");
        wxConfigParam.setReturnUrl("https://example.org/example");

        WXConfigParam wxConfigParam1 = new WXConfigParam();
        wxConfigParam1.setAppId("42");
        wxConfigParam1.setAppSecret("App Secret");
        wxConfigParam1.setKey("Key");
        wxConfigParam1.setMchId("42");
        wxConfigParam1.setReturnUrl("https://example.org/example");

        WeChatBean weChatBean1 = new WeChatBean();
        weChatBean1.setAppid("Appid");
        weChatBean1.setAttach("Attach");
        weChatBean1.setBody("Not all who wander are lost");
        weChatBean1.setMchId("42");
        weChatBean1.setNonceStr("Nonce Str");
        weChatBean1.setNotifyUrl("https://example.org/example");
        weChatBean1.setOpenId("42");
        weChatBean1.setOutTradeNo("Out Trade No");
        weChatBean1.setSign("Sign");
        weChatBean1.setSpbillCreateIp("Spbill Create Ip");
        weChatBean1.setStoreId(123L);
        weChatBean1.setTotalFee(1);
        weChatBean1.setTradeType("Trade Type");
        PayOrderWeiXinJSAPIBody payOrderWeiXinJSAPIBody = mock(PayOrderWeiXinJSAPIBody.class);
        when(payOrderWeiXinJSAPIBody.getWxConfigParam()).thenReturn(wxConfigParam1);
        when(payOrderWeiXinJSAPIBody.getWeChatBean()).thenReturn(weChatBean1);
        doNothing().when(payOrderWeiXinJSAPIBody).setWeChatBean((WeChatBean) any());
        doNothing().when(payOrderWeiXinJSAPIBody).setWxConfigParam((WXConfigParam) any());
        payOrderWeiXinJSAPIBody.setWeChatBean(weChatBean);
        payOrderWeiXinJSAPIBody.setWxConfigParam(wxConfigParam);
        payChannelAgentController.createPayOrderByWeChatJSAPI(payOrderWeiXinJSAPIBody);
    }
}

