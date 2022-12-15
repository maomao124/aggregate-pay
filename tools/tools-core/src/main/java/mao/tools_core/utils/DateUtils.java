package mao.tools_core.utils;

import mao.tools_core.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * Project name(项目名称)：jwt_spring_boot_starter
 * Package(包名): mao.tools_jwt.utils
 * Class(类名): DateUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/2
 * Time(创建时间)： 22:30
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class DateUtils
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(DateUtils.class);

    /**
     * 默认年格式
     */
    public final static String DEFAULT_YEAR_FORMAT = "yyyy";
    /**
     * 默认月格式
     */
    public final static String DEFAULT_MONTH_FORMAT = "yyyy-MM";
    /**
     * 默认月格式削减
     */
    public final static String DEFAULT_MONTH_FORMAT_SLASH = "yyyy/MM";
    /**
     * 默认月格式在
     */
    public final static String DEFAULT_MONTH_FORMAT_EN = "yyyy年MM月";
    /**
     * 默认星期格式
     */
    public final static String DEFAULT_WEEK_FORMAT = "yyyy-ww";
    /**
     * 默认星期格式在
     */
    public final static String DEFAULT_WEEK_FORMAT_EN = "yyyy年ww周";
    /**
     * 默认日期格式
     */
    public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    /**
     * 默认日期格式在
     */
    public final static String DEFAULT_DATE_FORMAT_EN = "yyyy年MM月dd日";
    /**
     * 默认日期时间格式
     */
    public final static String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 默认时间格式
     */
    public final static String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    /**
     * 一天
     */
    public final static String DAY = "DAY";
    /**
     * 月
     */
    public final static String MONTH = "MONTH";
    /**
     * 周
     */
    public final static String WEEK = "WEEK";

    /**
     * 最大值月一天
     */
    public final static long MAX_MONTH_DAY = 30;
    /**
     * 最大值3.月一天
     */
    public final static long MAX_3_MONTH_DAY = 90;
    /**
     * 最大值一年一天
     */
    public final static long MAX_YEAR_DAY = 365;


    private DateUtils()
    {
    }
