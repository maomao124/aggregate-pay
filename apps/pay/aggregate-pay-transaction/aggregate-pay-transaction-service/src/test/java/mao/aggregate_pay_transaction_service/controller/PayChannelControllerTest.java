package mao.aggregate_pay_transaction_service.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PayChannelControllerTest
{
    /**
     * Method under test: {@link PayChannelController#queryPayChannelByPlatformChannel(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPayChannelByPlatformChannel()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.PayChannelController.queryPayChannelByPlatformChannel(PayChannelController.java:48)
        //   In order to prevent queryPayChannelByPlatformChannel(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPayChannelByPlatformChannel(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PayChannelController()).queryPayChannelByPlatformChannel("Platform Channel Code");
    }
}

