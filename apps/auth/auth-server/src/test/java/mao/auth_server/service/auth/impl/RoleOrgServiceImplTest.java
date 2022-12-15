package mao.auth_server.service.auth.impl;

import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.entity.auth.RoleOrg;
import mao.auth_server.service.auth.RoleOrgService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(测试类名): RoleOrgServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 21:09
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Slf4j
@Transactional
@SpringBootTest
class RoleOrgServiceImplTest
{

    @Autowired
    private RoleOrgService roleOrgService;

    /**
     * 查询所有
     */
    @Test
    void queryAll()
    {
        for (RoleOrg roleOrg : roleOrgService.list())
        {
            System.out.println(roleOrg);
            System.out.println();
        }
    }

    /**
     * 组织通过角色id列表
     */
    @Test
    void listOrgByRoleId()
    {
        List<Long> list = roleOrgService.listOrgByRoleId(645198153556958497L);
        System.out.println(list);
    }
}