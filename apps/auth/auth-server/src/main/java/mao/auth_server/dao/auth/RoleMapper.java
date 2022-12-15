package mao.auth_server.dao.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.auth_entity.entity.auth.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.auth
 * Interface(接口名): RoleMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 20:56
 * Version(版本): 1.0
 * Description(描述)：角色
 */

@Mapper
public interface RoleMapper extends BaseMapper<Role>
{
    /**
     * 通过用户id找到角色
     *
     * @param userId 用户id
     * @return {@link List}<{@link Role}>
     */
    List<Role> findRoleByUserId(@Param("userId") Long userId);

    /**
     * 根据角色编码查询用户ID
     *
     * @param codes 角色编码
     * @return {@link List}<{@link Long}>
     */
    List<Long> findUserIdByCode(@Param("codes") String[] codes);
}
