package mao.aggregate_pay_user_service.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.aggregate_pay_user_api.dto.menu.MenuQueryDTO;

import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationQueryParams;
import mao.aggregate_pay_user_service.service.MenuService;
import mao.aggregate_pay_user_service.service.ResourceService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ResourceControllerV2.class})
@ExtendWith(SpringExtension.class)
class ResourceControllerV2Test
{
    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @MockBean
    private MenuService menuService;

    @Autowired
    private ResourceControllerV2 resourceControllerV2;

    @MockBean
    private ResourceService resourceService;

    /**
     * Method under test: {@link ResourceControllerV2#createApplication(ApplicationDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateApplication()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.ResourceControllerV2.createApplication(ResourceControllerV2.java:62)
        //   In order to prevent createApplication(ApplicationDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createApplication(ApplicationDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceControllerV2 resourceControllerV2 = new ResourceControllerV2();

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setCode("Code");
        applicationDTO.setId(123L);
        applicationDTO.setName("Name");
        applicationDTO.setTenantId(123L);
        resourceControllerV2.createApplication(applicationDTO);
    }

    /**
     * Method under test: {@link ResourceControllerV2#createApplication(ApplicationDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateApplication2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.ResourceControllerV2.createApplication(ResourceControllerV2.java:62)
        //   In order to prevent createApplication(ApplicationDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createApplication(ApplicationDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceControllerV2 resourceControllerV2 = new ResourceControllerV2();
        ApplicationDTO applicationDTO = mock(ApplicationDTO.class);
        doNothing().when(applicationDTO).setCode((String) any());
        doNothing().when(applicationDTO).setId((Long) any());
        doNothing().when(applicationDTO).setName((String) any());
        doNothing().when(applicationDTO).setTenantId((Long) any());
        applicationDTO.setCode("Code");
        applicationDTO.setId(123L);
        applicationDTO.setName("Name");
        applicationDTO.setTenantId(123L);
        resourceControllerV2.createApplication(applicationDTO);
    }

    /**
     * Method under test: {@link ResourceControllerV2#modifyApplication(ApplicationDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testModifyApplication()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.ResourceControllerV2.modifyApplication(ResourceControllerV2.java:77)
        //   In order to prevent modifyApplication(ApplicationDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   modifyApplication(ApplicationDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceControllerV2 resourceControllerV2 = new ResourceControllerV2();

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setCode("Code");
        applicationDTO.setId(123L);
        applicationDTO.setName("Name");
        applicationDTO.setTenantId(123L);
        resourceControllerV2.modifyApplication(applicationDTO);
    }

    /**
     * Method under test: {@link ResourceControllerV2#modifyApplication(ApplicationDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testModifyApplication2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.ResourceControllerV2.modifyApplication(ResourceControllerV2.java:77)
        //   In order to prevent modifyApplication(ApplicationDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   modifyApplication(ApplicationDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceControllerV2 resourceControllerV2 = new ResourceControllerV2();
        ApplicationDTO applicationDTO = mock(ApplicationDTO.class);
        doNothing().when(applicationDTO).setCode((String) any());
        doNothing().when(applicationDTO).setId((Long) any());
        doNothing().when(applicationDTO).setName((String) any());
        doNothing().when(applicationDTO).setTenantId((Long) any());
        applicationDTO.setCode("Code");
        applicationDTO.setId(123L);
        applicationDTO.setName("Name");
        applicationDTO.setTenantId(123L);
        resourceControllerV2.modifyApplication(applicationDTO);
    }

    /**
     * Method under test: {@link ResourceControllerV2#removeApplication(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRemoveApplication()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.ResourceControllerV2.removeApplication(ResourceControllerV2.java:92)
        //   In order to prevent removeApplication(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   removeApplication(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new ResourceControllerV2()).removeApplication("Application Code");
    }

    /**
     * Method under test: {@link ResourceControllerV2#queryApplication(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryApplication()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.ResourceControllerV2.queryApplication(ResourceControllerV2.java:108)
        //   In order to prevent queryApplication(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryApplication(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new ResourceControllerV2()).queryApplication("Application Code");
    }

    /**
     * Method under test: {@link ResourceControllerV2#pageApplicationByConditions(ApplicationQueryParams, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPageApplicationByConditions()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.ResourceControllerV2.pageApplicationByConditions(ResourceControllerV2.java:130)
        //   In order to prevent pageApplicationByConditions(ApplicationQueryParams, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   pageApplicationByConditions(ApplicationQueryParams, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceControllerV2 resourceControllerV2 = new ResourceControllerV2();

        ApplicationQueryParams applicationQueryParams = new ApplicationQueryParams();
        applicationQueryParams.setName("Name");
        resourceControllerV2.pageApplicationByConditions(applicationQueryParams, 1, 3);
    }

    /**
     * Method under test: {@link ResourceControllerV2#pageApplicationByConditions(ApplicationQueryParams, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPageApplicationByConditions2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.ResourceControllerV2.pageApplicationByConditions(ResourceControllerV2.java:130)
        //   In order to prevent pageApplicationByConditions(ApplicationQueryParams, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   pageApplicationByConditions(ApplicationQueryParams, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceControllerV2 resourceControllerV2 = new ResourceControllerV2();
        ApplicationQueryParams applicationQueryParams = mock(ApplicationQueryParams.class);
        doNothing().when(applicationQueryParams).setName((String) any());
        applicationQueryParams.setName("Name");
        resourceControllerV2.pageApplicationByConditions(applicationQueryParams, 1, 3);
    }

    /**
     * Method under test: {@link ResourceControllerV2#queryMenu(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryMenu()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.ResourceControllerV2.queryMenu(ResourceControllerV2.java:180)
        //   In order to prevent queryMenu(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryMenu(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new ResourceControllerV2()).queryMenu(123L);
    }

    /**
     * Method under test: {@link ResourceControllerV2#queryMenu(MenuQueryDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryMenu2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.ResourceControllerV2.queryMenu(ResourceControllerV2.java:217)
        //   In order to prevent queryMenu(MenuQueryDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryMenu(MenuQueryDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceControllerV2 resourceControllerV2 = new ResourceControllerV2();

        MenuQueryDTO menuQueryDTO = new MenuQueryDTO();
        menuQueryDTO.setApplicationCode("Application Code");
        menuQueryDTO.setStatus(1);
        menuQueryDTO.setTitle("Dr");
        resourceControllerV2.queryMenu(menuQueryDTO, 1, 3);
    }

    /**
     * Method under test: {@link ResourceControllerV2#queryMenu(MenuQueryDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryMenu3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.ResourceControllerV2.queryMenu(ResourceControllerV2.java:217)
        //   In order to prevent queryMenu(MenuQueryDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryMenu(MenuQueryDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceControllerV2 resourceControllerV2 = new ResourceControllerV2();
        MenuQueryDTO menuQueryDTO = mock(MenuQueryDTO.class);
        doNothing().when(menuQueryDTO).setApplicationCode((String) any());
        doNothing().when(menuQueryDTO).setStatus((Integer) any());
        doNothing().when(menuQueryDTO).setTitle((String) any());
        menuQueryDTO.setApplicationCode("Application Code");
        menuQueryDTO.setStatus(1);
        menuQueryDTO.setTitle("Dr");
        resourceControllerV2.queryMenu(menuQueryDTO, 1, 3);
    }

    /**
     * Method under test: {@link ResourceControllerV2#queryMenuByPrivileges(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryMenuByPrivileges()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.ResourceControllerV2.queryMenuByPrivileges(ResourceControllerV2.java:232)
        //   In order to prevent queryMenuByPrivileges(String[])
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryMenuByPrivileges(String[]).
        //   See https://diff.blue/R013 to resolve this issue.

        (new ResourceControllerV2()).queryMenuByPrivileges(new String[]{"Privileges"});
    }

    /**
     * Method under test: {@link ResourceControllerV2#queryMenuByApplicationCode(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryMenuByApplicationCode()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.ResourceControllerV2.queryMenuByApplicationCode(ResourceControllerV2.java:195)
        //   In order to prevent queryMenuByApplicationCode(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryMenuByApplicationCode(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new ResourceControllerV2()).queryMenuByApplicationCode("Application Code");
    }

    /**
     * Method under test: {@link ResourceControllerV2#loadResources(java.util.List, String)}
     */
    @Test
    void testLoadResources() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v2/apps/privileges/resources/{applicationCode}", "Application Code");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.resourceControllerV2)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link ResourceControllerV2#loadResources(java.util.Map)}
     */
    @Test
    void testLoadResources2() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v2/tenants/apps/privileges/resources");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.resourceControllerV2)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

