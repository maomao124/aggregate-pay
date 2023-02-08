package mao.aggregate_pay_transaction_service.service.impl;

import mao.aggregate_pay_transaction_api.dto.PlatformChannelDTO;
import mao.aggregate_pay_transaction_service.entity.AppPlatformChannel;
import mao.aggregate_pay_transaction_service.mapper.AppPlatformChannelMapper;
import mao.aggregate_pay_transaction_service.mapper.PlatformChannelMapper;
import mao.aggregate_pay_transaction_service.service.PlatformChannelService;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.tools_redis_cache.entity.RedisData;
import mao.tools_redis_cache.utils.RedisUtils;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service.impl
 * Class(测试类名): PlatformChannelServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 22:59
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PlatformChannelServiceImplTest
{

    @MockBean
    private AppPlatformChannelMapper appPlatformChannelMapper;

    @MockBean
    private DozerUtils dozerUtils;

    @MockBean
    private PlatformChannelMapper platformChannelMapper;

    @Autowired
    private PlatformChannelServiceImpl platformChannelServiceImpl;

    @MockBean
    private RedisUtils redisUtils;

    @Autowired
    private PlatformChannelService platformChannelService;

    @Test
    void queryAll()
    {
        R<List<PlatformChannelDTO>> listR = platformChannelService.queryAll();
        System.out.println(listR.getData());
    }

    /**
     * Method under test: {@link PlatformChannelServiceImpl#queryAll()}
     */
    @Test
    void testQueryAll()
    {
        when(this.redisUtils.query((String) any(), (String) any(), (Integer) any(), (Class<RedisData>) any(),
                (java.util.function.Function<Integer, RedisData>) any(), (Long) any(), (java.util.concurrent.TimeUnit) any(),
                (Integer) any())).thenReturn(new RedisData());
        R<List<PlatformChannelDTO>> actualQueryAllResult = this.platformChannelServiceImpl.queryAll();
        assertEquals(0, actualQueryAllResult.getCode());
        assertEquals("ok", actualQueryAllResult.getMsg());
        assertNull(actualQueryAllResult.getData());
        verify(this.redisUtils).query((String) any(), (String) any(), (Integer) any(), (Class<RedisData>) any(),
                (java.util.function.Function<Integer, RedisData>) any(), (Long) any(), (java.util.concurrent.TimeUnit) any(),
                (Integer) any());
    }

    /**
     * Method under test: {@link PlatformChannelServiceImpl#queryAll()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAll2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.PlatformChannelServiceImpl.queryAll(PlatformChannelServiceImpl.java:72)
        //   In order to prevent queryAll()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryAll().
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.redisUtils.query((String) any(), (String) any(), (Integer) any(), (Class<RedisData>) any(),
                (java.util.function.Function<Integer, RedisData>) any(), (Long) any(), (java.util.concurrent.TimeUnit) any(),
                (Integer) any())).thenReturn(null);
        this.platformChannelServiceImpl.queryAll();
    }

    /**
     * Method under test: {@link PlatformChannelServiceImpl#queryAll()}
     */
    @Test
    void testQueryAll3()
    {
        when(this.redisUtils.query((String) any(), (String) any(), (Integer) any(), (Class<RedisData>) any(),
                (java.util.function.Function<Integer, RedisData>) any(), (Long) any(), (java.util.concurrent.TimeUnit) any(),
                (Integer) any())).thenThrow(new IllegalArgumentException("pay:List_PlatformChannelDTO:queryAll:"));
        assertThrows(IllegalArgumentException.class, () -> this.platformChannelServiceImpl.queryAll());
        verify(this.redisUtils).query((String) any(), (String) any(), (Integer) any(), (Class<RedisData>) any(),
                (java.util.function.Function<Integer, RedisData>) any(), (Long) any(), (java.util.concurrent.TimeUnit) any(),
                (Integer) any());
    }

    /**
     * Method under test: {@link PlatformChannelServiceImpl#bindPlatformChannelForApp(String, String)}
     */
    @Test
    void testBindPlatformChannelForApp()
    {
        when(this.platformChannelMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.PlatformChannel>) any()))
                .thenReturn(3);

        AppPlatformChannel appPlatformChannel = new AppPlatformChannel();
        appPlatformChannel.setAppId("42");
        appPlatformChannel.setId(123L);
        appPlatformChannel.setPlatformChannel("Platform Channel");
        when(this.appPlatformChannelMapper.insert((AppPlatformChannel) any())).thenReturn(1);
        when(this.appPlatformChannelMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AppPlatformChannel>) any()))
                .thenReturn(appPlatformChannel);
        this.platformChannelServiceImpl.bindPlatformChannelForApp("42", "Platform Channel Codes");
        verify(this.platformChannelMapper).selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.PlatformChannel>) any());
        verify(this.appPlatformChannelMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AppPlatformChannel>) any());
    }

    /**
     * Method under test: {@link PlatformChannelServiceImpl#bindPlatformChannelForApp(String, String)}
     */
    @Test
    void testBindPlatformChannelForApp2()
    {
        when(this.platformChannelMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.PlatformChannel>) any()))
                .thenReturn(3);
        when(this.appPlatformChannelMapper.insert((AppPlatformChannel) any()))
                .thenThrow(new BizException("An error occurred"));
        when(this.appPlatformChannelMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AppPlatformChannel>) any()))
                .thenThrow(new BizException("An error occurred"));
        assertThrows(BizException.class,
                () -> this.platformChannelServiceImpl.bindPlatformChannelForApp("42", "Platform Channel Codes"));
        verify(this.platformChannelMapper).selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.PlatformChannel>) any());
        verify(this.appPlatformChannelMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AppPlatformChannel>) any());
    }

    /**
     * Method under test: {@link PlatformChannelServiceImpl#bindPlatformChannelForApp(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBindPlatformChannelForApp3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 平台服务类型码不存在
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_transaction_service.service.impl.PlatformChannelServiceImpl.bindPlatformChannelForApp(PlatformChannelServiceImpl.java:84)
        //   In order to prevent bindPlatformChannelForApp(String, String)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   bindPlatformChannelForApp(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.platformChannelMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.PlatformChannel>) any()))
                .thenReturn(0);

        AppPlatformChannel appPlatformChannel = new AppPlatformChannel();
        appPlatformChannel.setAppId("42");
        appPlatformChannel.setId(123L);
        appPlatformChannel.setPlatformChannel("Platform Channel");
        when(this.appPlatformChannelMapper.insert((AppPlatformChannel) any())).thenReturn(1);
        when(this.appPlatformChannelMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AppPlatformChannel>) any()))
                .thenReturn(appPlatformChannel);
        this.platformChannelServiceImpl.bindPlatformChannelForApp("42", "Platform Channel Codes");
    }

    /**
     * Method under test: {@link PlatformChannelServiceImpl#bindPlatformChannelForApp(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBindPlatformChannelForApp4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 平台服务类型码不存在
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_transaction_service.service.impl.PlatformChannelServiceImpl.bindPlatformChannelForApp(PlatformChannelServiceImpl.java:84)
        //   In order to prevent bindPlatformChannelForApp(String, String)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   bindPlatformChannelForApp(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.platformChannelMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.PlatformChannel>) any()))
                .thenReturn(null);

        AppPlatformChannel appPlatformChannel = new AppPlatformChannel();
        appPlatformChannel.setAppId("42");
        appPlatformChannel.setId(123L);
        appPlatformChannel.setPlatformChannel("Platform Channel");
        when(this.appPlatformChannelMapper.insert((AppPlatformChannel) any())).thenReturn(1);
        when(this.appPlatformChannelMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AppPlatformChannel>) any()))
                .thenReturn(appPlatformChannel);
        this.platformChannelServiceImpl.bindPlatformChannelForApp("42", "Platform Channel Codes");
    }

    /**
     * Method under test: {@link PlatformChannelServiceImpl#bindPlatformChannelForApp(String, String)}
     */
    @Test
    void testBindPlatformChannelForApp5()
    {
        when(this.platformChannelMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.PlatformChannel>) any()))
                .thenReturn(3);

        AppPlatformChannel appPlatformChannel = new AppPlatformChannel();
        appPlatformChannel.setAppId("42");
        appPlatformChannel.setId(123L);
        appPlatformChannel.setPlatformChannel("Platform Channel");
        when(this.appPlatformChannelMapper.insert((AppPlatformChannel) any())).thenReturn(1);
        when(this.appPlatformChannelMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AppPlatformChannel>) any()))
                .thenReturn(appPlatformChannel);
        this.platformChannelServiceImpl.bindPlatformChannelForApp(null, "Platform Channel Codes");
        verify(this.platformChannelMapper).selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.PlatformChannel>) any());
        verify(this.appPlatformChannelMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AppPlatformChannel>) any());
    }

    /**
     * Method under test: {@link PlatformChannelServiceImpl#bindPlatformChannelForApp(String, String)}
     */
    @Test
    void testBindPlatformChannelForApp6()
    {
        when(this.platformChannelMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.PlatformChannel>) any()))
                .thenReturn(3);

        AppPlatformChannel appPlatformChannel = new AppPlatformChannel();
        appPlatformChannel.setAppId("42");
        appPlatformChannel.setId(123L);
        appPlatformChannel.setPlatformChannel("Platform Channel");
        when(this.appPlatformChannelMapper.insert((AppPlatformChannel) any())).thenReturn(1);
        when(this.appPlatformChannelMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AppPlatformChannel>) any()))
                .thenReturn(appPlatformChannel);
        this.platformChannelServiceImpl.bindPlatformChannelForApp("", "Platform Channel Codes");
        verify(this.platformChannelMapper).selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_transaction_service.entity.PlatformChannel>) any());
        verify(this.appPlatformChannelMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AppPlatformChannel>) any());
    }
}
