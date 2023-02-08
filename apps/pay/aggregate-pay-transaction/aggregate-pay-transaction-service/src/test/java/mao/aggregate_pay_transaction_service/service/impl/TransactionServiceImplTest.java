package mao.aggregate_pay_transaction_service.service.impl;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import mao.aggregate_pay_transaction_api.dto.PayOrderDTO;
import mao.aggregate_pay_transaction_api.dto.QRCodeDto;
import mao.tools_core.exception.BizException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TransactionServiceImplTest
{
    /**
     * Method under test: {@link TransactionServiceImpl#createStoreQRCode(QRCodeDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateStoreQRCode()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.verifyAppAndStore(TransactionServiceImpl.java:131)
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.createStoreQRCode(TransactionServiceImpl.java:90)
        //   In order to prevent createStoreQRCode(QRCodeDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createStoreQRCode(QRCodeDto).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        transactionServiceImpl.createStoreQRCode(new QRCodeDto());
    }

    /**
     * Method under test: {@link TransactionServiceImpl#createStoreQRCode(QRCodeDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateStoreQRCode2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.createStoreQRCode(TransactionServiceImpl.java:90)
        //   In order to prevent createStoreQRCode(QRCodeDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createStoreQRCode(QRCodeDto).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TransactionServiceImpl()).createStoreQRCode(null);
    }

    /**
     * Method under test: {@link TransactionServiceImpl#createStoreQRCode(QRCodeDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateStoreQRCode3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.verifyAppAndStore(TransactionServiceImpl.java:131)
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.createStoreQRCode(TransactionServiceImpl.java:90)
        //   In order to prevent createStoreQRCode(QRCodeDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createStoreQRCode(QRCodeDto).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        QRCodeDto qrCodeDto = mock(QRCodeDto.class);
        when(qrCodeDto.getMerchantId()).thenReturn(123L);
        when(qrCodeDto.getStoreId()).thenReturn(123L);
        when(qrCodeDto.getAppId()).thenReturn("42");
        transactionServiceImpl.createStoreQRCode(qrCodeDto);
    }

    /**
     * Method under test: {@link TransactionServiceImpl#submitOrderByAli(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSubmitOrderByAli()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.submitOrderByAli(TransactionServiceImpl.java:156)
        //   In order to prevent submitOrderByAli(PayOrderDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   submitOrderByAli(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        transactionServiceImpl.submitOrderByAli(new PayOrderDTO());
    }

    /**
     * Method under test: {@link TransactionServiceImpl#submitOrderByAli(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSubmitOrderByAli2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.submitOrderByAli(TransactionServiceImpl.java:154)
        //   In order to prevent submitOrderByAli(PayOrderDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   submitOrderByAli(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TransactionServiceImpl()).submitOrderByAli(null);
    }

    /**
     * Method under test: {@link TransactionServiceImpl#submitOrderByAli(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSubmitOrderByAli3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.submitOrderByAli(TransactionServiceImpl.java:156)
        //   In order to prevent submitOrderByAli(PayOrderDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   submitOrderByAli(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        PayOrderDTO payOrderDTO = mock(PayOrderDTO.class);
        doNothing().when(payOrderDTO).setPayChannel((String) any());
        transactionServiceImpl.submitOrderByAli(payOrderDTO);
    }

    /**
     * Method under test: {@link TransactionServiceImpl#updateOrderTradeNoAndTradeState(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateOrderTradeNoAndTradeState()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [payChannelTradeNo] of entity [mao.aggregate_pay_transaction_service.entity.PayOrder]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:79)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:32)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.updateOrderTradeNoAndTradeState(TransactionServiceImpl.java:245)
        //   In order to prevent updateOrderTradeNoAndTradeState(String, String, String)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateOrderTradeNoAndTradeState(String, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TransactionServiceImpl()).updateOrderTradeNoAndTradeState("Trade No", "Pay Channel Trade No", "MD");
    }

    /**
     * Method under test: {@link TransactionServiceImpl#getWXOAuth2Code(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWXOAuth2Code()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.getWXOAuth2Code(TransactionServiceImpl.java:270)
        //   In order to prevent getWXOAuth2Code(PayOrderDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getWXOAuth2Code(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        transactionServiceImpl.getWXOAuth2Code(new PayOrderDTO());
    }

    /**
     * Method under test: {@link TransactionServiceImpl#getWXOAuth2Code(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWXOAuth2Code2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.getWXOAuth2Code(TransactionServiceImpl.java:270)
        //   In order to prevent getWXOAuth2Code(PayOrderDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getWXOAuth2Code(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        LocalDateTime createTime = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime updateTime = LocalDateTime.of(1, 1, 1, 1, 1);
        LocalDateTime expireTime = LocalDateTime.of(1, 1, 1, 1, 1);
        transactionServiceImpl.getWXOAuth2Code(
                new PayOrderDTO(123L, 123L, "42", "WX_JSAPI", "WX_JSAPI", "WX_JSAPI", "Hello from the Dreaming Spires",
                        "Not all who wander are lost", "GBP", 1, "WX_JSAPI", "WX_JSAPI", "WX_JSAPI", "42", "WX_JSAPI", "WX_JSAPI",
                        "WX_JSAPI", "WX_JSAPI", "WX_JSAPI", createTime, updateTime, expireTime, LocalDateTime.of(1, 1, 1, 1, 1)));
    }

    /**
     * Method under test: {@link TransactionServiceImpl#getWXOAuth2Code(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWXOAuth2Code3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.getWXOAuth2Code(TransactionServiceImpl.java:266)
        //   In order to prevent getWXOAuth2Code(PayOrderDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getWXOAuth2Code(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TransactionServiceImpl()).getWXOAuth2Code(null);
    }

    /**
     * Method under test: {@link TransactionServiceImpl#getWXOAuth2Code(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWXOAuth2Code4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.getWXOAuth2Code(TransactionServiceImpl.java:270)
        //   In order to prevent getWXOAuth2Code(PayOrderDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getWXOAuth2Code(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        PayOrderDTO payOrderDTO = mock(PayOrderDTO.class);
        when(payOrderDTO.getTotalAmount()).thenReturn(1);
        when(payOrderDTO.getMerchantId()).thenReturn(123L);
        when(payOrderDTO.getStoreId()).thenReturn(123L);
        when(payOrderDTO.getAnalysis()).thenReturn("Analysis");
        when(payOrderDTO.getAppId()).thenReturn("42");
        when(payOrderDTO.getAuthCode()).thenReturn("Auth Code");
        when(payOrderDTO.getBody()).thenReturn("Not all who wander are lost");
        when(payOrderDTO.getChannel()).thenReturn("Channel");
        when(payOrderDTO.getClientIp()).thenReturn("Client Ip");
        when(payOrderDTO.getCurrency()).thenReturn("GBP");
        when(payOrderDTO.getDevice()).thenReturn("Device");
        when(payOrderDTO.getExtra()).thenReturn("Extra");
        when(payOrderDTO.getOpenId()).thenReturn("42");
        when(payOrderDTO.getOptional()).thenReturn("Optional");
        when(payOrderDTO.getOutTradeNo()).thenReturn("Out Trade No");
        when(payOrderDTO.getPayChannel()).thenReturn("Pay Channel");
        when(payOrderDTO.getSubject()).thenReturn("Hello from the Dreaming Spires");
        when(payOrderDTO.getTradeNo()).thenReturn("Trade No");
        when(payOrderDTO.getTradeState()).thenReturn("Trade State");
        when(payOrderDTO.getCreateTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        when(payOrderDTO.getExpireTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        when(payOrderDTO.getPaySuccessTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        when(payOrderDTO.getUpdateTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        transactionServiceImpl.getWXOAuth2Code(payOrderDTO);
    }

    /**
     * Method under test: {@link TransactionServiceImpl#getWXOAuth2Code(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWXOAuth2Code5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.getWXOAuth2Code(TransactionServiceImpl.java:270)
        //   In order to prevent getWXOAuth2Code(PayOrderDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getWXOAuth2Code(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        PayOrderDTO payOrderDTO = mock(PayOrderDTO.class);
        when(payOrderDTO.getTotalAmount()).thenReturn(1);
        when(payOrderDTO.getMerchantId()).thenReturn(123L);
        when(payOrderDTO.getStoreId()).thenReturn(123L);
        when(payOrderDTO.getAnalysis()).thenReturn("Analysis");
        when(payOrderDTO.getAppId()).thenReturn("42");
        when(payOrderDTO.getAuthCode()).thenReturn("Auth Code");
        when(payOrderDTO.getBody()).thenReturn("Not all who wander are lost");
        when(payOrderDTO.getChannel()).thenReturn("Channel");
        when(payOrderDTO.getClientIp()).thenReturn("Client Ip");
        when(payOrderDTO.getCurrency()).thenReturn("GBP");
        when(payOrderDTO.getDevice()).thenReturn("Device");
        when(payOrderDTO.getExtra()).thenReturn("Extra");
        when(payOrderDTO.getOpenId()).thenReturn("42");
        when(payOrderDTO.getOptional()).thenReturn("Optional");
        when(payOrderDTO.getOutTradeNo()).thenReturn("Out Trade No");
        when(payOrderDTO.getPayChannel()).thenReturn("Pay Channel");
        when(payOrderDTO.getSubject()).thenReturn("Hello from the Dreaming Spires");
        when(payOrderDTO.getTradeNo()).thenReturn("Trade No");
        when(payOrderDTO.getTradeState()).thenReturn("Trade State");
        when(payOrderDTO.getCreateTime()).thenReturn(null);
        when(payOrderDTO.getExpireTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        when(payOrderDTO.getPaySuccessTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        when(payOrderDTO.getUpdateTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        transactionServiceImpl.getWXOAuth2Code(payOrderDTO);
    }

    /**
     * Method under test: {@link TransactionServiceImpl#getWXOAuth2Code(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWXOAuth2Code6()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.getWXOAuth2Code(TransactionServiceImpl.java:270)
        //   In order to prevent getWXOAuth2Code(PayOrderDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getWXOAuth2Code(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
        ofResult.withDayOfYear(1);
        PayOrderDTO payOrderDTO = mock(PayOrderDTO.class);
        when(payOrderDTO.getTotalAmount()).thenReturn(1);
        when(payOrderDTO.getMerchantId()).thenReturn(123L);
        when(payOrderDTO.getStoreId()).thenReturn(123L);
        when(payOrderDTO.getAnalysis()).thenReturn("Analysis");
        when(payOrderDTO.getAppId()).thenReturn("42");
        when(payOrderDTO.getAuthCode()).thenReturn("Auth Code");
        when(payOrderDTO.getBody()).thenReturn("Not all who wander are lost");
        when(payOrderDTO.getChannel()).thenReturn("Channel");
        when(payOrderDTO.getClientIp()).thenReturn("Client Ip");
        when(payOrderDTO.getCurrency()).thenReturn("GBP");
        when(payOrderDTO.getDevice()).thenReturn("Device");
        when(payOrderDTO.getExtra()).thenReturn("Extra");
        when(payOrderDTO.getOpenId()).thenReturn("42");
        when(payOrderDTO.getOptional()).thenReturn("Optional");
        when(payOrderDTO.getOutTradeNo()).thenReturn("Out Trade No");
        when(payOrderDTO.getPayChannel()).thenReturn("Pay Channel");
        when(payOrderDTO.getSubject()).thenReturn("Hello from the Dreaming Spires");
        when(payOrderDTO.getTradeNo()).thenReturn("Trade No");
        when(payOrderDTO.getTradeState()).thenReturn("Trade State");
        when(payOrderDTO.getCreateTime()).thenReturn(ofResult);
        when(payOrderDTO.getExpireTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        when(payOrderDTO.getPaySuccessTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        when(payOrderDTO.getUpdateTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        transactionServiceImpl.getWXOAuth2Code(payOrderDTO);
    }

    /**
     * Method under test: {@link TransactionServiceImpl#getWXOAuth2Code(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWXOAuth2Code7()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: An error occurred
        //       at com.alibaba.fastjson.serializer.JSONSerializer.write(JSONSerializer.java:312)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:793)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:731)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:688)
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.getWXOAuth2Code(TransactionServiceImpl.java:264)
        //   In order to prevent getWXOAuth2Code(PayOrderDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getWXOAuth2Code(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        PayOrderDTO payOrderDTO = mock(PayOrderDTO.class);
        when(payOrderDTO.getTotalAmount()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getMerchantId()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getStoreId()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getAnalysis()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getAppId()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getAuthCode()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getBody()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getChannel()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getClientIp()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getCurrency()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getDevice()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getExtra()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getOpenId()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getOptional()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getOutTradeNo()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getPayChannel()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getSubject()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getTradeNo()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getTradeState()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getCreateTime()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getExpireTime()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getPaySuccessTime()).thenThrow(new BizException("An error occurred"));
        when(payOrderDTO.getUpdateTime()).thenThrow(new BizException("An error occurred"));
        transactionServiceImpl.getWXOAuth2Code(payOrderDTO);
    }

    /**
     * Method under test: {@link TransactionServiceImpl#getWXOAuth2Code(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWXOAuth2Code8()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.getWXOAuth2Code(TransactionServiceImpl.java:270)
        //   In order to prevent getWXOAuth2Code(PayOrderDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getWXOAuth2Code(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        PayOrderDTO payOrderDTO = mock(PayOrderDTO.class);
        when(payOrderDTO.getTotalAmount()).thenReturn(1);
        when(payOrderDTO.getMerchantId()).thenReturn(123L);
        when(payOrderDTO.getStoreId()).thenReturn(123L);
        when(payOrderDTO.getAnalysis()).thenReturn("Analysis");
        when(payOrderDTO.getAppId()).thenReturn("42");
        when(payOrderDTO.getAuthCode()).thenReturn("Auth Code");
        when(payOrderDTO.getBody()).thenReturn("Not all who wander are lost");
        when(payOrderDTO.getChannel()).thenReturn("Channel");
        when(payOrderDTO.getClientIp()).thenReturn("Client Ip");
        when(payOrderDTO.getCurrency()).thenReturn("GBP");
        when(payOrderDTO.getDevice()).thenReturn("Device");
        when(payOrderDTO.getExtra()).thenReturn("Extra");
        when(payOrderDTO.getOpenId()).thenReturn("42");
        when(payOrderDTO.getOptional()).thenReturn("Optional");
        when(payOrderDTO.getOutTradeNo()).thenReturn("Out Trade No");
        when(payOrderDTO.getPayChannel()).thenReturn("Pay Channel");
        when(payOrderDTO.getSubject()).thenReturn("Hello from the Dreaming Spires");
        when(payOrderDTO.getTradeNo()).thenReturn("Trade No");
        when(payOrderDTO.getTradeState()).thenReturn("Trade State");
        when(payOrderDTO.getCreateTime()).thenReturn(null);
        when(payOrderDTO.getExpireTime()).thenReturn(null);
        when(payOrderDTO.getPaySuccessTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        when(payOrderDTO.getUpdateTime()).thenReturn(LocalDateTime.of(1, 1, 1, 1, 1));
        transactionServiceImpl.getWXOAuth2Code(payOrderDTO);
    }

    /**
     * Method under test: {@link TransactionServiceImpl#getWXOAuthOpenId(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWXOAuthOpenId()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.getWXOAuthOpenId(TransactionServiceImpl.java:303)
        //   In order to prevent getWXOAuthOpenId(String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getWXOAuthOpenId(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TransactionServiceImpl()).getWXOAuthOpenId("Code", "42");
    }

    /**
     * Method under test: {@link TransactionServiceImpl#submitOrderByWechat(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSubmitOrderByWechat()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.submitOrderByWechat(TransactionServiceImpl.java:337)
        //   In order to prevent submitOrderByWechat(PayOrderDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   submitOrderByWechat(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        transactionServiceImpl.submitOrderByWechat(new PayOrderDTO());
    }

    /**
     * Method under test: {@link TransactionServiceImpl#submitOrderByWechat(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSubmitOrderByWechat2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.submitOrderByWechat(TransactionServiceImpl.java:335)
        //   In order to prevent submitOrderByWechat(PayOrderDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   submitOrderByWechat(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TransactionServiceImpl()).submitOrderByWechat(null);
    }

    /**
     * Method under test: {@link TransactionServiceImpl#submitOrderByWechat(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSubmitOrderByWechat3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.TransactionServiceImpl.submitOrderByWechat(TransactionServiceImpl.java:337)
        //   In order to prevent submitOrderByWechat(PayOrderDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   submitOrderByWechat(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
        PayOrderDTO payOrderDTO = mock(PayOrderDTO.class);
        doNothing().when(payOrderDTO).setPayChannel((String) any());
        transactionServiceImpl.submitOrderByWechat(payOrderDTO);
    }
}

