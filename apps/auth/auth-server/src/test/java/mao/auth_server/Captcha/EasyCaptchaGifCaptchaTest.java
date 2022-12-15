package mao.auth_server.Captcha;

import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.base.Captcha;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.Captcha
 * Class(类名): EasyCaptchaGifCaptchaTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 13:30
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class EasyCaptchaGifCaptchaTest
{
    /**
     * gif类型图片验证码
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test3() throws IOException, FontFormatException
    {
        Captcha captcha = new GifCaptcha(120, 50);
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
        //captcha.setFont(1);
        captcha.out(new FileOutputStream("./captcha/test3.gif"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * gif类型图片验证码,纯数字
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test4() throws IOException, FontFormatException
    {
        Captcha captcha = new GifCaptcha(300, 150);
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
        captcha.out(new FileOutputStream("./captcha/test4.gif"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * gif类型图片验证码,纯字母
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test5() throws IOException, FontFormatException
    {
        Captcha captcha = new GifCaptcha(300, 150);
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
        captcha.out(new FileOutputStream("./captcha/test5.gif"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * gif类型图片验证码,纯大写字母
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test6() throws IOException, FontFormatException
    {
        Captcha captcha = new GifCaptcha(300, 150);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(4);
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
        captcha.out(new FileOutputStream("./captcha/test6.gif"));
        String text = captcha.text();
        System.out.println(text);
    }


}
