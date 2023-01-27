package mao.aggregate_pay_common.utils;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(测试类名): QRCodeUtilTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 21:21
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class QRCodeUtilTest
{

    @SneakyThrows
    @Test
    void createQRCode()
    {
        QRCodeUtil qrCodeUtil = new QRCodeUtil();
        System.out.println(qrCodeUtil.createQRCode("https://fanyi.baidu.com/", 200, 200));
    }

    @SneakyThrows
    @Test
    void createQRCode2()
    {
        QRCodeUtil qrCodeUtil = new QRCodeUtil();
        System.out.println(qrCodeUtil.createQRCode("https://www.bilibili.com/", 200, 200));
    }

    @SneakyThrows
    @Test
    void createQRCode3()
    {
        QRCodeUtil qrCodeUtil = new QRCodeUtil();
        System.out.println(qrCodeUtil.createQRCode("http://192.168.3.143:49827/alipay/test2?out_trade_no=188888888", 200, 200));
    }
}
