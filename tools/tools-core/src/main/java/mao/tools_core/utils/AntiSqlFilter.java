package mao.tools_core.utils;

import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.utils
 * Class(类名): AntiSqlFilter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 21:20
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class AntiSqlFilter
{

    private static final String[] KEY_WORDS = {";", "\"", "\'", "/*", "*/", "--", "exec",
            "select", "update", "delete", "insert",
            "alter", "drop", "create", "shutdown"};

    /**
     * 得到安全参数映射
     *
     * @param parameterMap 参数映射
     * @return {@link Map}<{@link String}, {@link String[]}>
     */
    public static Map<String, String[]> getSafeParameterMap(Map<String, String[]> parameterMap)
    {
        Map<String, String[]> map = new HashMap<>(parameterMap.size());
        for (String key : parameterMap.keySet())
        {
            String[] oldValues = parameterMap.get(key);
            map.put(key, getSafeValues(oldValues));
        }
        return map;
    }

    /**
     * 获得安全值
     *
     * @param oldValues 旧值
     * @return {@link String[]}
     */
    public static String[] getSafeValues(String[] oldValues)
    {
        if (ArrayUtils.isNotEmpty(oldValues))
        {
            String[] newValues = new String[oldValues.length];
            for (int i = 0; i < oldValues.length; i++)
            {
                newValues[i] = getSafeValue(oldValues[i]);
            }
            return newValues;
        }
        return null;
    }

    /**
     * 获得安全值
     *
     * @param oldValue 旧值
     * @return {@link String}
     */
    public static String getSafeValue(String oldValue)
    {
        if (oldValue == null || "".equals(oldValue))
        {
            return oldValue;
        }
        StringBuilder sb = new StringBuilder(oldValue);
        String lowerCase = oldValue.toLowerCase();
        for (String keyWord : KEY_WORDS)
        {
            int x;
            while ((x = lowerCase.indexOf(keyWord)) >= 0)
            {
                if (keyWord.length() == 1)
                {
                    sb.replace(x, x + 1, " ");
                    lowerCase = sb.toString().toLowerCase();
                    continue;
                }
                sb.deleteCharAt(x + 1);
                lowerCase = sb.toString().toLowerCase();
            }
        }
        return sb.toString();
    }

}
