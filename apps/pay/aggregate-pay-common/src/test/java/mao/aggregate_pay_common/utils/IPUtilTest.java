package mao.aggregate_pay_common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

class IPUtilTest
{
    /**
     * Method under test: {@link IPUtil#getIpAddr(javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testGetIpAddr()
    {
        assertEquals("127.0.0.1", IPUtil.getIpAddr(new MockHttpServletRequest()));
    }

    /**
     * Method under test: {@link IPUtil#getIpAddr(javax.servlet.http.HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetIpAddr2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_common.utils.IPUtil.getIpAddr(IPUtil.java:31)
        //   In order to prevent getIpAddr(HttpServletRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getIpAddr(HttpServletRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        IPUtil.getIpAddr(null);
    }

    /**
     * Method under test: {@link IPUtil#getIpAddr(javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testGetIpAddr3()
    {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setRemoteAddr("https://example.org/example");
        assertEquals("https://example.org/example", IPUtil.getIpAddr(mockHttpServletRequest));
    }

    /**
     * Method under test: {@link IPUtil#getIpAddr(javax.servlet.http.HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetIpAddr4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_common.utils.IPUtil.getIpAddr(IPUtil.java:63)
        //   In order to prevent getIpAddr(HttpServletRequest)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getIpAddr(HttpServletRequest).
        //   See https://diff.blue/R013 to resolve this issue.

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setRemoteAddr(null);
        IPUtil.getIpAddr(mockHttpServletRequest);
    }

    /**
     * Method under test: {@link IPUtil#getIpAddr(javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testGetIpAddr5()
    {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setRemoteAddr("0:0:0:0:0:0:1");
        assertEquals("127.0.0.1", IPUtil.getIpAddr(mockHttpServletRequest));
    }
}

