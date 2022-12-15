package mao.tools_core.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.utils
 * Class(类名): TimeUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 21:45
 * Version(版本): 1.0
 * Description(描述)： 时间工具类
 */

public class TimeUtils
{
    /**
     * 得到密码错误锁定时间
     *
     * @param time 时间
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime getPasswordErrorLockTime(String time)
    {
        if (time == null || "".equals(time))
        {
            return LocalDateTime.MAX;
        }
        if ("0".equals(time))
        {
            return LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        }
        //获取时间单位
        char unit = Character.toLowerCase(time.charAt(time.length() - 1));

        if (time.length() == 1)
        {
            unit = 'd';
        }
        Long lastTime = NumberHelper.longValueOf0(time.substring(0, time.length() - 1));

        LocalDateTime passwordErrorLastTime = LocalDateTime.MAX;
        switch (unit)
        {
            //时
            case 'h':
                passwordErrorLastTime = LocalDateTime.now().plusHours(lastTime);
                break;
            //天
            case 'd':
                passwordErrorLastTime = LocalDateTime.now().plusDays(lastTime);
                break;
            //周
            case 'w':
                passwordErrorLastTime = LocalDateTime.now().plusWeeks(lastTime);
                break;
            //月
            case 'm':
                passwordErrorLastTime = LocalDateTime.now().plusMonths(lastTime);
                break;
            default:
                passwordErrorLastTime = LocalDateTime.now().plusDays(lastTime);
                break;
        }

        return passwordErrorLastTime;
    }

}
