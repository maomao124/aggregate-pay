package mao.tools_core.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.utils
 * Class(测试类名): AntiSqlFilterTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 22:15
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class AntiSqlFilterTest
{

    /**
     * Gets safe value.
     */
    @Test
    void getSafeValue()
    {
        System.out.println(AntiSqlFilter.getSafeValue("exec select  * 123 exec \" /* drop"));
    }
}