package mao.aggregate_pay_merchant_service.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_service.entity.Staff;
import mao.aggregate_pay_merchant_service.entity.Store;
import mao.aggregate_pay_merchant_service.mapper.StoreMapper;
import mao.aggregate_pay_merchant_service.service.StaffService;
import mao.aggregate_pay_merchant_service.service.StoreStaffService;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StoreServiceImpl.class})
@ExtendWith(SpringExtension.class)
class StoreServiceImplTest
{
    @MockBean
    private DozerUtils dozerUtils;

    @MockBean
    private StaffService staffService;

    @MockBean
    private StoreMapper storeMapper;

    @Autowired
    private StoreServiceImpl storeServiceImpl;

    @MockBean
    private StoreStaffService storeStaffService;

    /**
     * Method under test: {@link StoreServiceImpl#queryStoreInMerchant(Long, Long)}
     */
    @Test
    void testQueryStoreInMerchant()
    {
        when(this.storeMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_merchant_service.entity.Store>) any()))
                .thenReturn(3);
        R<Boolean> actualQueryStoreInMerchantResult = this.storeServiceImpl.queryStoreInMerchant(123L, 123L);
        assertEquals(0, actualQueryStoreInMerchantResult.getCode());
        assertEquals("ok", actualQueryStoreInMerchantResult.getMsg());
        assertTrue(actualQueryStoreInMerchantResult.getData());
        verify(this.storeMapper).selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_merchant_service.entity.Store>) any());
    }

    /**
     * Method under test: {@link StoreServiceImpl#queryStoreInMerchant(Long, Long)}
     */
    @Test
    void testQueryStoreInMerchant2()
    {
        when(this.storeMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_merchant_service.entity.Store>) any()))
                .thenReturn(0);
        R<Boolean> actualQueryStoreInMerchantResult = this.storeServiceImpl.queryStoreInMerchant(123L, 123L);
        assertEquals(0, actualQueryStoreInMerchantResult.getCode());
        assertEquals("ok", actualQueryStoreInMerchantResult.getMsg());
        assertFalse(actualQueryStoreInMerchantResult.getData());
        verify(this.storeMapper).selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_merchant_service.entity.Store>) any());
    }

    /**
     * Method under test: {@link StoreServiceImpl#queryStoreInMerchant(Long, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryStoreInMerchant3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: An error occurred
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.count(ServiceImpl.java:266)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.queryStoreInMerchant(StoreServiceImpl.java:53)
        //   In order to prevent queryStoreInMerchant(Long, Long)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStoreInMerchant(Long, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.storeMapper.selectCount(
                (com.baomidou.mybatisplus.core.conditions.Wrapper<mao.aggregate_pay_merchant_service.entity.Store>) any()))
                .thenThrow(new BizException("An error occurred"));
        this.storeServiceImpl.queryStoreInMerchant(123L, 123L);
    }

    /**
     * Method under test: {@link StoreServiceImpl#update(StoreDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: An error occurred
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.updateById(ServiceImpl.java:207)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.update(StoreServiceImpl.java:76)
        //   In order to prevent update(StoreDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(StoreDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.storeMapper.updateById((Store) any())).thenThrow(new BizException("An error occurred"));
        when(this.dozerUtils.map((Object) any(), (Class<Store>) any())).thenReturn(new Store());

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        this.storeServiceImpl.update(storeDTO);
    }

    /**
     * Method under test: {@link StoreServiceImpl#update(StoreDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.checkStoreNumber(StoreServiceImpl.java:88)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.update(StoreServiceImpl.java:74)
        //   In order to prevent update(StoreDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(StoreDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.storeMapper.updateById((Store) any())).thenReturn(123);
        when(this.dozerUtils.map((Object) any(), (Class<Store>) any())).thenReturn(null);

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        this.storeServiceImpl.update(storeDTO);
    }

    /**
     * Method under test: {@link StoreServiceImpl#update(StoreDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 门店编号不唯一
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.checkStoreNumber(StoreServiceImpl.java:96)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.update(StoreServiceImpl.java:74)
        //   In order to prevent update(StoreDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(StoreDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.storeMapper.selectCount((com.baomidou.mybatisplus.core.conditions.Wrapper<Store>) any())).thenReturn(3);
        when(this.storeMapper.updateById((Store) any())).thenReturn(123);
        when(this.dozerUtils.map((Object) any(), (Class<Store>) any()))
                .thenReturn(new Store(123L, "Store Name", 1L, 123L, 123L, true, "42 Main St"));

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        this.storeServiceImpl.update(storeDTO);
    }

    /**
     * Method under test: {@link StoreServiceImpl#update(StoreDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: An error occurred
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.count(ServiceImpl.java:266)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.checkStoreNumber(StoreServiceImpl.java:92)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.update(StoreServiceImpl.java:74)
        //   In order to prevent update(StoreDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(StoreDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.storeMapper.selectCount((com.baomidou.mybatisplus.core.conditions.Wrapper<Store>) any()))
                .thenThrow(new BizException("An error occurred"));
        when(this.storeMapper.updateById((Store) any())).thenReturn(123);
        when(this.dozerUtils.map((Object) any(), (Class<Store>) any()))
                .thenReturn(new Store(123L, "Store Name", 1L, 123L, 123L, true, "42 Main St"));

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        this.storeServiceImpl.update(storeDTO);
    }

    /**
     * Method under test: {@link StoreServiceImpl#save(StoreDTO, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.save(StoreServiceImpl.java:127)
        //   In order to prevent save(StoreDTO, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   save(StoreDTO, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.storeMapper.insert((Store) any())).thenReturn(1);
        when(this.staffService.getById((java.io.Serializable) any())).thenReturn(new Staff());
        when(this.dozerUtils.map((Object) any(), (Class<Store>) any())).thenReturn(new Store());

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        this.storeServiceImpl.save(storeDTO, "Staff Ids");
    }

    /**
     * Method under test: {@link StoreServiceImpl#save(StoreDTO, String)}
     */
    @Test
    void testSave2()
    {
        when(this.storeMapper.insert((Store) any())).thenReturn(1);
        when(this.staffService.getById((java.io.Serializable) any())).thenThrow(new BizException("An error occurred"));
        when(this.dozerUtils.map((Object) any(), (Class<Store>) any())).thenReturn(new Store());

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        assertThrows(BizException.class, () -> this.storeServiceImpl.save(storeDTO, "Staff Ids"));
        verify(this.storeMapper).insert((Store) any());
        verify(this.staffService).getById((java.io.Serializable) any());
        verify(this.dozerUtils).map((Object) any(), (Class<Store>) any());
    }

    /**
     * Method under test: {@link StoreServiceImpl#save(StoreDTO, String)}
     */
    @Test
    void testSave3()
    {
        when(this.storeMapper.insert((Store) any())).thenReturn(1);
        when(this.staffService.getById((java.io.Serializable) any())).thenReturn(null);
        when(this.dozerUtils.map((Object) any(), (Class<Store>) any())).thenReturn(new Store());

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        assertThrows(BizException.class, () -> this.storeServiceImpl.save(storeDTO, "Staff Ids"));
        verify(this.storeMapper).insert((Store) any());
        verify(this.staffService).getById((java.io.Serializable) any());
        verify(this.dozerUtils).map((Object) any(), (Class<Store>) any());
    }

    /**
     * Method under test: {@link StoreServiceImpl#save(StoreDTO, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.checkStoreNumber(StoreServiceImpl.java:88)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.save(StoreServiceImpl.java:108)
        //   In order to prevent save(StoreDTO, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   save(StoreDTO, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.storeMapper.insert((Store) any())).thenReturn(1);
        when(this.staffService.getById((java.io.Serializable) any())).thenReturn(new Staff());
        when(this.dozerUtils.map((Object) any(), (Class<Store>) any())).thenReturn(null);

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        this.storeServiceImpl.save(storeDTO, "Staff Ids");
    }

    /**
     * Method under test: {@link StoreServiceImpl#save(StoreDTO, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 门店编号不唯一
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.checkStoreNumber(StoreServiceImpl.java:96)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.save(StoreServiceImpl.java:108)
        //   In order to prevent save(StoreDTO, String)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   save(StoreDTO, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.storeMapper.selectCount((com.baomidou.mybatisplus.core.conditions.Wrapper<Store>) any())).thenReturn(3);
        when(this.storeMapper.insert((Store) any())).thenReturn(1);
        when(this.staffService.getById((java.io.Serializable) any())).thenReturn(new Staff());
        when(this.dozerUtils.map((Object) any(), (Class<Store>) any()))
                .thenReturn(new Store(123L, ",", 1L, 123L, 123L, true, "42 Main St"));

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        this.storeServiceImpl.save(storeDTO, "Staff Ids");
    }

    /**
     * Method under test: {@link StoreServiceImpl#save(StoreDTO, String)}
     */
    @Test
    void testSave6()
    {
        when(this.storeMapper.selectCount((com.baomidou.mybatisplus.core.conditions.Wrapper<Store>) any())).thenReturn(0);
        when(this.storeMapper.insert((Store) any())).thenReturn(1);
        when(this.staffService.getById((java.io.Serializable) any())).thenReturn(new Staff());
        when(this.dozerUtils.map((Object) any(), (Class<Store>) any()))
                .thenReturn(new Store(123L, ",", 1L, 123L, 123L, true, "42 Main St"));

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        assertThrows(BizException.class, () -> this.storeServiceImpl.save(storeDTO, "Staff Ids"));
        verify(this.storeMapper).insert((Store) any());
        verify(this.storeMapper).selectCount((com.baomidou.mybatisplus.core.conditions.Wrapper<Store>) any());
        verify(this.staffService).getById((java.io.Serializable) any());
        verify(this.dozerUtils).map((Object) any(), (Class<Store>) any());
    }

    /**
     * Method under test: {@link StoreServiceImpl#save(StoreDTO, String)}
     */
    @Test
    void testSave7()
    {
        when(this.storeMapper.selectCount((com.baomidou.mybatisplus.core.conditions.Wrapper<Store>) any()))
                .thenReturn(null);
        when(this.storeMapper.insert((Store) any())).thenReturn(1);
        when(this.staffService.getById((java.io.Serializable) any())).thenReturn(new Staff());
        when(this.dozerUtils.map((Object) any(), (Class<Store>) any()))
                .thenReturn(new Store(123L, ",", 1L, 123L, 123L, true, "42 Main St"));

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        assertThrows(BizException.class, () -> this.storeServiceImpl.save(storeDTO, "Staff Ids"));
        verify(this.storeMapper).insert((Store) any());
        verify(this.storeMapper).selectCount((com.baomidou.mybatisplus.core.conditions.Wrapper<Store>) any());
        verify(this.staffService).getById((java.io.Serializable) any());
        verify(this.dozerUtils).map((Object) any(), (Class<Store>) any());
    }

    /**
     * Method under test: {@link StoreServiceImpl#save(StoreDTO, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave8()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: An error occurred
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.count(ServiceImpl.java:266)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.checkStoreNumber(StoreServiceImpl.java:92)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.save(StoreServiceImpl.java:108)
        //   In order to prevent save(StoreDTO, String)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   save(StoreDTO, String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.storeMapper.selectCount((com.baomidou.mybatisplus.core.conditions.Wrapper<Store>) any()))
                .thenThrow(new BizException("An error occurred"));
        when(this.storeMapper.insert((Store) any())).thenReturn(1);
        when(this.staffService.getById((java.io.Serializable) any())).thenReturn(new Staff());
        when(this.dozerUtils.map((Object) any(), (Class<Store>) any()))
                .thenReturn(new Store(123L, ",", 1L, 123L, 123L, true, "42 Main St"));

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        this.storeServiceImpl.save(storeDTO, "Staff Ids");
    }

    /**
     * Method under test: {@link StoreServiceImpl#delete(StoreDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDelete()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 当前门店不是属于当前登录的商户，无法删除
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.delete(StoreServiceImpl.java:161)
        //   In order to prevent delete(StoreDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   delete(StoreDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.storeMapper.selectById((java.io.Serializable) any())).thenReturn(new Store());

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        this.storeServiceImpl.delete(storeDTO);
    }

    /**
     * Method under test: {@link StoreServiceImpl#delete(StoreDTO)}
     */
    @Test
    void testDelete2()
    {
        Store store = new Store();
        store.setMerchantId(123L);
        when(this.storeMapper.deleteById((java.io.Serializable) any())).thenReturn(123);
        when(this.storeMapper.selectById((java.io.Serializable) any())).thenReturn(store);

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        assertTrue(this.storeServiceImpl.delete(storeDTO));
        verify(this.storeMapper).deleteById((java.io.Serializable) any());
        verify(this.storeMapper).selectById((java.io.Serializable) any());
    }

    /**
     * Method under test: {@link StoreServiceImpl#delete(StoreDTO)}
     */
    @Test
    void testDelete3()
    {
        Store store = new Store();
        store.setMerchantId(123L);
        when(this.storeMapper.deleteById((java.io.Serializable) any())).thenReturn(0);
        when(this.storeMapper.selectById((java.io.Serializable) any())).thenReturn(store);

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        assertTrue(this.storeServiceImpl.delete(storeDTO));
        verify(this.storeMapper).deleteById((java.io.Serializable) any());
        verify(this.storeMapper).selectById((java.io.Serializable) any());
    }

    /**
     * Method under test: {@link StoreServiceImpl#delete(StoreDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDelete4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.delete(StoreServiceImpl.java:158)
        //   In order to prevent delete(StoreDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   delete(StoreDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        Store store = new Store();
        store.setMerchantId(123L);
        when(this.storeMapper.deleteById((java.io.Serializable) any())).thenReturn(123);
        when(this.storeMapper.selectById((java.io.Serializable) any())).thenReturn(store);

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(null);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        this.storeServiceImpl.delete(storeDTO);
    }

    /**
     * Method under test: {@link StoreServiceImpl#delete(StoreDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDelete5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: An error occurred
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.removeById(ServiceImpl.java:186)
        //       at mao.aggregate_pay_merchant_service.service.impl.StoreServiceImpl.delete(StoreServiceImpl.java:164)
        //   In order to prevent delete(StoreDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   delete(StoreDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        Store store = new Store();
        store.setMerchantId(123L);
        when(this.storeMapper.deleteById((java.io.Serializable) any())).thenThrow(new BizException("An error occurred"));
        when(this.storeMapper.selectById((java.io.Serializable) any())).thenReturn(store);

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        this.storeServiceImpl.delete(storeDTO);
    }
}

