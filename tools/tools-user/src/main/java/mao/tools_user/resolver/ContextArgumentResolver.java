package mao.tools_user.resolver;

import lombok.extern.slf4j.Slf4j;
import mao.tools_core.base.R;
import mao.tools_core.context.BaseContextHandler;
import mao.tools_core.utils.NumberHelper;
import mao.tools_user.annotation.LoginUser;
import mao.tools_user.entity.SysUser;
import mao.tools_user.feign.UserQuery;
import mao.tools_user.feign.UserResolveApi;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.resolver
 * Class(类名): ContextArgumentResolver
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:33
 * Version(版本): 1.0
 * Description(描述)： Token转化SysUser
 */

@Slf4j
public class ContextArgumentResolver implements HandlerMethodArgumentResolver
{
    private final UserResolveApi userResolveApi;

    public ContextArgumentResolver(UserResolveApi userResolveApi)
    {
        this.userResolveApi = userResolveApi;
    }

    /**
     * 入参筛选
     *
     * @param mp 参数集合
     * @return 格式化后的参数
     */
    @Override
    public boolean supportsParameter(MethodParameter mp)
    {
        return mp.hasParameterAnnotation(LoginUser.class) && mp.getParameterType().equals(SysUser.class);
    }

    /**
     * @param methodParameter       入参集合
     * @param modelAndViewContainer model 和 view
     * @param nativeWebRequest      web相关
     * @param webDataBinderFactory  入参解析
     * @return 包装对象
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory)
    {
        Long userId = BaseContextHandler.getUserId();
        String account = BaseContextHandler.getAccount();
        String name = BaseContextHandler.getName();
        Long orgId = BaseContextHandler.getOrgId();
        Long stationId = BaseContextHandler.getStationId();

        //以下代码为 根据 @LoginUser 注解来注入 SysUser 对象
        SysUser user = SysUser.builder()
                .id(userId)
                .account(account)
                .name(name)
                .orgId(orgId)
                .stationId(stationId)
                .build();

        try
        {
            LoginUser loginUser = methodParameter.getParameterAnnotation(LoginUser.class);
            boolean isFull = loginUser.isFull();

            if (isFull || loginUser.isStation() || loginUser.isOrg() || loginUser.isRoles())
            {
                R<SysUser> result = userResolveApi.getById(NumberHelper.longValueOf0(userId),
                        UserQuery.builder()
                                .full(isFull)
                                .org(loginUser.isOrg())
                                .station(loginUser.isStation())
                                .roles(loginUser.isRoles())
                                .build());
                if (result.getIsSuccess() && result.getData() != null)
                {
                    return result.getData();
                }
            }
        }
        catch (Exception e)
        {
            log.warn("注入登录人信息时，发生异常. --> {}", user, e);
        }
        return user;
    }
}
