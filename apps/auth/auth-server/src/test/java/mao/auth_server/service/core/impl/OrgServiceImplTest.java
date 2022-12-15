package mao.auth_server.service.core.impl;

import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.entity.core.Org;
import mao.auth_server.service.core.OrgService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.core.impl
 * Class(测试类名): OrgServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 20:34
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Slf4j
@Transactional
@SpringBootTest
class OrgServiceImplTest
{
    @Autowired
    private OrgService orgService;

    /**
     * 查询所有
     */
    @Test
    void queryAll()
    {
        for (Org org : orgService.list())
        {
            System.out.println(org);
            System.out.println();
        }
    }

    /**
     * 找到孩子
     */
    @Test
    void findChildren()
    {
        List<Org> list = orgService.findChildren(Collections.singletonList(643775612976106881L));
        System.out.println(list);
    }

    /**
     * 删除
     */
    @Test
    void remove()
    {
        boolean remove = orgService.remove(Collections.singletonList(643775612976106881L));
        System.out.println(remove);
    }
}