package mao.aggregate_pay_uaa_service.feign;

import mao.aggregate_pay_user_api.dto.tenant.TenantDTO;
import mao.aggregate_pay_user_api.feign.TenantFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.feign
 * Class(测试类名): TenantFeignClientTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/21
 * Time(创建时间)： 15:01
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


@Transactional
@SpringBootTest
class TenantFeignClientTest
{
    @Autowired
    private TenantFeignClient tenantFeignClient;

    /**
     * Create tenant and init.
     */
    @Test
    void createTenantAndInit()
    {
    }

    /**
     * Create tenant relate account.
     */
    @Test
    void createTenantRelateAccount()
    {
    }

    /**
     * Gets tenant.
     */
    @Test
    void getTenant()
    {
        TenantDTO tenant = tenantFeignClient.getTenant(1L);
        System.out.println(tenant);
    }

    /**
     * Query tenants.
     */
    @Test
    void queryTenants()
    {
    }

    /**
     * Query bundle by tenant type.
     */
    @Test
    void queryBundleByTenantType()
    {
    }

    /**
     * Gets bundle.
     */
    @Test
    void getBundle()
    {
    }

    /**
     * Query all bundle.
     */
    @Test
    void queryAllBundle()
    {
        System.out.println(tenantFeignClient.queryAllBundle());
    }

    /**
     * Change bundle.
     */
    @Test
    void changeBundle()
    {
    }

    /**
     * Init bundle.
     */
    @Test
    void initBundle()
    {
    }

    /**
     * Create bundle.
     */
    @Test
    void createBundle()
    {
    }

    /**
     * Modify bundle.
     */
    @Test
    void modifyBundle()
    {
    }

    /**
     * Create account.
     */
    @Test
    void createAccount()
    {
    }

    /**
     * Test create account.
     */
    @Test
    void testCreateAccount()
    {
    }

    /**
     * Create account in tenant.
     */
    @Test
    void createAccountInTenant()
    {
    }

    /**
     * Bind tenant.
     */
    @Test
    void bindTenant()
    {
    }

    /**
     * Unbind tenant.
     */
    @Test
    void unbindTenant()
    {
    }

    /**
     * Is exist account by username.
     */
    @Test
    void isExistAccountByUsername()
    {
    }

    /**
     * Is exist account by mobile.
     */
    @Test
    void isExistAccountByMobile()
    {
    }

    /**
     * Gets account by username.
     */
    @Test
    void getAccountByUsername()
    {
    }

    /**
     * Gets account by mobile.
     */
    @Test
    void getAccountByMobile()
    {
    }

    /**
     * Is exist account in tenant by username.
     */
    @Test
    void isExistAccountInTenantByUsername()
    {
    }

    /**
     * Is exist account in tenant by mobile.
     */
    @Test
    void isExistAccountInTenantByMobile()
    {
    }

    /**
     * Query account.
     */
    @Test
    void queryAccount()
    {
    }

    /**
     * Query account in tenant.
     */
    @Test
    void queryAccountInTenant()
    {
    }

    /**
     * Send message.
     */
    @Test
    void sendMessage()
    {
    }

    /**
     * Authentication.
     */
    @Test
    void authentication()
    {
    }

    /**
     * Login.
     */
    @Test
    void login()
    {
    }

    /**
     * Gets application dto by client id.
     */
    @Test
    void getApplicationDTOByClientId()
    {
    }
}
