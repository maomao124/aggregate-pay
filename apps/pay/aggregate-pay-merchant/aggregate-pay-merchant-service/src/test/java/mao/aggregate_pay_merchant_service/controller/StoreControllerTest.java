package mao.aggregate_pay_merchant_service.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StoreControllerTest
{
    /**
     * Method under test: {@link StoreController#queryStoreInMerchant(Long, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryStoreInMerchant()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.StoreController.queryStoreInMerchant(StoreController.java:47)
        //   In order to prevent queryStoreInMerchant(Long, Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryStoreInMerchant(Long, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new StoreController()).queryStoreInMerchant(123L, 123L);
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
        //       at mao.aggregate_pay_merchant_service.controller.StoreController.update(StoreController.java:61)
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
        //       at mao.aggregate_pay_merchant_service.controller.StoreController.update(StoreController.java:61)
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
        //       at mao.aggregate_pay_merchant_service.controller.StoreController.save(StoreController.java:75)
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
        //       at mao.aggregate_pay_merchant_service.controller.StoreController.save(StoreController.java:75)
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
     * Method under test: {@link StoreController#delete(StoreDTO)}
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
        //       at mao.aggregate_pay_merchant_service.controller.StoreController.delete(StoreController.java:89)
        //   In order to prevent delete(StoreDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   delete(StoreDTO).
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
        storeController.delete(storeDTO);
    }

    /**
     * Method under test: {@link StoreController#delete(StoreDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDelete2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.StoreController.delete(StoreController.java:89)
        //   In order to prevent delete(StoreDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   delete(StoreDTO).
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
        storeController.delete(storeDTO);
    }
}

