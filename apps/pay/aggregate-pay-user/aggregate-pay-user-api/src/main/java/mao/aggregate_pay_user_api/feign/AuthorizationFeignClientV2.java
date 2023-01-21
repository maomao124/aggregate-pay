package mao.aggregate_pay_user_api.feign;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_user_api.dto.auth.AuthorizationInfoDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeTreeDTO;
import mao.aggregate_pay_user_api.dto.auth.RoleDTO;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.feign
 * Interface(接口名): AuthorizationFeignClientV2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/20
 * Time(创建时间)： 22:23
 * Version(版本): 2.0
 * Description(描述)： feign接口
 */

@FeignClient(value = "aggregate-pay-user-service", path = "/v2")
public interface AuthorizationFeignClientV2
{

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
    R<Map<Long, AuthorizationInfoDTO>> authorize(@PathVariable String username, @RequestParam Long[] tenantIds);

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
    R<List<PrivilegeDTO>> queryPrivilege(@PathVariable Long tenantId, @RequestParam String[] roleCodes);

    /**
     * 查询权限组id
     *
     * @param privilegeGroupId 权限组id
     * @return {@link List}<{@link PrivilegeDTO}>
     */
    @ApiOperation("获取权限组下所有权限")
    @ApiImplicitParam(name = "privilegeGroupId", value = "权限组的id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/privilege-groups/{privilegeGroupId}/privilege-list")
    R<List<PrivilegeDTO>> queryPrivilegeByGroupId(@PathVariable Long privilegeGroupId);

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
    R<PrivilegeTreeDTO> queryPrivilegeTree(@PathVariable Long tenantId, @RequestParam String[] roleCodes);


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
    R<Boolean> createRole(@PathVariable Long tenantId, @RequestBody RoleDTO role);

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
    R<Boolean> removeRole(@PathVariable Long tenantId, @PathVariable String roleCode);


    /**
     * 修改角色
     *
     * @param role 角色
     */
    @ApiOperation("修改租户内角色(不包含权限)")
    @ApiImplicitParam(name = "role", value = "角色信息", required = true, dataType = "RoleDTO", paramType = "body")
    @PutMapping("/tenants/roles")
    R<Boolean> modifyRole(@RequestBody RoleDTO role);

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
    R<Boolean> roleBindPrivilege(@PathVariable Long tenantId, @PathVariable String roleCode, @RequestParam String[] privilegeCodes);


    /**
     * 查询角色
     *
     * @param tenantId 承租者id
     * @return {@link List}<{@link RoleDTO}>
     */
    @ApiOperation("查询某租户下角色(不分页，不包含权限)")
    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/tenants/{tenantId}/roles")
    R<List<RoleDTO>> queryRole(@PathVariable Long tenantId);


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
    R<List<RoleDTO>> queryRole(@PathVariable Long tenantId, @RequestParam String... roleCodes);


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
    R<RoleDTO> queryTenantRole(@PathVariable Long tenantId, @PathVariable String roleCode);

    @ApiOperation("绑定角色")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path"),
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "roleCodes", value = "角色编码", required = true, allowMultiple = true, dataType = "String", paramType = "query")
            })
    @PostMapping("/bind/tenants/{tenantId}/accounts/{username}/roles")
    R<Boolean> bindAccountRole(@PathVariable String username, @PathVariable Long tenantId, @RequestParam String[] roleCodes);

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
    R<Boolean> unbindAccountRole(@PathVariable String username, @PathVariable Long tenantId, @RequestParam String[] roleCodes);
}
