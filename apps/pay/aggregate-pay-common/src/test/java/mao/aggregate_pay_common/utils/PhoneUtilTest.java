package mao.aggregate_pay_common.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(测试类名): PhoneUtilTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 21:11
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


class PhoneUtilTest
{

    /**
     * Is matches.
     */
    @Test
    void isMatches()
    {
        System.out.println(PhoneUtil.isMatches("12235786578"));
    }

    /**
     * Is matches 2.
     */
    @Test
    void isMatches2()
    {
        System.out.println(PhoneUtil.isMatches("13235786578"));
    }

    /**
     * Is matches 3.
     */
    @Test
    void isMatches3()
    {
        System.out.println(PhoneUtil.isMatches("18865789657"));
    }

    /**
     * Is matches 4.
     */
    @Test
    void isMatches4()
    {
        System.out.println(PhoneUtil.isMatches("1886578965"));
    }

    /**
     * Is matches 5.
     */
    @Test
    void isMatches5()
    {
        System.out.println(PhoneUtil.isMatches("28865789657"));
    }

}
