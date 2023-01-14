package mao.aggregate_pay_merchant_application.feign.sms;

import mao.aggregate_pay_common.domain.RestResponse;
import mao.aggregate_pay_entity.dto.VerificationInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.feign.sms
 * Class(测试类名): VerificationFeignClientTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/10
 * Time(创建时间)： 20:27
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class VerificationFeignClientTest
{
    @Autowired
    private VerificationFeignClient verificationFeignClient;

    @Test
    void generateVerificationInfo()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("mobile", "18166887788");
        RestResponse<VerificationInfo> response = verificationFeignClient.generateVerificationInfo("sms", map, 600);
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        VerificationInfo verificationInfo = response.getResult();
        System.out.println(verificationInfo.getContent());
        System.out.println(verificationInfo.getKey());
    }

    @Test
    void verify()
    {
        RestResponse<Boolean> response = verificationFeignClient.verify("sms", "sms:cfe3e1fdf1b348cf986a2d612bcae497", "941665");
        System.out.println(response.getResult());
    }
}
