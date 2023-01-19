package mao.aggregate_pay_user_service.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Class(测试类名): AuthorizationPrivilegeMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 17:54
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


@Transactional
@SpringBootTest
class AuthorizationPrivilegeMapperTest
{

    @Autowired
    private AuthorizationPrivilegeMapper authorizationPrivilegeMapper;

    /**
     * List.
     */
    @Test
    void list()
    {
        System.out.println(authorizationPrivilegeMapper.selectList(null));
    }

    /**
     * Select privilege by role.
     */
    @Test
    void selectPrivilegeByRole()
    {
        System.out.println(authorizationPrivilegeMapper.selectPrivilegeByRole(Collections.singletonList(4L)));
    }

    /**
     * Select privilege role in tenant.
     */
    @Test
    void selectPrivilegeRoleInTenant()
    {
        System.out.println(authorizationPrivilegeMapper.selectPrivilegeRoleInTenant(Collections.singletonList(1L)));
    }
}
