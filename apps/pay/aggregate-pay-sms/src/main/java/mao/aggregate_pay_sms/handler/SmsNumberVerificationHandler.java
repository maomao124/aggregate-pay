package mao.aggregate_pay_sms.handler;


import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_sms.generator.NumberVerificationCodeGenerator;
import mao.aggregate_pay_sms.generator.UUIDVerificationKeyGenerator;
import mao.aggregate_pay_sms.generator.VerificationCodeGenerator;
import mao.aggregate_pay_sms.generator.VerificationKeyGenerator;
import mao.aggregate_pay_sms.sms.SmsService;
import mao.aggregate_pay_sms.store.VerificationStore;

import java.util.Map;

/**
 * 短信(数字随机验证码)处理器
 */
@Slf4j
public class SmsNumberVerificationHandler extends AbstractVerificationHandler
{

    /**
     * 名字
     */
    private String name;

    /**
     * len
     */
    private int len;

    /**
     * 验证存储
     */
    private VerificationStore verificationStore;

    /**
     * 确认键生成器
     */
    private VerificationKeyGenerator verificationKeyGenerator;

    /**
     * 验证代码生成器
     */
    private VerificationCodeGenerator verificationCodeGenerator;

    /**
     * 短信服务
     */
    private SmsService smsService;

    /**
     * 短信验证处理器数量
     *
     * @param name 名字
     * @param len  len
     */
    public SmsNumberVerificationHandler(String name, int len)
    {
        this.name = name;
        this.len = len;
        verificationKeyGenerator = new UUIDVerificationKeyGenerator();
        verificationCodeGenerator = new NumberVerificationCodeGenerator(len);
    }


    /**
     * 得到名字
     *
     * @return {@link String}
     */
    @Override
    public String getName()
    {
        return name;
    }

    /**
     * 得到验证存储
     *
     * @return {@link VerificationStore}
     */
    @Override
    public VerificationStore getVerificationStore()
    {
        return verificationStore;
    }

    /**
     * 设置验证存储
     *
     * @param verificationStore 验证存储
     */
    public void setVerificationStore(VerificationStore verificationStore)
    {
        this.verificationStore = verificationStore;
    }

    /**
     * 得到验证键生成器
     *
     * @return {@link VerificationKeyGenerator}
     */
    @Override
    public VerificationKeyGenerator getVerificationKeyGenerator()
    {
        return verificationKeyGenerator;
    }

    /**
     * 得到验证代码生成器
     *
     * @return {@link VerificationCodeGenerator}
     */
    @Override
    public VerificationCodeGenerator getVerificationCodeGenerator()
    {
        return verificationCodeGenerator;
    }

    /**
     * 得到有效时间
     *
     * @return int
     */
    @Override
    public int getEffectiveTime()
    {
        return 300;
    }

    /**
     * 设置短信服务
     *
     * @param smsService 短信服务
     */
    public void setSmsService(SmsService smsService)
    {
        this.smsService = smsService;
    }

    /**
     * 混乱
     *
     * @param payload 有效载荷
     * @param key     关键
     * @param code    代码
     * @return {@link String}
     */
    @Override
    String confusion(Map<String, Object> payload, String key, String code)
    {
        String mobile = String.valueOf(payload.get("mobile"));

        // 使用腾讯云发送短信
        smsService.send(mobile, code, getEffectiveTime());

        // 测试使用，在控制台输出验证码
//		smsService.sendOnConsole(mobile, code, getEffectiveTime());
        return null;
    }


}
