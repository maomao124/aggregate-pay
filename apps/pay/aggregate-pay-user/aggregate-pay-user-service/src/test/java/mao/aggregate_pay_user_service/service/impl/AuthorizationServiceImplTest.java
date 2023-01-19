package mao.aggregate_pay_user_service.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mao.aggregate_pay_common.domain.BusinessException;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.auth.AuthorizationInfoDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeTreeDTO;
import mao.aggregate_pay_user_api.dto.auth.RoleDTO;
import mao.aggregate_pay_user_api.dto.tenant.TenRolePrivilegeDTO;
import mao.aggregate_pay_user_service.entity.AuthorizationPrivilege;
import mao.aggregate_pay_user_service.entity.AuthorizationPrivilegeGroup;
import mao.aggregate_pay_user_service.entity.AuthorizationRole;

import mao.aggregate_pay_user_service.mapper.AccountMapper;
import mao.aggregate_pay_user_service.mapper.AccountRoleMapper;
import mao.aggregate_pay_user_service.mapper.AuthorizationPrivilegeGroupMapper;
import mao.aggregate_pay_user_service.mapper.AuthorizationPrivilegeMapper;
import mao.aggregate_pay_user_service.mapper.AuthorizationRoleMapper;
import mao.aggregate_pay_user_service.mapper.AuthorizationRolePrivilegeMapper;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthorizationServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AuthorizationServiceImplTest
{
    @MockBean
    private AccountMapper accountMapper;

    @MockBean
    private AccountRoleMapper accountRoleMapper;

    @MockBean
    private AuthorizationPrivilegeGroupMapper authorizationPrivilegeGroupMapper;

    @MockBean
    private AuthorizationPrivilegeMapper authorizationPrivilegeMapper;

    @MockBean
    private AuthorizationRoleMapper authorizationRoleMapper;

    @MockBean
    private AuthorizationRolePrivilegeMapper authorizationRolePrivilegeMapper;

    @Autowired
    private AuthorizationServiceImpl authorizationServiceImpl;

    @MockBean
    private DozerUtils dozerUtils;

    /**
     * Method under test: {@link AuthorizationServiceImpl#authorize(String, Long[])}
     */
    @Test
    void testAuthorize()
    {
        when(this.authorizationPrivilegeMapper.selectPrivilegeRoleInTenant((List<Long>) any()))
                .thenReturn(new ArrayList<>());
        when(this.accountRoleMapper.selectRoleByUsernameInTenants((String) any(), (List<Long>) any()))
                .thenReturn(new ArrayList<>());
        assertTrue(this.authorizationServiceImpl.authorize("janedoe", new Long[]{1L}).isEmpty());
        verify(this.authorizationPrivilegeMapper).selectPrivilegeRoleInTenant((List<Long>) any());
        verify(this.accountRoleMapper).selectRoleByUsernameInTenants((String) any(), (List<Long>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#authorize(String, Long[])}
     */
    @Test
    void testAuthorize2()
    {
        when(this.authorizationPrivilegeMapper.selectPrivilegeRoleInTenant((List<Long>) any()))
                .thenReturn(new ArrayList<>());
        when(this.accountRoleMapper.selectRoleByUsernameInTenants((String) any(), (List<Long>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.authorizationServiceImpl.authorize("janedoe", new Long[]{1L}));
        verify(this.accountRoleMapper).selectRoleByUsernameInTenants((String) any(), (List<Long>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#authorize(String, Long[])}
     */
    @Test
    void testAuthorize3()
    {
        TenRolePrivilegeDTO tenRolePrivilegeDTO = new TenRolePrivilegeDTO();
        tenRolePrivilegeDTO.setPrivilegeCode("Privilege Code");
        tenRolePrivilegeDTO.setRoleCode("Role Code");
        tenRolePrivilegeDTO.setTenantId(123L);

        ArrayList<TenRolePrivilegeDTO> tenRolePrivilegeDTOList = new ArrayList<>();
        tenRolePrivilegeDTOList.add(tenRolePrivilegeDTO);
        when(this.authorizationPrivilegeMapper.selectPrivilegeRoleInTenant((List<Long>) any()))
                .thenReturn(tenRolePrivilegeDTOList);
        when(this.accountRoleMapper.selectRoleByUsernameInTenants((String) any(), (List<Long>) any()))
                .thenReturn(new ArrayList<>());
        Map<Long, AuthorizationInfoDTO> actualAuthorizeResult = this.authorizationServiceImpl.authorize("janedoe",
                new Long[]{1L});
        assertEquals(1, actualAuthorizeResult.size());
        Map<String, List<String>> rolePrivilegeMap = actualAuthorizeResult.get(123L).getRolePrivilegeMap();
        assertEquals(1, rolePrivilegeMap.size());
        List<String> getResult = rolePrivilegeMap.get("Role Code");
        assertEquals(1, getResult.size());
        assertEquals("Privilege Code", getResult.get(0));
        verify(this.authorizationPrivilegeMapper).selectPrivilegeRoleInTenant((List<Long>) any());
        verify(this.accountRoleMapper).selectRoleByUsernameInTenants((String) any(), (List<Long>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#authorize(String, Long[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthorize4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.util.Objects.requireNonNull(Objects.java:203)
        //       at java.util.Arrays$ArrayList.<init>(Arrays.java:3813)
        //       at java.util.Arrays.asList(Arrays.java:3800)
        //       at mao.aggregate_pay_user_service.service.impl.AuthorizationServiceImpl.authorize(AuthorizationServiceImpl.java:78)
        //   In order to prevent authorize(String, Long[])
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   authorize(String, Long[]).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.authorizationPrivilegeMapper.selectPrivilegeRoleInTenant((java.util.List<Long>) any()))
                .thenReturn(new ArrayList<>());
        when(this.accountRoleMapper.selectRoleByUsernameInTenants((String) any(), (java.util.List<Long>) any()))
                .thenReturn(new ArrayList<>());
        this.authorizationServiceImpl.authorize("janedoe", null);
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#authorize(String, Long[])}
     */
    @Test
    void testAuthorize5()
    {
        TenRolePrivilegeDTO tenRolePrivilegeDTO = new TenRolePrivilegeDTO();
        tenRolePrivilegeDTO.setPrivilegeCode("Privilege Code");
        tenRolePrivilegeDTO.setRoleCode("Role Code");
        tenRolePrivilegeDTO.setTenantId(123L);

        TenRolePrivilegeDTO tenRolePrivilegeDTO1 = new TenRolePrivilegeDTO();
        tenRolePrivilegeDTO1.setPrivilegeCode("Privilege Code");
        tenRolePrivilegeDTO1.setRoleCode("Role Code");
        tenRolePrivilegeDTO1.setTenantId(123L);

        ArrayList<TenRolePrivilegeDTO> tenRolePrivilegeDTOList = new ArrayList<>();
        tenRolePrivilegeDTOList.add(tenRolePrivilegeDTO1);
        tenRolePrivilegeDTOList.add(tenRolePrivilegeDTO);
        when(this.authorizationPrivilegeMapper.selectPrivilegeRoleInTenant((List<Long>) any()))
                .thenReturn(tenRolePrivilegeDTOList);
        when(this.accountRoleMapper.selectRoleByUsernameInTenants((String) any(), (List<Long>) any()))
                .thenReturn(new ArrayList<>());
        Map<Long, AuthorizationInfoDTO> actualAuthorizeResult = this.authorizationServiceImpl.authorize("janedoe",
                new Long[]{1L});
        assertEquals(1, actualAuthorizeResult.size());
        Map<String, List<String>> rolePrivilegeMap = actualAuthorizeResult.get(123L).getRolePrivilegeMap();
        assertEquals(1, rolePrivilegeMap.size());
        List<String> getResult = rolePrivilegeMap.get("Role Code");
        assertEquals(2, getResult.size());
        assertEquals("Privilege Code", getResult.get(0));
        assertEquals("Privilege Code", getResult.get(1));
        verify(this.authorizationPrivilegeMapper).selectPrivilegeRoleInTenant((List<Long>) any());
        verify(this.accountRoleMapper).selectRoleByUsernameInTenants((String) any(), (List<Long>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryPrivilege(Long, String[])}
     */
    @Test
    void testQueryPrivilege()
    {
        ArrayList<Object> objectList = new ArrayList<>();
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any())).thenReturn(objectList);
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(new ArrayList<>());
        List<PrivilegeDTO> actualQueryPrivilegeResult = this.authorizationServiceImpl.queryPrivilege(123L,
                new String[]{"Role Codes"});
        assertSame(objectList, actualQueryPrivilegeResult);
        assertTrue(actualQueryPrivilegeResult.isEmpty());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryPrivilege(Long, String[])}
     */
    @Test
    void testQueryPrivilege2()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class,
                () -> this.authorizationServiceImpl.queryPrivilege(123L, new String[]{"Role Codes"}));
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryPrivilege(Long, String[])}
     */
    @Test
    void testQueryPrivilege3()
    {
        ArrayList<Object> objectList = new ArrayList<>();
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any())).thenReturn(objectList);

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);

        ArrayList<AuthorizationRole> authorizationRoleList = new ArrayList<>();
        authorizationRoleList.add(authorizationRole);
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRoleList);
        when(this.authorizationPrivilegeMapper.selectPrivilegeByRole((List<Long>) any())).thenReturn(new ArrayList<>());
        List<PrivilegeDTO> actualQueryPrivilegeResult = this.authorizationServiceImpl.queryPrivilege(123L,
                new String[]{"Role Codes"});
        assertSame(objectList, actualQueryPrivilegeResult);
        assertTrue(actualQueryPrivilegeResult.isEmpty());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationPrivilegeMapper).selectPrivilegeByRole((List<Long>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryPrivilege(Long, String[])}
     */
    @Test
    void testQueryPrivilege4()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);

        ArrayList<AuthorizationRole> authorizationRoleList = new ArrayList<>();
        authorizationRoleList.add(authorizationRole);
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRoleList);
        when(this.authorizationPrivilegeMapper.selectPrivilegeByRole((List<Long>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class,
                () -> this.authorizationServiceImpl.queryPrivilege(123L, new String[]{"Role Codes"}));
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationPrivilegeMapper).selectPrivilegeByRole((List<Long>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryPrivilegeByGroupId(Long)}
     */
    @Test
    void testQueryPrivilegeByGroupId()
    {
        ArrayList<Object> objectList = new ArrayList<>();
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any())).thenReturn(objectList);
        when(this.authorizationPrivilegeMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any()))
                .thenReturn(new ArrayList<>());
        List<PrivilegeDTO> actualQueryPrivilegeByGroupIdResult = this.authorizationServiceImpl
                .queryPrivilegeByGroupId(123L);
        assertSame(objectList, actualQueryPrivilegeByGroupIdResult);
        assertTrue(actualQueryPrivilegeByGroupIdResult.isEmpty());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.authorizationPrivilegeMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryPrivilegeByGroupId(Long)}
     */
    @Test
    void testQueryPrivilegeByGroupId2()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());
        when(this.authorizationPrivilegeMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.authorizationServiceImpl.queryPrivilegeByGroupId(123L));
        verify(this.authorizationPrivilegeMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryPrivilegeTree(Long, String[])}
     */
    @Test
    void testQueryPrivilegeTree()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(new ArrayList<>());
        when(this.authorizationPrivilegeGroupMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilegeGroup>) any()))
                .thenReturn(new ArrayList<>());
        PrivilegeTreeDTO actualQueryPrivilegeTreeResult = this.authorizationServiceImpl.queryPrivilegeTree(123L,
                new String[]{"Role Codes"});
        assertTrue(actualQueryPrivilegeTreeResult.getChildren().isEmpty());
        assertTrue(actualQueryPrivilegeTreeResult.isGroup());
        assertEquals(0, actualQueryPrivilegeTreeResult.getStatus().intValue());
        assertNull(actualQueryPrivilegeTreeResult.getParentId());
        assertNull(actualQueryPrivilegeTreeResult.getName());
        assertEquals("top_1", actualQueryPrivilegeTreeResult.getId());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationPrivilegeGroupMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilegeGroup>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryPrivilegeTree(Long, String[])}
     */
    @Test
    void testQueryPrivilegeTree2()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(new ArrayList<>());
        when(this.authorizationPrivilegeGroupMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilegeGroup>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class,
                () -> this.authorizationServiceImpl.queryPrivilegeTree(123L, new String[]{"Role Codes"}));
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationPrivilegeGroupMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilegeGroup>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryPrivilegeTree(Long, String[])}
     */
    @Test
    void testQueryPrivilegeTree3()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("top_1");
        authorizationRole.setId(123L);
        authorizationRole.setName("top_1");
        authorizationRole.setTenantId(123L);

        ArrayList<AuthorizationRole> authorizationRoleList = new ArrayList<>();
        authorizationRoleList.add(authorizationRole);
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRoleList);
        when(this.authorizationPrivilegeMapper.selectPrivilegeByRole((List<Long>) any())).thenReturn(new ArrayList<>());
        when(this.authorizationPrivilegeGroupMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilegeGroup>) any()))
                .thenReturn(new ArrayList<>());
        PrivilegeTreeDTO actualQueryPrivilegeTreeResult = this.authorizationServiceImpl.queryPrivilegeTree(123L,
                new String[]{"Role Codes"});
        assertTrue(actualQueryPrivilegeTreeResult.getChildren().isEmpty());
        assertTrue(actualQueryPrivilegeTreeResult.isGroup());
        assertEquals(0, actualQueryPrivilegeTreeResult.getStatus().intValue());
        assertNull(actualQueryPrivilegeTreeResult.getParentId());
        assertNull(actualQueryPrivilegeTreeResult.getName());
        assertEquals("top_1", actualQueryPrivilegeTreeResult.getId());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationPrivilegeMapper).selectPrivilegeByRole((List<Long>) any());
        verify(this.authorizationPrivilegeGroupMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilegeGroup>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryPrivilegeTree(Long, String[])}
     */
    @Test
    void testQueryPrivilegeTree4()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("top_1");
        authorizationRole.setId(123L);
        authorizationRole.setName("top_1");
        authorizationRole.setTenantId(123L);

        ArrayList<AuthorizationRole> authorizationRoleList = new ArrayList<>();
        authorizationRoleList.add(authorizationRole);
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRoleList);
        when(this.authorizationPrivilegeMapper.selectPrivilegeByRole((List<Long>) any())).thenReturn(new ArrayList<>());

        AuthorizationPrivilegeGroup authorizationPrivilegeGroup = new AuthorizationPrivilegeGroup();
        authorizationPrivilegeGroup.setId(123L);
        authorizationPrivilegeGroup.setName("top_1");
        authorizationPrivilegeGroup.setParentId(123L);

        ArrayList<AuthorizationPrivilegeGroup> authorizationPrivilegeGroupList = new ArrayList<>();
        authorizationPrivilegeGroupList.add(authorizationPrivilegeGroup);
        when(this.authorizationPrivilegeGroupMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilegeGroup>) any()))
                .thenReturn(authorizationPrivilegeGroupList);
        PrivilegeTreeDTO actualQueryPrivilegeTreeResult = this.authorizationServiceImpl.queryPrivilegeTree(123L,
                new String[]{"Role Codes"});
        assertTrue(actualQueryPrivilegeTreeResult.getChildren().isEmpty());
        assertTrue(actualQueryPrivilegeTreeResult.isGroup());
        assertEquals(0, actualQueryPrivilegeTreeResult.getStatus().intValue());
        assertNull(actualQueryPrivilegeTreeResult.getParentId());
        assertNull(actualQueryPrivilegeTreeResult.getName());
        assertEquals("top_1", actualQueryPrivilegeTreeResult.getId());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationPrivilegeMapper).selectPrivilegeByRole((List<Long>) any());
        verify(this.authorizationPrivilegeGroupMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilegeGroup>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#createRole(Long, RoleDTO)}
     */
    @Test
    void testCreateRole()
    {
        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AuthorizationRole>) any())).thenReturn(authorizationRole);
        when(this.authorizationRoleMapper.insert((AuthorizationRole) any())).thenReturn(1);
        when(this.authorizationRoleMapper.selectRoleCodeInTenant((Long) any(), (String) any())).thenReturn(1);

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        assertThrows(BusinessException.class, () -> this.authorizationServiceImpl.createRole(123L, roleDTO));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.authorizationRoleMapper).selectRoleCodeInTenant((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#createRole(Long, RoleDTO)}
     */
    @Test
    void testCreateRole2()
    {
        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AuthorizationRole>) any())).thenReturn(authorizationRole);
        when(this.authorizationRoleMapper.insert((AuthorizationRole) any())).thenReturn(1);
        when(this.authorizationRoleMapper.selectRoleCodeInTenant((Long) any(), (String) any())).thenReturn(0);

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        this.authorizationServiceImpl.createRole(123L, roleDTO);
        verify(this.dozerUtils, atLeast(1)).map((Object) any(), (Class<AuthorizationRole>) any());
        verify(this.authorizationRoleMapper).insert((AuthorizationRole) any());
        verify(this.authorizationRoleMapper).selectRoleCodeInTenant((Long) any(), (String) any());
        assertEquals("Code", roleDTO.getCode());
        assertEquals(123L, roleDTO.getTenantId().longValue());
        assertTrue(roleDTO.getPrivilegeCodes().isEmpty());
        assertEquals("Name", roleDTO.getName());
        assertEquals(123L, roleDTO.getId().longValue());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#createRole(Long, RoleDTO)}
     */
    @Test
    void testCreateRole3()
    {
        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<Object>) any())).thenReturn("Map");
        when(this.dozerUtils.map((Object) any(), (Class<AuthorizationRole>) any())).thenReturn(authorizationRole);
        when(this.authorizationRoleMapper.insert((AuthorizationRole) any())).thenReturn(1);
        when(this.authorizationRoleMapper.selectRoleCodeInTenant((Long) any(), (String) any())).thenReturn(1);
        RoleDTO roleDTO = mock(RoleDTO.class);
        when(roleDTO.getCode()).thenReturn("");
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
        assertThrows(BusinessException.class, () -> this.authorizationServiceImpl.createRole(123L, roleDTO));
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(roleDTO).getCode();
        verify(roleDTO).setCode((String) any());
        verify(roleDTO).setId((Long) any());
        verify(roleDTO).setName((String) any());
        verify(roleDTO).setPrivilegeCodes((java.util.List<String>) any());
        verify(roleDTO).setTenantId((Long) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#removeRole(Long)}
     */
    @Test
    void testRemoveRole()
    {
        when(this.authorizationRoleMapper.deleteById((java.io.Serializable) any())).thenReturn(123);
        this.authorizationServiceImpl.removeRole(123L);
        verify(this.authorizationRoleMapper).deleteById((java.io.Serializable) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#removeRole(Long)}
     */
    @Test
    void testRemoveRole2()
    {
        when(this.authorizationRoleMapper.deleteById((java.io.Serializable) any())).thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.authorizationServiceImpl.removeRole(123L));
        verify(this.authorizationRoleMapper).deleteById((java.io.Serializable) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#removeRole(Long, String)}
     */
    @Test
    void testRemoveRole3()
    {
        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.deleteById((java.io.Serializable) any())).thenReturn(123);
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);
        when(this.accountMapper.selectAccountByRole((Long) any(), (String) any())).thenReturn(true);
        assertThrows(BusinessException.class, () -> this.authorizationServiceImpl.removeRole(123L, "Role Code"));
        verify(this.accountMapper).selectAccountByRole((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#removeRole(Long, String)}
     */
    @Test
    void testRemoveRole4()
    {
        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.deleteById((java.io.Serializable) any())).thenReturn(123);
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);
        when(this.accountMapper.selectAccountByRole((Long) any(), (String) any())).thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.authorizationServiceImpl.removeRole(123L, "Role Code"));
        verify(this.accountMapper).selectAccountByRole((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#removeRole(Long, String)}
     */
    @Test
    void testRemoveRole5()
    {
        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.deleteById((java.io.Serializable) any())).thenReturn(123);
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);
        when(this.accountMapper.selectAccountByRole((Long) any(), (String) any())).thenReturn(false);
        this.authorizationServiceImpl.removeRole(123L, "Role Code");
        verify(this.authorizationRoleMapper).deleteById((java.io.Serializable) any());
        verify(this.authorizationRoleMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.accountMapper).selectAccountByRole((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#removeRole(Long, String)}
     */
    @Test
    void testRemoveRole6()
    {
        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(null);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.deleteById((java.io.Serializable) any())).thenReturn(123);
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);
        when(this.accountMapper.selectAccountByRole((Long) any(), (String) any())).thenReturn(false);
        this.authorizationServiceImpl.removeRole(123L, "Role Code");
        verify(this.authorizationRoleMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.accountMapper).selectAccountByRole((Long) any(), (String) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#modifyRole(RoleDTO)}
     */
    @Test
    void testModifyRole()
    {
        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<AuthorizationRole>) any())).thenReturn(authorizationRole);
        when(this.authorizationRoleMapper.updateById((AuthorizationRole) any())).thenReturn(123);

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        this.authorizationServiceImpl.modifyRole(roleDTO);
        verify(this.dozerUtils).map((Object) any(), (Class<AuthorizationRole>) any());
        verify(this.authorizationRoleMapper).updateById((AuthorizationRole) any());
        assertEquals("Code", roleDTO.getCode());
        assertEquals(123L, roleDTO.getTenantId().longValue());
        assertTrue(roleDTO.getPrivilegeCodes().isEmpty());
        assertEquals("Name", roleDTO.getName());
        assertEquals(123L, roleDTO.getId().longValue());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#modifyRole(RoleDTO)}
     */
    @Test
    void testModifyRole2()
    {
        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<AuthorizationRole>) any())).thenReturn(authorizationRole);
        when(this.authorizationRoleMapper.updateById((AuthorizationRole) any())).thenThrow(new BusinessException());

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        assertThrows(BusinessException.class, () -> this.authorizationServiceImpl.modifyRole(roleDTO));
        verify(this.dozerUtils).map((Object) any(), (Class<AuthorizationRole>) any());
        verify(this.authorizationRoleMapper).updateById((AuthorizationRole) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#roleBindPrivilege(Long, String, String[])}
     */
    @Test
    void testRoleBindPrivilege()
    {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<RoleDTO>) any())).thenReturn(roleDTO);

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.selectPrivilegeByRole((Long) any())).thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);
        when(this.authorizationPrivilegeMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any()))
                .thenReturn(new ArrayList<>());
        assertThrows(BusinessException.class,
                () -> this.authorizationServiceImpl.roleBindPrivilege(123L, "Role Code", new String[]{"Privilege Codes"}));
        verify(this.dozerUtils).map((Object) any(), (Class<RoleDTO>) any());
        verify(this.authorizationRoleMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationRoleMapper).selectPrivilegeByRole((Long) any());
        verify(this.authorizationPrivilegeMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#roleBindPrivilege(Long, String, String[])}
     */
    @Test
    void testRoleBindPrivilege2()
    {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<RoleDTO>) any())).thenReturn(roleDTO);

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.selectPrivilegeByRole((Long) any())).thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);
        when(this.authorizationPrivilegeMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class,
                () -> this.authorizationServiceImpl.roleBindPrivilege(123L, "Role Code", new String[]{"Privilege Codes"}));
        verify(this.dozerUtils).map((Object) any(), (Class<RoleDTO>) any());
        verify(this.authorizationRoleMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationRoleMapper).selectPrivilegeByRole((Long) any());
        verify(this.authorizationPrivilegeMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#roleBindPrivilege(Long, String, String[])}
     */
    @Test
    void testRoleBindPrivilege3()
    {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<RoleDTO>) any())).thenReturn(roleDTO);
        when(this.authorizationRolePrivilegeMapper.delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.AuthorizationRolePrivilege>) any()))
                .thenReturn(1);
        doNothing().when(this.authorizationRolePrivilegeMapper).insertRolePrivilege((Long) any(), (List<Long>) any());

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.selectPrivilegeByRole((Long) any())).thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);

        AuthorizationPrivilege authorizationPrivilege = new AuthorizationPrivilege();
        authorizationPrivilege.setCode("Code");
        authorizationPrivilege.setId(123L);
        authorizationPrivilege.setName("Name");
        authorizationPrivilege.setPrivilegeGroupId(123L);

        ArrayList<AuthorizationPrivilege> authorizationPrivilegeList = new ArrayList<>();
        authorizationPrivilegeList.add(authorizationPrivilege);
        when(this.authorizationPrivilegeMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any()))
                .thenReturn(authorizationPrivilegeList);
        this.authorizationServiceImpl.roleBindPrivilege(123L, "Role Code", new String[]{"Privilege Codes"});
        verify(this.dozerUtils).map((Object) any(), (Class<RoleDTO>) any());
        verify(this.authorizationRolePrivilegeMapper).delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.AuthorizationRolePrivilege>) any());
        verify(this.authorizationRolePrivilegeMapper).insertRolePrivilege((Long) any(), (List<Long>) any());
        verify(this.authorizationRoleMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationRoleMapper).selectPrivilegeByRole((Long) any());
        verify(this.authorizationPrivilegeMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#roleBindPrivilege(Long, String, String[])}
     */
    @Test
    void testRoleBindPrivilege4()
    {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(null);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<RoleDTO>) any())).thenReturn(roleDTO);
        when(this.authorizationRolePrivilegeMapper.delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.AuthorizationRolePrivilege>) any()))
                .thenReturn(1);
        doNothing().when(this.authorizationRolePrivilegeMapper).insertRolePrivilege((Long) any(), (List<Long>) any());

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.selectPrivilegeByRole((Long) any())).thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);

        AuthorizationPrivilege authorizationPrivilege = new AuthorizationPrivilege();
        authorizationPrivilege.setCode("Code");
        authorizationPrivilege.setId(123L);
        authorizationPrivilege.setName("Name");
        authorizationPrivilege.setPrivilegeGroupId(123L);

        ArrayList<AuthorizationPrivilege> authorizationPrivilegeList = new ArrayList<>();
        authorizationPrivilegeList.add(authorizationPrivilege);
        when(this.authorizationPrivilegeMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any()))
                .thenReturn(authorizationPrivilegeList);
        this.authorizationServiceImpl.roleBindPrivilege(123L, "Role Code", new String[]{"Privilege Codes"});
        verify(this.dozerUtils).map((Object) any(), (Class<RoleDTO>) any());
        verify(this.authorizationRolePrivilegeMapper).insertRolePrivilege((Long) any(), (List<Long>) any());
        verify(this.authorizationRoleMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationRoleMapper).selectPrivilegeByRole((Long) any());
        verify(this.authorizationPrivilegeMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#roleBindPrivilege(Long, String, String[])}
     */
    @Test
    void testRoleBindPrivilege5()
    {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<RoleDTO>) any())).thenReturn(roleDTO);
        when(this.authorizationRolePrivilegeMapper.delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.AuthorizationRolePrivilege>) any()))
                .thenReturn(1);
        doNothing().when(this.authorizationRolePrivilegeMapper).insertRolePrivilege((Long) any(), (List<Long>) any());

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.selectPrivilegeByRole((Long) any())).thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);

        AuthorizationPrivilege authorizationPrivilege = new AuthorizationPrivilege();
        authorizationPrivilege.setCode("Code");
        authorizationPrivilege.setId(123L);
        authorizationPrivilege.setName("Name");
        authorizationPrivilege.setPrivilegeGroupId(123L);

        ArrayList<AuthorizationPrivilege> authorizationPrivilegeList = new ArrayList<>();
        authorizationPrivilegeList.add(authorizationPrivilege);
        when(this.authorizationPrivilegeMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any()))
                .thenReturn(authorizationPrivilegeList);
        assertThrows(BusinessException.class,
                () -> this.authorizationServiceImpl.roleBindPrivilege(123L, "Role Code", null));
        verify(this.dozerUtils).map((Object) any(), (Class<RoleDTO>) any());
        verify(this.authorizationRoleMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationRoleMapper).selectPrivilegeByRole((Long) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#roleBindPrivilege(Long, String, String[])}
     */
    @Test
    void testRoleBindPrivilege6()
    {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<RoleDTO>) any())).thenReturn(roleDTO);
        when(this.authorizationRolePrivilegeMapper.delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.AuthorizationRolePrivilege>) any()))
                .thenReturn(1);
        doNothing().when(this.authorizationRolePrivilegeMapper).insertRolePrivilege((Long) any(), (List<Long>) any());

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.selectPrivilegeByRole((Long) any())).thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);

        AuthorizationPrivilege authorizationPrivilege = new AuthorizationPrivilege();
        authorizationPrivilege.setCode("Code");
        authorizationPrivilege.setId(123L);
        authorizationPrivilege.setName("Name");
        authorizationPrivilege.setPrivilegeGroupId(123L);

        ArrayList<AuthorizationPrivilege> authorizationPrivilegeList = new ArrayList<>();
        authorizationPrivilegeList.add(authorizationPrivilege);
        when(this.authorizationPrivilegeMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any()))
                .thenReturn(authorizationPrivilegeList);
        assertThrows(BusinessException.class,
                () -> this.authorizationServiceImpl.roleBindPrivilege(123L, "Role Code", new String[]{}));
        verify(this.dozerUtils).map((Object) any(), (Class<RoleDTO>) any());
        verify(this.authorizationRoleMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationRoleMapper).selectPrivilegeByRole((Long) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#roleBindPrivilege(Long, String, String[])}
     */
    @Test
    void testRoleBindPrivilege7()
    {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<RoleDTO>) any())).thenReturn(roleDTO);
        when(this.authorizationRolePrivilegeMapper.delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.AuthorizationRolePrivilege>) any()))
                .thenThrow(new IllegalArgumentException("foo"));
        doThrow(new IllegalArgumentException("foo")).when(this.authorizationRolePrivilegeMapper)
                .insertRolePrivilege((Long) any(), (List<Long>) any());

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.selectPrivilegeByRole((Long) any())).thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);

        AuthorizationPrivilege authorizationPrivilege = new AuthorizationPrivilege();
        authorizationPrivilege.setCode("Code");
        authorizationPrivilege.setId(123L);
        authorizationPrivilege.setName("Name");
        authorizationPrivilege.setPrivilegeGroupId(123L);

        ArrayList<AuthorizationPrivilege> authorizationPrivilegeList = new ArrayList<>();
        authorizationPrivilegeList.add(authorizationPrivilege);
        when(this.authorizationPrivilegeMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any()))
                .thenReturn(authorizationPrivilegeList);
        assertThrows(IllegalArgumentException.class,
                () -> this.authorizationServiceImpl.roleBindPrivilege(123L, "Role Code", new String[]{"Privilege Codes"}));
        verify(this.dozerUtils).map((Object) any(), (Class<RoleDTO>) any());
        verify(this.authorizationRolePrivilegeMapper).delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.AuthorizationRolePrivilege>) any());
        verify(this.authorizationRoleMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationRoleMapper).selectPrivilegeByRole((Long) any());
        verify(this.authorizationPrivilegeMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#roleBindPrivilege(Long, String, String[])}
     */
    @Test
    void testRoleBindPrivilege8()
    {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(null);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<RoleDTO>) any())).thenReturn(roleDTO);
        when(this.authorizationRolePrivilegeMapper.delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.AuthorizationRolePrivilege>) any()))
                .thenThrow(new IllegalArgumentException("foo"));
        doThrow(new IllegalArgumentException("foo")).when(this.authorizationRolePrivilegeMapper)
                .insertRolePrivilege((Long) any(), (List<Long>) any());

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.selectPrivilegeByRole((Long) any())).thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);

        AuthorizationPrivilege authorizationPrivilege = new AuthorizationPrivilege();
        authorizationPrivilege.setCode("Code");
        authorizationPrivilege.setId(123L);
        authorizationPrivilege.setName("Name");
        authorizationPrivilege.setPrivilegeGroupId(123L);

        ArrayList<AuthorizationPrivilege> authorizationPrivilegeList = new ArrayList<>();
        authorizationPrivilegeList.add(authorizationPrivilege);
        when(this.authorizationPrivilegeMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any()))
                .thenReturn(authorizationPrivilegeList);
        assertThrows(IllegalArgumentException.class,
                () -> this.authorizationServiceImpl.roleBindPrivilege(123L, "Role Code", new String[]{"Privilege Codes"}));
        verify(this.dozerUtils).map((Object) any(), (Class<RoleDTO>) any());
        verify(this.authorizationRolePrivilegeMapper).insertRolePrivilege((Long) any(), (List<Long>) any());
        verify(this.authorizationRoleMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationRoleMapper).selectPrivilegeByRole((Long) any());
        verify(this.authorizationPrivilegeMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationPrivilege>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryRole(Long)}
     */
    @Test
    void testQueryRole()
    {
        ArrayList<Object> objectList = new ArrayList<>();
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any())).thenReturn(objectList);
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(new ArrayList<>());
        List<RoleDTO> actualQueryRoleResult = this.authorizationServiceImpl.queryRole(123L);
        assertSame(objectList, actualQueryRoleResult);
        assertTrue(actualQueryRoleResult.isEmpty());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryRole(Long)}
     */
    @Test
    void testQueryRole2()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.authorizationServiceImpl.queryRole(123L));
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryRole(Long, String[])}
     */
    @Test
    void testQueryRole3()
    {
        ArrayList<Object> objectList = new ArrayList<>();
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any())).thenReturn(objectList);
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(new ArrayList<>());
        List<RoleDTO> actualQueryRoleResult = this.authorizationServiceImpl.queryRole(123L, "Role Codes");
        assertSame(objectList, actualQueryRoleResult);
        assertTrue(actualQueryRoleResult.isEmpty());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryRole(Long, String[])}
     */
    @Test
    void testQueryRole4()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.authorizationServiceImpl.queryRole(123L, "Role Codes"));
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryTenantRole(Long, String)}
     */
    @Test
    void testQueryTenantRole()
    {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<RoleDTO>) any())).thenReturn(roleDTO);

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.selectPrivilegeByRole((Long) any())).thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);
        RoleDTO actualQueryTenantRoleResult = this.authorizationServiceImpl.queryTenantRole(123L, "Role Code");
        assertSame(roleDTO, actualQueryTenantRoleResult);
        assertTrue(actualQueryTenantRoleResult.getPrivilegeCodes().isEmpty());
        verify(this.dozerUtils).map((Object) any(), (Class<RoleDTO>) any());
        verify(this.authorizationRoleMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationRoleMapper).selectPrivilegeByRole((Long) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryTenantRole(Long, String)}
     */
    @Test
    void testQueryTenantRole2()
    {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<RoleDTO>) any())).thenReturn(roleDTO);

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);
        when(this.authorizationRoleMapper.selectPrivilegeByRole((Long) any())).thenThrow(new BusinessException());
        when(this.authorizationRoleMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRole);
        assertThrows(BusinessException.class, () -> this.authorizationServiceImpl.queryTenantRole(123L, "Role Code"));
        verify(this.dozerUtils).map((Object) any(), (Class<RoleDTO>) any());
        verify(this.authorizationRoleMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(this.authorizationRoleMapper).selectPrivilegeByRole((Long) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#bindAccountRole(String, Long, String[])}
     */
    @Test
    void testBindAccountRole()
    {
        doNothing().when(this.accountRoleMapper)
                .insertAccountRole((String) any(), (Long) any(), (java.util.List<String>) any());
        this.authorizationServiceImpl.bindAccountRole("janedoe", 123L, new String[]{"Role Codes"});
        verify(this.accountRoleMapper).insertAccountRole((String) any(), (Long) any(), (java.util.List<String>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#bindAccountRole(String, Long, String[])}
     */
    @Test
    void testBindAccountRole2()
    {
        doThrow(new BusinessException()).when(this.accountRoleMapper)
                .insertAccountRole((String) any(), (Long) any(), (java.util.List<String>) any());
        assertThrows(BusinessException.class,
                () -> this.authorizationServiceImpl.bindAccountRole("janedoe", 123L, new String[]{"Role Codes"}));
        verify(this.accountRoleMapper).insertAccountRole((String) any(), (Long) any(), (java.util.List<String>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#unbindAccountRole(String, Long, String[])}
     */
    @Test
    void testUnbindAccountRole()
    {
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(new ArrayList<>());
        assertThrows(BusinessException.class,
                () -> this.authorizationServiceImpl.unbindAccountRole("janedoe", 123L, new String[]{"Role Codes"}));
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#unbindAccountRole(String, Long, String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUnbindAccountRole2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: can not find lambda cache for this property [tenantId] of entity [mao.aggregate_pay_user_service.entity.AuthorizationRole]
        //       at com.baomidou.mybatisplus.core.toolkit.ExceptionUtils.mpe(ExceptionUtils.java:49)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.isTrue(Assert.java:38)
        //       at com.baomidou.mybatisplus.core.toolkit.Assert.notNull(Assert.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.getColumn(AbstractLambdaWrapper.java:95)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:72)
        //       at com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper.columnToString(AbstractLambdaWrapper.java:68)
        //       at com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper.set(LambdaUpdateWrapper.java:81)
        //       at com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper.set(LambdaUpdateWrapper.java:37)
        //       at com.baomidou.mybatisplus.core.conditions.update.Update.set(Update.java:30)
        //       at mao.aggregate_pay_user_service.service.impl.AuthorizationServiceImpl.unbindAccountRole(AuthorizationServiceImpl.java:490)
        //   In order to prevent unbindAccountRole(String, Long, String[])
        //   from throwing MybatisPlusException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   unbindAccountRole(String, Long, String[]).
        //   See https://diff.blue/R013 to resolve this issue.

        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("Code");
        authorizationRole.setId(123L);
        authorizationRole.setName("Name");
        authorizationRole.setTenantId(123L);

        ArrayList<AuthorizationRole> authorizationRoleList = new ArrayList<>();
        authorizationRoleList.add(authorizationRole);
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenReturn(authorizationRoleList);
        this.authorizationServiceImpl.unbindAccountRole("janedoe", 123L, new String[]{"Role Codes"});
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#unbindAccountRole(String, Long, String[])}
     */
    @Test
    void testUnbindAccountRole3()
    {
        when(this.authorizationRoleMapper
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class,
                () -> this.authorizationServiceImpl.unbindAccountRole("janedoe", 123L, new String[]{"Role Codes"}));
        verify(this.authorizationRoleMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryRoleByPage(RoleDTO, Integer, Integer)}
     */
    @Test
    void testQueryRoleByPage()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());
        when(this.authorizationRoleMapper.selectPage((IPage<AuthorizationRole>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any())).thenReturn(new Page<>());

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        PageVO<RoleDTO> actualQueryRoleByPageResult = this.authorizationServiceImpl.queryRoleByPage(roleDTO, 1, 3);
        assertEquals(0L, actualQueryRoleByPageResult.getCounts());
        assertFalse(actualQueryRoleByPageResult.isFirst());
        assertFalse(actualQueryRoleByPageResult.hasItems());
        assertEquals(3, actualQueryRoleByPageResult.getPageSize());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.authorizationRoleMapper).selectPage((IPage<AuthorizationRole>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryRoleByPage(RoleDTO, Integer, Integer)}
     */
    @Test
    void testQueryRoleByPage2()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenThrow(new BusinessException());
        when(this.authorizationRoleMapper.selectPage((IPage<AuthorizationRole>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any())).thenReturn(new Page<>());

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        assertThrows(BusinessException.class, () -> this.authorizationServiceImpl.queryRoleByPage(roleDTO, 1, 3));
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.authorizationRoleMapper).selectPage((IPage<AuthorizationRole>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryRoleByPage(RoleDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryRoleByPage3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.service.impl.AuthorizationServiceImpl.buildRoleQuery(AuthorizationServiceImpl.java:542)
        //       at mao.aggregate_pay_user_service.service.impl.AuthorizationServiceImpl.queryRoleByPage(AuthorizationServiceImpl.java:513)
        //   In order to prevent queryRoleByPage(RoleDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryRoleByPage(RoleDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());
        when(
                this.authorizationRoleMapper.selectPage((com.baomidou.mybatisplus.core.metadata.IPage<AuthorizationRole>) any(),
                        (com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any())).thenReturn(null);

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        this.authorizationServiceImpl.queryRoleByPage(roleDTO, 1, 3);
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryRoleByPage(RoleDTO, Integer, Integer)}
     */
    @Test
    void testQueryRoleByPage4()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());
        Page<AuthorizationRole> page = (Page<AuthorizationRole>) mock(Page.class);
        when(page.getRecords()).thenReturn(new ArrayList<>());
        when(page.getTotal()).thenReturn(1L);
        when(this.authorizationRoleMapper.selectPage((IPage<AuthorizationRole>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any())).thenReturn(page);

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        PageVO<RoleDTO> actualQueryRoleByPageResult = this.authorizationServiceImpl.queryRoleByPage(roleDTO, 1, 3);
        assertEquals(1L, actualQueryRoleByPageResult.getCounts());
        assertFalse(actualQueryRoleByPageResult.isFirst());
        assertFalse(actualQueryRoleByPageResult.hasItems());
        assertEquals(3, actualQueryRoleByPageResult.getPageSize());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.authorizationRoleMapper).selectPage((IPage<AuthorizationRole>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(page).getRecords();
        verify(page).getTotal();
    }

    /**
     * Method under test: {@link AuthorizationServiceImpl#queryRoleByPage(RoleDTO, Integer, Integer)}
     */
    @Test
    void testQueryRoleByPage5()
    {
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());
        Page<AuthorizationRole> page = (Page<AuthorizationRole>) mock(Page.class);
        when(page.getRecords()).thenReturn(new ArrayList<>());
        when(page.getTotal()).thenReturn(1L);
        when(this.authorizationRoleMapper.selectPage((IPage<AuthorizationRole>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any())).thenReturn(page);
        RoleDTO roleDTO = mock(RoleDTO.class);
        when(roleDTO.getTenantId()).thenReturn(123L);
        when(roleDTO.getName()).thenReturn("Name");
        doNothing().when(roleDTO).setCode((String) any());
        doNothing().when(roleDTO).setId((Long) any());
        doNothing().when(roleDTO).setName((String) any());
        doNothing().when(roleDTO).setPrivilegeCodes((List<String>) any());
        doNothing().when(roleDTO).setTenantId((Long) any());
        roleDTO.setCode("Code");
        roleDTO.setId(123L);
        roleDTO.setName("Name");
        roleDTO.setPrivilegeCodes(new ArrayList<>());
        roleDTO.setTenantId(123L);
        PageVO<RoleDTO> actualQueryRoleByPageResult = this.authorizationServiceImpl.queryRoleByPage(roleDTO, 2, 3);
        assertEquals(1L, actualQueryRoleByPageResult.getCounts());
        assertFalse(actualQueryRoleByPageResult.isFirst());
        assertFalse(actualQueryRoleByPageResult.hasItems());
        assertEquals(3, actualQueryRoleByPageResult.getPageSize());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
        verify(this.authorizationRoleMapper).selectPage((IPage<AuthorizationRole>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<AuthorizationRole>) any());
        verify(page).getRecords();
        verify(page).getTotal();
        verify(roleDTO, atLeast(1)).getTenantId();
        verify(roleDTO, atLeast(1)).getName();
        verify(roleDTO).setCode((String) any());
        verify(roleDTO).setId((Long) any());
        verify(roleDTO).setName((String) any());
        verify(roleDTO).setPrivilegeCodes((List<String>) any());
        verify(roleDTO).setTenantId((Long) any());
    }
}

