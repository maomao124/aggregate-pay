package mao.aggregate_pay_user_service.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.aggregate_pay_user_api.dto.auth.PrivilegeTreeDTO;

import mao.aggregate_pay_user_api.dto.auth.RoleDTO;

import mao.aggregate_pay_user_service.service.AuthorizationService;
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

@ContextConfiguration(classes = {AuthorizationController.class})
@ExtendWith(SpringExtension.class)
class AuthorizationControllerTest
{
    @Autowired
    private AuthorizationController authorizationController;

    @MockBean
    private AuthorizationService authorizationService;

    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    /**
     * Method under test: {@link AuthorizationController#authorize(String, Long[])}
     */
    @Test
    void testAuthorize() throws Exception
    {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/tenants/{username}/privileges", "janedoe");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("tenantIds", String.valueOf(new Long[]{1L}));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link AuthorizationController#authorize(String, Long[])}
     */
    @Test
    void testAuthorize2() throws Exception
    {
        when(this.authorizationService.authorize((String) any(), (Long[]) any())).thenReturn(new HashMap<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/tenants/{username}/privileges", "janedoe");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("tenantIds", String.valueOf("42"));
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    /**
     * Method under test: {@link AuthorizationController#queryPrivilege(Long, String[])}
     */
    @Test
    void testQueryPrivilege() throws Exception
    {
        when(this.authorizationService.queryPrivilege((Long) any(), (String[]) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/tenants/{tenantId}/roles/privilege-list",
                123L);
        MockHttpServletRequestBuilder requestBuilder = getResult.param("roleCodes", String.valueOf(new String[]{"foo"}));
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AuthorizationController#queryPrivilegeByGroupId(Long)}
     */
    @Test
    void testQueryPrivilegeByGroupId() throws Exception
    {
        when(this.authorizationService.queryPrivilegeByGroupId((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/privilege-groups/{privilegeGroupId}/privilege-list", 123L);
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AuthorizationController#queryPrivilegeByGroupId(Long)}
     */
    @Test
    void testQueryPrivilegeByGroupId2() throws Exception
    {
        when(this.authorizationService.queryPrivilegeByGroupId((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/privilege-groups/{privilegeGroupId}/privilege-list", 123L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AuthorizationController#queryPrivilegeTree(Long, String[])}
     */
    @Test
    void testQueryPrivilegeTree() throws Exception
    {
        PrivilegeTreeDTO privilegeTreeDTO = new PrivilegeTreeDTO();
        privilegeTreeDTO.setChildren(new ArrayList<>());
        privilegeTreeDTO.setGroup(true);
        privilegeTreeDTO.setId("42");
        privilegeTreeDTO.setName("Name");
        privilegeTreeDTO.setParentId("42");
        privilegeTreeDTO.setSort(1);
        privilegeTreeDTO.setStatus(1);
        when(this.authorizationService.queryPrivilegeTree((Long) any(), (String[]) any())).thenReturn(privilegeTreeDTO);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/tenants/{tenantId}/roles/role-privilege-list", 123L);
        MockHttpServletRequestBuilder requestBuilder = getResult.param("roleCodes", String.valueOf(new String[]{"foo"}));
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":\"42\",\"name\":\"Name\",\"parentId\":\"42\",\"sort\":1,\"status\":1,\"children\":[],\"group\":true}"));
    }

    /**
     * Method under test: {@link AuthorizationController#createRole(Long, RoleDTO)}
     */
    @Test
    void testCreateRole() throws Exception
    {
        doNothing().when(this.authorizationService).createRole((Long) any(), (RoleDTO) any());

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        String content = (new ObjectMapper()).writeValueAsString(roleDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/tenants/{tenantId}/roles", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link AuthorizationController#removeRole(Long, String)}
     */
    @Test
    void testRemoveRole() throws Exception
    {
        doNothing().when(this.authorizationService).removeRole((Long) any(), (String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/tenants/{tenantId}/roles/{roleCode}",
                123L, "Role Code");
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link AuthorizationController#removeRole(Long, String)}
     */
    @Test
    void testRemoveRole2() throws Exception
    {
        doNothing().when(this.authorizationService).removeRole((Long) any(), (String) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/tenants/{tenantId}/roles/{roleCode}",
                123L, "Role Code");
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link AuthorizationController#modifyRole(RoleDTO)}
     */
    @Test
    void testModifyRole() throws Exception
    {
        doNothing().when(this.authorizationService).modifyRole((RoleDTO) any());

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        String content = (new ObjectMapper()).writeValueAsString(roleDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/tenants/roles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link AuthorizationController#roleBindPrivilege(Long, String, String[])}
     */
    @Test
    void testRoleBindPrivilege() throws Exception
    {
        doNothing().when(this.authorizationService).roleBindPrivilege((Long) any(), (String) any(), (String[]) any());
        MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders
                .put("/tenants/{tenantId}/roles/{roleCode}/privileges", 123L, "Role Code");
        MockHttpServletRequestBuilder requestBuilder = putResult.param("privilegeCodes",
                String.valueOf(new String[]{"foo"}));
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link AuthorizationController#queryRole(Long)}
     */
    @Test
    void testQueryRole() throws Exception
    {
        when(this.authorizationService.queryRole((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/tenants/{tenantId}/roles", 123L);
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AuthorizationController#queryRole(Long)}
     */
    @Test
    void testQueryRole2() throws Exception
    {
        when(this.authorizationService.queryRole((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/tenants/{tenantId}/roles", 123L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AuthorizationController#queryRole(Long, String[])}
     */
    @Test
    void testQueryRole3() throws Exception
    {
        when(this.authorizationService.queryRole((Long) any(), (String[]) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/roles/tenants/{tenantId}", 123L);
        MockHttpServletRequestBuilder requestBuilder = getResult.param("roleCodes", String.valueOf(new String[]{"foo"}));
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AuthorizationController#queryTenantRole(Long, String)}
     */
    @Test
    void testQueryTenantRole() throws Exception
    {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        when(this.authorizationService.queryTenantRole((Long) any(), (String) any())).thenReturn(roleDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/tenants/{tenantId}/roles/{roleCode}/role-privilege", 123L, "Role Code");
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"code\":\"Code\",\"tenantId\":123,\"privilegeCodes\":[]}"));
    }

    /**
     * Method under test: {@link AuthorizationController#bindAccountRole(String, Long, String[])}
     */
    @Test
    void testBindAccountRole() throws Exception
    {
        doNothing().when(this.authorizationService).bindAccountRole((String) any(), (Long) any(), (String[]) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders
                .post("/bind/tenants/{tenantId}/accounts/{username}/roles", 123L, "janedoe");
        MockHttpServletRequestBuilder requestBuilder = postResult.param("roleCodes", String.valueOf(new String[]{"foo"}));
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link AuthorizationController#unbindAccountRole(String, Long, String[])}
     */
    @Test
    void testUnbindAccountRole() throws Exception
    {
        doNothing().when(this.authorizationService).unbindAccountRole((String) any(), (Long) any(), (String[]) any());
        MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders
                .put("/unbind/tenants/{tenantId}/accounts/{username}/roles", 123L, "janedoe");
        MockHttpServletRequestBuilder requestBuilder = putResult.param("roleCodes", String.valueOf(new String[]{"foo"}));
        MockMvcBuilders.standaloneSetup(this.authorizationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

