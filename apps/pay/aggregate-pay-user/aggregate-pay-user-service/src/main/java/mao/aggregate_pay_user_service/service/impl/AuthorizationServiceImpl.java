package mao.aggregate_pay_user_service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.BusinessException;
import mao.aggregate_pay_common.domain.CommonErrorCode;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.auth.AuthorizationInfoDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeTreeDTO;
import mao.aggregate_pay_user_api.dto.auth.RoleDTO;
import mao.aggregate_pay_user_api.dto.tenant.TenRolePrivilegeDTO;
import mao.aggregate_pay_user_service.entity.*;
import mao.aggregate_pay_user_service.mapper.*;
import mao.aggregate_pay_user_service.service.AuthorizationService;
import mao.toolsdozer.utils.DozerUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.service.impl
 * Class(类名): AuthorizationServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 19:51
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@Slf4j
@Service
public class AuthorizationServiceImpl implements AuthorizationService
{
    @Resource
    private AuthorizationRoleMapper authorizationRoleMapper;

    @Resource
    private AuthorizationPrivilegeMapper authorizationPrivilegeMapper;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private AccountRoleMapper accountRoleMapper;

    @Resource
    private AuthorizationRolePrivilegeMapper authorizationRolePrivilegeMapper;

    @Resource
    private AuthorizationPrivilegeGroupMapper authorizationPrivilegeGroupMapper;

    @Resource
    private DozerUtils dozerUtils;


    /**
     * 授权，获取某用户在多个租户下的权限信息
     *
     * @param username  用户名
     * @param tenantIds 租户id列表
     * @return key为租户id  value为租户下的角色权限信息
     */
    @Override
    public Map<Long, AuthorizationInfoDTO> authorize(String username, Long[] tenantIds)
    {
        List<Long> ids = Arrays.asList(tenantIds);
        List<Long> roleIds = accountRoleMapper.selectRoleByUsernameInTenants(username, ids);
        List<TenRolePrivilegeDTO> list = authorizationPrivilegeMapper.selectPrivilegeRoleInTenant(roleIds);
        if (list == null)
        {
            throw new BusinessException(CommonErrorCode.E_100104);
        }
        Map<Long, AuthorizationInfoDTO> map = new HashMap<>();// key 是租户id
        /*{
            租户id:{
                r_001:[p_001,p_002],
                r_002:[p_004,p_005]
            }
            ....
        }*/
        for (TenRolePrivilegeDTO dto : list)
        {
            if (!map.containsKey(dto.getTenantId()))
            {
                map.put(dto.getTenantId(), new AuthorizationInfoDTO());
            }
            AuthorizationInfoDTO info = map.get(dto.getTenantId());
            if (info.getRolePrivilegeMap().containsKey(dto.getRoleCode()))
            {
                info.getRolePrivilegeMap().get(dto.getRoleCode()).add(dto.getPrivilegeCode());
            }
            else
            {
                List<String> prviList = new ArrayList<>();
                prviList.add(dto.getPrivilegeCode());
                info.getRolePrivilegeMap().put(dto.getRoleCode(), prviList);
            }
        }
        return map;
    }

    /**
     * 查找某租户下，多个角色的权限信息集合
     *
     * @param tenantId  承租者id
     * @param roleCodes 角色代码
     * @return List<PrivilegeTreeDTO>
     */
    @Override
    public List<PrivilegeDTO> queryPrivilege(Long tenantId, String[] roleCodes)
    {
        //先获取某租户下的角色
        List<AuthorizationRole> roles = authorizationRoleMapper.selectList(new QueryWrapper<AuthorizationRole>().lambda()
                .eq(AuthorizationRole::getTenantId, tenantId)
                .in(AuthorizationRole::getCode, roleCodes));
        //获取多个角色的权限权限集合
        List<AuthorizationPrivilege> privileges = new ArrayList<>();
        if (!roles.isEmpty())
        {
            List<Long> roleIds = roles.stream().map(AuthorizationRole::getId).collect(Collectors.toList());
            privileges = authorizationPrivilegeMapper.selectPrivilegeByRole(roleIds);
        }
        List<PrivilegeDTO> privilegeDTOS = dozerUtils.mapList(privileges, PrivilegeDTO.class);
        return privilegeDTOS;
    }

    /**
     * 获取权限组下所有权限
     *
     * @param privilegeGroupId 权限组ID
     * @return {@link List}<{@link PrivilegeDTO}>
     */
    @Override
    public List<PrivilegeDTO> queryPrivilegeByGroupId(Long privilegeGroupId)
    {
        List<AuthorizationPrivilege> privilegeList = authorizationPrivilegeMapper.selectList(new QueryWrapper<AuthorizationPrivilege>().lambda()
                .eq(AuthorizationPrivilege::getPrivilegeGroupId, privilegeGroupId));
        //转换
        List<PrivilegeDTO> privilegeDTOS = dozerUtils.mapList(privilegeList, PrivilegeDTO.class);
        return privilegeDTOS;
    }

