package mao.auth_server.Captcha;

import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.ChineseGifCaptcha;
import com.wf.captcha.base.Captcha;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.Captcha
 * Class(类名): EasyCaptchaChineseGifCaptchaTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:35
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class EasyCaptchaChineseGifCaptchaTest
{
    /**
     * 中文类型gif图片验证码
     *
     * @throws IOException         IOException
     * @throws FontFormatException 字体格式异常
     */
    @Test
    void test14() throws IOException, FontFormatException
    {
        Captcha captcha = new ChineseGifCaptcha(250, 100);
        captcha.out(new FileOutputStream("./captcha/test14.gif"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 中文类型gif图片验证码,8位
     *
     * @throws IOException         IOException
     * @throws FontFormatException 字体格式异常
     */
    @Test
    void test15() throws IOException, FontFormatException
    {
        Captcha captcha = new ChineseGifCaptcha(250, 100, 8);
        captcha.out(new FileOutputStream("./captcha/test15.gif"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 中文类型gif图片验证码,32位
     *
     * @throws IOException         IOException
     * @throws FontFormatException 字体格式异常
     */
    @Test
    void test16() throws IOException, FontFormatException
    {
        Captcha captcha = new ChineseGifCaptcha(900, 100, 32);
        captcha.out(new FileOutputStream("./captcha/test16.gif"));
        String text = captcha.text();
        System.out.println(text);
    }
}
