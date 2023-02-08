package mao.aggregate_pay_transaction_service.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import mao.aggregate_pay_merchant_api.feign.AppFeignClient;
import mao.aggregate_pay_transaction_service.service.TransactionService;
import mao.aggregate_pay_transaction_service.vo.OrderConfirmVO;
import mao.tools_core.exception.BizException;
import mao.toolsdozer.utils.DozerUtils;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PayController.class})
@ExtendWith(SpringExtension.class)
class PayControllerTest
{
    @MockBean
    private AppFeignClient appFeignClient;

    @MockBean
    private DozerUtils dozerUtils;

    @Autowired
    private PayController payController;

    @MockBean
    private TransactionService transactionService;

    /**
     * Method under test: {@link PayController#createAlipayOrderForStore(OrderConfirmVO, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAlipayOrderForStore()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: appId为空
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:37)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createAlipayOrderForStore(PayController.java:131)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:652)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createAlipayOrderForStore(PayController.java:138)
        //   In order to prevent createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        PayController payController = new PayController();

        OrderConfirmVO orderConfirmVO = new OrderConfirmVO();
        orderConfirmVO.setAppId("42");
        orderConfirmVO.setBody("Not all who wander are lost");
        orderConfirmVO.setChannel("Channel");
        orderConfirmVO.setOpenId("42");
        orderConfirmVO.setStoreId("42");
        orderConfirmVO.setSubject("Hello from the Dreaming Spires");
        orderConfirmVO.setTotalAmount("10");
        orderConfirmVO.setTradeNo("Trade No");
        MockHttpServletRequest request = new MockHttpServletRequest();
        payController.createAlipayOrderForStore(orderConfirmVO, request, new Response());
    }

    /**
     * Method under test: {@link PayController#createAlipayOrderForStore(OrderConfirmVO, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAlipayOrderForStore2()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: appId为空
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:37)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createAlipayOrderForStore(PayController.java:131)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:652)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createAlipayOrderForStore(PayController.java:138)
        //   In order to prevent createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        PayController payController = new PayController();
        OrderConfirmVO orderConfirmVO = mock(OrderConfirmVO.class);
        when(orderConfirmVO.getTotalAmount()).thenReturn("10");
        when(orderConfirmVO.getAppId()).thenReturn("42");
        doNothing().when(orderConfirmVO).setAppId((String) any());
        doNothing().when(orderConfirmVO).setBody((String) any());
        doNothing().when(orderConfirmVO).setChannel((String) any());
        doNothing().when(orderConfirmVO).setOpenId((String) any());
        doNothing().when(orderConfirmVO).setStoreId((String) any());
        doNothing().when(orderConfirmVO).setSubject((String) any());
        doNothing().when(orderConfirmVO).setTotalAmount((String) any());
        doNothing().when(orderConfirmVO).setTradeNo((String) any());
        orderConfirmVO.setAppId("42");
        orderConfirmVO.setBody("Not all who wander are lost");
        orderConfirmVO.setChannel("Channel");
        orderConfirmVO.setOpenId("42");
        orderConfirmVO.setStoreId("42");
        orderConfirmVO.setSubject("Hello from the Dreaming Spires");
        orderConfirmVO.setTotalAmount("10");
        orderConfirmVO.setTradeNo("Trade No");
        MockHttpServletRequest request = new MockHttpServletRequest();
        payController.createAlipayOrderForStore(orderConfirmVO, request, new Response());
    }

    /**
     * Method under test: {@link PayController#createAlipayOrderForStore(OrderConfirmVO, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    void testCreateAlipayOrderForStore3()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: appId为空
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:37)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createAlipayOrderForStore(PayController.java:131)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:652)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        PayController payController = new PayController();
        OrderConfirmVO orderConfirmVO = mock(OrderConfirmVO.class);
        when(orderConfirmVO.getTotalAmount()).thenThrow(new BizException("An error occurred"));
        when(orderConfirmVO.getAppId()).thenReturn("42");
        doNothing().when(orderConfirmVO).setAppId((String) any());
        doNothing().when(orderConfirmVO).setBody((String) any());
        doNothing().when(orderConfirmVO).setChannel((String) any());
        doNothing().when(orderConfirmVO).setOpenId((String) any());
        doNothing().when(orderConfirmVO).setStoreId((String) any());
        doNothing().when(orderConfirmVO).setSubject((String) any());
        doNothing().when(orderConfirmVO).setTotalAmount((String) any());
        doNothing().when(orderConfirmVO).setTradeNo((String) any());
        orderConfirmVO.setAppId("42");
        orderConfirmVO.setBody("Not all who wander are lost");
        orderConfirmVO.setChannel("Channel");
        orderConfirmVO.setOpenId("42");
        orderConfirmVO.setStoreId("42");
        orderConfirmVO.setSubject("Hello from the Dreaming Spires");
        orderConfirmVO.setTotalAmount("10");
        orderConfirmVO.setTradeNo("Trade No");
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertThrows(BizException.class,
                () -> payController.createAlipayOrderForStore(orderConfirmVO, request, new Response()));
        verify(orderConfirmVO).getAppId();
        verify(orderConfirmVO).getTotalAmount();
        verify(orderConfirmVO).setAppId((String) any());
        verify(orderConfirmVO).setBody((String) any());
        verify(orderConfirmVO).setChannel((String) any());
        verify(orderConfirmVO).setOpenId((String) any());
        verify(orderConfirmVO).setStoreId((String) any());
        verify(orderConfirmVO).setSubject((String) any());
        verify(orderConfirmVO).setTotalAmount((String) any());
        verify(orderConfirmVO).setTradeNo((String) any());
    }

    /**
     * Method under test: {@link PayController#createAlipayOrderForStore(OrderConfirmVO, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAlipayOrderForStore4()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: appId为空
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:37)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createAlipayOrderForStore(PayController.java:131)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:652)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: appId为空
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:37)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createAlipayOrderForStore(PayController.java:131)
        //   In order to prevent createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAlipayOrderForStore(OrderConfirmVO, HttpServletRequest, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        PayController payController = new PayController();
        OrderConfirmVO orderConfirmVO = mock(OrderConfirmVO.class);
        when(orderConfirmVO.getTotalAmount()).thenThrow(new BizException("An error occurred"));
        when(orderConfirmVO.getAppId()).thenReturn("");
        doNothing().when(orderConfirmVO).setAppId((String) any());
        doNothing().when(orderConfirmVO).setBody((String) any());
        doNothing().when(orderConfirmVO).setChannel((String) any());
        doNothing().when(orderConfirmVO).setOpenId((String) any());
        doNothing().when(orderConfirmVO).setStoreId((String) any());
        doNothing().when(orderConfirmVO).setSubject((String) any());
        doNothing().when(orderConfirmVO).setTotalAmount((String) any());
        doNothing().when(orderConfirmVO).setTradeNo((String) any());
        orderConfirmVO.setAppId("42");
        orderConfirmVO.setBody("Not all who wander are lost");
        orderConfirmVO.setChannel("Channel");
        orderConfirmVO.setOpenId("42");
        orderConfirmVO.setStoreId("42");
        orderConfirmVO.setSubject("Hello from the Dreaming Spires");
        orderConfirmVO.setTotalAmount("10");
        orderConfirmVO.setTradeNo("Trade No");
        MockHttpServletRequest request = new MockHttpServletRequest();
        payController.createAlipayOrderForStore(orderConfirmVO, request, new Response());
    }

    /**
     * Method under test: {@link PayController#wxOAuth2CodeReturn(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWxOAuth2CodeReturn()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: syntax error, expect {, actual int, pos 0, fastjson-version 1.2.76
        //       at com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(JavaBeanDeserializer.java:506)
        //       at com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.parseRest(JavaBeanDeserializer.java:1624)
        //       at com.alibaba.fastjson.parser.deserializer.FastjsonASMDeserializer_1_PayOrderDTO.deserialze(null)
        //       at com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(JavaBeanDeserializer.java:287)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(DefaultJSONParser.java:705)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:394)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:298)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:588)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.wxOAuth2CodeReturn(PayController.java:176)
        //   In order to prevent wxOAuth2CodeReturn(String, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   wxOAuth2CodeReturn(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PayController()).wxOAuth2CodeReturn("Code", "MD");
    }

    /**
     * Method under test: {@link PayController#wxOAuth2CodeReturn(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWxOAuth2CodeReturn2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: syntax error, expect {, actual error, pos 0, fastjson-version 1.2.76
        //       at com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(JavaBeanDeserializer.java:506)
        //       at com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.parseRest(JavaBeanDeserializer.java:1624)
        //       at com.alibaba.fastjson.parser.deserializer.FastjsonASMDeserializer_1_PayOrderDTO.deserialze(null)
        //       at com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(JavaBeanDeserializer.java:287)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(DefaultJSONParser.java:705)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:394)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:298)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:588)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.wxOAuth2CodeReturn(PayController.java:176)
        //   In order to prevent wxOAuth2CodeReturn(String, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   wxOAuth2CodeReturn(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PayController()).wxOAuth2CodeReturn("foo", "foo");
    }

    /**
     * Method under test: {@link PayController#wxOAuth2CodeReturn(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWxOAuth2CodeReturn3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Last unit does not have enough valid bits
        //       at java.util.Base64$Decoder.decode0(Base64.java:734)
        //       at java.util.Base64$Decoder.decode(Base64.java:526)
        //       at java.util.Base64$Decoder.decode(Base64.java:549)
        //       at mao.aggregate_pay_common.utils.EncryptUtil.decodeUTF8StringBase64(EncryptUtil.java:87)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.wxOAuth2CodeReturn(PayController.java:176)
        //   In order to prevent wxOAuth2CodeReturn(String, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   wxOAuth2CodeReturn(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PayController()).wxOAuth2CodeReturn("Code", "State");
    }

    /**
     * Method under test: {@link PayController#wxOAuth2CodeReturn(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWxOAuth2CodeReturn4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: syntax error, expect {, actual error, pos 0, fastjson-version 1.2.76
        //       at com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(JavaBeanDeserializer.java:506)
        //       at com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.parseRest(JavaBeanDeserializer.java:1624)
        //       at com.alibaba.fastjson.parser.deserializer.FastjsonASMDeserializer_1_PayOrderDTO.deserialze(null)
        //       at com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(JavaBeanDeserializer.java:287)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(DefaultJSONParser.java:705)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:394)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:298)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:588)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.wxOAuth2CodeReturn(PayController.java:176)
        //   In order to prevent wxOAuth2CodeReturn(String, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   wxOAuth2CodeReturn(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PayController()).wxOAuth2CodeReturn("Code", "/wxpay");
    }

    /**
     * Method under test: {@link PayController#wxOAuth2CodeReturn(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWxOAuth2CodeReturn5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.PayController.wxOAuth2CodeReturn(PayController.java:178)
        //   In order to prevent wxOAuth2CodeReturn(String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   wxOAuth2CodeReturn(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PayController()).wxOAuth2CodeReturn("Code", "");
    }

    /**
     * Method under test: {@link PayController#createWXOrderForStore(OrderConfirmVO, javax.servlet.http.HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateWXOrderForStore()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: openId为空
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createWXOrderForStore(PayController.java:211)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:652)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent createWXOrderForStore(OrderConfirmVO, HttpServletRequest)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createWXOrderForStore(OrderConfirmVO, HttpServletRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createWXOrderForStore(PayController.java:216)
        //   In order to prevent createWXOrderForStore(OrderConfirmVO, HttpServletRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createWXOrderForStore(OrderConfirmVO, HttpServletRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        PayController payController = new PayController();

        OrderConfirmVO orderConfirmVO = new OrderConfirmVO();
        orderConfirmVO.setAppId("42");
        orderConfirmVO.setBody("Not all who wander are lost");
        orderConfirmVO.setChannel("Channel");
        orderConfirmVO.setOpenId("42");
        orderConfirmVO.setStoreId("42");
        orderConfirmVO.setSubject("Hello from the Dreaming Spires");
        orderConfirmVO.setTotalAmount("10");
        orderConfirmVO.setTradeNo("Trade No");
        payController.createWXOrderForStore(orderConfirmVO, new MockHttpServletRequest());
    }

    /**
     * Method under test: {@link PayController#createWXOrderForStore(OrderConfirmVO, javax.servlet.http.HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateWXOrderForStore2()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: openId为空
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createWXOrderForStore(PayController.java:211)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:652)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent createWXOrderForStore(OrderConfirmVO, HttpServletRequest)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createWXOrderForStore(OrderConfirmVO, HttpServletRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createWXOrderForStore(PayController.java:216)
        //   In order to prevent createWXOrderForStore(OrderConfirmVO, HttpServletRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createWXOrderForStore(OrderConfirmVO, HttpServletRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        PayController payController = new PayController();
        OrderConfirmVO orderConfirmVO = mock(OrderConfirmVO.class);
        when(orderConfirmVO.getAppId()).thenReturn("42");
        when(orderConfirmVO.getOpenId()).thenReturn("42");
        doNothing().when(orderConfirmVO).setAppId((String) any());
        doNothing().when(orderConfirmVO).setBody((String) any());
        doNothing().when(orderConfirmVO).setChannel((String) any());
        doNothing().when(orderConfirmVO).setOpenId((String) any());
        doNothing().when(orderConfirmVO).setStoreId((String) any());
        doNothing().when(orderConfirmVO).setSubject((String) any());
        doNothing().when(orderConfirmVO).setTotalAmount((String) any());
        doNothing().when(orderConfirmVO).setTradeNo((String) any());
        orderConfirmVO.setAppId("42");
        orderConfirmVO.setBody("Not all who wander are lost");
        orderConfirmVO.setChannel("Channel");
        orderConfirmVO.setOpenId("42");
        orderConfirmVO.setStoreId("42");
        orderConfirmVO.setSubject("Hello from the Dreaming Spires");
        orderConfirmVO.setTotalAmount("10");
        orderConfirmVO.setTradeNo("Trade No");
        payController.createWXOrderForStore(orderConfirmVO, new MockHttpServletRequest());
    }

    /**
     * Method under test: {@link PayController#createWXOrderForStore(OrderConfirmVO, javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testCreateWXOrderForStore3()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: openId为空
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createWXOrderForStore(PayController.java:211)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:652)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent createWXOrderForStore(OrderConfirmVO, HttpServletRequest)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createWXOrderForStore(OrderConfirmVO, HttpServletRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        PayController payController = new PayController();
        OrderConfirmVO orderConfirmVO = mock(OrderConfirmVO.class);
        when(orderConfirmVO.getAppId()).thenThrow(new BizException("An error occurred"));
        when(orderConfirmVO.getOpenId()).thenReturn("42");
        doNothing().when(orderConfirmVO).setAppId((String) any());
        doNothing().when(orderConfirmVO).setBody((String) any());
        doNothing().when(orderConfirmVO).setChannel((String) any());
        doNothing().when(orderConfirmVO).setOpenId((String) any());
        doNothing().when(orderConfirmVO).setStoreId((String) any());
        doNothing().when(orderConfirmVO).setSubject((String) any());
        doNothing().when(orderConfirmVO).setTotalAmount((String) any());
        doNothing().when(orderConfirmVO).setTradeNo((String) any());
        orderConfirmVO.setAppId("42");
        orderConfirmVO.setBody("Not all who wander are lost");
        orderConfirmVO.setChannel("Channel");
        orderConfirmVO.setOpenId("42");
        orderConfirmVO.setStoreId("42");
        orderConfirmVO.setSubject("Hello from the Dreaming Spires");
        orderConfirmVO.setTotalAmount("10");
        orderConfirmVO.setTradeNo("Trade No");
        assertThrows(BizException.class,
                () -> payController.createWXOrderForStore(orderConfirmVO, new MockHttpServletRequest()));
        verify(orderConfirmVO).getAppId();
        verify(orderConfirmVO).getOpenId();
        verify(orderConfirmVO).setAppId((String) any());
        verify(orderConfirmVO).setBody((String) any());
        verify(orderConfirmVO).setChannel((String) any());
        verify(orderConfirmVO).setOpenId((String) any());
        verify(orderConfirmVO).setStoreId((String) any());
        verify(orderConfirmVO).setSubject((String) any());
        verify(orderConfirmVO).setTotalAmount((String) any());
        verify(orderConfirmVO).setTradeNo((String) any());
    }

    /**
     * Method under test: {@link PayController#createWXOrderForStore(OrderConfirmVO, javax.servlet.http.HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateWXOrderForStore4()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: openId为空
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createWXOrderForStore(PayController.java:211)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:652)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent createWXOrderForStore(OrderConfirmVO, HttpServletRequest)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createWXOrderForStore(OrderConfirmVO, HttpServletRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: openId为空
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_transaction_service.controller.PayController.createWXOrderForStore(PayController.java:211)
        //   In order to prevent createWXOrderForStore(OrderConfirmVO, HttpServletRequest)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createWXOrderForStore(OrderConfirmVO, HttpServletRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        PayController payController = new PayController();
        OrderConfirmVO orderConfirmVO = mock(OrderConfirmVO.class);
        when(orderConfirmVO.getAppId()).thenThrow(new BizException("An error occurred"));
        when(orderConfirmVO.getOpenId()).thenReturn("");
        doNothing().when(orderConfirmVO).setAppId((String) any());
        doNothing().when(orderConfirmVO).setBody((String) any());
        doNothing().when(orderConfirmVO).setChannel((String) any());
        doNothing().when(orderConfirmVO).setOpenId((String) any());
        doNothing().when(orderConfirmVO).setStoreId((String) any());
        doNothing().when(orderConfirmVO).setSubject((String) any());
        doNothing().when(orderConfirmVO).setTotalAmount((String) any());
        doNothing().when(orderConfirmVO).setTradeNo((String) any());
        orderConfirmVO.setAppId("42");
        orderConfirmVO.setBody("Not all who wander are lost");
        orderConfirmVO.setChannel("Channel");
        orderConfirmVO.setOpenId("42");
        orderConfirmVO.setStoreId("42");
        orderConfirmVO.setSubject("Hello from the Dreaming Spires");
        orderConfirmVO.setTotalAmount("10");
        orderConfirmVO.setTradeNo("Trade No");
        payController.createWXOrderForStore(orderConfirmVO, new MockHttpServletRequest());
    }

    /**
     * Method under test: {@link PayController#payEntry(String, javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testPayEntry() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pay/pay-entry/{ticket}", "Ticket");
        MockMvcBuilders.standaloneSetup(this.payController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("forward:/pay-error-page"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/pay-error-page"));
    }

    /**
     * Method under test: {@link PayController#payEntry(String, javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testPayEntry2() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pay/pay-entry/{ticket}", "Uri Vars",
                "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.payController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("forward:/pay-error-page"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/pay-error-page"));
    }

    /**
     * Method under test: {@link PayController#payEntry(String, javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testPayEntry3() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pay/pay-entry/{ticket}", "pay",
                "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.payController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("forward:/pay-error-page"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/pay-error-page"));
    }

    /**
     * Method under test: {@link PayController#payEntry(String, javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testPayEntry4() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pay/pay-entry/{ticket}", 42,
                "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.payController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("forward:/pay-error-page"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/pay-error-page"));
    }
}

