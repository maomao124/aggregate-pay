package mao.aggregate_pay_uaa_service.feign;

import mao.aggregate_pay_user_api.dto.auth.RoleDTO;
import mao.aggregate_pay_user_api.feign.AuthorizationFeignClientV2;
import mao.tools_core.base.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.feign
 * Class(测试类名): AuthorizationFeignClientV2Test
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
class AuthorizationFeignClientV2Test
{

    @Autowired
    private AuthorizationFeignClientV2 authorizationFeignClientV2;

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
        R<List<RoleDTO>> r = authorizationFeignClientV2.queryRole(1L);
        System.out.println(r.getData());
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
