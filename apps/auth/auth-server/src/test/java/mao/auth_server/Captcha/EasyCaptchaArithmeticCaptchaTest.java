package mao.auth_server.Captcha;

import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.base.Captcha;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.Captcha
 * Class(类名): EasyCaptchaArithmeticCaptchaTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 13:19
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class EasyCaptchaArithmeticCaptchaTest
{
    /**
     * 算术类型图片验证码,字母数字混合
     */
    @Test
    void test1() throws FileNotFoundException
    {
        Captcha captcha = new ArithmeticCaptcha(120, 50);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(1);
        captcha.out(new FileOutputStream("./captcha/test1.png"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 算术类型图片验证码,纯数字
     */
    @Test
    void test2() throws FileNotFoundException
    {
        Captcha captcha = new ArithmeticCaptcha(120, 50);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(2);
        captcha.out(new FileOutputStream("./captcha/test2.png"));
        String text = captcha.text();
        System.out.println(text);
    }

}
