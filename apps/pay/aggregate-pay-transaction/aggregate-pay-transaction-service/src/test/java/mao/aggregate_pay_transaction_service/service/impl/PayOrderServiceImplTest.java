package mao.aggregate_pay_transaction_service.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import mao.aggregate_pay_transaction_api.dto.PayOrderDTO;
import mao.aggregate_pay_transaction_service.entity.PayOrder;
import mao.aggregate_pay_transaction_service.mapper.PayOrderMapper;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PayOrderServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PayOrderServiceImplTest
{
    @MockBean
    private DozerUtils dozerUtils;

    @MockBean
    private PayOrderMapper payOrderMapper;

    @Autowired
    private PayOrderServiceImpl payOrderServiceImpl;

    /**
     * Method under test: {@link PayOrderServiceImpl#save(PayOrderDTO)}
     */
    @Test
    void testSave()
    {
        when(this.payOrderMapper.insert((PayOrder) any())).thenReturn(1);

        PayOrder payOrder = new PayOrder();
        payOrder.setAnalysis("Analysis");
        payOrder.setAppId("42");
        payOrder.setBody("Not all who wander are lost");
        payOrder.setChannel("Channel");
        payOrder.setClientIp("Client Ip");
        payOrder.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setCurrency("GBP");
        payOrder.setDevice("Device");
        payOrder.setErrorCode("An error occurred");
        payOrder.setErrorMsg("An error occurred");
        payOrder.setExpireTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setExtra("Extra");
        payOrder.setId(123L);
        payOrder.setMerchantId(123L);
        payOrder.setOptional("Optional");
        payOrder.setOutTradeNo("Out Trade No");
        payOrder.setPayChannel("Pay Channel");
        payOrder.setPayChannelMchAppId("42");
        payOrder.setPayChannelMchId("42");
        payOrder.setPayChannelTradeNo("Pay Channel Trade No");
        payOrder.setPaySuccessTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setStoreId(123L);
        payOrder.setSubject("Hello from the Dreaming Spires");
        payOrder.setTotalAmount(1);
        payOrder.setTradeNo("Trade No");
        payOrder.setTradeState("Trade State");
        payOrder.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        doNothing().when(this.dozerUtils).map((Object) any(), (Object) any());
        when(this.dozerUtils.map((Object) any(), (Class<PayOrder>) any())).thenReturn(payOrder);
        this.payOrderServiceImpl.save(new PayOrderDTO());
        verify(this.dozerUtils).map((Object) any(), (Class<PayOrder>) any());
    }

    /**
     * Method under test: {@link PayOrderServiceImpl#save(PayOrderDTO)}
     */
    @Test
    void testSave2()
    {
        when(this.payOrderMapper.insert((PayOrder) any())).thenReturn(1);

        PayOrder payOrder = new PayOrder();
        payOrder.setAnalysis("Analysis");
        payOrder.setAppId("42");
        payOrder.setBody("Not all who wander are lost");
        payOrder.setChannel("Channel");
        payOrder.setClientIp("Client Ip");
        payOrder.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setCurrency("GBP");
        payOrder.setDevice("Device");
        payOrder.setErrorCode("An error occurred");
        payOrder.setErrorMsg("An error occurred");
        payOrder.setExpireTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setExtra("Extra");
        payOrder.setId(123L);
        payOrder.setMerchantId(123L);
        payOrder.setOptional("Optional");
        payOrder.setOutTradeNo("Out Trade No");
        payOrder.setPayChannel("Pay Channel");
        payOrder.setPayChannelMchAppId("42");
        payOrder.setPayChannelMchId("42");
        payOrder.setPayChannelTradeNo("Pay Channel Trade No");
        payOrder.setPaySuccessTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setStoreId(123L);
        payOrder.setSubject("Hello from the Dreaming Spires");
        payOrder.setTotalAmount(1);
        payOrder.setTradeNo("Trade No");
        payOrder.setTradeState("Trade State");
        payOrder.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        doThrow(new IllegalArgumentException("CNY")).when(this.dozerUtils).map((Object) any(), (Object) any());
        when(this.dozerUtils.map((Object) any(), (Class<PayOrder>) any())).thenReturn(payOrder);
        this.payOrderServiceImpl.save(new PayOrderDTO());
        verify(this.dozerUtils).map((Object) any(), (Class<PayOrder>) any());
    }

    /**
     * Method under test: {@link PayOrderServiceImpl#save(PayOrderDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 支付订单保存失败
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_transaction_service.service.impl.PayOrderServiceImpl.save(PayOrderServiceImpl.java:60)
        //   In order to prevent save(PayOrderDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   save(PayOrderDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.payOrderMapper.insert((PayOrder) any())).thenReturn(0);

        PayOrder payOrder = new PayOrder();
        payOrder.setAnalysis("Analysis");
        payOrder.setAppId("42");
        payOrder.setBody("Not all who wander are lost");
        payOrder.setChannel("Channel");
        payOrder.setClientIp("Client Ip");
        payOrder.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setCurrency("GBP");
        payOrder.setDevice("Device");
        payOrder.setErrorCode("An error occurred");
        payOrder.setErrorMsg("An error occurred");
        payOrder.setExpireTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setExtra("Extra");
        payOrder.setId(123L);
        payOrder.setMerchantId(123L);
        payOrder.setOptional("Optional");
        payOrder.setOutTradeNo("Out Trade No");
        payOrder.setPayChannel("Pay Channel");
        payOrder.setPayChannelMchAppId("42");
        payOrder.setPayChannelMchId("42");
        payOrder.setPayChannelTradeNo("Pay Channel Trade No");
        payOrder.setPaySuccessTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setStoreId(123L);
        payOrder.setSubject("Hello from the Dreaming Spires");
        payOrder.setTotalAmount(1);
        payOrder.setTradeNo("Trade No");
        payOrder.setTradeState("Trade State");
        payOrder.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        doNothing().when(this.dozerUtils).map((Object) any(), (Object) any());
        when(this.dozerUtils.map((Object) any(), (Class<PayOrder>) any())).thenReturn(payOrder);
        this.payOrderServiceImpl.save(new PayOrderDTO());
    }

    /**
     * Method under test: {@link PayOrderServiceImpl#queryPayOrderByTradeNo(String)}
     */
    @Test
    void testQueryPayOrderByTradeNo()
    {
        PayOrder payOrder = new PayOrder();
        payOrder.setAnalysis("Analysis");
        payOrder.setAppId("42");
        payOrder.setBody("Not all who wander are lost");
        payOrder.setChannel("Channel");
        payOrder.setClientIp("Client Ip");
        payOrder.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setCurrency("GBP");
        payOrder.setDevice("Device");
        payOrder.setErrorCode("An error occurred");
        payOrder.setErrorMsg("An error occurred");
        payOrder.setExpireTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setExtra("Extra");
        payOrder.setId(123L);
        payOrder.setMerchantId(123L);
        payOrder.setOptional("Optional");
        payOrder.setOutTradeNo("Out Trade No");
        payOrder.setPayChannel("Pay Channel");
        payOrder.setPayChannelMchAppId("42");
        payOrder.setPayChannelMchId("42");
        payOrder.setPayChannelTradeNo("Pay Channel Trade No");
        payOrder.setPaySuccessTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setStoreId(123L);
        payOrder.setSubject("Hello from the Dreaming Spires");
        payOrder.setTotalAmount(1);
        payOrder.setTradeNo("Trade No");
        payOrder.setTradeState("Trade State");
        payOrder.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        when(this.payOrderMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<PayOrder>) any()))
                .thenReturn(payOrder);
        PayOrderDTO payOrderDTO = new PayOrderDTO();
        when(this.dozerUtils.map((Object) any(), (Class<PayOrderDTO>) any())).thenReturn(payOrderDTO);
        assertSame(payOrderDTO, this.payOrderServiceImpl.queryPayOrderByTradeNo("Trade No"));
        verify(this.payOrderMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<PayOrder>) any());
        verify(this.dozerUtils).map((Object) any(), (Class<PayOrderDTO>) any());
    }

    /**
     * Method under test: {@link PayOrderServiceImpl#queryPayOrderByTradeNo(String)}
     */
    @Test
    void testQueryPayOrderByTradeNo2()
    {
        PayOrder payOrder = new PayOrder();
        payOrder.setAnalysis("Analysis");
        payOrder.setAppId("42");
        payOrder.setBody("Not all who wander are lost");
        payOrder.setChannel("Channel");
        payOrder.setClientIp("Client Ip");
        payOrder.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setCurrency("GBP");
        payOrder.setDevice("Device");
        payOrder.setErrorCode("An error occurred");
        payOrder.setErrorMsg("An error occurred");
        payOrder.setExpireTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setExtra("Extra");
        payOrder.setId(123L);
        payOrder.setMerchantId(123L);
        payOrder.setOptional("Optional");
        payOrder.setOutTradeNo("Out Trade No");
        payOrder.setPayChannel("Pay Channel");
        payOrder.setPayChannelMchAppId("42");
        payOrder.setPayChannelMchId("42");
        payOrder.setPayChannelTradeNo("Pay Channel Trade No");
        payOrder.setPaySuccessTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setStoreId(123L);
        payOrder.setSubject("Hello from the Dreaming Spires");
        payOrder.setTotalAmount(1);
        payOrder.setTradeNo("Trade No");
        payOrder.setTradeState("Trade State");
        payOrder.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        when(this.payOrderMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<PayOrder>) any()))
                .thenReturn(payOrder);
        when(this.dozerUtils.map((Object) any(), (Class<PayOrderDTO>) any()))
                .thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> this.payOrderServiceImpl.queryPayOrderByTradeNo("Trade No"));
        verify(this.payOrderMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<PayOrder>) any());
        verify(this.dozerUtils).map((Object) any(), (Class<PayOrderDTO>) any());
    }

    /**
     * Method under test: {@link PayOrderServiceImpl#queryPayOrderByTradeNo(String)}
     */
    @Test
    void testQueryPayOrderByTradeNo3()
    {
        PayOrder payOrder = new PayOrder();
        payOrder.setAnalysis("Analysis");
        payOrder.setAppId("42");
        payOrder.setBody("Not all who wander are lost");
        payOrder.setChannel("Channel");
        payOrder.setClientIp("Client Ip");
        payOrder.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setCurrency("GBP");
        payOrder.setDevice("Device");
        payOrder.setErrorCode("An error occurred");
        payOrder.setErrorMsg("An error occurred");
        payOrder.setExpireTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setExtra("Extra");
        payOrder.setId(123L);
        payOrder.setMerchantId(123L);
        payOrder.setOptional("Optional");
        payOrder.setOutTradeNo("Out Trade No");
        payOrder.setPayChannel("Pay Channel");
        payOrder.setPayChannelMchAppId("42");
        payOrder.setPayChannelMchId("42");
        payOrder.setPayChannelTradeNo("Pay Channel Trade No");
        payOrder.setPaySuccessTime(LocalDateTime.of(1, 1, 1, 1, 1));
        payOrder.setStoreId(123L);
        payOrder.setSubject("Hello from the Dreaming Spires");
        payOrder.setTotalAmount(1);
        payOrder.setTradeNo("Trade No");
        payOrder.setTradeState("Trade State");
        payOrder.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        when(this.payOrderMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<PayOrder>) any()))
                .thenReturn(payOrder);
        PayOrderDTO payOrderDTO = new PayOrderDTO();
        when(this.dozerUtils.map((Object) any(), (Class<PayOrderDTO>) any())).thenReturn(payOrderDTO);
        assertSame(payOrderDTO, this.payOrderServiceImpl.queryPayOrderByTradeNo(""));
        verify(this.payOrderMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<PayOrder>) any());
        verify(this.dozerUtils).map((Object) any(), (Class<PayOrderDTO>) any());
    }
}

