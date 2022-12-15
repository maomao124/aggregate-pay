package mao.auth_server.service.auth.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.UserUpdatePasswordDTO;
import mao.auth_entity.entity.auth.User;
import mao.auth_entity.entity.auth.UserRole;
import mao.auth_server.dao.auth.UserMapper;
import mao.auth_server.service.auth.PasswordEncoderService;
import mao.auth_server.service.auth.UserRoleService;
import mao.auth_server.service.auth.UserService;
import mao.tools_core.exception.BizException;
import mao.tools_core.utils.BizAssert;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): UserServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 21:05
 * Version(版本): 1.0
 * Description(描述)： 用户Service实现类
 */

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService
{

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private PasswordEncoderService passwordEncoderService;

    @Override
    public List<User> findUserByRoleId(Long roleId, String keyword)
    {
        return baseMapper.findUserByRoleId(roleId, keyword);
    }

    @Override
    public void updatePasswordErrorNumById(Long id)
    {
        baseMapper.incrPasswordErrorNumById(id);
    }

    @Override
    public User getByAccount(String account)
    {
        return getOne(Wraps.<User>lbQ().eq(User::getAccount, account));
    }

    @Override
    public void updateLoginTime(String account)
    {
        baseMapper.updateLastLoginTime(account, LocalDateTime.now());
    }

    @Override
    public User saveUser(User user)
    {
        //设置密码过期时间
        user.setPasswordExpireTime(null);
        //加密密码
        user.setPassword(passwordEncoderService.encoder(user.getPassword()));
        //设置密码的错误计数为0
        user.setPasswordErrorNum(0);
        //保存
        boolean b = this.save(user);
        if (b)
        {
            return user;
        }
        throw BizException.wrap("用户添加失败！");
    }

    @Override
    public boolean reset(List<Long> ids)
    {
        String password = passwordEncoderService.encoder("123456");
        return super.update(Wraps.<User>lbU()
                .set(User::getPassword, password)
                .set(User::getPasswordErrorNum, 0L)
                .set(User::getPasswordErrorLastTime, null)
                .set(User::getPasswordExpireTime, null)
                .in(User::getId, ids)
        );
    }

    @Override
    public User updateUser(User user)
    {
        //填充密码
        if (StrUtil.isNotEmpty(user.getPassword()))
        {
            user.setPassword(passwordEncoderService.encoder(user.getPassword()));
        }
        //更新
        boolean b = this.updateById(user);
        if (b)
        {
            return user;
        }
        throw BizException.wrap("用户更新失败");
    }

    @Override
    public boolean removeUser(List<Long> ids)
    {
        return userRoleService.remove(Wraps.<UserRole>lbQ().in(UserRole::getUserId, ids));
    }

    @Override
    public IPage<User> findPage(IPage<User> page, LbqWrapper<User> wrapper)
    {
        return baseMapper.findPage(page, wrapper);
    }

    @Override
    public Boolean updatePassword(UserUpdatePasswordDTO data)
    {
        //校验两次输入的密码是否一致
        BizAssert.equals(data.getConfirmPassword(), data.getPassword(), "密码与确认密码不一致");
        //获取用户信息
        User user = this.getById(data.getId());
        //判断用户是否存在
        BizAssert.notNull(user, "用户不存在");
        //验证老密码是否正确
        boolean verification = passwordEncoderService.verification(data.getOldPassword(), user.getPassword());
        if (!verification)
        {
            //旧密码错误
            throw BizException.wrap("旧密码错误");
        }
        //旧密码正确
        //加密新密码
        String newPassword = passwordEncoderService.encoder(data.getPassword());
        //更新
        return this.update(Wraps.<User>lbU().eq(User::getId, data.getId()).set(User::getPassword, newPassword));
    }

    @Override
    public int resetPassErrorNum(Long id)
    {
        return baseMapper.resetPassErrorNum(id);
    }
}
