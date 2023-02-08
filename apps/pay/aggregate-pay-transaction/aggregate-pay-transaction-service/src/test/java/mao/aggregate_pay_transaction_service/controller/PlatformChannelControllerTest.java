package mao.aggregate_pay_transaction_service.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PlatformChannelControllerTest
{
    /**
     * Method under test: {@link PlatformChannelController#queryAll()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAll()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.PlatformChannelController.queryAll(PlatformChannelController.java:48)
        //   In order to prevent queryAll()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryAll().
        //   See https://diff.blue/R013 to resolve this issue.

        (new PlatformChannelController()).queryAll();
    }

    /**
     * Method under test: {@link PlatformChannelController#bindPlatformChannelForApp(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBindPlatformChannelForApp()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.PlatformChannelController.bindPlatformChannelForApp(PlatformChannelController.java:62)
        //   In order to prevent bindPlatformChannelForApp(String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   bindPlatformChannelForApp(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PlatformChannelController()).bindPlatformChannelForApp("42", "Platform Channel Codes");
    }

    /**
     * Method under test: {@link PlatformChannelController#queryAppBindPlatformChannel(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAppBindPlatformChannel()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.PlatformChannelController.queryAppBindPlatformChannel(PlatformChannelController.java:77)
        //   In order to prevent queryAppBindPlatformChannel(String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryAppBindPlatformChannel(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PlatformChannelController()).queryAppBindPlatformChannel("42", "Platform Channel");
    }
}

