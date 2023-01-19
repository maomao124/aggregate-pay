package mao.aggregate_pay_user_service.mapper;

import mao.aggregate_pay_user_service.entity.AuthorizationRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Class(测试类名): AuthorizationRoleMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 18:10
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


@Transactional
@SpringBootTest
class AuthorizationRoleMapperTest
{

    @Autowired
    private AuthorizationRoleMapper authorizationRoleMapper;

    /**
     * List.
     */
    @Test
    void list()
    {
        System.out.println(authorizationRoleMapper.selectList(null));
    }

    /**
     * Select privilege by role.
     */
    @Test
    void selectPrivilegeByRole()
    {
        System.out.println(authorizationRoleMapper.selectPrivilegeByRole(1L));
    }

    /**
     * Create roles.
     */
    @Test
    void createRoles()
    {
        List<AuthorizationRole> list = new ArrayList<>();
        AuthorizationRole authorizationRole = new AuthorizationRole();
        authorizationRole.setCode("999999");
        authorizationRole.setName("test");
        authorizationRole.setTenantId(1L);
        list.add(authorizationRole);
        authorizationRoleMapper.createRoles(1L, list);
    }

    /**
     * Select role code in tenant.
     */
    @Test
    void selectRoleCodeInTenant()
    {
        System.out.println(authorizationRoleMapper.selectRoleCodeInTenant(1L, "4"));
    }
}
