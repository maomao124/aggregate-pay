package mao.auth_server.service.auth.impl;

import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.LoginDTO;
import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.dto.auth.UserDTO;
import mao.auth_entity.entity.auth.User;
import mao.auth_server.service.auth.*;
import mao.tools_common.constant.CacheKey;
import mao.tools_core.base.R;
import mao.tools_core.utils.BizAssert;
import mao.tools_jwt.entity.JwtUserInfo;
import mao.tools_jwt.entity.Token;
import mao.tools_jwt.server.utils.JwtTokenServerUtils;
import mao.toolsdozer.utils.DozerUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): AuthServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 20:37
 * Version(版本): 1.0
 * Description(描述)： 用户登录校验
 */

@Slf4j
@Service
public class AuthServiceImpl implements AuthService
{

    @Resource
    private JwtTokenServerUtils jwtTokenServerUtils;

    @Resource
    private UserService userService;

    @Resource
    private ResourceService resourceService;

    @Resource
    private DozerUtils dozer;

    @Resource
    private PasswordEncoderService passwordEncoderService;

    @Resource
    private CacheChannel cacheChannel;

    @Resource
    private ValidateCodeService validateCodeService;

    @Override
    public R<LoginDTO> login(String account, String password, String key, String value)
    {
        //校验验证码
        validateCodeService.check(key, value);
        //校验用户
        R<User> userR = this.check(account, password);
        //判断是否校验成功
        if (userR.getIsError())
        {
            //校验失败
            return R.fail(userR.getMsg());
        }
        //校验成功
        //生成token
        User user = userR.getData();
        Token token = this.generateUserToken(user);

        //查询用户可以访问的资源
        List<mao.auth_entity.entity.auth.Resource> visibleResource =
                resourceService.findVisibleResource(ResourceQueryDTO.builder().userId(user.getId()).build());
        log.debug("用户 " + user.getId() + "拥有的权限：" + visibleResource);
        //权限列表
        List<String> permissionList = null;
        if (visibleResource != null && visibleResource.size() > 0)
        {
            //用户有至少任何一个权限
            //前端使用
            permissionList = visibleResource.stream().
                    map(mao.auth_entity.entity.auth.Resource::getCode).collect(Collectors.toList());

            //给后端使用
            List<String> list = visibleResource.stream()
                    .map(resource -> resource.getMethod() + resource.getUrl())
                    .collect(Collectors.toList());

            //缓存，key为用户的id
            cacheChannel.set(CacheKey.USER_RESOURCE, user.getId().toString(), list);
        }

        //封装结果
        LoginDTO loginDTO = LoginDTO.builder()
                //用户数据
                .user(dozer.map(userR.getData(), UserDTO.class))
                //token
                .token(token)
                //权限列表
                .permissionsList(permissionList)
                .build();
        //返回
        return R.success(loginDTO);
    }


    /**
     * 校验用户
     *
     * @param account  账户
     * @param password 密码
     * @return {@link R}<{@link User}>
     */
    private R<User> check(String account, String password)
    {
        //查询用户信息
        User user = userService.getByAccount(account);
        //判断用户是否存在
        if (user == null)
        {
            return R.fail("用户不存在");
        }
        //用户存在
        //校验密码
        boolean verification = passwordEncoderService.verification(password, user.getPassword());
        if (!verification)
        {
            //密码不正确
            //将密码错误次数+1
            userService.updatePasswordErrorNumById(user.getId());
            //返回
            return R.fail("密码不正确");
        }
        else
        {
            //密码正确
            if (user.getPasswordErrorNum() != 0)
            {
                //重置密码错误次数
                userService.resetPassErrorNum(user.getId());
            }
            //返回
            R.success(user);
        }
        return R.success(user);
    }

    /**
     * 生成用户的token令牌
     *
     * @param user 用户
     * @return {@link Token}
     */
    private Token generateUserToken(User user)
    {
        JwtUserInfo jwtUserInfo = new JwtUserInfo(user.getId(),
                user.getAccount(), user.getName(), user.getOrgId(), user.getStationId());
        return jwtTokenServerUtils.generateUserToken(jwtUserInfo, null);
    }

}
