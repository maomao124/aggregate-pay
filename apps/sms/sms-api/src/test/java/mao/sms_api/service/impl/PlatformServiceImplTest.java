package mao.sms_api.service.impl;

import mao.sms_api.service.PlatformService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlatformServiceImplTest
{
    @Autowired
    private PlatformService platformService;

    /**
     * Method under test: {@link PlatformServiceImpl#getByAccessKeyId(String)}
     */
    @Test
    //@Disabled("TODO: Complete this test")
    void testGetByAccessKeyId()
    {
        System.out.println(platformService.getByAccessKeyId("EXAMPLEakiAIOSFODNN7"));
    }
}

