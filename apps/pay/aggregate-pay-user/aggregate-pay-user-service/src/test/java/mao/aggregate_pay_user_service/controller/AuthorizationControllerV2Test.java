package mao.aggregate_pay_user_service.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.aggregate_pay_user_api.dto.auth.RoleDTO;

import mao.aggregate_pay_user_service.service.AuthorizationService;
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

@ContextConfiguration(classes = {AuthorizationControllerV2.class})
@ExtendWith(SpringExtension.class)
class AuthorizationControllerV2Test
{
    @Autowired
    private AuthorizationControllerV2 authorizationControllerV2;

    @MockBean
    private AuthorizationService authorizationService;

    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    /**
     * Method under test: {@link AuthorizationControllerV2#queryPrivilege(Long, String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPrivilege()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.queryPrivilege(AuthorizationControllerV2.java:81)
        //   In order to prevent queryPrivilege(Long, String[])
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPrivilege(Long, String[]).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AuthorizationControllerV2()).queryPrivilege(123L, new String[]{"Role Codes"});
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#queryPrivilegeByGroupId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPrivilegeByGroupId()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.queryPrivilegeByGroupId(AuthorizationControllerV2.java:95)
        //   In order to prevent queryPrivilegeByGroupId(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPrivilegeByGroupId(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AuthorizationControllerV2()).queryPrivilegeByGroupId(123L);
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#queryPrivilegeTree(Long, String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPrivilegeTree()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.queryPrivilegeTree(AuthorizationControllerV2.java:114)
        //   In order to prevent queryPrivilegeTree(Long, String[])
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPrivilegeTree(Long, String[]).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AuthorizationControllerV2()).queryPrivilegeTree(123L, new String[]{"Role Codes"});
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#createRole(Long, RoleDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateRole()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.createRole(AuthorizationControllerV2.java:136)
        //   In order to prevent createRole(Long, RoleDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createRole(Long, RoleDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        AuthorizationControllerV2 authorizationControllerV2 = new AuthorizationControllerV2();

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        authorizationControllerV2.createRole(123L, roleDTO);
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#createRole(Long, RoleDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateRole2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.createRole(AuthorizationControllerV2.java:136)
        //   In order to prevent createRole(Long, RoleDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createRole(Long, RoleDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        AuthorizationControllerV2 authorizationControllerV2 = new AuthorizationControllerV2();
        RoleDTO roleDTO = mock(RoleDTO.class);
        doNothing().when(roleDTO).setCode((String) any());
        doNothing().when(roleDTO).setId((Long) any());
        doNothing().when(roleDTO).setName((String) any());
        doNothing().when(roleDTO).setPrivilegeCodes((java.util.List<String>) any());
        doNothing().when(roleDTO).setTenantId((Long) any());
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        authorizationControllerV2.createRole(123L, roleDTO);
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#removeRole(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRemoveRole()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.removeRole(AuthorizationControllerV2.java:155)
        //   In order to prevent removeRole(Long, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   removeRole(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AuthorizationControllerV2()).removeRole(123L, "Role Code");
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#modifyRole(RoleDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testModifyRole()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.modifyRole(AuthorizationControllerV2.java:170)
        //   In order to prevent modifyRole(RoleDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   modifyRole(RoleDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        AuthorizationControllerV2 authorizationControllerV2 = new AuthorizationControllerV2();

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        authorizationControllerV2.modifyRole(roleDTO);
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#modifyRole(RoleDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testModifyRole2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.modifyRole(AuthorizationControllerV2.java:170)
        //   In order to prevent modifyRole(RoleDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   modifyRole(RoleDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        AuthorizationControllerV2 authorizationControllerV2 = new AuthorizationControllerV2();
        RoleDTO roleDTO = mock(RoleDTO.class);
        doNothing().when(roleDTO).setCode((String) any());
        doNothing().when(roleDTO).setId((Long) any());
        doNothing().when(roleDTO).setName((String) any());
        doNothing().when(roleDTO).setPrivilegeCodes((java.util.List<String>) any());
        doNothing().when(roleDTO).setTenantId((Long) any());
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        authorizationControllerV2.modifyRole(roleDTO);
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#roleBindPrivilege(Long, String, String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRoleBindPrivilege()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.roleBindPrivilege(AuthorizationControllerV2.java:191)
        //   In order to prevent roleBindPrivilege(Long, String, String[])
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   roleBindPrivilege(Long, String, String[]).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AuthorizationControllerV2()).roleBindPrivilege(123L, "Role Code", new String[]{"Privilege Codes"});
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#queryRole(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryRole()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.queryRole(AuthorizationControllerV2.java:207)
        //   In order to prevent queryRole(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryRole(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AuthorizationControllerV2()).queryRole(123L);
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#queryRole(Long, String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryRole2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.queryRole(AuthorizationControllerV2.java:227)
        //   In order to prevent queryRole(Long, String[])
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryRole(Long, String[]).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AuthorizationControllerV2()).queryRole(123L, "Role Codes");
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#queryTenantRole(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryTenantRole()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.queryTenantRole(AuthorizationControllerV2.java:247)
        //   In order to prevent queryTenantRole(Long, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryTenantRole(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AuthorizationControllerV2()).queryTenantRole(123L, "Role Code");
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#authorize(String, Long[])}
     */
    @Test
    void testAuthorize() throws Exception
    {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v2/tenants/{username}/privileges",
                "janedoe");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("tenantIds", String.valueOf(new Long[]{1L}));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.authorizationControllerV2)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#bindAccountRole(String, Long, String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBindAccountRole()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.bindAccountRole(AuthorizationControllerV2.java:260)
        //   In order to prevent bindAccountRole(String, Long, String[])
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   bindAccountRole(String, Long, String[]).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AuthorizationControllerV2()).bindAccountRole("janedoe", 123L, new String[]{"Role Codes"});
    }

    /**
     * Method under test: {@link AuthorizationControllerV2#unbindAccountRole(String, Long, String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUnbindAccountRole()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.AuthorizationControllerV2.unbindAccountRole(AuthorizationControllerV2.java:281)
        //   In order to prevent unbindAccountRole(String, Long, String[])
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   unbindAccountRole(String, Long, String[]).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AuthorizationControllerV2()).unbindAccountRole("janedoe", 123L, new String[]{"Role Codes"});
    }
}

