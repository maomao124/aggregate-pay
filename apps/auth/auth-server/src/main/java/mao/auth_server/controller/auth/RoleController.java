package mao.auth_server.controller.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.*;
import mao.auth_entity.entity.auth.Role;
import mao.auth_entity.entity.auth.RoleAuthority;
import mao.auth_entity.entity.auth.UserRole;
import mao.auth_entity.enumeration.auth.AuthorizeType;
import mao.auth_server.service.auth.RoleAuthorityService;
import mao.auth_server.service.auth.RoleOrgService;
import mao.auth_server.service.auth.RoleService;
import mao.auth_server.service.auth.UserRoleService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_core.base.entity.SuperEntity;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import mao.tools_log.annotation.SysLog;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static mao.tools_core.base.R.success;
import static mao.tools_core.context.BaseContextHandler.getUserId;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.auth
 * Class(类名): RoleController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/12
 * Time(创建时间)： 20:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/role")
@Api(value = "RoleController", tags = "角色")
public class RoleController extends BaseController
{

    @Resource
    private RoleService roleService;

    @Resource
    private RoleAuthorityService roleAuthorityService;

    @Resource
    private RoleOrgService roleOrgService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private DozerUtils dozerUtils;

    /**
     * 分页查询角色
     */
    @ApiOperation(value = "分页查询角色", notes = "分页查询角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    @SysLog("分页查询角色")
    public R<IPage<Role>> page(RolePageDTO param)
    {
        IPage<Role> page = getPage();
        Role role = dozerUtils.map(param, Role.class);
        // 构建值不为null的查询条件
        LbqWrapper<Role> query = Wraps.lbQ(role)
                .geHeader(Role::getCreateTime, param.getStartCreateTime())
                .leFooter(Role::getCreateTime, param.getEndCreateTime())
                .orderByDesc(Role::getId);
        roleService.page(page, query);
        return success(page);
    }

    /**
     * 查询角色
     */
    @ApiOperation(value = "查询角色", notes = "查询角色")
    @GetMapping("/{id}")
    @SysLog("查询角色")
    public R<RoleQueryDTO> get(@PathVariable Long id)
    {
        Role role = roleService.getById(id);

        RoleQueryDTO roleQueryDTO = dozerUtils.map(role, RoleQueryDTO.class);
        List<Long> orgList = roleOrgService.listOrgByRoleId(role.getId());
        roleQueryDTO.setOrgList(orgList);

        return success(roleQueryDTO);
    }

    @ApiOperation(value = "检测角色编码", notes = "检测角色编码")
    @GetMapping("/check/{code}")
    @SysLog("检测角色编码")
    @Transactional
    public R<Boolean> check(@PathVariable String code)
    {
        return success(roleService.check(code));
    }


    /**
     * 新增角色
     */
    @ApiOperation(value = "新增角色", notes = "新增角色不为空的字段")
    @PostMapping
    @SysLog("新增角色")
    @Transactional
    public R<RoleSaveDTO> save(@RequestBody @Validated RoleSaveDTO data)
    {
        roleService.saveRole(data, getUserId());
        return success(data);
    }

    /**
     * 修改角色
     */
    @ApiOperation(value = "修改角色", notes = "修改角色不为空的字段")
    @PutMapping
    @SysLog("修改角色")
    @Transactional
    public R<RoleUpdateDTO> update(@RequestBody @Validated(SuperEntity.Update.class) RoleUpdateDTO data)
    {
        roleService.updateRole(data, getUserId());
        return success(data);
    }

    /**
     * 删除角色
     */
    @Transactional
    @ApiOperation(value = "删除角色", notes = "根据id物理删除角色")
    @DeleteMapping
    @SysLog("删除角色")
    public R<Boolean> delete(@RequestParam("ids[]") List<Long> ids)
    {
        roleService.removeById(ids);
        return success(true);
    }

    /**
     * 给用户分配角色
     */
    @Transactional
    @ApiOperation(value = "给用户分配角色", notes = "给用户分配角色")
    @PostMapping("/user")
    @SysLog("给角色分配用户")
    public R<Boolean> saveUserRole(@RequestBody UserRoleSaveDTO userRole)
    {
        return success(roleAuthorityService.saveUserRole(userRole));
    }

    /**
     * 查询角色的用户
     */
    @ApiOperation(value = "查询角色的用户", notes = "查询角色的用户")
    @GetMapping("/user/{roleId}")
    @SysLog("查询角色的用户")
    public R<List<Long>> findUserIdByRoleId(@PathVariable Long roleId)
    {
        List<UserRole> list = userRoleService.list(Wraps.<UserRole>lbQ().eq(UserRole::getRoleId, roleId));
        return success(list.stream().mapToLong(UserRole::getUserId).boxed().collect(Collectors.toList()));
    }

    /**
     * 查询角色拥有的资源id
     */
    @ApiOperation(value = "查询角色拥有的资源id集合", notes = "查询角色拥有的资源id集合")
    @GetMapping("/authority/{roleId}")
    @SysLog("查询角色拥有的资源")
    public R<RoleAuthoritySaveDTO> findAuthorityIdByRoleId(@PathVariable Long roleId)
    {
        List<RoleAuthority> list = roleAuthorityService.list(Wraps.<RoleAuthority>lbQ().eq(RoleAuthority::getRoleId, roleId));
        List<Long> menuIdList = list.stream().filter(item -> AuthorizeType.MENU.eq(item.getAuthorityType())).mapToLong(RoleAuthority::getAuthorityId).boxed().collect(Collectors.toList());
        List<Long> resourceIdList = list.stream().filter(item -> AuthorizeType.RESOURCE.eq(item.getAuthorityType())).mapToLong(RoleAuthority::getAuthorityId).boxed().collect(Collectors.toList());
        RoleAuthoritySaveDTO roleAuthority = RoleAuthoritySaveDTO.builder()
                .menuIdList(menuIdList).resourceIdList(resourceIdList)
                .build();
        return success(roleAuthority);
    }


    /**
     * 给角色配置权限
     */
    @Transactional
    @ApiOperation(value = "给角色配置权限", notes = "给角色配置权限")
    @PostMapping("/authority")
    @SysLog("给角色配置权限")
    public R<Boolean> saveRoleAuthority(@RequestBody RoleAuthoritySaveDTO roleAuthoritySaveDTO)
    {
        return success(roleAuthorityService.saveRoleAuthority(roleAuthoritySaveDTO));
    }


    /**
     * 根据角色编码查询用户ID
     */
    @ApiOperation(value = "根据角色编码查询用户ID", notes = "根据角色编码查询用户ID")
    @GetMapping("/codes")
    @SysLog("根据角色编码查询用户ID")
    public R<List<Long>> findUserIdByCode(@RequestParam(value = "codes") String[] codes)
    {
        return success(roleService.findUserIdByCode(codes));
    }

}
