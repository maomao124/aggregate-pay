package mao.aggregate_pay_common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StringUtilTest
{
    /**
     * Method under test: {@link StringUtil#builder()}
     */
    @Test
    void testBuilder()
    {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     AbstractStringBuilder.count
        //     AbstractStringBuilder.value

        StringUtil.builder();
    }

    /**
     * Method under test: {@link StringUtil#builder(int)}
     */
    @Test
    void testBuilder2()
    {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by builder(int)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        StringUtil.builder(3);
    }

    /**
     * Method under test: {@link StringUtil#builder(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBuilder3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NegativeArraySizeException
        //       at java.lang.AbstractStringBuilder.<init>(AbstractStringBuilder.java:68)
        //       at java.lang.StringBuilder.<init>(StringBuilder.java:106)
        //       at mao.aggregate_pay_common.utils.StringUtil.builder(StringUtil.java:214)
        //   In order to prevent builder(int)
        //   from throwing NegativeArraySizeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   builder(int).
        //   See https://diff.blue/R013 to resolve this issue.

        StringUtil.builder(-1);
    }

    /**
     * Method under test: {@link StringUtil#builder(String[])}
     */
    @Test
    void testBuilder4()
    {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     AbstractStringBuilder.count
        //     AbstractStringBuilder.value

        StringUtil.builder("Strs");
    }

    /**
     * Method under test: {@link StringUtil#bytes(String, String)}
     */
    @Test
    void testBytes()
    {
        byte[] actualBytesResult = StringUtil.bytes("Str", "UTF-8");
        assertEquals(3, actualBytesResult.length);
        assertEquals('S', actualBytesResult[0]);
        assertEquals('t', actualBytesResult[1]);
        assertEquals('r', actualBytesResult[2]);
    }

    /**
     * Method under test: {@link StringUtil#bytes(String, String)}
     */
    @Test
    void testBytes2()
    {
        assertNull(StringUtil.bytes(null, null));
    }

    /**
     * Method under test: {@link StringUtil#bytes(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBytes3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.nio.charset.UnsupportedCharsetException: Charset
        //       at java.nio.charset.Charset.forName(Charset.java:531)
        //       at mao.aggregate_pay_common.utils.StringUtil.bytes(StringUtil.java:249)
        //   In order to prevent bytes(String, String)
        //   from throwing UnsupportedCharsetException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   bytes(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        StringUtil.bytes("Str", "Charset");
    }

    /**
     * Method under test: {@link StringUtil#bytes(String, String)}
     */
    @Test
    void testBytes4()
    {
        assertNull(StringUtil.bytes("Str", null));
    }

    /**
     * Method under test: {@link StringUtil#bytes(String, String)}
     */
    @Test
    void testBytes5()
    {
        assertNull(StringUtil.bytes("Str", StringUtil.EMPTY));
    }
}

