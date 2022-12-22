package mao.sms_manage.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import mao.sms_dao.mapper.ConfigMapper;
import mao.sms_entity.dto.ConfigDTO;
import mao.sms_entity.dto.PlatformDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ConfigServiceImpl.class, RedisTemplate.class})
@ExtendWith(SpringExtension.class)
class ConfigServiceImplTest
{
    @MockBean
    private ConfigMapper configMapper;

    @Autowired
    private ConfigServiceImpl configServiceImpl;

    /**
     * Method under test: {@link ConfigServiceImpl#getByName(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetByName()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        this.configServiceImpl.getByName("Name");
    }

    /**
     * Method under test: {@link ConfigServiceImpl#getNewLevel(ConfigDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetNewLevel()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        ConfigDTO configDTO = new ConfigDTO();
        configDTO.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
        configDTO.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
        configDTO.setChannelType(1);
        configDTO.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configDTO.setCreateUser("Create User");
        configDTO.setDomain("Domain");
        configDTO.setId("42");
        configDTO.setIsActive(1);
        configDTO.setIsDelete(1);
        configDTO.setIsEnable(1);
        configDTO.setLastSuccessNum(10);
        configDTO.setLastSuccessNumInAnHour(10);
        configDTO.setLevel(1);
        configDTO.setName("Name");
        configDTO.setOther("Other");
        configDTO.setPlatform("Platform");
        configDTO.setPlatformDTO(new PlatformDTO());
        configDTO.setRemark("Remark");
        configDTO.setSignatureDTOS(new ArrayList<>());
        configDTO.setSignatureIds(new ArrayList<>());
        configDTO.setTemplateDTOS(new ArrayList<>());
        configDTO.setTemplateIds(new ArrayList<>());
        configDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configDTO.setUpdateUser("2020-03-01");
        this.configServiceImpl.getNewLevel(configDTO);
    }

    /**
     * Method under test: {@link ConfigServiceImpl#sendUpdateMessage()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSendUpdateMessage()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        this.configServiceImpl.sendUpdateMessage();
    }
}

