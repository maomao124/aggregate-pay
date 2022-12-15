package mao.tools_common.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.config
 * Class(测试类名): IgnoreTokenConfigTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 14:45
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */
class IgnoreTokenConfigTest
{

    /**
     * Is ignore token.
     */
    @Test
    void isIgnoreToken()
    {
        System.out.println(IgnoreTokenConfig.isIgnoreToken("/error"));
    }

    /**
     * Is ignore token 2.
     */
    @Test
    void isIgnoreToken2()
    {
        System.out.println(IgnoreTokenConfig.isIgnoreToken("/error3"));
    }

    /**
     * Is ignore token 3.
     */
    @Test
    void isIgnoreToken3()
    {
        System.out.println(IgnoreTokenConfig.isIgnoreToken("/error2"));
    }

    /**
     * Is ignore token 4.
     */
    @Test
    void isIgnoreToken4()
    {
        System.out.println(IgnoreTokenConfig.isIgnoreToken("/static/a.html"));
    }

    /**
     * Is ignore token 5.
     */
    @Test
    void isIgnoreToken5()
    {
        System.out.println(IgnoreTokenConfig.isIgnoreToken("/hello"));
    }

    /**
     * Is ignore token 6.
     */
    @Test
    void isIgnoreToken6()
    {
        System.out.println(IgnoreTokenConfig.isIgnoreToken("/doc.html"));
    }

    /**
     * Is ignore token 7.
     */
    @Test
    void isIgnoreToken7()
    {
        System.out.println(IgnoreTokenConfig.isIgnoreToken("/hello/doc.html"));
    }

    /**
     * Is ignore token 8.
     */
    @Test
    void isIgnoreToken8()
    {
        System.out.println(IgnoreTokenConfig.isIgnoreToken("/do4c.html"));
    }
}