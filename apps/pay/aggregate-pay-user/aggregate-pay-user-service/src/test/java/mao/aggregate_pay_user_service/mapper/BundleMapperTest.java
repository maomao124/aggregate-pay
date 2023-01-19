package mao.aggregate_pay_user_service.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Class(测试类名): BundleMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 18:24
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


@Transactional
@SpringBootTest
class BundleMapperTest
{
    @Autowired
    private BundleMapper bundleMapper;

    /**
     * List.
     */
    @Test
    void list()
    {
        System.out.println(bundleMapper.selectList(null));
    }

    /**
     * Select bundle by code.
     */
    @Test
    void selectBundleByCode()
    {
        System.out.println(bundleMapper.selectBundleByCode("admin"));
    }
}
