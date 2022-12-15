package mao.tools_core.base.id;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.base.id
 * Class(测试类名): CodeGenerateTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 13:35
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


class CodeGenerateTest
{
    /**
     * Test 1.
     */
    @Test
    void test1()
    {
        System.out.println(new Date(1548954061000L));
    }

    /**
     * Test 2.
     */
    @Test
    void test2()
    {
        Date date = new Date(1548954061000L);
        System.out.println(date.getYear());
        date.setYear(date.getYear() + 3);
        System.out.println(date);
        System.out.println(date.getTime());
    }


    /**
     * Test 3.
     */
    @Test
    void test3()
    {
        System.out.println(new Date(1643648461000L));
    }

    /**
     * Next.
     */
    @Test
    void next()
    {
        CodeGenerate codeGenerate = new CodeGenerate(3);
        String s = codeGenerate.next();
        System.out.println(s);
    }

    /**
     * Next 2.
     */
    @Test
    void next2()
    {
        CodeGenerate codeGenerate = new CodeGenerate(9);
        String s = codeGenerate.next();
        System.out.println(s);
    }

    /**
     * Next 3.
     */
    @Test
    void next3()
    {
        CodeGenerate codeGenerate = new CodeGenerate(3);
        for (int i = 0; i < 100; i++)
        {
            String s = codeGenerate.next();
            System.out.println(s);
        }
    }


    /**
     * Next 4.
     */
    @Test
    void next4()
    {
        CodeGenerate codeGenerate = new CodeGenerate(3);
        for (int i = 0; i < 20; i++)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int i = 0; i < 100; i++)
                    {
                        String s = codeGenerate.next();
                        System.out.println(s);
                    }
                }
            }).start();
        }
    }
}