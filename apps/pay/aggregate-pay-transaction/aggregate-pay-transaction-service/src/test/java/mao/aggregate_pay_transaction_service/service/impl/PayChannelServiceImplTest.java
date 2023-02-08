package mao.aggregate_pay_transaction_service.service.impl;

import mao.aggregate_pay_transaction_api.dto.PlatformChannelDTO;
import mao.aggregate_pay_transaction_service.mapper.PayChannelMapper;
import mao.aggregate_pay_transaction_service.mapper.PlatformChannelMapper;
import mao.aggregate_pay_transaction_service.service.PayChannelService;
import mao.tools_core.base.R;
import mao.tools_redis_cache.entity.RedisData;
import mao.tools_redis_cache.utils.RedisUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service.impl
 * Class(测试类名): PayChannelServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 22:50
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PayChannelServiceImplTest
{

    @MockBean
    private PayChannelMapper payChannelMapper;

    @Autowired
    private PayChannelServiceImpl payChannelServiceImpl;

    @MockBean
    private PlatformChannelMapper platformChannelMapper;

    @MockBean
    private RedisUtils redisUtils;

    @Autowired
    private PayChannelService payChannelService;

    @Test
    void queryAll()
    {
        System.out.println(payChannelService.list());
    }

    @Test
    void queryPayChannelByPlatformChannel()
    {
        System.out.println(payChannelService.queryPayChannelByPlatformChannel("aggregate_pay_c2b"));
    }

    /**
     * Method under test: {@link PayChannelServiceImpl#queryPayChannelByPlatformChannel(String)}
     */
    @Test
    void testQueryPayChannelByPlatformChannel()
    {
        when(this.redisUtils.query((String) any(), (String) any(), (String) any(), (Class<RedisData>) any(),
                (java.util.function.Function<String, RedisData>) any(), (Long) any(), (java.util.concurrent.TimeUnit) any(),
                (Integer) any())).thenReturn(new RedisData());
        assertNull(this.payChannelServiceImpl.queryPayChannelByPlatformChannel("Platform Channel Code"));
        verify(this.redisUtils).query((String) any(), (String) any(), (String) any(), (Class<RedisData>) any(),
                (java.util.function.Function<String, RedisData>) any(), (Long) any(), (java.util.concurrent.TimeUnit) any(),
                (Integer) any());
    }

    /**
     * Method under test: {@link PayChannelServiceImpl#queryPayChannelByPlatformChannel(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPayChannelByPlatformChannel2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.service.impl.PayChannelServiceImpl.queryPayChannelByPlatformChannel(PayChannelServiceImpl.java:62)
        //   In order to prevent queryPayChannelByPlatformChannel(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPayChannelByPlatformChannel(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.redisUtils.query((String) any(), (String) any(), (String) any(), (Class<RedisData>) any(),
                (java.util.function.Function<String, RedisData>) any(), (Long) any(), (java.util.concurrent.TimeUnit) any(),
                (Integer) any())).thenReturn(null);
        this.payChannelServiceImpl.queryPayChannelByPlatformChannel("Platform Channel Code");
    }
}
