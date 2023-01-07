package mao.aggregate_pay_common.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): MapStringConvertUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 20:56
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class MapStringConvertUtil
{
    /**
     * map转str
     *
     * @param map {@link Map}<{@link String}, {@link String}>
     * @return {@link String}
     */
    public static String getMapToString(Map<String, String> map)
    {
        Set<String> keySet = map.keySet();
        //将set集合转换为数组
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        //给数组排序(升序)
        Arrays.sort(keyArray);
        //因为String拼接效率会很低的，所以转用StringBuilder。
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyArray.length; i++)
        {
            // 参数值为空，则不参与签名 这个方法trim()是去空格
            if (map.get(keyArray[i]).trim().length() > 0)
            {
                sb.append(keyArray[i]).append(":").append(map.get(keyArray[i]).trim());
            }
            if (i != keyArray.length - 1)
            {
                sb.append(",");
            }
        }
        String s = sb.toString();
        return s;
    }

    /**
     * String转Map
     *
     * @param str str
     * @return {@link Map}<{@link String}, {@link String}>
     */
    public static Map<String, String> getStringToMap(String str)
    {
        //判断str是否有值
        if (null == str || "".equals(str))
        {
            return null;
        }
        //根据&截取
        String[] strings = str.split(",");
        //设置HashMap长度
        int mapLength = strings.length;
        //判断hashMap的长度是否是2的幂。
        if ((strings.length % 2) != 0)
        {
            mapLength = mapLength + 1;
        }

        Map<String, String> map = new HashMap<>(mapLength);
        //循环加入map集合
        for (String string : strings)
        {
            //截取一组字符串
            String[] strArray = string.split(":");
            //strArray[0]为KEY  strArray[1]为值
            map.put(strArray[0], strArray[1]);
        }
        return map;
    }
}
