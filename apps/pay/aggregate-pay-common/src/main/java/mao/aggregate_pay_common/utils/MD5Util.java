package mao.aggregate_pay_common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): MD5Util
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 20:57
 * Version(版本): 1.0
 * Description(描述)： MD5工具类
 */

public class MD5Util
{
    /**
     * 获取字符串的MD5摘要计算结果
     *
     * @param plainText 纯文本
     * @return {@link String}
     */
    public static String getMd5(String plainText)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte[] b = md.digest();

            int i;

            StringBuilder buf = new StringBuilder("");
            for (byte value : b)
            {
                i = value;
                if (i < 0)
                {
                    i += 256;
                }
                if (i < 16)
                {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return null;
        }

    }
}
