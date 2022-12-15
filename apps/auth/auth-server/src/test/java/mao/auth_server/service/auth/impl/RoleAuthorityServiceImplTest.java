package mao.auth_server.service.auth.impl;

import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.RoleAuthoritySaveDTO;
import mao.auth_entity.dto.auth.UserRoleSaveDTO;
import mao.auth_entity.entity.auth.RoleAuthority;
import mao.auth_server.service.auth.RoleAuthorityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(测试类名): RoleAuthorityServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 21:24
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Slf4j
@Transactional
@SpringBootTest
class RoleAuthorityServiceImplTest
{

    @Autowired
    private RoleAuthorityService roleAuthorityService;

    /**
     * 查询所有
     */
    @Test
    void queryAll()
    {
        for (RoleAuthority roleAuthority : roleAuthorityService.list())
        {
            System.out.println(roleAuthority);
            System.out.println();
        }
    }

    /**
     * 保存用户角色
     */
    @Test
    void saveUserRole()
    {
        boolean b = roleAuthorityService.saveUserRole(UserRoleSaveDTO.builder().build());
        System.out.println(b);
    }

    /**
     * 保存角色权限
     */
    @Test
    void saveRoleAuthority()
    {
        boolean b = roleAuthorityService.saveRoleAuthority(RoleAuthoritySaveDTO.builder().build());
        System.out.println();
    }
}