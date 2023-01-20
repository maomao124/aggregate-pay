package mao.aggregate_pay_user_service.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.classmap.ClassMappings;
import com.github.dozermapper.core.config.BeanContainer;
import com.github.dozermapper.core.metadata.DozerMappingMetadata;

import java.util.ArrayList;
import java.util.List;

import mao.aggregate_pay_common.domain.BusinessException;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_common.domain.RestResponse;
import mao.aggregate_pay_entity.dto.VerificationInfo;
import mao.aggregate_pay_user_api.dto.auth.RoleDTO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.dto.tenant.AccountDTO;
import mao.aggregate_pay_user_api.dto.tenant.AccountQueryDTO;
import mao.aggregate_pay_user_api.dto.tenant.AccountRoleDTO;
import mao.aggregate_pay_user_api.dto.tenant.AccountRoleQueryDTO;
import mao.aggregate_pay_user_api.dto.tenant.AuthenticationInfo;
import mao.aggregate_pay_user_api.dto.tenant.BundleDTO;
import mao.aggregate_pay_user_api.dto.tenant.ChangeAccountPwdDTO;
import mao.aggregate_pay_user_api.dto.tenant.CreateAccountRequestDTO;
import mao.aggregate_pay_user_api.dto.tenant.CreateTenantRequestDTO;
import mao.aggregate_pay_user_api.dto.tenant.LoginRequestDTO;
import mao.aggregate_pay_user_api.dto.tenant.TenantDTO;
import mao.aggregate_pay_user_api.dto.tenant.TenantQueryDTO;
import mao.aggregate_pay_user_service.entity.Account;
import mao.aggregate_pay_user_service.entity.Bundle;
import mao.aggregate_pay_user_service.entity.ResourceApplication;
import mao.aggregate_pay_user_service.entity.Tenant;
import mao.aggregate_pay_user_service.entity.TenantAccount;
import mao.aggregate_pay_user_service.feign.sms.VerificationFeignClient;
import mao.aggregate_pay_user_service.mapper.AccountMapper;
import mao.aggregate_pay_user_service.mapper.AccountRoleMapper;
import mao.aggregate_pay_user_service.mapper.AuthorizationRoleMapper;
import mao.aggregate_pay_user_service.mapper.AuthorizationRolePrivilegeMapper;
import mao.aggregate_pay_user_service.mapper.BundleMapper;
import mao.aggregate_pay_user_service.mapper.ResourceApplicationMapper;
import mao.aggregate_pay_user_service.mapper.TenantAccountMapper;
import mao.aggregate_pay_user_service.mapper.TenantMapper;
import mao.aggregate_pay_user_service.service.AuthorizationService;
import mao.aggregate_pay_user_service.service.ResourceService;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TenantServiceImpl.class})
@ExtendWith(SpringExtension.class)
class TenantServiceImplTest
{
    @MockBean
    private AccountMapper accountMapper;

    @MockBean
    private AccountRoleMapper accountRoleMapper;

    @MockBean
    private AuthorizationRoleMapper authorizationRoleMapper;

    @MockBean
    private AuthorizationRolePrivilegeMapper authorizationRolePrivilegeMapper;

    @MockBean
    private AuthorizationService authorizationService;

    @MockBean
    private BundleMapper bundleMapper;

    @MockBean
    private DozerUtils dozerUtils;

    @MockBean
    private ResourceApplicationMapper resourceApplicationMapper;

    @MockBean
    private ResourceService resourceService;

    @MockBean
    private TenantAccountMapper tenantAccountMapper;

    @MockBean
    private TenantMapper tenantMapper;

    @Autowired
    private TenantServiceImpl tenantServiceImpl;

    @MockBean
    private VerificationFeignClient verificationFeignClient;

