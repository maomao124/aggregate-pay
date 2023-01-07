package mao.aggregate_pay_common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): DateUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 20:16
 * Version(版本): 1.0
 * Description(描述)： 日期处理工具类
 */

public class DateUtil
{
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String HHmmss = "HHmmss";

    public static final String YYYYMM = "yyyyMM";

    /**
     * 构造方法
     */
    private DateUtil()
    {
    }


    /**
     * 现在
     *
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime now()
    {
        return LocalDateTime.now();
    }


    /**
     * 日期时间
     *
     * @param date 日期
     * @return {@link String}
     */
    public static String toDateTime(LocalDateTime date)
    {
        return toDateTime(date, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 日期时间
     *
     * @param dateTime 日期时间
     * @param pattern  模式
     * @return {@link String}
     */
    public static String toDateTime(LocalDateTime dateTime, String pattern)
    {
        return dateTime.format(DateTimeFormatter.ofPattern(pattern, Locale.SIMPLIFIED_CHINESE));
    }


    /**
     * 日期文本
     *
     * @param date    日期
     * @param pattern 模式
     * @return {@link String}
     */
    public static String toDateText(LocalDate date, String pattern)
    {
        if (date == null || pattern == null)
        {
            return null;
        }
        return date.format(DateTimeFormatter.ofPattern(pattern, Locale.SIMPLIFIED_CHINESE));
    }

    /**
     * 从给定的date，加上hour小时 求指定date时间后hour小时的时间
     *
     * @param date 指定的时间
     * @param hour 多少小时后
     * @return {@link Date}
     */
    public static Date addExtraHour(Date date, int hour)
    {
        Calendar cal = Calendar.getInstance();
        if (date != null)
        {
            cal.setTime(date);
        }
        cal.add(Calendar.HOUR_OF_DAY, hour);
        return cal.getTime();
    }

    /**
     * 从给定的date，加上increase天
     *
     * @param date     日期
     * @param increase 增加
     * @return {@link Date}
     */
    public static Date increaseDay2Date(Date date, int increase)
    {
        Calendar cal = Calendar.getInstance();
        if (date != null)
        {
            cal.setTime(date);
        }
        cal.add(Calendar.DAY_OF_MONTH, increase);
        return cal.getTime();
    }

    /**
     * 把字符串日期默认转换为yyyy-mm-dd格式的Data对象
     *
     * @param strDate str日期
     * @param format  格式
     * @return {@link Date}
     */
    public static Date format(String strDate, String format)
    {
        Date d = null;
        if (null == strDate || "".equals(strDate))
        {
            return null;
        }
        else
        {
            try
            {
                d = getFormatter(format).parse(strDate);
            }
            catch (ParseException pex)
            {
                return null;
            }
        }
        return d;
    }

    /**
     * 获取一个简单的日期格式化对象
     *
     * @param parttern parttern
     * @return 一个简单的日期格式化对象
     */
    private static SimpleDateFormat getFormatter(String parttern)
    {
        return new SimpleDateFormat(parttern);
    }

    /**
     * 获取month所在月的所有天
     *
     * @param month      要查询的日期（如果为null 则默认为当前月）
     * @param dateFormat 返回日期的格式（如果为null 则返回yyyy-MM-dd 格式结果）
     * @return {@link List}<{@link String}>
     */
    public static List<String> getAllDaysOfMonthInString(Date month, DateFormat dateFormat)
    {
        List<String> rs = new ArrayList<String>();
        DateFormat df = null;
        if (null == dateFormat)
        {
            df = new SimpleDateFormat("yyyy-MM-dd");
        }
        Calendar cad = Calendar.getInstance();
        if (null != month)
        {
            cad.setTime(month);
        }
        int day_month = cad.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取当月天数
        for (int i = 0; i < day_month; i++)
        {
            cad.set(Calendar.DAY_OF_MONTH, i + 1);
            rs.add(df.format(cad.getTime()));

        }
        return rs;
    }

    /**
     * 获取month所在月的所有天
     *
     * @param month 要查询的日期（如果为null 则默认为当前月）
     * @return 日期List
     */
    public static List<Date> getAllDaysOfMonth(Date month)
    {
        List<Date> rs = new ArrayList<Date>();
        Calendar cad = Calendar.getInstance();
        if (null != month)
        {
            cad.setTime(month);
        }
        int day_month = cad.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取当月天数
        for (int i = 0; i < day_month; i++)
        {
            cad.set(Calendar.DAY_OF_MONTH, i + 1);
            rs.add(cad.getTime());

        }
        return rs;
    }

    /**
     * 获取指定日期区间所有天
     *
     * @param dateFormat (如果为null 则返回yyyy-MM-dd格式的日期)
     * @param begin      开始
     * @param end        结束
     * @return {@link List}<{@link String}>
     */
    public static List<String> getSpecifyDaysOfMonthInString(Date begin, Date end, DateFormat dateFormat)
    {
        DateFormat df = null;
        if (null == dateFormat)
        {
            df = new SimpleDateFormat("yyyy-MM-dd");
        }
        List<String> rs = new ArrayList<String>();
        List<Date> tmplist = getSpecifyDaysOfMonth(begin, end);
        for (Date date : tmplist)
        {
            rs.add(df.format(date));
        }
        return rs;
    }

    /**
     * 获取指定日期区间所有天
     *
     * @param begin 开始
     * @param end   结束
     * @return {@link List}<{@link Date}>
     */
    public static List<Date> getSpecifyDaysOfMonth(Date begin, Date end)
    {
        List<Date> rs = new ArrayList<Date>();
        Calendar cad = Calendar.getInstance();
        int day_month = -1;
        if (null == begin)
        {
            // 设置开始日期为指定日期
            // day_month = cad.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取当月天数
            cad.set(Calendar.DAY_OF_MONTH, 1);// 设置开始日期为当前月的第一天
            begin = cad.getTime();
        }
        cad.setTime(begin);
        if (null == end)
        {
            // 如果结束日期为空 ，设置结束日期为下月的第一天
            day_month = cad.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取当月天数
            cad.set(Calendar.DAY_OF_MONTH, day_month + 1);
            end = cad.getTime();
        }
        cad.set(Calendar.DAY_OF_MONTH, 1);// 设置开始日期为当前月的第一天
        Date tmp = begin;
        int i = 1;
        while (true)
        {
            cad.set(Calendar.DAY_OF_MONTH, i);
            i++;
            tmp = cad.getTime();
            if (tmp.before(end))
            {
                rs.add(cad.getTime());
            }
            else
            {
                break;
            }
        }
        return rs;
    }

    /**
     * 获取当前日期
     *
     * @return 一个包含年月日的<code>Date</code>型日期
     */
    public static synchronized Date getCurrDate()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 格式
     *
     * @param date    日期
     * @param pattern 模式
     * @return {@link String}
     */
    public static String format(Date date, String pattern)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * 获取当前完整时间,样式: yyyy－MM－dd hh:mm:ss
     *
     * @return 一个包含年月日时分秒的<code>String</code>型日期。yyyy-MM-dd hh:mm:ss
     */
    public static String getCurrDateTimeStr()
    {
        return format(getCurrDate(), YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay YYYY_MM_DD_HH_MM_SS 格式
     * @param formatStr    日期类型
     * @return {@link String}
     */
    public static String getSpecifiedDayBefore(String specifiedDay, String formatStr)
    {// 可以用new
        // Date().toLocalString()传递参数
        Calendar c = Calendar.getInstance();
        Date date = null;
        try
        {
            date = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).parse(specifiedDay);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat(formatStr).format(c.getTime());
        return dayBefore;
    }

    /**
     * 获得指定日期的后一天
     *
     * @param specifiedDay YYYY_MM_DD_HH_MM_SS 格式
     * @param formatStr    日期类型
     * @return {@link String}
     */
    public static String getSpecifiedDayAfter(String specifiedDay, String formatStr)
    {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try
        {
            date = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).parse(specifiedDay);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String dayAfter = new SimpleDateFormat(formatStr).format(c.getTime());
        return dayAfter;
    }

    /**
     * 获取本周第一天的日期
     *
     * @return {@link String}
     */
    public static String getWeekFirstDay()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
        cal.add(Calendar.DATE, -day_of_week);
        return sdf.format(cal.getTime());
    }

    /**
     * 获取当前月的第一天
     *
     * @return {@link String}
     */
    public static String getCurrentMonthFirstDay()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 当前月的第一天
        cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
        Date beginTime = cal.getTime();
        return sdf.format(beginTime);
    }

    /**
     * @return {@link String}
     */
    public static String getYesterdayStart()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * @return {@link String}
     */
    public static String getYesterdayEnd()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime()) + " 23:59:59";
    }

