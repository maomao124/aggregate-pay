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
 * Class(测试类名): AccountRoleMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 13:18
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


@Transactional
@SpringBootTest
class AccountRoleMapperTest
{

    @Autowired
    private AccountRoleMapper accountRoleMapper;

    /**
     * List.
     */
    @Test
    void list()
    {
        System.out.println(accountRoleMapper.selectList(null));
    }

    /**
     * Delete by username in tenant.
     */
    @Test
    void deleteByUsernameInTenant()
    {
        accountRoleMapper.deleteByUsernameInTenant(1L, "134");
    }

    /**
     * Select role by username in tenants.
     */
    @Test
    void selectRoleByUsernameInTenants()
    {
        System.out.println(accountRoleMapper.selectRoleByUsernameInTenants("sfasg", Collections.singletonList(1L)));
    }

    /**
     * Insert account role.
     */
    @Test
    void insertAccountRole()
    {
        accountRoleMapper.insertAccountRole("sgasg", 1L, Collections.singletonList("23"));
    }
}
