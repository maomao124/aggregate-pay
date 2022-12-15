package mao.auth_server.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.entity.auth.UserRole;
import mao.auth_server.dao.auth.UserRoleMapper;
import mao.auth_server.service.auth.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): UserRoleServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 21:06
 * Version(版本): 1.0
 * Description(描述)： 用户角色实现类
 */

@Slf4j
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService
{

}
