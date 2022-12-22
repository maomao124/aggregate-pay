package mao.sms_manage.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mao.sms_dao.mapper.TemplateMapper;
import mao.sms_entity.dto.TemplateDTO;
import mao.sms_entity.entity.TemplateEntity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TemplateServiceImpl.class})
@ExtendWith(SpringExtension.class)
class TemplateServiceImplTest
{
    @MockBean
    private TemplateMapper templateMapper;

    @Autowired
    private TemplateServiceImpl templateServiceImpl;

    /**
     * Method under test: {@link TemplateServiceImpl#getNextCode()}
     */
    @Test
    void testGetNextCode()
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
        when(this.templateMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TemplateEntity>) any()))
                .thenReturn(templateEntity);
        assertEquals("DXMB_000000001", this.templateServiceImpl.getNextCode());
        verify(this.templateMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TemplateEntity>) any());
    }

    /**
     * Method under test: {@link TemplateServiceImpl#customPage(Page, java.util.Map)}
     */
    @Test
    void testCustomPage()
    {
        Page<TemplateDTO> page = new Page<>();
        when(this.templateMapper.custom((Page<TemplateDTO>) any(), (java.util.Map<?, ?>) any())).thenReturn(page);
        Page<TemplateDTO> page1 = new Page<>();
        IPage<TemplateDTO> actualCustomPageResult = this.templateServiceImpl.customPage(page1, new HashMap<>());
        assertSame(page, actualCustomPageResult);
        verify(this.templateMapper).custom((Page<TemplateDTO>) any(), (java.util.Map<?, ?>) any());
        List<TemplateDTO> expectedRecords = actualCustomPageResult.getRecords();
        assertSame(expectedRecords, page1.getRecords());
    }

    /**
     * Method under test: {@link TemplateServiceImpl#customPage(Page, java.util.Map)}
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
        //       at mao.sms_manage.service.impl.TemplateServiceImpl.customPage(TemplateServiceImpl.java:59)
        //   In order to prevent customPage(Page, Map)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   customPage(Page, Map).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.templateMapper.custom((Page<TemplateDTO>) any(), (java.util.Map<?, ?>) any())).thenReturn(null);
        Page<TemplateDTO> page = new Page<>();
        this.templateServiceImpl.customPage(page, new HashMap<>());
    }

    /**
     * Method under test: {@link TemplateServiceImpl#customPage(Page, java.util.Map)}
     */
    @Test
    void testCustomPage3()
    {
        IPage<TemplateDTO> iPage = (IPage<TemplateDTO>) mock(IPage.class);
        when(iPage.getRecords()).thenReturn(new ArrayList<>());
        when(this.templateMapper.custom((Page<TemplateDTO>) any(), (java.util.Map<?, ?>) any())).thenReturn(iPage);
        Page<TemplateDTO> page = new Page<>();
        this.templateServiceImpl.customPage(page, new HashMap<>());
        verify(this.templateMapper).custom((Page<TemplateDTO>) any(), (java.util.Map<?, ?>) any());
        verify(iPage).getRecords();
        assertTrue(page.getRecords().isEmpty());
    }

    /**
     * Method under test: {@link TemplateServiceImpl#customPage(Page, java.util.Map)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCustomPage4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.service.impl.TemplateServiceImpl.customPage(TemplateServiceImpl.java:59)
        //   In order to prevent customPage(Page, Map)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   customPage(Page, Map).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.templateMapper.custom((Page<TemplateDTO>) any(), (java.util.Map<?, ?>) any()))
                .thenReturn((IPage<TemplateDTO>) mock(IPage.class));
        this.templateServiceImpl.customPage(null, new HashMap<>());
    }

    /**
     * Method under test: {@link TemplateServiceImpl#customPage(Page, java.util.Map)}
     */
    @Test
    void testCustomPage5()
    {
        IPage<TemplateDTO> iPage = (IPage<TemplateDTO>) mock(IPage.class);
        when(iPage.getRecords()).thenReturn(new ArrayList<>());
        when(this.templateMapper.custom((Page<TemplateDTO>) any(), (java.util.Map<?, ?>) any())).thenReturn(iPage);
        new IllegalArgumentException("foo");
        Page<TemplateDTO> page = (Page<TemplateDTO>) mock(Page.class);
        when(page.setRecords((List<TemplateDTO>) any())).thenReturn(new Page<>());
        this.templateServiceImpl.customPage(page, new HashMap<>());
        verify(this.templateMapper).custom((Page<TemplateDTO>) any(), (java.util.Map<?, ?>) any());
        verify(iPage).getRecords();
        verify(page).setRecords((List<TemplateDTO>) any());
    }

    /**
     * Method under test: {@link TemplateServiceImpl#customList(java.util.Map)}
     */
    @Test
    void testCustomList()
    {
        ArrayList<TemplateDTO> templateDTOList = new ArrayList<>();
        when(this.templateMapper.custom((java.util.Map<?, ?>) any())).thenReturn(templateDTOList);
        List<TemplateDTO> actualCustomListResult = this.templateServiceImpl.customList(new HashMap<>());
        assertSame(templateDTOList, actualCustomListResult);
        assertTrue(actualCustomListResult.isEmpty());
        verify(this.templateMapper).custom((java.util.Map<?, ?>) any());
    }

    /**
     * Method under test: {@link TemplateServiceImpl#customList(java.util.Map)}
     */
    @Test
    void testCustomList2()
    {
        when(this.templateMapper.custom((java.util.Map<?, ?>) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> this.templateServiceImpl.customList(new HashMap<>()));
        verify(this.templateMapper).custom((java.util.Map<?, ?>) any());
    }

    /**
     * Method under test: {@link TemplateServiceImpl#getByCode(String)}
     */
    @Test
    void testGetByCode()
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
        when(this.templateMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TemplateEntity>) any()))
                .thenReturn(templateEntity);
        assertSame(templateEntity, this.templateServiceImpl.getByCode("Code"));
        verify(this.templateMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TemplateEntity>) any());
    }

    /**
     * Method under test: {@link TemplateServiceImpl#getByCode(String)}
     */
    @Test
    void testGetByCode2()
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
        when(this.templateMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TemplateEntity>) any()))
                .thenReturn(templateEntity);
        assertSame(templateEntity, this.templateServiceImpl.getByCode(""));
        verify(this.templateMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TemplateEntity>) any());
    }

    /**
     * Method under test: {@link TemplateServiceImpl#getByCode(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetByCode3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: foo
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.getOne(ServiceImpl.java:254)
        //       at com.baomidou.mybatisplus.extension.service.IService.getOne(IService.java:192)
        //       at mao.sms_manage.service.impl.TemplateServiceImpl.getByCode(TemplateServiceImpl.java:72)
        //   In order to prevent getByCode(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getByCode(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.templateMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TemplateEntity>) any()))
                .thenThrow(new IllegalArgumentException("foo"));
        this.templateServiceImpl.getByCode("Code");
    }

    /**
     * Method under test: {@link TemplateServiceImpl#getByName(String)}
     */
    @Test
    void testGetByName()
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
        when(this.templateMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TemplateEntity>) any()))
                .thenReturn(templateEntity);
        assertSame(templateEntity, this.templateServiceImpl.getByName("Name"));
        verify(this.templateMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TemplateEntity>) any());
    }

    /**
     * Method under test: {@link TemplateServiceImpl#getByName(String)}
     */
    @Test
    void testGetByName2()
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
        when(this.templateMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TemplateEntity>) any()))
                .thenReturn(templateEntity);
        assertSame(templateEntity, this.templateServiceImpl.getByName(""));
        verify(this.templateMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TemplateEntity>) any());
    }

    /**
     * Method under test: {@link TemplateServiceImpl#getByName(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetByName3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: foo
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.getOne(ServiceImpl.java:254)
        //       at com.baomidou.mybatisplus.extension.service.IService.getOne(IService.java:192)
        //       at mao.sms_manage.service.impl.TemplateServiceImpl.getByName(TemplateServiceImpl.java:78)
        //   In order to prevent getByName(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getByName(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.templateMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<TemplateEntity>) any()))
                .thenThrow(new IllegalArgumentException("foo"));
        this.templateServiceImpl.getByName("Name");
    }
}

