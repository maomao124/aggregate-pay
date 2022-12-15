package mao.tools_common.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.enums
 * Class(测试类名): HttpMethodTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 14:56
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class HttpMethodTest
{

    /**
     * Get.
     */
    @Test
    void get()
    {
        System.out.println(HttpMethod.get("get"));
    }

    /**
     * Gets 2.
     */
    @Test
    void get2()
    {
        System.out.println(HttpMethod.get(HttpMethod.POST.getCode()));
    }
}