    /**
     * Method under test: {@link TenantServiceImpl#createTenantAndAccount(CreateTenantRequestDTO)}
     */
    @Test
    void testCreateTenantAndAccount()
    {
        Tenant tenant = new Tenant();
        tenant.setBundleCode("Bundle Code");
        tenant.setId(123L);
        tenant.setName("Name");
        tenant.setTenantTypeCode("Tenant Type Code");
        when(this.tenantMapper.selectById((java.io.Serializable) any())).thenReturn(tenant);
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        when(this.tenantMapper.insert((Tenant) any())).thenReturn(1);

        TenantAccount tenantAccount = new TenantAccount();
        tenantAccount.setAccountId(1234567890L);
        tenantAccount.setId(123L);
        tenantAccount.setIsAdmin(true);
        tenantAccount.setTenantId(123L);
        when(this.tenantAccountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TenantAccount>) any()))
                .thenReturn(tenantAccount);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenThrow(new BusinessException());
        when(this.accountMapper.insert((Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);

        CreateTenantRequestDTO createTenantRequestDTO = new CreateTenantRequestDTO();
        createTenantRequestDTO.setBundleCode("Bundle Code");
        createTenantRequestDTO.setMobile("Mobile");
        createTenantRequestDTO.setName("Name");
        createTenantRequestDTO.setPassword("iloveyou");
        createTenantRequestDTO.setTenantTypeCode("Tenant Type Code");
        createTenantRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.createTenantAndAccount(createTenantRequestDTO));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createTenantAndAccount(CreateTenantRequestDTO)}
     */
    @Test
    void testCreateTenantAndAccount2()
    {
        Tenant tenant = new Tenant();
        tenant.setBundleCode("Bundle Code");
        tenant.setId(123L);
        tenant.setName("Name");
        tenant.setTenantTypeCode("Tenant Type Code");
        when(this.tenantMapper.selectById((java.io.Serializable) any())).thenReturn(tenant);
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        when(this.tenantMapper.insert((Tenant) any())).thenReturn(1);

        TenantAccount tenantAccount = new TenantAccount();
        tenantAccount.setAccountId(1234567890L);
        tenantAccount.setId(123L);
        tenantAccount.setIsAdmin(true);
        tenantAccount.setTenantId(123L);
        when(this.tenantAccountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TenantAccount>) any()))
                .thenReturn(tenantAccount);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.selectOne(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.Account>) any()))
                .thenThrow(new BusinessException());
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(0);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);

        CreateTenantRequestDTO createTenantRequestDTO = new CreateTenantRequestDTO();
        createTenantRequestDTO.setBundleCode("Bundle Code");
        createTenantRequestDTO.setMobile("Mobile");
        createTenantRequestDTO.setName("Name");
        createTenantRequestDTO.setPassword("iloveyou");
        createTenantRequestDTO.setTenantTypeCode("Tenant Type Code");
        createTenantRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.createTenantAndAccount(createTenantRequestDTO));
        verify(this.tenantMapper).insert((Tenant) any());
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper, atLeast(1)).selectAccountByMobile((String) any());
        verify(this.accountMapper).selectAccountByName((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createTenantRelateAccount(CreateTenantRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateTenantRelateAccount()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: field null expect '[', but error, pos 1, line 1, column 2Ability
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(DefaultJSONParser.java:738)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(DefaultJSONParser.java:726)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(DefaultJSONParser.java:721)
        //       at com.alibaba.fastjson.JSON.parseArray(JSON.java:643)
        //       at com.alibaba.fastjson.JSON.parseArray(JSON.java:623)
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.initBundle(TenantServiceImpl.java:351)
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.createTenantRelateAccount(TenantServiceImpl.java:197)
        //   In order to prevent createTenantRelateAccount(CreateTenantRequestDTO)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createTenantRelateAccount(CreateTenantRequestDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.tenantMapper.insert((mao.aggregate_pay_user_service.entity.Tenant) any())).thenReturn(1);
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);

        Bundle bundle = new Bundle();
        bundle.setAbility("Ability");
        bundle.setCode("Code");
        bundle.setComment("Comment");
        bundle.setId(123L);
        bundle.setInitialize(true);
        bundle.setName("Name");
        bundle.setNumberOfApp(10);
        bundle.setNumberOfConcurrent(10);
        bundle.setNumberOfInvocation(10);
        bundle.setTenantTypeCode("Tenant Type Code");
        when(this.bundleMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any()))
                .thenReturn(bundle);

        Account account = new Account();
        account.setId(123L);
        account.setMobile("Mobile");
        account.setPassword("iloveyou");
        account.setSalt("Salt");
        account.setUsername("janedoe");
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenReturn(account);

        CreateTenantRequestDTO createTenantRequestDTO = new CreateTenantRequestDTO();
        createTenantRequestDTO.setBundleCode("Bundle Code");
        createTenantRequestDTO.setMobile("Mobile");
        createTenantRequestDTO.setName("Name");
        createTenantRequestDTO.setPassword("iloveyou");
        createTenantRequestDTO.setTenantTypeCode("Tenant Type Code");
        createTenantRequestDTO.setUsername("janedoe");
        this.tenantServiceImpl.createTenantRelateAccount(createTenantRequestDTO);
    }

    /**
     * Method under test: {@link TenantServiceImpl#createTenantRelateAccount(CreateTenantRequestDTO)}
     */
    @Test
    void testCreateTenantRelateAccount2()
    {
        when(this.tenantMapper.insert((mao.aggregate_pay_user_service.entity.Tenant) any())).thenReturn(1);
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);

        Bundle bundle = new Bundle();
        bundle.setAbility("Ability");
        bundle.setCode("Code");
        bundle.setComment("Comment");
        bundle.setId(123L);
        bundle.setInitialize(true);
        bundle.setName("Name");
        bundle.setNumberOfApp(10);
        bundle.setNumberOfConcurrent(10);
        bundle.setNumberOfInvocation(10);
        bundle.setTenantTypeCode("Tenant Type Code");
        when(this.bundleMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any()))
                .thenReturn(bundle);
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenThrow(new BusinessException());

        CreateTenantRequestDTO createTenantRequestDTO = new CreateTenantRequestDTO();
        createTenantRequestDTO.setBundleCode("Bundle Code");
        createTenantRequestDTO.setMobile("Mobile");
        createTenantRequestDTO.setName("Name");
        createTenantRequestDTO.setPassword("iloveyou");
        createTenantRequestDTO.setTenantTypeCode("Tenant Type Code");
        createTenantRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.createTenantRelateAccount(createTenantRequestDTO));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#getTenant(Long)}
     */
    @Test
    void testGetTenant()
    {
        Tenant tenant = new Tenant();
        tenant.setBundleCode("Bundle Code");
        tenant.setId(123L);
        tenant.setName("Name");
        tenant.setTenantTypeCode("Tenant Type Code");
        when(this.tenantMapper.selectById((java.io.Serializable) any())).thenReturn(tenant);

        TenantDTO tenantDTO = new TenantDTO();
        tenantDTO.setBundleCode("Bundle Code");
        tenantDTO.setId(123L);
        tenantDTO.setName("Name");
        tenantDTO.setTenantTypeCode("Tenant Type Code");
        when(this.dozerUtils.map((Object) any(), (Class<TenantDTO>) any())).thenReturn(tenantDTO);
        assertSame(tenantDTO, this.tenantServiceImpl.getTenant(123L));
        verify(this.tenantMapper).selectById((java.io.Serializable) any());
        verify(this.dozerUtils).map((Object) any(), (Class<TenantDTO>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#getTenant(Long)}
     */
    @Test
    void testGetTenant2()
    {
        Tenant tenant = new Tenant();
        tenant.setBundleCode("Bundle Code");
        tenant.setId(123L);
        tenant.setName("Name");
        tenant.setTenantTypeCode("Tenant Type Code");
        when(this.tenantMapper.selectById((java.io.Serializable) any())).thenReturn(tenant);
        when(this.dozerUtils.map((Object) any(), (Class<TenantDTO>) any())).thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.getTenant(123L));
        verify(this.tenantMapper).selectById((java.io.Serializable) any());
        verify(this.dozerUtils).map((Object) any(), (Class<TenantDTO>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryTenants(TenantQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    void testQueryTenants()
    {
        when(this.tenantMapper.selectTenantByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<TenantDTO>) any(), (TenantQueryDTO) any(),
                (String) any(), (String) any())).thenReturn(new ArrayList<>());

        TenantQueryDTO tenantQueryDTO = new TenantQueryDTO();
        tenantQueryDTO.setName("Name");
        tenantQueryDTO.setTenantTypeCode("Tenant Type Code");
        PageVO<TenantDTO> actualQueryTenantsResult = this.tenantServiceImpl.queryTenants(tenantQueryDTO, 1, 3, "Sort By",
                "Order");
        assertEquals(0L, actualQueryTenantsResult.getCounts());
        assertFalse(actualQueryTenantsResult.isFirst());
        assertFalse(actualQueryTenantsResult.hasItems());
        assertEquals(3, actualQueryTenantsResult.getPageSize());
        verify(this.tenantMapper).selectTenantByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<TenantDTO>) any(), (TenantQueryDTO) any(),
                (String) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryTenants(TenantQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    void testQueryTenants2()
    {
        when(this.tenantMapper.selectTenantByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<TenantDTO>) any(), (TenantQueryDTO) any(),
                (String) any(), (String) any())).thenReturn(new ArrayList<>());

        TenantQueryDTO tenantQueryDTO = new TenantQueryDTO();
        tenantQueryDTO.setName("Name");
        tenantQueryDTO.setTenantTypeCode("Tenant Type Code");
        PageVO<TenantDTO> actualQueryTenantsResult = this.tenantServiceImpl.queryTenants(tenantQueryDTO, 3, 3, "Sort By",
                "Order");
        assertEquals(0L, actualQueryTenantsResult.getCounts());
        assertFalse(actualQueryTenantsResult.isFirst());
        assertFalse(actualQueryTenantsResult.hasItems());
        assertEquals(3, actualQueryTenantsResult.getPageSize());
        verify(this.tenantMapper).selectTenantByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<TenantDTO>) any(), (TenantQueryDTO) any(),
                (String) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryTenants(TenantQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryTenants3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.queryTenants(TenantServiceImpl.java:242)
        //   In order to prevent queryTenants(TenantQueryDTO, Integer, Integer, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryTenants(TenantQueryDTO, Integer, Integer, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.tenantMapper.selectTenantByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<TenantDTO>) any(), (TenantQueryDTO) any(),
                (String) any(), (String) any())).thenReturn(new ArrayList<>());

        TenantQueryDTO tenantQueryDTO = new TenantQueryDTO();
        tenantQueryDTO.setName("Name");
        tenantQueryDTO.setTenantTypeCode("Tenant Type Code");
        this.tenantServiceImpl.queryTenants(tenantQueryDTO, null, 3, "Sort By", "Order");
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryTenants(TenantQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    void testQueryTenants4()
    {
        when(this.tenantMapper.selectTenantByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<TenantDTO>) any(), (TenantQueryDTO) any(),
                (String) any(), (String) any())).thenReturn(new ArrayList<>());

        TenantQueryDTO tenantQueryDTO = new TenantQueryDTO();
        tenantQueryDTO.setName("Name");
        tenantQueryDTO.setTenantTypeCode("Tenant Type Code");
        PageVO<TenantDTO> actualQueryTenantsResult = this.tenantServiceImpl.queryTenants(tenantQueryDTO, 1, 0, "Sort By",
                "Order");
        assertEquals(0L, actualQueryTenantsResult.getCounts());
        assertFalse(actualQueryTenantsResult.isFirst());
        assertFalse(actualQueryTenantsResult.hasItems());
        assertEquals(1, actualQueryTenantsResult.getPages());
        verify(this.tenantMapper).selectTenantByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<TenantDTO>) any(), (TenantQueryDTO) any(),
                (String) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryTenants(TenantQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryTenants5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.queryTenants(TenantServiceImpl.java:244)
        //   In order to prevent queryTenants(TenantQueryDTO, Integer, Integer, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryTenants(TenantQueryDTO, Integer, Integer, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.tenantMapper.selectTenantByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<TenantDTO>) any(), (TenantQueryDTO) any(),
                (String) any(), (String) any())).thenReturn(new ArrayList<>());

        TenantQueryDTO tenantQueryDTO = new TenantQueryDTO();
        tenantQueryDTO.setName("Name");
        tenantQueryDTO.setTenantTypeCode("Tenant Type Code");
        this.tenantServiceImpl.queryTenants(tenantQueryDTO, 1, null, "Sort By", "Order");
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryTenants(TenantQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    void testQueryTenants6()
    {
        when(this.tenantMapper.selectTenantByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<TenantDTO>) any(), (TenantQueryDTO) any(),
                (String) any(), (String) any())).thenThrow(new BusinessException());

        TenantQueryDTO tenantQueryDTO = new TenantQueryDTO();
        tenantQueryDTO.setName("Name");
        tenantQueryDTO.setTenantTypeCode("Tenant Type Code");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.queryTenants(tenantQueryDTO, 1, 3, "Sort By", "Order"));
        verify(this.tenantMapper).selectTenantByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<TenantDTO>) any(), (TenantQueryDTO) any(),
                (String) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryBundleByTenantType(String)}
     */
    @Test
    void testQueryBundleByTenantType()
    {
        ArrayList<Object> objectList = new ArrayList<>();
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any())).thenReturn(objectList);
        when(this.bundleMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any()))
                .thenReturn(new ArrayList<>());
        List<BundleDTO> actualQueryBundleByTenantTypeResult = this.tenantServiceImpl.queryBundleByTenantType("Tenant Type");
        assertSame(objectList, actualQueryBundleByTenantTypeResult);
        assertTrue(actualQueryBundleByTenantTypeResult.isEmpty());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.bundleMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryBundleByTenantType(String)}
     */
    @Test
    void testQueryBundleByTenantType2()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());
        when(this.bundleMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.queryBundleByTenantType("Tenant Type"));
        verify(this.bundleMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#getBundle(String)}
     */
    @Test
    void testGetBundle()
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
        when(this.dozerUtils.map((Object) any(), (Class<BundleDTO>) any())).thenReturn(bundleDTO);

        Bundle bundle = new Bundle();
        bundle.setAbility("Ability");
        bundle.setCode("Code");
        bundle.setComment("Comment");
        bundle.setId(123L);
        bundle.setInitialize(true);
        bundle.setName("Name");
        bundle.setNumberOfApp(10);
        bundle.setNumberOfConcurrent(10);
        bundle.setNumberOfInvocation(10);
        bundle.setTenantTypeCode("Tenant Type Code");
        when(this.bundleMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any()))
                .thenReturn(bundle);
        assertSame(bundleDTO, this.tenantServiceImpl.getBundle("Bundle Code"));
        verify(this.dozerUtils).map((Object) any(), (Class<BundleDTO>) any());
        verify(this.bundleMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#getBundle(String)}
     */
    @Test
    void testGetBundle2()
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
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<BundleDTO>) any())).thenReturn(bundleDTO);
        when(this.bundleMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.getBundle("Bundle Code"));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.bundleMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAllBundle()}
     */
    @Test
    void testQueryAllBundle()
    {
        ArrayList<Object> objectList = new ArrayList<>();
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any())).thenReturn(objectList);
        when(this.bundleMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any()))
                .thenReturn(new ArrayList<>());
        List<BundleDTO> actualQueryAllBundleResult = this.tenantServiceImpl.queryAllBundle();
        assertSame(objectList, actualQueryAllBundleResult);
        assertTrue(actualQueryAllBundleResult.isEmpty());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.bundleMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAllBundle()}
     */
    @Test
    void testQueryAllBundle2()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());
        when(this.bundleMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.queryAllBundle());
        verify(this.bundleMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAllBundle()}
     */
    @Test
    void testQueryAllBundle3()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenThrow(new BusinessException());
        when(this.bundleMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any()))
                .thenReturn(new ArrayList<>());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.queryAllBundle());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.bundleMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#changeBundle(Long, String)}
     */
    @Test
    void testChangeBundle()
    {
        when(this.authorizationService.queryRole((Long) any())).thenReturn(new ArrayList<>());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.changeBundle(123L, "Bundle Code"));
        verify(this.authorizationService).queryRole((Long) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#changeBundle(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeBundle2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [roleCode] of entity [mao.aggregate_pay_user_service.entity.AccountRole]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper.set(LambdaUpdateWrapper.java:81)
        //       at com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper.set(LambdaUpdateWrapper.java:37)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.changeBundle(TenantServiceImpl.java:316)
        //   In order to prevent changeBundle(Long, String)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeBundle(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);

        ArrayList<RoleDTO> roleDTOList = new ArrayList<>();
        roleDTOList.add(roleDTO);
        when(this.authorizationService.queryRole((Long) any())).thenReturn(roleDTOList);
        this.tenantServiceImpl.changeBundle(123L, "Bundle Code");
    }

    /**
     * Method under test: {@link TenantServiceImpl#initBundle(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInitBundle()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: field null expect '[', but error, pos 1, line 1, column 2Ability
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(DefaultJSONParser.java:738)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(DefaultJSONParser.java:726)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(DefaultJSONParser.java:721)
        //       at com.alibaba.fastjson.JSON.parseArray(JSON.java:643)
        //       at com.alibaba.fastjson.JSON.parseArray(JSON.java:623)
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.initBundle(TenantServiceImpl.java:351)
        //   In order to prevent initBundle(Long, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   initBundle(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        Bundle bundle = new Bundle();
        bundle.setAbility("Ability");
        bundle.setCode("Code");
        bundle.setComment("Comment");
        bundle.setId(123L);
        bundle.setInitialize(true);
        bundle.setName("Name");
        bundle.setNumberOfApp(10);
        bundle.setNumberOfConcurrent(10);
        bundle.setNumberOfInvocation(10);
        bundle.setTenantTypeCode("Tenant Type Code");
        when(this.bundleMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any()))
                .thenReturn(bundle);
        this.tenantServiceImpl.initBundle(123L, "Bundle Code");
    }

    /**
     * Method under test: {@link TenantServiceImpl#initBundle(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInitBundle2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: error parse false
        //       at com.alibaba.fastjson.parser.JSONLexerBase.scanFalse(JSONLexerBase.java:4749)
        //       at com.alibaba.fastjson.parser.JSONLexerBase.nextToken(JSONLexerBase.java:151)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.<init>(DefaultJSONParser.java:170)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.<init>(DefaultJSONParser.java:137)
        //       at com.alibaba.fastjson.JSON.parseArray(JSON.java:633)
        //       at com.alibaba.fastjson.JSON.parseArray(JSON.java:623)
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.initBundle(TenantServiceImpl.java:351)
        //   In order to prevent initBundle(Long, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   initBundle(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        Bundle bundle = mock(Bundle.class);
        when(bundle.getAbility()).thenReturn("foo");
        doNothing().when(bundle).setAbility((String) any());
        doNothing().when(bundle).setCode((String) any());
        doNothing().when(bundle).setComment((String) any());
        doNothing().when(bundle).setId((Long) any());
        doNothing().when(bundle).setInitialize((Boolean) any());
        doNothing().when(bundle).setName((String) any());
        doNothing().when(bundle).setNumberOfApp((Integer) any());
        doNothing().when(bundle).setNumberOfConcurrent((Integer) any());
        doNothing().when(bundle).setNumberOfInvocation((Integer) any());
        doNothing().when(bundle).setTenantTypeCode((String) any());
        bundle.setAbility("Ability");
        bundle.setCode("Code");
        bundle.setComment("Comment");
        bundle.setId(123L);
        bundle.setInitialize(true);
        bundle.setName("Name");
        bundle.setNumberOfApp(10);
        bundle.setNumberOfConcurrent(10);
        bundle.setNumberOfInvocation(10);
        bundle.setTenantTypeCode("Tenant Type Code");
        when(this.bundleMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any()))
                .thenReturn(bundle);
        this.tenantServiceImpl.initBundle(123L, "Bundle Code");
    }

    /**
     * Method under test: {@link TenantServiceImpl#initBundle(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInitBundle3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: field null expect '[', but int, pos 2, line 1, column 342
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(DefaultJSONParser.java:738)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(DefaultJSONParser.java:726)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(DefaultJSONParser.java:721)
        //       at com.alibaba.fastjson.JSON.parseArray(JSON.java:643)
        //       at com.alibaba.fastjson.JSON.parseArray(JSON.java:623)
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.initBundle(TenantServiceImpl.java:351)
        //   In order to prevent initBundle(Long, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   initBundle(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        Bundle bundle = mock(Bundle.class);
        when(bundle.getAbility()).thenReturn("42");
        doNothing().when(bundle).setAbility((String) any());
        doNothing().when(bundle).setCode((String) any());
        doNothing().when(bundle).setComment((String) any());
        doNothing().when(bundle).setId((Long) any());
        doNothing().when(bundle).setInitialize((Boolean) any());
        doNothing().when(bundle).setName((String) any());
        doNothing().when(bundle).setNumberOfApp((Integer) any());
        doNothing().when(bundle).setNumberOfConcurrent((Integer) any());
        doNothing().when(bundle).setNumberOfInvocation((Integer) any());
        doNothing().when(bundle).setTenantTypeCode((String) any());
        bundle.setAbility("Ability");
        bundle.setCode("Code");
        bundle.setComment("Comment");
        bundle.setId(123L);
        bundle.setInitialize(true);
        bundle.setName("Name");
        bundle.setNumberOfApp(10);
        bundle.setNumberOfConcurrent(10);
        bundle.setNumberOfInvocation(10);
        bundle.setTenantTypeCode("Tenant Type Code");
        when(this.bundleMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any()))
                .thenReturn(bundle);
        this.tenantServiceImpl.initBundle(123L, "Bundle Code");
    }

    /**
     * Method under test: {@link TenantServiceImpl#initBundle(Long, String)}
     */
    @Test
    void testInitBundle4()
    {
        Bundle bundle = mock(Bundle.class);
        when(bundle.getAbility()).thenReturn("");
        doNothing().when(bundle).setAbility((String) any());
        doNothing().when(bundle).setCode((String) any());
        doNothing().when(bundle).setComment((String) any());
        doNothing().when(bundle).setId((Long) any());
        doNothing().when(bundle).setInitialize((Boolean) any());
        doNothing().when(bundle).setName((String) any());
        doNothing().when(bundle).setNumberOfApp((Integer) any());
        doNothing().when(bundle).setNumberOfConcurrent((Integer) any());
        doNothing().when(bundle).setNumberOfInvocation((Integer) any());
        doNothing().when(bundle).setTenantTypeCode((String) any());
        bundle.setAbility("Ability");
        bundle.setCode("Code");
        bundle.setComment("Comment");
        bundle.setId(123L);
        bundle.setInitialize(true);
        bundle.setName("Name");
        bundle.setNumberOfApp(10);
        bundle.setNumberOfConcurrent(10);
        bundle.setNumberOfInvocation(10);
        bundle.setTenantTypeCode("Tenant Type Code");
        when(this.bundleMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any()))
                .thenReturn(bundle);
        this.tenantServiceImpl.initBundle(123L, "Bundle Code");
        verify(this.bundleMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Bundle>) any());
        verify(bundle).getAbility();
        verify(bundle).setAbility((String) any());
        verify(bundle).setCode((String) any());
        verify(bundle).setComment((String) any());
        verify(bundle).setId((Long) any());
        verify(bundle).setInitialize((Boolean) any());
        verify(bundle).setName((String) any());
        verify(bundle).setNumberOfApp((Integer) any());
        verify(bundle).setNumberOfConcurrent((Integer) any());
        verify(bundle).setNumberOfInvocation((Integer) any());
        verify(bundle).setTenantTypeCode((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createBundle(BundleDTO)}
     */
    @Test
    void testCreateBundle()
    {
        Bundle bundle = new Bundle();
        bundle.setAbility("Ability");
        bundle.setCode("Code");
        bundle.setComment("Comment");
        bundle.setId(123L);
        bundle.setInitialize(true);
        bundle.setName("Name");
        bundle.setNumberOfApp(10);
        bundle.setNumberOfConcurrent(10);
        bundle.setNumberOfInvocation(10);
        bundle.setTenantTypeCode("Tenant Type Code");
        when(this.dozerUtils.map((Object) any(), (Class<Bundle>) any())).thenReturn(bundle);
        when(this.bundleMapper.insert((Bundle) any())).thenReturn(1);

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
        this.tenantServiceImpl.createBundle(bundleDTO);
        verify(this.dozerUtils).map((Object) any(), (Class<Bundle>) any());
        verify(this.bundleMapper).insert((Bundle) any());
        assertEquals("Ability", bundleDTO.getAbility());
        assertEquals("Tenant Type Code", bundleDTO.getTenantTypeCode());
        assertEquals(10, bundleDTO.getNumberOfInvocation().intValue());
        assertEquals(10, bundleDTO.getNumberOfConcurrent().intValue());
        assertEquals(10, bundleDTO.getNumberOfApp().intValue());
        assertEquals("Name", bundleDTO.getName());
        assertTrue(bundleDTO.getInitialize());
        assertEquals(123L, bundleDTO.getId().longValue());
        assertEquals("Comment", bundleDTO.getComment());
        assertEquals("Code", bundleDTO.getCode());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createBundle(BundleDTO)}
     */
    @Test
    void testCreateBundle2()
    {
        Bundle bundle = new Bundle();
        bundle.setAbility("Ability");
        bundle.setCode("Code");
        bundle.setComment("Comment");
        bundle.setId(123L);
        bundle.setInitialize(true);
        bundle.setName("Name");
        bundle.setNumberOfApp(10);
        bundle.setNumberOfConcurrent(10);
        bundle.setNumberOfInvocation(10);
        bundle.setTenantTypeCode("Tenant Type Code");
        when(this.dozerUtils.map((Object) any(), (Class<Bundle>) any())).thenReturn(bundle);
        when(this.bundleMapper.insert((Bundle) any())).thenThrow(new BusinessException());

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
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.createBundle(bundleDTO));
        verify(this.dozerUtils).map((Object) any(), (Class<Bundle>) any());
        verify(this.bundleMapper).insert((Bundle) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#modifyBundle(BundleDTO)}
     */
    @Test
    void testModifyBundle()
    {
        Bundle bundle = new Bundle();
        bundle.setAbility("Ability");
        bundle.setCode("Code");
        bundle.setComment("Comment");
        bundle.setId(123L);
        bundle.setInitialize(true);
        bundle.setName("Name");
        bundle.setNumberOfApp(10);
        bundle.setNumberOfConcurrent(10);
        bundle.setNumberOfInvocation(10);
        bundle.setTenantTypeCode("Tenant Type Code");
        when(this.dozerUtils.map((Object) any(), (Class<Bundle>) any())).thenReturn(bundle);
        when(this.bundleMapper.updateById((Bundle) any())).thenReturn(123);

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
        this.tenantServiceImpl.modifyBundle(bundleDTO);
        verify(this.dozerUtils).map((Object) any(), (Class<Bundle>) any());
        verify(this.bundleMapper).updateById((Bundle) any());
        assertEquals("Ability", bundleDTO.getAbility());
        assertEquals("Tenant Type Code", bundleDTO.getTenantTypeCode());
        assertEquals(10, bundleDTO.getNumberOfInvocation().intValue());
        assertEquals(10, bundleDTO.getNumberOfConcurrent().intValue());
        assertEquals(10, bundleDTO.getNumberOfApp().intValue());
        assertEquals("Name", bundleDTO.getName());
        assertTrue(bundleDTO.getInitialize());
        assertEquals(123L, bundleDTO.getId().longValue());
        assertEquals("Comment", bundleDTO.getComment());
        assertEquals("Code", bundleDTO.getCode());
    }

    /**
     * Method under test: {@link TenantServiceImpl#modifyBundle(BundleDTO)}
     */
    @Test
    void testModifyBundle2()
    {
        Bundle bundle = new Bundle();
        bundle.setAbility("Ability");
        bundle.setCode("Code");
        bundle.setComment("Comment");
        bundle.setId(123L);
        bundle.setInitialize(true);
        bundle.setName("Name");
        bundle.setNumberOfApp(10);
        bundle.setNumberOfConcurrent(10);
        bundle.setNumberOfInvocation(10);
        bundle.setTenantTypeCode("Tenant Type Code");
        when(this.dozerUtils.map((Object) any(), (Class<Bundle>) any())).thenReturn(bundle);
        when(this.bundleMapper.updateById((Bundle) any())).thenThrow(new BusinessException());

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
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.modifyBundle(bundleDTO));
        verify(this.dozerUtils).map((Object) any(), (Class<Bundle>) any());
        verify(this.bundleMapper).updateById((Bundle) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    void testCreateAccountInTenant()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);

        CreateAccountRequestDTO createAccountRequestDTO = new CreateAccountRequestDTO();
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.createAccountInTenant(createAccountRequestDTO, 123L));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    void testCreateAccountInTenant2()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(0);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);

        CreateAccountRequestDTO createAccountRequestDTO = new CreateAccountRequestDTO();
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.createAccountInTenant(createAccountRequestDTO, 123L));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(this.accountMapper).selectAccountByName((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    void testCreateAccountInTenant3()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.getMapper()).thenReturn(null);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.createAccountInTenant(createAccountRequestDTO, 123L));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    void testCreateAccountInTenant4()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        AccountDTO accountDTO = mock(AccountDTO.class);
        when(accountDTO.getId()).thenReturn(123L);
        when(accountDTO.getMobile()).thenReturn("Mobile");
        when(accountDTO.getPassword()).thenReturn("iloveyou");
        when(accountDTO.getSalt()).thenReturn("Salt");
        when(accountDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(accountDTO).setId((Long) any());
        doNothing().when(accountDTO).setMobile((String) any());
        doNothing().when(accountDTO).setPassword((String) any());
        doNothing().when(accountDTO).setSalt((String) any());
        doNothing().when(accountDTO).setUsername((String) any());
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.getMapper()).thenReturn(null);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.createAccountInTenant(createAccountRequestDTO, 123L));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(accountDTO).getId();
        verify(accountDTO).getMobile();
        verify(accountDTO).getPassword();
        verify(accountDTO).getSalt();
        verify(accountDTO).getUsername();
        verify(accountDTO).setId((Long) any());
        verify(accountDTO).setMobile((String) any());
        verify(accountDTO).setPassword((String) any());
        verify(accountDTO).setSalt((String) any());
        verify(accountDTO).setUsername((String) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    void testCreateAccountInTenant5()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        AccountDTO accountDTO = mock(AccountDTO.class);
        when(accountDTO.getId()).thenReturn(123L);
        when(accountDTO.getMobile()).thenReturn("Mobile");
        when(accountDTO.getPassword()).thenReturn("iloveyou");
        when(accountDTO.getSalt()).thenReturn("Salt");
        when(accountDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(accountDTO).setId((Long) any());
        doNothing().when(accountDTO).setMobile((String) any());
        doNothing().when(accountDTO).setPassword((String) any());
        doNothing().when(accountDTO).setSalt((String) any());
        doNothing().when(accountDTO).setUsername((String) any());
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.getMapper()).thenReturn(null);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("判断手机号在账号中是否存在");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.createAccountInTenant(createAccountRequestDTO, 123L));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(accountDTO).getId();
        verify(accountDTO).getMobile();
        verify(accountDTO).getPassword();
        verify(accountDTO).getSalt();
        verify(accountDTO).getUsername();
        verify(accountDTO).setId((Long) any());
        verify(accountDTO).setMobile((String) any());
        verify(accountDTO).setPassword((String) any());
        verify(accountDTO).setSalt((String) any());
        verify(accountDTO).setUsername((String) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    void testCreateAccountInTenant6()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        AccountDTO accountDTO = mock(AccountDTO.class);
        when(accountDTO.getId()).thenReturn(-1L);
        when(accountDTO.getMobile()).thenReturn("Mobile");
        when(accountDTO.getPassword()).thenReturn("iloveyou");
        when(accountDTO.getSalt()).thenReturn("Salt");
        when(accountDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(accountDTO).setId((Long) any());
        doNothing().when(accountDTO).setMobile((String) any());
        doNothing().when(accountDTO).setPassword((String) any());
        doNothing().when(accountDTO).setSalt((String) any());
        doNothing().when(accountDTO).setUsername((String) any());
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.getMapper()).thenReturn(null);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.createAccountInTenant(createAccountRequestDTO, 123L));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(accountDTO).getId();
        verify(accountDTO).getMobile();
        verify(accountDTO).getPassword();
        verify(accountDTO).getSalt();
        verify(accountDTO).getUsername();
        verify(accountDTO).setId((Long) any());
        verify(accountDTO).setMobile((String) any());
        verify(accountDTO).setPassword((String) any());
        verify(accountDTO).setSalt((String) any());
        verify(accountDTO).setUsername((String) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    void testCreateAccountInTenant7()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        AccountDTO accountDTO = mock(AccountDTO.class);
        when(accountDTO.getId()).thenReturn(Long.MAX_VALUE);
        when(accountDTO.getMobile()).thenReturn("Mobile");
        when(accountDTO.getPassword()).thenReturn("iloveyou");
        when(accountDTO.getSalt()).thenReturn("Salt");
        when(accountDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(accountDTO).setId((Long) any());
        doNothing().when(accountDTO).setMobile((String) any());
        doNothing().when(accountDTO).setPassword((String) any());
        doNothing().when(accountDTO).setSalt((String) any());
        doNothing().when(accountDTO).setUsername((String) any());
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.getMapper()).thenReturn(null);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.createAccountInTenant(createAccountRequestDTO, 123L));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(accountDTO).getId();
        verify(accountDTO).getMobile();
        verify(accountDTO).getPassword();
        verify(accountDTO).getSalt();
        verify(accountDTO).getUsername();
        verify(accountDTO).setId((Long) any());
        verify(accountDTO).setMobile((String) any());
        verify(accountDTO).setPassword((String) any());
        verify(accountDTO).setSalt((String) any());
        verify(accountDTO).setUsername((String) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    void testCreateAccountInTenant8()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        AccountDTO accountDTO = mock(AccountDTO.class);
        when(accountDTO.getId()).thenReturn(Long.MIN_VALUE);
        when(accountDTO.getMobile()).thenReturn("Mobile");
        when(accountDTO.getPassword()).thenReturn("iloveyou");
        when(accountDTO.getSalt()).thenReturn("Salt");
        when(accountDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(accountDTO).setId((Long) any());
        doNothing().when(accountDTO).setMobile((String) any());
        doNothing().when(accountDTO).setPassword((String) any());
        doNothing().when(accountDTO).setSalt((String) any());
        doNothing().when(accountDTO).setUsername((String) any());
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.getMapper()).thenReturn(null);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.createAccountInTenant(createAccountRequestDTO, 123L));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(accountDTO).getId();
        verify(accountDTO).getMobile();
        verify(accountDTO).getPassword();
        verify(accountDTO).getSalt();
        verify(accountDTO).getUsername();
        verify(accountDTO).setId((Long) any());
        verify(accountDTO).setMobile((String) any());
        verify(accountDTO).setPassword((String) any());
        verify(accountDTO).setSalt((String) any());
        verify(accountDTO).setUsername((String) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    void testCreateAccountInTenant9()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        AccountDTO accountDTO = mock(AccountDTO.class);
        when(accountDTO.getId()).thenReturn(123L);
        when(accountDTO.getMobile()).thenReturn("创建账号：");
        when(accountDTO.getPassword()).thenReturn("iloveyou");
        when(accountDTO.getSalt()).thenReturn("Salt");
        when(accountDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(accountDTO).setId((Long) any());
        doNothing().when(accountDTO).setMobile((String) any());
        doNothing().when(accountDTO).setPassword((String) any());
        doNothing().when(accountDTO).setSalt((String) any());
        doNothing().when(accountDTO).setUsername((String) any());
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.getMapper()).thenReturn(null);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.createAccountInTenant(createAccountRequestDTO, 123L));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(accountDTO).getId();
        verify(accountDTO).getMobile();
        verify(accountDTO).getPassword();
        verify(accountDTO).getSalt();
        verify(accountDTO).getUsername();
        verify(accountDTO).setId((Long) any());
        verify(accountDTO).setMobile((String) any());
        verify(accountDTO).setPassword((String) any());
        verify(accountDTO).setSalt((String) any());
        verify(accountDTO).setUsername((String) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    void testCreateAccountInTenant10()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        AccountDTO accountDTO = mock(AccountDTO.class);
        when(accountDTO.getId()).thenReturn(123L);
        when(accountDTO.getMobile()).thenReturn("Mobile");
        when(accountDTO.getPassword()).thenReturn("判断手机号在账号中是否存在");
        when(accountDTO.getSalt()).thenReturn("Salt");
        when(accountDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(accountDTO).setId((Long) any());
        doNothing().when(accountDTO).setMobile((String) any());
        doNothing().when(accountDTO).setPassword((String) any());
        doNothing().when(accountDTO).setSalt((String) any());
        doNothing().when(accountDTO).setUsername((String) any());
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.getMapper()).thenReturn(null);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.createAccountInTenant(createAccountRequestDTO, 123L));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(accountDTO).getId();
        verify(accountDTO).getMobile();
        verify(accountDTO).getPassword();
        verify(accountDTO).getSalt();
        verify(accountDTO).getUsername();
        verify(accountDTO).setId((Long) any());
        verify(accountDTO).setMobile((String) any());
        verify(accountDTO).setPassword((String) any());
        verify(accountDTO).setSalt((String) any());
        verify(accountDTO).setUsername((String) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    void testCreateAccountInTenant11()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        AccountDTO accountDTO = mock(AccountDTO.class);
        when(accountDTO.getId()).thenReturn(123L);
        when(accountDTO.getMobile()).thenReturn("Mobile");
        when(accountDTO.getPassword()).thenReturn("iloveyou");
        when(accountDTO.getSalt()).thenReturn("Salt");
        when(accountDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(accountDTO).setId((Long) any());
        doNothing().when(accountDTO).setMobile((String) any());
        doNothing().when(accountDTO).setPassword((String) any());
        doNothing().when(accountDTO).setSalt((String) any());
        doNothing().when(accountDTO).setUsername((String) any());
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.getMapper()).thenReturn(null);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.createAccountInTenant(createAccountRequestDTO, 123L));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(accountDTO).getId();
        verify(accountDTO).getMobile();
        verify(accountDTO).getPassword();
        verify(accountDTO).getSalt();
        verify(accountDTO).getUsername();
        verify(accountDTO).setId((Long) any());
        verify(accountDTO).setMobile((String) any());
        verify(accountDTO).setPassword((String) any());
        verify(accountDTO).setSalt((String) any());
        verify(accountDTO).setUsername((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#bindTenant(Long, String)}
     */
    @Test
    void testBindTenant()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);

        Account account = new Account();
        account.setId(123L);
        account.setMobile("Mobile");
        account.setPassword("iloveyou");
        account.setSalt("Salt");
        account.setUsername("janedoe");
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenReturn(account);
        this.tenantServiceImpl.bindTenant(123L, "janedoe");
        verify(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        verify(this.dozerUtils).map((Object) any(), (Class<AccountDTO>) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#bindTenant(Long, String)}
     */
    @Test
    void testBindTenant2()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.bindTenant(123L, "janedoe"));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    void testCreateAccount()
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);

        CreateAccountRequestDTO createAccountRequestDTO = new CreateAccountRequestDTO();
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.createAccount(createAccountRequestDTO));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    void testCreateAccount2()
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(0);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);

        CreateAccountRequestDTO createAccountRequestDTO = new CreateAccountRequestDTO();
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.createAccount(createAccountRequestDTO));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(this.accountMapper).selectAccountByName((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    void testCreateAccount3()
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.getMapper()).thenReturn(null);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.createAccount(createAccountRequestDTO));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    void testCreateAccount4()
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        Mapper mapper = mock(Mapper.class);
        when(mapper.getMapperModelContext()).thenReturn(null);
        when(mapper.getMappingMetadata()).thenReturn(new DozerMappingMetadata(new ClassMappings(new BeanContainer())));
        when(this.dozerUtils.getMapper()).thenReturn(mapper);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.createAccount(createAccountRequestDTO));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(mapper).getMapperModelContext();
        verify(mapper).getMappingMetadata();
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAccount5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.creation.settings.CreationSettings, fieldName : mockSettings, write javaBean error, fastjson version 1.2.76, class com.diffblue.spring.isolation.framework.mocks.MockInvocationListener, fieldName : 0, write javaBean error, fastjson version 1.2.76, class org.mockito.codegen.DozerUtils$MockitoMock$951127696, fieldName : 0, write javaBean error, fastjson version 1.2.76, class com.github.dozermapper.core.metadata.DozerMappingMetadata, fieldName : mappingMetadata
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:541)
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:154)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.writeWithFieldName(JSONSerializer.java:360)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_3_MockMethodInterceptor.write(null)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_2_CreateAccountRequestDTO$MockitoMock$837625223.write(null)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.write(JSONSerializer.java:312)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:793)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:731)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:688)
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.createAccount(TenantServiceImpl.java:457)
        //   In order to prevent createAccount(CreateAccountRequestDTO)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAccount(CreateAccountRequestDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.getMapper()).thenReturn(mock(Mapper.class));
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        this.tenantServiceImpl.createAccount(createAccountRequestDTO);
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAccount6()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.creation.settings.CreationSettings, fieldName : mockSettings, write javaBean error, fastjson version 1.2.76, class com.diffblue.spring.isolation.framework.mocks.MockInvocationListener, fieldName : 0, write javaBean error, fastjson version 1.2.76, class org.mockito.codegen.DozerUtils$MockitoMock$951127696, fieldName : 2, write javaBean error, fastjson version 1.2.76, class com.github.dozermapper.core.metadata.DozerMappingMetadata, fieldName : mappingMetadata
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:541)
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:154)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.writeWithFieldName(JSONSerializer.java:360)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_3_MockMethodInterceptor.write(null)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_2_CreateAccountRequestDTO$MockitoMock$837625223.write(null)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.write(JSONSerializer.java:312)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:793)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:731)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:688)
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.createAccount(TenantServiceImpl.java:457)
        //   In order to prevent createAccount(CreateAccountRequestDTO)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAccount(CreateAccountRequestDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.getMapper()).thenReturn(mock(Mapper.class));
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        this.tenantServiceImpl.createAccount(createAccountRequestDTO);
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    void testCreateAccount7()
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        Mapper mapper = mock(Mapper.class);
        when(mapper.getMapperModelContext()).thenReturn(null);
        when(mapper.getMappingMetadata()).thenReturn(new DozerMappingMetadata(new ClassMappings(new BeanContainer())));
        when(this.dozerUtils.getMapper()).thenReturn(mapper);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("foo");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.createAccount(createAccountRequestDTO));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(mapper).getMapperModelContext();
        verify(mapper).getMappingMetadata();
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    void testCreateAccount8()
    {
        AccountDTO accountDTO = mock(AccountDTO.class);
        when(accountDTO.getId()).thenReturn(123L);
        when(accountDTO.getMobile()).thenReturn("Mobile");
        when(accountDTO.getPassword()).thenReturn("iloveyou");
        when(accountDTO.getSalt()).thenReturn("Salt");
        when(accountDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(accountDTO).setId((Long) any());
        doNothing().when(accountDTO).setMobile((String) any());
        doNothing().when(accountDTO).setPassword((String) any());
        doNothing().when(accountDTO).setSalt((String) any());
        doNothing().when(accountDTO).setUsername((String) any());
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        Mapper mapper = mock(Mapper.class);
        when(mapper.getMapperModelContext()).thenReturn(null);
        when(mapper.getMappingMetadata()).thenReturn(new DozerMappingMetadata(new ClassMappings(new BeanContainer())));
        when(this.dozerUtils.getMapper()).thenReturn(mapper);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("foo");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.createAccount(createAccountRequestDTO));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(mapper).getMapperModelContext();
        verify(mapper).getMappingMetadata();
        verify(accountDTO).getId();
        verify(accountDTO).getMobile();
        verify(accountDTO).getPassword();
        verify(accountDTO).getSalt();
        verify(accountDTO).getUsername();
        verify(accountDTO).setId((Long) any());
        verify(accountDTO).setMobile((String) any());
        verify(accountDTO).setPassword((String) any());
        verify(accountDTO).setSalt((String) any());
        verify(accountDTO).setUsername((String) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    void testCreateAccount9()
    {
        AccountDTO accountDTO = mock(AccountDTO.class);
        when(accountDTO.getId()).thenReturn(-1L);
        when(accountDTO.getMobile()).thenReturn("Mobile");
        when(accountDTO.getPassword()).thenReturn("iloveyou");
        when(accountDTO.getSalt()).thenReturn("Salt");
        when(accountDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(accountDTO).setId((Long) any());
        doNothing().when(accountDTO).setMobile((String) any());
        doNothing().when(accountDTO).setPassword((String) any());
        doNothing().when(accountDTO).setSalt((String) any());
        doNothing().when(accountDTO).setUsername((String) any());
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        Mapper mapper = mock(Mapper.class);
        when(mapper.getMapperModelContext()).thenReturn(null);
        when(mapper.getMappingMetadata()).thenReturn(new DozerMappingMetadata(new ClassMappings(new BeanContainer())));
        when(this.dozerUtils.getMapper()).thenReturn(mapper);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("foo");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.createAccount(createAccountRequestDTO));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(mapper).getMapperModelContext();
        verify(mapper).getMappingMetadata();
        verify(accountDTO).getId();
        verify(accountDTO).getMobile();
        verify(accountDTO).getPassword();
        verify(accountDTO).getSalt();
        verify(accountDTO).getUsername();
        verify(accountDTO).setId((Long) any());
        verify(accountDTO).setMobile((String) any());
        verify(accountDTO).setPassword((String) any());
        verify(accountDTO).setSalt((String) any());
        verify(accountDTO).setUsername((String) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    void testCreateAccount10()
    {
        AccountDTO accountDTO = mock(AccountDTO.class);
        when(accountDTO.getId()).thenReturn(Long.MAX_VALUE);
        when(accountDTO.getMobile()).thenReturn("Mobile");
        when(accountDTO.getPassword()).thenReturn("iloveyou");
        when(accountDTO.getSalt()).thenReturn("Salt");
        when(accountDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(accountDTO).setId((Long) any());
        doNothing().when(accountDTO).setMobile((String) any());
        doNothing().when(accountDTO).setPassword((String) any());
        doNothing().when(accountDTO).setSalt((String) any());
        doNothing().when(accountDTO).setUsername((String) any());
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        Mapper mapper = mock(Mapper.class);
        when(mapper.getMapperModelContext()).thenReturn(null);
        when(mapper.getMappingMetadata()).thenReturn(new DozerMappingMetadata(new ClassMappings(new BeanContainer())));
        when(this.dozerUtils.getMapper()).thenReturn(mapper);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("foo");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.createAccount(createAccountRequestDTO));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(mapper).getMapperModelContext();
        verify(mapper).getMappingMetadata();
        verify(accountDTO).getId();
        verify(accountDTO).getMobile();
        verify(accountDTO).getPassword();
        verify(accountDTO).getSalt();
        verify(accountDTO).getUsername();
        verify(accountDTO).setId((Long) any());
        verify(accountDTO).setMobile((String) any());
        verify(accountDTO).setPassword((String) any());
        verify(accountDTO).setSalt((String) any());
        verify(accountDTO).setUsername((String) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    void testCreateAccount11()
    {
        AccountDTO accountDTO = mock(AccountDTO.class);
        when(accountDTO.getId()).thenReturn(Long.MIN_VALUE);
        when(accountDTO.getMobile()).thenReturn("Mobile");
        when(accountDTO.getPassword()).thenReturn("iloveyou");
        when(accountDTO.getSalt()).thenReturn("Salt");
        when(accountDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(accountDTO).setId((Long) any());
        doNothing().when(accountDTO).setMobile((String) any());
        doNothing().when(accountDTO).setPassword((String) any());
        doNothing().when(accountDTO).setSalt((String) any());
        doNothing().when(accountDTO).setUsername((String) any());
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        Mapper mapper = mock(Mapper.class);
        when(mapper.getMapperModelContext()).thenReturn(null);
        when(mapper.getMappingMetadata()).thenReturn(new DozerMappingMetadata(new ClassMappings(new BeanContainer())));
        when(this.dozerUtils.getMapper()).thenReturn(mapper);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("foo");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.insert((mao.aggregate_pay_user_service.entity.Account) any())).thenReturn(1);
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        when(createAccountRequestDTO.getMobile()).thenReturn("Mobile");
        when(createAccountRequestDTO.getPassword()).thenReturn("iloveyou");
        when(createAccountRequestDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.createAccount(createAccountRequestDTO));
        verify(this.dozerUtils).getMapper();
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(mapper).getMapperModelContext();
        verify(mapper).getMappingMetadata();
        verify(accountDTO).getId();
        verify(accountDTO).getMobile();
        verify(accountDTO).getPassword();
        verify(accountDTO).getSalt();
        verify(accountDTO).getUsername();
        verify(accountDTO).setId((Long) any());
        verify(accountDTO).setMobile((String) any());
        verify(accountDTO).setPassword((String) any());
        verify(accountDTO).setSalt((String) any());
        verify(accountDTO).setUsername((String) any());
        verify(this.accountMapper).selectAccountByMobile((String) any());
        verify(createAccountRequestDTO, atLeast(1)).getMobile();
        verify(createAccountRequestDTO).getPassword();
        verify(createAccountRequestDTO).getUsername();
        verify(createAccountRequestDTO).setMobile((String) any());
        verify(createAccountRequestDTO).setPassword((String) any());
        verify(createAccountRequestDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#accountPassword(ChangeAccountPwdDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAccountPassword()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [password] of entity [mao.aggregate_pay_user_service.entity.Account]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper.set(LambdaUpdateWrapper.java:81)
        //       at com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper.set(LambdaUpdateWrapper.java:37)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.accountPassword(TenantServiceImpl.java:521)
        //   In order to prevent accountPassword(ChangeAccountPwdDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   accountPassword(ChangeAccountPwdDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        Account account = new Account();
        account.setId(123L);
        account.setMobile("Mobile");
        account.setPassword("iloveyou");
        account.setSalt("Salt");
        account.setUsername("janedoe");
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenReturn(account);

        ChangeAccountPwdDTO changeAccountPwdDTO = new ChangeAccountPwdDTO();
        changeAccountPwdDTO.setAccountId(1234567890L);
        changeAccountPwdDTO.setPassword("iloveyou");
        changeAccountPwdDTO.setUserName("janedoe");
        this.tenantServiceImpl.accountPassword(changeAccountPwdDTO);
    }

    /**
     * Method under test: {@link TenantServiceImpl#accountPassword(ChangeAccountPwdDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAccountPassword2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [password] of entity [mao.aggregate_pay_user_service.entity.Account]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper.set(LambdaUpdateWrapper.java:81)
        //       at com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper.set(LambdaUpdateWrapper.java:37)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.accountPassword(TenantServiceImpl.java:521)
        //   In order to prevent accountPassword(ChangeAccountPwdDTO)
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   accountPassword(ChangeAccountPwdDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        Account account = mock(Account.class);
        when(account.getSalt()).thenReturn("foo");
        doNothing().when(account).setId((Long) any());
        doNothing().when(account).setMobile((String) any());
        doNothing().when(account).setPassword((String) any());
        doNothing().when(account).setSalt((String) any());
        doNothing().when(account).setUsername((String) any());
        account.setId(123L);
        account.setMobile("Mobile");
        account.setPassword("iloveyou");
        account.setSalt("Salt");
        account.setUsername("janedoe");
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenReturn(account);

        ChangeAccountPwdDTO changeAccountPwdDTO = new ChangeAccountPwdDTO();
        changeAccountPwdDTO.setAccountId(1234567890L);
        changeAccountPwdDTO.setPassword("iloveyou");
        changeAccountPwdDTO.setUserName("janedoe");
        this.tenantServiceImpl.accountPassword(changeAccountPwdDTO);
    }

    /**
     * Method under test: {@link TenantServiceImpl#accountPassword(ChangeAccountPwdDTO)}
     */
    @Test
    void testAccountPassword3()
    {
        Account account = mock(Account.class);
        when(account.getSalt()).thenReturn("Salt");
        doNothing().when(account).setId((Long) any());
        doNothing().when(account).setMobile((String) any());
        doNothing().when(account).setPassword((String) any());
        doNothing().when(account).setSalt((String) any());
        doNothing().when(account).setUsername((String) any());
        account.setId(123L);
        account.setMobile("Mobile");
        account.setPassword("iloveyou");
        account.setSalt("Salt");
        account.setUsername("janedoe");
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenReturn(account);
        ChangeAccountPwdDTO changeAccountPwdDTO = mock(ChangeAccountPwdDTO.class);
        when(changeAccountPwdDTO.getUserName()).thenThrow(new BusinessException());
        when(changeAccountPwdDTO.getAccountId()).thenReturn(1234567890L);
        when(changeAccountPwdDTO.getPassword()).thenReturn("iloveyou");
        doNothing().when(changeAccountPwdDTO).setAccountId((Long) any());
        doNothing().when(changeAccountPwdDTO).setPassword((String) any());
        doNothing().when(changeAccountPwdDTO).setUserName((String) any());
        changeAccountPwdDTO.setAccountId(1234567890L);
        changeAccountPwdDTO.setPassword("iloveyou");
        changeAccountPwdDTO.setUserName("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.accountPassword(changeAccountPwdDTO));
        verify(account).setId((Long) any());
        verify(account).setMobile((String) any());
        verify(account).setPassword((String) any());
        verify(account).setSalt((String) any());
        verify(account).setUsername((String) any());
        verify(changeAccountPwdDTO, atLeast(1)).getAccountId();
        verify(changeAccountPwdDTO).getPassword();
        verify(changeAccountPwdDTO).getUserName();
        verify(changeAccountPwdDTO).setAccountId((Long) any());
        verify(changeAccountPwdDTO).setPassword((String) any());
        verify(changeAccountPwdDTO).setUserName((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#accountPassword(ChangeAccountPwdDTO)}
     */
    @Test
    void testAccountPassword4()
    {
        Account account = mock(Account.class);
        when(account.getSalt()).thenReturn("Salt");
        doNothing().when(account).setId((Long) any());
        doNothing().when(account).setMobile((String) any());
        doNothing().when(account).setPassword((String) any());
        doNothing().when(account).setSalt((String) any());
        doNothing().when(account).setUsername((String) any());
        account.setId(123L);
        account.setMobile("Mobile");
        account.setPassword("iloveyou");
        account.setSalt("Salt");
        account.setUsername("janedoe");
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenReturn(account);
        ChangeAccountPwdDTO changeAccountPwdDTO = mock(ChangeAccountPwdDTO.class);
        when(changeAccountPwdDTO.getUserName()).thenThrow(new BusinessException());
        when(changeAccountPwdDTO.getAccountId()).thenReturn(null);
        when(changeAccountPwdDTO.getPassword()).thenReturn("iloveyou");
        doNothing().when(changeAccountPwdDTO).setAccountId((Long) any());
        doNothing().when(changeAccountPwdDTO).setPassword((String) any());
        doNothing().when(changeAccountPwdDTO).setUserName((String) any());
        changeAccountPwdDTO.setAccountId(1234567890L);
        changeAccountPwdDTO.setPassword("iloveyou");
        changeAccountPwdDTO.setUserName("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.accountPassword(changeAccountPwdDTO));
        verify(account).setId((Long) any());
        verify(account).setMobile((String) any());
        verify(account).setPassword((String) any());
        verify(account).setSalt((String) any());
        verify(account).setUsername((String) any());
        verify(changeAccountPwdDTO).getAccountId();
        verify(changeAccountPwdDTO).setAccountId((Long) any());
        verify(changeAccountPwdDTO).setPassword((String) any());
        verify(changeAccountPwdDTO).setUserName((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#accountPassword(ChangeAccountPwdDTO)}
     */
    @Test
    void testAccountPassword5()
    {
        Account account = mock(Account.class);
        when(account.getSalt()).thenReturn("Salt");
        doNothing().when(account).setId((Long) any());
        doNothing().when(account).setMobile((String) any());
        doNothing().when(account).setPassword((String) any());
        doNothing().when(account).setSalt((String) any());
        doNothing().when(account).setUsername((String) any());
        account.setId(123L);
        account.setMobile("Mobile");
        account.setPassword("iloveyou");
        account.setSalt("Salt");
        account.setUsername("janedoe");
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenReturn(account);
        ChangeAccountPwdDTO changeAccountPwdDTO = mock(ChangeAccountPwdDTO.class);
        when(changeAccountPwdDTO.getUserName()).thenThrow(new BusinessException());
        when(changeAccountPwdDTO.getAccountId()).thenReturn(1234567890L);
        when(changeAccountPwdDTO.getPassword()).thenReturn(null);
        doNothing().when(changeAccountPwdDTO).setAccountId((Long) any());
        doNothing().when(changeAccountPwdDTO).setPassword((String) any());
        doNothing().when(changeAccountPwdDTO).setUserName((String) any());
        changeAccountPwdDTO.setAccountId(1234567890L);
        changeAccountPwdDTO.setPassword("iloveyou");
        changeAccountPwdDTO.setUserName("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.accountPassword(changeAccountPwdDTO));
        verify(account).setId((Long) any());
        verify(account).setMobile((String) any());
        verify(account).setPassword((String) any());
        verify(account).setSalt((String) any());
        verify(account).setUsername((String) any());
        verify(changeAccountPwdDTO).getAccountId();
        verify(changeAccountPwdDTO).getPassword();
        verify(changeAccountPwdDTO).setAccountId((Long) any());
        verify(changeAccountPwdDTO).setPassword((String) any());
        verify(changeAccountPwdDTO).setUserName((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#accountPassword(ChangeAccountPwdDTO)}
     */
    @Test
    void testAccountPassword6()
    {
        Account account = mock(Account.class);
        when(account.getSalt()).thenReturn("Salt");
        doNothing().when(account).setId((Long) any());
        doNothing().when(account).setMobile((String) any());
        doNothing().when(account).setPassword((String) any());
        doNothing().when(account).setSalt((String) any());
        doNothing().when(account).setUsername((String) any());
        account.setId(123L);
        account.setMobile("Mobile");
        account.setPassword("iloveyou");
        account.setSalt("Salt");
        account.setUsername("janedoe");
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenReturn(account);
        ChangeAccountPwdDTO changeAccountPwdDTO = mock(ChangeAccountPwdDTO.class);
        when(changeAccountPwdDTO.getUserName()).thenThrow(new BusinessException());
        when(changeAccountPwdDTO.getAccountId()).thenReturn(1234567890L);
        when(changeAccountPwdDTO.getPassword()).thenReturn("");
        doNothing().when(changeAccountPwdDTO).setAccountId((Long) any());
        doNothing().when(changeAccountPwdDTO).setPassword((String) any());
        doNothing().when(changeAccountPwdDTO).setUserName((String) any());
        changeAccountPwdDTO.setAccountId(1234567890L);
        changeAccountPwdDTO.setPassword("iloveyou");
        changeAccountPwdDTO.setUserName("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.accountPassword(changeAccountPwdDTO));
        verify(account).setId((Long) any());
        verify(account).setMobile((String) any());
        verify(account).setPassword((String) any());
        verify(account).setSalt((String) any());
        verify(account).setUsername((String) any());
        verify(changeAccountPwdDTO).getAccountId();
        verify(changeAccountPwdDTO).getPassword();
        verify(changeAccountPwdDTO).setAccountId((Long) any());
        verify(changeAccountPwdDTO).setPassword((String) any());
        verify(changeAccountPwdDTO).setUserName((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#bindTenantAccount(Long, Long, Boolean)}
     */
    @Test
    void testBindTenantAccount()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        this.tenantServiceImpl.bindTenantAccount(123L, 1234567890L, true);
        verify(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#bindTenantAccount(Long, Long, Boolean)}
     */
    @Test
    void testBindTenantAccount2()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        this.tenantServiceImpl.bindTenantAccount(123L, 1234567890L, false);
        verify(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#bindTenantAccount(Long, Long, Boolean)}
     */
    @Test
    void testBindTenantAccount3()
    {
        doNothing().when(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        this.tenantServiceImpl.bindTenantAccount(123L, 1234567890L, null);
        verify(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#bindTenantAccount(Long, Long, Boolean)}
     */
    @Test
    void testBindTenantAccount4()
    {
        doThrow(new BusinessException()).when(this.tenantMapper)
                .insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.bindTenantAccount(123L, 1234567890L, true));
        verify(this.tenantMapper).insertTenantAccount((Long) any(), (Long) any(), (Boolean) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#unbindTenant(Long, String)}
     */
    @Test
    void testUnbindTenant()
    {
        when(this.accountMapper.selectNotAdmin((Long) any(), (String) any())).thenReturn(new ArrayList<>());
        this.tenantServiceImpl.unbindTenant(123L, "janedoe");
        verify(this.accountMapper).selectNotAdmin((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#unbindTenant(Long, String)}
     */
    @Test
    void testUnbindTenant2()
    {
        when(this.tenantAccountMapper.selectTenantByUsernameInAccount((String) any())).thenReturn(3);
        doNothing().when(this.tenantAccountMapper).deleteAccountInTenant((Long) any(), (Long) any());
        doNothing().when(this.accountRoleMapper).deleteByUsernameInTenant((Long) any(), (String) any());

        TenantAccount tenantAccount = new TenantAccount();
        tenantAccount.setAccountId(1234567890L);
        tenantAccount.setId(123L);
        tenantAccount.setIsAdmin(true);
        tenantAccount.setTenantId(123L);

        ArrayList<TenantAccount> tenantAccountList = new ArrayList<>();
        tenantAccountList.add(tenantAccount);
        when(this.accountMapper.selectNotAdmin((Long) any(), (String) any())).thenReturn(tenantAccountList);
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.unbindTenant(123L, "janedoe"));
        verify(this.tenantAccountMapper).selectTenantByUsernameInAccount((String) any());
        verify(this.tenantAccountMapper).deleteAccountInTenant((Long) any(), (Long) any());
        verify(this.accountRoleMapper).deleteByUsernameInTenant((Long) any(), (String) any());
        verify(this.accountMapper).selectNotAdmin((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#unbindTenant(Long, String)}
     */
    @Test
    void testUnbindTenant3()
    {
        when(this.tenantAccountMapper.selectTenantByUsernameInAccount((String) any())).thenReturn(3);
        doNothing().when(this.tenantAccountMapper).deleteAccountInTenant((Long) any(), (Long) any());
        doThrow(new BusinessException()).when(this.accountRoleMapper)
                .deleteByUsernameInTenant((Long) any(), (String) any());

        TenantAccount tenantAccount = new TenantAccount();
        tenantAccount.setAccountId(1234567890L);
        tenantAccount.setId(123L);
        tenantAccount.setIsAdmin(true);
        tenantAccount.setTenantId(123L);

        ArrayList<TenantAccount> tenantAccountList = new ArrayList<>();
        tenantAccountList.add(tenantAccount);
        when(this.accountMapper.selectNotAdmin((Long) any(), (String) any())).thenReturn(tenantAccountList);
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.unbindTenant(123L, "janedoe"));
        verify(this.tenantAccountMapper).deleteAccountInTenant((Long) any(), (Long) any());
        verify(this.accountRoleMapper).deleteByUsernameInTenant((Long) any(), (String) any());
        verify(this.accountMapper).selectNotAdmin((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#unbindTenant(Long, String)}
     */
    @Test
    void testUnbindTenant4()
    {
        when(this.tenantAccountMapper.selectTenantByUsernameInAccount((String) any())).thenReturn(0);
        doNothing().when(this.tenantAccountMapper).deleteAccountInTenant((Long) any(), (Long) any());
        doNothing().when(this.accountRoleMapper).deleteByUsernameInTenant((Long) any(), (String) any());

        TenantAccount tenantAccount = new TenantAccount();
        tenantAccount.setAccountId(1234567890L);
        tenantAccount.setId(123L);
        tenantAccount.setIsAdmin(true);
        tenantAccount.setTenantId(123L);

        ArrayList<TenantAccount> tenantAccountList = new ArrayList<>();
        tenantAccountList.add(tenantAccount);
        when(this.accountMapper.delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.Account>) any()))
                .thenReturn(1);
        when(this.accountMapper.selectNotAdmin((Long) any(), (String) any())).thenReturn(tenantAccountList);
        this.tenantServiceImpl.unbindTenant(123L, "janedoe");
        verify(this.tenantAccountMapper).selectTenantByUsernameInAccount((String) any());
        verify(this.tenantAccountMapper).deleteAccountInTenant((Long) any(), (Long) any());
        verify(this.accountRoleMapper).deleteByUsernameInTenant((Long) any(), (String) any());
        verify(this.accountMapper).delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.Account>) any());
        verify(this.accountMapper).selectNotAdmin((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#unbindTenant(Long, String)}
     */
    @Test
    void testUnbindTenant5()
    {
        when(this.tenantAccountMapper.selectTenantByUsernameInAccount((String) any())).thenReturn(0);
        doNothing().when(this.tenantAccountMapper).deleteAccountInTenant((Long) any(), (Long) any());
        doNothing().when(this.accountRoleMapper).deleteByUsernameInTenant((Long) any(), (String) any());

        TenantAccount tenantAccount = new TenantAccount();
        tenantAccount.setAccountId(1234567890L);
        tenantAccount.setId(123L);
        tenantAccount.setIsAdmin(true);
        tenantAccount.setTenantId(123L);

        ArrayList<TenantAccount> tenantAccountList = new ArrayList<>();
        tenantAccountList.add(tenantAccount);
        when(this.accountMapper.delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.Account>) any()))
                .thenThrow(new BusinessException());
        when(this.accountMapper.selectNotAdmin((Long) any(), (String) any())).thenReturn(tenantAccountList);
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.unbindTenant(123L, "janedoe"));
        verify(this.tenantAccountMapper).selectTenantByUsernameInAccount((String) any());
        verify(this.tenantAccountMapper).deleteAccountInTenant((Long) any(), (Long) any());
        verify(this.accountRoleMapper).deleteByUsernameInTenant((Long) any(), (String) any());
        verify(this.accountMapper).delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.Account>) any());
        verify(this.accountMapper).selectNotAdmin((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#isExistAccountByUsername(String)}
     */
    @Test
    void testIsExistAccountByUsername()
    {
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(3);
        assertTrue(this.tenantServiceImpl.isExistAccountByUsername("janedoe"));
        verify(this.accountMapper).selectAccountByName((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#isExistAccountByUsername(String)}
     */
    @Test
    void testIsExistAccountByUsername2()
    {
        when(this.accountMapper.selectAccountByName((String) any())).thenReturn(0);
        assertFalse(this.tenantServiceImpl.isExistAccountByUsername("janedoe"));
        verify(this.accountMapper).selectAccountByName((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#isExistAccountByUsername(String)}
     */
    @Test
    void testIsExistAccountByUsername3()
    {
        when(this.accountMapper.selectAccountByName((String) any())).thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.isExistAccountByUsername("janedoe"));
        verify(this.accountMapper).selectAccountByName((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#isExistAccountByMobile(String)}
     */
    @Test
    void testIsExistAccountByMobile()
    {
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(3);
        assertTrue(this.tenantServiceImpl.isExistAccountByMobile("Mobile"));
        verify(this.accountMapper).selectAccountByMobile((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#isExistAccountByMobile(String)}
     */
    @Test
    void testIsExistAccountByMobile2()
    {
        when(this.accountMapper.selectAccountByMobile((String) any())).thenReturn(0);
        assertFalse(this.tenantServiceImpl.isExistAccountByMobile("Mobile"));
        verify(this.accountMapper).selectAccountByMobile((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#isExistAccountByMobile(String)}
     */
    @Test
    void testIsExistAccountByMobile3()
    {
        when(this.accountMapper.selectAccountByMobile((String) any())).thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.isExistAccountByMobile("Mobile"));
        verify(this.accountMapper).selectAccountByMobile((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#getAccountByUsername(String)}
     */
    @Test
    void testGetAccountByUsername()
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);

        Account account = new Account();
        account.setId(123L);
        account.setMobile("Mobile");
        account.setPassword("iloveyou");
        account.setSalt("Salt");
        account.setUsername("janedoe");
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenReturn(account);
        assertSame(accountDTO, this.tenantServiceImpl.getAccountByUsername("janedoe"));
        verify(this.dozerUtils).map((Object) any(), (Class<AccountDTO>) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#getAccountByUsername(String)}
     */
    @Test
    void testGetAccountByUsername2()
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.getAccountByUsername("janedoe"));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#getAccountByMobile(String)}
     */
    @Test
    void testGetAccountByMobile()
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);

        Account account = new Account();
        account.setId(123L);
        account.setMobile("Mobile");
        account.setPassword("iloveyou");
        account.setSalt("Salt");
        account.setUsername("janedoe");
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenReturn(account);
        assertSame(accountDTO, this.tenantServiceImpl.getAccountByMobile("Mobile"));
        verify(this.dozerUtils).map((Object) any(), (Class<AccountDTO>) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#getAccountByMobile(String)}
     */
    @Test
    void testGetAccountByMobile2()
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.getAccountByMobile("Mobile"));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#isExistAccountInTenantByUsername(Long, String)}
     */
    @Test
    void testIsExistAccountInTenantByUsername()
    {
        when(this.accountMapper.selectAccountInTenantByName((Long) any(), (String) any())).thenReturn(3);
        assertTrue(this.tenantServiceImpl.isExistAccountInTenantByUsername(123L, "janedoe"));
        verify(this.accountMapper).selectAccountInTenantByName((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#isExistAccountInTenantByUsername(Long, String)}
     */
    @Test
    void testIsExistAccountInTenantByUsername2()
    {
        when(this.accountMapper.selectAccountInTenantByName((Long) any(), (String) any())).thenReturn(0);
        assertFalse(this.tenantServiceImpl.isExistAccountInTenantByUsername(123L, "janedoe"));
        verify(this.accountMapper).selectAccountInTenantByName((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#isExistAccountInTenantByUsername(Long, String)}
     */
    @Test
    void testIsExistAccountInTenantByUsername3()
    {
        when(this.accountMapper.selectAccountInTenantByName((Long) any(), (String) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.isExistAccountInTenantByUsername(123L, "janedoe"));
        verify(this.accountMapper).selectAccountInTenantByName((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#isExistAccountInTenantByMobile(Long, String)}
     */
    @Test
    void testIsExistAccountInTenantByMobile()
    {
        when(this.accountMapper.selectAccountInTenantByMobile((Long) any(), (String) any())).thenReturn(3);
        assertTrue(this.tenantServiceImpl.isExistAccountInTenantByMobile(123L, "Mobile"));
        verify(this.accountMapper).selectAccountInTenantByMobile((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#isExistAccountInTenantByMobile(Long, String)}
     */
    @Test
    void testIsExistAccountInTenantByMobile2()
    {
        when(this.accountMapper.selectAccountInTenantByMobile((Long) any(), (String) any())).thenReturn(0);
        assertFalse(this.tenantServiceImpl.isExistAccountInTenantByMobile(123L, "Mobile"));
        verify(this.accountMapper).selectAccountInTenantByMobile((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#isExistAccountInTenantByMobile(Long, String)}
     */
    @Test
    void testIsExistAccountInTenantByMobile3()
    {
        when(this.accountMapper.selectAccountInTenantByMobile((Long) any(), (String) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.isExistAccountInTenantByMobile(123L, "Mobile"));
        verify(this.accountMapper).selectAccountInTenantByMobile((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAccount(AccountQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    void testQueryAccount()
    {
        when(this.accountMapper.selectAccountByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountDTO>) any(), (AccountQueryDTO) any(),
                (String) any(), (String) any())).thenReturn(new ArrayList<>());

        AccountQueryDTO accountQueryDTO = new AccountQueryDTO();
        accountQueryDTO.setMobile("Mobile");
        accountQueryDTO.setTenantId(123L);
        accountQueryDTO.setUsername("janedoe");
        PageVO<AccountDTO> actualQueryAccountResult = this.tenantServiceImpl.queryAccount(accountQueryDTO, 3, 3, "Sort By",
                "Order");
        assertEquals(0L, actualQueryAccountResult.getCounts());
        assertFalse(actualQueryAccountResult.isFirst());
        assertFalse(actualQueryAccountResult.hasItems());
        assertEquals(3, actualQueryAccountResult.getPageSize());
        verify(this.accountMapper).selectAccountByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountDTO>) any(), (AccountQueryDTO) any(),
                (String) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAccount(AccountQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    void testQueryAccount2()
    {
        when(this.accountMapper.selectAccountByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountDTO>) any(), (AccountQueryDTO) any(),
                (String) any(), (String) any())).thenReturn(new ArrayList<>());

        AccountQueryDTO accountQueryDTO = new AccountQueryDTO();
        accountQueryDTO.setMobile("Mobile");
        accountQueryDTO.setTenantId(123L);
        accountQueryDTO.setUsername("janedoe");
        PageVO<AccountDTO> actualQueryAccountResult = this.tenantServiceImpl.queryAccount(accountQueryDTO, 1, 3, "Sort By",
                "Order");
        assertEquals(0L, actualQueryAccountResult.getCounts());
        assertFalse(actualQueryAccountResult.isFirst());
        assertFalse(actualQueryAccountResult.hasItems());
        assertEquals(3, actualQueryAccountResult.getPageSize());
        verify(this.accountMapper).selectAccountByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountDTO>) any(), (AccountQueryDTO) any(),
                (String) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAccount(AccountQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAccount3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.queryAccount(TenantServiceImpl.java:677)
        //   In order to prevent queryAccount(AccountQueryDTO, Integer, Integer, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryAccount(AccountQueryDTO, Integer, Integer, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.accountMapper.selectAccountByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountDTO>) any(), (AccountQueryDTO) any(),
                (String) any(), (String) any())).thenReturn(new ArrayList<>());

        AccountQueryDTO accountQueryDTO = new AccountQueryDTO();
        accountQueryDTO.setMobile("Mobile");
        accountQueryDTO.setTenantId(123L);
        accountQueryDTO.setUsername("janedoe");
        this.tenantServiceImpl.queryAccount(accountQueryDTO, null, 3, "Sort By", "Order");
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAccount(AccountQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    void testQueryAccount4()
    {
        when(this.accountMapper.selectAccountByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountDTO>) any(), (AccountQueryDTO) any(),
                (String) any(), (String) any())).thenReturn(new ArrayList<>());

        AccountQueryDTO accountQueryDTO = new AccountQueryDTO();
        accountQueryDTO.setMobile("Mobile");
        accountQueryDTO.setTenantId(123L);
        accountQueryDTO.setUsername("janedoe");
        PageVO<AccountDTO> actualQueryAccountResult = this.tenantServiceImpl.queryAccount(accountQueryDTO, 3, 0, "Sort By",
                "Order");
        assertEquals(0L, actualQueryAccountResult.getCounts());
        assertFalse(actualQueryAccountResult.isFirst());
        assertFalse(actualQueryAccountResult.hasItems());
        assertEquals(1, actualQueryAccountResult.getPages());
        verify(this.accountMapper).selectAccountByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountDTO>) any(), (AccountQueryDTO) any(),
                (String) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAccount(AccountQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAccount5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.queryAccount(TenantServiceImpl.java:679)
        //   In order to prevent queryAccount(AccountQueryDTO, Integer, Integer, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryAccount(AccountQueryDTO, Integer, Integer, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.accountMapper.selectAccountByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountDTO>) any(), (AccountQueryDTO) any(),
                (String) any(), (String) any())).thenReturn(new ArrayList<>());

        AccountQueryDTO accountQueryDTO = new AccountQueryDTO();
        accountQueryDTO.setMobile("Mobile");
        accountQueryDTO.setTenantId(123L);
        accountQueryDTO.setUsername("janedoe");
        this.tenantServiceImpl.queryAccount(accountQueryDTO, 3, null, "Sort By", "Order");
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAccount(AccountQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    void testQueryAccount6()
    {
        when(this.accountMapper.selectAccountByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountDTO>) any(), (AccountQueryDTO) any(),
                (String) any(), (String) any())).thenThrow(new BusinessException());

        AccountQueryDTO accountQueryDTO = new AccountQueryDTO();
        accountQueryDTO.setMobile("Mobile");
        accountQueryDTO.setTenantId(123L);
        accountQueryDTO.setUsername("janedoe");
        assertThrows(BusinessException.class,
                () -> this.tenantServiceImpl.queryAccount(accountQueryDTO, 3, 3, "Sort By", "Order"));
        verify(this.accountMapper).selectAccountByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountDTO>) any(), (AccountQueryDTO) any(),
                (String) any(), (String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAccountInTenant(String)}
     */
    @Test
    void testQueryAccountInTenant()
    {
        ArrayList<TenantDTO> tenantDTOList = new ArrayList<>();
        when(this.tenantMapper.selectAccountInTenant((Long) any())).thenReturn(tenantDTOList);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);

        Account account = new Account();
        account.setId(123L);
        account.setMobile("Mobile");
        account.setPassword("iloveyou");
        account.setSalt("Salt");
        account.setUsername("janedoe");
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenReturn(account);
        List<TenantDTO> actualQueryAccountInTenantResult = this.tenantServiceImpl.queryAccountInTenant("janedoe");
        assertSame(tenantDTOList, actualQueryAccountInTenantResult);
        assertTrue(actualQueryAccountInTenantResult.isEmpty());
        verify(this.tenantMapper).selectAccountInTenant((Long) any());
        verify(this.dozerUtils).map((Object) any(), (Class<AccountDTO>) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAccountInTenant(String)}
     */
    @Test
    void testQueryAccountInTenant2()
    {
        when(this.tenantMapper.selectAccountInTenant((Long) any())).thenReturn(new ArrayList<>());

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.queryAccountInTenant("janedoe"));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#sendMessage(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSendMessage()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.sendMessage(TenantServiceImpl.java:711)
        //   In order to prevent sendMessage(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   sendMessage(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.verificationFeignClient.generateVerificationInfo((String) any(), (java.util.Map<String, Object>) any(),
                anyInt())).thenReturn(new RestResponse<>(1, "Msg"));
        this.tenantServiceImpl.sendMessage("4105551212");
    }

    /**
     * Method under test: {@link TenantServiceImpl#sendMessage(String)}
     */
    @Test
    void testSendMessage2()
    {
        RestResponse<VerificationInfo> restResponse = new RestResponse<>(1, "Msg");
        restResponse.setResult(new VerificationInfo("调用短信服务发送验证码: 手机号:{}", "Not all who wander are lost"));
        when(this.verificationFeignClient.generateVerificationInfo((String) any(), (java.util.Map<String, Object>) any(),
                anyInt())).thenReturn(restResponse);
        assertEquals("调用短信服务发送验证码: 手机号:{}", this.tenantServiceImpl.sendMessage("4105551212"));
        verify(this.verificationFeignClient).generateVerificationInfo((String) any(), (java.util.Map<String, Object>) any(),
                anyInt());
    }

    /**
     * Method under test: {@link TenantServiceImpl#sendMessage(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSendMessage3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.sendMessage(TenantServiceImpl.java:711)
        //   In order to prevent sendMessage(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   sendMessage(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.verificationFeignClient.generateVerificationInfo((String) any(), (java.util.Map<String, Object>) any(),
                anyInt())).thenReturn(null);
        this.tenantServiceImpl.sendMessage("4105551212");
    }

    /**
     * Method under test: {@link TenantServiceImpl#sendMessage(String)}
     */
    @Test
    void testSendMessage4()
    {
        when(this.verificationFeignClient.generateVerificationInfo((String) any(), (java.util.Map<String, Object>) any(),
                anyInt())).thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.sendMessage("4105551212"));
        verify(this.verificationFeignClient).generateVerificationInfo((String) any(), (java.util.Map<String, Object>) any(),
                anyInt());
    }

    /**
     * Method under test: {@link TenantServiceImpl#authentication(AuthenticationInfo)}
     */
    @Test
    void testAuthentication()
    {
        AuthenticationInfo authenticationInfo = new AuthenticationInfo();
        authenticationInfo.setAuthenticationType("Authentication Type");
        authenticationInfo.setCertificate("Certificate");
        authenticationInfo.setPrincipal("Principal");
        authenticationInfo.setSmsKey("Sms Key");
        assertNull(this.tenantServiceImpl.authentication(authenticationInfo));
    }

    /**
     * Method under test: {@link TenantServiceImpl#authentication(AuthenticationInfo)}
     */
    @Test
    void testAuthentication2()
    {
        AuthenticationInfo authenticationInfo = mock(AuthenticationInfo.class);
        when(authenticationInfo.getAuthenticationType()).thenReturn("Authentication Type");
        when(authenticationInfo.getCertificate()).thenReturn("Certificate");
        when(authenticationInfo.getPrincipal()).thenReturn("Principal");
        doNothing().when(authenticationInfo).setAuthenticationType((String) any());
        doNothing().when(authenticationInfo).setCertificate((String) any());
        doNothing().when(authenticationInfo).setPrincipal((String) any());
        doNothing().when(authenticationInfo).setSmsKey((String) any());
        authenticationInfo.setAuthenticationType("Authentication Type");
        authenticationInfo.setCertificate("Certificate");
        authenticationInfo.setPrincipal("Principal");
        authenticationInfo.setSmsKey("Sms Key");
        assertNull(this.tenantServiceImpl.authentication(authenticationInfo));
        verify(authenticationInfo).getAuthenticationType();
        verify(authenticationInfo).getCertificate();
        verify(authenticationInfo).getPrincipal();
        verify(authenticationInfo).setAuthenticationType((String) any());
        verify(authenticationInfo).setCertificate((String) any());
        verify(authenticationInfo).setPrincipal((String) any());
        verify(authenticationInfo).setSmsKey((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#authentication(AuthenticationInfo)}
     */
    @Test
    void testAuthentication3()
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);

        Account account = new Account();
        account.setId(123L);
        account.setMobile("Mobile");
        account.setPassword("iloveyou");
        account.setSalt("Salt");
        account.setUsername("janedoe");
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenReturn(account);
        AuthenticationInfo authenticationInfo = mock(AuthenticationInfo.class);
        when(authenticationInfo.getAuthenticationType()).thenReturn("password");
        when(authenticationInfo.getCertificate()).thenReturn("Certificate");
        when(authenticationInfo.getPrincipal()).thenReturn("Principal");
        doNothing().when(authenticationInfo).setAuthenticationType((String) any());
        doNothing().when(authenticationInfo).setCertificate((String) any());
        doNothing().when(authenticationInfo).setPrincipal((String) any());
        doNothing().when(authenticationInfo).setSmsKey((String) any());
        authenticationInfo.setAuthenticationType("Authentication Type");
        authenticationInfo.setCertificate("Certificate");
        authenticationInfo.setPrincipal("Principal");
        authenticationInfo.setSmsKey("Sms Key");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.authentication(authenticationInfo));
        verify(this.dozerUtils).map((Object) any(), (Class<AccountDTO>) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
        verify(authenticationInfo).getAuthenticationType();
        verify(authenticationInfo).getCertificate();
        verify(authenticationInfo).getPrincipal();
        verify(authenticationInfo).setAuthenticationType((String) any());
        verify(authenticationInfo).setCertificate((String) any());
        verify(authenticationInfo).setPrincipal((String) any());
        verify(authenticationInfo).setSmsKey((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#authentication(AuthenticationInfo)}
     */
    @Test
    void testAuthentication4()
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenThrow(new BusinessException());
        AuthenticationInfo authenticationInfo = mock(AuthenticationInfo.class);
        when(authenticationInfo.getAuthenticationType()).thenReturn("password");
        when(authenticationInfo.getCertificate()).thenReturn("Certificate");
        when(authenticationInfo.getPrincipal()).thenReturn("Principal");
        doNothing().when(authenticationInfo).setAuthenticationType((String) any());
        doNothing().when(authenticationInfo).setCertificate((String) any());
        doNothing().when(authenticationInfo).setPrincipal((String) any());
        doNothing().when(authenticationInfo).setSmsKey((String) any());
        authenticationInfo.setAuthenticationType("Authentication Type");
        authenticationInfo.setCertificate("Certificate");
        authenticationInfo.setPrincipal("Principal");
        authenticationInfo.setSmsKey("Sms Key");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.authentication(authenticationInfo));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
        verify(authenticationInfo).getAuthenticationType();
        verify(authenticationInfo).getCertificate();
        verify(authenticationInfo).getPrincipal();
        verify(authenticationInfo).setAuthenticationType((String) any());
        verify(authenticationInfo).setCertificate((String) any());
        verify(authenticationInfo).setPrincipal((String) any());
        verify(authenticationInfo).setSmsKey((String) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#login(LoginRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogin()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.service.impl.TenantServiceImpl.login(TenantServiceImpl.java:815)
        //   In order to prevent login(LoginRequestDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   login(LoginRequestDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setAuthenticationType("Authentication Type");
        loginRequestDTO.setCertificate("Certificate");
        loginRequestDTO.setPrincipal("Principal");
        loginRequestDTO.setSmsKey("Sms Key");
        this.tenantServiceImpl.login(loginRequestDTO);
    }

    /**
     * Method under test: {@link TenantServiceImpl#login(LoginRequestDTO)}
     */
    @Test
    void testLogin2()
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);

        Account account = new Account();
        account.setId(123L);
        account.setMobile("Mobile");
        account.setPassword("iloveyou");
        account.setSalt("Salt");
        account.setUsername("janedoe");
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenReturn(account);

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setAuthenticationType("password");
        loginRequestDTO.setCertificate("Certificate");
        loginRequestDTO.setPrincipal("Principal");
        loginRequestDTO.setSmsKey("Sms Key");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.login(loginRequestDTO));
        verify(this.dozerUtils).map((Object) any(), (Class<AccountDTO>) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#login(LoginRequestDTO)}
     */
    @Test
    void testLogin3()
    {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(123L);
        accountDTO.setMobile("Mobile");
        accountDTO.setPassword("iloveyou");
        accountDTO.setSalt("Salt");
        accountDTO.setUsername("janedoe");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AccountDTO>) any())).thenReturn(accountDTO);
        when(this.accountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any()))
                .thenThrow(new BusinessException());

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setAuthenticationType("password");
        loginRequestDTO.setCertificate("Certificate");
        loginRequestDTO.setPrincipal("Principal");
        loginRequestDTO.setSmsKey("Sms Key");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.login(loginRequestDTO));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.accountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<Account>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#getApplicationDTOByClientId(String)}
     */
    @Test
    void testGetApplicationDTOByClientId()
    {
        ResourceApplication resourceApplication = new ResourceApplication();
        resourceApplication.setCode("Code");
        resourceApplication.setId(123L);
        resourceApplication.setName("Name");
        resourceApplication.setTenantId(123L);
        when(this.resourceApplicationMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any()))
                .thenReturn(resourceApplication);

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setCode("Code");
        applicationDTO.setId(123L);
        applicationDTO.setName("Name");
        applicationDTO.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<ApplicationDTO>) any())).thenReturn(applicationDTO);
        assertSame(applicationDTO, this.tenantServiceImpl.getApplicationDTOByClientId("42"));
        verify(this.resourceApplicationMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any());
        verify(this.dozerUtils).map((Object) any(), (Class<ApplicationDTO>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#getApplicationDTOByClientId(String)}
     */
    @Test
    void testGetApplicationDTOByClientId2()
    {
        ResourceApplication resourceApplication = new ResourceApplication();
        resourceApplication.setCode("Code");
        resourceApplication.setId(123L);
        resourceApplication.setName("Name");
        resourceApplication.setTenantId(123L);
        when(this.resourceApplicationMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any()))
                .thenReturn(resourceApplication);
        when(this.dozerUtils.map((Object) any(), (Class<ApplicationDTO>) any())).thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.getApplicationDTOByClientId("42"));
        verify(this.resourceApplicationMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any());
        verify(this.dozerUtils).map((Object) any(), (Class<ApplicationDTO>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#getTenantByAccount(Long, Boolean)}
     */
    @Test
    void testGetTenantByAccount()
    {
        Tenant tenant = new Tenant();
        tenant.setBundleCode("Bundle Code");
        tenant.setId(123L);
        tenant.setName("Name");
        tenant.setTenantTypeCode("Tenant Type Code");
        when(this.tenantMapper.selectById((java.io.Serializable) any())).thenReturn(tenant);

        TenantAccount tenantAccount = new TenantAccount();
        tenantAccount.setAccountId(1234567890L);
        tenantAccount.setId(123L);
        tenantAccount.setIsAdmin(true);
        tenantAccount.setTenantId(123L);
        when(this.tenantAccountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TenantAccount>) any()))
                .thenReturn(tenantAccount);

        TenantDTO tenantDTO = new TenantDTO();
        tenantDTO.setBundleCode("Bundle Code");
        tenantDTO.setId(123L);
        tenantDTO.setName("Name");
        tenantDTO.setTenantTypeCode("Tenant Type Code");
        when(this.dozerUtils.map((Object) any(), (Class<TenantDTO>) any())).thenReturn(tenantDTO);
        assertSame(tenantDTO, this.tenantServiceImpl.getTenantByAccount(1234567890L, true));
        verify(this.tenantMapper).selectById((java.io.Serializable) any());
        verify(this.tenantAccountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TenantAccount>) any());
        verify(this.dozerUtils).map((Object) any(), (Class<TenantDTO>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#getTenantByAccount(Long, Boolean)}
     */
    @Test
    void testGetTenantByAccount2()
    {
        Tenant tenant = new Tenant();
        tenant.setBundleCode("Bundle Code");
        tenant.setId(123L);
        tenant.setName("Name");
        tenant.setTenantTypeCode("Tenant Type Code");
        when(this.tenantMapper.selectById((java.io.Serializable) any())).thenReturn(tenant);

        TenantAccount tenantAccount = new TenantAccount();
        tenantAccount.setAccountId(1234567890L);
        tenantAccount.setId(123L);
        tenantAccount.setIsAdmin(true);
        tenantAccount.setTenantId(123L);
        when(this.tenantAccountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TenantAccount>) any()))
                .thenReturn(tenantAccount);
        when(this.dozerUtils.map((Object) any(), (Class<TenantDTO>) any())).thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.getTenantByAccount(1234567890L, true));
        verify(this.tenantMapper).selectById((java.io.Serializable) any());
        verify(this.tenantAccountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TenantAccount>) any());
        verify(this.dozerUtils).map((Object) any(), (Class<TenantDTO>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#getTenantByAccount(Long, Boolean)}
     */
    @Test
    void testGetTenantByAccount3()
    {
        Tenant tenant = new Tenant();
        tenant.setBundleCode("Bundle Code");
        tenant.setId(123L);
        tenant.setName("Name");
        tenant.setTenantTypeCode("Tenant Type Code");
        when(this.tenantMapper.selectById((java.io.Serializable) any())).thenReturn(tenant);

        TenantAccount tenantAccount = new TenantAccount();
        tenantAccount.setAccountId(1234567890L);
        tenantAccount.setId(123L);
        tenantAccount.setIsAdmin(true);
        tenantAccount.setTenantId(null);
        when(this.tenantAccountMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TenantAccount>) any()))
                .thenReturn(tenantAccount);

        TenantDTO tenantDTO = new TenantDTO();
        tenantDTO.setBundleCode("Bundle Code");
        tenantDTO.setId(123L);
        tenantDTO.setName("Name");
        tenantDTO.setTenantTypeCode("Tenant Type Code");
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<TenantDTO>) any())).thenReturn(tenantDTO);
        assertNull(this.tenantServiceImpl.getTenantByAccount(1234567890L, true));
        verify(this.tenantAccountMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TenantAccount>) any());
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAccountRole(String, String, Long)}
     */
    @Test
    void testQueryAccountRole()
    {
        AccountRoleQueryDTO accountRoleQueryDTO = new AccountRoleQueryDTO();
        accountRoleQueryDTO.setId(123L);
        accountRoleQueryDTO.setRoleName("Role Name");
        accountRoleQueryDTO.setTenantId(123L);
        accountRoleQueryDTO.setUsername("janedoe");
        when(this.tenantAccountMapper.selectAccountRole((String) any(), (String) any(), (Long) any()))
                .thenReturn(accountRoleQueryDTO);
        assertSame(accountRoleQueryDTO, this.tenantServiceImpl.queryAccountRole("janedoe", "Role Code", 123L));
        verify(this.tenantAccountMapper).selectAccountRole((String) any(), (String) any(), (Long) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAccountRole(String, String, Long)}
     */
    @Test
    void testQueryAccountRole2()
    {
        when(this.tenantAccountMapper.selectAccountRole((String) any(), (String) any(), (Long) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.queryAccountRole("janedoe", "Role Code", 123L));
        verify(this.tenantAccountMapper).selectAccountRole((String) any(), (String) any(), (Long) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAdministratorByPage(AccountRoleDTO, Integer, Integer)}
     */
    @Test
    void testQueryAdministratorByPage()
    {
        when(this.tenantMapper.queryAdministratorByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountRoleQueryDTO>) any(),
                (AccountRoleDTO) any())).thenReturn(new ArrayList<>());

        AccountRoleDTO accountRoleDTO = new AccountRoleDTO();
        accountRoleDTO.setRoleCode("Role Code");
        accountRoleDTO.setTenantId(123L);
        accountRoleDTO.setUsername("janedoe");
        PageVO<AccountRoleQueryDTO> actualQueryAdministratorByPageResult = this.tenantServiceImpl
                .queryAdministratorByPage(accountRoleDTO, 1, 3);
        assertEquals(0L, actualQueryAdministratorByPageResult.getCounts());
        assertFalse(actualQueryAdministratorByPageResult.isFirst());
        assertFalse(actualQueryAdministratorByPageResult.hasItems());
        assertEquals(3, actualQueryAdministratorByPageResult.getPageSize());
        verify(this.tenantMapper).queryAdministratorByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountRoleQueryDTO>) any(),
                (AccountRoleDTO) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAdministratorByPage(AccountRoleDTO, Integer, Integer)}
     */
    @Test
    void testQueryAdministratorByPage2()
    {
        when(this.tenantMapper.queryAdministratorByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountRoleQueryDTO>) any(),
                (AccountRoleDTO) any())).thenReturn(new ArrayList<>());

        AccountRoleDTO accountRoleDTO = new AccountRoleDTO();
        accountRoleDTO.setRoleCode("Role Code");
        accountRoleDTO.setTenantId(123L);
        accountRoleDTO.setUsername("janedoe");
        PageVO<AccountRoleQueryDTO> actualQueryAdministratorByPageResult = this.tenantServiceImpl
                .queryAdministratorByPage(accountRoleDTO, 2, 3);
        assertEquals(0L, actualQueryAdministratorByPageResult.getCounts());
        assertFalse(actualQueryAdministratorByPageResult.isFirst());
        assertFalse(actualQueryAdministratorByPageResult.hasItems());
        assertEquals(3, actualQueryAdministratorByPageResult.getPageSize());
        verify(this.tenantMapper).queryAdministratorByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountRoleQueryDTO>) any(),
                (AccountRoleDTO) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryAdministratorByPage(AccountRoleDTO, Integer, Integer)}
     */
    @Test
    void testQueryAdministratorByPage3()
    {
        when(this.tenantMapper.queryAdministratorByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountRoleQueryDTO>) any(),
                (AccountRoleDTO) any())).thenThrow(new BusinessException());

        AccountRoleDTO accountRoleDTO = new AccountRoleDTO();
        accountRoleDTO.setRoleCode("Role Code");
        accountRoleDTO.setTenantId(123L);
        accountRoleDTO.setUsername("janedoe");
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.queryAdministratorByPage(accountRoleDTO, 1, 3));
        verify(this.tenantMapper).queryAdministratorByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<AccountRoleQueryDTO>) any(),
                (AccountRoleDTO) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryTenantAccount(Long, Boolean)}
     */
    @Test
    void testQueryTenantAccount()
    {
        when(this.tenantAccountMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.TenantAccount>) any()))
                .thenReturn(3);
        assertTrue(this.tenantServiceImpl.queryTenantAccount(1234567890L, true));
        verify(this.tenantAccountMapper).selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.TenantAccount>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryTenantAccount(Long, Boolean)}
     */
    @Test
    void testQueryTenantAccount2()
    {
        when(this.tenantAccountMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.TenantAccount>) any()))
                .thenReturn(0);
        assertFalse(this.tenantServiceImpl.queryTenantAccount(1234567890L, true));
        verify(this.tenantAccountMapper).selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.TenantAccount>) any());
    }

    /**
     * Method under test: {@link TenantServiceImpl#queryTenantAccount(Long, Boolean)}
     */
    @Test
    void testQueryTenantAccount3()
    {
        when(this.tenantAccountMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.TenantAccount>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.tenantServiceImpl.queryTenantAccount(1234567890L, true));
        verify(this.tenantAccountMapper).selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.TenantAccount>) any());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link TenantServiceImpl}
     *   <li>{@link TenantServiceImpl#removeTenant(Long)}
     * </ul>
     */
    @Test
    void testConstructor()
    {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TenantServiceImpl.tenantMapper
        //     TenantServiceImpl.bundleMapper
        //     TenantServiceImpl.accountMapper
        //     TenantServiceImpl.tenantAccountMapper
        //     TenantServiceImpl.accountRoleMapper
        //     TenantServiceImpl.authorizationRoleMapper
        //     TenantServiceImpl.authorizationRolePrivilegeMapper
        //     TenantServiceImpl.authorizationService
        //     TenantServiceImpl.resourceService
        //     TenantServiceImpl.resourceApplicationMapper
        //     TenantServiceImpl.dozerUtils
        //     TenantServiceImpl.verificationFeignClient

        (new TenantServiceImpl()).removeTenant(123L);
    }
}

