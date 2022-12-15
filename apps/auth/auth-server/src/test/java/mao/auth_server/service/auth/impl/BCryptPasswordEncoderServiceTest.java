package mao.auth_server.service.auth.impl;

import mao.auth_server.service.auth.PasswordEncoderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(测试类名): BCryptPasswordEncoderServiceTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 21:44
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class BCryptPasswordEncoderServiceTest
{
    @Resource
    private PasswordEncoderService passwordEncoderService;

    /**
     * 编码器
     */
    @Test
    void encoder()
    {
        System.out.println(passwordEncoderService.encoder("123456"));
    }

    /**
     * 验证
     */
    @Test
    void verification()
    {
        boolean verification = passwordEncoderService.verification("123456",
                "$2a$10$CA2o1euRv0d1nI03Mve5zeVOW0LzBk2v7U6uLpgf6Q6zVFKgflSuq");
        System.out.println(verification);
        if (!verification)
        {
            throw new RuntimeException();
        }
    }

    /**
     * verification2
     */
    @Test
    void verification2()
    {
        boolean verification = passwordEncoderService.verification("123456789",
                "$2a$10$CA2o1euRv0d1nI03Mve5zeVOW0LzBk2v7U6uLpgf6Q6zVFKgflSuq");
        System.out.println(verification);
        if (verification)
        {
            throw new RuntimeException();
        }
    }
}