package mao.auth_server.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.utils
 * Class(测试类名): SHA256Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 22:51
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class SHA256Test
{

    @Test
    void getSHA256()
    {
        System.out.println(SHA256.getSHA256("123"));
    }

    @Test
    void getSHA256toUpperCase()
    {
        System.out.println(SHA256.getSHA256toUpperCase("123"));
    }
}