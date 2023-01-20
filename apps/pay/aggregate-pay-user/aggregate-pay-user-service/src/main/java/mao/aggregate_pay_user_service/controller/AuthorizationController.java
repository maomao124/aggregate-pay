package mao.aggregate_pay_user_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_user_api.dto.auth.AuthorizationInfoDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeTreeDTO;
import mao.aggregate_pay_user_api.dto.auth.RoleDTO;
import mao.aggregate_pay_user_service.service.AuthorizationService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.controller
 * Class(类名): AuthorizationController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/20
 * Time(创建时间)： 21:51
 * Version(版本): 1.0
 * Description(描述)： 统一账号-角色权限
 */

@Slf4j
@RestController
@Api(value = "统一账号-角色权限", tags = "统一账号-角色权限")
public class AuthorizationController extends BaseController
{
    @Resource
    private AuthorizationService authorizationService;


    /**
     * 授权
     *
     * @param username  用户名
     * @param tenantIds 租户id
     * @return {@link Map}<{@link Long}, {@link AuthorizationInfoDTO}>
     */
    @ApiOperation("授权，获取某用户在多个租户下的权限信息")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path"),
                    @ApiImplicitParam(name = "tenantIds", value = "多个租户的id", required = true, allowMultiple = true, dataType = "Long", paramType = "query")
            })
    @GetMapping("/tenants/{username}/privileges")
    public Map<Long, AuthorizationInfoDTO> authorize(@PathVariable String username, @RequestParam Long[] tenantIds)
    {
        Map<Long, AuthorizationInfoDTO> authorize = authorizationService.authorize(username, tenantIds);
        return authorize;
    }

    /**
     * 查询权限
     *
     * @param tenantId  承租者id
     * @param roleCodes 角色代码
     * @return {@link List}<{@link PrivilegeDTO}>
     */
    @ApiOperation("查找某租户下，多个角色的权限信息集合")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "roleCodes", value = "多个角色编码", required = true, allowMultiple = true, dataType = "String", paramType = "query")
            })
    @GetMapping("/tenants/{tenantId}/roles/privilege-list")
    public List<PrivilegeDTO> queryPrivilege(@PathVariable Long tenantId, @RequestParam String[] roleCodes)
    {
        return authorizationService.queryPrivilege(tenantId, roleCodes);
    }

    /**
     * 查询权限组id
     *
     * @param privilegeGroupId 权限组id
     * @return {@link List}<{@link PrivilegeDTO}>
     */
    @ApiOperation("获取权限组下所有权限")
    @ApiImplicitParam(name = "privilegeGroupId", value = "权限组的id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/privilege-groups/{privilegeGroupId}/privilege-list")
    public List<PrivilegeDTO> queryPrivilegeByGroupId(@PathVariable Long privilegeGroupId)
    {
        return authorizationService.queryPrivilegeByGroupId(privilegeGroupId);
    }

    /**
     * 查询权限树
     *
     * @param tenantId  承租者id
     * @param roleCodes 角色代码
     * @return {@link PrivilegeTreeDTO}
     */
    @ApiOperation("查找某租户下，多个角色的权限信息集合，并根据权限组组装成为权限树")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "roleCodes", value = "多个角色的编码", required = true, allowMultiple = true, dataType = "String", paramType = "query")
            })
    @GetMapping("/tenants/{tenantId}/roles/role-privilege-list")
    public PrivilegeTreeDTO queryPrivilegeTree(@PathVariable Long tenantId, @RequestParam String[] roleCodes)
    {
        return authorizationService.queryPrivilegeTree(tenantId, roleCodes);
    }


    //////////////////////////////////////////////////角色、权限///////////////////////////////////////////////////


    /**
     * 创建角色
     *
     * @param tenantId 承租者id
     * @param role     角色
     */
    @ApiOperation("创建租户内角色（不包含权限）")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "role", value = "角色信息", required = true, dataType = "RoleDTO", paramType = "body")
            })
    @PostMapping("/tenants/{tenantId}/roles")
    public void createRole(@PathVariable Long tenantId, @RequestBody RoleDTO role)
    {
        authorizationService.createRole(tenantId, role);
    }

    /**
     * 删除角色
     *
     * @param tenantId 承租者id
     * @param roleCode 角色代码
     */
    @ApiOperation("根据角色编码删除租户内角色，如果有账号绑定该角色，禁止删除")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "roleCode", value = "角色编码", required = true, dataType = "String", paramType = "path")
            })
    @DeleteMapping("/tenants/{tenantId}/roles/{roleCode}")
    public void removeRole(@PathVariable Long tenantId, @PathVariable String roleCode)
    {
        authorizationService.removeRole(tenantId, roleCode);
    }


    /**
     * 修改角色
     *
     * @param role 角色
     */
    @ApiOperation("修改租户内角色(不包含权限)")
    @ApiImplicitParam(name = "role", value = "角色信息", required = true, dataType = "RoleDTO", paramType = "body")
    @PutMapping("/tenants/roles")
    public void modifyRole(@RequestBody RoleDTO role)
    {
        authorizationService.modifyRole(role);
    }

    /**
     * 角色绑定特权
     *
     * @param tenantId       承租者id
     * @param roleCode       角色代码
     * @param privilegeCodes 特权代码
     */
    @ApiOperation("角色设置权限(清除+设置)")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "roleCode", value = "角色编码", required = true, dataType = "String", paramType = "path"),
                    @ApiImplicitParam(name = "privilegeCodes", value = "权限编码", required = true, allowMultiple = true, dataType = "String", paramType = "query")
            })
    @PutMapping("/tenants/{tenantId}/roles/{roleCode}/privileges")
    public void roleBindPrivilege(@PathVariable Long tenantId, @PathVariable String roleCode, @RequestParam String[] privilegeCodes)
    {
        authorizationService.roleBindPrivilege(tenantId, roleCode, privilegeCodes);
    }


    /**
     * 查询角色
     *
     * @param tenantId 承租者id
     * @return {@link List}<{@link RoleDTO}>
     */
    @ApiOperation("查询某租户下角色(不分页，不包含权限)")
    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/tenants/{tenantId}/roles")
    public List<RoleDTO> queryRole(@PathVariable Long tenantId)
    {
        return authorizationService.queryRole(tenantId);
    }


    /**
     * 查询角色
     *
     * @param tenantId  承租者id
     * @param roleCodes 角色代码
     * @return {@link List}<{@link RoleDTO}>
     */
    @ApiOperation("查根据roleCode获取角色(不包含权限)")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "roleCodes", value = "角色编码", required = true, allowMultiple = true, dataType = "String", paramType = "query")
            })
    @GetMapping("/roles/tenants/{tenantId}")
    public List<RoleDTO> queryRole(@PathVariable Long tenantId, @RequestParam String... roleCodes)
    {
        return authorizationService.queryRole(tenantId, roleCodes);
    }


    /**
     * 查询租户作用
     *
     * @param tenantId 承租者id
     * @param roleCode 角色代码
     * @return {@link RoleDTO}
     */
    @ApiOperation("获取租户内的某个角色信息(包含权限信息)")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "roleCodes", value = "角色编码", required = true, dataType = "String", paramType = "path")
            })
    @GetMapping("/tenants/{tenantId}/roles/{roleCode}/role-privilege")
    public RoleDTO queryTenantRole(@PathVariable Long tenantId, @PathVariable String roleCode)
    {
        return authorizationService.queryTenantRole(tenantId, roleCode);
    }

    @ApiOperation("绑定角色")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path"),
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "roleCodes", value = "角色编码", required = true, allowMultiple = true, dataType = "String", paramType = "query")
            })
    @PostMapping("/bind/tenants/{tenantId}/accounts/{username}/roles")
    public void bindAccountRole(@PathVariable String username, @PathVariable Long tenantId, @RequestParam String[] roleCodes)
    {
        authorizationService.bindAccountRole(username, tenantId, roleCodes);
    }

    /**
     * 解开帐户作用
     *
     * @param username  用户名
     * @param tenantId  承租者id
     * @param roleCodes 角色代码
     */
    @ApiOperation("解绑角色")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path"),
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "roleCodes", value = "角色编码", required = true, allowMultiple = true, dataType = "String", paramType = "query")
            })
    @PutMapping("/unbind/tenants/{tenantId}/accounts/{username}/roles")
    public void unbindAccountRole(@PathVariable String username, @PathVariable Long tenantId, @RequestParam String[] roleCodes)
    {
        authorizationService.unbindAccountRole(username, tenantId, roleCodes);
    }

}
