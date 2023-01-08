package mao.aggregate_pay_common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DateUtilTest
{
    /**
     * Method under test: {@link DateUtil#now()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testNow()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        DateUtil.now();
    }

    /**
     * Method under test: {@link DateUtil#toDateTime(LocalDateTime)}
     */
    @Test
    void testToDateTime()
    {
        assertEquals("0001-01-01 01:01:00", DateUtil.toDateTime(LocalDateTime.of(1, 1, 1, 1, 1)));
        assertEquals(StringUtil.EMPTY, DateUtil.toDateTime(LocalDateTime.of(1, 1, 1, 1, 1), StringUtil.EMPTY));
    }

    /**
     * Method under test: {@link DateUtil#toDateTime(LocalDateTime)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testToDateTime2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_common.utils.DateUtil.toDateTime(DateUtil.java:73)
        //       at mao.aggregate_pay_common.utils.DateUtil.toDateTime(DateUtil.java:61)
        //   In order to prevent toDateTime(LocalDateTime)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   toDateTime(LocalDateTime).
        //   See https://diff.blue/R013 to resolve this issue.

        DateUtil.toDateTime(null);
    }

    /**
     * Method under test: {@link DateUtil#toDateTime(LocalDateTime, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testToDateTime3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Unknown pattern letter: P
        //       at java.time.format.DateTimeFormatterBuilder.parsePattern(DateTimeFormatterBuilder.java:1672)
        //       at java.time.format.DateTimeFormatterBuilder.appendPattern(DateTimeFormatterBuilder.java:1581)
        //       at java.time.format.DateTimeFormatter.ofPattern(DateTimeFormatter.java:560)
        //       at mao.aggregate_pay_common.utils.DateUtil.toDateTime(DateUtil.java:73)
        //   In order to prevent toDateTime(LocalDateTime, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   toDateTime(LocalDateTime, String).
        //   See https://diff.blue/R013 to resolve this issue.

        DateUtil.toDateTime(LocalDateTime.of(1, 1, 1, 1, 1), "Pattern");
    }

    /**
     * Method under test: {@link DateUtil#toDateTime(LocalDateTime, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testToDateTime4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_common.utils.DateUtil.toDateTime(DateUtil.java:73)
        //   In order to prevent toDateTime(LocalDateTime, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   toDateTime(LocalDateTime, String).
        //   See https://diff.blue/R013 to resolve this issue.

        DateUtil.toDateTime(null, StringUtil.EMPTY);
    }

    /**
     * Method under test: {@link DateUtil#toDateText(LocalDate, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testToDateText()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Unknown pattern letter: P
        //       at java.time.format.DateTimeFormatterBuilder.parsePattern(DateTimeFormatterBuilder.java:1672)
        //       at java.time.format.DateTimeFormatterBuilder.appendPattern(DateTimeFormatterBuilder.java:1581)
        //       at java.time.format.DateTimeFormatter.ofPattern(DateTimeFormatter.java:560)
        //       at mao.aggregate_pay_common.utils.DateUtil.toDateText(DateUtil.java:90)
        //   In order to prevent toDateText(LocalDate, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   toDateText(LocalDate, String).
        //   See https://diff.blue/R013 to resolve this issue.

        DateUtil.toDateText(LocalDate.ofEpochDay(1L), "Pattern");
    }

    /**
     * Method under test: {@link DateUtil#toDateText(LocalDate, String)}
     */
    @Test
    void testToDateText2()
    {
        assertNull(DateUtil.toDateText(null, null));
    }

    /**
     * Method under test: {@link DateUtil#toDateText(LocalDate, String)}
     */
    @Test
    void testToDateText3()
    {
        assertNull(DateUtil.toDateText(LocalDate.ofEpochDay(1L), null));
    }

    /**
     * Method under test: {@link DateUtil#toDateText(LocalDate, String)}
     */
    @Test
    void testToDateText4()
    {
        assertEquals(StringUtil.EMPTY, DateUtil.toDateText(LocalDate.ofEpochDay(1L), StringUtil.EMPTY));
    }

    /**
     * Method under test: {@link DateUtil#addExtraHour(Date, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddExtraHour()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        DateUtil.addExtraHour(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), 2);
    }

    /**
     * Method under test: {@link DateUtil#addExtraHour(Date, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddExtraHour2()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        DateUtil.addExtraHour(null, 1);
    }

    /**
     * Method under test: {@link DateUtil#addExtraHour(Date, int)}
     */
    @Test
    void testAddExtraHour3()
    {
        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getTime()).thenReturn(10L);
        DateUtil.addExtraHour(timestamp, 2);
        verify(timestamp).getTime();
    }

    /**
     * Method under test: {@link DateUtil#increaseDay2Date(Date, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIncreaseDay2Date()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        DateUtil.increaseDay2Date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), 1);
    }

    /**
     * Method under test: {@link DateUtil#increaseDay2Date(Date, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIncreaseDay2Date2()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        DateUtil.increaseDay2Date(null, 1);
    }

    /**
     * Method under test: {@link DateUtil#increaseDay2Date(Date, int)}
     */
    @Test
    void testIncreaseDay2Date3()
    {
        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getTime()).thenReturn(10L);
        DateUtil.increaseDay2Date(timestamp, 1);
        verify(timestamp).getTime();
    }

    /**
     * Method under test: {@link DateUtil#format(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFormat()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Illegal pattern character 'o'
        //       at java.text.SimpleDateFormat.compile(SimpleDateFormat.java:826)
        //       at java.text.SimpleDateFormat.initialize(SimpleDateFormat.java:634)
        //       at java.text.SimpleDateFormat.<init>(SimpleDateFormat.java:605)
        //       at java.text.SimpleDateFormat.<init>(SimpleDateFormat.java:580)
        //       at mao.aggregate_pay_common.utils.DateUtil.getFormatter(DateUtil.java:165)
        //       at mao.aggregate_pay_common.utils.DateUtil.format(DateUtil.java:147)
        //   In order to prevent format(String, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   format(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        DateUtil.format("2020-03-01", "Format");
    }

    /**
     * Method under test: {@link DateUtil#format(String, String)}
     */
    @Test
    void testFormat2()
    {
        assertNull(DateUtil.format((String) null, "foo"));
    }

    /**
     * Method under test: {@link DateUtil#format(String, String)}
     */
    @Test
    void testFormat3()
    {
        assertNull(DateUtil.format((String) StringUtil.EMPTY, "foo"));
    }

    /**
     * Method under test: {@link DateUtil#format(String, String)}
     */
    @Test
    void testFormat4()
    {
        Date actualDate = DateUtil.format("2020-03-01", "2020-03-01");
        assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(actualDate));
    }

    /**
     * Method under test: {@link DateUtil#format(String, String)}
     */
    @Test
    void testFormat5()
    {
        assertNull(DateUtil.format("2020-03-01", StringUtil.EMPTY));
    }

    /**
     * Method under test: {@link DateUtil#format(Date, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFormat6()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Illegal pattern character 'P'
        //       at java.text.SimpleDateFormat.compile(SimpleDateFormat.java:826)
        //       at java.text.SimpleDateFormat.initialize(SimpleDateFormat.java:634)
        //       at java.text.SimpleDateFormat.<init>(SimpleDateFormat.java:605)
        //       at java.text.SimpleDateFormat.<init>(SimpleDateFormat.java:580)
        //       at mao.aggregate_pay_common.utils.DateUtil.format(DateUtil.java:313)
        //   In order to prevent format(Date, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   format(Date, String).
        //   See https://diff.blue/R013 to resolve this issue.

        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        DateUtil.format(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), "Pattern");
    }

    /**
     * Method under test: {@link DateUtil#format(Date, String)}
     */
    @Test
    void testFormat7()
    {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        assertEquals(StringUtil.EMPTY,
                DateUtil.format(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), StringUtil.EMPTY));
    }

    /**
     * Method under test: {@link DateUtil#format(java.util.Date, String)}
     */
    @Test
    void testFormat8()
    {
        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getTime()).thenReturn(10L);
        assertEquals(StringUtil.EMPTY, DateUtil.format(timestamp, StringUtil.EMPTY));
        verify(timestamp).getTime();
    }

    /**
     * Method under test: {@link DateUtil#format(Date, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFormat9()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.util.Calendar.setTime(Calendar.java:1770)
        //       at java.text.SimpleDateFormat.format(SimpleDateFormat.java:943)
        //       at java.text.SimpleDateFormat.format(SimpleDateFormat.java:936)
        //       at java.text.DateFormat.format(DateFormat.java:345)
        //       at mao.aggregate_pay_common.utils.DateUtil.format(DateUtil.java:314)
        //   In order to prevent format(Date, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   format(Date, String).
        //   See https://diff.blue/R013 to resolve this issue.

        DateUtil.format((Date) null, StringUtil.EMPTY);
    }

    /**
     * Method under test: {@link DateUtil#getCurrDateTimeStr()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCurrDateTimeStr()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        DateUtil.getCurrDateTimeStr();
    }

    /**
     * Method under test: {@link DateUtil#getSpecifiedDayBefore(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSpecifiedDayBefore()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.util.Calendar.setTime(Calendar.java:1770)
        //       at mao.aggregate_pay_common.utils.DateUtil.getSpecifiedDayBefore(DateUtil.java:347)
        //   In order to prevent getSpecifiedDayBefore(String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getSpecifiedDayBefore(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        DateUtil.getSpecifiedDayBefore("Specified Day", "Format Str");
    }

    /**
     * Method under test: {@link DateUtil#getSpecifiedDayAfter(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSpecifiedDayAfter()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.util.Calendar.setTime(Calendar.java:1770)
        //       at mao.aggregate_pay_common.utils.DateUtil.getSpecifiedDayAfter(DateUtil.java:374)
        //   In order to prevent getSpecifiedDayAfter(String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getSpecifiedDayAfter(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        DateUtil.getSpecifiedDayAfter("Specified Day", "Format Str");
    }

    /**
     * Method under test: {@link DateUtil#getWeekFirstDay()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWeekFirstDay()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        DateUtil.getWeekFirstDay();
    }

    /**
     * Method under test: {@link DateUtil#getCurrentMonthFirstDay()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCurrentMonthFirstDay()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        DateUtil.getCurrentMonthFirstDay();
    }

    /**
     * Method under test: {@link DateUtil#getYesterdayStart()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetYesterdayStart()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        DateUtil.getYesterdayStart();
    }

    /**
     * Method under test: {@link DateUtil#getYesterdayEnd()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetYesterdayEnd()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        DateUtil.getYesterdayEnd();
    }

    /**
     * Method under test: {@link DateUtil#getCurrDayStart()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCurrDayStart()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        DateUtil.getCurrDayStart();
    }

    /**
     * Method under test: {@link DateUtil#getStartDayWithMonth(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetStartDayWithMonth() throws ParseException
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.text.ParseException: Unparseable date: "Month"
        //       at java.text.DateFormat.parse(DateFormat.java:366)
        //       at mao.aggregate_pay_common.utils.DateUtil.getStartDayWithMonth(DateUtil.java:455)
        //   In order to prevent getStartDayWithMonth(String)
        //   from throwing ParseException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getStartDayWithMonth(String).
        //   See https://diff.blue/R013 to resolve this issue.

        DateUtil.getStartDayWithMonth("Month");
    }

    /**
     * Method under test: {@link DateUtil#getEndDayWithMonth(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetEndDayWithMonth() throws ParseException
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.text.ParseException: Unparseable date: "Month"
        //       at java.text.DateFormat.parse(DateFormat.java:366)
        //       at mao.aggregate_pay_common.utils.DateUtil.getEndDayWithMonth(DateUtil.java:473)
        //   In order to prevent getEndDayWithMonth(String)
        //   from throwing ParseException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getEndDayWithMonth(String).
        //   See https://diff.blue/R013 to resolve this issue.

        DateUtil.getEndDayWithMonth("Month");
    }

    /**
     * Method under test: {@link DateUtil#getAllDaysOfMonthInString(Date, java.text.DateFormat)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllDaysOfMonthInString()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_common.utils.DateUtil.getAllDaysOfMonthInString(DateUtil.java:192)
        //   In order to prevent getAllDaysOfMonthInString(Date, DateFormat)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllDaysOfMonthInString(Date, DateFormat).
        //   See https://diff.blue/R013 to resolve this issue.

        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date month = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        DateUtil.getAllDaysOfMonthInString(month, new ISO8601DateFormat());
    }

    /**
     * Method under test: {@link DateUtil#getAllDaysOfMonthInString(Date, DateFormat)}
     */
    @Test
    void testGetAllDaysOfMonthInString2()
    {
        assertEquals(31, DateUtil.getAllDaysOfMonthInString(null, null).size());
    }

    /**
     * Method under test: {@link DateUtil#getAllDaysOfMonthInString(java.util.Date, java.text.DateFormat)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllDaysOfMonthInString3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_common.utils.DateUtil.getAllDaysOfMonthInString(DateUtil.java:192)
        //   In order to prevent getAllDaysOfMonthInString(Date, DateFormat)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllDaysOfMonthInString(Date, DateFormat).
        //   See https://diff.blue/R013 to resolve this issue.

        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getTime()).thenReturn(10L);
        DateUtil.getAllDaysOfMonthInString(timestamp, new ISO8601DateFormat());
    }

    /**
     * Method under test: {@link DateUtil#getAllDaysOfMonth(Date)}
     */
    @Test
    void testGetAllDaysOfMonth()
    {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        assertEquals(31,
                DateUtil.getAllDaysOfMonth(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())).size());
    }

    /**
     * Method under test: {@link DateUtil#getAllDaysOfMonth(Date)}
     */
    @Test
    void testGetAllDaysOfMonth2()
    {
        assertEquals(31, DateUtil.getAllDaysOfMonth(null).size());
    }

    /**
     * Method under test: {@link DateUtil#getAllDaysOfMonth(Date)}
     */
    @Test
    void testGetAllDaysOfMonth3()
    {
        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getTime()).thenReturn(10L);
        assertEquals(31, DateUtil.getAllDaysOfMonth(timestamp).size());
        verify(timestamp).getTime();
    }

    /**
     * Method under test: {@link DateUtil#getSpecifyDaysOfMonthInString(Date, Date, java.text.DateFormat)}
     */
    @Test
    void testGetSpecifyDaysOfMonthInString()
    {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date begin = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date end = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        assertTrue(DateUtil.getSpecifyDaysOfMonthInString(begin, end, new ISO8601DateFormat()).isEmpty());
    }

    /**
     * Method under test: {@link DateUtil#getSpecifyDaysOfMonthInString(Date, Date, DateFormat)}
     */
    @Test
    void testGetSpecifyDaysOfMonthInString2()
    {
        assertTrue(DateUtil.getSpecifyDaysOfMonthInString(null, null, null).isEmpty());
    }

    /**
     * Method under test: {@link DateUtil#getSpecifyDaysOfMonthInString(Date, Date, java.text.DateFormat)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSpecifyDaysOfMonthInString3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_common.utils.DateUtil.getSpecifyDaysOfMonthInString(DateUtil.java:241)
        //   In order to prevent getSpecifyDaysOfMonthInString(Date, Date, DateFormat)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getSpecifyDaysOfMonthInString(Date, Date, DateFormat).
        //   See https://diff.blue/R013 to resolve this issue.

        LocalDateTime atStartOfDayResult = LocalDate.of(-1, 1, 1).atStartOfDay();
        Date begin = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date end = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        DateUtil.getSpecifyDaysOfMonthInString(begin, end, new ISO8601DateFormat());
    }

    /**
     * Method under test: {@link DateUtil#getSpecifyDaysOfMonthInString(Date, Date, java.text.DateFormat)}
     */
    @Test
    void testGetSpecifyDaysOfMonthInString4()
    {
        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getTime()).thenReturn(10L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date end = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        assertTrue(DateUtil.getSpecifyDaysOfMonthInString(timestamp, end, new ISO8601DateFormat()).isEmpty());
        verify(timestamp).getTime();
    }

    /**
     * Method under test: {@link DateUtil#getSpecifyDaysOfMonth(Date, Date)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSpecifyDaysOfMonth()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date begin = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        DateUtil.getSpecifyDaysOfMonth(begin, Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
    }

    /**
     * Method under test: {@link DateUtil#getSpecifyDaysOfMonth(Date, Date)}
     */
    @Test
    void testGetSpecifyDaysOfMonth2()
    {
        assertTrue(DateUtil.getSpecifyDaysOfMonth(null, null).isEmpty());
    }

    /**
     * Method under test: {@link DateUtil#getSpecifyDaysOfMonth(Date, Date)}
     */
    @Test
    void testGetSpecifyDaysOfMonth3()
    {
        LocalDateTime atStartOfDayResult = LocalDate.of(-1, 1, 1).atStartOfDay();
        Date begin = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        assertEquals(1215,
                DateUtil.getSpecifyDaysOfMonth(begin, Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()))
                        .size());
    }

    /**
     * Method under test: {@link DateUtil#getSpecifyDaysOfMonth(Date, Date)}
     */
    @Test
    void testGetSpecifyDaysOfMonth4()
    {
        Timestamp timestamp = mock(Timestamp.class);
        when(timestamp.getTime()).thenReturn(10L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        DateUtil.getSpecifyDaysOfMonth(timestamp, Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        verify(timestamp).getTime();
    }

    /**
     * Method under test: {@link DateUtil#getCurrDate()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCurrDate()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        DateUtil.getCurrDate();
    }

    /**
     * Method under test: {@link DateUtil#formatYearMonthDay(String)}
     */
    @Test
    void testFormatYearMonthDay() throws ParseException
    {
        assertEquals("2020-03-01", DateUtil.formatYearMonthDay("2020-03-01"));
        assertEquals(StringUtil.EMPTY, DateUtil.formatYearMonthDay(StringUtil.EMPTY));
    }

    /**
     * Method under test: {@link DateUtil#formatYearMonthDay(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFormatYearMonthDay2() throws ParseException
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.text.ParseException: Unparseable date: "foo"
        //       at java.text.DateFormat.parse(DateFormat.java:366)
        //       at mao.aggregate_pay_common.utils.DateUtil.formatYearMonthDay(DateUtil.java:491)
        //   In order to prevent formatYearMonthDay(String)
        //   from throwing ParseException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   formatYearMonthDay(String).
        //   See https://diff.blue/R013 to resolve this issue.

        DateUtil.formatYearMonthDay("foo");
    }

    /**
     * Method under test: {@link DateUtil#getWeekIndexOfMonth(String)}
     */
    @Test
    void testGetWeekIndexOfMonth() throws ParseException
    {
        assertEquals(1, DateUtil.getWeekIndexOfMonth("2020-03-01"));
    }

    /**
     * Method under test: {@link DateUtil#getWeekIndexOfMonth(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetWeekIndexOfMonth2() throws ParseException
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.text.ParseException: Unparseable date: "foo"
        //       at java.text.DateFormat.parse(DateFormat.java:366)
        //       at mao.aggregate_pay_common.utils.DateUtil.getWeekIndexOfMonth(DateUtil.java:513)
        //   In order to prevent getWeekIndexOfMonth(String)
        //   from throwing ParseException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getWeekIndexOfMonth(String).
        //   See https://diff.blue/R013 to resolve this issue.

        DateUtil.getWeekIndexOfMonth("foo");
    }

    /**
     * Method under test: {@link DateUtil#getSecondToDesignationTime(String)}
     */
    @Test
    void testGetSecondToDesignationTime()
    {
        assertEquals(0, DateUtil.getSecondToDesignationTime("Designation Time"));
    }

    /**
     * Method under test: {@link DateUtil#getYear()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetYear()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        DateUtil.getYear();
    }

    /**
     * Method under test: {@link DateUtil#getMonth()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetMonth()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        DateUtil.getMonth();
    }

    /**
     * Method under test: {@link DateUtil#getDay()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetDay()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        DateUtil.getDay();
    }
}

