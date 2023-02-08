package mao.aggregate_pay_transaction_service.controller;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;

class PayTestControllerTest
{
    /**
     * Method under test: {@link PayTestController#alipayTest(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAlipayTest()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.PayTestController.alipayTest(PayTestController.java:57)
        //   In order to prevent alipayTest(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   alipayTest(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PayTestController()).alipayTest("Out trade no");
    }

    /**
     * Method under test: {@link PayTestController#alipayTest2(String, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAlipayTest2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.apache.catalina.connector.Response.isCommitted(Response.java:618)
        //       at org.apache.catalina.connector.Response.setHeader(Response.java:1386)
        //       at mao.aggregate_pay_transaction_service.controller.PayTestController.alipayTest2(PayTestController.java:104)
        //   In order to prevent alipayTest2(String, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   alipayTest2(String, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        PayTestController payTestController = new PayTestController();
        payTestController.alipayTest2("Out trade no", new Response());
    }

    /**
     * Method under test: {@link PayTestController#alipayTest2(String, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAlipayTest22()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.PayTestController.alipayTest2(PayTestController.java:106)
        //   In order to prevent alipayTest2(String, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   alipayTest2(String, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        PayTestController payTestController = new PayTestController();
        payTestController.alipayTest2("Out trade no", new MockHttpServletResponse());
    }
}

