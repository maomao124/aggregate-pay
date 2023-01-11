package mao.aggregate_pay_merchant_application.service.Impl;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.RestResponse;
import mao.aggregate_pay_merchant_application.feign.sms.VerificationFeignClient;
import mao.aggregate_pay_merchant_application.service.SmsService;
import mao.tools_core.exception.BizException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.service.Impl
 * Class(类名): SmsServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/10
 * Time(创建时间)： 21:34
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class SmsServiceImpl implements SmsService
{
    @Resource
    private VerificationFeignClient verificationFeignClient;

    @Override
    public void checkVerifyCode(String verifyKey, String verifyCode)
    {
        try
        {
            //发起远程调用
            RestResponse<Boolean> response = verificationFeignClient.verify("sms", verifyKey, verifyCode);
            //判断结果
            if (!response.getResult())
            {
                //失败
                throw new BizException("验证码错误或者验证码已过期");
            }
        }
        catch (Exception e)
        {
            log.error("验证码服务异常：", e);
            throw new BizException("验证码错误或者验证码已过期");
        }

    }
}
