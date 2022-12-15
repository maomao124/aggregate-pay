package mao.gateway.api;

import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.entity.auth.Resource;
import mao.tools_core.base.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.gateway.api
 * Class(测试类名): ResourceApiTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/13
 * Time(创建时间)： 13:54
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Slf4j
@SpringBootTest
class ResourceApiTest
{

    @Autowired
    private ResourceApi resourceApi;

    @Test
    void list()
    {
        R<List> list = resourceApi.list();
        System.out.println("----------------------");
        System.out.println(list);
        System.out.println("----------------------");
    }

    @Test
    void visible()
    {
        System.out.println("----------------------");
        R<List<Resource>> visible = resourceApi.visible(ResourceQueryDTO.builder().userId(3L).menuId(123L).build());
        System.out.println("----------------------");
        System.out.println(visible);
        System.out.println("----------------------");
        for (Resource resource : visible.getData())
        {
            System.out.println(resource);
            System.out.println();
        }
        System.out.println("----------------------");
    }
}