    /**
     * 查找某租户下，多个角色的权限信息集合，并根据权限组组装成为权限树
     *
     * @param roleCodes 角色编码列表，为null时代表所有权限
     * @param tenantId  承租者id
     * @return {@link PrivilegeTreeDTO}
     */
    @Override
    public PrivilegeTreeDTO queryPrivilegeTree(Long tenantId, String[] roleCodes)
    {
        //1.获取租户下角色对应的权限集合
        List<PrivilegeDTO> pList = queryPrivilege(tenantId, roleCodes);
        HashSet<PrivilegeDTO> h = new HashSet<PrivilegeDTO>(pList);
        pList.clear();
        pList.addAll(h);
        //2.获取所有权限组
        List<AuthorizationPrivilegeGroup> groupList = authorizationPrivilegeGroupMapper.selectList(null);

        Map<String, PrivilegeTreeDTO> groupsMap = new HashMap<>();
        String topId = "top_1";
        PrivilegeTreeDTO topTree = new PrivilegeTreeDTO();
        topTree.setId(topId);
        topTree.setParentId(null);
        topTree.setName(null);
        topTree.setStatus(0);

        for (AuthorizationPrivilegeGroup g : groupList)
        {
            if (g.getParentId() == null)
            {
                PrivilegeTreeDTO child = new PrivilegeTreeDTO();
                child.setId(String.valueOf(g.getId()));
                child.setParentId(topId);
                child.setName(g.getName());
                child.setGroup(true);
                child.setStatus(1);
                topTree.getChildren().add(child);

                privGroupTree(child, groupList, groupsMap);
            }
        }

        for (PrivilegeDTO priv : pList)
        {

            String privGroupId = String.valueOf(priv.getPrivilegeGroupId());
            PrivilegeTreeDTO pGroupTreeDto = groupsMap.get(privGroupId);
            if (pGroupTreeDto != null)
            {

                PrivilegeTreeDTO pTreeDto = new PrivilegeTreeDTO();
                pTreeDto.setGroup(false);
                pTreeDto.setName(priv.getName());
                pTreeDto.setId(priv.getCode());
                pTreeDto.setParentId(privGroupId);
                pTreeDto.setStatus(1);

                pGroupTreeDto.getChildren().add(pTreeDto);
            }
        }
        return topTree;
    }


    private void privGroupTree(
            PrivilegeTreeDTO currChild, List<AuthorizationPrivilegeGroup> groupList, Map<String, PrivilegeTreeDTO> groupsMap)
    {
        if (!groupsMap.containsKey(currChild.getId()))
        {
            groupsMap.put(currChild.getId(), currChild);
        }
        for (AuthorizationPrivilegeGroup ccGroup : groupList)
        {
            if (String.valueOf(ccGroup.getParentId()).equals(currChild.getId()))
            {

                PrivilegeTreeDTO tmp = new PrivilegeTreeDTO();
                tmp.setId(String.valueOf(ccGroup.getId()));
                tmp.setParentId(currChild.getId());
                tmp.setName(ccGroup.getName());
                tmp.setGroup(true);
                tmp.setStatus(1);
                currChild.getChildren().add(tmp);

                //是否是多余的
                if (!groupsMap.containsKey(tmp.getId()))
                {
                    groupsMap.put(tmp.getId(), tmp);
                }
                privGroupTree(tmp, groupList, groupsMap);
            }
        }
    }

/////////////////////////////////////////////角色、权限/////////////////////////////////////////////

    /**
     * 创建租户内角色(不包含权限)
     *
     * @param tenantId 承租者id
     * @param role     角色
     */
    @Override
    public void createRole(Long tenantId, RoleDTO role)
    {
        //此处需要校验 同一租户下角色code不能相同
        if (role == null || StringUtils.isBlank(role.getCode()))
        {
            throw new BusinessException(CommonErrorCode.E_110003);
        }
        String code = role.getCode();
        if (isExistRoleCode(tenantId, code))
        {
            throw new BusinessException(CommonErrorCode.E_110002);
        }
        //转换
        AuthorizationRole authorizationRole = dozerUtils.map(role, AuthorizationRole.class);
        authorizationRoleMapper.insert(authorizationRole);
    }

    /**
     * 判断角色编码是否在某租户下已存在
     *
     * @param tenantId 承租者id
     * @param roleCode 角色代码
     * @return boolean
     */
    private boolean isExistRoleCode(Long tenantId, String roleCode)
    {
        int i = authorizationRoleMapper.selectRoleCodeInTenant(tenantId, roleCode);
        return i > 0;
    }

