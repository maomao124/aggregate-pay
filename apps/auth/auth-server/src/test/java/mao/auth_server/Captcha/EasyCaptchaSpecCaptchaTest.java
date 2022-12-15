package mao.auth_server.Captcha;

import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.Captcha
 * Class(类名): EasyCaptchaSpecCaptchaTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 13:43
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class EasyCaptchaSpecCaptchaTest
{
    /**
     * 图片验证码,字母数字混合
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test7() throws IOException, FontFormatException
    {
        Captcha captcha = new SpecCaptcha(200, 100);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(1);
        //public static final int FONT_1 = 0;
        //public static final int FONT_2 = 1;
        //public static final int FONT_3 = 2;
        //public static final int FONT_4 = 3;
        //public static final int FONT_5 = 4;
        //public static final int FONT_6 = 5;
        //public static final int FONT_7 = 6;
        //public static final int FONT_8 = 7;
        //public static final int FONT_9 = 8;
        //public static final int FONT_10 = 9;
        captcha.setFont(2);
        captcha.out(new FileOutputStream("./captcha/test7.gif"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 图片验证码,纯数字
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test8() throws IOException, FontFormatException
    {
        Captcha captcha = new SpecCaptcha(200, 100);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(2);
        //public static final int FONT_1 = 0;
        //public static final int FONT_2 = 1;
        //public static final int FONT_3 = 2;
        //public static final int FONT_4 = 3;
        //public static final int FONT_5 = 4;
        //public static final int FONT_6 = 5;
        //public static final int FONT_7 = 6;
        //public static final int FONT_8 = 7;
        //public static final int FONT_9 = 8;
        //public static final int FONT_10 = 9;
        captcha.setFont(2);
        captcha.out(new FileOutputStream("./captcha/test8.gif"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 图片验证码,纯字母
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test9() throws IOException, FontFormatException
    {
        Captcha captcha = new SpecCaptcha(200, 100);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(3);
        //public static final int FONT_1 = 0;
        //public static final int FONT_2 = 1;
        //public static final int FONT_3 = 2;
        //public static final int FONT_4 = 3;
        //public static final int FONT_5 = 4;
        //public static final int FONT_6 = 5;
        //public static final int FONT_7 = 6;
        //public static final int FONT_8 = 7;
        //public static final int FONT_9 = 8;
        //public static final int FONT_10 = 9;
        captcha.setFont(2);
        captcha.out(new FileOutputStream("./captcha/test9.png"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 图片验证码,纯小写字母,7位
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test10() throws IOException, FontFormatException
    {
        Captcha captcha = new SpecCaptcha(200, 100,7);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(5);
        //public static final int FONT_1 = 0;
        //public static final int FONT_2 = 1;
        //public static final int FONT_3 = 2;
        //public static final int FONT_4 = 3;
        //public static final int FONT_5 = 4;
        //public static final int FONT_6 = 5;
        //public static final int FONT_7 = 6;
        //public static final int FONT_8 = 7;
        //public static final int FONT_9 = 8;
        //public static final int FONT_10 = 9;
        captcha.setFont(2);
        captcha.out(new FileOutputStream("./captcha/test10.png"));
        String text = captcha.text();
        System.out.println(text);
    }

}
