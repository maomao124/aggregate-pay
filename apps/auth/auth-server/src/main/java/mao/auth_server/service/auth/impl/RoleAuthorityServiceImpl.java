package mao.auth_server.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.RoleAuthoritySaveDTO;
import mao.auth_entity.dto.auth.UserRoleSaveDTO;
import mao.auth_entity.entity.auth.RoleAuthority;
import mao.auth_entity.entity.auth.UserRole;
import mao.auth_entity.enumeration.auth.AuthorizeType;
import mao.auth_server.dao.auth.RoleAuthorityMapper;
import mao.auth_server.service.auth.ResourceService;
import mao.auth_server.service.auth.RoleAuthorityService;
import mao.auth_server.service.auth.UserRoleService;
import mao.tools_common.constant.CacheKey;
import mao.tools_core.utils.NumberHelper;
import mao.tools_databases.mybatis.conditions.Wraps;
import net.oschina.j2cache.CacheChannel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): RoleAuthorityServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 21:15
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class RoleAuthorityServiceImpl extends ServiceImpl<RoleAuthorityMapper, RoleAuthority> implements RoleAuthorityService
{
    @Resource
    private UserRoleService userRoleService;

    @Resource
    private ResourceService resourceService;

    @Resource
    private CacheChannel cacheChannel;

    @Override
    public boolean saveUserRole(UserRoleSaveDTO userRole)
    {
        //根据角色id删除
        userRoleService.remove(Wraps.<UserRole>lbQ().eq(UserRole::getRoleId, userRole.getRoleId()));
        //判断是否为空
        if (userRole.getUserIdList() == null || userRole.getRoleId() == null)
        {
            return false;
        }
        List<UserRole> list = userRole.getUserIdList()
                .stream()
                .map((userId) -> UserRole.builder()
                        .userId(userId)
                        .roleId(userRole.getRoleId())
                        .build())
                .collect(Collectors.toList());
        //保存
        userRoleService.saveBatch(list);
        //清除 用户拥有的资源列表
        userRole.getUserIdList().forEach((userId) ->
        {
            String key = CacheKey.buildKey(userId);
            cacheChannel.evict(CacheKey.USER_RESOURCE, key);
        });
        return true;
    }

    @Override
    public boolean saveRoleAuthority(RoleAuthoritySaveDTO roleAuthoritySaveDTO)
    {
        //根据角色id移除
        this.remove(Wraps.<RoleAuthority>lbQ().eq(RoleAuthority::getRoleId, roleAuthoritySaveDTO.getRoleId()));
        List<RoleAuthority> list = new ArrayList<>();
        if (roleAuthoritySaveDTO.getResourceIdList() != null && !roleAuthoritySaveDTO.getResourceIdList().isEmpty())
        {
            List<Long> menuIdList = resourceService.findMenuIdByResourceId(roleAuthoritySaveDTO.getResourceIdList());
            if (roleAuthoritySaveDTO.getMenuIdList() == null || roleAuthoritySaveDTO.getMenuIdList().isEmpty())
            {
                roleAuthoritySaveDTO.setMenuIdList(menuIdList);
            }
            else
            {
                roleAuthoritySaveDTO.getMenuIdList().addAll(menuIdList);
            }

            //保存授予的资源
            List<RoleAuthority> resourceList = new HashSet<>(roleAuthoritySaveDTO.getResourceIdList())
                    .stream()
                    .map((resourceId) -> RoleAuthority.builder()
                            .authorityType(AuthorizeType.RESOURCE)
                            .authorityId(resourceId)
                            .roleId(roleAuthoritySaveDTO.getRoleId())
                            .build())
                    .collect(Collectors.toList());
            list.addAll(resourceList);
        }
        if (roleAuthoritySaveDTO.getMenuIdList() != null && !roleAuthoritySaveDTO.getMenuIdList().isEmpty())
        {
            //保存授予的菜单
            List<RoleAuthority> menuList = new HashSet<>(roleAuthoritySaveDTO.getMenuIdList())
                    .stream()
                    .map((menuId) -> RoleAuthority.builder()
                            .authorityType(AuthorizeType.MENU)
                            .authorityId(menuId)
                            .roleId(roleAuthoritySaveDTO.getRoleId())
                            .build())
                    .collect(Collectors.toList());
            list.addAll(menuList);
        }
        //保存
        this.saveBatch(list);
        List<Long> userIdList = userRoleService.listObjs(Wraps.<UserRole>lbQ().
                        select(UserRole::getUserId).eq(UserRole::getRoleId, roleAuthoritySaveDTO.getRoleId()),
                NumberHelper::longValueOf0);
        new HashSet<>(userIdList).forEach((userId) ->
        {
            cacheChannel.evict(CacheKey.USER_RESOURCE, String.valueOf(userId));
        });
        return true;
    }
}
