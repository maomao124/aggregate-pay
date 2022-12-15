package mao.tools_common.converter;

import mao.tools_core.utils.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.converter
 * Class(类名): String2LocalTimeConverter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 20:56
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class String2LocalTimeConverter extends BaseDateConverter<LocalTime> implements Converter<String, LocalTime>
{
    protected static final Map<String, String> FORMAT = new LinkedHashMap(1);

    static
    {
        FORMAT.put(DateUtils.DEFAULT_TIME_FORMAT, "^\\d{1,2}:\\d{1,2}:\\d{1,2}$");
    }

    @Override
    protected Map<String, String> getFormat()
    {
        return FORMAT;
    }

    @Override
    public LocalTime convert(String source)
    {
        return super.convert(source, (key) -> LocalTime.parse(source, DateTimeFormatter.ofPattern(key)));
    }
}
