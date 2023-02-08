package mao.aggregate_pay_merchant_service.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;

import mao.aggregate_pay_common.domain.PageVO;

import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_service.entity.Staff;
import mao.aggregate_pay_merchant_service.mapper.StaffMapper;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StaffServiceImpl.class})
@ExtendWith(SpringExtension.class)
class StaffServiceImplTest
{
    @MockBean
    private DozerUtils dozerUtils;

    @MockBean
    private StaffMapper staffMapper;

    @Autowired
    private StaffServiceImpl staffServiceImpl;

    /**
     * Method under test: {@link StaffServiceImpl#queryStaffByPage(StaffDTO, Integer, Integer)}
     */
    @Test
    void testQueryStaffByPage()
    {
        when(this.staffMapper.selectPage((IPage<Staff>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any())).thenReturn(new Page<>());
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        PageVO<StaffDTO> actualQueryStaffByPageResult = this.staffServiceImpl.queryStaffByPage(staffDTO, 1, 3);
        assertEquals(0L, actualQueryStaffByPageResult.getCounts());
        assertFalse(actualQueryStaffByPageResult.isFirst());
        assertFalse(actualQueryStaffByPageResult.hasItems());
        assertEquals(3, actualQueryStaffByPageResult.getPageSize());
        verify(this.staffMapper).selectPage((IPage<Staff>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
    }

    /**
     * Method under test: {@link StaffServiceImpl#queryStaffByPage(StaffDTO, Integer, Integer)}
     */
    @Test
    void testQueryStaffByPage2()
    {
        when(this.staffMapper.selectPage((IPage<Staff>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any())).thenReturn(new Page<>());
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenThrow(new IllegalArgumentException("foo"));

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        assertThrows(IllegalArgumentException.class, () -> this.staffServiceImpl.queryStaffByPage(staffDTO, 1, 3));
        verify(this.staffMapper).selectPage((IPage<Staff>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
    }

    /**
     * Method under test: {@link StaffServiceImpl#queryStaffByPage(StaffDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryStaffByPage3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.StaffServiceImpl.queryStaffByPage(StaffServiceImpl.java:54)
        //   In order to prevent queryStaffByPage(StaffDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStaffByPage(StaffDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.staffMapper.selectPage((com.baomidou.mybatisplus.core.metadata.IPage<Staff>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any())).thenReturn(null);
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        this.staffServiceImpl.queryStaffByPage(staffDTO, 1, 3);
    }

    /**
     * Method under test: {@link StaffServiceImpl#queryStaffByPage(StaffDTO, Integer, Integer)}
     */
    @Test
    void testQueryStaffByPage4()
    {
        Page<Staff> page = (Page<Staff>) mock(Page.class);
        when(page.getRecords()).thenReturn(new ArrayList<>());
        when(page.getTotal()).thenReturn(1L);
        when(this.staffMapper.selectPage((IPage<Staff>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any())).thenReturn(page);
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        PageVO<StaffDTO> actualQueryStaffByPageResult = this.staffServiceImpl.queryStaffByPage(staffDTO, 1, 3);
        assertEquals(1L, actualQueryStaffByPageResult.getCounts());
        assertFalse(actualQueryStaffByPageResult.isFirst());
        assertFalse(actualQueryStaffByPageResult.hasItems());
        assertEquals(3, actualQueryStaffByPageResult.getPageSize());
        verify(this.staffMapper).selectPage((IPage<Staff>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any());
        verify(page).getRecords();
        verify(page).getTotal();
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
    }

    /**
     * Method under test: {@link StaffServiceImpl#queryStaffByPage(StaffDTO, Integer, Integer)}
     */
    @Test
    void testQueryStaffByPage5()
    {
        Page<Staff> page = (Page<Staff>) mock(Page.class);
        when(page.getRecords()).thenReturn(new ArrayList<>());
        when(page.getTotal()).thenReturn(1L);
        when(this.staffMapper.selectPage((IPage<Staff>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any())).thenReturn(page);
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(null);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        PageVO<StaffDTO> actualQueryStaffByPageResult = this.staffServiceImpl.queryStaffByPage(staffDTO, 1, 3);
        assertEquals(1L, actualQueryStaffByPageResult.getCounts());
        assertFalse(actualQueryStaffByPageResult.isFirst());
        assertFalse(actualQueryStaffByPageResult.hasItems());
        assertEquals(3, actualQueryStaffByPageResult.getPageSize());
        verify(this.staffMapper).selectPage((IPage<Staff>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any());
        verify(page).getRecords();
        verify(page).getTotal();
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
    }

    /**
     * Method under test: {@link StaffServiceImpl#queryStaffByPage(StaffDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryStaffByPage6()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.StaffServiceImpl.queryStaffByPage(StaffServiceImpl.java:46)
        //   In order to prevent queryStaffByPage(StaffDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStaffByPage(StaffDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.staffMapper.selectPage((com.baomidou.mybatisplus.core.metadata.IPage<Staff>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any())).thenReturn((Page<Staff>) mock(Page.class));
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(null);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        this.staffServiceImpl.queryStaffByPage(staffDTO, null, 3);
    }

    /**
     * Method under test: {@link StaffServiceImpl#queryStaffByPage(StaffDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryStaffByPage7()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.StaffServiceImpl.queryStaffByPage(StaffServiceImpl.java:46)
        //   In order to prevent queryStaffByPage(StaffDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStaffByPage(StaffDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.staffMapper.selectPage((com.baomidou.mybatisplus.core.metadata.IPage<Staff>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any())).thenReturn((Page<Staff>) mock(Page.class));
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(null);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        this.staffServiceImpl.queryStaffByPage(staffDTO, 1, null);
    }

    /**
     * Method under test: {@link StaffServiceImpl#queryStaffByPage(StaffDTO, Integer, Integer)}
     */
    @Test
    void testQueryStaffByPage8()
    {
        Page<Staff> page = (Page<Staff>) mock(Page.class);
        when(page.getRecords()).thenReturn(new ArrayList<>());
        when(page.getTotal()).thenReturn(1L);
        when(this.staffMapper.selectPage((IPage<Staff>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any())).thenReturn(page);
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenReturn(new ArrayList<>());

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(null);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        PageVO<StaffDTO> actualQueryStaffByPageResult = this.staffServiceImpl.queryStaffByPage(staffDTO, 5, 3);
        assertEquals(1L, actualQueryStaffByPageResult.getCounts());
        assertFalse(actualQueryStaffByPageResult.isFirst());
        assertFalse(actualQueryStaffByPageResult.hasItems());
        assertEquals(3, actualQueryStaffByPageResult.getPageSize());
        verify(this.staffMapper).selectPage((IPage<Staff>) any(),
                (com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any());
        verify(page).getRecords();
        verify(page).getTotal();
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
    }

    /**
     * Method under test: {@link StaffServiceImpl#saveStaff(StaffDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveStaff()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 手机号已经存在
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_merchant_service.service.impl.StaffServiceImpl.saveStaff(StaffServiceImpl.java:76)
        //   In order to prevent saveStaff(StaffDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   saveStaff(StaffDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.staffMapper.insert((mao.aggregate_pay_merchant_service.entity.Staff) any())).thenReturn(1);
        when(this.staffMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_merchant_service.entity.Staff>) any()))
                .thenReturn(3);

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        this.staffServiceImpl.saveStaff(staffDTO);
    }

    /**
     * Method under test: {@link StaffServiceImpl#saveStaff(StaffDTO)}
     */
    @Test
    void testSaveStaff2()
    {
        when(this.staffMapper.insert((Staff) any())).thenReturn(1);
        when(this.staffMapper.selectCount((com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any())).thenReturn(0);
        when(this.dozerUtils.map((Object) any(), (Class<Staff>) any())).thenReturn(new Staff());
        doNothing().when(this.dozerUtils).map((Object) any(), (Object) any());

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        assertSame(staffDTO, this.staffServiceImpl.saveStaff(staffDTO));
        verify(this.staffMapper).insert((Staff) any());
        verify(this.staffMapper, atLeast(1)).selectCount((com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any());
        verify(this.dozerUtils).map((Object) any(), (Class<Staff>) any());
        verify(this.dozerUtils).map((Object) any(), (Object) any());
    }

    /**
     * Method under test: {@link StaffServiceImpl#saveStaff(StaffDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveStaff3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 员工信息保存失败
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_merchant_service.service.impl.StaffServiceImpl.saveStaff(StaffServiceImpl.java:90)
        //   In order to prevent saveStaff(StaffDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   saveStaff(StaffDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.staffMapper.insert((Staff) any())).thenReturn(0);
        when(this.staffMapper.selectCount((com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any())).thenReturn(0);
        when(this.dozerUtils.map((Object) any(), (Class<Staff>) any())).thenReturn(new Staff());
        doNothing().when(this.dozerUtils).map((Object) any(), (Object) any());

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        this.staffServiceImpl.saveStaff(staffDTO);
    }

    /**
     * Method under test: {@link StaffServiceImpl#saveStaff(StaffDTO)}
     */
    @Test
    void testSaveStaff4()
    {
        when(this.staffMapper.insert((Staff) any())).thenReturn(1);
        when(this.staffMapper.selectCount((com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any())).thenReturn(0);
        when(this.dozerUtils.map((Object) any(), (Class<Staff>) any())).thenReturn(new Staff());
        doNothing().when(this.dozerUtils).map((Object) any(), (Object) any());
        StaffDTO staffDTO = mock(StaffDTO.class);
        when(staffDTO.getMerchantId()).thenReturn(123L);
        when(staffDTO.getMobile()).thenReturn("");
        when(staffDTO.getUsername()).thenReturn("janedoe");
        doNothing().when(staffDTO).setFullName((String) any());
        doNothing().when(staffDTO).setFullname((String) any());
        doNothing().when(staffDTO).setId((Long) any());
        doNothing().when(staffDTO).setLastLoginTime((LocalDateTime) any());
        doNothing().when(staffDTO).setMerchantId((Long) any());
        doNothing().when(staffDTO).setMobile((String) any());
        doNothing().when(staffDTO).setPosition((String) any());
        doNothing().when(staffDTO).setStaffStatus((Boolean) any());
        doNothing().when(staffDTO).setStoreId((Long) any());
        doNothing().when(staffDTO).setUsername((String) any());
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        this.staffServiceImpl.saveStaff(staffDTO);
        verify(this.staffMapper).insert((Staff) any());
        verify(this.staffMapper, atLeast(1)).selectCount((com.baomidou.mybatisplus.core.conditions.Wrapper<Staff>) any());
        verify(this.dozerUtils).map((Object) any(), (Class<Object>) any());
        verify(this.dozerUtils).map((Object) any(), (Object) any());
        verify(staffDTO, atLeast(1)).getMerchantId();
        verify(staffDTO).getMobile();
        verify(staffDTO).getUsername();
        verify(staffDTO).setFullName((String) any());
        verify(staffDTO).setFullname((String) any());
        verify(staffDTO).setId((Long) any());
        verify(staffDTO).setLastLoginTime((LocalDateTime) any());
        verify(staffDTO).setMerchantId((Long) any());
        verify(staffDTO).setMobile((String) any());
        verify(staffDTO).setPosition((String) any());
        verify(staffDTO).setStaffStatus((Boolean) any());
        verify(staffDTO).setStoreId((Long) any());
        verify(staffDTO).setUsername((String) any());
    }

    /**
     * Method under test: {@link StaffServiceImpl#updateStaff(StaffDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateStaff()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 功能未实现
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_merchant_service.service.impl.StaffServiceImpl.updateStaff(StaffServiceImpl.java:133)
        //   In order to prevent updateStaff(StaffDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateStaff(StaffDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        this.staffServiceImpl.updateStaff(staffDTO);
    }

    /**
     * Method under test: {@link StaffServiceImpl#updateStaff(StaffDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateStaff2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 功能未实现
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_merchant_service.service.impl.StaffServiceImpl.updateStaff(StaffServiceImpl.java:133)
        //   In order to prevent updateStaff(StaffDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateStaff(StaffDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        StaffDTO staffDTO = mock(StaffDTO.class);
        doNothing().when(staffDTO).setFullName((String) any());
        doNothing().when(staffDTO).setFullname((String) any());
        doNothing().when(staffDTO).setId((Long) any());
        doNothing().when(staffDTO).setLastLoginTime((LocalDateTime) any());
        doNothing().when(staffDTO).setMerchantId((Long) any());
        doNothing().when(staffDTO).setMobile((String) any());
        doNothing().when(staffDTO).setPosition((String) any());
        doNothing().when(staffDTO).setStaffStatus((Boolean) any());
        doNothing().when(staffDTO).setStoreId((Long) any());
        doNothing().when(staffDTO).setUsername((String) any());
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        this.staffServiceImpl.updateStaff(staffDTO);
    }

    /**
     * Method under test: {@link StaffServiceImpl#deleteStaff(StaffDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteStaff()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 当前员工不属于当前商户
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_merchant_service.service.impl.StaffServiceImpl.deleteStaff(StaffServiceImpl.java:154)
        //   In order to prevent deleteStaff(StaffDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deleteStaff(StaffDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.staffMapper.selectById((java.io.Serializable) any())).thenReturn(new Staff());

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        this.staffServiceImpl.deleteStaff(staffDTO);
    }

    /**
     * Method under test: {@link StaffServiceImpl#deleteStaff(StaffDTO)}
     */
    @Test
    void testDeleteStaff2()
    {
        Staff staff = new Staff();
        staff.setMerchantId(123L);
        when(this.staffMapper.deleteById((java.io.Serializable) any())).thenReturn(123);
        when(this.staffMapper.selectById((java.io.Serializable) any())).thenReturn(staff);

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        assertTrue(this.staffServiceImpl.deleteStaff(staffDTO));
        verify(this.staffMapper).deleteById((java.io.Serializable) any());
        verify(this.staffMapper).selectById((java.io.Serializable) any());
    }

    /**
     * Method under test: {@link StaffServiceImpl#deleteStaff(StaffDTO)}
     */
    @Test
    void testDeleteStaff3()
    {
        Staff staff = new Staff();
        staff.setMerchantId(123L);
        when(this.staffMapper.deleteById((java.io.Serializable) any())).thenReturn(0);
        when(this.staffMapper.selectById((java.io.Serializable) any())).thenReturn(staff);

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        assertTrue(this.staffServiceImpl.deleteStaff(staffDTO));
        verify(this.staffMapper).deleteById((java.io.Serializable) any());
        verify(this.staffMapper).selectById((java.io.Serializable) any());
    }

    /**
     * Method under test: {@link StaffServiceImpl#deleteStaff(StaffDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteStaff4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.StaffServiceImpl.deleteStaff(StaffServiceImpl.java:152)
        //   In order to prevent deleteStaff(StaffDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deleteStaff(StaffDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        Staff staff = new Staff();
        staff.setMerchantId(123L);
        when(this.staffMapper.deleteById((java.io.Serializable) any())).thenReturn(123);
        when(this.staffMapper.selectById((java.io.Serializable) any())).thenReturn(staff);

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(null);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        this.staffServiceImpl.deleteStaff(staffDTO);
    }

    /**
     * Method under test: {@link StaffServiceImpl#deleteStaff(StaffDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteStaff5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: foo
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.removeById(ServiceImpl.java:186)
        //       at mao.aggregate_pay_merchant_service.service.impl.StaffServiceImpl.deleteStaff(StaffServiceImpl.java:157)
        //   In order to prevent deleteStaff(StaffDTO)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deleteStaff(StaffDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        Staff staff = new Staff();
        staff.setMerchantId(123L);
        when(this.staffMapper.deleteById((java.io.Serializable) any())).thenThrow(new IllegalArgumentException("foo"));
        when(this.staffMapper.selectById((java.io.Serializable) any())).thenReturn(staff);

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        this.staffServiceImpl.deleteStaff(staffDTO);
    }
}

