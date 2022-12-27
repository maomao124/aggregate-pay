package mao.sms_sdk.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.utils
 * Class(类名): MD5Utils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 14:32
 * Version(版本): 1.0
 * Description(描述)： MD5工具类
 */

public class MD5Utils
{
    /**
     * SHA
     *
     * @param strText str文本
     * @return {@link String}
     */
    private static String SHA(final String strText)
    {
        String strResult = null;
        if (strText != null && strText.length() > 0)
        {
            try
            {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(strText.getBytes());
                byte[] byteBuffer = messageDigest.digest();
                StringBuilder strHexString = new StringBuilder();
                for (int i = 0; i < byteBuffer.length; i++)
                {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1)
                    {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                strResult = strHexString.toString();
            }
            catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
        }
        return strResult;
    }

    /**
     * SHA
     *
     * @param md5Bytes md5字节
     * @return {@link String}
     */
    private static String SHA(final byte[] md5Bytes)
    {
        if (md5Bytes.length == 0)
        {
            return null;
        }
        String strResult = null;
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(md5Bytes);
            byte[] byteBuffer = messageDigest.digest();
            StringBuilder strHexString = new StringBuilder();
            for (int i = 0; i < byteBuffer.length; i++)
            {
                String hex = Integer.toHexString(0xff & byteBuffer[i]);
                if (hex.length() == 1)
                {
                    strHexString.append('0');
                }
                strHexString.append(hex);
            }
            strResult = strHexString.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return strResult;
    }

    /**
     * 得到md5
     *
     * @param strText str文本
     * @return {@link String}
     */
    public static String getMD5(String strText)
    {
        return SHA(strText);
    }

    /**
     * 得到md5
     *
     * @param md5Bytes md5字节
     * @return {@link String}
     */
    public static String getMD5(byte[] md5Bytes)
    {
        return SHA(md5Bytes);
    }

    /**
     * 得到md5to大写
     *
     * @param strText str文本
     * @return {@link String}
     */
    public static String getMD5toUpperCase(String strText)
    {
        if (strText == null)
        {
            return null;
        }
        return Objects.requireNonNull(SHA(strText)).toUpperCase();
    }

    /**
     * 得到md5to大写
     *
     * @param md5Bytes md5字节
     * @return {@link String}
     */
    public static String getMD5toUpperCase(byte[] md5Bytes)
    {
        if (md5Bytes == null || md5Bytes.length == 0)
        {
            return null;
        }
        return Objects.requireNonNull(SHA(md5Bytes)).toUpperCase();
    }
}
