package mao.auth_server.service.auth.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(测试类名): SHA256PasswordEncoderServiceTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 22:59
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class SHA256PasswordEncoderServiceTest
{

    /**
     * 编码器
     */
    @Test
    void encoder()
    {
        System.out.println(new SHA256PasswordEncoderService().encoder("123"));
    }

    /**
     * 验证
     */
    @Test
    void verification()
    {
        System.out.println(new SHA256PasswordEncoderService().verification("123",
                "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3"));

    }

    /**
     * verification2
     */
    @Test
    void verification2()
    {
        System.out.println(new SHA256PasswordEncoderService().verification("1234",
                "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3"));

    }
}