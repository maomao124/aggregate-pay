package mao.gateway.filter;

import cn.hutool.core.util.StrUtil;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.gateway.api.ResourceApi;
import mao.tools_common.constant.CacheKey;
import mao.tools_core.constants.BaseContextConstants;
import mao.tools_core.exception.ExceptionCode;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.gateway.filter
 * Class(类名): AccessFilter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/13
 * Time(创建时间)： 14:10
 * Version(版本): 1.0
 * Description(描述)： 鉴权处理过滤器
 */


@Slf4j
@Component
public class AccessFilter extends BaseFilter
{
    @Resource
    private ResourceApi resourceApi;

    @Resource
    private CacheChannel cacheChannel;

    @Override
    public String filterType()
    {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder()
    {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 10;
    }

    @Override
    public boolean shouldFilter()
    {
        return true;
    }

    @Override
    public Object run() throws ZuulException
    {
        //判断当前请求uri是否需要忽略
        boolean ignoreToken = this.isIgnoreToken();
        if (ignoreToken)
        {
            //忽略，直接放行
            return null;
        }
        //需要验证
        //获得HttpServletRequest
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        //获得请求方式
        String method = request.getMethod();
        //获得uri
        String requestURI = request.getRequestURI();
        requestURI = StrUtil.subSuf(requestURI, zuulPrefix.length());
        requestURI = StrUtil.subSuf(requestURI, requestURI.indexOf("/", 1));
        //拼接成GET/user/page这种形式
        String permission = method + requestURI;
        //从缓存里取需要进行鉴权的资源
        CacheObject cacheObject = cacheChannel.get(CacheKey.RESOURCE, CacheKey.RESOURCE_NEED_TO_CHECK);
        List<String> list = (List<String>) cacheObject.getValue();
        //判断是否为空，如果没有获取到则通过Feign调用权限服务获取并放入缓存中
        if (list == null)
        {
            //远程调用
            list = resourceApi.list().getData();
            if (list != null && list.size() > 0)
            {
                //放入缓存
                cacheChannel.set(CacheKey.RESOURCE, CacheKey.RESOURCE_NEED_TO_CHECK, list);
            }
        }

        //判断这些资源是否包含当前请求的权限标识符
        long count = list.stream().filter(permission::startsWith).count();
        //不包含
        if (count == 0)
        {
            //当前请求是一个未知请求，直接返回未授权异常信息
            errorResponse(ExceptionCode.UNAUTHORIZED.getMsg(), ExceptionCode.UNAUTHORIZED.getCode(), 200);
            return null;
        }

        //如果包含当前的权限标识符，则从zuul header中取出用户id，根据用户id取出缓存中的用户拥有的权限
        String userId = RequestContext.getCurrentContext().getZuulRequestHeaders().get(BaseContextConstants.JWT_KEY_USER_ID);
        //从缓存里取用户可用的资源
        List<String> visibleResource = (List<String>) cacheChannel.get(CacheKey.USER_RESOURCE, userId).getValue();

        //缓存里没有，如果没有取到则通过Feign调用权限服务获取并放入缓存，判断用户拥有的权限是否包含当前请求的权限标识符
        if (visibleResource == null)
        {
            //缓存中不存在，需要通过接口远程调用权限服务来获取
            ResourceQueryDTO resourceQueryDTO = ResourceQueryDTO.builder().userId(new Long(userId)).build();
            //获取resourceList
            List<mao.auth_entity.entity.auth.Resource> resourceList = resourceApi.visible(resourceQueryDTO).getData();
            if (resourceList != null && resourceList.size() > 0)
            {
                visibleResource = resourceList.stream().map((resource -> resource.getMethod() +
                        resource.getUrl())).collect(Collectors.toList());
                //缓存
                cacheChannel.set(CacheKey.USER_RESOURCE, userId, visibleResource);
            }
        }

        //如果用户拥有的权限包含当前请求的权限标识符则说明当前用户拥有权限，直接放行
        count = visibleResource.stream().filter(permission::startsWith).count();


        if (count > 0)
        {
            //大于0，当前用户拥有权限
            return null;
        }
        else
        {
            //等于0，没有权限，返回未授权
            errorResponse(ExceptionCode.UNAUTHORIZED.getMsg(), ExceptionCode.UNAUTHORIZED.getCode(), 200);
            return null;
        }
    }

}
