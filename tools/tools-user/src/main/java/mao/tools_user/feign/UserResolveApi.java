package mao.tools_user.feign;

import mao.tools_core.base.R;
import mao.tools_user.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.feign
 * Interface(接口名): UserResolveApi
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:36
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@FeignClient(name = "${feign.authority-server:auth-server}", fallbackFactory = UserResolveApiFallback.class)
public interface UserResolveApi
{
    /**
     * 根据id 查询用户详情
     */
    @PostMapping(value = "/user/anno/id/{id}")
    R<SysUser> getById(@PathVariable("id") Long id, @RequestBody UserQuery userQuery);
}
