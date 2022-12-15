package mao.tools_common.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.converter
 * Class(测试类名): String2DateConverterTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 20:50
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


class String2DateConverterTest
{

    /**
     * Convert.
     */
    @Test
    void convert()
    {
        System.out.println(new String2DateConverter().convert("2012/6/13"));
    }

    /**
     * Convert 2.
     */
    @Test
    void convert2()
    {
        System.out.println(new String2DateConverter().convert("2017/7/16"));
    }

    /**
     * Convert 3.
     */
    @Test
    void convert3()
    {
        try
        {
            System.out.println(new String2DateConverter().convert("2012/6/32"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Convert 4.
     */
    @Test
    void convert4()
    {
        try
        {
            System.out.println(new String2DateConverter().convert("2012-6/13"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Convert 5.
     */
    @Test
    void convert5()
    {
        try
        {
            System.out.println(new String2DateConverter().convert("2012-6-13-"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Convert 6.
     */
    @Test
    void convert6()
    {
        try
        {
            System.out.println(new String2DateConverter().convert("201/6/13"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Convert 7.
     */
    @Test
    void convert7()
    {
        System.out.println(new String2DateConverter().convert("2012-6-13"));
    }

    /**
     * Convert 8.
     */
    @Test
    void convert8()
    {
        System.out.println(new String2DateConverter().convert("2012-6"));
    }

    /**
     * Convert 9.
     */
    @Test
    void convert9()
    {
        System.out.println(new String2DateConverter().convert("2012/6"));
    }

    /**
     * Convert 10.
     */
    @Test
    void convert10()
    {
        System.out.println(new String2DateConverter().convert("2012"));
    }

    /**
     * Convert 11.
     */
    @Test
    void convert11()
    {
        System.out.println(new String2DateConverter().convert("2012/6/13 22:11:36"));
    }

    /**
     * Convert 12.
     */
    @Test
    void convert12()
    {
        try
        {
            System.out.println(new String2DateConverter().convert("2012/6/13    22:11:36"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Convert 13.
     */
    @Test
    void convert13()
    {
        System.out.println(new String2DateConverter().convert("2012/6/13 22:11"));
    }

    /**
     * Convert 14.
     */
    @Test
    void convert14()
    {
        System.out.println(new String2DateConverter().convert("2012/6/13 22"));
    }
}