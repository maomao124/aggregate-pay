package mao.aggregate_pay_common.utils;

import java.math.BigDecimal;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): AmountUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 14:56
 * Version(版本): 1.0
 * Description(描述)： 金额元分之间转换工具类
 */

public class AmountUtil
{
    /**
     * 金额为分的格式
     */
    public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";

    /**
     * 将分为单位的转换为元并返回金额格式的字符串 （除100）
     * 比如：100000转换为1,000.00   100转化为1.00 10转换为0.1   1转换为0.01
     *
     * @param amount 量
     * @return {@link String}
     * @throws Exception 异常
     */
    public static String changeF2Y(Long amount) throws Exception
    {
        if (!amount.toString().matches(CURRENCY_FEN_REGEX))
        {
            throw new Exception("金额格式有误");
        }

        int flag = 0;
        String amString = amount.toString();
        if (amString.charAt(0) == '-')
        {
            flag = 1;
            amString = amString.substring(1);
        }
        StringBuilder result = new StringBuilder();
        if (amString.length() == 1)
        {
            result.append("0.0").append(amString);
        }
        else if (amString.length() == 2)
        {
            result.append("0.").append(amString);
        }
        else
        {
            String intString = amString.substring(0, amString.length() - 2);
            for (int i = 1; i <= intString.length(); i++)
            {
                if ((i - 1) % 3 == 0 && i != 1)
                {
                    result.append(",");
                }
                result.append(intString.charAt(intString.length() - i));
            }
            result.reverse().append(".").append(amString.substring(amString.length() - 2));
        }
        if (flag == 1)
        {
            return "-" + result.toString();
        }
        else
        {
            return result.toString();
        }
    }

    /**
     * 将分为单位的转换为元 （除100）
     * 比如：1000000转换为10000   100最后转化为1 10转换为0.1 1转换为0.01
     *
     * @param amount 量
     * @return {@link String}
     * @throws Exception 异常
     */
    public static String changeF2Y(String amount) throws Exception
    {
        if (!amount.matches(CURRENCY_FEN_REGEX))
        {
            throw new Exception("金额格式有误");
        }
        return BigDecimal.valueOf(Long.parseLong(amount)).divide(new BigDecimal(100)).toString();
    }

    /**
     * 将元为单位的转换为分 （乘100）
     *
     * @param amount 量
     * @return {@link String}
     */
    public static String changeY2F(Long amount)
    {
        return BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).toString();
    }

    /**
     * 将元为单位的转换为分 替换小数点，支持以逗号区分的金额
     * 比如：100￥转换为10000  1转换为100  1,000.00转换为100000
     *
     * @param amount 量
     * @return {@link String}
     */
    public static String changeY2F(String amount)
    {
        String currency = amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额
        int index = currency.indexOf(".");
        int length = currency.length();
        Long amLong = 0l;
        if (index == -1)
        {
            amLong = Long.valueOf(currency + "00");
        }
        else if (length - index >= 3)
        {
            amLong = Long.valueOf((currency.substring(0, index + 3)).replace(".", ""));
        }
        else if (length - index == 2)
        {
            amLong = Long.valueOf((currency.substring(0, index + 2)).replace(".", "") + 0);
        }
        else
        {
            amLong = Long.valueOf((currency.substring(0, index + 1)).replace(".", "") + "00");
        }
        return amLong.toString();
    }
}
