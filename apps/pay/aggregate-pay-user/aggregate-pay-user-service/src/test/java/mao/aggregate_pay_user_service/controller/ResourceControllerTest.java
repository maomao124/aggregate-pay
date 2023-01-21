package mao.aggregate_pay_user_service.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.menu.MenuDTO;
import mao.aggregate_pay_user_api.dto.menu.MenuQueryDTO;

import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationQueryParams;
import mao.aggregate_pay_user_service.service.MenuService;
import mao.aggregate_pay_user_service.service.ResourceService;
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

@ContextConfiguration(classes = {ResourceController.class})
@ExtendWith(SpringExtension.class)
class ResourceControllerTest
{
    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @MockBean
    private MenuService menuService;

    @Autowired
    private ResourceController resourceController;

    @MockBean
    private ResourceService resourceService;

    /**
     * Method under test: {@link ResourceController#createApplication(ApplicationDTO)}
     */
    @Test
    void testCreateApplication() throws Exception
    {
        doNothing().when(this.resourceService).createApplication((ApplicationDTO) any());

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setCode("Code");
        applicationDTO.setId(123L);
        applicationDTO.setName("Name");
        applicationDTO.setTenantId(123L);
        String content = (new ObjectMapper()).writeValueAsString(applicationDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/apps")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.resourceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link ResourceController#modifyApplication(ApplicationDTO)}
     */
    @Test
    void testModifyApplication() throws Exception
    {
        doNothing().when(this.resourceService).modifyApplication((ApplicationDTO) any());

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setCode("Code");
        applicationDTO.setId(123L);
        applicationDTO.setName("Name");
        applicationDTO.setTenantId(123L);
        String content = (new ObjectMapper()).writeValueAsString(applicationDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/apps")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.resourceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link ResourceController#removeApplication(String)}
     */
    @Test
    void testRemoveApplication() throws Exception
    {
        doNothing().when(this.resourceService).removeApplication((String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/apps/{applicationCode}",
                "Application Code");
        MockMvcBuilders.standaloneSetup(this.resourceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link ResourceController#removeApplication(String)}
     */
    @Test
    void testRemoveApplication2() throws Exception
    {
        doNothing().when(this.resourceService).removeApplication((String) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/apps/{applicationCode}",
                "Application Code");
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.resourceController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link ResourceController#queryApplication(String)}
     */
    @Test
    void testQueryApplication() throws Exception
    {
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setCode("Code");
        applicationDTO.setId(123L);
        applicationDTO.setName("Name");
        applicationDTO.setTenantId(123L);
        when(this.resourceService.queryApplication((String) any())).thenReturn(applicationDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/apps/{applicationCode}",
                "Application Code");
        MockMvcBuilders.standaloneSetup(this.resourceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"code\":\"Code\",\"tenantId\":123}"));
    }

    /**
     * Method under test: {@link ResourceController#pageApplicationByConditions(ApplicationQueryParams, Integer, Integer)}
     */
    @Test
    void testPageApplicationByConditions() throws Exception
    {
        when(this.resourceService.pageApplicationByConditions((ApplicationQueryParams) any(), (Integer) any(),
                (Integer) any())).thenReturn(new PageVO<>());

        ApplicationQueryParams applicationQueryParams = new ApplicationQueryParams();
        applicationQueryParams.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(applicationQueryParams);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/apps/page");
        MockHttpServletRequestBuilder paramResult = postResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.resourceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"items\":[],\"counts\":0,\"page\":0,\"pageSize\":0,\"pages\":1,\"first\":true,\"itemsSize\":0}"));
    }

    /**
     * Method under test: {@link ResourceController#queryMenu(Long)}
     */
    @Test
    void testQueryMenu() throws Exception
    {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setApplication("Application");
        menuDTO.setApplicationCode("Application Code");
        menuDTO.setCode("Code");
        menuDTO.setComment("Comment");
        menuDTO.setIcon("Icon");
        menuDTO.setId(123L);
        menuDTO.setParentId(123L);
        menuDTO.setPrivilegeCode("Privilege Code");
        menuDTO.setSort(1);
        menuDTO.setStatus(1);
        menuDTO.setTitle("Dr");
        menuDTO.setUrl("https://example.org/example");
        when(this.menuService.queryMenu((Long) any())).thenReturn(menuDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/menus/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.resourceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"parentId\":123,\"title\":\"Dr\",\"url\":\"https://example.org/example\",\"code\":\"Code\",\"icon\":\"Icon"
                                        + "\",\"sort\":1,\"comment\":\"Comment\",\"applicationCode\":\"Application Code\",\"application\":\"Application\","
                                        + "\"privilegeCode\":\"Privilege Code\",\"status\":1}"));
    }

    /**
     * Method under test: {@link ResourceController#queryMenu(MenuQueryDTO, Integer, Integer)}
     */
    @Test
    void testQueryMenu2() throws Exception
    {
        when(this.menuService.queryMenu((MenuQueryDTO) any(), (Integer) any(), (Integer) any())).thenReturn(new PageVO<>());

        MenuQueryDTO menuQueryDTO = new MenuQueryDTO();
        menuQueryDTO.setApplicationCode("Application Code");
        menuQueryDTO.setStatus(1);
        menuQueryDTO.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(menuQueryDTO);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/menus/page");
        MockHttpServletRequestBuilder paramResult = postResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.resourceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"items\":[],\"counts\":0,\"page\":0,\"pageSize\":0,\"pages\":1,\"first\":true,\"itemsSize\":0}"));
    }

    /**
     * Method under test: {@link ResourceController#queryMenuByPrivileges(String[])}
     */
    @Test
    void testQueryMenuByPrivileges() throws Exception
    {
        when(this.menuService.queryMenuByPrivileges((String[]) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/menus/privileges");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("privileges", String.valueOf(new String[]{"foo"}));
        MockMvcBuilders.standaloneSetup(this.resourceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ResourceController#queryMenuByApplicationCode(String)}
     */
    @Test
    void testQueryMenuByApplicationCode() throws Exception
    {
        when(this.menuService.queryMenuByApplicationCode((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/menus/{applicationCode}/menu-list",
                "Application Code");
        MockMvcBuilders.standaloneSetup(this.resourceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ResourceController#queryMenuByApplicationCode(String)}
     */
    @Test
    void testQueryMenuByApplicationCode2() throws Exception
    {
        when(this.menuService.queryMenuByApplicationCode((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/menus/{applicationCode}/menu-list",
                "Application Code");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.resourceController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ResourceController#loadResources(java.util.List, String)}
     */
    @Test
    void testLoadResources() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/apps/privileges/resources/{applicationCode}", "Application Code");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.resourceController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link ResourceController#loadResources(java.util.Map)}
     */
    @Test
    void testLoadResources2() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/tenants/apps/privileges/resources");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.resourceController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

