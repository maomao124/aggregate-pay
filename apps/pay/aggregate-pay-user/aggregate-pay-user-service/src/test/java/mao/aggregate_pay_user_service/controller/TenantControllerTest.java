package mao.aggregate_pay_user_service.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.aggregate_pay_common.domain.PageVO;

import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;

import mao.aggregate_pay_user_api.dto.tenant.AccountDTO;
import mao.aggregate_pay_user_api.dto.tenant.AccountQueryDTO;
import mao.aggregate_pay_user_api.dto.tenant.AuthenticationInfo;
import mao.aggregate_pay_user_api.dto.tenant.BundleDTO;
import mao.aggregate_pay_user_api.dto.tenant.ChangeAccountPwdDTO;
import mao.aggregate_pay_user_api.dto.tenant.CreateAccountRequestDTO;
import mao.aggregate_pay_user_api.dto.tenant.CreateTenantRequestDTO;
import mao.aggregate_pay_user_api.dto.tenant.LoginInfoDTO;
import mao.aggregate_pay_user_api.dto.tenant.LoginRequestDTO;
import mao.aggregate_pay_user_api.dto.tenant.TenantDTO;
import mao.aggregate_pay_user_api.dto.tenant.TenantQueryDTO;
import mao.aggregate_pay_user_service.service.TenantService;
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
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {TenantController.class})
@ExtendWith(SpringExtension.class)
class TenantControllerTest
{
    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @Autowired
    private TenantController tenantController;

    @MockBean
    private TenantService tenantService;

