package mao.auth_server.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.RoleSaveDTO;
import mao.auth_entity.dto.auth.RoleUpdateDTO;
import mao.auth_entity.entity.auth.*;
import mao.auth_server.dao.auth.RoleMapper;
import mao.auth_server.service.auth.*;
import mao.tools_common.constant.CacheKey;
import mao.tools_core.base.id.CodeGenerate;
import mao.tools_core.utils.StrHelper;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.toolsdozer.utils.DozerUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): RoleServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 20:50
 * Version(版本): 1.0
 * Description(描述)： 角色服务实现类
 */

@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService
{
    @Resource
    private CacheChannel cacheChannel;

    @Resource
    private DozerUtils dozerUtils;

    @Resource
    private RoleOrgService roleOrgService;

    @Resource
    private RoleAuthorityService roleAuthorityService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private UserService userService;

    @Resource
    private CodeGenerate codeGenerate;


    @Override
    public boolean removeById(List<Long> ids)
    {
        //判断集合是否为空
        if (ids.isEmpty())
        {
            //为空，返回true
            return true;
        }
        //不为空
        ids.forEach(new Consumer<Long>()
        {
            @Override
            public void accept(Long aLong)
            {
                //根据角色id查询用户列表
                List<User> userList = userService.findUserByRoleId(aLong, null);

                if (userList != null && userList.size() > 0)
                {
                    //不为空
                    userList.forEach(user ->
                    {
                        //删除缓存
                        cacheChannel.evict(CacheKey.USER_RESOURCE, user.getId().toString());
                    });
                }
            }
        });

        //删除数据
        super.removeByIds(ids);
        //删除相关表数据
        roleOrgService.remove(Wraps.<RoleOrg>lbQ().in(RoleOrg::getRoleId, ids));
        roleAuthorityService.remove(Wraps.<RoleAuthority>lbQ().in(RoleAuthority::getRoleId, ids));
        userRoleService.remove(Wraps.<UserRole>lbQ().in(UserRole::getRoleId, ids));
        return true;
    }

    @Override
    public List<Role> findRoleByUserId(Long userId)
    {
        return baseMapper.findRoleByUserId(userId);
    }

    @Override
    public void saveRole(RoleSaveDTO data, Long userId)
    {
        //转成Role
        Role role = dozerUtils.map(data, Role.class);
        //编码，雪花算法
        role.setCode(StrHelper.getOrDef(data.getCode(), codeGenerate.next()));
        //非只读
        role.setReadonly(false);
        //保存
        this.save(role);
        //保存关系
        this.saveRoleOrg(userId, role, data.getOrgList());
    }

    /**
     * 保存角色组织
     *
     * @param userId  用户id
     * @param role    角色
     * @param orgList 组织列表
     */
    private void saveRoleOrg(Long userId, Role role, List<Long> orgList)
    {
        //判空
        if (orgList != null && !orgList.isEmpty())
        {
            List<RoleOrg> list = orgList.stream().map((orgId) ->
                    RoleOrg.builder()
                            .orgId(orgId).roleId(role.getId())
                            .build()
            ).collect(Collectors.toList());
            //保存
            roleOrgService.saveBatch(list);
        }
    }

    @Override
    public void updateRole(RoleUpdateDTO roleUpdateDTO, Long userId)
    {
        //转成Role
        Role role = dozerUtils.map(roleUpdateDTO, Role.class);
        //更新
        this.updateById(role);
        //根据角色id移除roleOrg关系表的数据
        roleOrgService.remove(Wraps.<RoleOrg>lbQ().eq(RoleOrg::getRoleId, roleUpdateDTO.getId()));
        //保存新的关系
        saveRoleOrg(userId, role, roleUpdateDTO.getOrgList());
    }

    @Override
    public List<Long> findUserIdByCode(String[] codes)
    {
        return baseMapper.findUserIdByCode(codes);
    }

    @Override
    public Boolean check(String code)
    {
        return this.count(Wraps.<Role>lbQ().eq(Role::getCode, code)) > 0;
    }
}
