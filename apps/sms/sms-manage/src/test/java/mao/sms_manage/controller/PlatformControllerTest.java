package mao.sms_manage.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.sms_entity.dto.PlatformDTO;
import mao.sms_entity.entity.PlatformEntity;

import mao.sms_manage.service.PlatformService;
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

@ContextConfiguration(classes = {PlatformController.class})
@ExtendWith(SpringExtension.class)
class PlatformControllerTest
{
    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @Autowired
    private PlatformController platformController;

    @MockBean
    private PlatformService platformService;

    /**
     * Method under test: {@link PlatformController#page(PlatformDTO)}
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
        //       at mao.sms_manage.controller.PlatformController.page(PlatformController.java:70)
        //   In order to prevent page(PlatformDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   page(PlatformDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        PlatformController platformController = new PlatformController();
        platformController.page(new PlatformDTO());
    }

    /**
     * Method under test: {@link PlatformController#delete(java.util.List)}
     */
    @Test
    void testDelete() throws Exception
    {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/platform")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ArrayList<>()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.platformController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }

    /**
     * Method under test: {@link PlatformController#get(String)}
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
        //       at mao.sms_manage.controller.PlatformController.get(PlatformController.java:96)
        //   In order to prevent get(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   get(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PlatformController()).get("42");
    }

    /**
     * Method under test: {@link PlatformController#save(PlatformEntity)}
     */
    @Test
    void testSave() throws Exception
    {
        PlatformEntity platformEntity = new PlatformEntity();
        platformEntity.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
        platformEntity.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
        platformEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        platformEntity.setCreateUser("Create User");
        platformEntity.setId("42");
        platformEntity.setIpAddr("42 Main St");
        platformEntity.setIsActive(1);
        platformEntity.setIsDelete(1);
        platformEntity.setLevel(1);
        platformEntity.setName("Name");
        platformEntity.setNeedAuth(1);
        platformEntity.setRemark("Remark");
        platformEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        platformEntity.setUpdateUser("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(platformEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/platform")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.platformController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }

    /**
     * Method under test: {@link PlatformController#update(PlatformEntity)}
     */
    @Test
    void testUpdate() throws Exception
    {
        PlatformEntity platformEntity = new PlatformEntity();
        platformEntity.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
        platformEntity.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
        platformEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        platformEntity.setCreateUser("Create User");
        platformEntity.setId("42");
        platformEntity.setIpAddr("42 Main St");
        platformEntity.setIsActive(1);
        platformEntity.setIsDelete(1);
        platformEntity.setLevel(1);
        platformEntity.setName("Name");
        platformEntity.setNeedAuth(1);
        platformEntity.setRemark("Remark");
        platformEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        platformEntity.setUpdateUser("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(platformEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/platform")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.platformController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}

