package mao.aggregate_pay_user_service.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mao.aggregate_pay_user_api.dto.tenant.AccountRoleQueryDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Class(测试类名): TenantMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 19:31
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


@Transactional
@SpringBootTest
class TenantMapperTest
{

    @Autowired
    private TenantMapper tenantMapper;

    /**
     * List.
     */
    @Test
    void list()
    {
        System.out.println(tenantMapper.selectList(null));
    }

    /**
     * Insert tenant account.
     */
    @Test
    void insertTenantAccount()
    {
        tenantMapper.insertTenantAccount(99999L, 4523525235L, true);
    }

    /**
     * Select account in tenant.
     */
    @Test
    void selectAccountInTenant()
    {
        System.out.println(tenantMapper.selectAccountInTenant(99999L));
    }

    /**
     * Select tenant by page.
     */
    @Test
    void selectTenantByPage()
    {

    }

    /**
     * Query administrator by page.
     */
    @Test
    void queryAdministratorByPage()
    {
        Page<AccountRoleQueryDTO> page = new Page<>(1, 5);
        System.out.println(tenantMapper.queryAdministratorByPage(page, null));
    }
}
