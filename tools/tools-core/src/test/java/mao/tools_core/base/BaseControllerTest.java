package mao.tools_core.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.base
 * Class(测试类名): BaseControllerTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 14:22
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


class BaseControllerTest
{

    /**
     * Success.
     */
    @Test
    void success()
    {
        System.out.println(new BaseController().success("hello"));
    }

    /**
     * Fail.
     */
    @Test
    void fail()
    {
        System.out.println(new BaseController().fail("hello"));
    }
}