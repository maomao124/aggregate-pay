package mao.aggregate_pay_transaction_service.service.impl;

import mao.aggregate_pay_transaction_api.dto.PayChannelParamDTO;
import mao.aggregate_pay_transaction_service.service.PayChannelParamService;
import mao.tools_core.base.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service.impl
 * Class(测试类名): PayChannelParamServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/17
 * Time(创建时间)： 14:07
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class PayChannelParamServiceImplTest
{

    @Autowired
    private PayChannelParamService payChannelParamService;

    @Test
    void queryPayChannelParamByAppAndPlatform()
    {
        R<List<PayChannelParamDTO>> aggregate_pay_c2b =
                payChannelParamService.queryPayChannelParamByAppAndPlatform("7a6e88fba94742069ef3bc40ee70ef18",
                        "aggregate_pay_c2b");
        System.out.println(aggregate_pay_c2b.getData());
    }

    @Test
    void queryPayChannelParamByAppAndPlatform2()
    {
        R<List<PayChannelParamDTO>> aggregate_pay_c2b =
                payChannelParamService.queryPayChannelParamByAppAndPlatform("7a6e88fba94742069ef3bc40ee70ef18",
                        "aggregate_pay_c2b");
        System.out.println(aggregate_pay_c2b.getData());
    }

    @Test
    void queryParamByAppPlatformAndPayChannel()
    {
        R<PayChannelParamDTO> aggregate_pay_c2b =
                payChannelParamService.queryParamByAppPlatformAndPayChannel("7a6e88fba94742069ef3bc40ee70ef18",
                        "aggregate_pay_c2b", "32");
        System.out.println(aggregate_pay_c2b.getData());
    }

    @Test
    void queryParamByAppPlatformAndPayChannel2()
    {
        R<PayChannelParamDTO> aggregate_pay_c2b =
                payChannelParamService.queryParamByAppPlatformAndPayChannel("7a6e88fba94742069ef3bc40ee70ef18",
                        "aggregate_pay_c2b", "32");
        System.out.println(aggregate_pay_c2b.getData());
    }
}
