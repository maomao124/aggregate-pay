package mao.tools_core.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.utils
 * Class(测试类名): ValidatorUtilTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 22:39
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */
class ValidatorUtilTest
{

    /**
     * Is user name.
     */
    @Test
    void isUserName()
    {
        System.out.println(ValidatorUtil.isUserName(""));
    }

    /**
     * Is user name 2.
     */
    @Test
    void isUserName2()
    {
        try
        {
            System.out.println(ValidatorUtil.isUserName(null));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Is user name 3.
     */
    @Test
    void isUserName3()
    {
        System.out.println(ValidatorUtil.isUserName("123"));
    }

    /**
     * Is user name 4.
     */
    @Test
    void isUserName4()
    {
        System.out.println(ValidatorUtil.isUserName("23dgs"));
    }

    /**
     * Is password.
     */
    @Test
    void isPassword()
    {
        System.out.println(ValidatorUtil.isPassword(""));
    }

    /**
     * Is password 2.
     */
    @Test
    void isPassword2()
    {
        try
        {
            System.out.println(ValidatorUtil.isPassword(null));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Is password 3.
     */
    @Test
    void isPassword3()
    {
        System.out.println(ValidatorUtil.isPassword("123456"));
    }

    /**
     * Is password 4.
     */
    @Test
    void isPassword4()
    {
        System.out.println(ValidatorUtil.isPassword("123"));
    }

    /**
     * Is password 5.
     */
    @Test
    void isPassword5()
    {
        System.out.println(ValidatorUtil.isPassword("123456789"));
    }

    /**
     * Is password 6.
     */
    @Test
    void isPassword6()
    {
        System.out.println(ValidatorUtil.isPassword("12345l6"));
    }

    /**
     * Check phone.
     */
    @Test
    void checkPhone()
    {
        System.out.println(ValidatorUtil.checkPhone(""));
    }

    /**
     * Check phone 2.
     */
    @Test
    void checkPhone2()
    {
        try
        {
            System.out.println(ValidatorUtil.checkPhone(null));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Check phone 3.
     */
    @Test
    void checkPhone3()
    {
        System.out.println(ValidatorUtil.checkPhone("12889"));
    }

    /**
     * Check phone 4.
     */
    @Test
    void checkPhone4()
    {
        System.out.println(ValidatorUtil.checkPhone("18888888888"));
    }

    /**
     * Check phone 5.
     */
    @Test
    void checkPhone5()
    {
        System.out.println(ValidatorUtil.checkPhone("15822887788"));
    }

    /**
     * Check phone 6.
     */
    @Test
    void checkPhone6()
    {
        System.out.println(ValidatorUtil.checkPhone("1687369852"));
    }

    /**
     * Check phone 7.
     */
    @Test
    void checkPhone7()
    {
        System.out.println(ValidatorUtil.checkPhone("28845675892"));
    }
}