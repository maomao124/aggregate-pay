package mao.aggregate_pay_merchant_service.service.impl;

import java.time.LocalDateTime;

import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_service.mapper.MerchantMapper;
import mao.aggregate_pay_merchant_service.service.MerchantService;
import mao.aggregate_pay_merchant_service.service.StaffService;
import mao.aggregate_pay_merchant_service.service.StoreService;
import mao.aggregate_pay_merchant_service.service.StoreStaffService;
import mao.aggregate_pay_user_api.feign.TenantFeignClientV2;
import mao.tools_redis_cache.utils.RedisUtils;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.service.impl
 * Class(测试类名): MerchantServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 15:41
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest
class MerchantServiceImplTest
{

    @MockBean
    private DozerUtils dozerUtils;

    @MockBean
    private MerchantMapper merchantMapper;

    @Autowired
    private MerchantServiceImpl merchantServiceImpl;

    @MockBean
    private RedisUtils redisUtils;

    @MockBean
    private StaffService staffService;

    @MockBean
    private StoreService storeService;

    @MockBean
    private StoreStaffService storeStaffService;

    @MockBean
    private TenantFeignClientV2 tenantFeignClientV2;

    @Autowired
    private MerchantService merchantService;

    @Test
    void getMerchantById()
    {
        MerchantDTO merchantDTO = merchantService.getMerchantById(1L);
        System.out.println(merchantDTO);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#getMerchantById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetMerchantById()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        this.merchantServiceImpl.getMerchantById(123L);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#createMerchant(MerchantDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateMerchant()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        MerchantDTO merchantDTO = new MerchantDTO();
        merchantDTO.setAuditStatus("Audit Status");
        merchantDTO.setBusinessLicensesImg("Business Licenses Img");
        merchantDTO.setContactsAddress("42 Main St");
        merchantDTO.setId(123L);
        merchantDTO.setIdCardAfterImg("Id Card After Img");
        merchantDTO.setIdCardFrontImg("Id Card Front Img");
        merchantDTO.setMerchantAddress("42 Main St");
        merchantDTO.setMerchantName("Merchant Name");
        merchantDTO.setMerchantNo(1L);
        merchantDTO.setMerchantType("Merchant Type");
        merchantDTO.setMobile("Mobile");
        merchantDTO.setPassword("iloveyou");
        merchantDTO.setTenantId(123L);
        merchantDTO.setUsername("janedoe");
        this.merchantServiceImpl.createMerchant(merchantDTO);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#applyMerchant(Long, MerchantDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testApplyMerchant()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        MerchantDTO merchantDTO = new MerchantDTO();
        merchantDTO.setAuditStatus("Audit Status");
        merchantDTO.setBusinessLicensesImg("Business Licenses Img");
        merchantDTO.setContactsAddress("42 Main St");
        merchantDTO.setId(123L);
        merchantDTO.setIdCardAfterImg("Id Card After Img");
        merchantDTO.setIdCardFrontImg("Id Card Front Img");
        merchantDTO.setMerchantAddress("42 Main St");
        merchantDTO.setMerchantName("Merchant Name");
        merchantDTO.setMerchantNo(1L);
        merchantDTO.setMerchantType("Merchant Type");
        merchantDTO.setMobile("Mobile");
        merchantDTO.setPassword("iloveyou");
        merchantDTO.setTenantId(123L);
        merchantDTO.setUsername("janedoe");
        this.merchantServiceImpl.applyMerchant(123L, merchantDTO);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#createStore(StoreDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateStore()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        this.merchantServiceImpl.createStore(storeDTO);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#createStaff(StaffDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateStaff()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.MerchantServiceImpl.isExistStaffByMobile(MerchantServiceImpl.java:324)
        //       at mao.aggregate_pay_merchant_service.service.impl.MerchantServiceImpl.createStaff(MerchantServiceImpl.java:292)
        //   In order to prevent createStaff(StaffDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createStaff(StaffDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantServiceImpl merchantServiceImpl = new MerchantServiceImpl();

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
        merchantServiceImpl.createStaff(staffDTO);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#createStaff(StaffDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateStaff2()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.MerchantServiceImpl.isExistStaffByMobile(MerchantServiceImpl.java:324)
        //       at mao.aggregate_pay_merchant_service.service.impl.MerchantServiceImpl.createStaff(MerchantServiceImpl.java:292)
        //   In order to prevent createStaff(StaffDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createStaff(StaffDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantServiceImpl merchantServiceImpl = new MerchantServiceImpl();
        StaffDTO staffDTO = mock(StaffDTO.class);
        when(staffDTO.getMerchantId()).thenReturn(123L);
        when(staffDTO.getUsername()).thenReturn("janedoe");
        when(staffDTO.getMobile()).thenReturn("Mobile");
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
        merchantServiceImpl.createStaff(staffDTO);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#createStaff(StaffDTO)}
     */
    @Test
    void testCreateStaff3()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        MerchantServiceImpl merchantServiceImpl = new MerchantServiceImpl();
        StaffDTO staffDTO = mock(StaffDTO.class);
        when(staffDTO.getMerchantId()).thenThrow(new IllegalArgumentException("foo"));
        when(staffDTO.getUsername()).thenReturn("janedoe");
        when(staffDTO.getMobile()).thenReturn("Mobile");
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
        assertThrows(IllegalArgumentException.class, () -> merchantServiceImpl.createStaff(staffDTO));
        verify(staffDTO).getMerchantId();
        verify(staffDTO, atLeast(1)).getMobile();
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
     * Method under test: {@link MerchantServiceImpl#createStaff(StaffDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateStaff4()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 用户名为空
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_merchant_service.service.impl.MerchantServiceImpl.createStaff(MerchantServiceImpl.java:289)
        //   In order to prevent createStaff(StaffDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createStaff(StaffDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantServiceImpl merchantServiceImpl = new MerchantServiceImpl();
        StaffDTO staffDTO = mock(StaffDTO.class);
        when(staffDTO.getMerchantId()).thenThrow(new IllegalArgumentException("foo"));
        when(staffDTO.getUsername()).thenReturn("");
        when(staffDTO.getMobile()).thenReturn("Mobile");
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
        merchantServiceImpl.createStaff(staffDTO);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#createStaff(StaffDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateStaff5()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: 手机号为空
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:42)
        //       at mao.aggregate_pay_merchant_service.service.impl.MerchantServiceImpl.createStaff(MerchantServiceImpl.java:283)
        //   In order to prevent createStaff(StaffDTO)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createStaff(StaffDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantServiceImpl merchantServiceImpl = new MerchantServiceImpl();
        StaffDTO staffDTO = mock(StaffDTO.class);
        when(staffDTO.getMerchantId()).thenThrow(new IllegalArgumentException("foo"));
        when(staffDTO.getUsername()).thenReturn("janedoe");
        when(staffDTO.getMobile()).thenReturn("");
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
        merchantServiceImpl.createStaff(staffDTO);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#bindStaffToStore(Long, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBindStaffToStore()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        this.merchantServiceImpl.bindStaffToStore(123L, 123L);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#getMerchantByTenantId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetMerchantByTenantId()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        this.merchantServiceImpl.getMerchantByTenantId(123L);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#queryStoreByPage(StoreDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryStoreByPage()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.MerchantServiceImpl.queryStoreByPage(MerchantServiceImpl.java:392)
        //   In order to prevent queryStoreByPage(StoreDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStoreByPage(StoreDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantServiceImpl merchantServiceImpl = new MerchantServiceImpl();

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        merchantServiceImpl.queryStoreByPage(storeDTO, 1, 3);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#queryStoreByPage(StoreDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryStoreByPage2()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.MerchantServiceImpl.queryStoreByPage(MerchantServiceImpl.java:402)
        //   In order to prevent queryStoreByPage(StoreDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStoreByPage(StoreDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        (new MerchantServiceImpl()).queryStoreByPage(null, 1, 1);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#queryStoreByPage(StoreDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryStoreByPage3()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.MerchantServiceImpl.queryStoreByPage(MerchantServiceImpl.java:392)
        //   In order to prevent queryStoreByPage(StoreDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStoreByPage(StoreDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantServiceImpl merchantServiceImpl = new MerchantServiceImpl();
        StoreDTO storeDTO = mock(StoreDTO.class);
        when(storeDTO.getMerchantId()).thenReturn(123L);
        doNothing().when(storeDTO).setId((Long) any());
        doNothing().when(storeDTO).setMerchantId((Long) any());
        doNothing().when(storeDTO).setParentId((Long) any());
        doNothing().when(storeDTO).setStoreAddress((String) any());
        doNothing().when(storeDTO).setStoreName((String) any());
        doNothing().when(storeDTO).setStoreNumber((Long) any());
        doNothing().when(storeDTO).setStoreStatus((Boolean) any());
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        merchantServiceImpl.queryStoreByPage(storeDTO, 1, 3);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#queryStoreByPage(StoreDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryStoreByPage4()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.MerchantServiceImpl.queryStoreByPage(MerchantServiceImpl.java:402)
        //   In order to prevent queryStoreByPage(StoreDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStoreByPage(StoreDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantServiceImpl merchantServiceImpl = new MerchantServiceImpl();
        StoreDTO storeDTO = mock(StoreDTO.class);
        when(storeDTO.getMerchantId()).thenReturn(null);
        doNothing().when(storeDTO).setId((Long) any());
        doNothing().when(storeDTO).setMerchantId((Long) any());
        doNothing().when(storeDTO).setParentId((Long) any());
        doNothing().when(storeDTO).setStoreAddress((String) any());
        doNothing().when(storeDTO).setStoreName((String) any());
        doNothing().when(storeDTO).setStoreNumber((Long) any());
        doNothing().when(storeDTO).setStoreStatus((Boolean) any());
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        merchantServiceImpl.queryStoreByPage(storeDTO, 1, 3);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#queryStoreByPage(StoreDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryStoreByPage5()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.MerchantServiceImpl.queryStoreByPage(MerchantServiceImpl.java:387)
        //   In order to prevent queryStoreByPage(StoreDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStoreByPage(StoreDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantServiceImpl merchantServiceImpl = new MerchantServiceImpl();
        StoreDTO storeDTO = mock(StoreDTO.class);
        when(storeDTO.getMerchantId()).thenReturn(123L);
        doNothing().when(storeDTO).setId((Long) any());
        doNothing().when(storeDTO).setMerchantId((Long) any());
        doNothing().when(storeDTO).setParentId((Long) any());
        doNothing().when(storeDTO).setStoreAddress((String) any());
        doNothing().when(storeDTO).setStoreName((String) any());
        doNothing().when(storeDTO).setStoreNumber((Long) any());
        doNothing().when(storeDTO).setStoreStatus((Boolean) any());
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        merchantServiceImpl.queryStoreByPage(storeDTO, null, 3);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#queryStoreByPage(StoreDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryStoreByPage6()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.service.impl.MerchantServiceImpl.queryStoreByPage(MerchantServiceImpl.java:387)
        //   In order to prevent queryStoreByPage(StoreDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStoreByPage(StoreDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantServiceImpl merchantServiceImpl = new MerchantServiceImpl();
        StoreDTO storeDTO = mock(StoreDTO.class);
        when(storeDTO.getMerchantId()).thenReturn(123L);
        doNothing().when(storeDTO).setId((Long) any());
        doNothing().when(storeDTO).setMerchantId((Long) any());
        doNothing().when(storeDTO).setParentId((Long) any());
        doNothing().when(storeDTO).setStoreAddress((String) any());
        doNothing().when(storeDTO).setStoreName((String) any());
        doNothing().when(storeDTO).setStoreNumber((Long) any());
        doNothing().when(storeDTO).setStoreStatus((Boolean) any());
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        merchantServiceImpl.queryStoreByPage(storeDTO, 1, null);
    }

    /**
     * Method under test: {@link MerchantServiceImpl#queryStoreByPage(StoreDTO, Integer, Integer)}
     */
    @Test
    void testQueryStoreByPage7()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        MerchantServiceImpl merchantServiceImpl = new MerchantServiceImpl();
        StoreDTO storeDTO = mock(StoreDTO.class);
        when(storeDTO.getMerchantId()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> merchantServiceImpl.queryStoreByPage(storeDTO, 1, 1));
        verify(storeDTO).getMerchantId();
    }

    /**
     * Method under test: {@link MerchantServiceImpl#queryStoreByPage(StoreDTO, Integer, Integer)}
     */
    @Test
    void testQueryStoreByPage8()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        MerchantServiceImpl merchantServiceImpl = new MerchantServiceImpl();
        StoreDTO storeDTO = mock(StoreDTO.class);
        when(storeDTO.getMerchantId()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> merchantServiceImpl.queryStoreByPage(storeDTO, 2, 1));
        verify(storeDTO).getMerchantId();
    }
}
