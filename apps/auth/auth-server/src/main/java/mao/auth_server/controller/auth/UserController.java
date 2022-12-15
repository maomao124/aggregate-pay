package mao.auth_server.controller.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.*;
import mao.auth_entity.entity.auth.Role;
import mao.auth_entity.entity.auth.User;
import mao.auth_entity.entity.core.Org;
import mao.auth_server.service.auth.RoleService;
import mao.auth_server.service.auth.UserService;
import mao.auth_server.service.core.OrgService;
import mao.auth_server.service.core.StationService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_core.base.entity.SuperEntity;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import mao.tools_log.annotation.SysLog;
import mao.tools_user.entity.SysOrg;
import mao.tools_user.entity.SysRole;
import mao.tools_user.entity.SysStation;
import mao.tools_user.entity.SysUser;
import mao.tools_user.feign.UserQuery;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.auth
 * Class(类名): UserController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/12
 * Time(创建时间)： 20:35
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/user")
@Api(value = "UserController", tags = "用户")
public class UserController extends BaseController
{
    @Resource
    private UserService userService;

    @Resource
    private OrgService orgService;

    @Resource
    private RoleService roleService;

    @Resource
    private StationService stationService;

    @Resource
    private DozerUtils dozerUtils;

    /**
     * 分页查询用户
     *
     * @param userPage 用户页面
     * @return {@link R}<{@link IPage}<{@link User}>>
     */
    @ApiOperation(value = "分页查询用户", notes = "分页查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "页码", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "分页条数", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    @SysLog("分页查询用户")
    public R<IPage<User>> page(UserPageDTO userPage)
    {
        IPage<User> page = getPage();

        User user = UserController.this.dozerUtils.map2(userPage, User.class);
        if (userPage.getOrgId() != null && userPage.getOrgId() >= 0)
        {
            user.setOrgId(null);
        }
        LbqWrapper<User> wrapper = Wraps.lbQ(user);
        if (userPage.getOrgId() != null && userPage.getOrgId() >= 0)
        {
            List<Org> children = orgService.findChildren(Collections.singletonList(userPage.getOrgId()));
            wrapper.in(User::getOrgId, children.stream().mapToLong(Org::getId).boxed().collect(Collectors.toList()));
        }
        wrapper.geHeader(User::getCreateTime, userPage.getStartCreateTime())
                .leFooter(User::getCreateTime, userPage.getEndCreateTime())
                .like(User::getName, userPage.getName())
                .like(User::getAccount, userPage.getAccount())
                .like(User::getEmail, userPage.getEmail())
                .like(User::getMobile, userPage.getMobile())
                .eq(User::getSex, userPage.getSex())
                .eq(User::getStatus, userPage.getStatus())
                .orderByDesc(User::getId);
        //userService.page(page, wrapper);

        userService.findPage(page, wrapper);
        return success(page);
    }

    /**
     * 查询用户
     *
     * @param id id
     * @return {@link R}<{@link User}>
     */
    @ApiOperation(value = "查询用户", notes = "查询用户")
    @GetMapping("/{id}")
    @SysLog("查询用户")
    public R<User> get(@PathVariable Long id)
    {
        return success(userService.getById(id));
    }


    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @GetMapping("/find")
    @SysLog("查询所有用户")
    public R<List<Long>> findAllUserId()
    {
        return success(userService.list().stream().mapToLong(User::getId).boxed().collect(Collectors.toList()));
    }

    /**
     * 新增用户
     *
     * @param data 数据
     * @return {@link R}<{@link User}>
     */
    @Transactional
    @ApiOperation(value = "新增用户", notes = "新增用户不为空的字段")
    @PostMapping
    @SysLog("新增用户")
    public R<User> save(@RequestBody @Validated UserSaveDTO data)
    {
        User user = UserController.this.dozerUtils.map(data, User.class);
        userService.saveUser(user);
        return success(user);
    }

    /**
     * 修改用户
     *
     * @param data 数据
     * @return {@link R}<{@link User}>
     */
    @Transactional
    @ApiOperation(value = "修改用户", notes = "修改用户不为空的字段")
    @PutMapping
    @SysLog("修改用户")
    public R<User> update(@RequestBody @Validated(SuperEntity.Update.class) UserUpdateDTO data)
    {
        User user = UserController.this.dozerUtils.map(data, User.class);
        userService.updateUser(user);
        return success(user);
    }

    /**
     * 修改头像
     *
     * @param data 数据
     * @return {@link R}<{@link User}>
     */
    @Transactional
    @ApiOperation(value = "修改头像", notes = "修改头像")
    @PutMapping("/avatar")
    @SysLog("修改头像")
    public R<User> avatar(@RequestBody @Validated(SuperEntity.Update.class) UserUpdateAvatarDTO data)
    {
        User user = UserController.this.dozerUtils.map(data, User.class);
        userService.updateUser(user);
        return success(user);
    }

    /**
     * 修改密码
     *
     * @param data 数据
     * @return {@link R}<{@link Boolean}>
     */
    @Transactional
    @ApiOperation(value = "修改密码", notes = "修改密码")
    @PutMapping("/password")
    @SysLog("修改密码")
    public R<Boolean> updatePassword(@RequestBody UserUpdatePasswordDTO data)
    {
        return success(userService.updatePassword(data));
    }

    /**
     * 重置密码
     *
     * @param ids id
     * @return {@link R}<{@link Boolean}>
     */
    @Transactional
    @ApiOperation(value = "重置密码", notes = "重置密码")
    @GetMapping("/reset")
    @SysLog("重置密码")
    public R<Boolean> resetTx(@RequestParam("ids[]") List<Long> ids)
    {
        userService.reset(ids);
        return success();
    }

    /**
     * 删除用户
     *
     * @param ids id
     * @return {@link R}<{@link Boolean}>
     */
    @Transactional
    @ApiOperation(value = "删除用户", notes = "根据id物理删除用户")
    @DeleteMapping
    @SysLog("删除用户")
    public R<Boolean> delete(@RequestParam("ids[]") List<Long> ids)
    {
        userService.removeUser(ids);
        return success(true);
    }


    /**
     * 单体查询用户
     *
     * @param id    id
     * @param query 查询
     * @return {@link R}<{@link SysUser}>
     */
    @ApiOperation(value = "查询用户详细", notes = "查询用户详细")
    @PostMapping(value = "/anno/id/{id}")
    public R<SysUser> getById(@PathVariable Long id, @RequestBody UserQuery query)
    {
        User user = userService.getById(id);
        if (user == null)
        {
            return success(null);
        }
        SysUser sysUser = UserController.this.dozerUtils.map(user, SysUser.class);

        if (query.getFull() || query.getOrg())
        {
            sysUser.setOrg(UserController.this.dozerUtils.map(orgService.getById(user.getOrgId()), SysOrg.class));
        }
        if (query.getFull() || query.getStation())
        {
            sysUser.setStation(UserController.this.dozerUtils.map(stationService.getById(user.getStationId()), SysStation.class));
        }

        if (query.getFull() || query.getRoles())
        {
            List<Role> list = roleService.findRoleByUserId(id);
            sysUser.setRoles(UserController.this.dozerUtils.mapList(list, SysRole.class));
        }

        return success(sysUser);
    }

    /**
     * 查询角色的已关联用户
     *
     * @param roleId  角色id
     * @param keyword 账号account或名称name
     * @return {@link R}<{@link UserRoleDTO}>
     */
    @ApiOperation(value = "查询角色的已关联用户", notes = "查询角色的已关联用户")
    @GetMapping(value = "/role/{roleId}")
    public R<UserRoleDTO> findUserByRoleId(@PathVariable("roleId") Long roleId, @RequestParam(value = "keyword", required = false) String keyword)
    {
        List<User> list = userService.findUserByRoleId(roleId, keyword);
        List<Long> idList = list.stream().mapToLong(User::getId).boxed().collect(Collectors.toList());
        return success(UserRoleDTO.builder().idList(idList).userList(list).build());
    }
}
