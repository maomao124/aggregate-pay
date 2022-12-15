package mao.tools_core.base.id;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.base.id
 * Class(类名): SnowflakeIdGenerate
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 13:49
 * Version(版本): 1.0
 * Description(描述)：
 * <p>
 * 1bit 		+ 41bit 		+ 17bit 		+ 5bit
 * |			    |				|				|
 * |				|				|				|
 * 符合位     	        时间戳（毫秒）		     序列号			      机器码
 * 第1bit固定是0  符号位不动 。
 * 第2bit到第42bit使用时间蹉，精确到毫秒  41bit。 使用年限是69年
 * 第43bit到第59bit使用自增的序列号       17bit  可用序列号最大131071个，说明一毫秒我们可以生成131071个不同的序列号。
 * 第60bit到第64bit使用机器码	5bit   可以使系统可以分布式，最大分布式数量是32台机子。
 */

public class SnowflakeIdGenerate extends AbstractIdGenerate<Long>
{
    /**
     * 构造方法
     *
     * @param machineCode 机器代码
     */
    public SnowflakeIdGenerate(final long machineCode)
    {
        super(machineCode);
    }

    @Override
    public Long generate()
    {
        return super.generateLong();
    }
}
