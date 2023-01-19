package mao.aggregate_pay_user_service.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Class(测试类名): AccountMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 13:02
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


@Transactional
@SpringBootTest
class AccountMapperTest
{

    @Autowired
    private AccountMapper accountMapper;

    /**
     * List.
     */
    @Test
    void list()
    {
        System.out.println(accountMapper.selectList(null));
    }

    /**
     * Select account in tenant by mobile.
     */
    @Test
    void selectAccountInTenantByMobile()
    {
        System.out.println(accountMapper.selectAccountInTenantByMobile(1L, "123445"));
    }

    /**
     * Select account in tenant by name.
     */
    @Test
    void selectAccountInTenantByName()
    {
        System.out.println(accountMapper.selectAccountInTenantByName(1L, "test"));
    }

    /**
     * Select account by mobile.
     */
    @Test
    void selectAccountByMobile()
    {
        System.out.println(accountMapper.selectAccountByMobile("15555555"));
    }

    /**
     * Select account by name.
     */
    @Test
    void selectAccountByName()
    {
        System.out.println(accountMapper.selectAccountByName("dsg"));
    }

    /**
     * Delete account.
     */
    @Test
    void deleteAccount()
    {
        accountMapper.deleteAccount(13L);
    }

    /**
     * Select not admin.
     */
    @Test
    void selectNotAdmin()
    {
        System.out.println(accountMapper.selectNotAdmin(1L, "gdsg"));
    }

    /**
     * Select account by role.
     */
    @Test
    void selectAccountByRole()
    {
        System.out.println(accountMapper.selectAccountByRole(1L, "12345"));
    }

    /**
     * Select account by page.
     */
    @Test
    void selectAccountByPage()
    {

    }

    /**
     * Select account by tenant id.
     */
    @Test
    void selectAccountByTenantId()
    {
        System.out.println(accountMapper.selectAccountByTenantId(1L));
    }

    /**
     * Select account info by tenant id.
     */
    @Test
    void selectAccountInfoByTenantId()
    {
        System.out.println(accountMapper.selectAccountByTenantId(1L));
    }
}
