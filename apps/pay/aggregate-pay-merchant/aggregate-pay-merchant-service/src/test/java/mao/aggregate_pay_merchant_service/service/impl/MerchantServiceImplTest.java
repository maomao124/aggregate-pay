package mao.aggregate_pay_merchant_service.service.impl;

import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_service.service.MerchantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.service.impl
 * Class(测试类名): MerchantServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 15:41
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Transactional
@SpringBootTest
class MerchantServiceImplTest
{

    @Autowired
    private MerchantService merchantService;

    @Test
    void getMerchantById()
    {
        MerchantDTO merchantDTO = merchantService.getMerchantById(1L);
        System.out.println(merchantDTO);
    }
}
