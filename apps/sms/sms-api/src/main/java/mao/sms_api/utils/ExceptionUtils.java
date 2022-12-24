package mao.sms_api.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.utils
 * Class(类名): ExceptionUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 14:29
 * Version(版本): 1.0
 * Description(描述)： 异常工具类
 */

public class ExceptionUtils
{
    /**
     * 获取异常信息
     *
     * @param ex {@link Exception}
     * @return {@link String}
     */
    public static String getErrorStackTrace(Exception ex)
    {
        if (ex == null)
        {
            return null;
        }
        StringWriter stringWriter = null;
        PrintWriter printWriter = null;
        try
        {
            stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter, true);
            ex.printStackTrace(printWriter);
        }
        finally
        {
            try
            {
                if (printWriter != null)
                {
                    printWriter.close();
                }
            }
            catch (Exception ignored)
            {

            }
            try
            {
                if (stringWriter != null)
                {
                    stringWriter.close();
                }
            }
            catch (IOException ignored)
            {

            }
        }
        return stringWriter.toString();
    }
}
