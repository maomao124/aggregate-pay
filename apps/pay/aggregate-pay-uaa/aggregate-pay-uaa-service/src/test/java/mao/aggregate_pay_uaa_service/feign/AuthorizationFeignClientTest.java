package mao.aggregate_pay_uaa_service.feign;

import mao.aggregate_pay_user_api.dto.auth.PrivilegeDTO;
import mao.aggregate_pay_user_api.feign.AuthorizationFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.feign
 * Class(测试类名): AuthorizationFeignClientTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/21
 * Time(创建时间)： 15:02
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Transactional
@SpringBootTest
class AuthorizationFeignClientTest
{

    @Autowired
    private AuthorizationFeignClient authorizationFeignClient;

    /**
     * Authorize.
     */
    @Test
    void authorize()
    {
    }

    /**
     * Query privilege.
     */
    @Test
    void queryPrivilege()
    {
    }

    /**
     * Query privilege by group id.
     */
    @Test
    void queryPrivilegeByGroupId()
    {
        List<PrivilegeDTO> privilegeDTOS = authorizationFeignClient.queryPrivilegeByGroupId(1L);
        System.out.println(privilegeDTOS);
    }

    /**
     * Query privilege tree.
     */
    @Test
    void queryPrivilegeTree()
    {
    }

    /**
     * Create role.
     */
    @Test
    void createRole()
    {
    }

    /**
     * Remove role.
     */
    @Test
    void removeRole()
    {
    }

    /**
     * Modify role.
     */
    @Test
    void modifyRole()
    {
    }

    /**
     * Role bind privilege.
     */
    @Test
    void roleBindPrivilege()
    {
    }

    /**
     * Query role.
     */
    @Test
    void queryRole()
    {
    }

    /**
     * Test query role.
     */
    @Test
    void testQueryRole()
    {
    }

    /**
     * Query tenant role.
     */
    @Test
    void queryTenantRole()
    {
    }

    /**
     * Bind account role.
     */
    @Test
    void bindAccountRole()
    {
    }

    /**
     * Unbind account role.
     */
    @Test
    void unbindAccountRole()
    {
    }
}
