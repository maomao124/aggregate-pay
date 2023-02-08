package mao.aggregate_pay_merchant_application.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StoreControllerTest
{
    /**
     * Method under test: {@link StoreController#queryStoreByPage(Integer, Integer)}
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
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantIdThrowsException(SecurityUtil.java:124)
        //       at mao.aggregate_pay_merchant_application.controller.StoreController.queryStoreByPage(StoreController.java:109)
        //   In order to prevent queryStoreByPage(Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStoreByPage(Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        (new StoreController()).queryStoreByPage(1, 3);
    }

    /**
     * Method under test: {@link StoreController#queryStoreByPage(Integer, Integer)}
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
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantIdThrowsException(SecurityUtil.java:124)
        //       at mao.aggregate_pay_merchant_application.controller.StoreController.queryStoreByPage(StoreController.java:109)
        //   In order to prevent queryStoreByPage(Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStoreByPage(Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        (new StoreController()).queryStoreByPage(1, 100);
    }

    /**
     * Method under test: {@link StoreController#createCScanBStoreQRCode(Long, String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCScanBStoreQRCode()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantThrowsException(SecurityUtil.java:164)
        //       at mao.aggregate_pay_merchant_application.controller.StoreController.createCScanBStoreQRCode(StoreController.java:147)
        //   In order to prevent createCScanBStoreQRCode(Long, String, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createCScanBStoreQRCode(Long, String, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new StoreController()).createCScanBStoreQRCode(123L, "42", "Not all who wander are lost", "10");
    }

    /**
     * Method under test: {@link StoreController#createCScanBStoreQRCode(Long, String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCScanBStoreQRCode2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantThrowsException(SecurityUtil.java:164)
        //       at mao.aggregate_pay_merchant_application.controller.StoreController.createCScanBStoreQRCode(StoreController.java:147)
        //   In order to prevent createCScanBStoreQRCode(Long, String, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createCScanBStoreQRCode(Long, String, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new StoreController()).createCScanBStoreQRCode(1L, "foo", "foo", "foo");
    }

    /**
     * Method under test: {@link StoreController#update(StoreDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantIdThrowsException(SecurityUtil.java:124)
        //       at mao.aggregate_pay_merchant_application.controller.StoreController.update(StoreController.java:207)
        //   In order to prevent update(StoreDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(StoreDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        StoreController storeController = new StoreController();

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        storeController.update(storeDTO);
    }

    /**
     * Method under test: {@link StoreController#update(StoreDTO)}
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
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantIdThrowsException(SecurityUtil.java:124)
        //       at mao.aggregate_pay_merchant_application.controller.StoreController.update(StoreController.java:207)
        //   In order to prevent update(StoreDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   update(StoreDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        StoreController storeController = new StoreController();
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
        storeController.update(storeDTO);
    }

    /**
     * Method under test: {@link StoreController#save(StoreDTO, String)}
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
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantIdThrowsException(SecurityUtil.java:124)
        //       at mao.aggregate_pay_merchant_application.controller.StoreController.save(StoreController.java:231)
        //   In order to prevent save(StoreDTO, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   save(StoreDTO, String).
        //   See https://diff.blue/R013 to resolve this issue.

        StoreController storeController = new StoreController();

        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(123L);
        storeDTO.setMerchantId(123L);
        storeDTO.setParentId(123L);
        storeDTO.setStoreAddress("42 Main St");
        storeDTO.setStoreName("Store Name");
        storeDTO.setStoreNumber(1L);
        storeDTO.setStoreStatus(true);
        storeController.save(storeDTO, "Staff Ids");
    }

    /**
     * Method under test: {@link StoreController#save(StoreDTO, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantIdThrowsException(SecurityUtil.java:124)
        //       at mao.aggregate_pay_merchant_application.controller.StoreController.save(StoreController.java:231)
        //   In order to prevent save(StoreDTO, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   save(StoreDTO, String).
        //   See https://diff.blue/R013 to resolve this issue.

        StoreController storeController = new StoreController();
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
        storeController.save(storeDTO, "Staff Ids");
    }

    /**
     * Method under test: {@link StoreController#delete(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDelete()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantIdThrowsException(SecurityUtil.java:124)
        //       at mao.aggregate_pay_merchant_application.controller.StoreController.delete(StoreController.java:257)
        //   In order to prevent delete(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   delete(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new StoreController()).delete(123L);
    }
}