    /**
     *
     * 删除租户内角色，如果有账号绑定该角色，禁止删除
     *
     * @param tenantId 承租者id
     * @param roleCode 角色代码
     */
    @Override
    public void removeRole(Long tenantId, String roleCode)
    {
        boolean b = accountMapper.selectAccountByRole(tenantId, roleCode);
        if (b)
        {
            throw new BusinessException(CommonErrorCode.E_110004);
        }
        AuthorizationRole role = authorizationRoleMapper.selectOne(new QueryWrapper<AuthorizationRole>().lambda()
                .eq(AuthorizationRole::getTenantId, tenantId).eq(AuthorizationRole::getCode, roleCode));
        if (role != null && role.getId() != null)
        {
            removeRole(role.getId());
        }

    }

    /**
     * 删除租户内角色
     *
     * @param id 角色id
     */
    @Override
    public void removeRole(Long id)
    {

        authorizationRoleMapper.deleteById(id);
    }

    /**
     *
     * 修改租户内角色(不包含权限)
     *
     * @param role 角色
     */
    @Override
    public void modifyRole(RoleDTO role)
    {
        //UpdateWrapper<AuthorizationRole> uw = new UpdateWrapper<>();
        //uw.lambda().eq(AuthorizationRole::getId,role.getId()).set(AuthorizationRole::getName,role.getName());
        //roleMapper.update(null,uw);
        AuthorizationRole authorizationRole = dozerUtils.map(role, AuthorizationRole.class);
        authorizationRoleMapper.updateById(authorizationRole);
    }

    /**
     * 角色设置权限(清除+设置)
     *
     * @param tenantId       租户id
     * @param roleCode       角色code
     * @param privilegeCodes 该角色对应的权限集合
     */
    @Override
    public void roleBindPrivilege(Long tenantId, String roleCode, String[] privilegeCodes)
    {

        //1.获取租户内的某个角色信息(包含权限信息)
        RoleDTO roleDTOS = queryTenantRole(tenantId, roleCode);
        if (privilegeCodes == null || privilegeCodes.length == 0)
        {
            throw new BusinessException(CommonErrorCode.E_110005);
        }
        //2.根据权限code获取权限实体集合
        List<AuthorizationPrivilege> privileges = authorizationPrivilegeMapper.selectList(new QueryWrapper<AuthorizationPrivilege>().lambda()
                .in(AuthorizationPrivilege::getCode, privilegeCodes));
        if (privileges.isEmpty())
        {
            throw new BusinessException(CommonErrorCode.E_110005);
        }

        //组装权限id集合
        List<Long> pids = new ArrayList<>();
        for (AuthorizationPrivilege p : privileges)
        {
            pids.add(p.getId());
        }

        //3.删除角色已关联的权限信息
        if (roleDTOS != null && roleDTOS.getId() != null)
        {
            Long roleId = roleDTOS.getId();
            //若角色已关联权限，清除
            authorizationRolePrivilegeMapper.delete(new QueryWrapper<AuthorizationRolePrivilege>().lambda()
                    .eq(AuthorizationRolePrivilege::getRoleId, roleId));
        }

        //4.将角色和权限进行关联操作authorization_role_privilege表
        authorizationRolePrivilegeMapper.insertRolePrivilege(roleDTOS.getId(), pids);
    }

    /**
     *
     * 查询某租户下角色(不分页，不包含权限)
     *
     * @param tenantId 承租者id
     * @return {@link List}<{@link RoleDTO}>
     */
    @Override
    public List<RoleDTO> queryRole(Long tenantId)
    {
        QueryWrapper<AuthorizationRole> qw = new QueryWrapper<>();
        qw.lambda().eq(AuthorizationRole::getTenantId, tenantId);
        List<AuthorizationRole> authorizationRoles = authorizationRoleMapper.selectList(qw);
        //转换
        List<RoleDTO> roleDTOS = dozerUtils.mapList(authorizationRoles, RoleDTO.class);
        return roleDTOS;
    }

    /**
     *
     * 根据roleCode获取角色(不包含权限)
     *
     * @param tenantId  承租者id
     * @param roleCodes 角色代码
     * @return {@link List}<{@link RoleDTO}>
     */
    @Override
    public List<RoleDTO> queryRole(Long tenantId, String... roleCodes)
    {
        List<String> codes = Arrays.asList(roleCodes);
        List<AuthorizationRole> authorizationRoles = authorizationRoleMapper.selectList(new QueryWrapper<AuthorizationRole>().lambda()
                .eq(AuthorizationRole::getTenantId, tenantId)
                .in(AuthorizationRole::getCode, codes));
        //转换
        List<RoleDTO> roleDTOS = dozerUtils.mapList(authorizationRoles, RoleDTO.class);
        return roleDTOS;
    }


