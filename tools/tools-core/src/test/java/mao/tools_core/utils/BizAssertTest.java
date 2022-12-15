package mao.tools_core.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.utils
 * Class(测试类名): BizAssertTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 22:19
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */
class BizAssertTest
{

    /**
     * Is false.
     */
    @Test
    void isFalse()
    {
        try
        {
            BizAssert.isFalse(true, "不能为TRUE");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Is false 2.
     */
    @Test
    void isFalse2()
    {
        BizAssert.isFalse(false, "不能为TRUE");
    }

    /**
     * Not null.
     */
    @Test
    void notNull()
    {
        BizAssert.notNull("123", "不能为null");
    }

    /**
     * Not null 2.
     */
    @Test
    void notNull2()
    {
        BizAssert.notNull(new Object(), "不能为null");
    }

    /**
     * Not null 3.
     */
    @Test
    void notNull3()
    {
        try
        {
            BizAssert.notNull(null, "不能为null");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Not empty.
     */
    @Test
    void notEmpty()
    {
        BizAssert.notEmpty("123");
    }

    /**
     * Not empty 2.
     */
    @Test
    void notEmpty2()
    {
        BizAssert.notEmpty("1");
    }

    /**
     * Not empty 3.
     */
    @Test
    void notEmpty3()
    {
        try
        {
            BizAssert.notEmpty("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Not empty 4.
     */
    @Test
    void notEmpty4()
    {
        try
        {
            BizAssert.notEmpty(null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Test equals.
     */
    @Test
    void testEquals()
    {
        BizAssert.equals("123", "123", "不相等");
    }

    /**
     * Test equals 2.
     */
    @Test
    void testEquals2()
    {
        BizAssert.equals("1231", "1231", "不相等");
    }

    /**
     * Test equals 3.
     */
    @Test
    void testEquals3()
    {
        try
        {
            BizAssert.equals("1234", "123", "不相等");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Test equals 4.
     */
    @Test
    void testEquals4()
    {
        try
        {
            BizAssert.equals(new Object(), new Object(), "不相等");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Test equals 5.
     */
    @Test
    void testEquals5()
    {
        try
        {
            BizAssert.equals(null, null, "不相等");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Test equals 6.
     */
    @Test
    void testEquals6()
    {
        try
        {
            BizAssert.equals(new Object(), null, "不相等");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}