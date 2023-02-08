package mao.aggregate_pay_transaction_service.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import mao.aggregate_pay_transaction_service.mapper.AppPlatformChannelMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AppPlatformChannelServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AppPlatformChannelServiceImplTest
{
    @MockBean
    private AppPlatformChannelMapper appPlatformChannelMapper;

    @Autowired
    private AppPlatformChannelServiceImpl appPlatformChannelServiceImpl;

    /**
     * Method under test: {@link AppPlatformChannelServiceImpl#queryAppBindPlatformChannel(String, String)}
     */
    @Test
    void testQueryAppBindPlatformChannel()
    {
        when(this.appPlatformChannelMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.AppPlatformChannel>) any()))
                .thenReturn(3);
        assertTrue(this.appPlatformChannelServiceImpl.queryAppBindPlatformChannel("42", "Platform Channel"));
        verify(this.appPlatformChannelMapper).selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.AppPlatformChannel>) any());
    }

    /**
     * Method under test: {@link AppPlatformChannelServiceImpl#queryAppBindPlatformChannel(String, String)}
     */
    @Test
    void testQueryAppBindPlatformChannel2()
    {
        when(this.appPlatformChannelMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.AppPlatformChannel>) any()))
                .thenReturn(0);
        assertFalse(this.appPlatformChannelServiceImpl.queryAppBindPlatformChannel("42", "Platform Channel"));
        verify(this.appPlatformChannelMapper).selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.AppPlatformChannel>) any());
    }

    /**
     * Method under test: {@link AppPlatformChannelServiceImpl#queryAppBindPlatformChannel(String, String)}
     */
    @Test
    void testQueryAppBindPlatformChannel3()
    {
        when(this.appPlatformChannelMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.AppPlatformChannel>) any()))
                .thenReturn(3);
        assertTrue(this.appPlatformChannelServiceImpl.queryAppBindPlatformChannel("", "Platform Channel"));
        verify(this.appPlatformChannelMapper).selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.AppPlatformChannel>) any());
    }

    /**
     * Method under test: {@link AppPlatformChannelServiceImpl#queryAppBindPlatformChannel(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAppBindPlatformChannel4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: foo
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.count(ServiceImpl.java:266)
        //       at mao.aggregate_pay_transaction_service.service.impl.AppPlatformChannelServiceImpl.queryAppBindPlatformChannel(AppPlatformChannelServiceImpl.java:33)
        //   In order to prevent queryAppBindPlatformChannel(String, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryAppBindPlatformChannel(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.appPlatformChannelMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.AppPlatformChannel>) any()))
                .thenThrow(new IllegalArgumentException("foo"));
        this.appPlatformChannelServiceImpl.queryAppBindPlatformChannel("42", "Platform Channel");
    }
}

