package mao.auth_server.service.auth.impl;

import mao.auth_entity.entity.auth.UserRole;
import mao.auth_server.service.auth.UserRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(测试类名): UserRoleServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 21:48
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class UserRoleServiceImplTest
{
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 查询所有
     */
    @Test
    void queryAll()
    {
        List<UserRole> userRoleList = userRoleService.query().list();
        for (UserRole userRole : userRoleList)
        {
            System.out.println(userRole);
            System.out.println();
        }
    }
}