package mao.tools_core.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.utils
 * Class(测试类名): TimeUtilsTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 22:28
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */
class TimeUtilsTest
{

    /**
     * Gets password error lock time.
     */
    @Test
    void getPasswordErrorLockTime()
    {
        LocalDateTime passwordErrorLockTime = TimeUtils.getPasswordErrorLockTime("3m");
        System.out.println(passwordErrorLockTime);
    }

    /**
     * Gets password error lock time 2.
     */
    @Test
    void getPasswordErrorLockTime2()
    {
        LocalDateTime passwordErrorLockTime = TimeUtils.getPasswordErrorLockTime("35m");
        System.out.println(passwordErrorLockTime);
    }

    /**
     * Gets password error lock time 3.
     */
    @Test
    void getPasswordErrorLockTime3()
    {
        LocalDateTime passwordErrorLockTime = TimeUtils.getPasswordErrorLockTime("1h");
        System.out.println(passwordErrorLockTime);
    }

    /**
     * Gets password error lock time 4.
     */
    @Test
    void getPasswordErrorLockTime4()
    {
        LocalDateTime passwordErrorLockTime = TimeUtils.getPasswordErrorLockTime("3h");
        System.out.println(passwordErrorLockTime);
    }

    /**
     * Gets password error lock time 5.
     */
    @Test
    void getPasswordErrorLockTime5()
    {
        LocalDateTime passwordErrorLockTime = TimeUtils.getPasswordErrorLockTime("");
        System.out.println(passwordErrorLockTime);
    }

    /**
     * Gets password error lock time 6.
     */
    @Test
    void getPasswordErrorLockTime6()
    {
        LocalDateTime passwordErrorLockTime = TimeUtils.getPasswordErrorLockTime(null);
        System.out.println(passwordErrorLockTime);
    }

}