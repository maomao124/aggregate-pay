package mao.auth_server.service.auth.impl;

import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.RoleSaveDTO;
import mao.auth_entity.dto.auth.RoleUpdateDTO;
import mao.auth_entity.entity.auth.Role;
import mao.auth_server.service.auth.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(测试类名): RoleServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 21:45
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Slf4j
@Transactional
@SpringBootTest
class RoleServiceImplTest
{
    @Autowired
    private RoleService roleService;

    /**
     * 查询所有
     */
    @Test
    void queryAll()
    {
        for (Role role : roleService.list())
        {
            System.out.println(role);
            System.out.println();
        }
    }

    /**
     * 删除通过id
     */
    @Test
    void removeById()
    {
        boolean b = roleService.removeById(Arrays.asList(100L, 643779012732130273L));
        System.out.println(b);
    }

    /**
     * 通过用户id找到角色
     */
    @Test
    void findRoleByUserId()
    {
        List<Role> roleByUserId = roleService.findRoleByUserId(3L);
        for (Role role : roleByUserId)
        {
            System.out.println(role);
            System.out.println();
        }
    }

    /**
     * 保存角色
     */
    @Test
    void saveRole()
    {
        roleService.saveRole(RoleSaveDTO.builder().name("张三").build(), 3L);
    }

    /**
     * 更新作用
     */
    @Test
    void updateRole()
    {
        roleService.updateRole(RoleUpdateDTO.builder().name("张三").build(), 3L);
    }

    /**
     * 通过代码找到用户id
     */
    @Test
    void findUserIdByCode()
    {
        List<Long> longList = roleService.findUserIdByCode(new String[]{"PT_ADMIN"});
        System.out.println(longList);
    }

    /**
     * 检查
     */
    @Test
    void check()
    {
        Boolean aBoolean = roleService.check("PT_ADMIN");
        System.out.println(aBoolean);
    }
}