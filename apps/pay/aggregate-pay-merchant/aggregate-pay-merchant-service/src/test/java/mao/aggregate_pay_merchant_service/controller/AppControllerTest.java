package mao.aggregate_pay_merchant_service.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import mao.aggregate_pay_merchant_api.dto.AppDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AppControllerTest
{
    /**
     * Method under test: {@link AppController#createApp(Long, AppDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateApp()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.AppController.createApp(AppController.java:46)
        //   In order to prevent createApp(Long, AppDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createApp(Long, AppDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        AppController appController = new AppController();

        AppDTO appDTO = new AppDTO();
        appDTO.setAppId("42");
        appDTO.setAppName("App Name");
        appDTO.setMerchantId(123L);
        appDTO.setNotifyUrl("https://example.org/example");
        appDTO.setPublicKey("Public Key");
        appController.createApp(123L, appDTO);
    }

    /**
     * Method under test: {@link AppController#createApp(Long, AppDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateApp2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.AppController.createApp(AppController.java:46)
        //   In order to prevent createApp(Long, AppDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createApp(Long, AppDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        AppController appController = new AppController();
        AppDTO appDTO = mock(AppDTO.class);
        doNothing().when(appDTO).setAppId((String) any());
        doNothing().when(appDTO).setAppName((String) any());
        doNothing().when(appDTO).setMerchantId((Long) any());
        doNothing().when(appDTO).setNotifyUrl((String) any());
        doNothing().when(appDTO).setPublicKey((String) any());
        appDTO.setAppId("42");
        appDTO.setAppName("App Name");
        appDTO.setMerchantId(123L);
        appDTO.setNotifyUrl("https://example.org/example");
        appDTO.setPublicKey("Public Key");
        appController.createApp(123L, appDTO);
    }

    /**
     * Method under test: {@link AppController#queryAppByMerchantId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAppByMerchantId()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.AppController.queryAppByMerchantId(AppController.java:59)
        //   In order to prevent queryAppByMerchantId(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryAppByMerchantId(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AppController()).queryAppByMerchantId(123L);
    }

    /**
     * Method under test: {@link AppController#getAppById(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAppById()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.AppController.getAppById(AppController.java:72)
        //   In order to prevent getAppById(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAppById(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AppController()).getAppById("42");
    }

    /**
     * Method under test: {@link AppController#queryAppInMerchant(String, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAppInMerchant()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_service.controller.AppController.queryAppInMerchant(AppController.java:87)
        //   In order to prevent queryAppInMerchant(String, Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryAppInMerchant(String, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AppController()).queryAppInMerchant("42", 123L);
    }
}

