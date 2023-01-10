package mao.aggregate_pay_sms.generator;

/**
 * 验证key生成器
 */
public interface VerificationKeyGenerator
{
    /**
     * 生成
     *
     * @param prefix 前缀
     * @return {@link String}
     */
    String generate(String prefix);
}
