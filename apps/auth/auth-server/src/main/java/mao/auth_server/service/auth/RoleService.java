package mao.auth_server.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.dto.auth.RoleSaveDTO;
import mao.auth_entity.dto.auth.RoleUpdateDTO;
import mao.auth_entity.entity.auth.Role;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): RoleService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 20:49
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface RoleService extends IService<Role>
{
    /**
     * 根据ID删除
     */
    boolean removeById(List<Long> ids);

    /**
     * 查询用户拥有的角色
     */
    List<Role> findRoleByUserId(Long userId);

    /**
     * 保存角色
     */
    void saveRole(RoleSaveDTO data, Long userId);

    /**
     * 修改
     */
    void updateRole(RoleUpdateDTO role, Long userId);

    /**
     * 根据角色编码查询用户ID
     */
    List<Long> findUserIdByCode(String[] codes);

    /**
     * 检测编码重复 存在返回真
     */
    Boolean check(String code);
}
