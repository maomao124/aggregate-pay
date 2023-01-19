package mao.aggregate_pay_user_service.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mao.aggregate_pay_common.domain.BusinessException;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.auth.AuthorizationInfoDTO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationQueryParams;
import mao.aggregate_pay_user_api.dto.resource.ResourceDTO;
import mao.aggregate_pay_user_service.entity.ResourceApplication;
import mao.aggregate_pay_user_service.entity.ResourceButton;
import mao.aggregate_pay_user_service.entity.ResourceMenu;
import mao.aggregate_pay_user_service.mapper.ResourceApplicationMapper;
import mao.aggregate_pay_user_service.mapper.ResourceButtonMapper;
import mao.aggregate_pay_user_service.mapper.ResourceMenuMapper;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ResourceServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ResourceServiceImplTest
{
    @MockBean
    private DozerUtils dozerUtils;

    @MockBean
    private ResourceApplicationMapper resourceApplicationMapper;

    @MockBean
    private ResourceButtonMapper resourceButtonMapper;

    @MockBean
    private ResourceMenuMapper resourceMenuMapper;

    @Autowired
    private ResourceServiceImpl resourceServiceImpl;

    /**
     * Method under test: {@link ResourceServiceImpl#createApplication(ApplicationDTO)}
     */
    @Test
    void testCreateApplication()
    {
        when(this.resourceApplicationMapper.insert((ResourceApplication) any())).thenReturn(1);

        ResourceApplication resourceApplication = new ResourceApplication();
        resourceApplication.setCode("Code");
        resourceApplication.setId(123L);
        resourceApplication.setName("Name");
        resourceApplication.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<ResourceApplication>) any())).thenReturn(resourceApplication);

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setCode("Code");
        applicationDTO.setId(123L);
        applicationDTO.setName("Name");
        applicationDTO.setTenantId(123L);
        this.resourceServiceImpl.createApplication(applicationDTO);
        verify(this.resourceApplicationMapper).insert((ResourceApplication) any());
        verify(this.dozerUtils).map((Object) any(), (Class<ResourceApplication>) any());
        assertEquals("Code", applicationDTO.getCode());
        assertEquals(123L, applicationDTO.getTenantId().longValue());
        assertEquals("Name", applicationDTO.getName());
        assertEquals(123L, applicationDTO.getId().longValue());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#createApplication(ApplicationDTO)}
     */
    @Test
    void testCreateApplication2()
    {
        when(this.resourceApplicationMapper.insert((ResourceApplication) any())).thenReturn(1);
        when(this.dozerUtils.map((Object) any(), (Class<ResourceApplication>) any())).thenThrow(new BusinessException());

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setCode("Code");
        applicationDTO.setId(123L);
        applicationDTO.setName("Name");
        applicationDTO.setTenantId(123L);
        assertThrows(BusinessException.class, () -> this.resourceServiceImpl.createApplication(applicationDTO));
        verify(this.dozerUtils).map((Object) any(), (Class<ResourceApplication>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#modifyApplication(ApplicationDTO)}
     */
    @Test
    void testModifyApplication()
    {
        when(this.resourceApplicationMapper.updateById((ResourceApplication) any())).thenReturn(123);

        ResourceApplication resourceApplication = new ResourceApplication();
        resourceApplication.setCode("Code");
        resourceApplication.setId(123L);
        resourceApplication.setName("Name");
        resourceApplication.setTenantId(123L);
        when(this.dozerUtils.map((Object) any(), (Class<ResourceApplication>) any())).thenReturn(resourceApplication);

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setCode("Code");
        applicationDTO.setId(123L);
        applicationDTO.setName("Name");
        applicationDTO.setTenantId(123L);
        this.resourceServiceImpl.modifyApplication(applicationDTO);
        verify(this.resourceApplicationMapper).updateById((ResourceApplication) any());
        verify(this.dozerUtils).map((Object) any(), (Class<ResourceApplication>) any());
        assertEquals("Code", applicationDTO.getCode());
        assertEquals(123L, applicationDTO.getTenantId().longValue());
        assertEquals("Name", applicationDTO.getName());
        assertEquals(123L, applicationDTO.getId().longValue());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#modifyApplication(ApplicationDTO)}
     */
    @Test
    void testModifyApplication2()
    {
        when(this.resourceApplicationMapper.updateById((ResourceApplication) any())).thenReturn(123);
        when(this.dozerUtils.map((Object) any(), (Class<ResourceApplication>) any())).thenThrow(new BusinessException());

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setCode("Code");
        applicationDTO.setId(123L);
        applicationDTO.setName("Name");
        applicationDTO.setTenantId(123L);
        assertThrows(BusinessException.class, () -> this.resourceServiceImpl.modifyApplication(applicationDTO));
        verify(this.dozerUtils).map((Object) any(), (Class<ResourceApplication>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#removeApplication(String)}
     */
    @Test
    void testRemoveApplication()
    {
        when(this.resourceMenuMapper.selectResourceByApplicationCode((String) any())).thenReturn(1);
        when(this.resourceApplicationMapper.delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.ResourceApplication>) any()))
                .thenReturn(1);
        this.resourceServiceImpl.removeApplication("Application Code");
        verify(this.resourceMenuMapper).selectResourceByApplicationCode((String) any());
        verify(this.resourceApplicationMapper).delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.ResourceApplication>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#removeApplication(String)}
     */
    @Test
    void testRemoveApplication2()
    {
        when(this.resourceMenuMapper.selectResourceByApplicationCode((String) any())).thenReturn(1);
        when(this.resourceApplicationMapper.delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.ResourceApplication>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class, () -> this.resourceServiceImpl.removeApplication("Application Code"));
        verify(this.resourceMenuMapper).selectResourceByApplicationCode((String) any());
        verify(this.resourceApplicationMapper).delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.ResourceApplication>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#removeApplication(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRemoveApplication3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: 应用下有关联资源，不能删除
        //       at org.springframework.util.Assert.isTrue(Assert.java:118)
        //       at mao.aggregate_pay_user_service.service.impl.ResourceServiceImpl.removeApplication(ResourceServiceImpl.java:102)
        //   In order to prevent removeApplication(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   removeApplication(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.resourceMenuMapper.selectResourceByApplicationCode((String) any())).thenReturn(0);
        when(this.resourceApplicationMapper.delete(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_user_service.entity.ResourceApplication>) any()))
                .thenReturn(1);
        this.resourceServiceImpl.removeApplication("Application Code");
    }

    /**
     * Method under test: {@link ResourceServiceImpl#queryApplication(String)}
     */
    @Test
    void testQueryApplication()
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
        assertSame(applicationDTO, this.resourceServiceImpl.queryApplication("Application Code"));
        verify(this.resourceApplicationMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any());
        verify(this.dozerUtils).map((Object) any(), (Class<ApplicationDTO>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#queryApplication(String)}
     */
    @Test
    void testQueryApplication2()
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
        assertThrows(BusinessException.class, () -> this.resourceServiceImpl.queryApplication("Application Code"));
        verify(this.resourceApplicationMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any());
        verify(this.dozerUtils).map((Object) any(), (Class<ApplicationDTO>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#pageApplicationByConditions(ApplicationQueryParams, Integer, Integer)}
     */
    @Test
    void testPageApplicationByConditions()
    {
        when(this.resourceApplicationMapper.selectAppByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<ApplicationDTO>) any(),
                (ApplicationQueryParams) any())).thenReturn(new ArrayList<>());

        ApplicationQueryParams applicationQueryParams = new ApplicationQueryParams();
        applicationQueryParams.setName("Name");
        PageVO<ApplicationDTO> actualPageApplicationByConditionsResult = this.resourceServiceImpl
                .pageApplicationByConditions(applicationQueryParams, 1, 3);
        assertEquals(0L, actualPageApplicationByConditionsResult.getCounts());
        assertFalse(actualPageApplicationByConditionsResult.isFirst());
        assertFalse(actualPageApplicationByConditionsResult.hasItems());
        assertEquals(3, actualPageApplicationByConditionsResult.getPageSize());
        verify(this.resourceApplicationMapper).selectAppByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<ApplicationDTO>) any(),
                (ApplicationQueryParams) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#pageApplicationByConditions(ApplicationQueryParams, Integer, Integer)}
     */
    @Test
    void testPageApplicationByConditions2()
    {
        when(this.resourceApplicationMapper.selectAppByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<ApplicationDTO>) any(),
                (ApplicationQueryParams) any())).thenReturn(new ArrayList<>());

        ApplicationQueryParams applicationQueryParams = new ApplicationQueryParams();
        applicationQueryParams.setName("Name");
        PageVO<ApplicationDTO> actualPageApplicationByConditionsResult = this.resourceServiceImpl
                .pageApplicationByConditions(applicationQueryParams, 5, 3);
        assertEquals(0L, actualPageApplicationByConditionsResult.getCounts());
        assertFalse(actualPageApplicationByConditionsResult.isFirst());
        assertFalse(actualPageApplicationByConditionsResult.hasItems());
        assertEquals(3, actualPageApplicationByConditionsResult.getPageSize());
        verify(this.resourceApplicationMapper).selectAppByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<ApplicationDTO>) any(),
                (ApplicationQueryParams) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#pageApplicationByConditions(ApplicationQueryParams, Integer, Integer)}
     */
    @Test
    void testPageApplicationByConditions3()
    {
        when(this.resourceApplicationMapper.selectAppByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<ApplicationDTO>) any(),
                (ApplicationQueryParams) any())).thenThrow(new BusinessException());

        ApplicationQueryParams applicationQueryParams = new ApplicationQueryParams();
        applicationQueryParams.setName("Name");
        assertThrows(BusinessException.class,
                () -> this.resourceServiceImpl.pageApplicationByConditions(applicationQueryParams, 1, 3));
        verify(this.resourceApplicationMapper).selectAppByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<ApplicationDTO>) any(),
                (ApplicationQueryParams) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(List, String)}
     */
    @Test
    void testLoadResources()
    {
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(new ArrayList<>());
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(new ArrayList<>());

        ResourceApplication resourceApplication = new ResourceApplication();
        resourceApplication.setCode("Code");
        resourceApplication.setId(123L);
        resourceApplication.setName("Name");
        resourceApplication.setTenantId(123L);
        when(this.resourceApplicationMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any()))
                .thenReturn(resourceApplication);
        List<ResourceDTO> actualLoadResourcesResult = this.resourceServiceImpl.loadResources(new ArrayList<>(),
                "Application Code");
        assertEquals(1, actualLoadResourcesResult.size());
        ResourceDTO getResult = actualLoadResourcesResult.get(0);
        assertTrue(getResult.getAppRes().isEmpty());
        assertEquals("Name", getResult.getApplicationName());
        assertEquals("Code", getResult.getApplicationCode());
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.resourceButtonMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any());
        verify(this.resourceApplicationMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(List, String)}
     */
    @Test
    void testLoadResources2()
    {
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(new ArrayList<>());
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(new ArrayList<>());
        when(this.resourceApplicationMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any()))
                .thenThrow(new BusinessException());
        assertThrows(BusinessException.class,
                () -> this.resourceServiceImpl.loadResources(new ArrayList<>(), "Application Code"));
        verify(this.resourceApplicationMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(List, String)}
     */
    @Test
    void testLoadResources3()
    {
        ResourceMenu resourceMenu = new ResourceMenu();
        resourceMenu.setApplicationCode("Application Code");
        resourceMenu.setComment("Comment");
        resourceMenu.setIcon("Icon");
        resourceMenu.setId(123L);
        resourceMenu.setParentId(123L);
        resourceMenu.setPrivilegeCode("Privilege Code");
        resourceMenu.setSort(1);
        resourceMenu.setStatus(1);
        resourceMenu.setTitle("Dr");
        resourceMenu.setUrl("https://example.org/example");

        ArrayList<ResourceMenu> resourceMenuList = new ArrayList<>();
        resourceMenuList.add(resourceMenu);
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(resourceMenuList);
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(new ArrayList<>());

        ResourceApplication resourceApplication = new ResourceApplication();
        resourceApplication.setCode("Code");
        resourceApplication.setId(123L);
        resourceApplication.setName("Name");
        resourceApplication.setTenantId(123L);
        when(this.resourceApplicationMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any()))
                .thenReturn(resourceApplication);
        List<ResourceDTO> actualLoadResourcesResult = this.resourceServiceImpl.loadResources(new ArrayList<>(),
                "Application Code");
        assertEquals(1, actualLoadResourcesResult.size());
        ResourceDTO getResult = actualLoadResourcesResult.get(0);
        assertEquals(1, getResult.getAppRes().size());
        assertEquals("Name", getResult.getApplicationName());
        assertEquals("Code", getResult.getApplicationCode());
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.resourceButtonMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any());
        verify(this.resourceApplicationMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(List, String)}
     */
    @Test
    void testLoadResources4()
    {
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(new ArrayList<>());

        ResourceButton resourceButton = new ResourceButton();
        resourceButton.setApplicationCode("Application Code");
        resourceButton.setComment("Comment");
        resourceButton.setIcon("Icon");
        resourceButton.setId(123L);
        resourceButton.setParentId(123L);
        resourceButton.setPrivilegeCode("Privilege Code");
        resourceButton.setSort(1);
        resourceButton.setStatus(1);
        resourceButton.setTitle("Dr");
        resourceButton.setUrl("https://example.org/example");

        ArrayList<ResourceButton> resourceButtonList = new ArrayList<>();
        resourceButtonList.add(resourceButton);
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(resourceButtonList);

        ResourceApplication resourceApplication = new ResourceApplication();
        resourceApplication.setCode("Code");
        resourceApplication.setId(123L);
        resourceApplication.setName("Name");
        resourceApplication.setTenantId(123L);
        when(this.resourceApplicationMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any()))
                .thenReturn(resourceApplication);
        List<ResourceDTO> actualLoadResourcesResult = this.resourceServiceImpl.loadResources(new ArrayList<>(),
                "Application Code");
        assertEquals(1, actualLoadResourcesResult.size());
        ResourceDTO getResult = actualLoadResourcesResult.get(0);
        assertEquals(1, getResult.getAppRes().size());
        assertEquals("Name", getResult.getApplicationName());
        assertEquals("Code", getResult.getApplicationCode());
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.resourceButtonMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any());
        verify(this.resourceApplicationMapper)
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(List, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadResources5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.creation.settings.CreationSettings, fieldName : mockSettings, write javaBean error, fastjson version 1.2.76, class com.diffblue.spring.isolation.framework.mocks.MockInvocationListener, fieldName : 0, write javaBean error, fastjson version 1.2.76, class org.mockito.codegen.ResourceApplicationMapper$MockitoMock$1424933886, fieldName : 1, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper, fieldName : 0
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:541)
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:154)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.writeWithFieldName(JSONSerializer.java:360)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_4_MockMethodInterceptor.write(null)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_3_ResourceMenu$MockitoMock$1214729020.write(null)
        //       at com.alibaba.fastjson.serializer.ListSerializer.write(ListSerializer.java:135)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.write(JSONSerializer.java:312)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:793)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:731)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:688)
        //       at mao.aggregate_pay_user_service.service.impl.ResourceServiceImpl.loadResources(ResourceServiceImpl.java:157)
        //   In order to prevent loadResources(List, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadResources(List, String).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceMenu resourceMenu = mock(ResourceMenu.class);
        when(resourceMenu.getId()).thenReturn(123L);
        when(resourceMenu.getApplicationCode()).thenReturn("Application Code");
        when(resourceMenu.getComment()).thenReturn("Comment");
        when(resourceMenu.getIcon()).thenReturn("Icon");
        doNothing().when(resourceMenu).setApplicationCode((String) any());
        doNothing().when(resourceMenu).setComment((String) any());
        doNothing().when(resourceMenu).setIcon((String) any());
        doNothing().when(resourceMenu).setId((Long) any());
        doNothing().when(resourceMenu).setParentId((Long) any());
        doNothing().when(resourceMenu).setPrivilegeCode((String) any());
        doNothing().when(resourceMenu).setSort((Integer) any());
        doNothing().when(resourceMenu).setStatus((Integer) any());
        doNothing().when(resourceMenu).setTitle((String) any());
        doNothing().when(resourceMenu).setUrl((String) any());
        resourceMenu.setApplicationCode("Application Code");
        resourceMenu.setComment("Comment");
        resourceMenu.setIcon("Icon");
        resourceMenu.setId(123L);
        resourceMenu.setParentId(123L);
        resourceMenu.setPrivilegeCode("Privilege Code");
        resourceMenu.setSort(1);
        resourceMenu.setStatus(1);
        resourceMenu.setTitle("Dr");
        resourceMenu.setUrl("https://example.org/example");

        ArrayList<ResourceMenu> resourceMenuList = new ArrayList<>();
        resourceMenuList.add(resourceMenu);
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(resourceMenuList);
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(new ArrayList<>());

        ResourceApplication resourceApplication = new ResourceApplication();
        resourceApplication.setCode("Code");
        resourceApplication.setId(123L);
        resourceApplication.setName("Name");
        resourceApplication.setTenantId(123L);
        when(this.resourceApplicationMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any()))
                .thenReturn(resourceApplication);
        this.resourceServiceImpl.loadResources(new ArrayList<>(), "Application Code");
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(List, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadResources6()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.creation.settings.CreationSettings, fieldName : mockSettings, write javaBean error, fastjson version 1.2.76, class com.diffblue.spring.isolation.framework.mocks.MockInvocationListener, fieldName : 0, write javaBean error, fastjson version 1.2.76, class org.mockito.codegen.ResourceMenuMapper$MockitoMock$1647981646, fieldName : 0, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper, fieldName : 0
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:541)
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:154)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.writeWithFieldName(JSONSerializer.java:360)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_4_MockMethodInterceptor.write(null)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_3_ResourceMenu$MockitoMock$1214729020.write(null)
        //       at com.alibaba.fastjson.serializer.ListSerializer.write(ListSerializer.java:135)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.write(JSONSerializer.java:312)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:793)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:731)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:688)
        //       at mao.aggregate_pay_user_service.service.impl.ResourceServiceImpl.loadResources(ResourceServiceImpl.java:157)
        //   In order to prevent loadResources(List, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadResources(List, String).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceMenu resourceMenu = mock(ResourceMenu.class);
        when(resourceMenu.getId()).thenReturn(123L);
        when(resourceMenu.getApplicationCode()).thenReturn("Application Code");
        when(resourceMenu.getComment()).thenReturn("Comment");
        when(resourceMenu.getIcon()).thenReturn("Icon");
        doNothing().when(resourceMenu).setApplicationCode((String) any());
        doNothing().when(resourceMenu).setComment((String) any());
        doNothing().when(resourceMenu).setIcon((String) any());
        doNothing().when(resourceMenu).setId((Long) any());
        doNothing().when(resourceMenu).setParentId((Long) any());
        doNothing().when(resourceMenu).setPrivilegeCode((String) any());
        doNothing().when(resourceMenu).setSort((Integer) any());
        doNothing().when(resourceMenu).setStatus((Integer) any());
        doNothing().when(resourceMenu).setTitle((String) any());
        doNothing().when(resourceMenu).setUrl((String) any());
        resourceMenu.setApplicationCode("Application Code");
        resourceMenu.setComment("Comment");
        resourceMenu.setIcon("Icon");
        resourceMenu.setId(123L);
        resourceMenu.setParentId(123L);
        resourceMenu.setPrivilegeCode("Privilege Code");
        resourceMenu.setSort(1);
        resourceMenu.setStatus(1);
        resourceMenu.setTitle("Dr");
        resourceMenu.setUrl("https://example.org/example");

        ResourceMenu resourceMenu1 = new ResourceMenu();
        resourceMenu1.setApplicationCode("(LUUU;)LUUU;");
        resourceMenu1.setComment("(LUUU;)LUUU;");
        resourceMenu1.setIcon("(LUUU;)LUUU;");
        resourceMenu1.setId(123L);
        resourceMenu1.setParentId(123L);
        resourceMenu1.setPrivilegeCode("(LUUU;)LUUU;");
        resourceMenu1.setSort(4);
        resourceMenu1.setStatus(4);
        resourceMenu1.setTitle("Dr");
        resourceMenu1.setUrl("https://example.org/example");

        ArrayList<ResourceMenu> resourceMenuList = new ArrayList<>();
        resourceMenuList.add(resourceMenu1);
        resourceMenuList.add(resourceMenu);
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(resourceMenuList);
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(new ArrayList<>());

        ResourceApplication resourceApplication = new ResourceApplication();
        resourceApplication.setCode("Code");
        resourceApplication.setId(123L);
        resourceApplication.setName("Name");
        resourceApplication.setTenantId(123L);
        when(this.resourceApplicationMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any()))
                .thenReturn(resourceApplication);
        this.resourceServiceImpl.loadResources(new ArrayList<>(), "Application Code");
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(List, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadResources7()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.creation.settings.CreationSettings, fieldName : mockSettings, write javaBean error, fastjson version 1.2.76, class com.diffblue.spring.isolation.framework.mocks.MockInvocationListener, fieldName : 0, write javaBean error, fastjson version 1.2.76, class org.mockito.codegen.ResourceApplicationMapper$MockitoMock$1424933886, fieldName : 1, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper, fieldName : 0
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:541)
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:154)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.writeWithFieldName(JSONSerializer.java:360)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_4_MockMethodInterceptor.write(null)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_3_ResourceMenu$MockitoMock$1214729020.write(null)
        //       at com.alibaba.fastjson.serializer.ListSerializer.write(ListSerializer.java:135)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.write(JSONSerializer.java:312)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:793)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:731)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:688)
        //       at mao.aggregate_pay_user_service.service.impl.ResourceServiceImpl.loadResources(ResourceServiceImpl.java:157)
        //   In order to prevent loadResources(List, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadResources(List, String).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceMenu resourceMenu = mock(ResourceMenu.class);
        when(resourceMenu.getId()).thenReturn(4L);
        when(resourceMenu.getApplicationCode()).thenReturn("Application Code");
        when(resourceMenu.getComment()).thenReturn("Comment");
        when(resourceMenu.getIcon()).thenReturn("Icon");
        doNothing().when(resourceMenu).setApplicationCode((String) any());
        doNothing().when(resourceMenu).setComment((String) any());
        doNothing().when(resourceMenu).setIcon((String) any());
        doNothing().when(resourceMenu).setId((Long) any());
        doNothing().when(resourceMenu).setParentId((Long) any());
        doNothing().when(resourceMenu).setPrivilegeCode((String) any());
        doNothing().when(resourceMenu).setSort((Integer) any());
        doNothing().when(resourceMenu).setStatus((Integer) any());
        doNothing().when(resourceMenu).setTitle((String) any());
        doNothing().when(resourceMenu).setUrl((String) any());
        resourceMenu.setApplicationCode("Application Code");
        resourceMenu.setComment("Comment");
        resourceMenu.setIcon("Icon");
        resourceMenu.setId(123L);
        resourceMenu.setParentId(123L);
        resourceMenu.setPrivilegeCode("Privilege Code");
        resourceMenu.setSort(1);
        resourceMenu.setStatus(1);
        resourceMenu.setTitle("Dr");
        resourceMenu.setUrl("https://example.org/example");

        ArrayList<ResourceMenu> resourceMenuList = new ArrayList<>();
        resourceMenuList.add(resourceMenu);
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(resourceMenuList);
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(new ArrayList<>());

        ResourceApplication resourceApplication = new ResourceApplication();
        resourceApplication.setCode("Code");
        resourceApplication.setId(123L);
        resourceApplication.setName("Name");
        resourceApplication.setTenantId(123L);
        when(this.resourceApplicationMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any()))
                .thenReturn(resourceApplication);
        this.resourceServiceImpl.loadResources(new ArrayList<>(), "Application Code");
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(List, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadResources8()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.creation.settings.CreationSettings, fieldName : mockSettings, write javaBean error, fastjson version 1.2.76, class com.diffblue.spring.isolation.framework.mocks.MockInvocationListener, fieldName : 0, write javaBean error, fastjson version 1.2.76, class org.mockito.codegen.ResourceApplicationMapper$MockitoMock$1424933886, fieldName : 2, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper, fieldName : 0
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:541)
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:154)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.writeWithFieldName(JSONSerializer.java:360)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_4_MockMethodInterceptor.write(null)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_3_ResourceMenu$MockitoMock$1214729020.write(null)
        //       at com.alibaba.fastjson.serializer.ListSerializer.write(ListSerializer.java:135)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.write(JSONSerializer.java:312)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:793)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:731)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:688)
        //       at mao.aggregate_pay_user_service.service.impl.ResourceServiceImpl.loadResources(ResourceServiceImpl.java:157)
        //   In order to prevent loadResources(List, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadResources(List, String).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceMenu resourceMenu = mock(ResourceMenu.class);
        when(resourceMenu.getId()).thenReturn(-1L);
        when(resourceMenu.getApplicationCode()).thenReturn("Application Code");
        when(resourceMenu.getComment()).thenReturn("Comment");
        when(resourceMenu.getIcon()).thenReturn("Icon");
        doNothing().when(resourceMenu).setApplicationCode((String) any());
        doNothing().when(resourceMenu).setComment((String) any());
        doNothing().when(resourceMenu).setIcon((String) any());
        doNothing().when(resourceMenu).setId((Long) any());
        doNothing().when(resourceMenu).setParentId((Long) any());
        doNothing().when(resourceMenu).setPrivilegeCode((String) any());
        doNothing().when(resourceMenu).setSort((Integer) any());
        doNothing().when(resourceMenu).setStatus((Integer) any());
        doNothing().when(resourceMenu).setTitle((String) any());
        doNothing().when(resourceMenu).setUrl((String) any());
        resourceMenu.setApplicationCode("Application Code");
        resourceMenu.setComment("Comment");
        resourceMenu.setIcon("Icon");
        resourceMenu.setId(123L);
        resourceMenu.setParentId(123L);
        resourceMenu.setPrivilegeCode("Privilege Code");
        resourceMenu.setSort(1);
        resourceMenu.setStatus(1);
        resourceMenu.setTitle("Dr");
        resourceMenu.setUrl("https://example.org/example");

        ArrayList<ResourceMenu> resourceMenuList = new ArrayList<>();
        resourceMenuList.add(resourceMenu);
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(resourceMenuList);
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(new ArrayList<>());

        ResourceApplication resourceApplication = new ResourceApplication();
        resourceApplication.setCode("Code");
        resourceApplication.setId(123L);
        resourceApplication.setName("Name");
        resourceApplication.setTenantId(123L);
        when(this.resourceApplicationMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any()))
                .thenReturn(resourceApplication);
        this.resourceServiceImpl.loadResources(new ArrayList<>(), "Application Code");
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(List, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadResources9()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.creation.settings.CreationSettings, fieldName : mockSettings, write javaBean error, fastjson version 1.2.76, class com.diffblue.spring.isolation.framework.mocks.MockInvocationListener, fieldName : 0, write javaBean error, fastjson version 1.2.76, class org.mockito.codegen.ResourceApplicationMapper$MockitoMock$1424933886, fieldName : 0, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper, fieldName : 0
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:541)
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:154)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.writeWithFieldName(JSONSerializer.java:360)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_4_MockMethodInterceptor.write(null)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_3_ResourceMenu$MockitoMock$1214729020.write(null)
        //       at com.alibaba.fastjson.serializer.ListSerializer.write(ListSerializer.java:135)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.write(JSONSerializer.java:312)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:793)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:731)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:688)
        //       at mao.aggregate_pay_user_service.service.impl.ResourceServiceImpl.loadResources(ResourceServiceImpl.java:157)
        //   In order to prevent loadResources(List, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadResources(List, String).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceMenu resourceMenu = mock(ResourceMenu.class);
        when(resourceMenu.getId()).thenReturn(Long.MAX_VALUE);
        when(resourceMenu.getApplicationCode()).thenReturn("Application Code");
        when(resourceMenu.getComment()).thenReturn("Comment");
        when(resourceMenu.getIcon()).thenReturn("Icon");
        doNothing().when(resourceMenu).setApplicationCode((String) any());
        doNothing().when(resourceMenu).setComment((String) any());
        doNothing().when(resourceMenu).setIcon((String) any());
        doNothing().when(resourceMenu).setId((Long) any());
        doNothing().when(resourceMenu).setParentId((Long) any());
        doNothing().when(resourceMenu).setPrivilegeCode((String) any());
        doNothing().when(resourceMenu).setSort((Integer) any());
        doNothing().when(resourceMenu).setStatus((Integer) any());
        doNothing().when(resourceMenu).setTitle((String) any());
        doNothing().when(resourceMenu).setUrl((String) any());
        resourceMenu.setApplicationCode("Application Code");
        resourceMenu.setComment("Comment");
        resourceMenu.setIcon("Icon");
        resourceMenu.setId(123L);
        resourceMenu.setParentId(123L);
        resourceMenu.setPrivilegeCode("Privilege Code");
        resourceMenu.setSort(1);
        resourceMenu.setStatus(1);
        resourceMenu.setTitle("Dr");
        resourceMenu.setUrl("https://example.org/example");

        ArrayList<ResourceMenu> resourceMenuList = new ArrayList<>();
        resourceMenuList.add(resourceMenu);
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(resourceMenuList);
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(new ArrayList<>());

        ResourceApplication resourceApplication = new ResourceApplication();
        resourceApplication.setCode("Code");
        resourceApplication.setId(123L);
        resourceApplication.setName("Name");
        resourceApplication.setTenantId(123L);
        when(this.resourceApplicationMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any()))
                .thenReturn(resourceApplication);
        this.resourceServiceImpl.loadResources(new ArrayList<>(), "Application Code");
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(List, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadResources10()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.creation.settings.CreationSettings, fieldName : mockSettings, write javaBean error, fastjson version 1.2.76, class com.diffblue.spring.isolation.framework.mocks.MockInvocationListener, fieldName : 0, write javaBean error, fastjson version 1.2.76, class org.mockito.codegen.ResourceMenuMapper$MockitoMock$1647981646, fieldName : 1, write javaBean error, fastjson version 1.2.76, class org.mockito.internal.handler.InvocationNotifierHandler, fieldName : mockHandler, write javaBean error, fastjson version 1.2.76, class com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper, fieldName : 0
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:541)
        //       at com.alibaba.fastjson.serializer.JavaBeanSerializer.write(JavaBeanSerializer.java:154)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.writeWithFieldName(JSONSerializer.java:360)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_4_MockMethodInterceptor.write(null)
        //       at com.alibaba.fastjson.serializer.ASMSerializer_3_ResourceMenu$MockitoMock$1214729020.write(null)
        //       at com.alibaba.fastjson.serializer.ListSerializer.write(ListSerializer.java:135)
        //       at com.alibaba.fastjson.serializer.JSONSerializer.write(JSONSerializer.java:312)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:793)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:731)
        //       at com.alibaba.fastjson.JSON.toJSONString(JSON.java:688)
        //       at mao.aggregate_pay_user_service.service.impl.ResourceServiceImpl.loadResources(ResourceServiceImpl.java:157)
        //   In order to prevent loadResources(List, String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadResources(List, String).
        //   See https://diff.blue/R013 to resolve this issue.

        ResourceMenu resourceMenu = mock(ResourceMenu.class);
        when(resourceMenu.getId()).thenReturn(Long.MIN_VALUE);
        when(resourceMenu.getApplicationCode()).thenReturn("Application Code");
        when(resourceMenu.getComment()).thenReturn("Comment");
        when(resourceMenu.getIcon()).thenReturn("Icon");
        doNothing().when(resourceMenu).setApplicationCode((String) any());
        doNothing().when(resourceMenu).setComment((String) any());
        doNothing().when(resourceMenu).setIcon((String) any());
        doNothing().when(resourceMenu).setId((Long) any());
        doNothing().when(resourceMenu).setParentId((Long) any());
        doNothing().when(resourceMenu).setPrivilegeCode((String) any());
        doNothing().when(resourceMenu).setSort((Integer) any());
        doNothing().when(resourceMenu).setStatus((Integer) any());
        doNothing().when(resourceMenu).setTitle((String) any());
        doNothing().when(resourceMenu).setUrl((String) any());
        resourceMenu.setApplicationCode("Application Code");
        resourceMenu.setComment("Comment");
        resourceMenu.setIcon("Icon");
        resourceMenu.setId(123L);
        resourceMenu.setParentId(123L);
        resourceMenu.setPrivilegeCode("Privilege Code");
        resourceMenu.setSort(1);
        resourceMenu.setStatus(1);
        resourceMenu.setTitle("Dr");
        resourceMenu.setUrl("https://example.org/example");

        ArrayList<ResourceMenu> resourceMenuList = new ArrayList<>();
        resourceMenuList.add(resourceMenu);
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(resourceMenuList);
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(new ArrayList<>());

        ResourceApplication resourceApplication = new ResourceApplication();
        resourceApplication.setCode("Code");
        resourceApplication.setId(123L);
        resourceApplication.setName("Name");
        resourceApplication.setTenantId(123L);
        when(this.resourceApplicationMapper
                .selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceApplication>) any()))
                .thenReturn(resourceApplication);
        this.resourceServiceImpl.loadResources(new ArrayList<>(), "Application Code");
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(Map)}
     */
    @Test
    void testLoadResources11()
    {
        assertThrows(BusinessException.class, () -> this.resourceServiceImpl.loadResources(new HashMap<>()));
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(Map)}
     */
    @Test
    void testLoadResources12()
    {
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(new ArrayList<>());
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(new ArrayList<>());

        AuthorizationInfoDTO authorizationInfoDTO = new AuthorizationInfoDTO();
        authorizationInfoDTO.setRolePrivilegeMap(new HashMap<>());

        HashMap<Long, AuthorizationInfoDTO> resultLongAuthorizationInfoDTOMap = new HashMap<>();
        resultLongAuthorizationInfoDTOMap.put(1L, authorizationInfoDTO);
        assertEquals(1, this.resourceServiceImpl.loadResources(resultLongAuthorizationInfoDTOMap).size());
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.resourceButtonMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(Map)}
     */
    @Test
    void testLoadResources13()
    {
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(new ArrayList<>());
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenThrow(new BusinessException());

        AuthorizationInfoDTO authorizationInfoDTO = new AuthorizationInfoDTO();
        authorizationInfoDTO.setRolePrivilegeMap(new HashMap<>());

        HashMap<Long, AuthorizationInfoDTO> resultLongAuthorizationInfoDTOMap = new HashMap<>();
        resultLongAuthorizationInfoDTOMap.put(1L, authorizationInfoDTO);
        assertThrows(BusinessException.class,
                () -> this.resourceServiceImpl.loadResources(resultLongAuthorizationInfoDTOMap));
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.resourceButtonMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(Map)}
     */
    @Test
    void testLoadResources14()
    {
        ResourceMenu resourceMenu = new ResourceMenu();
        resourceMenu.setApplicationCode("Application Code");
        resourceMenu.setComment("Comment");
        resourceMenu.setIcon("Icon");
        resourceMenu.setId(123L);
        resourceMenu.setParentId(123L);
        resourceMenu.setPrivilegeCode("Privilege Code");
        resourceMenu.setSort(1);
        resourceMenu.setStatus(1);
        resourceMenu.setTitle("Dr");
        resourceMenu.setUrl("https://example.org/example");

        ArrayList<ResourceMenu> resourceMenuList = new ArrayList<>();
        resourceMenuList.add(resourceMenu);
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(resourceMenuList);
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(new ArrayList<>());

        AuthorizationInfoDTO authorizationInfoDTO = new AuthorizationInfoDTO();
        authorizationInfoDTO.setRolePrivilegeMap(new HashMap<>());

        HashMap<Long, AuthorizationInfoDTO> resultLongAuthorizationInfoDTOMap = new HashMap<>();
        resultLongAuthorizationInfoDTOMap.put(1L, authorizationInfoDTO);
        Map<Long, List<ResourceDTO>> actualLoadResourcesResult = this.resourceServiceImpl
                .loadResources(resultLongAuthorizationInfoDTOMap);
        assertEquals(1, actualLoadResourcesResult.size());
        List<ResourceDTO> getResult = actualLoadResourcesResult.get(1L);
        assertEquals(1, getResult.size());
        ResourceDTO getResult1 = getResult.get(0);
        Map<String, Object> appRes = getResult1.getAppRes();
        assertEquals(1, appRes.size());
        assertEquals("Application Code", getResult1.getApplicationCode());
        assertEquals(1, ((Collection<ResourceMenu>) appRes.get("menu")).size());
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.resourceButtonMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(Map)}
     */
    @Test
    void testLoadResources15()
    {
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(new ArrayList<>());

        ResourceButton resourceButton = new ResourceButton();
        resourceButton.setApplicationCode("Application Code");
        resourceButton.setComment("Comment");
        resourceButton.setIcon("Icon");
        resourceButton.setId(123L);
        resourceButton.setParentId(123L);
        resourceButton.setPrivilegeCode("Privilege Code");
        resourceButton.setSort(1);
        resourceButton.setStatus(1);
        resourceButton.setTitle("Dr");
        resourceButton.setUrl("https://example.org/example");

        ArrayList<ResourceButton> resourceButtonList = new ArrayList<>();
        resourceButtonList.add(resourceButton);
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(resourceButtonList);

        AuthorizationInfoDTO authorizationInfoDTO = new AuthorizationInfoDTO();
        authorizationInfoDTO.setRolePrivilegeMap(new HashMap<>());

        HashMap<Long, AuthorizationInfoDTO> resultLongAuthorizationInfoDTOMap = new HashMap<>();
        resultLongAuthorizationInfoDTOMap.put(1L, authorizationInfoDTO);
        assertEquals(1, this.resourceServiceImpl.loadResources(resultLongAuthorizationInfoDTOMap).size());
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.resourceButtonMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(Map)}
     */
    @Test
    void testLoadResources16()
    {
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(new ArrayList<>());
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(new ArrayList<>());

        HashMap<String, List<String>> stringListMap = new HashMap<>();
        stringListMap.put("foo", new ArrayList<>());

        AuthorizationInfoDTO authorizationInfoDTO = new AuthorizationInfoDTO();
        authorizationInfoDTO.setRolePrivilegeMap(stringListMap);

        HashMap<Long, AuthorizationInfoDTO> resultLongAuthorizationInfoDTOMap = new HashMap<>();
        resultLongAuthorizationInfoDTOMap.put(1L, authorizationInfoDTO);
        assertEquals(1, this.resourceServiceImpl.loadResources(resultLongAuthorizationInfoDTOMap).size());
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.resourceButtonMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(Map)}
     */
    @Test
    void testLoadResources17()
    {
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(new ArrayList<>());

        ResourceButton resourceButton = new ResourceButton();
        resourceButton.setApplicationCode("Application Code");
        resourceButton.setComment("Comment");
        resourceButton.setIcon("Icon");
        resourceButton.setId(123L);
        resourceButton.setParentId(123L);
        resourceButton.setPrivilegeCode("Privilege Code");
        resourceButton.setSort(1);
        resourceButton.setStatus(1);
        resourceButton.setTitle("Dr");
        resourceButton.setUrl("https://example.org/example");

        ResourceButton resourceButton1 = new ResourceButton();
        resourceButton1.setApplicationCode("Application Code");
        resourceButton1.setComment("Comment");
        resourceButton1.setIcon("Icon");
        resourceButton1.setId(123L);
        resourceButton1.setParentId(123L);
        resourceButton1.setPrivilegeCode("Privilege Code");
        resourceButton1.setSort(1);
        resourceButton1.setStatus(1);
        resourceButton1.setTitle("Dr");
        resourceButton1.setUrl("https://example.org/example");

        ArrayList<ResourceButton> resourceButtonList = new ArrayList<>();
        resourceButtonList.add(resourceButton1);
        resourceButtonList.add(resourceButton);
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(resourceButtonList);

        AuthorizationInfoDTO authorizationInfoDTO = new AuthorizationInfoDTO();
        authorizationInfoDTO.setRolePrivilegeMap(new HashMap<>());

        HashMap<Long, AuthorizationInfoDTO> resultLongAuthorizationInfoDTOMap = new HashMap<>();
        resultLongAuthorizationInfoDTOMap.put(1L, authorizationInfoDTO);
        assertEquals(1, this.resourceServiceImpl.loadResources(resultLongAuthorizationInfoDTOMap).size());
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.resourceButtonMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any());
    }

    /**
     * Method under test: {@link ResourceServiceImpl#loadResources(Map)}
     */
    @Test
    void testLoadResources18()
    {
        ResourceMenu resourceMenu = new ResourceMenu();
        resourceMenu.setApplicationCode("Application Code");
        resourceMenu.setComment("Comment");
        resourceMenu.setIcon("Icon");
        resourceMenu.setId(123L);
        resourceMenu.setParentId(123L);
        resourceMenu.setPrivilegeCode("Privilege Code");
        resourceMenu.setSort(1);
        resourceMenu.setStatus(1);
        resourceMenu.setTitle("Dr");
        resourceMenu.setUrl("https://example.org/example");

        ArrayList<ResourceMenu> resourceMenuList = new ArrayList<>();
        resourceMenuList.add(resourceMenu);
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(resourceMenuList);

        ResourceButton resourceButton = new ResourceButton();
        resourceButton.setApplicationCode("Application Code");
        resourceButton.setComment("Comment");
        resourceButton.setIcon("Icon");
        resourceButton.setId(123L);
        resourceButton.setParentId(123L);
        resourceButton.setPrivilegeCode("Privilege Code");
        resourceButton.setSort(1);
        resourceButton.setStatus(1);
        resourceButton.setTitle("Dr");
        resourceButton.setUrl("https://example.org/example");

        ArrayList<ResourceButton> resourceButtonList = new ArrayList<>();
        resourceButtonList.add(resourceButton);
        when(this.resourceButtonMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any()))
                .thenReturn(resourceButtonList);

        AuthorizationInfoDTO authorizationInfoDTO = new AuthorizationInfoDTO();
        authorizationInfoDTO.setRolePrivilegeMap(new HashMap<>());

        HashMap<Long, AuthorizationInfoDTO> resultLongAuthorizationInfoDTOMap = new HashMap<>();
        resultLongAuthorizationInfoDTOMap.put(1L, authorizationInfoDTO);
        Map<Long, List<ResourceDTO>> actualLoadResourcesResult = this.resourceServiceImpl
                .loadResources(resultLongAuthorizationInfoDTOMap);
        assertEquals(1, actualLoadResourcesResult.size());
        List<ResourceDTO> getResult = actualLoadResourcesResult.get(1L);
        assertEquals(1, getResult.size());
        ResourceDTO getResult1 = getResult.get(0);
        Map<String, Object> appRes = getResult1.getAppRes();
        assertEquals(2, appRes.size());
        assertEquals("Application Code", getResult1.getApplicationCode());
        assertEquals(1, ((Collection<ResourceButton>) appRes.get("button")).size());
        assertEquals(1, ((Collection<ResourceMenu>) appRes.get("menu")).size());
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.resourceButtonMapper)
                .selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceButton>) any());
    }
}

