package mao.aggregate_pay_common.utils;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(测试类名): PaymentUtilTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 21:06
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class PaymentUtilTest
{

    @Test
    void checkPayOrderAttach()
    {
        System.out.println(PaymentUtil.checkPayOrderAttach("SJ1611711501470044160"));
    }

    @SneakyThrows
    @Test
    void genUniquePayOrderNo()
    {
        System.out.println(PaymentUtil.genUniquePayOrderNo());
        System.out.println(PaymentUtil.genUniquePayOrderNo());
        System.out.println(PaymentUtil.genUniquePayOrderNo());
        System.out.println(PaymentUtil.genUniquePayOrderNo());
        System.out.println(PaymentUtil.genUniquePayOrderNo());
        System.out.println(PaymentUtil.genUniquePayOrderNo());
        Thread.sleep(200);
        System.out.println(PaymentUtil.genUniquePayOrderNo());
        System.out.println(PaymentUtil.genUniquePayOrderNo());
        System.out.println(PaymentUtil.genUniquePayOrderNo());
        System.out.println(PaymentUtil.genUniquePayOrderNo());
        System.out.println(PaymentUtil.genUniquePayOrderNo());
    }

    @SneakyThrows
    @Test
    void workId()
    {
        System.out.println(PaymentUtil.WorkId());
        System.out.println(PaymentUtil.WorkId());
        Thread.sleep(200);
        System.out.println(PaymentUtil.WorkId());
        System.out.println(PaymentUtil.WorkId());
        System.out.println(PaymentUtil.WorkId());
    }
}
