package mao.aggregate_pay_common.utils;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): ParseURLPairUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 20:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class ParseURLPairUtil
{
    /**
     * 解析urlpair
     *
     * @param o o
     * @return {@link String}
     * @throws Exception 异常
     */
    public static String parseURLPair(Object o) throws Exception
    {
        Class<?> c = o.getClass();
        Field[] fields = c.getDeclaredFields();
        Map<String, Object> map = new TreeMap<>();
        for (Field field : fields)
        {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(o);
            if (value != null)
            {
                map.put(name, value);
            }
        }
        Set<Map.Entry<String, Object>> set = map.entrySet();
        Iterator<Map.Entry<String, Object>> it = set.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext())
        {
            Map.Entry<String, Object> e = it.next();
            sb.append(e.getKey()).append("=").append(e.getValue()).append("&");
        }
        if (sb.length() == 0)
        {
            return null;
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
