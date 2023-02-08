package mao.aggregate_pay_uaa_service.utils;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class IPUtilsTest
{
    /**
     * Method under test: {@link IPUtils#setIP(String)}
     */
    @Test
    void testSetIP()
    {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by setIP(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        IPUtils.setIP("127.0.0.1");
    }

    /**
     * Method under test: {@link IPUtils#getIP()}
     */
    @Test
    void testGetIP()
    {
        assertNull(IPUtils.getIP());
    }

    /**
     * Method under test: {@link IPUtils#removeIP()}
     */
    @Test
    void testRemoveIP()
    {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        IPUtils.removeIP();
    }
}

