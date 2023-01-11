package mao.aggregate_pay_common.utils;

import com.qiniu.util.IOUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(测试类名): QiniuUtilsTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 21:17
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class QiniuUtilsTest
{

    @SneakyThrows
    @Test
    void upload2qiniu()
    {
        String accessKey = "iCXS8pn-PiJ77RYpkFd9UH5alX9b_0oiB......";
        String SecretKey = "w65H_JovJdjWpTQwYcFw63OCIVIS_o6......";
        String bucket = "......";
        String fileName = "image-20230110151739681.png";
        String filePath = "C:\\Users\\mao\\Desktop\\image-20230110151739681.png";
        byte[] bytes = IOUtils.toByteArray(new FileInputStream(filePath));
        QiniuUtils.upload2qiniu(accessKey, SecretKey, bucket, bytes, fileName);
    }

}
