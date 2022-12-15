package mao.tools_common.converter;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.converter
 * Class(类名): BaseDateConverter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 20:44
 * Version(版本): 1.0
 * Description(描述)： 解决入参为 Date类型
 */

public abstract class BaseDateConverter<T>
{
    /**
     * 转换
     *
     * @param source   源
     * @param function 函数
     * @return {@link T}
     */
    public T convert(String source, Function<String, T> function)
    {
        if (source == null || source.isEmpty())
        {
            return null;
        }
        source = source.trim();
        Set<Map.Entry<String, String>> entries = getFormat().entrySet();
        for (Map.Entry<String, String> entry : entries)
        {
            if (source.matches(entry.getValue()))
            {
                return function.apply(entry.getKey());
            }
        }
        throw new IllegalArgumentException("无效的日期参数格式:'" + source + "'");
    }

    /**
     * 获取子类 具体的格式化表达式
     *
     * @return {@link Map}<{@link String}, {@link String}>
     */
    protected abstract Map<String, String> getFormat();
}
