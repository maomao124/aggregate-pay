package mao.sms_manage.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.sms_entity.dto.SignatureDTO;
import mao.sms_entity.entity.SignatureEntity;
import mao.sms_manage.service.ReceiveLogService;
import mao.sms_manage.service.SignatureService;
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

@ContextConfiguration(classes = {SignatureController.class})
@ExtendWith(SpringExtension.class)
class SignatureControllerTest
{
    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @MockBean
    private ReceiveLogService receiveLogService;

    @Autowired
    private SignatureController signatureController;

    @MockBean
    private SignatureService signatureService;

    /**
     * Method under test: {@link SignatureController#page(SignatureDTO)}
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
        //       at mao.sms_manage.controller.SignatureController.page(SignatureController.java:77)
        //   In order to prevent page(SignatureDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   page(SignatureDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        SignatureController signatureController = new SignatureController();

        SignatureDTO signatureDTO = new SignatureDTO();
        signatureDTO.setCode("Code");
        signatureDTO.setConfigId("42");
        signatureDTO.setConfigSignatureCode("Config Signature Code");
        signatureDTO.setContent("Not all who wander are lost");
        signatureDTO.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureDTO.setCreateUser("Create User");
        signatureDTO.setId("42");
        signatureDTO.setIsDelete(1);
        signatureDTO.setName("Name");
        signatureDTO.setRemark("Remark");
        signatureDTO.setSelected(true);
        signatureDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureDTO.setUpdateUser("2020-03-01");
        signatureController.page(signatureDTO);
    }

    /**
     * Method under test: {@link SignatureController#page(SignatureDTO)}
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
        //       at mao.sms_manage.controller.SignatureController.page(SignatureController.java:77)
        //   In order to prevent page(SignatureDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   page(SignatureDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        SignatureController signatureController = new SignatureController();
        SignatureDTO signatureDTO = mock(SignatureDTO.class);
        doNothing().when(signatureDTO).setConfigId((String) any());
        doNothing().when(signatureDTO).setConfigSignatureCode((String) any());
        doNothing().when(signatureDTO).setSelected(anyBoolean());
        doNothing().when(signatureDTO).setCode((String) any());
        doNothing().when(signatureDTO).setContent((String) any());
        doNothing().when(signatureDTO).setName((String) any());
        doNothing().when(signatureDTO).setRemark((String) any());
        doNothing().when(signatureDTO).setCreateTime((LocalDateTime) any());
        doNothing().when(signatureDTO).setCreateUser((String) any());
        doNothing().when(signatureDTO).setId((String) any());
        doNothing().when(signatureDTO).setIsDelete((Integer) any());
        doNothing().when(signatureDTO).setUpdateTime((LocalDateTime) any());
        doNothing().when(signatureDTO).setUpdateUser((String) any());
        signatureDTO.setCode("Code");
        signatureDTO.setConfigId("42");
        signatureDTO.setConfigSignatureCode("Config Signature Code");
        signatureDTO.setContent("Not all who wander are lost");
        signatureDTO.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureDTO.setCreateUser("Create User");
        signatureDTO.setId("42");
        signatureDTO.setIsDelete(1);
        signatureDTO.setName("Name");
        signatureDTO.setRemark("Remark");
        signatureDTO.setSelected(true);
        signatureDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureDTO.setUpdateUser("2020-03-01");
        signatureController.page(signatureDTO);
    }

    /**
     * Method under test: {@link SignatureController#customPage(SignatureDTO)}
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
        //       at mao.sms_manage.controller.SignatureController.customPage(SignatureController.java:109)
        //   In order to prevent customPage(SignatureDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   customPage(SignatureDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        SignatureController signatureController = new SignatureController();

        SignatureDTO signatureDTO = new SignatureDTO();
        signatureDTO.setCode("Code");
        signatureDTO.setConfigId("42");
        signatureDTO.setConfigSignatureCode("Config Signature Code");
        signatureDTO.setContent("Not all who wander are lost");
        signatureDTO.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureDTO.setCreateUser("Create User");
        signatureDTO.setId("42");
        signatureDTO.setIsDelete(1);
        signatureDTO.setName("Name");
        signatureDTO.setRemark("Remark");
        signatureDTO.setSelected(true);
        signatureDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureDTO.setUpdateUser("2020-03-01");
        signatureController.customPage(signatureDTO);
    }

    /**
     * Method under test: {@link SignatureController#customPage(SignatureDTO)}
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
        //       at mao.sms_manage.controller.SignatureController.customPage(SignatureController.java:109)
        //   In order to prevent customPage(SignatureDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   customPage(SignatureDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        SignatureController signatureController = new SignatureController();
        SignatureDTO signatureDTO = mock(SignatureDTO.class);
        doNothing().when(signatureDTO).setConfigId((String) any());
        doNothing().when(signatureDTO).setConfigSignatureCode((String) any());
        doNothing().when(signatureDTO).setSelected(anyBoolean());
        doNothing().when(signatureDTO).setCode((String) any());
        doNothing().when(signatureDTO).setContent((String) any());
        doNothing().when(signatureDTO).setName((String) any());
        doNothing().when(signatureDTO).setRemark((String) any());
        doNothing().when(signatureDTO).setCreateTime((LocalDateTime) any());
        doNothing().when(signatureDTO).setCreateUser((String) any());
        doNothing().when(signatureDTO).setId((String) any());
        doNothing().when(signatureDTO).setIsDelete((Integer) any());
        doNothing().when(signatureDTO).setUpdateTime((LocalDateTime) any());
        doNothing().when(signatureDTO).setUpdateUser((String) any());
        signatureDTO.setCode("Code");
        signatureDTO.setConfigId("42");
        signatureDTO.setConfigSignatureCode("Config Signature Code");
        signatureDTO.setContent("Not all who wander are lost");
        signatureDTO.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureDTO.setCreateUser("Create User");
        signatureDTO.setId("42");
        signatureDTO.setIsDelete(1);
        signatureDTO.setName("Name");
        signatureDTO.setRemark("Remark");
        signatureDTO.setSelected(true);
        signatureDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureDTO.setUpdateUser("2020-03-01");
        signatureController.customPage(signatureDTO);
    }

    /**
     * Method under test: {@link SignatureController#list(SignatureDTO)}
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
        //       at mao.sms_manage.controller.SignatureController.list(SignatureController.java:140)
        //   In order to prevent list(SignatureDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   list(SignatureDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        SignatureController signatureController = new SignatureController();

        SignatureDTO signatureDTO = new SignatureDTO();
        signatureDTO.setCode("Code");
        signatureDTO.setConfigId("42");
        signatureDTO.setConfigSignatureCode("Config Signature Code");
        signatureDTO.setContent("Not all who wander are lost");
        signatureDTO.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureDTO.setCreateUser("Create User");
        signatureDTO.setId("42");
        signatureDTO.setIsDelete(1);
        signatureDTO.setName("Name");
        signatureDTO.setRemark("Remark");
        signatureDTO.setSelected(true);
        signatureDTO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureDTO.setUpdateUser("2020-03-01");
        signatureController.list(signatureDTO);
    }

    /**
     * Method under test: {@link SignatureController#get(String)}
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
        //       at mao.sms_manage.controller.SignatureController.get(SignatureController.java:154)
        //   In order to prevent get(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   get(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new SignatureController()).get("42");
    }

    /**
     * Method under test: {@link SignatureController#delete(java.util.List)}
     */
    @Test
    void testDelete() throws Exception
    {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/signature")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ArrayList<>()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.signatureController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }

    /**
     * Method under test: {@link SignatureController#save(SignatureEntity)}
     */
    @Test
    void testSave() throws Exception
    {
        SignatureEntity signatureEntity = new SignatureEntity();
        signatureEntity.setCode("Code");
        signatureEntity.setContent("Not all who wander are lost");
        signatureEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureEntity.setCreateUser("Create User");
        signatureEntity.setId("42");
        signatureEntity.setIsDelete(1);
        signatureEntity.setName("Name");
        signatureEntity.setRemark("Remark");
        signatureEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureEntity.setUpdateUser("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(signatureEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/signature")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.signatureController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }

    /**
     * Method under test: {@link SignatureController#update(SignatureEntity)}
     */
    @Test
    void testUpdate() throws Exception
    {
        SignatureEntity signatureEntity = new SignatureEntity();
        signatureEntity.setCode("Code");
        signatureEntity.setContent("Not all who wander are lost");
        signatureEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureEntity.setCreateUser("Create User");
        signatureEntity.setId("42");
        signatureEntity.setIsDelete(1);
        signatureEntity.setName("Name");
        signatureEntity.setRemark("Remark");
        signatureEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureEntity.setUpdateUser("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(signatureEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/signature")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.signatureController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}

