package mao.auth_server.service.auth.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(测试类名): MD5PasswordEncoderServiceTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 22:56
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class MD5PasswordEncoderServiceTest
{

    /**
     * 编码器
     */
    @Test
    void encoder()
    {
        System.out.println(new MD5PasswordEncoderService().encoder("123"));
    }

    /**
     * 验证
     */
    @Test
    void verification()
    {
        System.out.println(new MD5PasswordEncoderService().verification("123",
                "202cb962ac59075b964b07152d234b70"));
    }

    /**
     * verification2
     */
    @Test
    void verification2()
    {
        System.out.println(new MD5PasswordEncoderService().verification("124",
                "202cb962ac59075b964b07152d234b70"));
    }

    /**
     * verification3
     */
    @Test
    void verification3()
    {
        System.out.println(new MD5PasswordEncoderService().verification("123",
                "202cb962ac59075b964b07152d234b71"));
    }
}