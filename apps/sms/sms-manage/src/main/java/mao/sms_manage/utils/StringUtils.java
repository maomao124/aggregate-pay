package mao.sms_manage.utils;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.utils
 * Class(类名): StringUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 21:20
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class StringUtils
{
    /**
     * 不够位数的在前面补0，保留num的长度位数字
     *
     * @param code 代码
     * @param num  长度数字
     * @return {@link String}
     */
    public static String autoGenericCode(Integer code, int num)
    {
        String result = "";
        result = String.format("%0" + num + "d", code);
        return result;
    }
}
