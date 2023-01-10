package mao.aggregate_pay_merchant_application.service;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.service
 * Interface(接口名): SmsService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/10
 * Time(创建时间)： 21:34
 * Version(版本): 1.0
 * Description(描述)： 验证码服务
 */

public interface SmsService
{
    /**
     * 校验验证码，校验失败，抛出异常
     *
     * @param verifyKey  验证码的key
     * @param verifyCode 验证码
     */
    void checkVerifyCode(String verifyKey, String verifyCode);
}
