package mao.aggregate_pay_sms.generator;

import java.util.Random;

public class NumberVerificationCodeGenerator implements VerificationCodeGenerator
{


    /**
     * 数字验证代码生成器
     *
     * @param len len
     */
    public NumberVerificationCodeGenerator(int len)
    {
        this.len = len;
    }

    /**
     * len
     */
    private int len;

    /**
     * 生成
     *
     * @return {@link String}
     */
    @Override
    public String generate()
    {
        return getNumRandom(len);
    }

    /**
     * 得到num随机
     *
     * @param length 长度
     * @return {@link String}
     */
    private String getNumRandom(int length)
    {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++)
        {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

}
