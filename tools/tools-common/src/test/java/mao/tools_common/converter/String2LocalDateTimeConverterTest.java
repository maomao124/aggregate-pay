package mao.tools_common.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.converter
 * Class(测试类名): String2LocalDateTimeConverterTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 21:13
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


class String2LocalDateTimeConverterTest
{

    /**
     * Convert.
     */
    @Test
    void convert()
    {
        try
        {
            System.out.println(new String2LocalDateTimeConverter().convert("2022/10/01"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Convert 2.
     */
    @Test
    void convert2()
    {
        try
        {
            System.out.println(new String2LocalDateTimeConverter().convert("2022-10-01"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Convert 3.
     */
    @Test
    void convert3()
    {
        try
        {
            System.out.println(new String2LocalDateTimeConverter().convert("2022/10/01 11:16:59"));
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
            System.out.println(new String2LocalDateTimeConverter().convert("2022/10/01 11:16:61"));
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
            System.out.println(new String2LocalDateTimeConverter().convert("2022/10/01 11:16"));
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
            System.out.println(new String2LocalDateTimeConverter().convert("2022-10-01 11:16:59"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}