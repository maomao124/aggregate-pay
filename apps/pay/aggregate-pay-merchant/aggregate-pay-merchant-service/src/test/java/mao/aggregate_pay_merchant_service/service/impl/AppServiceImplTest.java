package mao.aggregate_pay_merchant_service.service.impl;

import mao.aggregate_pay_merchant_api.dto.AppDTO;
import mao.aggregate_pay_merchant_service.mapper.AppMapper;
import mao.aggregate_pay_merchant_service.service.MerchantService;
import mao.tools_redis_cache.utils.RedisUtils;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AppServiceImpl.class, StringRedisTemplate.class})
@ExtendWith(SpringExtension.class)
class AppServiceImplTest
{
    @MockBean
    private AppMapper appMapper;

    @Autowired
    private AppServiceImpl appServiceImpl;

    @MockBean
    private DozerUtils dozerUtils;

    @MockBean
    private MerchantService merchantService;

    @MockBean
    private RedisUtils redisUtils;

    /**
     * Method under test: {@link AppServiceImpl#createApp(Long, AppDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateApp()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        AppDTO appDTO = new AppDTO();
        appDTO.setAppId("42");
        appDTO.setAppName("App Name");
        appDTO.setMerchantId(123L);
        appDTO.setNotifyUrl("https://example.org/example");
        appDTO.setPublicKey("Public Key");
        this.appServiceImpl.createApp(123L, appDTO);
    }

    /**
     * Method under test: {@link AppServiceImpl#queryAppByMerchantId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAppByMerchantId()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        this.appServiceImpl.queryAppByMerchantId(123L);
    }

    /**
     * Method under test: {@link AppServiceImpl#getAppById(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAppById()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        this.appServiceImpl.getAppById("42");
    }

    /**
     * Method under test: {@link AppServiceImpl#queryAppInMerchant(String, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAppInMerchant()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        this.appServiceImpl.queryAppInMerchant("42", 123L);
    }
}

