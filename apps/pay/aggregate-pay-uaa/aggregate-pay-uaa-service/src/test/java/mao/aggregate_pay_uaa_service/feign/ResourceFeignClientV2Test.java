package mao.aggregate_pay_uaa_service.feign;

import mao.aggregate_pay_user_api.dto.menu.MenuDTO;
import mao.aggregate_pay_user_api.feign.ResourceFeignClientV2;
import mao.tools_core.base.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.feign
 * Class(测试类名): ResourceFeignClientV2Test
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
class ResourceFeignClientV2Test
{
    @Autowired
    private ResourceFeignClientV2 resourceFeignClientV2;

    /**
     * Create application.
     */
    @Test
    void createApplication()
    {
    }

    /**
     * Modify application.
     */
    @Test
    void modifyApplication()
    {
    }

    /**
     * Remove application.
     */
    @Test
    void removeApplication()
    {
    }

    /**
     * Query application.
     */
    @Test
    void queryApplication()
    {
    }

    /**
     * Page application by conditions.
     */
    @Test
    void pageApplicationByConditions()
    {
    }

    /**
     * Load resources.
     */
    @Test
    void loadResources()
    {
    }

    /**
     * Test load resources.
     */
    @Test
    void testLoadResources()
    {
    }

    /**
     * Query menu.
     */
    @Test
    void queryMenu()
    {
        R<MenuDTO> r = resourceFeignClientV2.queryMenu(1L);
        System.out.println(r.getData());
    }

    /**
     * Query menu by application code.
     */
    @Test
    void queryMenuByApplicationCode()
    {
    }

    /**
     * Test query menu.
     */
    @Test
    void testQueryMenu()
    {
    }

    /**
     * Query menu by privileges.
     */
    @Test
    void queryMenuByPrivileges()
    {
    }
}
