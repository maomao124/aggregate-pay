package mao.aggregate_pay_sms.generator;

import java.util.UUID;

public class UUIDVerificationKeyGenerator implements VerificationKeyGenerator
{
    /**
     * 生成
     *
     * @param prefix 前缀
     * @return {@link String}
     */
    @Override
    public String generate(String prefix)
    {
        String uuid = UUID.randomUUID().toString();
        return prefix + uuid.replaceAll("-", "");
    }
}
