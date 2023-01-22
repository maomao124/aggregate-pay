package mao.aggregate_pay_gateway.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import mao.aggregate_pay_common.utils.EncryptUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_gateway.filter
 * Class(类名): AuthFilter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/22
 * Time(创建时间)： 22:40
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class AuthFilter extends ZuulFilter
{
    @Override
    public boolean shouldFilter()
    {
        return true;
    }

    @Override
    public String filterType()
    {
        return "pre";
    }

    @Override
    public int filterOrder()
    {
        return 0;
    }

    @Override
    public Object run() throws ZuulException
    {
        RequestContext currentContext = RequestContext.getCurrentContext();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof OAuth2Authentication))
        {
            // 无token访问网关内资源的情况，目前仅有uaa服务直接暴露
            return null;
        }

        OAuth2Authentication oauth2Authentication = (OAuth2Authentication) authentication;
        Authentication userAuthentication = oauth2Authentication.getUserAuthentication();

        Map<String, String> jsonToken = new HashMap<>(
                oauth2Authentication.getOAuth2Request().getRequestParameters());
        if (userAuthentication != null)
        {
            jsonToken.put("user_name", userAuthentication.getName());
        }
        currentContext.addZuulRequestHeader("jsonToken", EncryptUtil.encodeUTF8StringBase64(JSON.toJSONString(jsonToken)));
        return null;
    }
}
