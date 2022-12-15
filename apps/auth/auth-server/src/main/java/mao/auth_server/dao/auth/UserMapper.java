package mao.auth_server.dao.auth;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import mao.auth_entity.entity.auth.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.auth
 * Interface(接口名): UserMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 20:57
 * Version(版本): 1.0
 * Description(描述)： 用户
 */

@Mapper
public interface UserMapper extends BaseMapper<User>
{
    /**
     * 根据角色id，查询已关联用户
     *
     * @param roleId  角色id
     * @param keyword 关键字
     * @return {@link List}<{@link User}>
     */
    List<User> findUserByRoleId(@Param("roleId") Long roleId, @Param("keyword") String keyword);

    /**
     * 递增密码错误次数
     *
     * @param id id
     * @return int
     */
    int incrPasswordErrorNumById(@Param("id") Long id);

    /**
     * 带数据权限的分页查询
     *
     * @param page    页面
     * @param wrapper 包装器
     * @return {@link IPage}<{@link User}>
     */
    IPage<User> findPage(IPage<User> page, @Param(Constants.WRAPPER) Wrapper<User> wrapper);


    /**
     * 重置密码错误次数
     *
     * @param id id
     * @return int
     */
    int resetPassErrorNum(@Param("id") Long id);


    /**
     * 更新最后登录时间
     *
     * @param account 账户
     * @param now     现在时间
     * @return int
     */
    int updateLastLoginTime(@Param("account") String account, @Param("now") LocalDateTime now);
}
