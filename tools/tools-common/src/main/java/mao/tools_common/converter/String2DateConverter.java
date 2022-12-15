package mao.tools_common.converter;

import mao.tools_core.exception.BaseException;
import mao.tools_core.exception.BizException;
import mao.tools_core.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.converter
 * Class(类名): String2DateConverter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 20:47
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class String2DateConverter extends BaseDateConverter<Date> implements Converter<String, Date>
{
    private static final Logger log = LoggerFactory.getLogger(String2DateConverter.class);

    protected static final Map<String, String> FORMAT = new LinkedHashMap<>(11);

    static
    {
        FORMAT.put(DateUtils.DEFAULT_YEAR_FORMAT, "^\\d{4}");
        FORMAT.put(DateUtils.DEFAULT_MONTH_FORMAT, "^\\d{4}-\\d{1,2}$");
        FORMAT.put(DateUtils.DEFAULT_DATE_FORMAT, "^\\d{4}-\\d{1,2}-\\d{1,2}$");
        FORMAT.put("yyyy-MM-dd HH", "^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}");
        FORMAT.put("yyyy-MM-dd HH:mm", "^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$");
        FORMAT.put(DateUtils.DEFAULT_DATE_TIME_FORMAT, "^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$");
        FORMAT.put("yyyy/MM", "^\\d{4}/\\d{1,2}$");
        FORMAT.put("yyyy/MM/dd", "^\\d{4}/\\d{1,2}/\\d{1,2}$");
        FORMAT.put("yyyy/MM/dd HH", "^\\d{4}/\\d{1,2}/\\d{1,2} {1}\\d{1,2}");
        FORMAT.put("yyyy/MM/dd HH:mm", "^\\d{4}/\\d{1,2}/\\d{1,2} {1}\\d{1,2}:\\d{1,2}$");
        FORMAT.put("yyyy/MM/dd HH:mm:ss", "^\\d{4}/\\d{1,2}/\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$");
    }

    /**
     * 格式化日期
     *
     * @param dateStr String 字符型日期
     * @param format  String 格式
     * @return Date 日期
     */
    protected static Date parseDate(String dateStr, String format)
    {
        Date date = null;
        try
        {
            DateFormat dateFormat = new SimpleDateFormat(format);
            //严格模式
            dateFormat.setLenient(false);
            date = dateFormat.parse(dateStr);
        }
        catch (ParseException e)
        {
            log.info("转换日期失败, date={}, format={}", dateStr, format, e);
            throw new BizException(BaseException.BASE_VALID_PARAM, e.getMessage());
        }
        return date;
    }

    @Override
    protected Map<String, String> getFormat()
    {
        return FORMAT;
    }

    /**
     * 转换
     *
     * @param source 源
     * @return {@link Date}
     */
    @Override
    public Date convert(String source)
    {
        return super.convert(source, (key) -> parseDate(source, key));
    }
}
