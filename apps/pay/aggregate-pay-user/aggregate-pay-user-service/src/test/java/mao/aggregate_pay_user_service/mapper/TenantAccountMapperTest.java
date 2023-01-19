package mao.aggregate_pay_user_service.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Class(测试类名): TenantAccountMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 19:12
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


@Transactional
@SpringBootTest
class TenantAccountMapperTest
{

    @Autowired
    private TenantAccountMapper tenantAccountMapper;

    /**
     * List.
     */
    @Test
    void list()
    {
        System.out.println(tenantAccountMapper.selectList(null));
    }

    /**
     * Select tenant by username in account.
     */
    @Test
    void selectTenantByUsernameInAccount()
    {
        System.out.println(tenantAccountMapper.selectTenantByUsernameInAccount("123"));
    }

    /**
     * Delete account in tenant.
     */
    @Test
    void deleteAccountInTenant()
    {
        tenantAccountMapper.deleteAccountInTenant(1L,1L);
    }

    /**
     * Select account role.
     */
    @Test
    void selectAccountRole()
    {
        System.out.println(tenantAccountMapper.selectAccountRole("123", "123", 1L));
    }
}
