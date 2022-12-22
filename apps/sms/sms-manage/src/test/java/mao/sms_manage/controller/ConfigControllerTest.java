package mao.sms_manage.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.sms_entity.dto.ConfigDTO;
import mao.sms_entity.dto.ConfigUpdateOtherDTO;
import mao.sms_entity.dto.PlatformDTO;
import mao.sms_entity.dto.SignatureDTO;
import mao.sms_entity.dto.TemplateDTO;

import mao.sms_manage.service.ConfigService;
import mao.sms_manage.service.ConfigSignatureService;
import mao.sms_manage.service.ConfigTemplateService;
import mao.sms_manage.service.SignatureService;
import mao.sms_manage.service.TemplateService;
import mao.tools_core.base.R;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ConfigController.class})
@ExtendWith(SpringExtension.class)
class ConfigControllerTest
{
    @Autowired
    private ConfigController configController;

    @MockBean
    private ConfigService configService;

    @MockBean
    private ConfigSignatureService configSignatureService;

    @MockBean
    private ConfigTemplateService configTemplateService;

    @MockBean
    private DozerUtils dozerUtils;

    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @MockBean
    private SignatureService signatureService;

    @MockBean
    private TemplateService templateService;

    /**
     * Method under test: {@link ConfigController#page(ConfigDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPage()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.sms_manage.controller.ConfigController.page(ConfigController.java:91)
        //   In order to prevent page(ConfigDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   page(ConfigDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigController configController = new ConfigController();

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
        configController.page(configDTO);
    }

    /**
     * Method under test: {@link ConfigController#page(ConfigDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPage2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.sms_manage.controller.ConfigController.page(ConfigController.java:91)
        //   In order to prevent page(ConfigDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   page(ConfigDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigController configController = new ConfigController();
        ConfigDTO configDTO = mock(ConfigDTO.class);
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
        configController.page(configDTO);
    }

    /**
     * Method under test: {@link ConfigController#delete(java.util.List)}
     */
    @Test
    void testDelete() throws Exception
    {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/config")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ArrayList<>()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.configController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }

    /**
     * Method under test: {@link ConfigController#get(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGet()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.controller.ConfigController.get(ConfigController.java:119)
        //   In order to prevent get(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   get(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new ConfigController()).get("42");
    }

    /**
     * Method under test: {@link ConfigController#level(java.util.List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLevel()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.controller.ConfigController.level(ConfigController.java:193)
        //   In order to prevent level(List)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   level(List).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigController configController = new ConfigController();
        configController.level(new ArrayList<>());
    }

    /**
     * Method under test: {@link ConfigController#level(java.util.List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLevel2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [level] of entity [mao.sms_entity.entity.ConfigEntity]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:79)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:32)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.sms_manage.controller.ConfigController.level(ConfigController.java:191)
        //   In order to prevent level(List)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   level(List).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigController configController = new ConfigController();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        configController.level(stringList);
    }

    /**
     * Method under test: {@link ConfigController#updateOther(ConfigUpdateOtherDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateOther()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [configSignatureCode] of entity [mao.sms_entity.entity.ConfigSignatureEntity]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:79)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:32)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.sms_manage.controller.ConfigController.updateOther(ConfigController.java:243)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPut(FrameworkServlet.java:920)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent updateOther(ConfigUpdateOtherDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateOther(ConfigUpdateOtherDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [configSignatureCode] of entity [mao.sms_entity.entity.ConfigSignatureEntity]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:79)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:32)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.sms_manage.controller.ConfigController.updateOther(ConfigController.java:243)
        //   In order to prevent updateOther(ConfigUpdateOtherDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateOther(ConfigUpdateOtherDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigController configController = new ConfigController();

        ConfigUpdateOtherDTO configUpdateOtherDTO = new ConfigUpdateOtherDTO();
        configUpdateOtherDTO.setConfigId("42");
        configUpdateOtherDTO.setConfigSignatureCode("Config Signature Code");
        configUpdateOtherDTO.setConfigTemplateCode("Config Template Code");
        configUpdateOtherDTO.setSignatureId("42");
        configUpdateOtherDTO.setTemplateId("42");
        configController.updateOther(configUpdateOtherDTO);
    }

    /**
     * Method under test: {@link ConfigController#updateOther(ConfigUpdateOtherDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateOther2()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [configSignatureCode] of entity [mao.sms_entity.entity.ConfigSignatureEntity]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:79)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:32)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.sms_manage.controller.ConfigController.updateOther(ConfigController.java:243)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPut(FrameworkServlet.java:920)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent updateOther(ConfigUpdateOtherDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateOther(ConfigUpdateOtherDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [configSignatureCode] of entity [mao.sms_entity.entity.ConfigSignatureEntity]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:79)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:32)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.sms_manage.controller.ConfigController.updateOther(ConfigController.java:243)
        //   In order to prevent updateOther(ConfigUpdateOtherDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateOther(ConfigUpdateOtherDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigController configController = new ConfigController();
        ConfigUpdateOtherDTO configUpdateOtherDTO = mock(ConfigUpdateOtherDTO.class);
        when(configUpdateOtherDTO.getConfigId()).thenReturn("42");
        when(configUpdateOtherDTO.getConfigSignatureCode()).thenReturn("Config Signature Code");
        when(configUpdateOtherDTO.getSignatureId()).thenReturn("42");
        when(configUpdateOtherDTO.getTemplateId()).thenReturn("42");
        doNothing().when(configUpdateOtherDTO).setConfigId((String) any());
        doNothing().when(configUpdateOtherDTO).setConfigSignatureCode((String) any());
        doNothing().when(configUpdateOtherDTO).setConfigTemplateCode((String) any());
        doNothing().when(configUpdateOtherDTO).setSignatureId((String) any());
        doNothing().when(configUpdateOtherDTO).setTemplateId((String) any());
        configUpdateOtherDTO.setConfigId("42");
        configUpdateOtherDTO.setConfigSignatureCode("Config Signature Code");
        configUpdateOtherDTO.setConfigTemplateCode("Config Template Code");
        configUpdateOtherDTO.setSignatureId("42");
        configUpdateOtherDTO.setTemplateId("42");
        configController.updateOther(configUpdateOtherDTO);
    }

    /**
     * Method under test: {@link ConfigController#updateOther(ConfigUpdateOtherDTO)}
     */
    @Test
    void testUpdateOther3()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [configSignatureCode] of entity [mao.sms_entity.entity.ConfigSignatureEntity]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:79)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:32)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.sms_manage.controller.ConfigController.updateOther(ConfigController.java:243)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPut(FrameworkServlet.java:920)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent updateOther(ConfigUpdateOtherDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateOther(ConfigUpdateOtherDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigController configController = new ConfigController();
        ConfigUpdateOtherDTO configUpdateOtherDTO = mock(ConfigUpdateOtherDTO.class);
        when(configUpdateOtherDTO.getConfigId()).thenThrow(new IllegalArgumentException("(LUUU;)LUUU;"));
        when(configUpdateOtherDTO.getConfigSignatureCode()).thenThrow(new IllegalArgumentException("(LUUU;)LUUU;"));
        when(configUpdateOtherDTO.getSignatureId()).thenReturn("42");
        when(configUpdateOtherDTO.getTemplateId()).thenReturn("42");
        doNothing().when(configUpdateOtherDTO).setConfigId((String) any());
        doNothing().when(configUpdateOtherDTO).setConfigSignatureCode((String) any());
        doNothing().when(configUpdateOtherDTO).setConfigTemplateCode((String) any());
        doNothing().when(configUpdateOtherDTO).setSignatureId((String) any());
        doNothing().when(configUpdateOtherDTO).setTemplateId((String) any());
        configUpdateOtherDTO.setConfigId("42");
        configUpdateOtherDTO.setConfigSignatureCode("Config Signature Code");
        configUpdateOtherDTO.setConfigTemplateCode("Config Template Code");
        configUpdateOtherDTO.setSignatureId("42");
        configUpdateOtherDTO.setTemplateId("42");
        assertThrows(IllegalArgumentException.class, () -> configController.updateOther(configUpdateOtherDTO));
        verify(configUpdateOtherDTO).getConfigId();
        verify(configUpdateOtherDTO).getSignatureId();
        verify(configUpdateOtherDTO).setConfigId((String) any());
        verify(configUpdateOtherDTO).setConfigSignatureCode((String) any());
        verify(configUpdateOtherDTO).setConfigTemplateCode((String) any());
        verify(configUpdateOtherDTO).setSignatureId((String) any());
        verify(configUpdateOtherDTO).setTemplateId((String) any());
    }

    /**
     * Method under test: {@link ConfigController#updateOther(ConfigUpdateOtherDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateOther4()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [configSignatureCode] of entity [mao.sms_entity.entity.ConfigSignatureEntity]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:79)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:32)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.sms_manage.controller.ConfigController.updateOther(ConfigController.java:243)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPut(FrameworkServlet.java:920)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent updateOther(ConfigUpdateOtherDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateOther(ConfigUpdateOtherDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [configTemplateCode] of entity [mao.sms_entity.entity.ConfigTemplateEntity]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:79)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:32)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.sms_manage.controller.ConfigController.updateOther(ConfigController.java:250)
        //   In order to prevent updateOther(ConfigUpdateOtherDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateOther(ConfigUpdateOtherDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigController configController = new ConfigController();
        ConfigUpdateOtherDTO configUpdateOtherDTO = mock(ConfigUpdateOtherDTO.class);
        when(configUpdateOtherDTO.getConfigTemplateCode()).thenReturn("Config Template Code");
        when(configUpdateOtherDTO.getConfigId()).thenReturn("42");
        when(configUpdateOtherDTO.getConfigSignatureCode()).thenReturn("Config Signature Code");
        when(configUpdateOtherDTO.getSignatureId()).thenReturn("");
        when(configUpdateOtherDTO.getTemplateId()).thenReturn("42");
        doNothing().when(configUpdateOtherDTO).setConfigId((String) any());
        doNothing().when(configUpdateOtherDTO).setConfigSignatureCode((String) any());
        doNothing().when(configUpdateOtherDTO).setConfigTemplateCode((String) any());
        doNothing().when(configUpdateOtherDTO).setSignatureId((String) any());
        doNothing().when(configUpdateOtherDTO).setTemplateId((String) any());
        configUpdateOtherDTO.setConfigId("42");
        configUpdateOtherDTO.setConfigSignatureCode("Config Signature Code");
        configUpdateOtherDTO.setConfigTemplateCode("Config Template Code");
        configUpdateOtherDTO.setSignatureId("42");
        configUpdateOtherDTO.setTemplateId("42");
        configController.updateOther(configUpdateOtherDTO);
    }

    /**
     * Method under test: {@link ConfigController#updateOther(ConfigUpdateOtherDTO)}
     */
    @Test
    void testUpdateOther5()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [configSignatureCode] of entity [mao.sms_entity.entity.ConfigSignatureEntity]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:79)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:32)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.sms_manage.controller.ConfigController.updateOther(ConfigController.java:243)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPut(FrameworkServlet.java:920)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent updateOther(ConfigUpdateOtherDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateOther(ConfigUpdateOtherDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigController configController = new ConfigController();
        ConfigUpdateOtherDTO configUpdateOtherDTO = mock(ConfigUpdateOtherDTO.class);
        when(configUpdateOtherDTO.getConfigTemplateCode()).thenReturn("Config Template Code");
        when(configUpdateOtherDTO.getConfigId()).thenReturn("42");
        when(configUpdateOtherDTO.getConfigSignatureCode()).thenReturn("Config Signature Code");
        when(configUpdateOtherDTO.getSignatureId()).thenReturn("");
        when(configUpdateOtherDTO.getTemplateId()).thenReturn("");
        doNothing().when(configUpdateOtherDTO).setConfigId((String) any());
        doNothing().when(configUpdateOtherDTO).setConfigSignatureCode((String) any());
        doNothing().when(configUpdateOtherDTO).setConfigTemplateCode((String) any());
        doNothing().when(configUpdateOtherDTO).setSignatureId((String) any());
        doNothing().when(configUpdateOtherDTO).setTemplateId((String) any());
        configUpdateOtherDTO.setConfigId("42");
        configUpdateOtherDTO.setConfigSignatureCode("Config Signature Code");
        configUpdateOtherDTO.setConfigTemplateCode("Config Template Code");
        configUpdateOtherDTO.setSignatureId("42");
        configUpdateOtherDTO.setTemplateId("42");
        R<Boolean> actualUpdateOtherResult = configController.updateOther(configUpdateOtherDTO);
        assertEquals(0, actualUpdateOtherResult.getCode());
        assertEquals("ok", actualUpdateOtherResult.getMsg());
        assertTrue(actualUpdateOtherResult.getData());
        verify(configUpdateOtherDTO).getSignatureId();
        verify(configUpdateOtherDTO).getTemplateId();
        verify(configUpdateOtherDTO).setConfigId((String) any());
        verify(configUpdateOtherDTO).setConfigSignatureCode((String) any());
        verify(configUpdateOtherDTO).setConfigTemplateCode((String) any());
        verify(configUpdateOtherDTO).setSignatureId((String) any());
        verify(configUpdateOtherDTO).setTemplateId((String) any());
    }

    /**
     * Method under test: {@link ConfigController#updateOther(ConfigUpdateOtherDTO)}
     */
    @Test
    void testUpdateOther6()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [configSignatureCode] of entity [mao.sms_entity.entity.ConfigSignatureEntity]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:79)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:32)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.sms_manage.controller.ConfigController.updateOther(ConfigController.java:243)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPut(FrameworkServlet.java:920)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent updateOther(ConfigUpdateOtherDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateOther(ConfigUpdateOtherDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigController configController = new ConfigController();
        ConfigUpdateOtherDTO configUpdateOtherDTO = mock(ConfigUpdateOtherDTO.class);
        when(configUpdateOtherDTO.getConfigTemplateCode()).thenThrow(new IllegalArgumentException("(LUUU;)LUUU;"));
        when(configUpdateOtherDTO.getConfigId()).thenReturn("42");
        when(configUpdateOtherDTO.getConfigSignatureCode()).thenReturn("Config Signature Code");
        when(configUpdateOtherDTO.getSignatureId()).thenReturn("");
        when(configUpdateOtherDTO.getTemplateId()).thenReturn("42");
        doNothing().when(configUpdateOtherDTO).setConfigId((String) any());
        doNothing().when(configUpdateOtherDTO).setConfigSignatureCode((String) any());
        doNothing().when(configUpdateOtherDTO).setConfigTemplateCode((String) any());
        doNothing().when(configUpdateOtherDTO).setSignatureId((String) any());
        doNothing().when(configUpdateOtherDTO).setTemplateId((String) any());
        configUpdateOtherDTO.setConfigId("42");
        configUpdateOtherDTO.setConfigSignatureCode("Config Signature Code");
        configUpdateOtherDTO.setConfigTemplateCode("Config Template Code");
        configUpdateOtherDTO.setSignatureId("42");
        configUpdateOtherDTO.setTemplateId("42");
        assertThrows(IllegalArgumentException.class, () -> configController.updateOther(configUpdateOtherDTO));
        verify(configUpdateOtherDTO).getConfigId();
        verify(configUpdateOtherDTO).getConfigTemplateCode();
        verify(configUpdateOtherDTO).getSignatureId();
        verify(configUpdateOtherDTO, atLeast(1)).getTemplateId();
        verify(configUpdateOtherDTO).setConfigId((String) any());
        verify(configUpdateOtherDTO).setConfigSignatureCode((String) any());
        verify(configUpdateOtherDTO).setConfigTemplateCode((String) any());
        verify(configUpdateOtherDTO).setSignatureId((String) any());
        verify(configUpdateOtherDTO).setTemplateId((String) any());
    }

    /**
     * Method under test: {@link ConfigController#updateOther(ConfigUpdateOtherDTO)}
     */
    @Test
    void testUpdateOther7()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [configSignatureCode] of entity [mao.sms_entity.entity.ConfigSignatureEntity]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:79)
        //       at mao.tools_databases.mybatis.conditions.update.LbuWrapper.set(LbuWrapper.java:32)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.sms_manage.controller.ConfigController.updateOther(ConfigController.java:243)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPut(FrameworkServlet.java:920)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent updateOther(ConfigUpdateOtherDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateOther(ConfigUpdateOtherDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ConfigController configController = new ConfigController();
        ConfigUpdateOtherDTO configUpdateOtherDTO = mock(ConfigUpdateOtherDTO.class);
        when(configUpdateOtherDTO.getConfigId()).thenThrow(new IllegalArgumentException("(LUUU;)LUUU;"));
        when(configUpdateOtherDTO.getConfigSignatureCode()).thenThrow(new IllegalArgumentException("(LUUU;)LUUU;"));
        when(configUpdateOtherDTO.getSignatureId()).thenReturn("");
        when(configUpdateOtherDTO.getTemplateId()).thenReturn("42");
        doNothing().when(configUpdateOtherDTO).setConfigId((String) any());
        doNothing().when(configUpdateOtherDTO).setConfigSignatureCode((String) any());
        doNothing().when(configUpdateOtherDTO).setConfigTemplateCode((String) any());
        doNothing().when(configUpdateOtherDTO).setSignatureId((String) any());
        doNothing().when(configUpdateOtherDTO).setTemplateId((String) any());
        configUpdateOtherDTO.setConfigId("42");
        configUpdateOtherDTO.setConfigSignatureCode("Config Signature Code");
        configUpdateOtherDTO.setConfigTemplateCode("Config Template Code");
        configUpdateOtherDTO.setSignatureId("42");
        configUpdateOtherDTO.setTemplateId("42");
        assertThrows(IllegalArgumentException.class, () -> configController.updateOther(configUpdateOtherDTO));
        verify(configUpdateOtherDTO).getConfigId();
        verify(configUpdateOtherDTO).getSignatureId();
        verify(configUpdateOtherDTO).getTemplateId();
        verify(configUpdateOtherDTO).setConfigId((String) any());
        verify(configUpdateOtherDTO).setConfigSignatureCode((String) any());
        verify(configUpdateOtherDTO).setConfigTemplateCode((String) any());
        verify(configUpdateOtherDTO).setSignatureId((String) any());
        verify(configUpdateOtherDTO).setTemplateId((String) any());
    }

    /**
     * Method under test: {@link ConfigController#save(ConfigDTO)}
     */
    @Test
    void testSave() throws Exception
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
        configDTO.setPlatformDTO(new PlatformDTO());
        configDTO.setRemark("Remark");
        configDTO.setSignatureDTOS(new ArrayList<>());
        configDTO.setSignatureIds(new ArrayList<>());
        configDTO.setTemplateDTOS(new ArrayList<>());
        configDTO.setTemplateIds(new ArrayList<>());
        configDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configDTO.setUpdateUser("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(configDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/config")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.configController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }

    /**
     * Method under test: {@link ConfigController#update(ConfigDTO)}
     */
    @Test
    void testUpdate() throws Exception
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
        configDTO.setPlatformDTO(new PlatformDTO());
        configDTO.setRemark("Remark");
        configDTO.setSignatureDTOS(new ArrayList<>());
        configDTO.setSignatureIds(new ArrayList<>());
        configDTO.setTemplateDTOS(new ArrayList<>());
        configDTO.setTemplateIds(new ArrayList<>());
        configDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        configDTO.setUpdateUser("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(configDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/config")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.configController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}

