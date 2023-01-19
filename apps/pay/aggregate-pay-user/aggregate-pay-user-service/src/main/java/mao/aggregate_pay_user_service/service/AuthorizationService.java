package mao.aggregate_pay_user_service.service;

import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.auth.AuthorizationInfoDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeTreeDTO;
import mao.aggregate_pay_user_api.dto.auth.RoleDTO;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.service
 * Interface(接口名): AuthorizationService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 19:47
 * Version(版本): 1.0
 * Description(描述)： 授权服务：负责 用户-角色关系、角色、权限、等信息维护
 */


public interface AuthorizationService
{
    /**
     * 授权，获取某用户在多个租户下的权限信息
     *
     * @param username  用户名
     * @param tenantIds 租户id列表
     * @return key为租户id  value为租户下的角色权限信息
     */
    Map<Long, AuthorizationInfoDTO> authorize(String username, Long[] tenantIds);


    /**
     * 查找某租户下，多个角色的权限信息集合
     *
     * @param tenantId  承租者id
     * @param roleCodes 角色代码
     * @return List<PrivilegeTreeDTO>
     */
    List<PrivilegeDTO> queryPrivilege(Long tenantId, String[] roleCodes);


    /**
     * 获取权限组下所有权限
     *
     * @param privilegeGroupId 权限组ID
     * @return {@link List}<{@link PrivilegeDTO}>
     */
    List<PrivilegeDTO> queryPrivilegeByGroupId(Long privilegeGroupId);


    /**
     * 查找某租户下，多个角色的权限信息集合，并根据权限组组装成为权限树
     *
     * @param roleCodes 角色编码列表，为null时代表所有权限
     * @param tenantId  承租者id
     * @return {@link PrivilegeTreeDTO}
     */
    PrivilegeTreeDTO queryPrivilegeTree(Long tenantId, String[] roleCodes);



    //////////////////////////////////////////////////角色、权限///////////////////////////////////////////////////


    /**
     * 创建租户内角色（不包含权限）
     *
     * @param tenantId 承租者id
     * @param role     角色
     */
    void createRole(Long tenantId, RoleDTO role);


    /**
     * 删除租户内角色，如果有账号绑定该角色，禁止删除
     *
     * @param tenantId 承租者id
     * @param roleCode 角色代码
     */
    void removeRole(Long tenantId, String roleCode);


    /**
     * 删除租户内角色
     *
     * @param id 角色id
     */
    void removeRole(Long id);


    /**
     * 修改租户内角色(不包含权限)
     *
     * @param role 角色
     */
    void modifyRole(RoleDTO role);


    /**
     * 角色设置权限(清除+设置)
     *
     * @param tenantId       承租者id
     * @param roleCode       角色代码
     * @param privilegeCodes 特权代码
     */
    void roleBindPrivilege(Long tenantId, String roleCode, String[] privilegeCodes);


    /**
     * 查询某租户下角色(不分页，不包含权限)
     *
     * @param tenantId 承租者id
     * @return {@link List}<{@link RoleDTO}>
     */
    List<RoleDTO> queryRole(Long tenantId);


    /**
     * 根据roleCode获取角色(不包含权限)
     *
     * @param tenantId  承租者id
     * @param roleCodes 角色代码
     * @return {@link List}<{@link RoleDTO}>
     */
    List<RoleDTO> queryRole(Long tenantId, String... roleCodes);


    /**
     * 获取租户内的某个角色信息(包含权限信息)
     *
     * @param tenantId 承租者id
     * @param roleCode 角色代码
     * @return {@link RoleDTO}
     */
    RoleDTO queryTenantRole(Long tenantId, String roleCode);


    /**
     * 绑定角色
     *
     * @param username  用户名
     * @param tenantId  租户id
     * @param roleCodes 角色列表
     */
    void bindAccountRole(String username, Long tenantId, String[] roleCodes);


    /**
     * 解绑角色
     *
     * @param username  用户名
     * @param tenantId  租户id
     * @param roleCodes 角色列表
     */
    void unbindAccountRole(String username, Long tenantId, String[] roleCodes);


    /**
     * 分页查询角色
     *
     * @param roleDTO  角色dto
     * @param pageNo   页面没有
     * @param pageSize 页面大小
     * @return {@link PageVO}<{@link RoleDTO}>
     */
    PageVO<RoleDTO> queryRoleByPage(RoleDTO roleDTO, Integer pageNo, Integer pageSize);
}
