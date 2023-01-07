package mao.aggregate_pay_common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AmountUtilTest
{
    /**
     * Method under test: {@link AmountUtil#changeF2Y(Long)}
     */
    @Test
    void testChangeF2Y() throws Exception
    {
        assertEquals("0.10", AmountUtil.changeF2Y(10L));
        assertEquals("0.01", AmountUtil.changeF2Y(1L));
        assertEquals("0.45", AmountUtil.changeF2Y(45L));
        assertEquals("0.49", AmountUtil.changeF2Y(49L));
        assertEquals("0.02", AmountUtil.changeF2Y(2L));
        assertEquals("0.00", AmountUtil.changeF2Y(0L));
        assertEquals("-0.01", AmountUtil.changeF2Y(-1L));
        assertEquals("92,233,720,368,547,758.07", AmountUtil.changeF2Y(Long.MAX_VALUE));
        assertEquals("-92,233,720,368,547,758.08", AmountUtil.changeF2Y(Long.MIN_VALUE));
        assertEquals("0.1", AmountUtil.changeF2Y("10"));
        assertThrows(Exception.class, () -> AmountUtil.changeF2Y("foo"));
        assertEquals("4.44", AmountUtil.changeF2Y("444"));
        assertEquals("0.42", AmountUtil.changeF2Y("42"));
        assertEquals("10.1", AmountUtil.changeF2Y("1010"));
        assertEquals("104.44", AmountUtil.changeF2Y("10444"));
        assertEquals("10.42", AmountUtil.changeF2Y("1042"));
        assertEquals("444.1", AmountUtil.changeF2Y("44410"));
        assertEquals("4444.44", AmountUtil.changeF2Y("444444"));
        assertEquals("444.42", AmountUtil.changeF2Y("44442"));
        assertEquals("42.1", AmountUtil.changeF2Y("4210"));
        assertEquals("424.44", AmountUtil.changeF2Y("42444"));
        assertEquals("42.42", AmountUtil.changeF2Y("4242"));
        assertEquals("1010.1", AmountUtil.changeF2Y("101010"));
        assertEquals("10104.44", AmountUtil.changeF2Y("1010444"));
        assertEquals("1010.42", AmountUtil.changeF2Y("101042"));
        assertEquals("10444.1", AmountUtil.changeF2Y("1044410"));
        assertEquals("104444.44", AmountUtil.changeF2Y("10444444"));
        assertEquals("10444.42", AmountUtil.changeF2Y("1044442"));
        assertEquals("1042.1", AmountUtil.changeF2Y("104210"));
        assertEquals("10424.44", AmountUtil.changeF2Y("1042444"));
        assertEquals("1042.42", AmountUtil.changeF2Y("104242"));
        assertEquals("44410.1", AmountUtil.changeF2Y("4441010"));
        assertEquals("444104.44", AmountUtil.changeF2Y("44410444"));
        assertEquals("44410.42", AmountUtil.changeF2Y("4441042"));
        assertEquals("444444.1", AmountUtil.changeF2Y("44444410"));
        assertEquals("4444444.44", AmountUtil.changeF2Y("444444444"));
        assertEquals("444444.42", AmountUtil.changeF2Y("44444442"));
        assertEquals("44442.1", AmountUtil.changeF2Y("4444210"));
        assertEquals("444424.44", AmountUtil.changeF2Y("44442444"));
        assertEquals("44442.42", AmountUtil.changeF2Y("4444242"));
        assertEquals("4210.1", AmountUtil.changeF2Y("421010"));
        assertEquals("42104.44", AmountUtil.changeF2Y("4210444"));
        assertEquals("4210.42", AmountUtil.changeF2Y("421042"));
        assertEquals("42444.1", AmountUtil.changeF2Y("4244410"));
        assertEquals("424444.44", AmountUtil.changeF2Y("42444444"));
        assertEquals("42444.42", AmountUtil.changeF2Y("4244442"));
        assertEquals("4242.1", AmountUtil.changeF2Y("424210"));
        assertEquals("42424.44", AmountUtil.changeF2Y("4242444"));
        assertEquals("4242.42", AmountUtil.changeF2Y("424242"));
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(Long)}
     */
    @Test
    void testChangeY2F()
    {
        assertEquals("1000", AmountUtil.changeY2F(10L));
        assertEquals("1000", AmountUtil.changeY2F("10"));
        assertEquals("0", AmountUtil.changeY2F("$"));
        assertEquals("0", AmountUtil.changeY2F("."));
        assertEquals("1000", AmountUtil.changeY2F("10$"));
        assertEquals("1000", AmountUtil.changeY2F("$10"));
        assertEquals("0", AmountUtil.changeY2F("$$"));
        assertEquals("0", AmountUtil.changeY2F("$."));
        assertEquals("0", AmountUtil.changeY2F("$00"));
        assertEquals("4200", AmountUtil.changeY2F("$42"));
        assertEquals("10", AmountUtil.changeY2F(".10"));
        assertEquals("0", AmountUtil.changeY2F(".$"));
        assertEquals("0", AmountUtil.changeY2F(".."));
        assertEquals("0", AmountUtil.changeY2F("00$"));
        assertEquals("4200", AmountUtil.changeY2F("42$"));
        assertEquals("101000", AmountUtil.changeY2F("1010$"));
        assertEquals("101000", AmountUtil.changeY2F("10$10"));
        assertEquals("1000", AmountUtil.changeY2F("10$$"));
        assertEquals("1000", AmountUtil.changeY2F("10$."));
        assertEquals("100000", AmountUtil.changeY2F("10$00"));
        assertEquals("104200", AmountUtil.changeY2F("10$42"));
        assertEquals("1000", AmountUtil.changeY2F("10.$"));
        assertEquals("100000", AmountUtil.changeY2F("1000$"));
        assertEquals("104200", AmountUtil.changeY2F("1042$"));
        assertEquals("101000", AmountUtil.changeY2F("$1010"));
        assertEquals("1000", AmountUtil.changeY2F("$10$"));
        assertEquals("1000", AmountUtil.changeY2F("$10."));
        assertEquals("100000", AmountUtil.changeY2F("$1000"));
        assertEquals("104200", AmountUtil.changeY2F("$1042"));
        assertEquals("1000", AmountUtil.changeY2F("$$10"));
        assertEquals("0", AmountUtil.changeY2F("$$$"));
        assertEquals("0", AmountUtil.changeY2F("$$."));
        assertEquals("0", AmountUtil.changeY2F("$$00"));
        assertEquals("4200", AmountUtil.changeY2F("$$42"));
        assertEquals("10", AmountUtil.changeY2F("$.10"));
        assertEquals("0", AmountUtil.changeY2F("$.$"));
        assertEquals("0", AmountUtil.changeY2F("$.."));
        assertEquals("0", AmountUtil.changeY2F("$.00"));
        assertEquals("42", AmountUtil.changeY2F("$.42"));
        assertEquals("1000", AmountUtil.changeY2F("$0010"));
        assertEquals("0", AmountUtil.changeY2F("$00$"));
        assertEquals("0", AmountUtil.changeY2F("$00."));
        assertEquals("0", AmountUtil.changeY2F("$0000"));
        assertEquals("4200", AmountUtil.changeY2F("$0042"));
        assertEquals("421000", AmountUtil.changeY2F("$4210"));
        assertEquals("4200", AmountUtil.changeY2F("$42$"));
        assertEquals("4200", AmountUtil.changeY2F("$42."));
        assertEquals("420000", AmountUtil.changeY2F("$4200"));
        assertEquals("424200", AmountUtil.changeY2F("$4242"));
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "foo00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("foo");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F6()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F7()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F8()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F9()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\1000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,10");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F10()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F11()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F12()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:134)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,.");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F13()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\0000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,00");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F14()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F15()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F16()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\4200"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,42");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F17()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F18()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:126)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F(".\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F19()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "00\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("00\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F20()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("Amount$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F21()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Amount\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("Amount\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F22()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\-?[0-9]+$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F23()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-?[0-9]+\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\-?[0-9]+\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F24()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "42\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("42\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F25()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("金额格式有误$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F26()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额格式有误\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("金额格式有误\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F27()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "1010\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("1010\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F28()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10$\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F29()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10$Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F30()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10$\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F31()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10$金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F32()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\|\|\1000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10\\$|\\￥|\\,10");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F33()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10\\$|\\￥|\\,$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F34()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\|\|\\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10\\$|\\￥|\\,\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F35()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:134)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10\\$|\\￥|\\,.");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F36()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\|\|\0000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10\\$|\\￥|\\,00");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F37()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\|\|\Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10\\$|\\￥|\\,Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F38()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\|\|\\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10\\$|\\￥|\\,\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F39()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\|\|\4200"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10\\$|\\￥|\\,42");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F40()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\|\|\金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10\\$|\\￥|\\,金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F41()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\|"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:126)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10.\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F42()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "1000\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("1000\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F43()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10Amount$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F44()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10Amount\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10Amount\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F45()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10\\-?[0-9]+$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F46()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\-?[0-9]+\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10\\-?[0-9]+\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F47()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "1042\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("1042\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F48()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10金额格式有误$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F49()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10金额格式有误\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("10金额格式有误\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F50()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$10\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F51()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$10Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F52()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$10\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F53()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "10金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$10金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F54()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$$\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F55()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$$Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F56()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$$\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F57()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$$金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F58()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\1000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\$|\\￥|\\,10");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F59()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\$|\\￥|\\,$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F60()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\$|\\￥|\\,\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F61()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:134)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\$|\\￥|\\,.");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F62()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\0000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\$|\\￥|\\,00");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F63()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\$|\\￥|\\,Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F64()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\$|\\￥|\\,\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F65()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\4200"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\$|\\￥|\\,42");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F66()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\$|\\￥|\\,金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F67()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:126)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$.\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F68()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Am"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:126)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$.Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F69()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:126)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$.\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F70()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:126)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$.金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F71()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "00\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$00\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F72()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "00Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$00Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F73()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "00\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$00\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F74()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "00金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$00金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F75()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Amount1000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$Amount10");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F76()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$Amount$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F77()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Amount\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$Amount\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F78()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:134)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$Amount.");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F79()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Amount0000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$Amount00");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F80()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "AmountAmount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$AmountAmount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F81()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Amount\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$Amount\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F82()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Amount4200"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$Amount42");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F83()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Amount金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$Amount金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F84()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-?[0-9]+1000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\-?[0-9]+10");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F85()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\-?[0-9]+$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F86()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-?[0-9]+\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\-?[0-9]+\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F87()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:134)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\-?[0-9]+.");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F88()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-?[0-9]+0000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\-?[0-9]+00");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F89()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-?[0-9]+Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\-?[0-9]+Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F90()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-?[0-9]+\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\-?[0-9]+\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F91()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-?[0-9]+4200"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\-?[0-9]+42");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F92()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\-?[0-9]+金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$\\-?[0-9]+金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F93()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "42\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$42\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F94()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "42Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$42Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F95()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "42\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$42\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F96()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "42金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$42金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F97()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额格式有误1000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$金额格式有误10");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F98()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$金额格式有误$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F99()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额格式有误\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$金额格式有误\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F100()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:134)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$金额格式有误.");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F101()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额格式有误0000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$金额格式有误00");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F102()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额格式有误Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$金额格式有误Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F103()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额格式有误\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$金额格式有误\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F104()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额格式有误4200"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$金额格式有误42");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F105()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "金额格式有误金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("$金额格式有误金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F106()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\101000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,1010");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F107()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\1000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,10$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F108()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\10\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,10\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F109()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\1000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:134)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,10.");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F110()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\100000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,1000");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F111()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\10Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,10Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F112()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\10\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,10\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F113()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\104200"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,1042");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F114()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\10金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,10金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F115()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\1000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,$10");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F116()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,$$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F117()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,$\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F118()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:134)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,$.");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F119()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\0000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,$00");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F120()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,$Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F121()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,$\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F122()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\4200"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,$42");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F123()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,$金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F124()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\|\|\1000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\$|\\￥|\\,10");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F125()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\$|\\￥|\\,$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F126()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\|\|\\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\$|\\￥|\\,\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F127()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:134)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\$|\\￥|\\,.");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F128()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\|\|\0000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\$|\\￥|\\,00");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F129()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\|\|\Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\$|\\￥|\\,Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F130()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\|\|\\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\$|\\￥|\\,\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F131()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\|\|\4200"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\$|\\￥|\\,42");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F132()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\|\|\金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\$|\\￥|\\,金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F133()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\10"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:126)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,.10");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F134()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:134)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,.$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F135()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\|"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:126)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,.\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F136()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\0"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:130)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,..");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F137()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:126)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,.00");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F138()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\Am"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:126)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,.Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F139()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\-"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:126)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,.\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F140()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\42"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:126)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,.42");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F141()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\金额"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:126)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,.金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F142()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\001000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,0010");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F143()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\0000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,00$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F144()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,00\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F145()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\0000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:134)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,00.");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F146()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\000000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,0000");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F147()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,00Amount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F148()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,00\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F149()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\004200"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,0042");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F150()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\00金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,00金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F151()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\Amount1000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,Amount10");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F152()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,Amount$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F153()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\Amount\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,Amount\\$|\\￥|\\,");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F154()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\Amount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:134)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,Amount.");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F155()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\Amount0000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,Amount00");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F156()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\AmountAmount00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,AmountAmount");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F157()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\Amount\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,Amount\\-?[0-9]+");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F158()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\Amount4200"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,Amount42");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F159()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\Amount金额格式有误00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,Amount金额格式有误");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F160()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\-?[0-9]+1000"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\-?[0-9]+10");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F161()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\-?[0-9]+00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\-?[0-9]+$");
    }

    /**
     * Method under test: {@link AmountUtil#changeY2F(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeY2F162()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "\|\|\\-?[0-9]+\|\|\00"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Long.parseLong(Long.java:589)
        //       at java.lang.Long.valueOf(Long.java:803)
        //       at mao.aggregate_pay_common.utils.AmountUtil.changeY2F(AmountUtil.java:122)
        //   In order to prevent changeY2F(String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeY2F(String).
        //   See https://diff.blue/R013 to resolve this issue.

        AmountUtil.changeY2F("\\$|\\￥|\\,\\-?[0-9]+\\$|\\￥|\\,");
    }
}

