package mao.aggregate_pay_merchant_application.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_api.feign.MerchantFeignClient;
import mao.aggregate_pay_merchant_application.feign.sms.VerificationFeignClient;
import mao.aggregate_pay_merchant_application.service.SmsService;
import mao.aggregate_pay_merchant_application.vo.MerchantRegisterVO;
import mao.tools_core.exception.BizException;
import org.springframework.web.bind.annotation.*;

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
 * Time(创建时间)： 21:49
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

    @Resource
    private SmsService smsService;

    @Resource
    private MerchantFeignClient merchantFeignClient;

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

    /**
     * 注册商户
     *
     * @param merchantRegisterVO MerchantRegisterVO
     * @return {@link MerchantRegisterVO}
     */
    @PostMapping("/merchants/register")
    @ApiOperation("商户注册")
    @ApiImplicitParam(value = "商户注册信息", name = "merchantRegisterVO", required = true, dataType = "MerchantRegisterVO", paramType = "body")
    public MerchantRegisterVO registerMerchant(@RequestBody MerchantRegisterVO merchantRegisterVO)
    {
        if (merchantRegisterVO.getMobile() == null || merchantRegisterVO.getMobile().equals(""))
        {
            throw new RuntimeException("请输入手机号");
        }
        if (merchantRegisterVO.getVerifiykey() == null || merchantRegisterVO.getVerifiykey().equals(""))
        {
            throw new RuntimeException("验证码的key为空");
        }
        if (merchantRegisterVO.getVerifiyCode() == null || merchantRegisterVO.getVerifiyCode().equals(""))
        {
            throw new RuntimeException("请输入验证码");
        }
        smsService.checkVerifyCode(merchantRegisterVO.getVerifiykey(), merchantRegisterVO.getVerifiyCode());

        //注册商户
        MerchantDTO merchantDTO = new MerchantDTO();
        merchantDTO.setUsername(merchantRegisterVO.getUsername());
        merchantDTO.setMobile(merchantRegisterVO.getMobile());
        merchantDTO.setPassword(merchantRegisterVO.getPassword());
        //远程调用
        merchantFeignClient.createMerchant(merchantDTO);
        //返回
        return merchantRegisterVO;

    }
}
