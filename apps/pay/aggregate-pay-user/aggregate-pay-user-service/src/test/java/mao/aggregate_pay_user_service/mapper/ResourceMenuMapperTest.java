package mao.aggregate_pay_user_service.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Class(测试类名): ResourceMenuMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 18:37
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


@Transactional
@SpringBootTest
class ResourceMenuMapperTest
{

    @Autowired
    private ResourceMenuMapper resourceMenuMapper;

    /**
     * List.
     */
    @Test
    void list()
    {
        System.out.println(resourceMenuMapper.selectList(null));
    }

    /**
     * Select resource by application code.
     */
    @Test
    void selectResourceByApplicationCode()
    {
        System.out.println(resourceMenuMapper.selectResourceByApplicationCode("1"));
    }

    /**
     * Select resource by privilege in app.
     */
    @Test
    void selectResourceByPrivilegeInApp()
    {
        System.out.println(resourceMenuMapper.selectResourceByPrivilegeInApp(Collections.singletonList("1"), "1"));
    }

    /**
     * Select by page.
     */
    @Test
    void selectByPage()
    {

    }

    /**
     * Select resource.
     */
    @Test
    void selectResource()
    {
        System.out.println(resourceMenuMapper.selectResource(Collections.singletonList("1")));
    }
}
