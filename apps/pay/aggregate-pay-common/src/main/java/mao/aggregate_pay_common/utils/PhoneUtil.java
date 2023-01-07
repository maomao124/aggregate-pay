package mao.aggregate_pay_common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): PhoneUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 21:10
 * Version(版本): 1.0
 * Description(描述)： 手机号工具类
 */

public class PhoneUtil
{
    /**
     * 校验用户手机号是否合法
     *
     * @param phone 手机号
     * @return {@link Boolean}
     */
    public static Boolean isMatches(String phone)
    {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        return m.matches();
    }
}
