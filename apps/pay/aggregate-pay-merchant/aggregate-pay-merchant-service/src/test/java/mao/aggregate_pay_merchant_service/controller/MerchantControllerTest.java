package mao.aggregate_pay_merchant_service.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_service.service.MerchantService;
import org.junit.jupiter.api.Disabled;
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

@ContextConfiguration(classes = {MerchantController.class})
@ExtendWith(SpringExtension.class)
class MerchantControllerTest
{
    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @Autowired
    private MerchantController merchantController;

    @MockBean
    private MerchantService merchantService;

    /**
     * Method under test: {@link MerchantController#getById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetById()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.MerchantController.getById(MerchantController.java:48)
        //   In order to prevent getById(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getById(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new MerchantController()).getById(123L);
    }

    /**
     * Method under test: {@link MerchantController#applyMerchant(Long, MerchantDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testApplyMerchant()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.MerchantController.applyMerchant(MerchantController.java:77)
        //   In order to prevent applyMerchant(Long, MerchantDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   applyMerchant(Long, MerchantDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantController merchantController = new MerchantController();

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
        merchantController.applyMerchant(123L, merchantDTO);
    }

    /**
     * Method under test: {@link MerchantController#applyMerchant(Long, MerchantDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testApplyMerchant2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.MerchantController.applyMerchant(MerchantController.java:77)
        //   In order to prevent applyMerchant(Long, MerchantDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   applyMerchant(Long, MerchantDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantController merchantController = new MerchantController();
        MerchantDTO merchantDTO = mock(MerchantDTO.class);
        doNothing().when(merchantDTO).setAuditStatus((String) any());
        doNothing().when(merchantDTO).setBusinessLicensesImg((String) any());
        doNothing().when(merchantDTO).setContactsAddress((String) any());
        doNothing().when(merchantDTO).setId((Long) any());
        doNothing().when(merchantDTO).setIdCardAfterImg((String) any());
        doNothing().when(merchantDTO).setIdCardFrontImg((String) any());
        doNothing().when(merchantDTO).setMerchantAddress((String) any());
        doNothing().when(merchantDTO).setMerchantName((String) any());
        doNothing().when(merchantDTO).setMerchantNo((Long) any());
        doNothing().when(merchantDTO).setMerchantType((String) any());
        doNothing().when(merchantDTO).setMobile((String) any());
        doNothing().when(merchantDTO).setPassword((String) any());
        doNothing().when(merchantDTO).setTenantId((Long) any());
        doNothing().when(merchantDTO).setUsername((String) any());
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
        merchantController.applyMerchant(123L, merchantDTO);
    }

    /**
     * Method under test: {@link MerchantController#createStore(StoreDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateStore()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.MerchantController.createStore(MerchantController.java:92)
        //   In order to prevent createStore(StoreDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createStore(StoreDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantController merchantController = new MerchantController();

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        merchantController.createStore(storeDTO);
    }

    /**
     * Method under test: {@link MerchantController#createStore(StoreDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateStore2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.MerchantController.createStore(MerchantController.java:92)
        //   In order to prevent createStore(StoreDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createStore(StoreDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantController merchantController = new MerchantController();
        StoreDTO storeDTO = mock(StoreDTO.class);
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
        merchantController.createStore(storeDTO);
    }

    /**
     * Method under test: {@link MerchantController#bindStaffToStore(Long, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBindStaffToStore()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.MerchantController.bindStaffToStore(MerchantController.java:121)
        //   In order to prevent bindStaffToStore(Long, Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   bindStaffToStore(Long, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new MerchantController()).bindStaffToStore(123L, 123L);
    }

    /**
     * Method under test: {@link MerchantController#getMerchantByTenantId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetMerchantByTenantId()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.MerchantController.getMerchantByTenantId(MerchantController.java:136)
        //   In order to prevent getMerchantByTenantId(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getMerchantByTenantId(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new MerchantController()).getMerchantByTenantId(123L);
    }

    /**
     * Method under test: {@link MerchantController#queryStoreByPage(StoreDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryStoreByPage()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.MerchantController.queryStoreByPage(MerchantController.java:154)
        //   In order to prevent queryStoreByPage(StoreDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStoreByPage(StoreDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantController merchantController = new MerchantController();

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        merchantController.queryStoreByPage(storeDTO, 1, 3);
    }

    /**
     * Method under test: {@link MerchantController#queryStoreByPage(StoreDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryStoreByPage2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.MerchantController.queryStoreByPage(MerchantController.java:154)
        //   In order to prevent queryStoreByPage(StoreDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStoreByPage(StoreDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantController merchantController = new MerchantController();
        StoreDTO storeDTO = mock(StoreDTO.class);
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
        merchantController.queryStoreByPage(storeDTO, 1, 3);
    }

    /**
     * Method under test: {@link MerchantController#createMerchant(MerchantDTO)}
     */
    @Test
    void testCreateMerchant() throws Exception
    {
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
        String content = (new ObjectMapper()).writeValueAsString(merchantDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/merchant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.merchantController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }

    /**
     * Method under test: {@link MerchantController#createStaff(StaffDTO)}
     */
    @Test
    void testCreateStaff() throws Exception
    {
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
        String content = (new ObjectMapper()).writeValueAsString(staffDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/merchant/createStaff")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.merchantController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

