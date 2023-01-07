package mao.aggregate_pay_common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): EncryptUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 20:43
 * Version(版本): 1.0
 * Description(描述)： base64编码转换工具类
 */

public class EncryptUtil
{
    private static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    /**
     *
     * 将字节数组进行base64编码
     *
     * @param bytes 字节
     * @return {@link String}
     */
    public static String encodeBase64(byte[] bytes)
    {
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     *
     * 将字符串进行base64解码
     *
     * @param str str
     * @return {@link byte[]}
     */
    public static byte[] decodeBase64(String str)
    {
        byte[] bytes = null;
        bytes = Base64.getDecoder().decode(str);
        return bytes;
    }

    /**
     *
     * 将字符串str 先使用utf-8符集进行url编码 +转为%2B ?转为%3F 等防止传输过程中出问题，然后在进行base64编码
     *
     * @param str str
     * @return {@link String}
     */
    public static String encodeUTF8StringBase64(String str)
    {
        String encoded = null;
        try
        {
            encoded = URLEncoder.encode(str, "utf-8");
            encoded = Base64.getEncoder().encodeToString(encoded.getBytes("utf-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            logger.warn("不支持的编码格式", e);
        }
        return encoded;

    }

    /**
     *
     * 将字符串str 先进行base64解码 然后在使用utf-8字符集进行url解码
     *
     * @param str str
     * @return {@link String}
     */
    public static String decodeUTF8StringBase64(String str)
    {
        String decoded = null;
        byte[] bytes = Base64.getDecoder().decode(str);

        try
        {
            decoded = new String(bytes, "utf-8");
            decoded = URLDecoder.decode(decoded, "utf-8");
        }
        catch (UnsupportedEncodingException e)
        {
            logger.warn("不支持的编码格式", e);
        }
        return decoded;
    }


    public static void main(String[] args)
    {
        String str = "www.baidu.com?a=1&b=2+1&c=dfdasaf+%&&d=1";
        String encoded = EncryptUtil.encodeUTF8StringBase64(str);
        String decoded = EncryptUtil.decodeUTF8StringBase64(encoded);
        System.out.println(str);
        System.out.println(encoded);
        System.out.println(decoded);

    }

}
