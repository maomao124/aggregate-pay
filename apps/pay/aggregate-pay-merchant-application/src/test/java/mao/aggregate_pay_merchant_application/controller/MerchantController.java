package mao.aggregate_pay_merchant_application.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_merchant_application.feign.sms.VerificationFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.controller
 * Class(类名): MerchantController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/10
 * Time(创建时间)： 20:51
 * Version(版本): 1.0
 * Description(描述)： 商户
 */

@Slf4j
@RestController
@Api(tags = "商户平台应用接口")
public class MerchantController
{

    @Resource
    private VerificationFeignClient verificationFeignClient;

    /**
     * 发送验证码
     *
     * @param phone 电话
     * @return {@link String} 验证码的key
     */
    @ApiOperation("获取手机验证码")
    @GetMapping("/sms")
    @ApiImplicitParam(value = "手机号", name = "phone", required = true, dataType = "string", paramType = "query")
    public String getSMSCode(@RequestParam("phone") String phone)
    {
        log.info("向手机号:{}发送验证码", phone);
        //向验证码服务请求发送验证码
        Map<String, Object> map = new HashMap<>();
        map.put("mobile", phone);
        return verificationFeignClient.generateVerificationInfo("sms", map, 20 * 60).getResult().getKey();
    }
}
