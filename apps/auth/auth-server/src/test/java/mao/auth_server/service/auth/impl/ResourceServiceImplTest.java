package mao.auth_server.service.auth.impl;

import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.entity.auth.Resource;
import mao.auth_server.service.auth.ResourceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(测试类名): ResourceServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 22:33
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Slf4j
@Transactional
@SpringBootTest
class ResourceServiceImplTest
{
    @Autowired
    private ResourceService resourceService;

    /**
     * 查询所有
     */
    @Test
    void queryAll()
    {
        List<Resource> resourceList = resourceService.list();
        for (Resource resource : resourceList)
        {
            System.out.println(resource);
            System.out.println();
        }
    }

    /**
     * 发现明显资源
     */
    @Test
    void findVisibleResource()
    {
        List<Resource> resourceList = resourceService.
                findVisibleResource(ResourceQueryDTO.builder().menuId(603981723864141121L).build());
        for (Resource resource : resourceList)
        {
            System.out.println(resource);
            System.out.println();
        }
    }

    /**
     * 删除菜单id
     */
    @Test
    void removeByMenuId()
    {
        List<Long> list = new ArrayList<>();
        list.add(603982542332235201L);
        resourceService.removeByMenuId(list);
    }

    /**
     * 通过资源id找到菜单id
     */
    @Test
    void findMenuIdByResourceId()
    {
        List<Long> list = new ArrayList<>();
        list.add(643444685339100193L);
        List<Long> longList = resourceService.findMenuIdByResourceId(list);
        System.out.println(longList);
    }
}