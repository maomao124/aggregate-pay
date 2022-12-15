package mao.auth_server.service.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.dto.auth.UserUpdatePasswordDTO;
import mao.auth_entity.entity.auth.User;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): UserService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 21:01
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public interface UserService extends IService<User>
{
    /**
     * 根据角色id 和 账号或名称 查询角色关联的用户
     * 注意，该接口只返回 id，账号，姓名，手机，性别
     *
     * @param roleId  角色id
     * @param keyword 账号或名称
     */
    List<User> findUserByRoleId(Long roleId, String keyword);

    /**
     * 修改输错密码的次数
     *
     * @param id id
     */
    void updatePasswordErrorNumById(Long id);

    /**
     * 根据账号查询用户
     *
     * @param account 账户
     * @return {@link User}
     */
    User getByAccount(String account);

    /**
     * 修改用户最后一次登录 时间
     *
     * @param account 账户
     */
    void updateLoginTime(String account);

    /**
     * 保存用户
     *
     * @param user 用户
     * @return {@link User}
     */
    User saveUser(User user);

    /**
     * 重置密码
     *
     * @param ids id
     * @return boolean
     */
    boolean reset(List<Long> ids);

    /**
     * 更新用户
     *
     * @param user 用户
     * @return {@link User}
     */
    User updateUser(User user);

    /**
     * 删除，删除的是用户角色表的数据
     *
     * @param ids id
     * @return boolean
     */
    boolean removeUser(List<Long> ids);

    /**
     * 分页
     *
     * @param page    页面
     * @param wrapper 包装器
     * @return {@link IPage}<{@link User}>
     */
    IPage<User> findPage(IPage<User> page, LbqWrapper<User> wrapper);

    /**
     * 更新密码
     *
     * @param data UserUpdatePasswordDTO
     * @return {@link Boolean}
     */
    Boolean updatePassword(UserUpdatePasswordDTO data);

    /**
     * 重置密码错误次数
     */
    int resetPassErrorNum(Long id);
}
