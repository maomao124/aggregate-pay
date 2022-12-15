package mao.auth_server.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.entity.auth.RoleOrg;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): RoleOrgService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 21:07
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface RoleOrgService extends IService<RoleOrg>
{
    /**
     * 根据角色id查询
     *
     * @param id id
     * @return {@link List}<{@link Long}>
     */
    List<Long> listOrgByRoleId(Long id);
}