//--格式化日期start-----------------------------------------

    /**
     * 格式化日期,返回格式为 yyyy-MM
     *
     * @param date 日期
     * @return
     */
    public static String format(LocalDateTime date, String pattern)
    {
        if (date == null)
        {
            date = LocalDateTime.now();
        }
        if (pattern == null)
        {
            pattern = DEFAULT_MONTH_FORMAT;
        }
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 根据传入的格式格式化日期.默认格式为MM月dd日
     *
     * @param d 日期
     * @param f 格式
     * @return
     */
    public static String format(Date d, String f)
    {
        Date date = d;
        String format = f;
        if (date == null)
        {
            date = new Date();
        }
        if (format == null)
        {
            format = DEFAULT_DATE_TIME_FORMAT;
        }
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 格式化日期,返回格式为 yyyy-MM-dd
     *
     * @param date 日期
     * @return
     */
    public static String formatAsDate(LocalDateTime date)
    {
        return format(date, DEFAULT_DATE_FORMAT);
    }

    public static String formatAsDateEn(LocalDateTime date)
    {
        return format(date, DEFAULT_DATE_FORMAT_EN);
    }


    public static String formatAsYearMonth(LocalDateTime date)
    {
        return format(date, DEFAULT_MONTH_FORMAT);
    }

    public static String formatAsYearMonthEn(LocalDateTime date)
    {
        return format(date, DEFAULT_MONTH_FORMAT_EN);
    }

    /**
     * 格式化日期,返回格式为 yyyy-ww
     *
     * @param date 日期
     * @return
     */
    public static String formatAsYearWeek(LocalDateTime date)
    {
        return format(date, DEFAULT_WEEK_FORMAT);
    }

    public static String formatAsYearWeekEn(LocalDateTime date)
    {
        return format(date, DEFAULT_WEEK_FORMAT_EN);
    }

    /**
     * 格式化日期,返回格式为 yyyy-MM
     *
     * @param date 日期
     * @return
     */
    public static String formatAsYearMonth(Date date)
    {
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_MONTH_FORMAT);
        return df.format(date);
    }

    /**
     * 格式化日期,返回格式为 yyyy-ww
     *
     * @param date 日期
     * @return
     */
    public static String formatAsYearWeek(Date date)
    {
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_WEEK_FORMAT);
        return df.format(date);
    }

    /**
     * 格式化日期,返回格式为 HH:mm:ss 例:12:24:24
     *
     * @param date 日期
     * @return
     */
    public static String formatAsTime(Date date)
    {
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
        return df.format(date);
    }

    /**
     * 格式化日期,返回格式为 yyyy-MM-dd
     *
     * @param date 日期
     * @return
     */
    public static String formatAsDate(Date date)
    {
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return df.format(date);
    }

    /**
     * 格式化日期,返回格式为 yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期
     * @return
     */
    public static String formatAsDateTime(Date date)
    {
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
        return df.format(date);
    }

    /**
     * 格式化日期,返回格式为 dd ,即对应的天数.
     *
     * @param date 日期
     * @return
     */
    public static String formatAsDay(Date date)
    {
        SimpleDateFormat df = new SimpleDateFormat("dd");
        return df.format(date);
    }

    //--格式化日期end-----------------------------------------

    //--解析日期start-----------------------------------------

    /**
     * 将字符转换成日期
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date parse(String dateStr, String format)
    {
        Date date = null;
        SimpleDateFormat sdateFormat = new SimpleDateFormat(format);
        sdateFormat.setLenient(false);
        try
        {
            date = sdateFormat.parse(dateStr);

        }
        catch (Exception e)
        {
            log.info("DateUtils error {} ", e);
        }
        return date;
    }

    /**
     * 根据传入的String返回对应的date
     *
     * @param dateString
     * @return
     */
    public static Date parseAsDate(String dateString)
    {
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        try
        {
            return df.parse(dateString);
        }
        catch (ParseException e)
        {
            return new Date();
        }
    }

    /**
     * 按给定参数返回Date对象
     *
     * @param dateTime 时间对象格式为("yyyy-MM-dd HH:mm:ss");
     * @return
     */
    public static Date parseAsDateTime(String dateTime)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
        try
        {
            return simpledateformat.parse(dateTime);
        }
        catch (ParseException e)
        {
            return null;
        }
    }

    /**
     * 获取指定日期的开始时间
     * 如：00:00:00
     *
     * @param value
     * @return
     */
    public static Date getDate0000(LocalDateTime value)
    {
        return getDate0000(value.toLocalDate());
    }

    /**
     * 获取指定日期的开始时间
     * 如：00:00:00
     *
     * @param value
     * @return
     */
    public static Date getDate0000(Date value)
    {
        return getDate0000(DateUtils.date2LocalDate(value));
    }

    /**
     * 获取指定日期的开始时间
     * 如：00:00:00
     *
     * @param value
     * @return
     */
    public static Date getDate0000(LocalDate value)
    {
        LocalDateTime todayStart = LocalDateTime.of(value, LocalTime.MIN);
        return DateUtils.localDateTime2Date(todayStart);
    }

    /**
     * 获取指定日期的结束时间
     * 如：23:59:59
     *
     * @param value
     * @return
     */
    public static Date getDate2359(LocalDateTime value)
    {
        return getDate2359(value.toLocalDate());

    }

    /**
     * 获取指定日期的结束时间
     * 如：23:59:59
     *
     * @param value
     * @return
     */
    public static Date getDate2359(Date value)
    {
        return getDate2359(DateUtils.date2LocalDate(value));
    }

    /**
     * 获取指定日期的结束时间
     * 如：23:59:59
     *
     * @param value
     * @return
     */
    public static Date getDate2359(LocalDate value)
    {
        LocalDateTime dateEnd = LocalDateTime.of(value, LocalTime.MAX);
        return DateUtils.localDateTime2Date(dateEnd);
    }

    /**
     * LocalDateTime转换为Date
     *
     * @param localDateTime
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime)
    {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    //--解析日期 end-----------------------------------------


    /**
     * Date转换为LocalDateTime
     *
     * @param date
     */
    public static LocalDateTime date2LocalDateTime(Date date)
    {
        if (date == null)
        {
            return LocalDateTime.now();
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * 日期转 LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDate date2LocalDate(Date date)
    {
        if (date == null)
        {
            return LocalDate.now();
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * 日期转 LocalTime
     *
     * @param date
     * @return
     */
    public static LocalTime date2LocalTime(Date date)
    {
        if (date == null)
        {
            return LocalTime.now();
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalTime();
    }

    //-计算日期 start------------------------------------------


    /**
     * 计算结束时间与当前时间中的天数
     *
     * @param endDate 结束日期
     * @return
     */
    public static long until(Date endDate)
    {
        return LocalDateTime.now().until(date2LocalDateTime(endDate), ChronoUnit.DAYS);
    }

    /**
     * 计算结束时间与开始时间中的天数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static long until(Date startDate, Date endDate)
    {
        return date2LocalDateTime(startDate).until(date2LocalDateTime(endDate), ChronoUnit.DAYS);
    }


    /**
     * 计算结束时间与开始时间中的天数
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static long until(LocalDateTime startDate, LocalDateTime endDate)
    {
        return startDate.until(endDate, ChronoUnit.DAYS);
    }

    public static long until(LocalDate startDate, LocalDate endDate)
    {
        return startDate.until(endDate, ChronoUnit.DAYS);
    }

    /**
     * 计算2个日期之间的所有的日期 yyyy-MM-dd
     * 含头含尾
     *
     * @param start yyyy-MM-dd
     * @param end   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenDay(Date start, Date end)
    {
        return getBetweenDay(date2LocalDate(start), date2LocalDate(end));
    }

    /**
     * 计算2个日期之间的所有的日期 yyyy-MM-dd
     * 含头含尾
     *
     * @param start yyyy-MM-dd
     * @param end   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenDay(String start, String end)
    {
        return getBetweenDay(LocalDate.parse(start), LocalDate.parse(end));
    }

    /**
     * 计算2个日期之间的所有的日期 yyyy-MM-dd
     * 含头含尾
     *
     * @param startDate yyyy-MM-dd
     * @param endDate   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenDay(LocalDate startDate, LocalDate endDate)
    {
        return getBetweenDay(startDate, endDate, DEFAULT_DATE_FORMAT);
    }

    public static List<String> getBetweenDayEn(LocalDate startDate, LocalDate endDate)
    {
        return getBetweenDay(startDate, endDate, DEFAULT_DATE_FORMAT_EN);
    }

    public static List<String> getBetweenDay(LocalDate startDate, LocalDate endDate, String pattern)
    {
        if (pattern == null)
        {
            pattern = DEFAULT_DATE_FORMAT;
        }
        List<String> list = new ArrayList<>();
        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        if (distance < 1)
        {
            return list;
        }
        String finalPattern = pattern;
        Stream.iterate(startDate, d -> d.plusDays(1)).
                limit(distance + 1)
                .forEach(f -> list.add(f.format(DateTimeFormatter.ofPattern(finalPattern))));
        return list;
    }


    /**
     * 计算2个日期之间的所有的周 yyyy-ww
     * 含头含尾
     *
     * @param start yyyy-MM-dd
     * @param end   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenWeek(Date start, Date end)
    {
        return getBetweenWeek(date2LocalDate(start), date2LocalDate(end));
    }

    /**
     * 计算2个日期之间的所有的周 yyyy-ww
     * 含头含尾
     *
     * @param start yyyy-MM-dd
     * @param end   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenWeek(String start, String end)
    {
        return getBetweenWeek(LocalDate.parse(start), LocalDate.parse(end));
    }

    /**
     * 计算2个日期之间的所有的周 yyyy-ww
     * 含头含尾
     *
     * @param startDate yyyy-MM-dd
     * @param endDate   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenWeek(LocalDate startDate, LocalDate endDate)
    {
        return getBetweenWeek(startDate, endDate, DEFAULT_WEEK_FORMAT);
    }

    public static List<String> getBetweenWeek(LocalDate startDate, LocalDate endDate, String pattern)
    {
        List<String> list = new ArrayList<>();

        long distance = ChronoUnit.WEEKS.between(startDate, endDate);
        if (distance < 1)
        {
            return list;
        }
        Stream.iterate(startDate, d -> d.plusWeeks(1)).
                limit(distance + 1).forEach(f -> list.add(f.format(DateTimeFormatter.ofPattern(pattern))));
        return list;
    }

    /**
     * 计算2个日期之间的所有的月 yyyy-MM
     *
     * @param start yyyy-MM-dd
     * @param end   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenMonth(Date start, Date end)
    {
        return getBetweenMonth(date2LocalDate(start), date2LocalDate(end));
    }

    /**
     * 计算2个日期之间的所有的月 yyyy-MM
     *
     * @param start yyyy-MM-dd
     * @param end   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenMonth(String start, String end)
    {
        return getBetweenMonth(LocalDate.parse(start), LocalDate.parse(end));
    }

    /**
     * 计算2个日期之间的所有的月 yyyy-MM
     *
     * @param startDate yyyy-MM-dd
     * @param endDate   yyyy-MM-dd
     * @return
     */
    public static List<String> getBetweenMonth(LocalDate startDate, LocalDate endDate)
    {
        return getBetweenMonth(startDate, endDate, DEFAULT_MONTH_FORMAT);
    }

    public static List<String> getBetweenMonth(LocalDate startDate, LocalDate endDate, String pattern)
    {
        List<String> list = new ArrayList<>();
        long distance = ChronoUnit.MONTHS.between(startDate, endDate);
        if (distance < 1)
        {
            return list;
        }

        Stream.iterate(startDate, d -> d.plusMonths(1))
                .limit(distance + 1)
                .forEach(f -> list.add(f.format(DateTimeFormatter.ofPattern(pattern))));
        return list;
    }

    /**
     * 计算时间区间内的日期列表，并返回
     *
     * @param startTime
     * @param endTime
     * @param dateList
     * @return
     */
    public static String calculationEn(LocalDateTime startTime, LocalDateTime endTime, List<String> dateList)
    {
        if (startTime == null)
        {
            startTime = LocalDateTime.now();
        }
        if (endTime == null)
        {
            endTime = LocalDateTime.now().plusDays(30);
        }
        return calculationEn(startTime.toLocalDate(), endTime.toLocalDate(), dateList);
    }

    public static String calculation(LocalDate startDate, LocalDate endDate, List<String> dateList)
    {
        if (startDate == null)
        {
            startDate = LocalDate.now();
        }
        if (endDate == null)
        {
            endDate = LocalDate.now().plusDays(30);
        }
        if (dateList == null)
        {
            dateList = new ArrayList<>();
        }
        long day = until(startDate, endDate);

        String dateType = MONTH;
        if (day >= 0 && day <= MAX_MONTH_DAY)
        {
            dateType = DAY;
            dateList.addAll(DateUtils.getBetweenDay(startDate, endDate, DEFAULT_DATE_FORMAT));
        }
        else if (day > MAX_MONTH_DAY && day <= MAX_3_MONTH_DAY)
        {
            dateType = WEEK;
            dateList.addAll(DateUtils.getBetweenWeek(startDate, endDate, DEFAULT_WEEK_FORMAT));
        }
        else if (day > MAX_3_MONTH_DAY && day <= MAX_YEAR_DAY)
        {
            dateType = MONTH;
            dateList.addAll(DateUtils.getBetweenMonth(startDate, endDate, DEFAULT_MONTH_FORMAT));
        }
        else
        {
            throw new BizException("日期参数只能介于0-365天之间");
        }
        return dateType;
    }

    public static String calculationEn(LocalDate startDate, LocalDate endDate, List<String> dateList)
    {
        if (startDate == null)
        {
            startDate = LocalDate.now();
        }
        if (endDate == null)
        {
            endDate = LocalDate.now().plusDays(30);
        }
        if (dateList == null)
        {
            dateList = new ArrayList<>();
        }
        long day = until(startDate, endDate);

        String dateType = MONTH;
        if (day >= 0 && day <= MAX_MONTH_DAY)
        {
            dateType = DAY;
            dateList.addAll(DateUtils.getBetweenDay(startDate, endDate, DEFAULT_DATE_FORMAT_EN));
        }
        else if (day > MAX_MONTH_DAY && day <= MAX_3_MONTH_DAY)
        {
            dateType = WEEK;
            dateList.addAll(DateUtils.getBetweenWeek(startDate, endDate, DEFAULT_WEEK_FORMAT_EN));
        }
        else if (day > MAX_3_MONTH_DAY && day <= MAX_YEAR_DAY)
        {
            dateType = MONTH;
            dateList.addAll(DateUtils.getBetweenMonth(startDate, endDate, DEFAULT_MONTH_FORMAT_EN));
        }
        else
        {
            throw new BizException("日期参数只能介于0-365天之间");
        }
        return dateType;
    }

//----------//----------//----------//----------//----------//----------//----------//----------//----------//----------//----------

}