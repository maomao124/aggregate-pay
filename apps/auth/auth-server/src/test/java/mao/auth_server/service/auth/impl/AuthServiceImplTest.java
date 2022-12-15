package mao.auth_server.service.auth.impl;

import mao.auth_entity.dto.auth.LoginDTO;
import mao.auth_server.service.auth.AuthService;
import mao.tools_core.base.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(测试类名): AuthServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 13:48
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class AuthServiceImplTest
{
    @Autowired
    private AuthService authService;

    /**
     * 登录
     */
    @Test
    void login()
    {
        try
        {
            R<LoginDTO> login = authService.login("123", "123456", "123", "241q5");
            System.out.println(login);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}