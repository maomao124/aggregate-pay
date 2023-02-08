package mao.aggregate_pay_merchant_application.controller;

import mao.aggregate_pay_transaction_api.dto.PayChannelParamDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PlatformParamControllerTest
{
    /**
     * Method under test: {@link PlatformParamController#queryPlatformChannel(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPlatformChannel()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.controller.PlatformParamController.queryPlatformChannel(PlatformParamController.java:63)
        //   In order to prevent queryPlatformChannel(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPlatformChannel(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PlatformParamController()).queryPlatformChannel(123L);
    }

    /**
     * Method under test: {@link PlatformParamController#queryPayChannelByPlatformChannel(String)}
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
        //       at mao.aggregate_pay_merchant_application.controller.PlatformParamController.queryPayChannelByPlatformChannel(PlatformParamController.java:86)
        //   In order to prevent queryPayChannelByPlatformChannel(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPayChannelByPlatformChannel(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PlatformParamController()).queryPayChannelByPlatformChannel("Platform Channel Code");
    }

    /**
     * Method under test: {@link PlatformParamController#createPayChannelParam(PayChannelParamDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePayChannelParam()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantId(SecurityUtil.java:105)
        //       at mao.aggregate_pay_merchant_application.controller.PlatformParamController.createPayChannelParam(PlatformParamController.java:111)
        //   In order to prevent createPayChannelParam(PayChannelParamDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createPayChannelParam(PayChannelParamDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        PlatformParamController platformParamController = new PlatformParamController();
        platformParamController.createPayChannelParam(new PayChannelParamDTO());
    }

    /**
     * Method under test: {@link PlatformParamController#queryPayChannelParam(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPayChannelParam()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.controller.PlatformParamController.queryPayChannelParam(PlatformParamController.java:146)
        //   In order to prevent queryPayChannelParam(String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPayChannelParam(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PlatformParamController()).queryPayChannelParam("42", "Platform Channel");
    }

    /**
     * Method under test: {@link PlatformParamController#queryPayChannelParam(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPayChannelParam2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.controller.PlatformParamController.queryPayChannelParam(PlatformParamController.java:176)
        //   In order to prevent queryPayChannelParam(String, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPayChannelParam(String, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PlatformParamController()).queryPayChannelParam("42", "Platform Channel", "Pay Channel");
    }
}

