package mao.auth_server.service.auth.impl;

import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.entity.auth.Menu;
import mao.auth_server.service.auth.MenuService;
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
 * Class(测试类名): MenuServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 22:10
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Slf4j
@Transactional
@SpringBootTest
class MenuServiceImplTest
{
    @Autowired
    private MenuService menuService;


    /**
     * 查询所有
     */
    @Test
    void queryAll()
    {
        List<Menu> menuList = menuService.list();
        for (Menu menu : menuList)
        {
            System.out.println(menu);
            System.out.println();
        }
    }

    /**
     * 删除由ids
     */
    @Test
    void removeByIds()
    {
        boolean b = menuService.removeByIds(Arrays.asList(104L, 603976297063910529L));
        System.out.println(b);
    }

    /**
     * 找到可见菜单
     */
    @Test
    void findVisibleMenu()
    {
        List<Menu> menuList = menuService.findVisibleMenu("", 3L);
        for (Menu menu : menuList)
        {
            System.out.println(menu);
            System.out.println();
        }
    }

    /**
     * 保存
     */
    @Test
    void save()
    {

    }
}