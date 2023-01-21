package mao.aggregate_pay_uaa_service.feign;

import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.feign.ResourceFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.feign
 * Class(测试类名): ResourceFeignClientTest
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
class ResourceFeignClientTest
{
    @Autowired
    private ResourceFeignClient resourceFeignClient;

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
        ApplicationDTO applicationDTO = resourceFeignClient.queryApplication("1");
        System.out.println(applicationDTO);
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
