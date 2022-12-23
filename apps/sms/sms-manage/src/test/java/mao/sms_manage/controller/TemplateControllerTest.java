package mao.sms_manage.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.sms_entity.dto.TemplateDTO;

import mao.sms_entity.entity.TemplateEntity;
import mao.sms_manage.service.ReceiveLogService;
import mao.sms_manage.service.TemplateService;
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

@ContextConfiguration(classes = {TemplateController.class})
@ExtendWith(SpringExtension.class)
class TemplateControllerTest
{
    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @MockBean
    private ReceiveLogService receiveLogService;

    @Autowired
    private TemplateController templateController;

    @MockBean
    private TemplateService templateService;

    /**
     * Method under test: {@link TemplateController#page(TemplateDTO)}
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
        //       at mao.sms_manage.controller.TemplateController.page(TemplateController.java:77)
        //   In order to prevent page(TemplateDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   page(TemplateDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TemplateController templateController = new TemplateController();

        TemplateDTO templateDTO = new TemplateDTO();
        templateDTO.setCode("Code");
        templateDTO.setConfigId("42");
        templateDTO.setConfigTemplateCode("Config Template Code");
        templateDTO.setContent("Not all who wander are lost");
        templateDTO.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateDTO.setCreateUser("Create User");
        templateDTO.setId("42");
        templateDTO.setIsDelete(1);
        templateDTO.setName("Name");
        templateDTO.setRemark("Remark");
        templateDTO.setSelected(true);
        templateDTO.setType(1);
        templateDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateDTO.setUpdateUser("2020-03-01");
        templateController.page(templateDTO);
    }

    /**
     * Method under test: {@link TemplateController#page(TemplateDTO)}
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
        //       at mao.sms_manage.controller.TemplateController.page(TemplateController.java:77)
        //   In order to prevent page(TemplateDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   page(TemplateDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TemplateController templateController = new TemplateController();
        TemplateDTO templateDTO = mock(TemplateDTO.class);
        doNothing().when(templateDTO).setConfigId((String) any());
        doNothing().when(templateDTO).setConfigTemplateCode((String) any());
        doNothing().when(templateDTO).setSelected(anyBoolean());
        doNothing().when(templateDTO).setCode((String) any());
        doNothing().when(templateDTO).setContent((String) any());
        doNothing().when(templateDTO).setName((String) any());
        doNothing().when(templateDTO).setRemark((String) any());
        doNothing().when(templateDTO).setType(anyInt());
        doNothing().when(templateDTO).setCreateTime((LocalDateTime) any());
        doNothing().when(templateDTO).setCreateUser((String) any());
        doNothing().when(templateDTO).setId((String) any());
        doNothing().when(templateDTO).setIsDelete((Integer) any());
        doNothing().when(templateDTO).setUpdateTime((LocalDateTime) any());
        doNothing().when(templateDTO).setUpdateUser((String) any());
        templateDTO.setCode("Code");
        templateDTO.setConfigId("42");
        templateDTO.setConfigTemplateCode("Config Template Code");
        templateDTO.setContent("Not all who wander are lost");
        templateDTO.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateDTO.setCreateUser("Create User");
        templateDTO.setId("42");
        templateDTO.setIsDelete(1);
        templateDTO.setName("Name");
        templateDTO.setRemark("Remark");
        templateDTO.setSelected(true);
        templateDTO.setType(1);
        templateDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateDTO.setUpdateUser("2020-03-01");
        templateController.page(templateDTO);
    }

    /**
     * Method under test: {@link TemplateController#customPage(TemplateDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCustomPage()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.sms_manage.controller.TemplateController.customPage(TemplateController.java:108)
        //   In order to prevent customPage(TemplateDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   customPage(TemplateDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TemplateController templateController = new TemplateController();

        TemplateDTO templateDTO = new TemplateDTO();
        templateDTO.setCode("Code");
        templateDTO.setConfigId("42");
        templateDTO.setConfigTemplateCode("Config Template Code");
        templateDTO.setContent("Not all who wander are lost");
        templateDTO.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateDTO.setCreateUser("Create User");
        templateDTO.setId("42");
        templateDTO.setIsDelete(1);
        templateDTO.setName("Name");
        templateDTO.setRemark("Remark");
        templateDTO.setSelected(true);
        templateDTO.setType(1);
        templateDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateDTO.setUpdateUser("2020-03-01");
        templateController.customPage(templateDTO);
    }

    /**
     * Method under test: {@link TemplateController#customPage(TemplateDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCustomPage2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.sms_manage.controller.TemplateController.customPage(TemplateController.java:108)
        //   In order to prevent customPage(TemplateDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   customPage(TemplateDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TemplateController templateController = new TemplateController();
        TemplateDTO templateDTO = mock(TemplateDTO.class);
        doNothing().when(templateDTO).setConfigId((String) any());
        doNothing().when(templateDTO).setConfigTemplateCode((String) any());
        doNothing().when(templateDTO).setSelected(anyBoolean());
        doNothing().when(templateDTO).setCode((String) any());
        doNothing().when(templateDTO).setContent((String) any());
        doNothing().when(templateDTO).setName((String) any());
        doNothing().when(templateDTO).setRemark((String) any());
        doNothing().when(templateDTO).setType(anyInt());
        doNothing().when(templateDTO).setCreateTime((LocalDateTime) any());
        doNothing().when(templateDTO).setCreateUser((String) any());
        doNothing().when(templateDTO).setId((String) any());
        doNothing().when(templateDTO).setIsDelete((Integer) any());
        doNothing().when(templateDTO).setUpdateTime((LocalDateTime) any());
        doNothing().when(templateDTO).setUpdateUser((String) any());
        templateDTO.setCode("Code");
        templateDTO.setConfigId("42");
        templateDTO.setConfigTemplateCode("Config Template Code");
        templateDTO.setContent("Not all who wander are lost");
        templateDTO.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateDTO.setCreateUser("Create User");
        templateDTO.setId("42");
        templateDTO.setIsDelete(1);
        templateDTO.setName("Name");
        templateDTO.setRemark("Remark");
        templateDTO.setSelected(true);
        templateDTO.setType(1);
        templateDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateDTO.setUpdateUser("2020-03-01");
        templateController.customPage(templateDTO);
    }

    /**
     * Method under test: {@link TemplateController#list(TemplateDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testList()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.controller.TemplateController.list(TemplateController.java:135)
        //   In order to prevent list(TemplateDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   list(TemplateDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TemplateController templateController = new TemplateController();

        TemplateDTO templateDTO = new TemplateDTO();
        templateDTO.setCode("Code");
        templateDTO.setConfigId("42");
        templateDTO.setConfigTemplateCode("Config Template Code");
        templateDTO.setContent("Not all who wander are lost");
        templateDTO.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateDTO.setCreateUser("Create User");
        templateDTO.setId("42");
        templateDTO.setIsDelete(1);
        templateDTO.setName("Name");
        templateDTO.setRemark("Remark");
        templateDTO.setSelected(true);
        templateDTO.setType(1);
        templateDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateDTO.setUpdateUser("2020-03-01");
        templateController.list(templateDTO);
    }

    /**
     * Method under test: {@link TemplateController#get(String)}
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
        //       at mao.sms_manage.controller.TemplateController.get(TemplateController.java:154)
        //   In order to prevent get(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   get(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TemplateController()).get("42");
    }

    /**
     * Method under test: {@link TemplateController#paramFields(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testParamFields()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.controller.TemplateController.paramFields(TemplateController.java:169)
        //   In order to prevent paramFields(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   paramFields(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TemplateController()).paramFields("Code");
    }

    /**
     * Method under test: {@link TemplateController#build(TemplateEntity)}
     */
    @Test
    void testBuild() throws Exception
    {
        TemplateEntity templateEntity = new TemplateEntity();
        templateEntity.setCode("Code");
        templateEntity.setContent("Not all who wander are lost");
        templateEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateEntity.setCreateUser("Create User");
        templateEntity.setId("42");
        templateEntity.setIsDelete(1);
        templateEntity.setName("Name");
        templateEntity.setRemark("Remark");
        templateEntity.setType(1);
        templateEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateEntity.setUpdateUser("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(templateEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/template/build")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.templateController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link TemplateController#delete(java.util.List)}
     */
    @Test
    void testDelete() throws Exception
    {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/template")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ArrayList<>()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.templateController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }

    /**
     * Method under test: {@link TemplateController#save(TemplateEntity)}
     */
    @Test
    void testSave() throws Exception
    {
        TemplateEntity templateEntity = new TemplateEntity();
        templateEntity.setCode("Code");
        templateEntity.setContent("Not all who wander are lost");
        templateEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateEntity.setCreateUser("Create User");
        templateEntity.setId("42");
        templateEntity.setIsDelete(1);
        templateEntity.setName("Name");
        templateEntity.setRemark("Remark");
        templateEntity.setType(1);
        templateEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateEntity.setUpdateUser("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(templateEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/template")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.templateController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }

    /**
     * Method under test: {@link TemplateController#update(TemplateEntity)}
     */
    @Test
    void testUpdate() throws Exception
    {
        TemplateEntity templateEntity = new TemplateEntity();
        templateEntity.setCode("Code");
        templateEntity.setContent("Not all who wander are lost");
        templateEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateEntity.setCreateUser("Create User");
        templateEntity.setId("42");
        templateEntity.setIsDelete(1);
        templateEntity.setName("Name");
        templateEntity.setRemark("Remark");
        templateEntity.setType(1);
        templateEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateEntity.setUpdateUser("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(templateEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/template")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.templateController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}

