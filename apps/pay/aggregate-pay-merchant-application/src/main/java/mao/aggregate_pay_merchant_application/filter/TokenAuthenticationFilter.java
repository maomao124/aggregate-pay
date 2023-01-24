package mao.aggregate_pay_merchant_application.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.utils.EncryptUtil;
import mao.aggregate_pay_common.utils.StringUtil;
import mao.aggregate_pay_entity.entity.LoginUser;
import mao.aggregate_pay_merchant_application.utils.SecurityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.filter
 * Class(类名): TokenAuthenticationFilter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/23
 * Time(创建时间)： 22:28
 * Version(版本): 1.0
 * Description(描述)： token解析过滤器
 */

@Slf4j
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter
{

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain)
            throws ServletException, IOException
    {

        // 0.放行静态资源
        String requestURL = httpServletRequest.getRequestURL().toString();
        log.debug("请求的URL:{}", requestURL);
        String[] urls = {".js", ".css", ".ico", ".jpg", ".png", ".gif"};//不需要过滤的资源
        if (StringUtil.isContains(urls, requestURL)
                || requestURL.contains("/v2/api-docs")
                || requestURL.contains("/swagger-resources")
                || requestURL.contains("/swagger-ui.html")
                || requestURL.contains("/druid")
                || requestURL.contains("/doc.html")
                || requestURL.contains("/merchants/register")
                || requestURL.contains("/sms")
                || requestURL.contains("/my/tenants-merchants"))
        {

            log.debug("资源放行：" + requestURL);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // 1.校验json token
        //网关给后端微服务传的token令牌
        String jsonToken = httpServletRequest.getHeader("jsonToken");
        log.debug("jsonToken:{}", jsonToken);

        if (StringUtils.isBlank(jsonToken))
        {
            //throw new BusinessException(CommonErrorCode.E_999911);
            responseMessage(999911, "没有token令牌", httpServletRequest, httpServletResponse);
            return;
        }

        // 2.base64解码 后判断有没有当前租户的权限信息
        String json = EncryptUtil.decodeUTF8StringBase64(jsonToken);
        log.debug("json令牌:{}", json);
        Map tokenMap = JSON.parseObject(json, Map.class);
        log.debug("tokenMap:{}", JSON.toJSONString(tokenMap));

        //需注意payload的值是字符串需要再次转map
        String payload = (String) tokenMap.get("payload");
        log.debug("有效载荷:{}", payload);
        Map payloadMap = JSON.parseObject(payload, Map.class);
        log.debug("payloadMap:{}", JSON.toJSONString(payloadMap));

        //增加将当前登入用户信息放入requestAttribute
        LoginUser loginUser = SecurityUtil.convertTokenToLoginUser(jsonToken);
        //tenantId
        String tenantId = httpServletRequest.getHeader("tenantId");
        if (StringUtils.isNotBlank(tenantId))
        {
            //不为空，设置商户id到loginUser中
            loginUser.setTenantId(Long.parseLong(tenantId));
        }
        //将数据设置到Attribute
        httpServletRequest.setAttribute("jsonToken", loginUser);

        //获取当前租户的权限信息
        Map tenantMap = (Map) payloadMap.get(tenantId);
        log.debug("tenantMap:{}", JSON.toJSONString(tenantMap));
        if (tenantMap == null)
        {
            log.error("json-token中没有当前租户 {} 的信息", tenantId);
            //throw new BusinessException(CommonErrorCode.E_999913);
            responseMessage(999913, "json-token令牌有误-没有当前租户信息", httpServletRequest, httpServletResponse);
            return;
        }


        //取对应的 user_authorities信息 将权限放到几个arraylist集合中  不需要角色
        Map<String, JSONArray> userAuthMap = (Map<String, JSONArray>) tenantMap.get("user_authorities");
        log.debug("userAuthMap:{}", JSON.toJSONString(userAuthMap));
        if (userAuthMap == null)
        {
            log.error("json-token中该租户 {} 下没有权限信息", tenantId);
            //throw new BusinessException(CommonErrorCode.E_999914);
            responseMessage(999914, "json-token令牌有误-该租户下没有权限信息", httpServletRequest, httpServletResponse);
            return;
        }

        List<String> rolePrivileges = new ArrayList<>();
        for (Map.Entry<String, JSONArray> entry : userAuthMap.entrySet())
        {
            //String roleName = entry.getKey();
            List<String> privileges = JSONObject.parseArray(JSON.toJSONString(entry.getValue()), String.class);
            //rolePrivileges.add(roleName);
            rolePrivileges.addAll(privileges);
        }
        log.debug("该租户 {} 拥有的权限最终个数{},分别是{}", tenantId, rolePrivileges.size(), rolePrivileges);
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }


    public void responseMessage(int code, String desc, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException
    {
        // 由于全局异常处理器无法捕获filter中的异常信息 利用此map将异常信息直接响应到前端
        Map<String, Object> exceptionMap = new HashMap<>();
        exceptionMap.put("code", code);
        exceptionMap.put("desc", desc);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().print(JSONObject.toJSON(exceptionMap));

    }
}
