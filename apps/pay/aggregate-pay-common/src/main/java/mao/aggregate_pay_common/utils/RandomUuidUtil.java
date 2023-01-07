package mao.aggregate_pay_common.utils;

import java.util.UUID;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): RandomUuidUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 21:28
 * Version(版本): 1.0
 * Description(描述)： 随机UUID生成工具类
 */

public class RandomUuidUtil
{
    /**
     * 得到uuid，没有横线
     *
     * @return {@link String}
     */
    public static String getUUID()
    {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.replace("-", "");
    }
}
