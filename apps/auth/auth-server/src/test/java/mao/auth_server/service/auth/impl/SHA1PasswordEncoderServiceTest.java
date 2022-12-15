package mao.auth_server.service.auth.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(测试类名): SHA1PasswordEncoderServiceTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 22:58
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class SHA1PasswordEncoderServiceTest
{

    /**
     * 编码器
     */
    @Test
    void encoder()
    {
        System.out.println(new SHA1PasswordEncoderService().encoder("123"));
    }

    /**
     * 验证
     */
    @Test
    void verification()
    {
        System.out.println(new SHA1PasswordEncoderService().verification("123",
                "40bd001563085fc35165329ea1ff5c5ecbdbbeef"));
    }

    /**
     * verification2
     */
    @Test
    void verification2()
    {
        System.out.println(new SHA1PasswordEncoderService().verification("113",
                "40bd001563085fc35165329ea1ff5c5ecbdbbeef"));
    }

    @Test
    void verification3()
    {
        System.out.println(new SHA1PasswordEncoderService().verification("123",
                "40bd001562085fc35165329ea1ff5c5ecbdbbeef"));
    }
}