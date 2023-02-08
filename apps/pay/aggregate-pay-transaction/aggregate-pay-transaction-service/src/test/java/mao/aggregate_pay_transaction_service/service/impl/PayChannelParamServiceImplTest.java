package mao.aggregate_pay_transaction_service.service.impl;

import mao.aggregate_pay_transaction_api.dto.PayChannelParamDTO;
import mao.aggregate_pay_transaction_service.mapper.PayChannelParamMapper;
import mao.aggregate_pay_transaction_service.service.AppPlatformChannelService;
import mao.aggregate_pay_transaction_service.service.PayChannelParamService;
import mao.tools_core.base.R;
import mao.tools_redis_cache.utils.RedisUtils;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service.impl
 * Class(测试类名): PayChannelParamServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/17
 * Time(创建时间)： 14:07
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PayChannelParamServiceImplTest
{

    @MockBean
    private AppPlatformChannelService appPlatformChannelService;

    @MockBean
    private DozerUtils dozerUtils;

    @MockBean
    private PayChannelParamMapper payChannelParamMapper;

    @Autowired
    private PayChannelParamServiceImpl payChannelParamServiceImpl;

    @MockBean
    private RedisUtils redisUtils;

    @Autowired
    private PayChannelParamService payChannelParamService;

    /**
     * Method under test: {@link PayChannelParamServiceImpl#savePayChannelParam(PayChannelParamDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSavePayChannelParam()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        this.payChannelParamServiceImpl.savePayChannelParam(new PayChannelParamDTO());
    }

    @Test
    void queryPayChannelParamByAppAndPlatform()
    {
        R<List<PayChannelParamDTO>> aggregate_pay_c2b =
                payChannelParamService.queryPayChannelParamByAppAndPlatform("7a6e88fba94742069ef3bc40ee70ef18",
                        "aggregate_pay_c2b");
        System.out.println(aggregate_pay_c2b.getData());
    }

    @Test
    void queryPayChannelParamByAppAndPlatform2()
    {
        R<List<PayChannelParamDTO>> aggregate_pay_c2b =
                payChannelParamService.queryPayChannelParamByAppAndPlatform("7a6e88fba94742069ef3bc40ee70ef18",
                        "aggregate_pay_c2b");
        System.out.println(aggregate_pay_c2b.getData());
    }

    /**
     * Method under test: {@link PayChannelParamServiceImpl#queryPayChannelParamByAppAndPlatform(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPayChannelParamByAppAndPlatform()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        this.payChannelParamServiceImpl.queryPayChannelParamByAppAndPlatform("42", "Platform Channel");
    }

    @Test
    void queryParamByAppPlatformAndPayChannel()
    {
        R<PayChannelParamDTO> aggregate_pay_c2b =
                payChannelParamService.queryParamByAppPlatformAndPayChannel("7a6e88fba94742069ef3bc40ee70ef18",
                        "aggregate_pay_c2b", "32");
        System.out.println(aggregate_pay_c2b.getData());
    }

    @Test
    void queryParamByAppPlatformAndPayChannel2()
    {
        R<PayChannelParamDTO> aggregate_pay_c2b =
                payChannelParamService.queryParamByAppPlatformAndPayChannel("7a6e88fba94742069ef3bc40ee70ef18",
                        "aggregate_pay_c2b", "32");
        System.out.println(aggregate_pay_c2b.getData());
    }

    /**
     * Method under test: {@link PayChannelParamServiceImpl#queryParamByAppPlatformAndPayChannel(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryParamByAppPlatformAndPayChannel()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        this.payChannelParamServiceImpl.queryParamByAppPlatformAndPayChannel("42", "Platform Channel", "Pay Channel");
    }
}
