package mao.aggregate_pay_common.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(测试类名): RandomStringUtilTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 21:26
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


class RandomStringUtilTest
{

    /**
     * Gets random string.
     */
    @Test
    void getRandomString()
    {
        System.out.println(RandomStringUtil.getRandomString(6));
        System.out.println(RandomStringUtil.getRandomString(6));
        System.out.println(RandomStringUtil.getRandomString(6));
        System.out.println(RandomStringUtil.getRandomString(6));
        System.out.println(RandomStringUtil.getRandomString(6));
    }

    /**
     * Gets random string 2.
     */
    @Test
    void getRandomString2()
    {
        System.out.println(RandomStringUtil.getRandomString(5));
        System.out.println(RandomStringUtil.getRandomString(5));
        System.out.println(RandomStringUtil.getRandomString(5));
        System.out.println(RandomStringUtil.getRandomString(5));
        System.out.println(RandomStringUtil.getRandomString(5));
    }

    /**
     * Gets random string 3.
     */
    @Test
    void getRandomString3()
    {
        System.out.println(RandomStringUtil.getRandomString(16));
        System.out.println(RandomStringUtil.getRandomString(16));
        System.out.println(RandomStringUtil.getRandomString(16));
        System.out.println(RandomStringUtil.getRandomString(16));
        System.out.println(RandomStringUtil.getRandomString(16));
    }

    /**
     * Gets random string 4.
     */
    @Test
    void getRandomString4()
    {
        System.out.println(RandomStringUtil.getRandomString(64));
        System.out.println(RandomStringUtil.getRandomString(64));
        System.out.println(RandomStringUtil.getRandomString(64));
        System.out.println(RandomStringUtil.getRandomString(64));
        System.out.println(RandomStringUtil.getRandomString(64));
    }
}
