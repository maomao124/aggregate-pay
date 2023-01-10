package mao.aggregate_pay_sms.generator;

/**
 * 认证码生成器
 */
public interface VerificationCodeGenerator
{

    /**
     * 认证码生成
     *
     * @return {@link String}
     */
    String generate();

}
