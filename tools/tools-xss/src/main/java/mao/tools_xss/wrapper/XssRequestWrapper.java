package mao.tools_xss.wrapper;

import mao.tools_xss.utils.XssUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：AntiSamy_spring_boot_starter_demo
 * Package(包名): mao.tools_xss.wrapper
 * Class(类名): XssRequestWrapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/30
 * Time(创建时间)： 20:01
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class XssRequestWrapper extends HttpServletRequestWrapper
{

    private static final Logger log = LoggerFactory.getLogger(XssRequestWrapper.class);

    /**
     * 忽略参数值列表
     */
    private final List<String> ignoreParamValueList;

    public XssRequestWrapper(HttpServletRequest request, List<String> ignoreParamValueList)
    {
        super(request);
        this.ignoreParamValueList = ignoreParamValueList;
    }

    @Override
    public Map<String, String[]> getParameterMap()
    {
        Map<String, String[]> requestMap = super.getParameterMap();
        for (Map.Entry<String, String[]> me : requestMap.entrySet())
        {
            log.debug(me.getKey() + ":");
            String[] values = me.getValue();
            for (int i = 0; i < values.length; i++)
            {
                log.debug(values[i]);
                values[i] = XssUtils.xssClean(values[i], this.ignoreParamValueList);
            }
        }
        return requestMap;
    }

    @Override
    public String[] getParameterValues(String paramString)
    {
        String[] arrayOfString1 = super.getParameterValues(paramString);
        if (arrayOfString1 == null)
        {
            return null;
        }
        int i = arrayOfString1.length;
        String[] arrayOfString2 = new String[i];
        for (int j = 0; j < i; j++)
        {
            arrayOfString2[j] = XssUtils.xssClean(arrayOfString1[j], this.ignoreParamValueList);
        }
        return arrayOfString2;
    }

    @Override
    public String getParameter(String paramString)
    {
        String str = super.getParameter(paramString);
        if (str == null)
        {
            return null;
        }
        return XssUtils.xssClean(str, this.ignoreParamValueList);
    }

    @Override
    public String getHeader(String paramString)
    {
        String str = super.getHeader(paramString);
        if (str == null)
        {
            return null;
        }
        return XssUtils.xssClean(str, this.ignoreParamValueList);
    }
}
