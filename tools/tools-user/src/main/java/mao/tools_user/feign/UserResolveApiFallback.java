package mao.tools_user.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import mao.tools_core.base.R;
import mao.tools_user.entity.SysUser;
import org.springframework.stereotype.Component;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.feign
 * Class(类名): UserResolveApiFallback
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:35
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Component
public class UserResolveApiFallback implements FallbackFactory<UserResolveApi>
{

    @Override
    public UserResolveApi create(Throwable throwable)
    {
        return new UserResolveApi()
        {
            /**
             * 根据id 查询用户详情
             *
             * @param id 用户的id
             * @param userQuery UserQuery
             * @return R<SysUser>
             */
            @Override
            public R<SysUser> getById(Long id, UserQuery userQuery)
            {
                log.error("通过用户名查询用户异常:{}", id, throwable);
                return R.timeout();
            }
        };
    }
}
