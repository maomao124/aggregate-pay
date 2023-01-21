package mao.aggregate_pay_uaa_service.feign;

import mao.aggregate_pay_user_api.dto.tenant.BundleDTO;
import mao.aggregate_pay_user_api.feign.TenantFeignClientV2;
import mao.tools_core.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.feign
 * Class(测试类名): TenantFeignClientV2Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/21
 * Time(创建时间)： 15:00
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


@Transactional
@SpringBootTest
class TenantFeignClientV2Test
{

    @Autowired
    private TenantFeignClientV2 tenantFeignClientV2;

    /**
     * Create tenant and init.
     */
    @org.junit.jupiter.api.Test
    void createTenantAndInit()
    {
    }

    /**
     * Create tenant relate account.
     */
    @org.junit.jupiter.api.Test
    void createTenantRelateAccount()
    {
    }

    /**
     * Gets tenant.
     */
    @org.junit.jupiter.api.Test
    void getTenant()
    {
    }

    /**
     * Query tenants.
     */
    @org.junit.jupiter.api.Test
    void queryTenants()
    {

    }

    /**
     * Query bundle by tenant type.
     */
    @org.junit.jupiter.api.Test
    void queryBundleByTenantType()
    {
    }

    /**
     * Gets bundle.
     */
    @org.junit.jupiter.api.Test
    void getBundle()
    {
    }

    /**
     * Query all bundle.
     */
    @org.junit.jupiter.api.Test
    void queryAllBundle()
    {
        R<List<BundleDTO>> r = tenantFeignClientV2.queryAllBundle();
        System.out.println(r.getData());
    }

    /**
     * Change bundle.
     */
    @org.junit.jupiter.api.Test
    void changeBundle()
    {
    }

    /**
     * Init bundle.
     */
    @org.junit.jupiter.api.Test
    void initBundle()
    {
    }

    /**
     * Create bundle.
     */
    @org.junit.jupiter.api.Test
    void createBundle()
    {
    }

    /**
     * Modify bundle.
     */
    @org.junit.jupiter.api.Test
    void modifyBundle()
    {
    }

    /**
     * Create account.
     */
    @org.junit.jupiter.api.Test
    void createAccount()
    {
    }

    /**
     * Test create account.
     */
    @org.junit.jupiter.api.Test
    void testCreateAccount()
    {
    }

    /**
     * Create account in tenant.
     */
    @org.junit.jupiter.api.Test
    void createAccountInTenant()
    {
    }

    /**
     * Bind tenant.
     */
    @org.junit.jupiter.api.Test
    void bindTenant()
    {
    }

    /**
     * Unbind tenant.
     */
    @org.junit.jupiter.api.Test
    void unbindTenant()
    {
    }

    /**
     * Is exist account by username.
     */
    @org.junit.jupiter.api.Test
    void isExistAccountByUsername()
    {
    }

    /**
     * Is exist account by mobile.
     */
    @org.junit.jupiter.api.Test
    void isExistAccountByMobile()
    {
    }

    /**
     * Gets account by username.
     */
    @org.junit.jupiter.api.Test
    void getAccountByUsername()
    {
    }

    /**
     * Gets account by mobile.
     */
    @org.junit.jupiter.api.Test
    void getAccountByMobile()
    {
    }

    /**
     * Is exist account in tenant by username.
     */
    @org.junit.jupiter.api.Test
    void isExistAccountInTenantByUsername()
    {
    }

    /**
     * Is exist account in tenant by mobile.
     */
    @org.junit.jupiter.api.Test
    void isExistAccountInTenantByMobile()
    {
    }

    /**
     * Query account.
     */
    @org.junit.jupiter.api.Test
    void queryAccount()
    {

    }

    /**
     * Query account in tenant.
     */
    @org.junit.jupiter.api.Test
    void queryAccountInTenant()
    {
    }

    /**
     * Send message.
     */
    @org.junit.jupiter.api.Test
    void sendMessage()
    {
    }

    /**
     * Authentication.
     */
    @org.junit.jupiter.api.Test
    void authentication()
    {
    }

    /**
     * Login.
     */
    @org.junit.jupiter.api.Test
    void login()
    {
    }

    /**
     * Gets application dto by client id.
     */
    @org.junit.jupiter.api.Test
    void getApplicationDTOByClientId()
    {
    }
}
