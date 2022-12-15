package mao.auth_server.Captcha;

import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.Captcha
 * Class(类名): EasyCaptchaChineseCaptchaTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:25
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class EasyCaptchaChineseCaptchaTest
{
    /**
     * 中文类型图片验证码
     *
     * @throws IOException         IOException
     * @throws FontFormatException 字体格式异常
     */
    @Test
    void test11() throws IOException, FontFormatException
    {
        Captcha captcha = new ChineseCaptcha(250, 100);
        captcha.out(new FileOutputStream("./captcha/test11.png"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 中文类型图片验证码,6位
     *
     * @throws IOException         IOException
     * @throws FontFormatException 字体格式异常
     */
    @Test
    void test12() throws IOException, FontFormatException
    {
        Captcha captcha = new ChineseCaptcha(250, 100, 6);
        captcha.out(new FileOutputStream("./captcha/test12.png"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 中文类型图片验证码,8位
     *
     * @throws IOException         IOException
     * @throws FontFormatException 字体格式异常
     */
    @Test
    void test13() throws IOException, FontFormatException
    {
        Captcha captcha = new ChineseCaptcha(250, 100, 8);
        captcha.out(new FileOutputStream("./captcha/test13.png"));
        String text = captcha.text();
        System.out.println(text);
    }
}
