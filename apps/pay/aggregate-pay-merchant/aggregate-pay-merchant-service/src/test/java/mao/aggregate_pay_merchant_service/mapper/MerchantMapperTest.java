package mao.aggregate_pay_merchant_service.mapper;

import mao.aggregate_pay_merchant_service.entity.Merchant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.mapper
 * Class(测试类名): MerchantMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 14:50
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class MerchantMapperTest
{

    @Autowired
    private MerchantMapper merchantMapper;

    @Test
    void list()
    {
        List<Merchant> merchantList = merchantMapper.selectList(null);
        System.out.println(merchantList);
    }
}
