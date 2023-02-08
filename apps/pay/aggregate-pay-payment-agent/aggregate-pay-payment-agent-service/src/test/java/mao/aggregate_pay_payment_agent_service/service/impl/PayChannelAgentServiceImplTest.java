package mao.aggregate_pay_payment_agent_service.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import mao.aggregate_pay_payment_agent_api.dto.AliConfigParam;
import mao.aggregate_pay_payment_agent_api.dto.AlipayBean;
import mao.aggregate_pay_payment_agent_api.dto.PaymentResponseDTO;
import mao.aggregate_pay_payment_agent_api.dto.WXConfigParam;
import mao.aggregate_pay_payment_agent_api.dto.WeChatBean;
import mao.aggregate_pay_payment_agent_api.enums.TradeStatus;
import mao.aggregate_pay_payment_agent_service.producer.PayProducer;
import mao.tools_core.exception.BizException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PayChannelAgentServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PayChannelAgentServiceImplTest
{
    @Autowired
    private PayChannelAgentServiceImpl payChannelAgentServiceImpl;

    @MockBean
    private PayProducer payProducer;

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#createPayOrderByAliWAP(AliConfigParam, AlipayBean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByAliWAP()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 支付宝确认支付失败
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.createPayOrderByAliWAP(PayChannelAgentServiceImpl.java:129)
        //   In order to prevent createPayOrderByAliWAP(AliConfigParam, AlipayBean)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByAliWAP(AliConfigParam, AlipayBean).
        //   See https://diff.blue/R013 to resolve this issue.

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
        this.payChannelAgentServiceImpl.createPayOrderByAliWAP(aliConfigParam, alipayBean);
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#createPayOrderByAliWAP(AliConfigParam, AlipayBean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByAliWAP2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 支付宝确认支付失败
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.createPayOrderByAliWAP(PayChannelAgentServiceImpl.java:129)
        //   In order to prevent createPayOrderByAliWAP(AliConfigParam, AlipayBean)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByAliWAP(AliConfigParam, AlipayBean).
        //   See https://diff.blue/R013 to resolve this issue.

        AliConfigParam aliConfigParam = mock(AliConfigParam.class);
        when(aliConfigParam.getAlipayPublicKey()).thenReturn("Alipay Public Key");
        when(aliConfigParam.getAppId()).thenReturn("42");
        when(aliConfigParam.getFormat()).thenReturn("Format");
        when(aliConfigParam.getNotifyUrl()).thenReturn("https://example.org/example");
        when(aliConfigParam.getReturnUrl()).thenReturn("https://example.org/example");
        when(aliConfigParam.getRsaPrivateKey()).thenReturn("Rsa Private Key");
        when(aliConfigParam.getSignType()).thenReturn("Sign Type");
        when(aliConfigParam.getUrl()).thenReturn("https://example.org/example");
        doNothing().when(aliConfigParam).setAlipayPublicKey((String) any());
        doNothing().when(aliConfigParam).setAppId((String) any());
        doNothing().when(aliConfigParam).setCharset((String) any());
        doNothing().when(aliConfigParam).setFormat((String) any());
        doNothing().when(aliConfigParam).setLogPath((String) any());
        doNothing().when(aliConfigParam).setNotifyUrl((String) any());
        doNothing().when(aliConfigParam).setReturnUrl((String) any());
        doNothing().when(aliConfigParam).setRsaPrivateKey((String) any());
        doNothing().when(aliConfigParam).setSignType((String) any());
        doNothing().when(aliConfigParam).setUrl((String) any());
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
        this.payChannelAgentServiceImpl.createPayOrderByAliWAP(aliConfigParam, alipayBean);
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#createPayOrderByAliWAP(AliConfigParam, AlipayBean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByAliWAP3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 支付宝确认支付失败
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.createPayOrderByAliWAP(PayChannelAgentServiceImpl.java:129)
        //   In order to prevent createPayOrderByAliWAP(AliConfigParam, AlipayBean)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByAliWAP(AliConfigParam, AlipayBean).
        //   See https://diff.blue/R013 to resolve this issue.

        AliConfigParam aliConfigParam = mock(AliConfigParam.class);
        when(aliConfigParam.getAlipayPublicKey()).thenReturn("Alipay Public Key");
        when(aliConfigParam.getAppId()).thenReturn("42");
        when(aliConfigParam.getFormat()).thenReturn("");
        when(aliConfigParam.getNotifyUrl()).thenReturn("https://example.org/example");
        when(aliConfigParam.getReturnUrl()).thenReturn("https://example.org/example");
        when(aliConfigParam.getRsaPrivateKey()).thenReturn("Rsa Private Key");
        when(aliConfigParam.getSignType()).thenReturn("Sign Type");
        when(aliConfigParam.getUrl()).thenReturn("https://example.org/example");
        doNothing().when(aliConfigParam).setAlipayPublicKey((String) any());
        doNothing().when(aliConfigParam).setAppId((String) any());
        doNothing().when(aliConfigParam).setCharset((String) any());
        doNothing().when(aliConfigParam).setFormat((String) any());
        doNothing().when(aliConfigParam).setLogPath((String) any());
        doNothing().when(aliConfigParam).setNotifyUrl((String) any());
        doNothing().when(aliConfigParam).setReturnUrl((String) any());
        doNothing().when(aliConfigParam).setRsaPrivateKey((String) any());
        doNothing().when(aliConfigParam).setSignType((String) any());
        doNothing().when(aliConfigParam).setUrl((String) any());
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
        this.payChannelAgentServiceImpl.createPayOrderByAliWAP(aliConfigParam, alipayBean);
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#createPayOrderByAliWAP(AliConfigParam, AlipayBean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByAliWAP4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 支付宝确认支付失败
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.createPayOrderByAliWAP(PayChannelAgentServiceImpl.java:129)
        //   In order to prevent createPayOrderByAliWAP(AliConfigParam, AlipayBean)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByAliWAP(AliConfigParam, AlipayBean).
        //   See https://diff.blue/R013 to resolve this issue.

        AliConfigParam aliConfigParam = mock(AliConfigParam.class);
        when(aliConfigParam.getAlipayPublicKey()).thenReturn("Alipay Public Key");
        when(aliConfigParam.getAppId()).thenReturn("42");
        when(aliConfigParam.getFormat()).thenReturn("Format");
        when(aliConfigParam.getNotifyUrl()).thenReturn("https://example.org/example");
        when(aliConfigParam.getReturnUrl()).thenReturn("https://example.org/example");
        when(aliConfigParam.getRsaPrivateKey()).thenReturn("Rsa Private Key");
        when(aliConfigParam.getSignType()).thenReturn("");
        when(aliConfigParam.getUrl()).thenReturn("https://example.org/example");
        doNothing().when(aliConfigParam).setAlipayPublicKey((String) any());
        doNothing().when(aliConfigParam).setAppId((String) any());
        doNothing().when(aliConfigParam).setCharset((String) any());
        doNothing().when(aliConfigParam).setFormat((String) any());
        doNothing().when(aliConfigParam).setLogPath((String) any());
        doNothing().when(aliConfigParam).setNotifyUrl((String) any());
        doNothing().when(aliConfigParam).setReturnUrl((String) any());
        doNothing().when(aliConfigParam).setRsaPrivateKey((String) any());
        doNothing().when(aliConfigParam).setSignType((String) any());
        doNothing().when(aliConfigParam).setUrl((String) any());
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
        this.payChannelAgentServiceImpl.createPayOrderByAliWAP(aliConfigParam, alipayBean);
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#createPayOrderByAliWAP(AliConfigParam, AlipayBean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByAliWAP5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 支付宝确认支付失败
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.createPayOrderByAliWAP(PayChannelAgentServiceImpl.java:129)
        //   In order to prevent createPayOrderByAliWAP(AliConfigParam, AlipayBean)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByAliWAP(AliConfigParam, AlipayBean).
        //   See https://diff.blue/R013 to resolve this issue.

        AliConfigParam aliConfigParam = mock(AliConfigParam.class);
        when(aliConfigParam.getCharset()).thenReturn("UTF-8");
        when(aliConfigParam.getLogPath()).thenReturn("Log Path");
        when(aliConfigParam.getAlipayPublicKey()).thenReturn("Alipay Public Key");
        when(aliConfigParam.getAppId()).thenReturn("42");
        when(aliConfigParam.getFormat()).thenReturn("Format");
        when(aliConfigParam.getNotifyUrl()).thenReturn("https://example.org/example");
        when(aliConfigParam.getReturnUrl()).thenReturn("https://example.org/example");
        when(aliConfigParam.getRsaPrivateKey()).thenReturn("Rsa Private Key");
        when(aliConfigParam.getSignType()).thenReturn("Sign Type");
        when(aliConfigParam.getUrl()).thenReturn("https://example.org/example");
        doNothing().when(aliConfigParam).setAlipayPublicKey((String) any());
        doNothing().when(aliConfigParam).setAppId((String) any());
        doNothing().when(aliConfigParam).setCharset((String) any());
        doNothing().when(aliConfigParam).setFormat((String) any());
        doNothing().when(aliConfigParam).setLogPath((String) any());
        doNothing().when(aliConfigParam).setNotifyUrl((String) any());
        doNothing().when(aliConfigParam).setReturnUrl((String) any());
        doNothing().when(aliConfigParam).setRsaPrivateKey((String) any());
        doNothing().when(aliConfigParam).setSignType((String) any());
        doNothing().when(aliConfigParam).setUrl((String) any());
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
        AlipayBean alipayBean = mock(AlipayBean.class);
        when(alipayBean.getStoreId()).thenReturn(123L);
        when(alipayBean.getAttach()).thenReturn("Attach");
        when(alipayBean.getBody()).thenReturn("Not all who wander are lost");
        when(alipayBean.getExpireTime()).thenReturn("Expire Time");
        when(alipayBean.getOutTradeNo()).thenReturn("Out Trade No");
        when(alipayBean.getProductCode()).thenReturn("Product Code");
        when(alipayBean.getSubject()).thenReturn("Hello from the Dreaming Spires");
        when(alipayBean.getTimestamp()).thenReturn("Timestamp");
        when(alipayBean.getTotalAmount()).thenReturn("10");
        doNothing().when(alipayBean).setAttach((String) any());
        doNothing().when(alipayBean).setBody((String) any());
        doNothing().when(alipayBean).setExpireTime((String) any());
        doNothing().when(alipayBean).setOutTradeNo((String) any());
        doNothing().when(alipayBean).setProductCode((String) any());
        doNothing().when(alipayBean).setStoreId((Long) any());
        doNothing().when(alipayBean).setSubject((String) any());
        doNothing().when(alipayBean).setTimestamp((String) any());
        doNothing().when(alipayBean).setTotalAmount((String) any());
        alipayBean.setAttach("Attach");
        alipayBean.setBody("Not all who wander are lost");
        alipayBean.setExpireTime("Expire Time");
        alipayBean.setOutTradeNo("Out Trade No");
        alipayBean.setProductCode("Product Code");
        alipayBean.setStoreId(123L);
        alipayBean.setSubject("Hello from the Dreaming Spires");
        alipayBean.setTimestamp("Timestamp");
        alipayBean.setTotalAmount("10");
        this.payChannelAgentServiceImpl.createPayOrderByAliWAP(aliConfigParam, alipayBean);
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#createPayOrderByAliWAP(AliConfigParam, AlipayBean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByAliWAP6()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 支付宝确认支付失败
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.createPayOrderByAliWAP(PayChannelAgentServiceImpl.java:129)
        //   In order to prevent createPayOrderByAliWAP(AliConfigParam, AlipayBean)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByAliWAP(AliConfigParam, AlipayBean).
        //   See https://diff.blue/R013 to resolve this issue.

        AliConfigParam aliConfigParam = mock(AliConfigParam.class);
        when(aliConfigParam.getCharset()).thenReturn("支付宝请求参数：");
        when(aliConfigParam.getLogPath()).thenReturn("Log Path");
        when(aliConfigParam.getAlipayPublicKey()).thenReturn("Alipay Public Key");
        when(aliConfigParam.getAppId()).thenReturn("42");
        when(aliConfigParam.getFormat()).thenReturn("Format");
        when(aliConfigParam.getNotifyUrl()).thenReturn("https://example.org/example");
        when(aliConfigParam.getReturnUrl()).thenReturn("https://example.org/example");
        when(aliConfigParam.getRsaPrivateKey()).thenReturn("Rsa Private Key");
        when(aliConfigParam.getSignType()).thenReturn("Sign Type");
        when(aliConfigParam.getUrl()).thenReturn("https://example.org/example");
        doNothing().when(aliConfigParam).setAlipayPublicKey((String) any());
        doNothing().when(aliConfigParam).setAppId((String) any());
        doNothing().when(aliConfigParam).setCharset((String) any());
        doNothing().when(aliConfigParam).setFormat((String) any());
        doNothing().when(aliConfigParam).setLogPath((String) any());
        doNothing().when(aliConfigParam).setNotifyUrl((String) any());
        doNothing().when(aliConfigParam).setReturnUrl((String) any());
        doNothing().when(aliConfigParam).setRsaPrivateKey((String) any());
        doNothing().when(aliConfigParam).setSignType((String) any());
        doNothing().when(aliConfigParam).setUrl((String) any());
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
        AlipayBean alipayBean = mock(AlipayBean.class);
        when(alipayBean.getStoreId()).thenReturn(123L);
        when(alipayBean.getAttach()).thenReturn("Attach");
        when(alipayBean.getBody()).thenReturn("Not all who wander are lost");
        when(alipayBean.getExpireTime()).thenReturn("Expire Time");
        when(alipayBean.getOutTradeNo()).thenReturn("Out Trade No");
        when(alipayBean.getProductCode()).thenReturn("Product Code");
        when(alipayBean.getSubject()).thenReturn("Hello from the Dreaming Spires");
        when(alipayBean.getTimestamp()).thenReturn("Timestamp");
        when(alipayBean.getTotalAmount()).thenReturn("10");
        doNothing().when(alipayBean).setAttach((String) any());
        doNothing().when(alipayBean).setBody((String) any());
        doNothing().when(alipayBean).setExpireTime((String) any());
        doNothing().when(alipayBean).setOutTradeNo((String) any());
        doNothing().when(alipayBean).setProductCode((String) any());
        doNothing().when(alipayBean).setStoreId((Long) any());
        doNothing().when(alipayBean).setSubject((String) any());
        doNothing().when(alipayBean).setTimestamp((String) any());
        doNothing().when(alipayBean).setTotalAmount((String) any());
        alipayBean.setAttach("Attach");
        alipayBean.setBody("Not all who wander are lost");
        alipayBean.setExpireTime("Expire Time");
        alipayBean.setOutTradeNo("Out Trade No");
        alipayBean.setProductCode("Product Code");
        alipayBean.setStoreId(123L);
        alipayBean.setSubject("Hello from the Dreaming Spires");
        alipayBean.setTimestamp("Timestamp");
        alipayBean.setTotalAmount("10");
        this.payChannelAgentServiceImpl.createPayOrderByAliWAP(aliConfigParam, alipayBean);
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#queryPayOrderByAli(AliConfigParam, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPayOrderByAli()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: com.alipay.api.AlipayApiException: Sign Type is Not Support : signType=Sign Type
        //       at com.alipay.api.DefaultSigner.sign(DefaultSigner.java:28)
        //       at com.alipay.api.AbstractAlipayClient.getRequestHolderWithSign(AbstractAlipayClient.java:526)
        //       at com.alipay.api.AbstractAlipayClient.doPost(AbstractAlipayClient.java:669)
        //       at com.alipay.api.AbstractAlipayClient._execute(AbstractAlipayClient.java:607)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:108)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:95)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:89)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.queryPayOrderByAli(PayChannelAgentServiceImpl.java:166)
        //   In order to prevent queryPayOrderByAli(AliConfigParam, String)
        //   from throwing RuntimeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPayOrderByAli(AliConfigParam, String).
        //   See https://diff.blue/R013 to resolve this issue.

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
        this.payChannelAgentServiceImpl.queryPayOrderByAli(aliConfigParam, "Out Trade No");
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#queryPayOrderByAli(AliConfigParam, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPayOrderByAli2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: com.alipay.api.AlipayApiException: Sign Type is Not Support : signType=Sign Type
        //       at com.alipay.api.DefaultSigner.sign(DefaultSigner.java:28)
        //       at com.alipay.api.AbstractAlipayClient.getRequestHolderWithSign(AbstractAlipayClient.java:526)
        //       at com.alipay.api.AbstractAlipayClient.doPost(AbstractAlipayClient.java:669)
        //       at com.alipay.api.AbstractAlipayClient._execute(AbstractAlipayClient.java:607)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:108)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:95)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:89)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.queryPayOrderByAli(PayChannelAgentServiceImpl.java:166)
        //   In order to prevent queryPayOrderByAli(AliConfigParam, String)
        //   from throwing RuntimeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPayOrderByAli(AliConfigParam, String).
        //   See https://diff.blue/R013 to resolve this issue.

        AliConfigParam aliConfigParam = mock(AliConfigParam.class);
        when(aliConfigParam.getAlipayPublicKey()).thenReturn("Alipay Public Key");
        when(aliConfigParam.getSignType()).thenReturn("Sign Type");
        when(aliConfigParam.getAppId()).thenReturn("42");
        when(aliConfigParam.getCharset()).thenReturn("UTF-8");
        when(aliConfigParam.getFormat()).thenReturn("Format");
        when(aliConfigParam.getRsaPrivateKey()).thenReturn("Rsa Private Key");
        when(aliConfigParam.getUrl()).thenReturn("https://example.org/example");
        doNothing().when(aliConfigParam).setAlipayPublicKey((String) any());
        doNothing().when(aliConfigParam).setAppId((String) any());
        doNothing().when(aliConfigParam).setCharset((String) any());
        doNothing().when(aliConfigParam).setFormat((String) any());
        doNothing().when(aliConfigParam).setLogPath((String) any());
        doNothing().when(aliConfigParam).setNotifyUrl((String) any());
        doNothing().when(aliConfigParam).setReturnUrl((String) any());
        doNothing().when(aliConfigParam).setRsaPrivateKey((String) any());
        doNothing().when(aliConfigParam).setSignType((String) any());
        doNothing().when(aliConfigParam).setUrl((String) any());
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
        this.payChannelAgentServiceImpl.queryPayOrderByAli(aliConfigParam, "Out Trade No");
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#queryPayOrderByAli(AliConfigParam, String)}
     */
    @Test
    void testQueryPayOrderByAli3()
    {
        AliConfigParam aliConfigParam = mock(AliConfigParam.class);
        when(aliConfigParam.getAlipayPublicKey()).thenThrow(new BizException("An error occurred"));
        when(aliConfigParam.getSignType()).thenThrow(new BizException("An error occurred"));
        when(aliConfigParam.getAppId()).thenReturn("42");
        when(aliConfigParam.getCharset()).thenReturn("UTF-8");
        when(aliConfigParam.getFormat()).thenReturn("Format");
        when(aliConfigParam.getRsaPrivateKey()).thenReturn("Rsa Private Key");
        when(aliConfigParam.getUrl()).thenReturn("https://example.org/example");
        doNothing().when(aliConfigParam).setAlipayPublicKey((String) any());
        doNothing().when(aliConfigParam).setAppId((String) any());
        doNothing().when(aliConfigParam).setCharset((String) any());
        doNothing().when(aliConfigParam).setFormat((String) any());
        doNothing().when(aliConfigParam).setLogPath((String) any());
        doNothing().when(aliConfigParam).setNotifyUrl((String) any());
        doNothing().when(aliConfigParam).setReturnUrl((String) any());
        doNothing().when(aliConfigParam).setRsaPrivateKey((String) any());
        doNothing().when(aliConfigParam).setSignType((String) any());
        doNothing().when(aliConfigParam).setUrl((String) any());
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
        assertThrows(BizException.class,
                () -> this.payChannelAgentServiceImpl.queryPayOrderByAli(aliConfigParam, "Out Trade No"));
        verify(aliConfigParam).getAlipayPublicKey();
        verify(aliConfigParam).getAppId();
        verify(aliConfigParam).getCharset();
        verify(aliConfigParam).getFormat();
        verify(aliConfigParam).getRsaPrivateKey();
        verify(aliConfigParam).getUrl();
        verify(aliConfigParam).setAlipayPublicKey((String) any());
        verify(aliConfigParam).setAppId((String) any());
        verify(aliConfigParam).setCharset((String) any());
        verify(aliConfigParam).setFormat((String) any());
        verify(aliConfigParam).setLogPath((String) any());
        verify(aliConfigParam).setNotifyUrl((String) any());
        verify(aliConfigParam).setReturnUrl((String) any());
        verify(aliConfigParam).setRsaPrivateKey((String) any());
        verify(aliConfigParam).setSignType((String) any());
        verify(aliConfigParam).setUrl((String) any());
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#queryPayOrderByAli(AliConfigParam, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPayOrderByAli4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: com.alipay.api.AlipayApiException: RSA私钥格式不正确，请检查是否正确配置了PKCS8格式的私钥
        //       at com.alipay.api.DefaultSigner.sign(DefaultSigner.java:28)
        //       at com.alipay.api.AbstractAlipayClient.getRequestHolderWithSign(AbstractAlipayClient.java:526)
        //       at com.alipay.api.AbstractAlipayClient.doPost(AbstractAlipayClient.java:669)
        //       at com.alipay.api.AbstractAlipayClient._execute(AbstractAlipayClient.java:607)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:108)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:95)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:89)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.queryPayOrderByAli(PayChannelAgentServiceImpl.java:166)
        //   In order to prevent queryPayOrderByAli(AliConfigParam, String)
        //   from throwing RuntimeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPayOrderByAli(AliConfigParam, String).
        //   See https://diff.blue/R013 to resolve this issue.

        AliConfigParam aliConfigParam = mock(AliConfigParam.class);
        when(aliConfigParam.getAlipayPublicKey()).thenReturn("Alipay Public Key");
        when(aliConfigParam.getSignType()).thenReturn("");
        when(aliConfigParam.getAppId()).thenReturn("42");
        when(aliConfigParam.getCharset()).thenReturn("UTF-8");
        when(aliConfigParam.getFormat()).thenReturn("Format");
        when(aliConfigParam.getRsaPrivateKey()).thenReturn("Rsa Private Key");
        when(aliConfigParam.getUrl()).thenReturn("https://example.org/example");
        doNothing().when(aliConfigParam).setAlipayPublicKey((String) any());
        doNothing().when(aliConfigParam).setAppId((String) any());
        doNothing().when(aliConfigParam).setCharset((String) any());
        doNothing().when(aliConfigParam).setFormat((String) any());
        doNothing().when(aliConfigParam).setLogPath((String) any());
        doNothing().when(aliConfigParam).setNotifyUrl((String) any());
        doNothing().when(aliConfigParam).setReturnUrl((String) any());
        doNothing().when(aliConfigParam).setRsaPrivateKey((String) any());
        doNothing().when(aliConfigParam).setSignType((String) any());
        doNothing().when(aliConfigParam).setUrl((String) any());
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
        this.payChannelAgentServiceImpl.queryPayOrderByAli(aliConfigParam, "Out Trade No");
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#queryPayOrderByAli(AliConfigParam, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPayOrderByAli5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: com.alipay.api.AlipayApiException: Sign Type is Not Support : signType=Sign Type
        //       at com.alipay.api.DefaultSigner.sign(DefaultSigner.java:28)
        //       at com.alipay.api.AbstractAlipayClient.getRequestHolderWithSign(AbstractAlipayClient.java:526)
        //       at com.alipay.api.AbstractAlipayClient.doPost(AbstractAlipayClient.java:669)
        //       at com.alipay.api.AbstractAlipayClient._execute(AbstractAlipayClient.java:607)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:108)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:95)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:89)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.queryPayOrderByAli(PayChannelAgentServiceImpl.java:166)
        //   In order to prevent queryPayOrderByAli(AliConfigParam, String)
        //   from throwing RuntimeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPayOrderByAli(AliConfigParam, String).
        //   See https://diff.blue/R013 to resolve this issue.

        AliConfigParam aliConfigParam = mock(AliConfigParam.class);
        when(aliConfigParam.getAlipayPublicKey()).thenReturn("Alipay Public Key");
        when(aliConfigParam.getSignType()).thenReturn("Sign Type");
        when(aliConfigParam.getAppId()).thenReturn("42");
        when(aliConfigParam.getCharset()).thenReturn("");
        when(aliConfigParam.getFormat()).thenReturn("Format");
        when(aliConfigParam.getRsaPrivateKey()).thenReturn("Rsa Private Key");
        when(aliConfigParam.getUrl()).thenReturn("https://example.org/example");
        doNothing().when(aliConfigParam).setAlipayPublicKey((String) any());
        doNothing().when(aliConfigParam).setAppId((String) any());
        doNothing().when(aliConfigParam).setCharset((String) any());
        doNothing().when(aliConfigParam).setFormat((String) any());
        doNothing().when(aliConfigParam).setLogPath((String) any());
        doNothing().when(aliConfigParam).setNotifyUrl((String) any());
        doNothing().when(aliConfigParam).setReturnUrl((String) any());
        doNothing().when(aliConfigParam).setRsaPrivateKey((String) any());
        doNothing().when(aliConfigParam).setSignType((String) any());
        doNothing().when(aliConfigParam).setUrl((String) any());
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
        this.payChannelAgentServiceImpl.queryPayOrderByAli(aliConfigParam, "Out Trade No");
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#queryPayOrderByAli(AliConfigParam, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPayOrderByAli6()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: com.alipay.api.AlipayApiException: Sign Type is Not Support : signType=Sign Type
        //       at com.alipay.api.DefaultSigner.sign(DefaultSigner.java:28)
        //       at com.alipay.api.AbstractAlipayClient.getRequestHolderWithSign(AbstractAlipayClient.java:526)
        //       at com.alipay.api.AbstractAlipayClient.doPost(AbstractAlipayClient.java:669)
        //       at com.alipay.api.AbstractAlipayClient._execute(AbstractAlipayClient.java:607)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:108)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:95)
        //       at com.alipay.api.AbstractAlipayClient.execute(AbstractAlipayClient.java:89)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.queryPayOrderByAli(PayChannelAgentServiceImpl.java:166)
        //   In order to prevent queryPayOrderByAli(AliConfigParam, String)
        //   from throwing RuntimeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPayOrderByAli(AliConfigParam, String).
        //   See https://diff.blue/R013 to resolve this issue.

        AliConfigParam aliConfigParam = mock(AliConfigParam.class);
        when(aliConfigParam.getAlipayPublicKey()).thenReturn("Alipay Public Key");
        when(aliConfigParam.getSignType()).thenReturn("Sign Type");
        when(aliConfigParam.getAppId()).thenReturn("42");
        when(aliConfigParam.getCharset()).thenReturn("UTF-8");
        when(aliConfigParam.getFormat()).thenReturn("");
        when(aliConfigParam.getRsaPrivateKey()).thenReturn("Rsa Private Key");
        when(aliConfigParam.getUrl()).thenReturn("https://example.org/example");
        doNothing().when(aliConfigParam).setAlipayPublicKey((String) any());
        doNothing().when(aliConfigParam).setAppId((String) any());
        doNothing().when(aliConfigParam).setCharset((String) any());
        doNothing().when(aliConfigParam).setFormat((String) any());
        doNothing().when(aliConfigParam).setLogPath((String) any());
        doNothing().when(aliConfigParam).setNotifyUrl((String) any());
        doNothing().when(aliConfigParam).setReturnUrl((String) any());
        doNothing().when(aliConfigParam).setRsaPrivateKey((String) any());
        doNothing().when(aliConfigParam).setSignType((String) any());
        doNothing().when(aliConfigParam).setUrl((String) any());
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
        this.payChannelAgentServiceImpl.queryPayOrderByAli(aliConfigParam, "Out Trade No");
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#createPayOrderByWeChatJSAPI(WXConfigParam, WeChatBean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByWeChatJSAPI()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 微信下单失败
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.createPayOrderByWeChatJSAPI(PayChannelAgentServiceImpl.java:269)
        //   In order to prevent createPayOrderByWeChatJSAPI(WXConfigParam, WeChatBean)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByWeChatJSAPI(WXConfigParam, WeChatBean).
        //   See https://diff.blue/R013 to resolve this issue.

        WXConfigParam wxConfigParam = new WXConfigParam();
        wxConfigParam.setAppId("42");
        wxConfigParam.setAppSecret("App Secret");
        wxConfigParam.setKey("Key");
        wxConfigParam.setMchId("42");
        wxConfigParam.setReturnUrl("https://example.org/example");

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
        this.payChannelAgentServiceImpl.createPayOrderByWeChatJSAPI(wxConfigParam, weChatBean);
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#createPayOrderByWeChatJSAPI(WXConfigParam, WeChatBean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByWeChatJSAPI2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 微信下单失败
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.createPayOrderByWeChatJSAPI(PayChannelAgentServiceImpl.java:269)
        //   In order to prevent createPayOrderByWeChatJSAPI(WXConfigParam, WeChatBean)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByWeChatJSAPI(WXConfigParam, WeChatBean).
        //   See https://diff.blue/R013 to resolve this issue.

        WXConfigParam wxConfigParam = mock(WXConfigParam.class);
        when(wxConfigParam.getAppId()).thenReturn("42");
        when(wxConfigParam.getKey()).thenReturn("Key");
        when(wxConfigParam.getMchId()).thenReturn("42");
        doNothing().when(wxConfigParam).setAppId((String) any());
        doNothing().when(wxConfigParam).setAppSecret((String) any());
        doNothing().when(wxConfigParam).setKey((String) any());
        doNothing().when(wxConfigParam).setMchId((String) any());
        doNothing().when(wxConfigParam).setReturnUrl((String) any());
        wxConfigParam.setAppId("42");
        wxConfigParam.setAppSecret("App Secret");
        wxConfigParam.setKey("Key");
        wxConfigParam.setMchId("42");
        wxConfigParam.setReturnUrl("https://example.org/example");

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
        this.payChannelAgentServiceImpl.createPayOrderByWeChatJSAPI(wxConfigParam, weChatBean);
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#createPayOrderByWeChatJSAPI(WXConfigParam, WeChatBean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByWeChatJSAPI3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 微信下单失败
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.createPayOrderByWeChatJSAPI(PayChannelAgentServiceImpl.java:269)
        //   In order to prevent createPayOrderByWeChatJSAPI(WXConfigParam, WeChatBean)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByWeChatJSAPI(WXConfigParam, WeChatBean).
        //   See https://diff.blue/R013 to resolve this issue.

        WXConfigParam wxConfigParam = mock(WXConfigParam.class);
        when(wxConfigParam.getAppId()).thenReturn("");
        when(wxConfigParam.getKey()).thenReturn("Key");
        when(wxConfigParam.getMchId()).thenReturn("42");
        doNothing().when(wxConfigParam).setAppId((String) any());
        doNothing().when(wxConfigParam).setAppSecret((String) any());
        doNothing().when(wxConfigParam).setKey((String) any());
        doNothing().when(wxConfigParam).setMchId((String) any());
        doNothing().when(wxConfigParam).setReturnUrl((String) any());
        wxConfigParam.setAppId("42");
        wxConfigParam.setAppSecret("App Secret");
        wxConfigParam.setKey("Key");
        wxConfigParam.setMchId("42");
        wxConfigParam.setReturnUrl("https://example.org/example");

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
        this.payChannelAgentServiceImpl.createPayOrderByWeChatJSAPI(wxConfigParam, weChatBean);
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#createPayOrderByWeChatJSAPI(WXConfigParam, WeChatBean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayOrderByWeChatJSAPI4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 微信下单失败
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_payment_agent_service.service.impl.PayChannelAgentServiceImpl.createPayOrderByWeChatJSAPI(PayChannelAgentServiceImpl.java:269)
        //   In order to prevent createPayOrderByWeChatJSAPI(WXConfigParam, WeChatBean)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayOrderByWeChatJSAPI(WXConfigParam, WeChatBean).
        //   See https://diff.blue/R013 to resolve this issue.

        WXConfigParam wxConfigParam = mock(WXConfigParam.class);
        when(wxConfigParam.getAppId()).thenReturn("42");
        when(wxConfigParam.getKey()).thenReturn("");
        when(wxConfigParam.getMchId()).thenReturn("42");
        doNothing().when(wxConfigParam).setAppId((String) any());
        doNothing().when(wxConfigParam).setAppSecret((String) any());
        doNothing().when(wxConfigParam).setKey((String) any());
        doNothing().when(wxConfigParam).setMchId((String) any());
        doNothing().when(wxConfigParam).setReturnUrl((String) any());
        wxConfigParam.setAppId("42");
        wxConfigParam.setAppSecret("App Secret");
        wxConfigParam.setKey("Key");
        wxConfigParam.setMchId("42");
        wxConfigParam.setReturnUrl("https://example.org/example");

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
        this.payChannelAgentServiceImpl.createPayOrderByWeChatJSAPI(wxConfigParam, weChatBean);
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#queryPayOrderByWeChat(WXConfigParam, String)}
     */
    @Test
    void testQueryPayOrderByWeChat()
    {
        WXConfigParam wxConfigParam = new WXConfigParam();
        wxConfigParam.setAppId("42");
        wxConfigParam.setAppSecret("App Secret");
        wxConfigParam.setKey("Key");
        wxConfigParam.setMchId("42");
        wxConfigParam.setReturnUrl("https://example.org/example");
        PaymentResponseDTO<String> actualQueryPayOrderByWeChatResult = this.payChannelAgentServiceImpl
                .queryPayOrderByWeChat(wxConfigParam, "Out Trade No");
        assertEquals("999999", actualQueryPayOrderByWeChatResult.getCode());
        assertEquals(TradeStatus.UNKNOWN, actualQueryPayOrderByWeChatResult.getTradeState());
        assertEquals("Out Trade No", actualQueryPayOrderByWeChatResult.getOutTradeNo());
        assertEquals("调用微信查询订单异常", actualQueryPayOrderByWeChatResult.getMsg());
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#queryPayOrderByWeChat(WXConfigParam, String)}
     */
    @Test
    void testQueryPayOrderByWeChat2()
    {
        WXConfigParam wxConfigParam = mock(WXConfigParam.class);
        when(wxConfigParam.getAppId()).thenReturn("");
        when(wxConfigParam.getKey()).thenReturn("Key");
        when(wxConfigParam.getMchId()).thenReturn("42");
        doNothing().when(wxConfigParam).setAppId((String) any());
        doNothing().when(wxConfigParam).setAppSecret((String) any());
        doNothing().when(wxConfigParam).setKey((String) any());
        doNothing().when(wxConfigParam).setMchId((String) any());
        doNothing().when(wxConfigParam).setReturnUrl((String) any());
        wxConfigParam.setAppId("42");
        wxConfigParam.setAppSecret("App Secret");
        wxConfigParam.setKey("Key");
        wxConfigParam.setMchId("42");
        wxConfigParam.setReturnUrl("https://example.org/example");
        PaymentResponseDTO<String> actualQueryPayOrderByWeChatResult = this.payChannelAgentServiceImpl
                .queryPayOrderByWeChat(wxConfigParam, "Out Trade No");
        assertEquals("999999", actualQueryPayOrderByWeChatResult.getCode());
        assertEquals(TradeStatus.UNKNOWN, actualQueryPayOrderByWeChatResult.getTradeState());
        assertEquals("Out Trade No", actualQueryPayOrderByWeChatResult.getOutTradeNo());
        assertEquals("调用微信查询订单异常", actualQueryPayOrderByWeChatResult.getMsg());
        verify(wxConfigParam).getAppId();
        verify(wxConfigParam).getKey();
        verify(wxConfigParam, atLeast(1)).getMchId();
        verify(wxConfigParam).setAppId((String) any());
        verify(wxConfigParam).setAppSecret((String) any());
        verify(wxConfigParam).setKey((String) any());
        verify(wxConfigParam).setMchId((String) any());
        verify(wxConfigParam).setReturnUrl((String) any());
    }

    /**
     * Method under test: {@link PayChannelAgentServiceImpl#queryPayOrderByWeChat(WXConfigParam, String)}
     */
    @Test
    void testQueryPayOrderByWeChat3()
    {
        WXConfigParam wxConfigParam = mock(WXConfigParam.class);
        when(wxConfigParam.getAppId()).thenReturn("42");
        when(wxConfigParam.getKey()).thenReturn("");
        when(wxConfigParam.getMchId()).thenReturn("42");
        doNothing().when(wxConfigParam).setAppId((String) any());
        doNothing().when(wxConfigParam).setAppSecret((String) any());
        doNothing().when(wxConfigParam).setKey((String) any());
        doNothing().when(wxConfigParam).setMchId((String) any());
        doNothing().when(wxConfigParam).setReturnUrl((String) any());
        wxConfigParam.setAppId("42");
        wxConfigParam.setAppSecret("App Secret");
        wxConfigParam.setKey("Key");
        wxConfigParam.setMchId("42");
        wxConfigParam.setReturnUrl("https://example.org/example");
        PaymentResponseDTO<String> actualQueryPayOrderByWeChatResult = this.payChannelAgentServiceImpl
                .queryPayOrderByWeChat(wxConfigParam, "Out Trade No");
        assertEquals("999999", actualQueryPayOrderByWeChatResult.getCode());
        assertEquals(TradeStatus.UNKNOWN, actualQueryPayOrderByWeChatResult.getTradeState());
        assertEquals("Out Trade No", actualQueryPayOrderByWeChatResult.getOutTradeNo());
        assertEquals("调用微信查询订单异常", actualQueryPayOrderByWeChatResult.getMsg());
        verify(wxConfigParam).getAppId();
        verify(wxConfigParam).getKey();
        verify(wxConfigParam).getMchId();
        verify(wxConfigParam).setAppId((String) any());
        verify(wxConfigParam).setAppSecret((String) any());
        verify(wxConfigParam).setKey((String) any());
        verify(wxConfigParam).setMchId((String) any());
        verify(wxConfigParam).setReturnUrl((String) any());
    }
}

