package mao.auth_server.dao.auth;

import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.entity.auth.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.auth
 * Class(测试类名): ResourceMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 21:43
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class ResourceMapperTest
{

    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 发现明显资源
     */
    @Test
    void findVisibleResource()
    {
        ResourceQueryDTO resourceQueryDTO = new ResourceQueryDTO();
        resourceQueryDTO.setUserId(3L);
        resourceQueryDTO.setMenuId(101L);
        List<Resource> visibleResource = resourceMapper.findVisibleResource(resourceQueryDTO);
        for (Resource resource : visibleResource)
        {
            System.out.println(resource);
            System.out.println();
        }
    }

    /**
     * 通过资源id找到菜单id
     */
    @Test
    void findMenuIdByResourceId()
    {
        List<Long> list = new ArrayList<>();
        list.add(643445704177487105L);
        list.add(603982542332235201L);
        List<Long> menuIdByResourceId = resourceMapper.findMenuIdByResourceId(list);
        for (Long aLong : menuIdByResourceId)
        {
            System.out.println(aLong);
        }
    }

    /**
     * 查询所有
     */
    @Test
    void queryAll()
    {
        List<Resource> resources = resourceMapper.selectList(null);
        for (Resource resource : resources)
        {
            System.out.println(resource);
            System.out.println();
        }
    }
}