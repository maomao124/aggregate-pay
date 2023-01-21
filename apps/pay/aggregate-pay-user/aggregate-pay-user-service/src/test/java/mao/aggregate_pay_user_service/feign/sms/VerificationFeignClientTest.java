package mao.aggregate_pay_user_service.feign.sms;

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
 * Package(包名): mao.aggregate_pay_user_service.feign.sms
 * Class(测试类名): VerificationFeignClientTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/20
 * Time(创建时间)： 21:47
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
        Map<String, Object> params = new HashMap<>();
        params.put("mobile", "18845778562");
        RestResponse<VerificationInfo> response = verificationFeignClient.generateVerificationInfo("sms", params, 600);
        System.out.println(response.getResult().getKey());
    }

    @Test
    void verify()
    {
    }
}
