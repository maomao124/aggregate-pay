package mao.aggregate_pay_payment_agent_service.producer.impl;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.alibaba.fastjson.support.spring.messaging.MappingFastJsonMessageConverter;

import java.util.HashSet;

import mao.aggregate_pay_payment_agent_api.dto.PaymentResponseDTO;
import mao.aggregate_pay_payment_agent_api.enums.TradeStatus;
import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.AccessChannel;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.impl.producer.DefaultMQProducerImpl;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.trace.AsyncTraceDispatcher;
import org.apache.rocketmq.client.trace.TraceDispatcher;
import org.apache.rocketmq.remoting.protocol.LanguageCode;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.MessagingException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {RocketMQPayProducer.class})
@ExtendWith(SpringExtension.class)
class RocketMQPayProducerTest
{
    @Autowired
    private RocketMQPayProducer rocketMQPayProducer;

    @MockBean
    private RocketMQTemplate rocketMQTemplate;

    /**
     * Method under test: {@link RocketMQPayProducer#payOrderNotice(PaymentResponseDTO)}
     */
    @Test
    void testPayOrderNotice()
    {
        when(this.rocketMQTemplate.syncSend((String) any(), (org.springframework.messaging.Message<?>) any(), anyLong(),
                anyInt())).thenReturn(new SendResult());
        this.rocketMQPayProducer.payOrderNotice(new PaymentResponseDTO<>());
        verify(this.rocketMQTemplate).syncSend((String) any(), (org.springframework.messaging.Message<?>) any(), anyLong(),
                anyInt());
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payOrderNotice(PaymentResponseDTO)}
     */
    @Test
    void testPayOrderNotice2()
    {
        when(this.rocketMQTemplate.syncSend((String) any(), (org.springframework.messaging.Message<?>) any(), anyLong(),
                anyInt())).thenReturn(new SendResult());
        this.rocketMQPayProducer.payOrderNotice(new PaymentResponseDTO<>("PAY_PAYMENT_ORDER", "PAY_PAYMENT_ORDER",
                "PAY_PAYMENT_ORDER", "PAY_PAYMENT_ORDER", TradeStatus.SUCCESS, "Not all who wander are lost"));
        verify(this.rocketMQTemplate).syncSend((String) any(), (org.springframework.messaging.Message<?>) any(), anyLong(),
                anyInt());
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payOrderNotice(PaymentResponseDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPayOrderNotice3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Payload must not be null
        //       at org.springframework.util.Assert.notNull(Assert.java:198)
        //       at org.springframework.messaging.support.MessageBuilder.<init>(MessageBuilder.java:57)
        //       at org.springframework.messaging.support.MessageBuilder.withPayload(MessageBuilder.java:189)
        //       at mao.aggregate_pay_payment_agent_service.producer.impl.RocketMQPayProducer.payOrderNotice(RocketMQPayProducer.java:44)
        //   In order to prevent payOrderNotice(PaymentResponseDTO)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   payOrderNotice(PaymentResponseDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.rocketMQTemplate.syncSend((String) any(), (org.springframework.messaging.Message<?>) any(), anyLong(),
                anyInt())).thenReturn(new SendResult());
        this.rocketMQPayProducer.payOrderNotice(null);
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payOrderNotice(PaymentResponseDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPayOrderNotice4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.creation.settings.CreationSettings, fieldName : mockSettings, write javaBean error, fastjson version 1.2.76, class com.diffblue.spring.isolation.framework.mocks.MockInvocationListener, fieldName : 0, write javaBean error, fastjson version 1.2.76, class org.mockito.codegen.RocketMQTemplate$MockitoMock$798037944, fieldName : 0, write javaBean error, fastjson version 1.2.76, class org.apache.rocketmq.client.consumer.DefaultLitePullConsumer, fieldName : consumer
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:541)
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:154)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.writeWithFieldName(JSONSerializer.java:360)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_2_MockMethodInterceptor.write(null)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_1_PaymentResponseDTO$MockitoMock$1980592089.write(null)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.write(JSONSerializer.java:312)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:793)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:731)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:688)
        //       at mao.aggregate_pay_payment_agent_service.producer.impl.RocketMQPayProducer.payOrderNotice(RocketMQPayProducer.java:47)
        //   In order to prevent payOrderNotice(PaymentResponseDTO)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   payOrderNotice(PaymentResponseDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.rocketMQTemplate.getDefaultDestination()).thenReturn("Default Destination");
        when(this.rocketMQTemplate.getCharset()).thenReturn("UTF-8");
        when(this.rocketMQTemplate.getConsumer()).thenReturn(new DefaultLitePullConsumer());
        when(this.rocketMQTemplate.getProducer()).thenReturn(new DefaultMQProducer());
        when(this.rocketMQTemplate.getMessageQueueSelector()).thenReturn(mock(MessageQueueSelector.class));
        when(this.rocketMQTemplate.getMessageConverter()).thenReturn(new MappingFastJsonMessageConverter());
        when(this.rocketMQTemplate.syncSend((String) any(), (org.springframework.messaging.Message<?>) any(), anyLong(),
                anyInt())).thenReturn(new SendResult());
        PaymentResponseDTO<String> paymentResponseDTO = (PaymentResponseDTO<String>) mock(PaymentResponseDTO.class);
        when(paymentResponseDTO.getContent()).thenReturn("Not all who wander are lost");
        when(paymentResponseDTO.getCode()).thenReturn("Code");
        this.rocketMQPayProducer.payOrderNotice(paymentResponseDTO);
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payOrderNotice(PaymentResponseDTO)}
     */
    @Test
    void testPayOrderNotice5()
    {
        when(this.rocketMQTemplate.getDefaultDestination()).thenReturn("Default Destination");
        when(this.rocketMQTemplate.getCharset()).thenReturn("UTF-8");
        when(this.rocketMQTemplate.getConsumer()).thenReturn(null);
        when(this.rocketMQTemplate.getProducer()).thenReturn(new DefaultMQProducer());
        when(this.rocketMQTemplate.getMessageQueueSelector()).thenReturn(mock(MessageQueueSelector.class));
        when(this.rocketMQTemplate.getMessageConverter()).thenReturn(new MappingFastJsonMessageConverter());
        when(this.rocketMQTemplate.syncSend((String) any(), (org.springframework.messaging.Message<?>) any(), anyLong(),
                anyInt())).thenReturn(new SendResult());
        PaymentResponseDTO<String> paymentResponseDTO = (PaymentResponseDTO<String>) mock(PaymentResponseDTO.class);
        when(paymentResponseDTO.getMsg()).thenReturn("Msg");
        when(paymentResponseDTO.getOutTradeNo()).thenReturn("Out Trade No");
        when(paymentResponseDTO.getTradeNo()).thenReturn("Trade No");
        when(paymentResponseDTO.getTradeState()).thenReturn(TradeStatus.SUCCESS);
        when(paymentResponseDTO.getContent()).thenReturn("Not all who wander are lost");
        when(paymentResponseDTO.getCode()).thenReturn("Code");
        this.rocketMQPayProducer.payOrderNotice(paymentResponseDTO);
        verify(this.rocketMQTemplate).getDefaultDestination();
        verify(this.rocketMQTemplate).getCharset();
        verify(this.rocketMQTemplate).getConsumer();
        verify(this.rocketMQTemplate).getProducer();
        verify(this.rocketMQTemplate).getMessageQueueSelector();
        verify(this.rocketMQTemplate).syncSend((String) any(), (org.springframework.messaging.Message<?>) any(), anyLong(),
                anyInt());
        verify(this.rocketMQTemplate).getMessageConverter();
        verify(paymentResponseDTO).getContent();
        verify(paymentResponseDTO).getCode();
        verify(paymentResponseDTO).getMsg();
        verify(paymentResponseDTO).getOutTradeNo();
        verify(paymentResponseDTO).getTradeNo();
        verify(paymentResponseDTO).getTradeState();
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payOrderNotice(PaymentResponseDTO)}
     */
    @Test
    void testPayOrderNotice6()
    {
        when(this.rocketMQTemplate.getDefaultDestination()).thenReturn("UUU://MQ_INST_UUU_UUU.xx");
        when(this.rocketMQTemplate.getCharset()).thenReturn("UTF-8");
        when(this.rocketMQTemplate.getConsumer()).thenReturn(null);
        when(this.rocketMQTemplate.getProducer()).thenReturn(new DefaultMQProducer());
        when(this.rocketMQTemplate.getMessageQueueSelector()).thenReturn(mock(MessageQueueSelector.class));
        when(this.rocketMQTemplate.getMessageConverter()).thenReturn(new MappingFastJsonMessageConverter());
        when(this.rocketMQTemplate.syncSend((String) any(), (org.springframework.messaging.Message<?>) any(), anyLong(),
                anyInt())).thenReturn(new SendResult());
        PaymentResponseDTO<String> paymentResponseDTO = (PaymentResponseDTO<String>) mock(PaymentResponseDTO.class);
        when(paymentResponseDTO.getMsg()).thenReturn("Msg");
        when(paymentResponseDTO.getOutTradeNo()).thenReturn("Out Trade No");
        when(paymentResponseDTO.getTradeNo()).thenReturn("Trade No");
        when(paymentResponseDTO.getTradeState()).thenReturn(TradeStatus.SUCCESS);
        when(paymentResponseDTO.getContent()).thenReturn("Not all who wander are lost");
        when(paymentResponseDTO.getCode()).thenReturn("Code");
        this.rocketMQPayProducer.payOrderNotice(paymentResponseDTO);
        verify(this.rocketMQTemplate).getDefaultDestination();
        verify(this.rocketMQTemplate).getCharset();
        verify(this.rocketMQTemplate).getConsumer();
        verify(this.rocketMQTemplate).getProducer();
        verify(this.rocketMQTemplate).getMessageQueueSelector();
        verify(this.rocketMQTemplate).syncSend((String) any(), (org.springframework.messaging.Message<?>) any(), anyLong(),
                anyInt());
        verify(this.rocketMQTemplate).getMessageConverter();
        verify(paymentResponseDTO).getContent();
        verify(paymentResponseDTO).getCode();
        verify(paymentResponseDTO).getMsg();
        verify(paymentResponseDTO).getOutTradeNo();
        verify(paymentResponseDTO).getTradeNo();
        verify(paymentResponseDTO).getTradeState();
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payOrderNotice(PaymentResponseDTO)}
     */
    @Test
    void testPayOrderNotice7()
    {
        when(this.rocketMQTemplate.getDefaultDestination()).thenReturn("支付渠道代理服务向mq发送订单查询的消息：{}");
        when(this.rocketMQTemplate.getCharset()).thenReturn("UTF-8");
        when(this.rocketMQTemplate.getConsumer()).thenReturn(null);
        when(this.rocketMQTemplate.getProducer()).thenReturn(new DefaultMQProducer());
        when(this.rocketMQTemplate.getMessageQueueSelector()).thenReturn(mock(MessageQueueSelector.class));
        when(this.rocketMQTemplate.getMessageConverter()).thenReturn(new MappingFastJsonMessageConverter());
        when(this.rocketMQTemplate.syncSend((String) any(), (org.springframework.messaging.Message<?>) any(), anyLong(),
                anyInt())).thenReturn(new SendResult());
        PaymentResponseDTO<String> paymentResponseDTO = (PaymentResponseDTO<String>) mock(PaymentResponseDTO.class);
        when(paymentResponseDTO.getMsg()).thenReturn("Msg");
        when(paymentResponseDTO.getOutTradeNo()).thenReturn("Out Trade No");
        when(paymentResponseDTO.getTradeNo()).thenReturn("Trade No");
        when(paymentResponseDTO.getTradeState()).thenReturn(TradeStatus.SUCCESS);
        when(paymentResponseDTO.getContent()).thenReturn("Not all who wander are lost");
        when(paymentResponseDTO.getCode()).thenReturn("Code");
        this.rocketMQPayProducer.payOrderNotice(paymentResponseDTO);
        verify(this.rocketMQTemplate).getDefaultDestination();
        verify(this.rocketMQTemplate).getCharset();
        verify(this.rocketMQTemplate).getConsumer();
        verify(this.rocketMQTemplate).getProducer();
        verify(this.rocketMQTemplate).getMessageQueueSelector();
        verify(this.rocketMQTemplate).syncSend((String) any(), (org.springframework.messaging.Message<?>) any(), anyLong(),
                anyInt());
        verify(this.rocketMQTemplate).getMessageConverter();
        verify(paymentResponseDTO).getContent();
        verify(paymentResponseDTO).getCode();
        verify(paymentResponseDTO).getMsg();
        verify(paymentResponseDTO).getOutTradeNo();
        verify(paymentResponseDTO).getTradeNo();
        verify(paymentResponseDTO).getTradeState();
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payResultNotice(PaymentResponseDTO)}
     */
    @Test
    void testPayResultNotice() throws MessagingException
    {
        doNothing().when(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
        this.rocketMQPayProducer.payResultNotice(new PaymentResponseDTO<>());
        verify(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payResultNotice(PaymentResponseDTO)}
     */
    @Test
    void testPayResultNotice2() throws MessagingException
    {
        doNothing().when(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
        this.rocketMQPayProducer.payResultNotice(new PaymentResponseDTO<>("PAY_PAYMENT_RESULT", "PAY_PAYMENT_RESULT",
                "PAY_PAYMENT_RESULT", "PAY_PAYMENT_RESULT", TradeStatus.SUCCESS, "Not all who wander are lost"));
        verify(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payResultNotice(PaymentResponseDTO)}
     */
    @Test
    void testPayResultNotice3() throws MessagingException
    {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     RocketMQPayProducer.rocketMQTemplate

        doNothing().when(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
        this.rocketMQPayProducer.payResultNotice(null);
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payResultNotice(PaymentResponseDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPayResultNotice4() throws MessagingException
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.creation.settings.CreationSettings, fieldName : mockSettings, write javaBean error, fastjson version 1.2.76, class com.diffblue.spring.isolation.framework.mocks.MockInvocationListener, fieldName : 0, write javaBean error, fastjson version 1.2.76, class org.mockito.codegen.RocketMQTemplate$MockitoMock$798037944, fieldName : 1, write javaBean error, fastjson version 1.2.76, class org.apache.rocketmq.client.consumer.DefaultLitePullConsumer, fieldName : consumer
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:541)
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:154)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.writeWithFieldName(JSONSerializer.java:360)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_2_MockMethodInterceptor.write(null)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_1_PaymentResponseDTO$MockitoMock$1980592089.write(null)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.write(JSONSerializer.java:312)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:793)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:731)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:688)
        //       at mao.aggregate_pay_payment_agent_service.producer.impl.RocketMQPayProducer.payResultNotice(RocketMQPayProducer.java:59)
        //   In order to prevent payResultNotice(PaymentResponseDTO)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   payResultNotice(PaymentResponseDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.rocketMQTemplate.getDefaultDestination()).thenReturn("Default Destination");
        when(this.rocketMQTemplate.getCharset()).thenReturn("UTF-8");
        when(this.rocketMQTemplate.getConsumer()).thenReturn(new DefaultLitePullConsumer());
        when(this.rocketMQTemplate.getProducer()).thenReturn(new DefaultMQProducer());
        when(this.rocketMQTemplate.getMessageQueueSelector()).thenReturn(mock(MessageQueueSelector.class));
        when(this.rocketMQTemplate.getMessageConverter()).thenReturn(new MappingFastJsonMessageConverter());
        doNothing().when(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
        PaymentResponseDTO<String> paymentResponseDTO = (PaymentResponseDTO<String>) mock(PaymentResponseDTO.class);
        when(paymentResponseDTO.getContent()).thenReturn("Not all who wander are lost");
        when(paymentResponseDTO.getCode()).thenReturn("Code");
        this.rocketMQPayProducer.payResultNotice(paymentResponseDTO);
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payResultNotice(PaymentResponseDTO)}
     */
    @Test
    void testPayResultNotice5() throws MessagingException
    {
        when(this.rocketMQTemplate.getDefaultDestination()).thenReturn("Default Destination");
        when(this.rocketMQTemplate.getCharset()).thenReturn("UTF-8");
        when(this.rocketMQTemplate.getConsumer()).thenReturn(null);
        when(this.rocketMQTemplate.getProducer()).thenReturn(new DefaultMQProducer());
        when(this.rocketMQTemplate.getMessageQueueSelector()).thenReturn(mock(MessageQueueSelector.class));
        when(this.rocketMQTemplate.getMessageConverter()).thenReturn(new MappingFastJsonMessageConverter());
        doNothing().when(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
        PaymentResponseDTO<String> paymentResponseDTO = (PaymentResponseDTO<String>) mock(PaymentResponseDTO.class);
        when(paymentResponseDTO.getMsg()).thenReturn("Msg");
        when(paymentResponseDTO.getOutTradeNo()).thenReturn("Out Trade No");
        when(paymentResponseDTO.getTradeNo()).thenReturn("Trade No");
        when(paymentResponseDTO.getTradeState()).thenReturn(TradeStatus.SUCCESS);
        when(paymentResponseDTO.getContent()).thenReturn("Not all who wander are lost");
        when(paymentResponseDTO.getCode()).thenReturn("Code");
        this.rocketMQPayProducer.payResultNotice(paymentResponseDTO);
        verify(this.rocketMQTemplate).getDefaultDestination();
        verify(this.rocketMQTemplate).getCharset();
        verify(this.rocketMQTemplate).getConsumer();
        verify(this.rocketMQTemplate).getProducer();
        verify(this.rocketMQTemplate).getMessageQueueSelector();
        verify(this.rocketMQTemplate).getMessageConverter();
        verify(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
        verify(paymentResponseDTO).getContent();
        verify(paymentResponseDTO).getCode();
        verify(paymentResponseDTO).getMsg();
        verify(paymentResponseDTO).getOutTradeNo();
        verify(paymentResponseDTO).getTradeNo();
        verify(paymentResponseDTO).getTradeState();
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payResultNotice(PaymentResponseDTO)}
     */
    @Test
    void testPayResultNotice6() throws MessagingException
    {
        when(this.rocketMQTemplate.getDefaultDestination()).thenReturn("支付渠道代理服务向mq支付结果消息：{}");
        when(this.rocketMQTemplate.getCharset()).thenReturn("UTF-8");
        when(this.rocketMQTemplate.getConsumer()).thenReturn(null);
        when(this.rocketMQTemplate.getProducer()).thenReturn(new DefaultMQProducer());
        when(this.rocketMQTemplate.getMessageQueueSelector()).thenReturn(mock(MessageQueueSelector.class));
        when(this.rocketMQTemplate.getMessageConverter()).thenReturn(new MappingFastJsonMessageConverter());
        doNothing().when(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
        PaymentResponseDTO<String> paymentResponseDTO = (PaymentResponseDTO<String>) mock(PaymentResponseDTO.class);
        when(paymentResponseDTO.getMsg()).thenReturn("Msg");
        when(paymentResponseDTO.getOutTradeNo()).thenReturn("Out Trade No");
        when(paymentResponseDTO.getTradeNo()).thenReturn("Trade No");
        when(paymentResponseDTO.getTradeState()).thenReturn(TradeStatus.SUCCESS);
        when(paymentResponseDTO.getContent()).thenReturn("Not all who wander are lost");
        when(paymentResponseDTO.getCode()).thenReturn("Code");
        this.rocketMQPayProducer.payResultNotice(paymentResponseDTO);
        verify(this.rocketMQTemplate).getDefaultDestination();
        verify(this.rocketMQTemplate).getCharset();
        verify(this.rocketMQTemplate).getConsumer();
        verify(this.rocketMQTemplate).getProducer();
        verify(this.rocketMQTemplate).getMessageQueueSelector();
        verify(this.rocketMQTemplate).getMessageConverter();
        verify(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
        verify(paymentResponseDTO).getContent();
        verify(paymentResponseDTO).getCode();
        verify(paymentResponseDTO).getMsg();
        verify(paymentResponseDTO).getOutTradeNo();
        verify(paymentResponseDTO).getTradeNo();
        verify(paymentResponseDTO).getTradeState();
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payResultNotice(PaymentResponseDTO)}
     */
    @Test
    void testPayResultNotice7() throws MessagingException
    {
        when(this.rocketMQTemplate.getDefaultDestination()).thenReturn("Default Destination");
        when(this.rocketMQTemplate.getCharset()).thenReturn("UTF-8");
        when(this.rocketMQTemplate.getConsumer()).thenReturn(null);
        when(this.rocketMQTemplate.getProducer()).thenReturn(new TransactionMQProducer("UUU://MQ_INST_UUU_UUU.xx"));
        when(this.rocketMQTemplate.getMessageQueueSelector()).thenReturn(mock(MessageQueueSelector.class));
        when(this.rocketMQTemplate.getMessageConverter()).thenReturn(new MappingFastJsonMessageConverter());
        doNothing().when(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
        PaymentResponseDTO<String> paymentResponseDTO = (PaymentResponseDTO<String>) mock(PaymentResponseDTO.class);
        when(paymentResponseDTO.getMsg()).thenReturn("Msg");
        when(paymentResponseDTO.getOutTradeNo()).thenReturn("Out Trade No");
        when(paymentResponseDTO.getTradeNo()).thenReturn("Trade No");
        when(paymentResponseDTO.getTradeState()).thenReturn(TradeStatus.SUCCESS);
        when(paymentResponseDTO.getContent()).thenReturn("Not all who wander are lost");
        when(paymentResponseDTO.getCode()).thenReturn("Code");
        this.rocketMQPayProducer.payResultNotice(paymentResponseDTO);
        verify(this.rocketMQTemplate).getDefaultDestination();
        verify(this.rocketMQTemplate).getCharset();
        verify(this.rocketMQTemplate).getConsumer();
        verify(this.rocketMQTemplate).getProducer();
        verify(this.rocketMQTemplate).getMessageQueueSelector();
        verify(this.rocketMQTemplate).getMessageConverter();
        verify(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
        verify(paymentResponseDTO).getContent();
        verify(paymentResponseDTO).getCode();
        verify(paymentResponseDTO).getMsg();
        verify(paymentResponseDTO).getOutTradeNo();
        verify(paymentResponseDTO).getTradeNo();
        verify(paymentResponseDTO).getTradeState();
    }

    /**
     * Method under test: {@link RocketMQPayProducer#payResultNotice(PaymentResponseDTO)}
     */
    @Test
    void testPayResultNotice8() throws MessagingException
    {
        DefaultMQProducer defaultMQProducer = mock(DefaultMQProducer.class);
        when(defaultMQProducer.isUnitMode()).thenReturn(true);
        when(defaultMQProducer.isUseTLS()).thenReturn(true);
        when(defaultMQProducer.isVipChannelEnabled()).thenReturn(true);
        when(defaultMQProducer.isRetryAnotherBrokerWhenNotStoreOK()).thenReturn(true);
        when(defaultMQProducer.isSendLatencyFaultEnable()).thenReturn(true);
        when(defaultMQProducer.isSendMessageWithVIPChannel()).thenReturn(true);
        when(defaultMQProducer.getClientCallbackExecutorThreads()).thenReturn(1);
        when(defaultMQProducer.getHeartbeatBrokerInterval()).thenReturn(42);
        when(defaultMQProducer.getMqClientApiTimeout()).thenReturn(10);
        when(defaultMQProducer.getPersistConsumerOffsetInterval()).thenReturn(42);
        when(defaultMQProducer.getPollNameServerInterval()).thenReturn(42);
        when(defaultMQProducer.getCompressMsgBodyOverHowmuch()).thenReturn(1);
        when(defaultMQProducer.getDefaultTopicQueueNums()).thenReturn(1000);
        when(defaultMQProducer.getMaxMessageSize()).thenReturn(3);
        when(defaultMQProducer.getRetryTimesWhenSendAsyncFailed()).thenReturn(3);
        when(defaultMQProducer.getRetryTimesWhenSendFailed()).thenReturn(3);
        when(defaultMQProducer.getSendMsgTimeout()).thenReturn(3);
        when(defaultMQProducer.getClientIP()).thenReturn("Client IP");
        when(defaultMQProducer.getInstanceName()).thenReturn("Instance Name");
        when(defaultMQProducer.getNamespace()).thenReturn("Namespace");
        when(defaultMQProducer.getNamesrvAddr()).thenReturn("42 Main St");
        when(defaultMQProducer.getUnitName()).thenReturn("Unit Name");
        when(defaultMQProducer.getCreateTopicKey()).thenReturn("Create Topic Key");
        when(defaultMQProducer.getProducerGroup()).thenReturn("Producer Group");
        when(defaultMQProducer.getRetryResponseCodes()).thenReturn(new HashSet<>());
        when(defaultMQProducer.getPullTimeDelayMillsWhenException()).thenReturn(1L);
        when(defaultMQProducer.getLatencyMax()).thenReturn(new long[]{1L, 1L, 1L, 1L});
        when(defaultMQProducer.getNotAvailableDuration()).thenReturn(new long[]{1L, 1L, 1L, 1L});
        when(defaultMQProducer.getAccessChannel()).thenReturn(AccessChannel.LOCAL);
        when(defaultMQProducer.getDefaultMQProducerImpl()).thenReturn(new DefaultMQProducerImpl(new DefaultMQProducer()));
        when(defaultMQProducer.getTraceDispatcher()).thenReturn(new AsyncTraceDispatcher("Group",
                TraceDispatcher.Type.PRODUCE, "Trace Topic Name", new AclClientRPCHook(new SessionCredentials())));
        when(defaultMQProducer.getLanguage()).thenReturn(LanguageCode.JAVA);
        when(this.rocketMQTemplate.getDefaultDestination()).thenReturn("Default Destination");
        when(this.rocketMQTemplate.getCharset()).thenReturn("UTF-8");
        when(this.rocketMQTemplate.getConsumer()).thenReturn(null);
        when(this.rocketMQTemplate.getProducer()).thenReturn(defaultMQProducer);
        when(this.rocketMQTemplate.getMessageQueueSelector()).thenReturn(mock(MessageQueueSelector.class));
        when(this.rocketMQTemplate.getMessageConverter()).thenReturn(new MappingFastJsonMessageConverter());
        doNothing().when(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
        PaymentResponseDTO<String> paymentResponseDTO = (PaymentResponseDTO<String>) mock(PaymentResponseDTO.class);
        when(paymentResponseDTO.getMsg()).thenReturn("Msg");
        when(paymentResponseDTO.getOutTradeNo()).thenReturn("Out Trade No");
        when(paymentResponseDTO.getTradeNo()).thenReturn("Trade No");
        when(paymentResponseDTO.getTradeState()).thenReturn(TradeStatus.SUCCESS);
        when(paymentResponseDTO.getContent()).thenReturn("Not all who wander are lost");
        when(paymentResponseDTO.getCode()).thenReturn("Code");
        this.rocketMQPayProducer.payResultNotice(paymentResponseDTO);
        verify(this.rocketMQTemplate).getDefaultDestination();
        verify(this.rocketMQTemplate).getCharset();
        verify(this.rocketMQTemplate).getConsumer();
        verify(this.rocketMQTemplate).getProducer();
        verify(this.rocketMQTemplate).getMessageQueueSelector();
        verify(this.rocketMQTemplate).getMessageConverter();
        verify(this.rocketMQTemplate).convertAndSend((String) any(), (Object) any());
        verify(defaultMQProducer).isUnitMode();
        verify(defaultMQProducer).isUseTLS();
        verify(defaultMQProducer).isVipChannelEnabled();
        verify(defaultMQProducer).isRetryAnotherBrokerWhenNotStoreOK();
        verify(defaultMQProducer).isSendLatencyFaultEnable();
        verify(defaultMQProducer).isSendMessageWithVIPChannel();
        verify(defaultMQProducer).getClientCallbackExecutorThreads();
        verify(defaultMQProducer).getHeartbeatBrokerInterval();
        verify(defaultMQProducer).getMqClientApiTimeout();
        verify(defaultMQProducer).getPersistConsumerOffsetInterval();
        verify(defaultMQProducer).getPollNameServerInterval();
        verify(defaultMQProducer).getCompressMsgBodyOverHowmuch();
        verify(defaultMQProducer).getDefaultTopicQueueNums();
        verify(defaultMQProducer).getMaxMessageSize();
        verify(defaultMQProducer).getRetryTimesWhenSendAsyncFailed();
        verify(defaultMQProducer).getRetryTimesWhenSendFailed();
        verify(defaultMQProducer).getSendMsgTimeout();
        verify(defaultMQProducer).getClientIP();
        verify(defaultMQProducer).getInstanceName();
        verify(defaultMQProducer).getNamespace();
        verify(defaultMQProducer).getNamesrvAddr();
        verify(defaultMQProducer).getUnitName();
        verify(defaultMQProducer).getCreateTopicKey();
        verify(defaultMQProducer).getProducerGroup();
        verify(defaultMQProducer).getRetryResponseCodes();
        verify(defaultMQProducer).getPullTimeDelayMillsWhenException();
        verify(defaultMQProducer).getLatencyMax();
        verify(defaultMQProducer).getNotAvailableDuration();
        verify(defaultMQProducer).getAccessChannel();
        verify(defaultMQProducer).getDefaultMQProducerImpl();
        verify(defaultMQProducer).getTraceDispatcher();
        verify(defaultMQProducer).getLanguage();
        verify(paymentResponseDTO).getContent();
        verify(paymentResponseDTO).getCode();
        verify(paymentResponseDTO).getMsg();
        verify(paymentResponseDTO).getOutTradeNo();
        verify(paymentResponseDTO).getTradeNo();
        verify(paymentResponseDTO).getTradeState();
    }
}

