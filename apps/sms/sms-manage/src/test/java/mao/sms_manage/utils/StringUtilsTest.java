package mao.sms_manage.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StringUtilsTest
{
    /**
     * Method under test: {@link StringUtils#autoGenericCode(Integer, int)}
     */
    @Test
    void testAutoGenericCode()
    {
        assertEquals("0000000001", StringUtils.autoGenericCode(1, 10));
    }

    /**
     * Method under test: {@link StringUtils#autoGenericCode(Integer, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAutoGenericCode2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.DuplicateFormatFlagsException: Flags = '0'
        //       at java.util.Formatter$Flags.parse(Formatter.java:4443)
        //       at java.util.Formatter$FormatSpecifier.flags(Formatter.java:2640)
        //       at java.util.Formatter$FormatSpecifier.<init>(Formatter.java:2709)
        //       at java.util.Formatter.parse(Formatter.java:2560)
        //       at java.util.Formatter.format(Formatter.java:2501)
        //       at java.util.Formatter.format(Formatter.java:2455)
        //       at java.lang.String.format(String.java:2940)
        //       at mao.sms_manage.utils.StringUtils.autoGenericCode(StringUtils.java:28)
        //   In order to prevent autoGenericCode(Integer, int)
        //   from throwing DuplicateFormatFlagsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   autoGenericCode(Integer, int).
        //   See https://diff.blue/R013 to resolve this issue.

        StringUtils.autoGenericCode(1, 0);
    }
}

