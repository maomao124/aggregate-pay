package mao.tools_xss.filter;

import com.alibaba.fastjson.JSON;
import mao.tools_xss.wrapper.XssRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project name(项目名称)：AntiSamy_spring_boot_starter_demo
 * Package(包名): mao.tools_xss.filter
 * Class(类名): XssFilter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/30
 * Time(创建时间)： 20:18
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class XssFilter implements Filter
{

    private static final Logger log = LoggerFactory.getLogger(XssFilter.class);

    /**
     * 可放行的请求路径
     */
    private static final String IGNORE_PATH = "ignorePath";
    /**
     * 可放行的参数值
     */
    private static final String IGNORE_PARAM_VALUE = "ignoreParamValue";
    /**
     * 默认放行单点登录的登出响应(响应中包含samlp:LogoutRequest标签，直接放行)
     */
    private static final String CAS_LOGOUT_RESPONSE_TAG = "samlp:LogoutRequest";
    /**
     * 可放行的请求路径列表
     */
    private List<String> ignorePathList;
    /**
     * 可放行的参数值列表
     */
    private List<String> ignoreParamValueList;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        log.debug("XSS fiter [XSSFilter] init start ...");
        String ignorePaths = filterConfig.getInitParameter(IGNORE_PATH);
        String ignoreParamValues = filterConfig.getInitParameter(IGNORE_PARAM_VALUE);
        if (!(ignorePaths == null || ignorePaths.equals("")))
        {
            String[] ignorePathArr = ignorePaths.split(",");
            ignorePathList = Arrays.asList(ignorePathArr);
        }
        if (!(ignoreParamValues == null || ignoreParamValues.equals("")))
        {
            String[] ignoreParamValueArr = ignoreParamValues.split(",");
            ignoreParamValueList = Arrays.asList(ignoreParamValueArr);
            //默认放行单点登录的登出响应(响应中包含samlp:LogoutRequest标签，直接放行)
            if (!ignoreParamValueList.contains(CAS_LOGOUT_RESPONSE_TAG))
            {
                ignoreParamValueList.add(CAS_LOGOUT_RESPONSE_TAG);
            }
        }
        else
        {
            //默认放行单点登录的登出响应(响应中包含samlp:LogoutRequest标签，直接放行)
            ignoreParamValueList = new ArrayList<>();
            ignoreParamValueList.add(CAS_LOGOUT_RESPONSE_TAG);
        }
        log.debug("ignorePathList=" + JSON.toJSONString(ignorePathList));
        log.debug("ignoreParamValueList=" + JSON.toJSONString(ignoreParamValueList));
        log.debug("XSS fiter [XSSFilter] init end");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        log.debug("XSS fiter [XSSFilter] starting");
        // 判断uri是否包含项目名称
        String uriPath = ((HttpServletRequest) request).getRequestURI();
        if (isIgnorePath(uriPath))
        {
            log.debug("ignore xssfilter,path[" + uriPath + "] pass through XssFilter, go ahead...");
            chain.doFilter(request, response);
            return;
        }
        else
        {
            log.debug("has xssfiter path[" + uriPath + "] need XssFilter, go to XssRequestWrapper");
            //传入重写后的Request
            chain.doFilter(new XssRequestWrapper((HttpServletRequest) request, ignoreParamValueList), response);
        }
        log.debug("XSS fiter [XSSFilter] stop");
    }

    @Override
    public void destroy()
    {
        log.debug("XSS fiter [XSSFilter] destroy");
    }

    /**
     * 是否为忽略的请求路径
     *
     * @param servletPath servlet路径
     * @return boolean
     */
    private boolean isIgnorePath(String servletPath)
    {
        if (servletPath == null || servletPath.equals(""))
        {
            return true;
        }
        if (ignorePathList == null || ignorePathList.size() == 0)
        {
            return false;
        }
        else
        {
            for (String ignorePath : ignorePathList)
            {
                if (!(ignorePath == null || ignorePath.equals("")) && servletPath.contains(ignorePath.trim()))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
