package mao.sms_api.utils;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.utils
 * Class(类名): SmsEncryptionUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 14:30
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class SmsEncryptionUtils
{
    /**
     * 编码
     *
     * @param timestamp       时间戳
     * @param accessKeyId     访问密钥id
     * @param accessKeySecret 访问密钥秘密
     * @return {@link String}
     */
    public static String encode(String timestamp, String accessKeyId, String accessKeySecret)
    {
        byte[] timestamps = timestamp.getBytes();
        byte[] cakis = new byte[timestamps.length];
        byte[] cakss = new byte[timestamps.length];
        for (int i = 0; i < timestamps.length; i++)
        {
            int ci = (int) timestamps[i] - (int) ('0');
            byte caki = (byte) accessKeyId.charAt(ci);
            byte caks = (byte) accessKeySecret.charAt(ci);
            cakis[i] = (byte) (caki >>> (i > 6 ? i / 2 : i) & i);
            cakss[i] = (byte) (caks | i);
        }
        byte[] accessKeyIds = accessKeyId.getBytes();
        byte[] accessKeySecrets = accessKeySecret.getBytes();

        byte[] md5Bytes = new byte[cakis.length + cakss.length + accessKeyIds.length + accessKeySecrets.length];

        System.arraycopy(cakis, 0, md5Bytes, 0, cakis.length);
        System.arraycopy(accessKeyIds, 0, md5Bytes, cakis.length, accessKeyIds.length);
        System.arraycopy(cakss, 0, md5Bytes, accessKeyIds.length, cakss.length);
        System.arraycopy(accessKeySecrets, 0, md5Bytes, cakss.length, accessKeySecrets.length);

        return MD5Utils.getMD5(MD5Utils.getMD5(md5Bytes).getBytes());
    }
}
