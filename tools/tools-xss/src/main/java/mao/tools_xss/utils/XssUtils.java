package mao.tools_xss.utils;


import org.owasp.validator.html.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Project name(项目名称)：AntiSamy_spring_boot_starter_demo
 * Package(包名): mao.tools_xss.utils
 * Class(类名): XssUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/30
 * Time(创建时间)： 20:03
 * Version(版本): 1.0
 * Description(描述)： XSS 工具类， 用于过滤特殊字符
 */

public class XssUtils
{
    private static final Logger log = LoggerFactory.getLogger(XssUtils.class);

    private static final String ANTISAMY_SLASHDOT_XML = "antisamy-slashdot-1.4.4.xml";
    private static Policy policy = null;

    static
    {
        log.debug(" start read XSS configfile [" + ANTISAMY_SLASHDOT_XML + "]");
        InputStream inputStream = XssUtils.class.getClassLoader().getResourceAsStream(ANTISAMY_SLASHDOT_XML);
        try
        {
            policy = Policy.getInstance(inputStream);
            log.debug("read XSS configfile [" + ANTISAMY_SLASHDOT_XML + "] success");
        }
        catch (PolicyException e)
        {
            log.error("read XSS configfile [" + ANTISAMY_SLASHDOT_XML + "] fail , reason:", e);
        }
        finally
        {
            if (inputStream != null)
            {
                try
                {
                    inputStream.close();
                }
                catch (IOException e)
                {
                    log.error("close XSS configfile [" + ANTISAMY_SLASHDOT_XML + "] fail , reason:", e);
                }
            }
        }
    }

    /**
     * 跨站攻击语句过滤 方法
     *
     * @param paramValue           待过滤的参数
     * @param ignoreParamValueList 忽略过滤的参数列表
     * @return String
     */
    public static String xssClean(String paramValue, List<String> ignoreParamValueList)
    {
        AntiSamy antiSamy = new AntiSamy();
        try
        {
            log.debug("raw value before xssClean: " + paramValue);
            if (isIgnoreParamValue(paramValue, ignoreParamValueList))
            {
                log.debug("ignore the xssClean,keep the raw paramValue: " + paramValue);
                return paramValue;
            }
            else
            {
                final CleanResults cleanResults = antiSamy.scan(paramValue, policy);
                cleanResults.getErrorMessages().forEach(log::debug);
                String str = cleanResults.getCleanHTML();
                /*String str = StringEscapeUtils.escapeHtml(cleanResults.getCleanHTML());
                str = str.replaceAll((antiSamy.scan("&nbsp;", policy)).getCleanHTML(), "");
                str = StringEscapeUtils.unescapeHtml(str);*/
                /*str = str.replaceAll("&quot;", "\"");
                str = str.replaceAll("&amp;", "&");
                str = str.replaceAll("'", "'");
                str = str.replaceAll("'", "＇");

                str = str.replaceAll("&lt;", "<");
                str = str.replaceAll("&gt;", ">");*/
                log.debug("xssfilter value after xssClean: " + str);

                return str;
            }
        }
        catch (ScanException e)
        {
            log.error("scan failed armter is [" + paramValue + "]", e);
        }
        catch (PolicyException e)
        {
            log.error("antisamy convert failed  armter is [" + paramValue + "]", e);
        }
        return paramValue;
    }

    /**
     * 忽略参数值
     *
     * @param paramValue           参数值
     * @param ignoreParamValueList 忽略参数值列表
     * @return boolean
     */
    private static boolean isIgnoreParamValue(String paramValue, List<String> ignoreParamValueList)
    {
        if (paramValue == null || paramValue.equals(""))
        {
            return true;
        }
        if (ignoreParamValueList == null || ignoreParamValueList.size() == 0)
        {
            return false;
        }
        else
        {
            for (String ignoreParamValue : ignoreParamValueList)
            {
                if (paramValue.contains(ignoreParamValue))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
