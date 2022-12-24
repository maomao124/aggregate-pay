package mao.sms_api.service.impl;

import mao.sms_dao.mapper.BlackListMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ContextConfiguration(classes = {BlackListServiceImpl.class, RedisTemplate.class})
@ExtendWith(SpringExtension.class)
class BlackListServiceImplTest
{
    @MockBean
    private BlackListMapper blackListMapper;

    @Autowired
    private BlackListServiceImpl blackListServiceImpl;

    /**
     * Method under test: {@link BlackListServiceImpl#listByType(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testListByType()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        this.blackListServiceImpl.listByType("Type");
    }
}

