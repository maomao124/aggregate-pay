package mao.sms_manage.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import mao.sms_dao.mapper.ConfigTemplateMapper;
import mao.sms_entity.dto.ConfigDTO;
import mao.sms_entity.dto.PlatformDTO;
import mao.sms_entity.dto.SignatureDTO;
import mao.sms_entity.dto.TemplateDTO;
import mao.sms_entity.entity.ConfigTemplateEntity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ConfigTemplateServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ConfigTemplateServiceImplTest
{
    @MockBean
    private ConfigTemplateMapper configTemplateMapper;

    @Autowired
    private ConfigTemplateServiceImpl configTemplateServiceImpl;

    /**
     * Method under test: {@link ConfigTemplateServiceImpl#merge(ConfigDTO)}
     */
    @Test
    void testMerge()
    {
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
        PlatformDTO platformDTO = new PlatformDTO();
        configDTO.setPlatformDTO(platformDTO);
        configDTO.setRemark("Remark");
        configDTO.setSignatureDTOS(new ArrayList<>());
        configDTO.setSignatureIds(new ArrayList<>());
        configDTO.setTemplateDTOS(new ArrayList<>());
        configDTO.setTemplateIds(new ArrayList<>());
        configDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configDTO.setUpdateUser("2020-03-01");
        this.configTemplateServiceImpl.merge(configDTO);
        assertEquals("EXAMPLEakiAIOSFODNN7", configDTO.getAccessKeyId());
        assertEquals("2020-03-01", configDTO.getUpdateUser());
        assertTrue(configDTO.getTemplateIds().isEmpty());
        assertEquals("01:01", configDTO.getUpdateTime().toLocalTime().toString());
        assertTrue(configDTO.getTemplateDTOS().isEmpty());
        assertTrue(configDTO.getSignatureIds().isEmpty());
        assertTrue(configDTO.getSignatureDTOS().isEmpty());
        assertEquals("Remark", configDTO.getRemark());
        assertSame(platformDTO, configDTO.getPlatformDTO());
        assertEquals("Platform", configDTO.getPlatform());
        assertEquals("EXAMPLEakiAIOSFODNN7", configDTO.getAccessKeySecret());
        assertEquals(1, configDTO.getIsActive().intValue());
        assertEquals("01:01", configDTO.getCreateTime().toLocalTime().toString());
        assertEquals(1, configDTO.getIsDelete().intValue());
        assertEquals("Create User", configDTO.getCreateUser());
        assertEquals(1, configDTO.getIsEnable().intValue());
        assertEquals(10, configDTO.getLastSuccessNum());
        assertEquals(1, configDTO.getChannelType().intValue());
        assertEquals("Domain", configDTO.getDomain());
        assertEquals(10, configDTO.getLastSuccessNumInAnHour());
        assertEquals(1, configDTO.getLevel().intValue());
        assertEquals("42", configDTO.getId());
        assertEquals("Name", configDTO.getName());
        assertEquals("Other", configDTO.getOther());
    }

    /**
     * Method under test: {@link ConfigTemplateServiceImpl#merge(ConfigDTO)}
     */
    @Test
    void testMerge2()
    {
        ConfigDTO configDTO = mock(ConfigDTO.class);
        when(configDTO.getTemplateIds()).thenReturn(new ArrayList<>());
        doNothing().when(configDTO).setLastSuccessNum(anyInt());
        doNothing().when(configDTO).setLastSuccessNumInAnHour(anyInt());
        doNothing().when(configDTO).setPlatformDTO((PlatformDTO) any());
        doNothing().when(configDTO).setSignatureDTOS((List<SignatureDTO>) any());
        doNothing().when(configDTO).setSignatureIds((List<String>) any());
        doNothing().when(configDTO).setTemplateDTOS((List<TemplateDTO>) any());
        doNothing().when(configDTO).setTemplateIds((List<String>) any());
        doNothing().when(configDTO).setAccessKeyId((String) any());
        doNothing().when(configDTO).setAccessKeySecret((String) any());
        doNothing().when(configDTO).setChannelType((Integer) any());
        doNothing().when(configDTO).setDomain((String) any());
        doNothing().when(configDTO).setIsActive((Integer) any());
        doNothing().when(configDTO).setIsEnable((Integer) any());
        doNothing().when(configDTO).setLevel((Integer) any());
        doNothing().when(configDTO).setName((String) any());
        doNothing().when(configDTO).setOther((String) any());
        doNothing().when(configDTO).setPlatform((String) any());
        doNothing().when(configDTO).setRemark((String) any());
        doNothing().when(configDTO).setCreateTime((LocalDateTime) any());
        doNothing().when(configDTO).setCreateUser((String) any());
        doNothing().when(configDTO).setId((String) any());
        doNothing().when(configDTO).setIsDelete((Integer) any());
        doNothing().when(configDTO).setUpdateTime((LocalDateTime) any());
        doNothing().when(configDTO).setUpdateUser((String) any());
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
        this.configTemplateServiceImpl.merge(configDTO);
        verify(configDTO).getTemplateIds();
        verify(configDTO).setLastSuccessNum(anyInt());
        verify(configDTO).setLastSuccessNumInAnHour(anyInt());
        verify(configDTO).setPlatformDTO((PlatformDTO) any());
        verify(configDTO).setSignatureDTOS((List<SignatureDTO>) any());
        verify(configDTO).setSignatureIds((List<String>) any());
        verify(configDTO).setTemplateDTOS((List<TemplateDTO>) any());
        verify(configDTO).setTemplateIds((List<String>) any());
        verify(configDTO).setAccessKeyId((String) any());
        verify(configDTO).setAccessKeySecret((String) any());
        verify(configDTO).setChannelType((Integer) any());
        verify(configDTO).setDomain((String) any());
        verify(configDTO).setIsActive((Integer) any());
        verify(configDTO).setIsEnable((Integer) any());
        verify(configDTO).setLevel((Integer) any());
        verify(configDTO).setName((String) any());
        verify(configDTO).setOther((String) any());
        verify(configDTO).setPlatform((String) any());
        verify(configDTO).setRemark((String) any());
        verify(configDTO).setCreateTime((LocalDateTime) any());
        verify(configDTO).setCreateUser((String) any());
        verify(configDTO).setId((String) any());
        verify(configDTO).setIsDelete((Integer) any());
        verify(configDTO).setUpdateTime((LocalDateTime) any());
        verify(configDTO).setUpdateUser((String) any());
    }

    /**
     * Method under test: {@link ConfigTemplateServiceImpl#merge(ConfigDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMerge3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Error: Cannot execute table Method, ClassGenricType not found .
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.extension.toolkit.SqlHelper.table(SqlHelper.java:86)
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.sqlStatement(ServiceImpl.java:99)
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.saveBatch(ServiceImpl.java:117)
        //       at com.baomidou.mybatisplus.extension.service.IService.saveBatch(IService.java:58)
        //       at mao.sms_manage.service.impl.ConfigTemplateServiceImpl.merge(ConfigTemplateServiceImpl.java:65)
        //   In order to prevent merge(ConfigDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   merge(ConfigDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.configTemplateMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ConfigTemplateEntity>) any()))
                .thenReturn(new ArrayList<>());

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        ConfigDTO configDTO = mock(ConfigDTO.class);
        when(configDTO.getId()).thenReturn("42");
        when(configDTO.getTemplateIds()).thenReturn(stringList);
        doNothing().when(configDTO).setLastSuccessNum(anyInt());
        doNothing().when(configDTO).setLastSuccessNumInAnHour(anyInt());
        doNothing().when(configDTO).setPlatformDTO((PlatformDTO) any());
        doNothing().when(configDTO).setSignatureDTOS((java.util.List<SignatureDTO>) any());
        doNothing().when(configDTO).setSignatureIds((java.util.List<String>) any());
        doNothing().when(configDTO).setTemplateDTOS((java.util.List<TemplateDTO>) any());
        doNothing().when(configDTO).setTemplateIds((java.util.List<String>) any());
        doNothing().when(configDTO).setAccessKeyId((String) any());
        doNothing().when(configDTO).setAccessKeySecret((String) any());
        doNothing().when(configDTO).setChannelType((Integer) any());
        doNothing().when(configDTO).setDomain((String) any());
        doNothing().when(configDTO).setIsActive((Integer) any());
        doNothing().when(configDTO).setIsEnable((Integer) any());
        doNothing().when(configDTO).setLevel((Integer) any());
        doNothing().when(configDTO).setName((String) any());
        doNothing().when(configDTO).setOther((String) any());
        doNothing().when(configDTO).setPlatform((String) any());
        doNothing().when(configDTO).setRemark((String) any());
        doNothing().when(configDTO).setCreateTime((LocalDateTime) any());
        doNothing().when(configDTO).setCreateUser((String) any());
        doNothing().when(configDTO).setId((String) any());
        doNothing().when(configDTO).setIsDelete((Integer) any());
        doNothing().when(configDTO).setUpdateTime((LocalDateTime) any());
        doNothing().when(configDTO).setUpdateUser((String) any());
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
        this.configTemplateServiceImpl.merge(configDTO);
    }

    /**
     * Method under test: {@link ConfigTemplateServiceImpl#merge(ConfigDTO)}
     */
    @Test
    void testMerge4()
    {
        when(this.configTemplateMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ConfigTemplateEntity>) any()))
                .thenReturn(new ArrayList<>());

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        ConfigDTO configDTO = mock(ConfigDTO.class);
        when(configDTO.getId()).thenThrow(new IllegalArgumentException("foo"));
        when(configDTO.getTemplateIds()).thenReturn(stringList);
        doNothing().when(configDTO).setLastSuccessNum(anyInt());
        doNothing().when(configDTO).setLastSuccessNumInAnHour(anyInt());
        doNothing().when(configDTO).setPlatformDTO((PlatformDTO) any());
        doNothing().when(configDTO).setSignatureDTOS((List<SignatureDTO>) any());
        doNothing().when(configDTO).setSignatureIds((List<String>) any());
        doNothing().when(configDTO).setTemplateDTOS((List<TemplateDTO>) any());
        doNothing().when(configDTO).setTemplateIds((List<String>) any());
        doNothing().when(configDTO).setAccessKeyId((String) any());
        doNothing().when(configDTO).setAccessKeySecret((String) any());
        doNothing().when(configDTO).setChannelType((Integer) any());
        doNothing().when(configDTO).setDomain((String) any());
        doNothing().when(configDTO).setIsActive((Integer) any());
        doNothing().when(configDTO).setIsEnable((Integer) any());
        doNothing().when(configDTO).setLevel((Integer) any());
        doNothing().when(configDTO).setName((String) any());
        doNothing().when(configDTO).setOther((String) any());
        doNothing().when(configDTO).setPlatform((String) any());
        doNothing().when(configDTO).setRemark((String) any());
        doNothing().when(configDTO).setCreateTime((LocalDateTime) any());
        doNothing().when(configDTO).setCreateUser((String) any());
        doNothing().when(configDTO).setId((String) any());
        doNothing().when(configDTO).setIsDelete((Integer) any());
        doNothing().when(configDTO).setUpdateTime((LocalDateTime) any());
        doNothing().when(configDTO).setUpdateUser((String) any());
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
        assertThrows(IllegalArgumentException.class, () -> this.configTemplateServiceImpl.merge(configDTO));
        verify(configDTO).getId();
        verify(configDTO).getTemplateIds();
        verify(configDTO).setLastSuccessNum(anyInt());
        verify(configDTO).setLastSuccessNumInAnHour(anyInt());
        verify(configDTO).setPlatformDTO((PlatformDTO) any());
        verify(configDTO).setSignatureDTOS((List<SignatureDTO>) any());
        verify(configDTO).setSignatureIds((List<String>) any());
        verify(configDTO).setTemplateDTOS((List<TemplateDTO>) any());
        verify(configDTO).setTemplateIds((List<String>) any());
        verify(configDTO).setAccessKeyId((String) any());
        verify(configDTO).setAccessKeySecret((String) any());
        verify(configDTO).setChannelType((Integer) any());
        verify(configDTO).setDomain((String) any());
        verify(configDTO).setIsActive((Integer) any());
        verify(configDTO).setIsEnable((Integer) any());
        verify(configDTO).setLevel((Integer) any());
        verify(configDTO).setName((String) any());
        verify(configDTO).setOther((String) any());
        verify(configDTO).setPlatform((String) any());
        verify(configDTO).setRemark((String) any());
        verify(configDTO).setCreateTime((LocalDateTime) any());
        verify(configDTO).setCreateUser((String) any());
        verify(configDTO).setId((String) any());
        verify(configDTO).setIsDelete((Integer) any());
        verify(configDTO).setUpdateTime((LocalDateTime) any());
        verify(configDTO).setUpdateUser((String) any());
    }

    /**
     * Method under test: {@link ConfigTemplateServiceImpl#merge(ConfigDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMerge5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Error: Cannot execute table Method, ClassGenricType not found .
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.extension.toolkit.SqlHelper.table(SqlHelper.java:86)
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.sqlStatement(ServiceImpl.java:99)
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.saveBatch(ServiceImpl.java:117)
        //       at com.baomidou.mybatisplus.extension.service.IService.saveBatch(IService.java:58)
        //       at mao.sms_manage.service.impl.ConfigTemplateServiceImpl.merge(ConfigTemplateServiceImpl.java:65)
        //   In order to prevent merge(ConfigDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   merge(ConfigDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigTemplateEntity configTemplateEntity = new ConfigTemplateEntity();
        configTemplateEntity.setConfigId("42");
        configTemplateEntity.setConfigTemplateCode("Config Template Code");
        configTemplateEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configTemplateEntity.setCreateUser("Create User");
        configTemplateEntity.setId("42");
        configTemplateEntity.setIsDelete(1);
        configTemplateEntity.setRemark("Remark");
        configTemplateEntity.setTemplateId("42");
        configTemplateEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configTemplateEntity.setUpdateUser("2020-03-01");

        ArrayList<ConfigTemplateEntity> configTemplateEntityList = new ArrayList<>();
        configTemplateEntityList.add(configTemplateEntity);
        when(this.configTemplateMapper
                .delete((com.baomidou.mybatisplus.core.conditions.Wrapper<ConfigTemplateEntity>) any())).thenReturn(1);
        when(this.configTemplateMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ConfigTemplateEntity>) any()))
                .thenReturn(configTemplateEntityList);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        ConfigDTO configDTO = mock(ConfigDTO.class);
        when(configDTO.getId()).thenReturn("42");
        when(configDTO.getTemplateIds()).thenReturn(stringList);
        doNothing().when(configDTO).setLastSuccessNum(anyInt());
        doNothing().when(configDTO).setLastSuccessNumInAnHour(anyInt());
        doNothing().when(configDTO).setPlatformDTO((PlatformDTO) any());
        doNothing().when(configDTO).setSignatureDTOS((java.util.List<SignatureDTO>) any());
        doNothing().when(configDTO).setSignatureIds((java.util.List<String>) any());
        doNothing().when(configDTO).setTemplateDTOS((java.util.List<TemplateDTO>) any());
        doNothing().when(configDTO).setTemplateIds((java.util.List<String>) any());
        doNothing().when(configDTO).setAccessKeyId((String) any());
        doNothing().when(configDTO).setAccessKeySecret((String) any());
        doNothing().when(configDTO).setChannelType((Integer) any());
        doNothing().when(configDTO).setDomain((String) any());
        doNothing().when(configDTO).setIsActive((Integer) any());
        doNothing().when(configDTO).setIsEnable((Integer) any());
        doNothing().when(configDTO).setLevel((Integer) any());
        doNothing().when(configDTO).setName((String) any());
        doNothing().when(configDTO).setOther((String) any());
        doNothing().when(configDTO).setPlatform((String) any());
        doNothing().when(configDTO).setRemark((String) any());
        doNothing().when(configDTO).setCreateTime((LocalDateTime) any());
        doNothing().when(configDTO).setCreateUser((String) any());
        doNothing().when(configDTO).setId((String) any());
        doNothing().when(configDTO).setIsDelete((Integer) any());
        doNothing().when(configDTO).setUpdateTime((LocalDateTime) any());
        doNothing().when(configDTO).setUpdateUser((String) any());
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
        this.configTemplateServiceImpl.merge(configDTO);
    }

    /**
     * Method under test: {@link ConfigTemplateServiceImpl#merge(ConfigDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMerge6()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Error: Cannot execute table Method, ClassGenricType not found .
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.extension.toolkit.SqlHelper.table(SqlHelper.java:86)
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.sqlStatement(ServiceImpl.java:99)
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.saveBatch(ServiceImpl.java:117)
        //       at com.baomidou.mybatisplus.extension.service.IService.saveBatch(IService.java:58)
        //       at mao.sms_manage.service.impl.ConfigTemplateServiceImpl.merge(ConfigTemplateServiceImpl.java:65)
        //   In order to prevent merge(ConfigDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   merge(ConfigDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigTemplateEntity configTemplateEntity = new ConfigTemplateEntity();
        configTemplateEntity.setConfigId("42");
        configTemplateEntity.setConfigTemplateCode("Config Template Code");
        configTemplateEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configTemplateEntity.setCreateUser("Create User");
        configTemplateEntity.setId("42");
        configTemplateEntity.setIsDelete(1);
        configTemplateEntity.setRemark("Remark");
        configTemplateEntity.setTemplateId("42");
        configTemplateEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configTemplateEntity.setUpdateUser("2020-03-01");

        ArrayList<ConfigTemplateEntity> configTemplateEntityList = new ArrayList<>();
        configTemplateEntityList.add(configTemplateEntity);
        when(this.configTemplateMapper
                .delete((com.baomidou.mybatisplus.core.conditions.Wrapper<ConfigTemplateEntity>) any())).thenReturn(0);
        when(this.configTemplateMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ConfigTemplateEntity>) any()))
                .thenReturn(configTemplateEntityList);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        ConfigDTO configDTO = mock(ConfigDTO.class);
        when(configDTO.getId()).thenReturn("42");
        when(configDTO.getTemplateIds()).thenReturn(stringList);
        doNothing().when(configDTO).setLastSuccessNum(anyInt());
        doNothing().when(configDTO).setLastSuccessNumInAnHour(anyInt());
        doNothing().when(configDTO).setPlatformDTO((PlatformDTO) any());
        doNothing().when(configDTO).setSignatureDTOS((java.util.List<SignatureDTO>) any());
        doNothing().when(configDTO).setSignatureIds((java.util.List<String>) any());
        doNothing().when(configDTO).setTemplateDTOS((java.util.List<TemplateDTO>) any());
        doNothing().when(configDTO).setTemplateIds((java.util.List<String>) any());
        doNothing().when(configDTO).setAccessKeyId((String) any());
        doNothing().when(configDTO).setAccessKeySecret((String) any());
        doNothing().when(configDTO).setChannelType((Integer) any());
        doNothing().when(configDTO).setDomain((String) any());
        doNothing().when(configDTO).setIsActive((Integer) any());
        doNothing().when(configDTO).setIsEnable((Integer) any());
        doNothing().when(configDTO).setLevel((Integer) any());
        doNothing().when(configDTO).setName((String) any());
        doNothing().when(configDTO).setOther((String) any());
        doNothing().when(configDTO).setPlatform((String) any());
        doNothing().when(configDTO).setRemark((String) any());
        doNothing().when(configDTO).setCreateTime((LocalDateTime) any());
        doNothing().when(configDTO).setCreateUser((String) any());
        doNothing().when(configDTO).setId((String) any());
        doNothing().when(configDTO).setIsDelete((Integer) any());
        doNothing().when(configDTO).setUpdateTime((LocalDateTime) any());
        doNothing().when(configDTO).setUpdateUser((String) any());
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
        this.configTemplateServiceImpl.merge(configDTO);
    }

    /**
     * Method under test: {@link ConfigTemplateServiceImpl#merge(ConfigDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMerge7()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Error: Cannot execute table Method, ClassGenricType not found .
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.extension.toolkit.SqlHelper.table(SqlHelper.java:86)
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.sqlStatement(ServiceImpl.java:99)
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.saveBatch(ServiceImpl.java:117)
        //       at com.baomidou.mybatisplus.extension.service.IService.saveBatch(IService.java:58)
        //       at mao.sms_manage.service.impl.ConfigTemplateServiceImpl.merge(ConfigTemplateServiceImpl.java:65)
        //   In order to prevent merge(ConfigDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   merge(ConfigDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigTemplateEntity configTemplateEntity = new ConfigTemplateEntity();
        configTemplateEntity.setConfigId("42");
        configTemplateEntity.setConfigTemplateCode("Config Template Code");
        configTemplateEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configTemplateEntity.setCreateUser("Create User");
        configTemplateEntity.setId("42");
        configTemplateEntity.setIsDelete(1);
        configTemplateEntity.setRemark("Remark");
        configTemplateEntity.setTemplateId("42");
        configTemplateEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configTemplateEntity.setUpdateUser("2020-03-01");

        ConfigTemplateEntity configTemplateEntity1 = new ConfigTemplateEntity();
        configTemplateEntity1.setConfigId("42");
        configTemplateEntity1.setConfigTemplateCode("删除成功 config:{} deleteIds:{}");
        configTemplateEntity1.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configTemplateEntity1.setCreateUser("删除成功 config:{} deleteIds:{}");
        configTemplateEntity1.setId("42");
        configTemplateEntity1.setIsDelete(1);
        configTemplateEntity1.setRemark("删除成功 config:{} deleteIds:{}");
        configTemplateEntity1.setTemplateId("42");
        configTemplateEntity1.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configTemplateEntity1.setUpdateUser("2020-03-01");

        ArrayList<ConfigTemplateEntity> configTemplateEntityList = new ArrayList<>();
        configTemplateEntityList.add(configTemplateEntity1);
        configTemplateEntityList.add(configTemplateEntity);
        when(this.configTemplateMapper
                .delete((com.baomidou.mybatisplus.core.conditions.Wrapper<ConfigTemplateEntity>) any())).thenReturn(1);
        when(this.configTemplateMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ConfigTemplateEntity>) any()))
                .thenReturn(configTemplateEntityList);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        ConfigDTO configDTO = mock(ConfigDTO.class);
        when(configDTO.getId()).thenReturn("42");
        when(configDTO.getTemplateIds()).thenReturn(stringList);
        doNothing().when(configDTO).setLastSuccessNum(anyInt());
        doNothing().when(configDTO).setLastSuccessNumInAnHour(anyInt());
        doNothing().when(configDTO).setPlatformDTO((PlatformDTO) any());
        doNothing().when(configDTO).setSignatureDTOS((java.util.List<SignatureDTO>) any());
        doNothing().when(configDTO).setSignatureIds((java.util.List<String>) any());
        doNothing().when(configDTO).setTemplateDTOS((java.util.List<TemplateDTO>) any());
        doNothing().when(configDTO).setTemplateIds((java.util.List<String>) any());
        doNothing().when(configDTO).setAccessKeyId((String) any());
        doNothing().when(configDTO).setAccessKeySecret((String) any());
        doNothing().when(configDTO).setChannelType((Integer) any());
        doNothing().when(configDTO).setDomain((String) any());
        doNothing().when(configDTO).setIsActive((Integer) any());
        doNothing().when(configDTO).setIsEnable((Integer) any());
        doNothing().when(configDTO).setLevel((Integer) any());
        doNothing().when(configDTO).setName((String) any());
        doNothing().when(configDTO).setOther((String) any());
        doNothing().when(configDTO).setPlatform((String) any());
        doNothing().when(configDTO).setRemark((String) any());
        doNothing().when(configDTO).setCreateTime((LocalDateTime) any());
        doNothing().when(configDTO).setCreateUser((String) any());
        doNothing().when(configDTO).setId((String) any());
        doNothing().when(configDTO).setIsDelete((Integer) any());
        doNothing().when(configDTO).setUpdateTime((LocalDateTime) any());
        doNothing().when(configDTO).setUpdateUser((String) any());
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
        this.configTemplateServiceImpl.merge(configDTO);
    }

    /**
     * Method under test: {@link ConfigTemplateServiceImpl#merge(ConfigDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMerge8()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Error: Cannot execute table Method, ClassGenricType not found .
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.extension.toolkit.SqlHelper.table(SqlHelper.java:86)
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.sqlStatement(ServiceImpl.java:99)
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.saveBatch(ServiceImpl.java:117)
        //       at com.baomidou.mybatisplus.extension.service.IService.saveBatch(IService.java:58)
        //       at mao.sms_manage.service.impl.ConfigTemplateServiceImpl.merge(ConfigTemplateServiceImpl.java:65)
        //   In order to prevent merge(ConfigDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   merge(ConfigDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigTemplateEntity configTemplateEntity = new ConfigTemplateEntity();
        configTemplateEntity.setConfigId("42");
        configTemplateEntity.setConfigTemplateCode("Config Template Code");
        configTemplateEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configTemplateEntity.setCreateUser("Create User");
        configTemplateEntity.setId("42");
        configTemplateEntity.setIsDelete(1);
        configTemplateEntity.setRemark("Remark");
        configTemplateEntity.setTemplateId("42");
        configTemplateEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configTemplateEntity.setUpdateUser("2020-03-01");

        ArrayList<ConfigTemplateEntity> configTemplateEntityList = new ArrayList<>();
        configTemplateEntityList.add(configTemplateEntity);
        when(this.configTemplateMapper
                .delete((com.baomidou.mybatisplus.core.conditions.Wrapper<ConfigTemplateEntity>) any())).thenReturn(1);
        when(this.configTemplateMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ConfigTemplateEntity>) any()))
                .thenReturn(configTemplateEntityList);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("删除成功 config:{} deleteIds:{}");
        stringList.add("foo");
        ConfigDTO configDTO = mock(ConfigDTO.class);
        when(configDTO.getId()).thenReturn("42");
        when(configDTO.getTemplateIds()).thenReturn(stringList);
        doNothing().when(configDTO).setLastSuccessNum(anyInt());
        doNothing().when(configDTO).setLastSuccessNumInAnHour(anyInt());
        doNothing().when(configDTO).setPlatformDTO((PlatformDTO) any());
        doNothing().when(configDTO).setSignatureDTOS((java.util.List<SignatureDTO>) any());
        doNothing().when(configDTO).setSignatureIds((java.util.List<String>) any());
        doNothing().when(configDTO).setTemplateDTOS((java.util.List<TemplateDTO>) any());
        doNothing().when(configDTO).setTemplateIds((java.util.List<String>) any());
        doNothing().when(configDTO).setAccessKeyId((String) any());
        doNothing().when(configDTO).setAccessKeySecret((String) any());
        doNothing().when(configDTO).setChannelType((Integer) any());
        doNothing().when(configDTO).setDomain((String) any());
        doNothing().when(configDTO).setIsActive((Integer) any());
        doNothing().when(configDTO).setIsEnable((Integer) any());
        doNothing().when(configDTO).setLevel((Integer) any());
        doNothing().when(configDTO).setName((String) any());
        doNothing().when(configDTO).setOther((String) any());
        doNothing().when(configDTO).setPlatform((String) any());
        doNothing().when(configDTO).setRemark((String) any());
        doNothing().when(configDTO).setCreateTime((LocalDateTime) any());
        doNothing().when(configDTO).setCreateUser((String) any());
        doNothing().when(configDTO).setId((String) any());
        doNothing().when(configDTO).setIsDelete((Integer) any());
        doNothing().when(configDTO).setUpdateTime((LocalDateTime) any());
        doNothing().when(configDTO).setUpdateUser((String) any());
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
        this.configTemplateServiceImpl.merge(configDTO);
    }

    /**
     * Method under test: {@link ConfigTemplateServiceImpl#merge(ConfigDTO)}
     */
    @Test
    void testMerge9()
    {
        ConfigTemplateEntity configTemplateEntity = new ConfigTemplateEntity();
        configTemplateEntity.setConfigId("42");
        configTemplateEntity.setConfigTemplateCode("Config Template Code");
        configTemplateEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configTemplateEntity.setCreateUser("Create User");
        configTemplateEntity.setId("42");
        configTemplateEntity.setIsDelete(1);
        configTemplateEntity.setRemark("Remark");
        configTemplateEntity.setTemplateId("42");
        configTemplateEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configTemplateEntity.setUpdateUser("2020-03-01");

        ArrayList<ConfigTemplateEntity> configTemplateEntityList = new ArrayList<>();
        configTemplateEntityList.add(configTemplateEntity);
        when(this.configTemplateMapper
                .delete((com.baomidou.mybatisplus.core.conditions.Wrapper<ConfigTemplateEntity>) any())).thenReturn(1);
        when(this.configTemplateMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ConfigTemplateEntity>) any()))
                .thenReturn(configTemplateEntityList);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("42");
        ConfigDTO configDTO = mock(ConfigDTO.class);
        when(configDTO.getId()).thenReturn("42");
        when(configDTO.getTemplateIds()).thenReturn(stringList);
        doNothing().when(configDTO).setLastSuccessNum(anyInt());
        doNothing().when(configDTO).setLastSuccessNumInAnHour(anyInt());
        doNothing().when(configDTO).setPlatformDTO((PlatformDTO) any());
        doNothing().when(configDTO).setSignatureDTOS((List<SignatureDTO>) any());
        doNothing().when(configDTO).setSignatureIds((List<String>) any());
        doNothing().when(configDTO).setTemplateDTOS((List<TemplateDTO>) any());
        doNothing().when(configDTO).setTemplateIds((List<String>) any());
        doNothing().when(configDTO).setAccessKeyId((String) any());
        doNothing().when(configDTO).setAccessKeySecret((String) any());
        doNothing().when(configDTO).setChannelType((Integer) any());
        doNothing().when(configDTO).setDomain((String) any());
        doNothing().when(configDTO).setIsActive((Integer) any());
        doNothing().when(configDTO).setIsEnable((Integer) any());
        doNothing().when(configDTO).setLevel((Integer) any());
        doNothing().when(configDTO).setName((String) any());
        doNothing().when(configDTO).setOther((String) any());
        doNothing().when(configDTO).setPlatform((String) any());
        doNothing().when(configDTO).setRemark((String) any());
        doNothing().when(configDTO).setCreateTime((LocalDateTime) any());
        doNothing().when(configDTO).setCreateUser((String) any());
        doNothing().when(configDTO).setId((String) any());
        doNothing().when(configDTO).setIsDelete((Integer) any());
        doNothing().when(configDTO).setUpdateTime((LocalDateTime) any());
        doNothing().when(configDTO).setUpdateUser((String) any());
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
        this.configTemplateServiceImpl.merge(configDTO);
        verify(this.configTemplateMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ConfigTemplateEntity>) any());
        verify(configDTO).getId();
        verify(configDTO, atLeast(1)).getTemplateIds();
        verify(configDTO).setLastSuccessNum(anyInt());
        verify(configDTO).setLastSuccessNumInAnHour(anyInt());
        verify(configDTO).setPlatformDTO((PlatformDTO) any());
        verify(configDTO).setSignatureDTOS((List<SignatureDTO>) any());
        verify(configDTO).setSignatureIds((List<String>) any());
        verify(configDTO).setTemplateDTOS((List<TemplateDTO>) any());
        verify(configDTO).setTemplateIds((List<String>) any());
        verify(configDTO).setAccessKeyId((String) any());
        verify(configDTO).setAccessKeySecret((String) any());
        verify(configDTO).setChannelType((Integer) any());
        verify(configDTO).setDomain((String) any());
        verify(configDTO).setIsActive((Integer) any());
        verify(configDTO).setIsEnable((Integer) any());
        verify(configDTO).setLevel((Integer) any());
        verify(configDTO).setName((String) any());
        verify(configDTO).setOther((String) any());
        verify(configDTO).setPlatform((String) any());
        verify(configDTO).setRemark((String) any());
        verify(configDTO).setCreateTime((LocalDateTime) any());
        verify(configDTO).setCreateUser((String) any());
        verify(configDTO).setId((String) any());
        verify(configDTO).setIsDelete((Integer) any());
        verify(configDTO).setUpdateTime((LocalDateTime) any());
        verify(configDTO).setUpdateUser((String) any());
    }
}

