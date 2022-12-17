package mao.sms_entity.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.utils
 * Class(类名): StringHelper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 20:26
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class StringHelper
{
    /**
     * 替换模板内容
     *
     * @param content 内容
     * @param map     Map
     * @return {@link String}
     */
    public static String renderString(String content, Map<String, String> map)
    {
        Set<Map.Entry<String, String>> sets = map.entrySet();
        for (Map.Entry<String, String> entry : sets)
        {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            content = matcher.replaceAll(entry.getValue());
        }
        return content;
    }

    /**
     * 按顺序获取模板中的变量名称
     *
     * @param soap 肥皂
     * @return {@link List}<{@link String}>
     */
    public static List<String> getSubUtil(String soap)
    {
        String regex = "\\$\\{(.*?)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(soap);
        List<String> list = new ArrayList<>();
        int i = 1;
        while (matcher.find())
        {
            list.add(matcher.group(i));
        }
        return list;
    }
}