    /**
     * @return {@link String}
     */
    public static String getCurrDayStart()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * 功能：获取指定月份的第一天<br/>
     *
     * @param month 月
     * @return {@link String}
     * @throws ParseException 解析异常
     */
    public static String getStartDayWithMonth(String month) throws ParseException
    {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat mf = new SimpleDateFormat("yyyy-MM");
        Date date = mf.parse(month);
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 0);// 因为格式化时默认了DATE为本月第一天所以此处为0
        return sdf.format(calendar.getTime());
    }

    /**
     * 功能：获取指定月份的最后一天<br/>
     *
     * @param month 月
     * @return {@link String}
     * @throws ParseException 解析异常
     */
    public static String getEndDayWithMonth(String month) throws ParseException
    {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat mf = new SimpleDateFormat("yyyy-MM");
        Date date = mf.parse(month);
        calendar.setTime(date);
        calendar.roll(Calendar.DATE, -1);// api解释roll()：向指定日历字段添加指定（有符号的）时间量，不更改更大的字段
        return sdf.format(calendar.getTime());
    }

    /**
     * 格式年月日
     *
     * @param dateStr str日期
     * @return {@link String}
     * @throws ParseException 解析异常
     */
    public static final String formatYearMonthDay(String dateStr) throws ParseException
    {
        if (StringUtil.isNotBlank(dateStr))
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);
            return sdf.format(date);
        }
        else
        {
            return "";
        }
    }

    /**
     * 周月指数
     * 功能：<br/>
     * 根据时间 yyyy-MM-dd 获取该日期是本月第几周
     *
     * @param dateStr str日期
     * @return int
     * @throws ParseException 解析异常
     */
    public static final int getWeekIndexOfMonth(String dateStr) throws ParseException
    {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        return weekOfMonth;
    }

    /**
     * 得到第二个指定时间
     * 获取当前时间到指定时间距离多少秒 功能：<br/>
     *
     * @param designationTime 指定时间
     * @return int
     */
    public static final int getSecondToDesignationTime(String designationTime)
    {
        // 24小时制
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date toDate;
        try
        {
            toDate = dateFormat.parse(designationTime);
            int u = (int) ((toDate.getTime() - dateFormat.parse(DateUtil.getCurrDateTimeStr()).getTime()) / 1000);
            return u;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获得年
     *
     * @return int
     */
    public static int getYear()
    {
        Calendar cal = Calendar.getInstance();
        return cal.get(cal.YEAR);
    }

    /**
     * 获得月
     *
     * @return int
     */
    public static int getMonth()
    {
        Calendar cal = Calendar.getInstance();
        return cal.get(cal.MONTH) + 1;
    }

    /**
     * 获得天
     *
     * @return int
     */
    public static int getDay()
    {
        Calendar cal = Calendar.getInstance();
        return cal.get(cal.DATE);
    }
}
