package mao.gateway.filter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import mao.tools_core.base.R;
import mao.tools_core.constants.BaseContextConstants;
import mao.tools_core.exception.BizException;
import mao.tools_core.utils.StrHelper;
import mao.tools_jwt.client.config.AuthClientConfigurationProperties;
import mao.tools_jwt.client.utils.JwtTokenClientUtils;
import mao.tools_jwt.entity.JwtUserInfo;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.gateway.filter
 * Class(类名): TokenContextFilter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/13
 * Time(创建时间)： 14:31
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Component
public class TokenContextFilter extends BaseFilter
{

    @Resource
    private AuthClientConfigurationProperties authClientConfigurationProperties;

    @Resource
    private JwtTokenClientUtils jwtTokenClientUtils;

    /**
     * 前置过滤器
     *
     * @return {@link String}
     */
    @Override
    public String filterType()
    {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 设置过滤器执行顺序，数值越大优先级越低
     *
     * @return int
     */
    @Override
    public int filterOrder()
    {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    /**
     * 是否执行当前过滤器
     *
     * @return boolean
     */
    @Override
    public boolean shouldFilter()
    {
        return true;
    }

    @Override
    public Object run() throws ZuulException
    {
        //判断是否需要直接放行
        boolean ignoreToken = this.isIgnoreToken();
        if (ignoreToken)
        {
            //直接放行
            return null;
        }
        //需要认证
        //获取HttpServletRequest
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        //获取RequestContext
        RequestContext requestContext = RequestContext.getCurrentContext();
        //从请求头中获取token
        String token = request.getHeader(authClientConfigurationProperties.getUser().getHeaderName());
        JwtUserInfo userInfo = null;
        try
        {
            //解析token令牌
            userInfo = jwtTokenClientUtils.getUserInfo(token);
        }
        catch (BizException e)
        {
            //业务异常
            errorResponse(e.getMessage(), e.getCode(), 200);
            return null;
        }
        catch (Exception e)
        {
            //其它异常
            errorResponse("解析jwt令牌出错", R.FAIL_CODE, 200);
            return null;
        }

        //将信息放入header
        if (userInfo != null)
        {
            addHeader(requestContext, BaseContextConstants.JWT_KEY_ACCOUNT,
                    userInfo.getAccount());
            addHeader(requestContext, BaseContextConstants.JWT_KEY_USER_ID,
                    userInfo.getUserId());
            addHeader(requestContext, BaseContextConstants.JWT_KEY_NAME,
                    userInfo.getName());
            addHeader(requestContext, BaseContextConstants.JWT_KEY_ORG_ID,
                    userInfo.getOrgId());
            addHeader(requestContext, BaseContextConstants.JWT_KEY_STATION_ID,
                    userInfo.getStationId());
        }
        return null;
    }

    /**
     * 将一个键值对添加到请求头中
     *
     * @param requestContext 请求上下文
     * @param key            key
     * @param value          value
     */
    private void addHeader(RequestContext requestContext, String key, Object value)
    {
        //空的就不添加
        if (StringUtils.isEmpty(key))
        {
            return;
        }
        if (StringUtils.isEmpty(value))
        {
            return;
        }
        requestContext.addZuulRequestHeader(key, StrHelper.encode(value.toString()));
    }


}
