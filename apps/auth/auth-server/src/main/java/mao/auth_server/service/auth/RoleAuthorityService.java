package mao.auth_server.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.dto.auth.RoleAuthoritySaveDTO;
import mao.auth_entity.dto.auth.UserRoleSaveDTO;
import mao.auth_entity.entity.auth.RoleAuthority;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): RoleAuthorityService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 21:14
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface RoleAuthorityService extends IService<RoleAuthority>
{
    /**
     * 给用户分配角色
     */
    boolean saveUserRole(UserRoleSaveDTO userRole);

    /**
     * 给角色重新分配 权限（资源/菜单）
     */
    boolean saveRoleAuthority(RoleAuthoritySaveDTO roleAuthoritySaveDTO);
}
