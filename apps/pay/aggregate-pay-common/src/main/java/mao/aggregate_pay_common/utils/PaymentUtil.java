package mao.aggregate_pay_common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): PaymentUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 21:05
 * Version(版本): 1.0
 * Description(描述)： Payment
 */

public class PaymentUtil
{
    private static final Pattern pattern = Pattern.compile("SJPAY(,\\S+){4}");
    private static final String SHANJUPAY_PREFIX = "SJ";

    /**
     * 查看支付订单附加
     *
     * @param attach 附加
     * @return boolean
     */
    public static boolean checkPayOrderAttach(String attach)
    {
        if (StringUtils.isBlank(attach))
        {
            return false;
        }
        return pattern.matcher(attach).matches();
    }

    /**
     * 创独特支付订单号
     *
     * @return {@link String}
     */
    public static String genUniquePayOrderNo()
    {
        return SHANJUPAY_PREFIX + WorkId();
    }

    /**
     * 工作id
     *
     * @return {@link String}
     */
    public static String WorkId()
    {
        long id = IdWorkerUtils.getInstance().nextId();
        return String.valueOf(id);
    }
}
