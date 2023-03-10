package mao.aggregate_pay_sms.generator;

import java.util.UUID;

public class UUIDVerificationKeyGenerator implements VerificationKeyGenerator
{
    /**
     * įæ
     *
     * @param prefix åįž
     * @return {@link String}
     */
    @Override
    public String generate(String prefix)
    {
        String uuid = UUID.randomUUID().toString();
        return prefix + uuid.replaceAll("-", "");
    }
}
