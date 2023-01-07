package mao.aggregate_pay_common.utils;

import java.util.Random;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): RandomStringUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 21:25
 * Version(版本): 1.0
 * Description(描述)： 随机字符串工具类
 */

public class RandomStringUtil
{
    /**
     * 获取指定长度随机字符串
     *
     * @param length 长度
     * @return {@link String}
     */
    public static String getRandomString(int length)
    {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++)
        {
            int number = random.nextInt(3);
            long result = 0;
            switch (number)
            {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }

}
