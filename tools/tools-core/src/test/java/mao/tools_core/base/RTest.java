package mao.tools_core.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.base
 * Class(测试类名): RTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 13:59
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


class RTest
{

    /**
     * Test to string.
     */
    @Test
    void testToString()
    {
        R<String> fail = R.fail("错误");
        System.out.println(fail);
    }

    /**
     * Test to string 2.
     */
    @Test
    void testToString2()
    {
        System.out.println(R.success());
    }

    /**
     * Test to string 3.
     */
    @Test
    void testToString3()
    {
        System.out.println(R.success("测试"));
    }

    /**
     * Test to string 4.
     */
    @Test
    void testToString4()
    {
        System.out.println(R.success("数据","成功"));
    }
}