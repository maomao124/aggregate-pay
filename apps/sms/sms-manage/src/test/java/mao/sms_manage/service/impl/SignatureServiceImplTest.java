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

import mao.sms_dao.mapper.SignatureMapper;
import mao.sms_entity.dto.SignatureDTO;
import mao.sms_entity.entity.SignatureEntity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SignatureServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SignatureServiceImplTest
{
    @MockBean
    private SignatureMapper signatureMapper;

    @Autowired
    private SignatureServiceImpl signatureServiceImpl;

    /**
     * Method under test: {@link SignatureServiceImpl#getNextCode()}
     */
    @Test
    void testGetNextCode()
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
        when(this.signatureMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<SignatureEntity>) any()))
                .thenReturn(signatureEntity);
        assertEquals("DXQM_000000001", this.signatureServiceImpl.getNextCode());
        verify(this.signatureMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<SignatureEntity>) any());
    }

    /**
     * Method under test: {@link SignatureServiceImpl#customPage(Page, java.util.Map)}
     */
    @Test
    void testCustomPage()
    {
        Page<SignatureDTO> page = new Page<>();
        when(this.signatureMapper.custom((Page<SignatureDTO>) any(), (java.util.Map<?, ?>) any())).thenReturn(page);
        Page<SignatureDTO> page1 = new Page<>();
        IPage<SignatureDTO> actualCustomPageResult = this.signatureServiceImpl.customPage(page1, new HashMap<>());
        assertSame(page, actualCustomPageResult);
        verify(this.signatureMapper).custom((Page<SignatureDTO>) any(), (java.util.Map<?, ?>) any());
        List<SignatureDTO> expectedRecords = actualCustomPageResult.getRecords();
        assertSame(expectedRecords, page1.getRecords());
    }

    /**
     * Method under test: {@link SignatureServiceImpl#customPage(Page, java.util.Map)}
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
        //       at mao.sms_manage.service.impl.SignatureServiceImpl.customPage(SignatureServiceImpl.java:59)
        //   In order to prevent customPage(Page, Map)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   customPage(Page, Map).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.signatureMapper.custom((Page<SignatureDTO>) any(), (java.util.Map<?, ?>) any())).thenReturn(null);
        Page<SignatureDTO> page = new Page<>();
        this.signatureServiceImpl.customPage(page, new HashMap<>());
    }

    /**
     * Method under test: {@link SignatureServiceImpl#customPage(Page, java.util.Map)}
     */
    @Test
    void testCustomPage3()
    {
        IPage<SignatureDTO> iPage = (IPage<SignatureDTO>) mock(IPage.class);
        when(iPage.getRecords()).thenReturn(new ArrayList<>());
        when(this.signatureMapper.custom((Page<SignatureDTO>) any(), (java.util.Map<?, ?>) any())).thenReturn(iPage);
        Page<SignatureDTO> page = new Page<>();
        this.signatureServiceImpl.customPage(page, new HashMap<>());
        verify(this.signatureMapper).custom((Page<SignatureDTO>) any(), (java.util.Map<?, ?>) any());
        verify(iPage).getRecords();
        assertTrue(page.getRecords().isEmpty());
    }

    /**
     * Method under test: {@link SignatureServiceImpl#customPage(Page, java.util.Map)}
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
        //       at mao.sms_manage.service.impl.SignatureServiceImpl.customPage(SignatureServiceImpl.java:59)
        //   In order to prevent customPage(Page, Map)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   customPage(Page, Map).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.signatureMapper.custom((Page<SignatureDTO>) any(), (java.util.Map<?, ?>) any()))
                .thenReturn((IPage<SignatureDTO>) mock(IPage.class));
        this.signatureServiceImpl.customPage(null, new HashMap<>());
    }

    /**
     * Method under test: {@link SignatureServiceImpl#customPage(Page, java.util.Map)}
     */
    @Test
    void testCustomPage5()
    {
        IPage<SignatureDTO> iPage = (IPage<SignatureDTO>) mock(IPage.class);
        when(iPage.getRecords()).thenReturn(new ArrayList<>());
        when(this.signatureMapper.custom((Page<SignatureDTO>) any(), (java.util.Map<?, ?>) any())).thenReturn(iPage);
        new IllegalArgumentException("foo");
        Page<SignatureDTO> page = (Page<SignatureDTO>) mock(Page.class);
        when(page.setRecords((List<SignatureDTO>) any())).thenReturn(new Page<>());
        this.signatureServiceImpl.customPage(page, new HashMap<>());
        verify(this.signatureMapper).custom((Page<SignatureDTO>) any(), (java.util.Map<?, ?>) any());
        verify(iPage).getRecords();
        verify(page).setRecords((List<SignatureDTO>) any());
    }

    /**
     * Method under test: {@link SignatureServiceImpl#customList(java.util.Map)}
     */
    @Test
    void testCustomList()
    {
        ArrayList<SignatureDTO> signatureDTOList = new ArrayList<>();
        when(this.signatureMapper.custom((java.util.Map<?, ?>) any())).thenReturn(signatureDTOList);
        List<SignatureDTO> actualCustomListResult = this.signatureServiceImpl.customList(new HashMap<>());
        assertSame(signatureDTOList, actualCustomListResult);
        assertTrue(actualCustomListResult.isEmpty());
        verify(this.signatureMapper).custom((java.util.Map<?, ?>) any());
    }

    /**
     * Method under test: {@link SignatureServiceImpl#customList(java.util.Map)}
     */
    @Test
    void testCustomList2()
    {
        when(this.signatureMapper.custom((java.util.Map<?, ?>) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> this.signatureServiceImpl.customList(new HashMap<>()));
        verify(this.signatureMapper).custom((java.util.Map<?, ?>) any());
    }

    /**
     * Method under test: {@link SignatureServiceImpl#getByCode(String)}
     */
    @Test
    void testGetByCode()
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
        when(this.signatureMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<SignatureEntity>) any()))
                .thenReturn(signatureEntity);
        assertSame(signatureEntity, this.signatureServiceImpl.getByCode("Code"));
        verify(this.signatureMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<SignatureEntity>) any());
    }

    /**
     * Method under test: {@link SignatureServiceImpl#getByCode(String)}
     */
    @Test
    void testGetByCode2()
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
        when(this.signatureMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<SignatureEntity>) any()))
                .thenReturn(signatureEntity);
        assertSame(signatureEntity, this.signatureServiceImpl.getByCode(""));
        verify(this.signatureMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<SignatureEntity>) any());
    }

    /**
     * Method under test: {@link SignatureServiceImpl#getByCode(String)}
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
        //       at mao.sms_manage.service.impl.SignatureServiceImpl.getByCode(SignatureServiceImpl.java:72)
        //   In order to prevent getByCode(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getByCode(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.signatureMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<SignatureEntity>) any()))
                .thenThrow(new IllegalArgumentException("foo"));
        this.signatureServiceImpl.getByCode("Code");
    }

    /**
     * Method under test: {@link SignatureServiceImpl#getByName(String)}
     */
    @Test
    void testGetByName()
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
        when(this.signatureMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<SignatureEntity>) any()))
                .thenReturn(signatureEntity);
        assertSame(signatureEntity, this.signatureServiceImpl.getByName("Name"));
        verify(this.signatureMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<SignatureEntity>) any());
    }

    /**
     * Method under test: {@link SignatureServiceImpl#getByName(String)}
     */
    @Test
    void testGetByName2()
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
        when(this.signatureMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<SignatureEntity>) any()))
                .thenReturn(signatureEntity);
        assertSame(signatureEntity, this.signatureServiceImpl.getByName(""));
        verify(this.signatureMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<SignatureEntity>) any());
    }

    /**
     * Method under test: {@link SignatureServiceImpl#getByName(String)}
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
        //       at mao.sms_manage.service.impl.SignatureServiceImpl.getByName(SignatureServiceImpl.java:78)
        //   In order to prevent getByName(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getByName(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.signatureMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<SignatureEntity>) any()))
                .thenThrow(new IllegalArgumentException("foo"));
        this.signatureServiceImpl.getByName("Name");
    }
}

