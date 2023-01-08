package mao.aggregate_pay_common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StringUtilTest
{
    /**
     * Method under test: {@link StringUtil#isBlank(String)}
     */
    @Test
    void testIsBlank()
    {
        assertFalse(StringUtil.isBlank("Str"));
        assertTrue(StringUtil.isBlank(null));
        assertTrue(StringUtil.isBlank(StringUtil.EMPTY));
    }

    /**
     * Method under test: {@link StringUtil#isNotBlank(String)}
     */
    @Test
    void testIsNotBlank()
    {
        assertTrue(StringUtil.isNotBlank("Str"));
        assertFalse(StringUtil.isNotBlank(null));
        assertFalse(StringUtil.isNotBlank(StringUtil.EMPTY));
    }

    /**
     * Method under test: {@link StringUtil#isEmpty(String)}
     */
    @Test
    void testIsEmpty()
    {
        assertFalse(StringUtil.isEmpty("Str"));
        assertTrue(StringUtil.isEmpty(null));
        assertTrue(StringUtil.isEmpty(StringUtil.EMPTY));
    }

    /**
     * Method under test: {@link StringUtil#isNotEmpty(String)}
     */
    @Test
    void testIsNotEmpty()
    {
        assertTrue(StringUtil.isNotEmpty("Str"));
        assertFalse(StringUtil.isNotEmpty(null));
        assertFalse(StringUtil.isNotEmpty(StringUtil.EMPTY));
    }

    /**
     * Method under test: {@link StringUtil#isWrap(String, char)}
     */
    @Test
    void testIsWrap()
    {
        assertFalse(StringUtil.isWrap("Str", 'A'));
        assertFalse(StringUtil.isWrap("Str", 'S'));
        assertFalse(StringUtil.isWrap("Str", 'A', 'A'));
        assertFalse(StringUtil.isWrap("Str", 'S', 'A'));
        assertTrue(StringUtil.isWrap("Str", 'S', 'r'));
        assertFalse(StringUtil.isWrap("Str", "Wrapper"));
        assertTrue(StringUtil.isWrap("foo", "foo"));
        assertFalse(StringUtil.isWrap("Str", "Prefix", "Suffix"));
        assertTrue(StringUtil.isWrap("foo", "foo", "foo"));
        assertFalse(StringUtil.isWrap("Str", StringUtil.EMPTY, "Suffix"));
    }

    /**
     * Method under test: {@link StringUtil#isWrap(String, char)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsWrap2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.StringIndexOutOfBoundsException: String index out of range: 0
        //       at java.lang.String.charAt(String.java:658)
        //       at mao.aggregate_pay_common.utils.StringUtil.isWrap(StringUtil.java:148)
        //       at mao.aggregate_pay_common.utils.StringUtil.isWrap(StringUtil.java:135)
        //   In order to prevent isWrap(String, char)
        //   from throwing StringIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   isWrap(String, char).
        //   See https://diff.blue/R013 to resolve this issue.

        StringUtil.isWrap(StringUtil.EMPTY, 'A');
    }

    /**
     * Method under test: {@link StringUtil#isWrap(String, char, char)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsWrap3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.StringIndexOutOfBoundsException: String index out of range: 0
        //       at java.lang.String.charAt(String.java:658)
        //       at mao.aggregate_pay_common.utils.StringUtil.isWrap(StringUtil.java:148)
        //   In order to prevent isWrap(String, char, char)
        //   from throwing StringIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   isWrap(String, char, char).
        //   See https://diff.blue/R013 to resolve this issue.

        StringUtil.isWrap(StringUtil.EMPTY, 'A', 'A');
    }

    /**
     * Method under test: {@link StringUtil#padPre(String, int, char)}
     */
    @Test
    void testPadPre()
    {
        assertEquals("Str", StringUtil.padPre("Str", 3, 'A'));
        assertEquals("A42", StringUtil.padPre("42", 3, 'A'));
    }

    /**
     * Method under test: {@link StringUtil#padEnd(String, int, char)}
     */
    @Test
    void testPadEnd()
    {
        assertEquals("Str", StringUtil.padEnd("Str", 3, 'A'));
        assertEquals("42A", StringUtil.padEnd("42", 3, 'A'));
    }

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
     * Method under test: {@link StringUtil#builder()}
     */
    @Test
    void testBuilder5()
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
    void testBuilder6()
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
    void testBuilder7()
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
    void testBuilder8()
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

    /**
     * Method under test: {@link StringUtil#bytes(String, String)}
     */
    @Test
    void testBytes6()
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
    void testBytes7()
    {
        assertNull(StringUtil.bytes(null, null));
    }

    /**
     * Method under test: {@link StringUtil#bytes(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBytes8()
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
    void testBytes9()
    {
        assertNull(StringUtil.bytes("Str", null));
    }

    /**
     * Method under test: {@link StringUtil#bytes(String, String)}
     */
    @Test
    void testBytes10()
    {
        assertNull(StringUtil.bytes("Str", StringUtil.EMPTY));
    }

    /**
     * Method under test: {@link StringUtil#isInteger(String)}
     */
    @Test
    void testIsInteger()
    {
        assertFalse(StringUtil.isInteger("Input"));
        assertTrue(StringUtil.isInteger("444"));
    }

    /**
     * Method under test: {@link StringUtil#stringToIntegerArray(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testStringToIntegerArray()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Str"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Integer.parseInt(Integer.java:580)
        //       at java.lang.Integer.parseInt(Integer.java:615)
        //       at mao.aggregate_pay_common.utils.StringUtil.stringToIntegerArray(StringUtil.java:275)
        //   In order to prevent stringToIntegerArray(String[])
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   stringToIntegerArray(String[]).
        //   See https://diff.blue/R013 to resolve this issue.

        StringUtil.stringToIntegerArray(new String[]{"Str"});
    }

    /**
     * Method under test: {@link StringUtil#stringToIntegerArray(String[])}
     */
    @Test
    void testStringToIntegerArray2()
    {
        Integer[] actualStringToIntegerArrayResult = StringUtil.stringToIntegerArray(new String[]{"42"});
        assertEquals(1, actualStringToIntegerArrayResult.length);
        assertEquals(42, actualStringToIntegerArrayResult[0]);
    }

    /**
     * Method under test: {@link StringUtil#stringTOLongArray(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testStringTOLongArray()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Str"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.parseLong(Long.java:631)
        //       at mao.aggregate_pay_common.utils.StringUtil.stringTOLongArray(StringUtil.java:291)
        //   In order to prevent stringTOLongArray(String[])
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   stringTOLongArray(String[]).
        //   See https://diff.blue/R013 to resolve this issue.

        StringUtil.stringTOLongArray(new String[]{"Str"});
    }

    /**
     * Method under test: {@link StringUtil#stringTOLongArray(String[])}
     */
    @Test
    void testStringTOLongArray2()
    {
        Long[] actualStringTOLongArrayResult = StringUtil.stringTOLongArray(new String[]{"42"});
        assertEquals(1, actualStringTOLongArrayResult.length);
        assertEquals(42L, actualStringTOLongArrayResult[0]);
    }

    /**
     * Method under test: {@link StringUtil#getFileExt(String)}
     */
    @Test
    void testGetFileExt()
    {
        assertEquals("Src", StringUtil.getFileExt("Src"));
    }

    /**
     * Method under test: {@link StringUtil#getFileName(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetFileName()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.StringIndexOutOfBoundsException: String index out of range: -1
        //       at java.lang.String.substring(String.java:1967)
        //       at mao.aggregate_pay_common.utils.StringUtil.getFileName(StringUtil.java:321)
        //   In order to prevent getFileName(String)
        //   from throwing StringIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getFileName(String).
        //   See https://diff.blue/R013 to resolve this issue.

        StringUtil.getFileName("Src");
    }

    /**
     * Method under test: {@link StringUtil#getFileName(String)}
     */
    @Test
    void testGetFileName2()
    {
        assertEquals(StringUtil.EMPTY, StringUtil.getFileName(StringUtil.DOT));
    }

    /**
     * Method under test: {@link StringUtil#isNull(String)}
     */
    @Test
    void testIsNull()
    {
        assertFalse(StringUtil.isNull("Src"));
        assertTrue(StringUtil.isNull(null));
        assertTrue(StringUtil.isNull(StringUtil.EMPTY));
    }

    /**
     * Method under test: {@link StringUtil#checkArrayValue(String[], String)}
     */
    @Test
    void testCheckArrayValue()
    {
        assertFalse(StringUtil.checkArrayValue(new String[]{"Arr"}, "42"));
        assertFalse(StringUtil.checkArrayValue(null, "foo"));
        assertTrue(StringUtil.checkArrayValue(new String[]{"42"}, "42"));
        assertFalse(StringUtil.checkArrayValue(new String[]{}, "42"));
    }

    /**
     * Method under test: {@link StringUtil#checkArrayValue(String[], String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCheckArrayValue2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_common.utils.StringUtil.checkArrayValue(StringUtil.java:350)
        //   In order to prevent checkArrayValue(String[], String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   checkArrayValue(String[], String).
        //   See https://diff.blue/R013 to resolve this issue.

        StringUtil.checkArrayValue(new String[]{null}, "42");
    }

    /**
     * Method under test: {@link StringUtil#isContains(String[], String)}
     */
    @Test
    void testIsContains()
    {
        assertFalse(StringUtil.isContains(new String[]{"Arr"}, "42"));
        assertFalse(StringUtil.isContains(null, "foo"));
        assertTrue(StringUtil.isContains(new String[]{"42"}, "42"));
        assertFalse(StringUtil.isContains(new String[]{}, "42"));
    }

    /**
     * Method under test: {@link StringUtil#isContains(String[], String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsContains2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.lang.String.contains(String.java:2133)
        //       at mao.aggregate_pay_common.utils.StringUtil.isContains(StringUtil.java:374)
        //   In order to prevent isContains(String[], String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   isContains(String[], String).
        //   See https://diff.blue/R013 to resolve this issue.

        StringUtil.isContains(new String[]{null}, "42");
    }
}

