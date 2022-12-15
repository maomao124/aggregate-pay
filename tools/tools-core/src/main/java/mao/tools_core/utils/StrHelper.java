package mao.tools_core.utils;

import cn.hutool.core.util.StrUtil;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：jwt_spring_boot_starter
 * Package(包名): mao.tools_jwt.utils
 * Class(类名): StrHelper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/2
 * Time(创建时间)： 22:28
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class StrHelper
{
    public static String getObjectValue(Object obj)
    {
        return obj == null ? "" : obj.toString();
    }

    public static String encode(String value)
    {
        try
        {
            return URLEncoder.encode(value, "UTF-8");
        }
        catch (Exception e)
        {
            return "";
        }
    }

    public static String decode(String value)
    {
        try
        {
            return URLDecoder.decode(value, "UTF-8");
        }
        catch (Exception e)
        {
            return "";
        }
    }

    public static String getOrDef(String val, String def)
    {
        return StrUtil.isEmpty(val) ? def : val;
    }
}