    /**
     * Method under test: {@link TenantController#createTenantRelateAccount(CreateTenantRequestDTO)}
     */
    @Test
    void testCreateTenantRelateAccount() throws Exception
    {
        TenantDTO tenantDTO = new TenantDTO();
        tenantDTO.setBundleCode("Bundle Code");
        tenantDTO.setId(123L);
        tenantDTO.setName("Name");
        tenantDTO.setTenantTypeCode("Tenant Type Code");
        when(this.tenantService.createTenantRelateAccount((CreateTenantRequestDTO) any())).thenReturn(tenantDTO);

        CreateTenantRequestDTO createTenantRequestDTO = new CreateTenantRequestDTO();
        createTenantRequestDTO.setBundleCode("Bundle Code");
        createTenantRequestDTO.setMobile("Mobile");
        createTenantRequestDTO.setName("Name");
        createTenantRequestDTO.setPassword("iloveyou");
        createTenantRequestDTO.setTenantTypeCode("Tenant Type Code");
        createTenantRequestDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(createTenantRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/tenantRelateAccount")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"tenantTypeCode\":\"Tenant Type Code\",\"bundleCode\":\"Bundle Code\"}"));
    }

    /**
     * Method under test: {@link TenantController#getTenant(Long)}
     */
    @Test
    void testGetTenant() throws Exception
    {
        TenantDTO tenantDTO = new TenantDTO();
        tenantDTO.setBundleCode("Bundle Code");
        tenantDTO.setId(123L);
        tenantDTO.setName("Name");
        tenantDTO.setTenantTypeCode("Tenant Type Code");
        when(this.tenantService.getTenant((Long) any())).thenReturn(tenantDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/tenants/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"tenantTypeCode\":\"Tenant Type Code\",\"bundleCode\":\"Bundle Code\"}"));
    }

    /**
     * Method under test: {@link TenantController#queryTenants(TenantQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    void testQueryTenants() throws Exception
    {
        when(this.tenantService.queryTenants((TenantQueryDTO) any(), (Integer) any(), (Integer) any(), (String) any(),
                (String) any())).thenReturn(new PageVO<>());

        TenantQueryDTO tenantQueryDTO = new TenantQueryDTO();
        tenantQueryDTO.setName("Name");
        tenantQueryDTO.setTenantTypeCode("Tenant Type Code");
        String content = (new ObjectMapper()).writeValueAsString(tenantQueryDTO);
        MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.post("/tenants/page").param("order", "foo");
        MockHttpServletRequestBuilder paramResult1 = paramResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult1.param("pageSize", String.valueOf(1))
                .param("sortBy", "foo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"items\":[],\"counts\":0,\"page\":0,\"pageSize\":0,\"itemsSize\":0,\"first\":true,\"pages\":1}"));
    }

    /**
     * Method under test: {@link TenantController#queryBundleByTenantType(String)}
     */
    @Test
    void testQueryBundleByTenantType() throws Exception
    {
        when(this.tenantService.queryBundleByTenantType((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/bundles/tenant-types/{tenantType}/bundle-list", "Tenant Type");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TenantController#queryBundleByTenantType(String)}
     */
    @Test
    void testQueryBundleByTenantType2() throws Exception
    {
        when(this.tenantService.queryBundleByTenantType((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/bundles/tenant-types/{tenantType}/bundle-list", "Tenant Type");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TenantController#getBundle(String)}
     */
    @Test
    void testGetBundle() throws Exception
    {
        BundleDTO bundleDTO = new BundleDTO();
        bundleDTO.setAbility("Ability");
        bundleDTO.setCode("Code");
        bundleDTO.setComment("Comment");
        bundleDTO.setId(123L);
        bundleDTO.setInitialize(true);
        bundleDTO.setName("Name");
        bundleDTO.setNumberOfApp(10);
        bundleDTO.setNumberOfConcurrent(10);
        bundleDTO.setNumberOfInvocation(10);
        bundleDTO.setTenantTypeCode("Tenant Type Code");
        when(this.tenantService.getBundle((String) any())).thenReturn(bundleDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bundles/{bundleCode}", "Bundle Code");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"code\":\"Code\",\"tenantTypeCode\":\"Tenant Type Code\",\"ability\":\"Ability\","
                                        + "\"numberOfInvocation\":10,\"numberOfConcurrent\":10,\"numberOfApp\":10,\"comment\":\"Comment\",\"initialize\":true"
                                        + "}"));
    }

    /**
     * Method under test: {@link TenantController#queryAllBundle()}
     */
    @Test
    void testQueryAllBundle() throws Exception
    {
        when(this.tenantService.queryAllBundle()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bundles/bundle-list");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TenantController#queryAllBundle()}
     */
    @Test
    void testQueryAllBundle2() throws Exception
    {
        when(this.tenantService.queryAllBundle()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/bundles/bundle-list");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TenantController#changeBundle(Long, String)}
     */
    @Test
    void testChangeBundle() throws Exception
    {
        doNothing().when(this.tenantService).changeBundle((Long) any(), (String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/tenants/{tenantId}/bundles/{bundleCode}", 123L, "Bundle Code");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TenantController#changeBundle(Long, String)}
     */
    @Test
    void testChangeBundle2() throws Exception
    {
        doNothing().when(this.tenantService).changeBundle((Long) any(), (String) any());
        MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/tenants/{tenantId}/bundles/{bundleCode}",
                123L, "Bundle Code");
        putResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(putResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TenantController#initBundle(Long, String)}
     */
    @Test
    void testInitBundle() throws Exception
    {
        doNothing().when(this.tenantService).initBundle((Long) any(), (String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/tenants/{tenantId}/bundles/{bundleCode}", 123L, "Bundle Code");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TenantController#initBundle(Long, String)}
     */
    @Test
    void testInitBundle2() throws Exception
    {
        doNothing().when(this.tenantService).initBundle((Long) any(), (String) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/tenants/{tenantId}/bundles/{bundleCode}",
                123L, "Bundle Code");
        postResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TenantController#createBundle(BundleDTO)}
     */
    @Test
    void testCreateBundle() throws Exception
    {
        doNothing().when(this.tenantService).createBundle((BundleDTO) any());

        BundleDTO bundleDTO = new BundleDTO();
        bundleDTO.setAbility("Ability");
        bundleDTO.setCode("Code");
        bundleDTO.setComment("Comment");
        bundleDTO.setId(123L);
        bundleDTO.setInitialize(true);
        bundleDTO.setName("Name");
        bundleDTO.setNumberOfApp(10);
        bundleDTO.setNumberOfConcurrent(10);
        bundleDTO.setNumberOfInvocation(10);
        bundleDTO.setTenantTypeCode("Tenant Type Code");
        String content = (new ObjectMapper()).writeValueAsString(bundleDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/bundles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TenantController#modifyBundle(BundleDTO)}
     */
    @Test
    void testModifyBundle() throws Exception
    {
        doNothing().when(this.tenantService).modifyBundle((BundleDTO) any());

        BundleDTO bundleDTO = new BundleDTO();
        bundleDTO.setAbility("Ability");
        bundleDTO.setCode("Code");
        bundleDTO.setComment("Comment");
        bundleDTO.setId(123L);
        bundleDTO.setInitialize(true);
        bundleDTO.setName("Name");
        bundleDTO.setNumberOfApp(10);
        bundleDTO.setNumberOfConcurrent(10);
        bundleDTO.setNumberOfInvocation(10);
        bundleDTO.setTenantTypeCode("Tenant Type Code");
        String content = (new ObjectMapper()).writeValueAsString(bundleDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/bundles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TenantController#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    void testCreateAccount2() throws Exception
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.tenantService.createAccount((CreateAccountRequestDTO) any())).thenReturn(accountDTO);

        CreateAccountRequestDTO createAccountRequestDTO = new CreateAccountRequestDTO();
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(createAccountRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"username\":\"janedoe\",\"mobile\":\"Mobile\",\"password\":\"iloveyou\",\"salt\":\"Salt\"}"));
    }

    /**
     * Method under test: {@link TenantController#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    void testCreateAccountInTenant() throws Exception
    {
        doNothing().when(this.tenantService).createAccountInTenant((CreateAccountRequestDTO) any(), (Long) any());

        CreateAccountRequestDTO createAccountRequestDTO = new CreateAccountRequestDTO();
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(createAccountRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accounts/tenants/{tenantId}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TenantController#bindTenant(Long, String)}
     */
    @Test
    void testBindTenant() throws Exception
    {
        doNothing().when(this.tenantService).bindTenant((Long) any(), (String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/bind/accounts/{username}/tenants/{tenantId}", "janedoe", 123L);
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TenantController#bindTenant(Long, String)}
     */
    @Test
    void testBindTenant2() throws Exception
    {
        doNothing().when(this.tenantService).bindTenant((Long) any(), (String) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders
                .post("/bind/accounts/{username}/tenants/{tenantId}", "janedoe", 123L);
        postResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TenantController#unbindTenant(Long, String)}
     */
    @Test
    void testUnbindTenant() throws Exception
    {
        doNothing().when(this.tenantService).unbindTenant((Long) any(), (String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/unbind/accounts/{username}/tenants/{tenantId}", "janedoe", 123L);
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TenantController#unbindTenant(Long, String)}
     */
    @Test
    void testUnbindTenant2() throws Exception
    {
        doNothing().when(this.tenantService).unbindTenant((Long) any(), (String) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders
                .delete("/unbind/accounts/{username}/tenants/{tenantId}", "janedoe", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TenantController#isExistAccountByUsername(String)}
     */
    @Test
    void testIsExistAccountByUsername() throws Exception
    {
        when(this.tenantService.isExistAccountByUsername((String) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/exist/accounts/name/{username}",
                "janedoe");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link TenantController#isExistAccountByUsername(String)}
     */
    @Test
    void testIsExistAccountByUsername2() throws Exception
    {
        when(this.tenantService.isExistAccountByUsername((String) any())).thenReturn(true);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/exist/accounts/name/{username}", "janedoe");
        getResult.characterEncoding("Encoding");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link TenantController#isExistAccountByMobile(String)}
     */
    @Test
    void testIsExistAccountByMobile() throws Exception
    {
        when(this.tenantService.isExistAccountByMobile((String) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/exist/accounts/mobile/{mobile}",
                "Mobile");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link TenantController#isExistAccountByMobile(String)}
     */
    @Test
    void testIsExistAccountByMobile2() throws Exception
    {
        when(this.tenantService.isExistAccountByMobile((String) any())).thenReturn(true);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/exist/accounts/mobile/{mobile}", "Mobile");
        getResult.characterEncoding("Encoding");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link TenantController#getAccountByUsername(String)}
     */
    @Test
    void testGetAccountByUsername() throws Exception
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.tenantService.getAccountByUsername((String) any())).thenReturn(accountDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/account-information/name/{username}",
                "janedoe");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"username\":\"janedoe\",\"mobile\":\"Mobile\",\"password\":\"iloveyou\",\"salt\":\"Salt\"}"));
    }

    /**
     * Method under test: {@link TenantController#getAccountByMobile(String)}
     */
    @Test
    void testGetAccountByMobile() throws Exception
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.tenantService.getAccountByMobile((String) any())).thenReturn(accountDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accounts-information/mobile/{mobile}",
                "Mobile");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"username\":\"janedoe\",\"mobile\":\"Mobile\",\"password\":\"iloveyou\",\"salt\":\"Salt\"}"));
    }

    /**
     * Method under test: {@link TenantController#isExistAccountInTenantByUsername(Long, String)}
     */
    @Test
    void testIsExistAccountInTenantByUsername() throws Exception
    {
        when(this.tenantService.isExistAccountInTenantByUsername((Long) any(), (String) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/exist/accounts/{username}/tenants/{tenantId}", "janedoe", 123L);
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link TenantController#isExistAccountInTenantByUsername(Long, String)}
     */
    @Test
    void testIsExistAccountInTenantByUsername2() throws Exception
    {
        when(this.tenantService.isExistAccountInTenantByUsername((Long) any(), (String) any())).thenReturn(true);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/exist/accounts/{username}/tenants/{tenantId}", "janedoe", 123L);
        getResult.characterEncoding("Encoding");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link TenantController#isExistAccountInTenantByMobile(Long, String)}
     */
    @Test
    void testIsExistAccountInTenantByMobile() throws Exception
    {
        when(this.tenantService.isExistAccountInTenantByMobile((Long) any(), (String) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/exist/accounts/tenants/{tenantId}/mobiles/{mobile}", 123L, "Mobile");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link TenantController#isExistAccountInTenantByMobile(Long, String)}
     */
    @Test
    void testIsExistAccountInTenantByMobile2() throws Exception
    {
        when(this.tenantService.isExistAccountInTenantByMobile((Long) any(), (String) any())).thenReturn(true);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/exist/accounts/tenants/{tenantId}/mobiles/{mobile}", 123L, "Mobile");
        getResult.characterEncoding("Encoding");
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link TenantController#queryAccount(AccountQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    void testQueryAccount() throws Exception
    {
        when(this.tenantService.queryAccount((AccountQueryDTO) any(), (Integer) any(), (Integer) any(), (String) any(),
                (String) any())).thenReturn(new PageVO<>());

        AccountQueryDTO accountQueryDTO = new AccountQueryDTO();
        accountQueryDTO.setMobile("Mobile");
        accountQueryDTO.setTenantId(123L);
        accountQueryDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(accountQueryDTO);
        MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.post("/accounts/page").param("order", "foo");
        MockHttpServletRequestBuilder paramResult1 = paramResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult1.param("pageSize", String.valueOf(1))
                .param("sortBy", "foo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"items\":[],\"counts\":0,\"page\":0,\"pageSize\":0,\"itemsSize\":0,\"first\":true,\"pages\":1}"));
    }

    /**
     * Method under test: {@link TenantController#queryAccountInTenant(String)}
     */
    @Test
    void testQueryAccountInTenant() throws Exception
    {
        when(this.tenantService.queryAccountInTenant((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accounts/tenant-list/{username}",
                "janedoe");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TenantController#queryAccountInTenant(String)}
     */
    @Test
    void testQueryAccountInTenant2() throws Exception
    {
        when(this.tenantService.queryAccountInTenant((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/accounts/tenant-list/{username}", "janedoe");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TenantController#sendMessage(String)}
     */
    @Test
    void testSendMessage() throws Exception
    {
        when(this.tenantService.sendMessage((String) any())).thenReturn("Send Message");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getMessage").param("phone", "foo");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Send Message"));
    }

    /**
     * Method under test: {@link TenantController#authentication(AuthenticationInfo)}
     */
    @Test
    void testAuthentication() throws Exception
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.tenantService.authentication((AuthenticationInfo) any())).thenReturn(accountDTO);

        AuthenticationInfo authenticationInfo = new AuthenticationInfo();
        authenticationInfo.setAuthenticationType("Authentication Type");
        authenticationInfo.setCertificate("Certificate");
        authenticationInfo.setPrincipal("Principal");
        authenticationInfo.setSmsKey("Sms Key");
        String content = (new ObjectMapper()).writeValueAsString(authenticationInfo);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/authentication")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"username\":\"janedoe\",\"mobile\":\"Mobile\",\"password\":\"iloveyou\",\"salt\":\"Salt\"}"));
    }

    /**
     * Method under test: {@link TenantController#login(LoginRequestDTO)}
     */
    @Test
    void testLogin() throws Exception
    {
        LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
        loginInfoDTO.setId(123L);
        loginInfoDTO.setMobile("Mobile");
        loginInfoDTO.setResources(new HashMap<>());
        loginInfoDTO.setTenantAuthorizationInfoMap(new HashMap<>());
        loginInfoDTO.setTenants(new ArrayList<>());
        loginInfoDTO.setUsername("janedoe");
        when(this.tenantService.login((LoginRequestDTO) any())).thenReturn(loginInfoDTO);

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setAuthenticationType("Authentication Type");
        loginRequestDTO.setCertificate("Certificate");
        loginRequestDTO.setPrincipal("Principal");
        loginRequestDTO.setSmsKey("Sms Key");
        String content = (new ObjectMapper()).writeValueAsString(loginRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"username\":\"janedoe\",\"mobile\":\"Mobile\",\"tenants\":[],\"tenantAuthorizationInfoMap\":{},\"resources"
                                        + "\":{}}"));
    }

    /**
     * Method under test: {@link TenantController#getApplicationDTOByClientId(String)}
     */
    @Test
    void testGetApplicationDTOByClientId() throws Exception
    {
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setCode("Code");
        applicationDTO.setId(123L);
        applicationDTO.setName("Name");
        applicationDTO.setTenantId(123L);
        when(this.tenantService.getApplicationDTOByClientId((String) any())).thenReturn(applicationDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/apps/{clientId}", "42");
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"code\":\"Code\",\"tenantId\":123}"));
    }

    /**
     * Method under test: {@link TenantController#createAccount(ChangeAccountPwdDTO)}
     */
    @Test
    void testCreateAccount() throws Exception
    {
        when(this.tenantService.accountPassword((ChangeAccountPwdDTO) any())).thenReturn(true);

        ChangeAccountPwdDTO changeAccountPwdDTO = new ChangeAccountPwdDTO();
        changeAccountPwdDTO.setAccountId(1234567890L);
        changeAccountPwdDTO.setPassword("iloveyou");
        changeAccountPwdDTO.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(changeAccountPwdDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accounts/password")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link TenantController#createTenantAndInit(CreateTenantRequestDTO)}
     */
    @Test
    void testCreateTenantAndInit() throws Exception
    {
        TenantDTO tenantDTO = new TenantDTO();
        tenantDTO.setBundleCode("Bundle Code");
        tenantDTO.setId(123L);
        tenantDTO.setName("Name");
        tenantDTO.setTenantTypeCode("Tenant Type Code");
        when(this.tenantService.createTenantAndAccount((CreateTenantRequestDTO) any())).thenReturn(tenantDTO);

        CreateTenantRequestDTO createTenantRequestDTO = new CreateTenantRequestDTO();
        createTenantRequestDTO.setBundleCode("Bundle Code");
        createTenantRequestDTO.setMobile("Mobile");
        createTenantRequestDTO.setName("Name");
        createTenantRequestDTO.setPassword("iloveyou");
        createTenantRequestDTO.setTenantTypeCode("Tenant Type Code");
        createTenantRequestDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(createTenantRequestDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/tenants")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.tenantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"name\":\"Name\",\"tenantTypeCode\":\"Tenant Type Code\",\"bundleCode\":\"Bundle Code\"}"));
    }
}

