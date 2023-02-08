package mao.aggregate_pay_transaction_service.consumer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;

import mao.aggregate_pay_transaction_service.service.TransactionService;
import org.apache.rocketmq.common.message.MessageClientExt;
import org.apache.rocketmq.common.message.MessageExt;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TransactionPayConsumer.class})
@ExtendWith(SpringExtension.class)
class TransactionPayConsumerTest
{
    @Autowired
    private TransactionPayConsumer transactionPayConsumer;

    @MockBean
    private TransactionService transactionService;

    /**
     * Method under test: {@link TransactionPayConsumer#onMessage(MessageExt)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testOnMessage()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.lang.String.<init>(String.java:515)
        //       at mao.aggregate_pay_transaction_service.consumer.TransactionPayConsumer.onMessage(TransactionPayConsumer.java:43)
        //   In order to prevent onMessage(MessageExt)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   onMessage(MessageExt).
        //   See https://diff.blue/R013 to resolve this issue.

        this.transactionPayConsumer.onMessage(new MessageExt());
    }

    /**
     * Method under test: {@link TransactionPayConsumer#onMessage(org.apache.rocketmq.common.message.MessageExt)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testOnMessage2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.consumer.TransactionPayConsumer.onMessage(TransactionPayConsumer.java:43)
        //   In order to prevent onMessage(MessageExt)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   onMessage(MessageExt).
        //   See https://diff.blue/R013 to resolve this issue.

        this.transactionPayConsumer.onMessage(null);
    }

    /**
     * Method under test: {@link TransactionPayConsumer#onMessage(org.apache.rocketmq.common.message.MessageExt)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testOnMessage3() throws UnsupportedEncodingException
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: syntax error,expect start with { or [,but actually start with error
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(DefaultJSONParser.java:701)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:394)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:298)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:588)
        //       at mao.aggregate_pay_transaction_service.consumer.TransactionPayConsumer.onMessage(TransactionPayConsumer.java:45)
        //   In order to prevent onMessage(MessageExt)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   onMessage(MessageExt).
        //   See https://diff.blue/R013 to resolve this issue.

        MessageClientExt messageClientExt = mock(MessageClientExt.class);
        when(messageClientExt.getBody()).thenReturn("AAAAAAAA".getBytes("UTF-8"));
        this.transactionPayConsumer.onMessage(messageClientExt);
    }
}