    /**
     *
     * 获取租户内的某个角色信息(包含权限信息)
     *
     * @param tenantId 承租者id
     * @param roleCode 角色代码
     * @return {@link RoleDTO}
     */
    @Override
    public RoleDTO queryTenantRole(Long tenantId, String roleCode)
    {
        AuthorizationRole role = authorizationRoleMapper.selectOne(new QueryWrapper<AuthorizationRole>().lambda()
                .eq(AuthorizationRole::getTenantId, tenantId).eq(AuthorizationRole::getCode, roleCode));
        if (role == null)
        {
            throw new BusinessException(CommonErrorCode.E_110003);
        }
        Long id = role.getId();
        //转换
        RoleDTO roleDTO = dozerUtils.map(role, RoleDTO.class);
        roleDTO.setPrivilegeCodes(authorizationRoleMapper.selectPrivilegeByRole(id));

        return roleDTO;
    }

    /**
     * 绑定角色
     *
     * @param username  用户名
     * @param tenantId  租户id
     * @param roleCodes 角色列表
     */
    @Override
    public void bindAccountRole(String username, Long tenantId, String[] roleCodes)
    {
        //批量插入
        List<String> roleList = new ArrayList<>(Arrays.asList(roleCodes));
        accountRoleMapper.insertAccountRole(username, tenantId, roleList);
    }

    /**
     * 解绑角色
     *
     * @param username  用户名
     * @param tenantId  租户id
     * @param roleCodes 角色列表
     */
    @Override
    public void unbindAccountRole(String username, Long tenantId, String[] roleCodes)
    {
        List<String> roleList = new ArrayList<>(Arrays.asList(roleCodes));
        //根据查询到的角色id清除掉对应租户
        List<AuthorizationRole> roles = authorizationRoleMapper.selectList(new QueryWrapper<AuthorizationRole>().lambda()
                .eq(AuthorizationRole::getTenantId, tenantId)
                .in(AuthorizationRole::getCode, roleList));
        if (roles.isEmpty())
        {
            throw new BusinessException(CommonErrorCode.E_100104);
        }
        List<Long> roleIds = new ArrayList<>();
        for (AuthorizationRole role : roles)
        {
            Long id = role.getId();
            roleIds.add(id);
        }
        authorizationRoleMapper.update(null, new UpdateWrapper<AuthorizationRole>().lambda()
                .in(AuthorizationRole::getId, roleIds).set(AuthorizationRole::getTenantId, null));
        //根据账号-角色表id清除关系
        List<AccountRole> accountRoles = accountRoleMapper.selectList(new QueryWrapper<AccountRole>().lambda()
                .eq(AccountRole::getUsername, username).eq(AccountRole::getTenantId, tenantId)
                .in(AccountRole::getId, roleList));
        if (accountRoles.isEmpty())
        {
            throw new BusinessException(CommonErrorCode.E_100104);
        }
        List<Long> ids = new ArrayList<>();
        for (AccountRole accountRole : accountRoles)
        {
            Long id = accountRole.getId();
            ids.add(id);
        }
        accountRoleMapper.update(null, new UpdateWrapper<AccountRole>().lambda()
                .in(AccountRole::getId, ids).set(AccountRole::getRoleCode, null));

    }

    @Override
    public PageVO<RoleDTO> queryRoleByPage(RoleDTO roleDTO, Integer pageNo, Integer pageSize)
    {
        return buildRoleQuery(roleDTO, pageNo, pageSize);
    }


    /**
     * 建立角色查询
     *
     * @param roleDTO  角色dto
     * @param pageNo   页面号
     * @param pageSize 页面大小
     * @return {@link PageVO}<{@link RoleDTO}>
     */
    private PageVO<RoleDTO> buildRoleQuery(RoleDTO roleDTO, Integer pageNo, Integer pageSize)
    {
        // 创建分页
        Page<AuthorizationRole> page = new Page<>(pageNo, pageSize);
        // 构造查询条件
        QueryWrapper<AuthorizationRole> qw = new QueryWrapper<>();
        if (null != roleDTO && null != roleDTO.getTenantId())
        {
            qw.lambda().eq(AuthorizationRole::getTenantId, roleDTO.getTenantId());
        }
        if (null != roleDTO && null != roleDTO.getName())
        {
            qw.lambda().eq(AuthorizationRole::getName, roleDTO.getName());
        }
        // 执行查询
        IPage<AuthorizationRole> roleIPage = authorizationRoleMapper.selectPage(page, qw);
        // entity List转DTO List
        List<RoleDTO> roleList = dozerUtils.mapList(roleIPage.getRecords(), RoleDTO.class);
        // 封装结果集
        return new PageVO<>(roleList, roleIPage.getTotal(), pageNo, pageSize);
    }

}
