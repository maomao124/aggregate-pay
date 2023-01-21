package mao.aggregate_pay_user_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.dto.tenant.*;
import mao.aggregate_pay_user_service.service.TenantService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.controller
 * Class(类名): TenantControllerV2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/21
 * Time(创建时间)： 13:23
 * Version(版本): 1.0
 * Description(描述)： 统一账号-租户、套餐、账号相关V2.0
 */


@Slf4j
@RestController
@RequestMapping("/v2")
@Api(value = "统一账号-租户、套餐、账号相关V2.0", tags = "统一账号-租户、套餐、账号相关V2.0")
public class TenantControllerV2 extends BaseController
{
    /**
     * 租户服务
     */
    @Resource
    private TenantService tenantService;


    /**
     * 创建租户
     *
     * @param createTenantRequest 创建租户请求
     * @return {@link TenantDTO}
     */
    @ApiOperation("创建租户")
    @ApiImplicitParam(name = "createTenantRequest", value = "创建租户参数信息", required = true, dataType = "CreateTenantRequestDTO", paramType = "body")
    @PostMapping("/tenants")
    public R<TenantDTO> createTenantAndInit(@RequestBody CreateTenantRequestDTO createTenantRequest)
    {
        TenantDTO tenant = tenantService.createTenantAndAccount(createTenantRequest);
        return success(tenant);
    }


    /**
     * 创建租户并关联账号
     *
     * @param createTenantRequest 创建租户请求
     * @return {@link TenantDTO}
     */
    @ApiOperation("创建租户并关联账号")
    @ApiImplicitParam(name = "createTenantRequest", value = "创建租户参数信息", required = true, dataType = "CreateTenantRequestDTO", paramType = "body")
    @PostMapping("/tenantRelateAccount")
    public R<TenantDTO> createTenantRelateAccount(@RequestBody CreateTenantRequestDTO createTenantRequest)
    {
        return success(tenantService.createTenantRelateAccount(createTenantRequest));
    }


    /**
     * 获取租户信息
     *
     * @param id id
     * @return {@link TenantDTO}
     */
    @ApiOperation("获取租户信息")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path", example = "1")
            })
    @GetMapping("/tenants/{id}")
    public R<TenantDTO> getTenant(@PathVariable Long id)
    {
        return success(tenantService.getTenant(id));
    }


    /**
     * 查询租户
     *
     * @param tenantQuery 房客查询
     * @param pageNo      页号
     * @param pageSize    页面大小
     * @param sortBy      排序
     * @param order       订单
     * @return {@link PageVO}<{@link TenantDTO}>
     */
    @ApiOperation("检索租户")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantQuery", value = "租户检索参数", dataType = "TenantQueryDTO", paramType = "body"),
                    @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "sortBy", value = "排序字段", required = true, dataType = "String", paramType = "query"),
                    @ApiImplicitParam(name = "order", value = "顺序", required = true, dataType = "String", paramType = "query")
            })
    @PostMapping("/tenants/page")
    public R<PageVO<TenantDTO>> queryTenants(@RequestBody TenantQueryDTO tenantQuery,
                                             @RequestParam Integer pageNo, @RequestParam Integer pageSize,
                                             @RequestParam String sortBy, @RequestParam String order)
    {
        return success(tenantService.queryTenants(tenantQuery, pageNo, pageSize, sortBy, order));
    }


    /**
     * 查询某租户类型的套餐列表
     *
     * @param tenantType 租客类型
     * @return {@link List}<{@link BundleDTO}>
     */
    @ApiOperation("查询某租户类型的套餐列表(不包含初始化套餐)")
    @ApiImplicitParam(name = "tenantType", value = "租户类型", required = true, dataType = "String", paramType = "path")
    @GetMapping("/bundles/tenant-types/{tenantType}/bundle-list")
    public R<List<BundleDTO>> queryBundleByTenantType(@PathVariable String tenantType)
    {
        return success(tenantService.queryBundleByTenantType(tenantType));
    }


    ////////////////////套餐管理start//////////////


    /**
     * 获取某套餐信息
     *
     * @param bundleCode 包代码
     * @return {@link BundleDTO}
     */
    @ApiOperation("获取某套餐信息")
    @ApiImplicitParam(name = "bundleCode", value = "租户套餐", required = true, dataType = "String", paramType = "path")
    @GetMapping("/bundles/{bundleCode}")
    public R<BundleDTO> getBundle(@PathVariable String bundleCode)
    {
        return success(tenantService.getBundle(bundleCode));
    }


    /**
     * 查询所有套餐
     *
     * @return {@link List}<{@link BundleDTO}>
     */
    @ApiOperation("查询所有套餐")
    @GetMapping("/bundles/bundle-list")
    public R<List<BundleDTO>> queryAllBundle()
    {
        return success(tenantService.queryAllBundle());
    }


    /**
     * 切换租户套餐
     *
     * @param tenantId   承租者id
     * @param bundleCode 包代码
     */
    @ApiOperation("切换租户套餐")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "bundleCode", value = "套餐编码", required = true, dataType = "String", paramType = "path")
            })
    @PutMapping("/tenants/{tenantId}/bundles/{bundleCode}")
    public R<Boolean> changeBundle(@PathVariable Long tenantId, @PathVariable String bundleCode)
    {
        tenantService.changeBundle(tenantId, bundleCode);
        return success();
    }


    /**
     * 初始化租户套餐
     *
     * @param tenantId   承租者id
     * @param bundleCode 包代码
     */
    @ApiOperation("初始化租户套餐")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "bundleCode", value = "套餐编码", required = true, dataType = "String", paramType = "path")
            })
    @PostMapping("/tenants/{tenantId}/bundles/{bundleCode}")
    public R<Boolean> initBundle(@PathVariable Long tenantId, @PathVariable String bundleCode)
    {
        tenantService.initBundle(tenantId, bundleCode);
        return success();
    }


    /**
     * 新增套餐
     *
     * @param bundleDTO 包dto
     */
    @ApiOperation("新增套餐")
    @ApiImplicitParam(name = "bundleDTO", value = "套餐信息", required = true, dataType = "BundleDTO", paramType = "body")
    @PostMapping("/bundles")
    public R<Boolean> createBundle(@RequestBody BundleDTO bundleDTO)
    {
        tenantService.createBundle(bundleDTO);
        return success();
    }


    /**
     * 更新套餐
     *
     * @param bundleDTO 包dto
     */
    @ApiOperation("更新套餐")
    @ApiImplicitParam(name = "bundleDTO", value = "套餐信息", required = true, dataType = "BundleDTO", paramType = "body")
    @PutMapping("/bundles")
    public R<Boolean> modifyBundle(@RequestBody BundleDTO bundleDTO)
    {
        tenantService.modifyBundle(bundleDTO);
        return success();
    }


    ////////////////////套餐管理end/////////////////////


    /**
     * 创建账户
     *
     * @param createAccountRequest 创建帐户请求
     * @return {@link AccountDTO}
     */
    @ApiOperation("创建账号")
    @ApiImplicitParam(name = "createAccountRequest", value = "创建账号请求参数", required = true, dataType = "CreateAccountRequestDTO", paramType = "body")
    @PostMapping("/accounts")
    public R<AccountDTO> createAccount(@RequestBody CreateAccountRequestDTO createAccountRequest)
    {
        return success(tenantService.createAccount(createAccountRequest));
    }


    /**
     * 创建账户
     *
     * @param accountPwdRequest 账户pwd请求
     * @return {@link Boolean}
     */
    @ApiOperation("创建账号")
    @ApiImplicitParam(name = "accountPwdRequest", value = "修改账号请求参数", required = true, dataType = "ChangeAccountPwdDTO", paramType = "body")
    @PostMapping("/accounts/password")
    public R<Boolean> createAccount(@RequestBody ChangeAccountPwdDTO accountPwdRequest)
    {
        return success(tenantService.accountPassword(accountPwdRequest));
    }


    /**
     * 创建账号并绑定至某租户
     *
     * @param createAccountRequest 创建帐户请求
     * @param tenantId             承租者id
     */
    @ApiOperation("创建账号并绑定至某租户")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "createAccountRequest", value = "创建账号请求参数", required = true, dataType = "CreateAccountRequestDTO", paramType = "body"),
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path", example = "1")
            })
    @PostMapping("/accounts/tenants/{tenantId}")
    public R<Boolean> createAccountInTenant(@RequestBody CreateAccountRequestDTO createAccountRequest, @PathVariable Long tenantId)
    {
        tenantService.createAccountInTenant(createAccountRequest, tenantId);
        return success();
    }


    /**
     * 将已存在账号，加入到某租户
     *
     * @param tenantId 承租者id
     * @param username 用户名
     */
    @ApiOperation("将已存在账号，加入到某租户")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path")
            })
    @PostMapping("/bind/accounts/{username}/tenants/{tenantId}")
    public R<Boolean> bindTenant(@PathVariable Long tenantId, @PathVariable String username)
    {
        tenantService.bindTenant(tenantId, username);
        return success();
    }


    /**
     * 将某账号从租户内移除
     *
     * @param tenantId 承租者id
     * @param username 用户名
     */
    @ApiOperation("将某账号从租户内移除，租户管理员不可移除")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path")
            })
    @DeleteMapping("/unbind/accounts/{username}/tenants/{tenantId}")
    public R<Boolean> unbindTenant(@PathVariable Long tenantId, @PathVariable String username)
    {
        tenantService.unbindTenant(tenantId, username);
        return success();
    }


    /**
     * 根据用户名判断账号是否存在
     *
     * @param username 用户名
     * @return boolean
     */
    @ApiOperation("根据用户名判断账号是否存在")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path")
    @GetMapping("/exist/accounts/name/{username}")
    public R<Boolean> isExistAccountByUsername(@PathVariable String username)
    {
        return success(tenantService.isExistAccountByUsername(username));

    }


    /**
     * 根据手机号判断账号是否存在
     *
     * @param mobile 移动
     * @return boolean
     */
    @ApiOperation("根据手机号判断账号是否存在")
    @ApiImplicitParam(name = "mobile", value = "手机号", required = true, dataType = "String", paramType = "path")
    @GetMapping("/exist/accounts/mobile/{mobile}")
    public R<Boolean> isExistAccountByMobile(@PathVariable String mobile)
    {
        return success(tenantService.isExistAccountByMobile(mobile));
    }


    /**
     * 根据用户名获取账号信息
     *
     * @param username 用户名
     * @return {@link AccountDTO}
     */
    @ApiOperation("根据用户名获取账号信息")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path")
    @GetMapping("/account-information/name/{username}")
    public R<AccountDTO> getAccountByUsername(@PathVariable String username)
    {
        return success(tenantService.getAccountByUsername(username));
    }


    /**
     * 根据手机号获取账号信息
     *
     * @param mobile 移动
     * @return {@link AccountDTO}
     */
    @ApiOperation("根据手机号获取账号信息")
    @ApiImplicitParam(name = "mobile", value = "手机号", required = true, dataType = "String", paramType = "path")
    @GetMapping("/accounts-information/mobile/{mobile}")
    public R<AccountDTO> getAccountByMobile(@PathVariable String mobile)
    {
        return success(tenantService.getAccountByMobile(mobile));
    }


    /**
     * 根据用户名判断账号是否在某租户内
     *
     * @param tenantId 承租者id
     * @param username 用户名
     * @return boolean
     */
    @ApiOperation("根据用户名判断账号是否在某租户内")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path")
            })
    @GetMapping("/exist/accounts/{username}/tenants/{tenantId}")
    public R<Boolean> isExistAccountInTenantByUsername(@PathVariable Long tenantId, @PathVariable String username)
    {
        return success(tenantService.isExistAccountInTenantByUsername(tenantId, username));
    }


    /**
     * 根据手机号判断账号是否在某租户内
     *
     * @param tenantId 承租者id
     * @param mobile   移动
     * @return boolean
     */
    @ApiOperation("根据手机号判断账号是否在某租户内")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "tenantId", value = "租户id", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "mobile", value = "手机号", required = true, dataType = "String", paramType = "path")
            })
    @GetMapping("/exist/accounts/tenants/{tenantId}/mobiles/{mobile}")
    public R<Boolean> isExistAccountInTenantByMobile(@PathVariable Long tenantId, @PathVariable String mobile)
    {
        return success(tenantService.isExistAccountInTenantByMobile(tenantId, mobile));
    }


    /**
     * 查询账户
     *
     * @param accountQuery 账户查询
     * @param pageNo       页号
     * @param pageSize     页面大小
     * @param sortBy       排序
     * @param order        订单
     * @return {@link PageVO}<{@link AccountDTO}>
     */
    @ApiOperation("检索账号")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "accountQuery", value = "账号检索参数", dataType = "AccountQueryDTO", paramType = "body"),
                    @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "sortBy", value = "排序字段", required = true, dataType = "String", paramType = "query"),
                    @ApiImplicitParam(name = "order", value = "顺序", required = true, dataType = "String", paramType = "query")
            })
    @PostMapping("/accounts/page")
    public R<PageVO<AccountDTO>> queryAccount(@RequestBody AccountQueryDTO accountQuery, @RequestParam Integer pageNo,
                                              @RequestParam Integer pageSize, @RequestParam String sortBy, @RequestParam String order)
    {
        return success(tenantService.queryAccount(accountQuery, pageNo, pageSize, sortBy, order));
    }


    /**
     * 查询某账号所属租户列表
     *
     * @param username 用户名
     * @return {@link List}<{@link TenantDTO}>
     */
    @ApiOperation("查询某账号所属租户列表")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path")
    @GetMapping("/accounts/tenant-list/{username}")
    public R<List<TenantDTO>> queryAccountInTenant(@PathVariable String username)
    {
        return success(tenantService.queryAccountInTenant(username));
    }


    /**
     * 发送短信验证码
     *
     * @param phone 电话
     * @return {@link String}
     */
    @ApiOperation("发送短信验证码")
    @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getMessage")
    public R<String> sendMessage(@RequestParam String phone)
    {
        return success(tenantService.sendMessage(phone));
    }


    /**
     * 身份验证
     *
     * @param authenticationInfo 身份验证信息
     * @return {@link AccountDTO}
     */
    @ApiOperation("用户认证")
    @ApiImplicitParam(name = "authenticationInfo", value = "认证信息", required = true, dataType = "AuthenticationInfo", paramType = "body")
    @PostMapping("/authentication")
    public R<AccountDTO> authentication(@RequestBody AuthenticationInfo authenticationInfo)
    {
        return success(tenantService.authentication(authenticationInfo));
    }


    /**
     * 登录
     *
     * @param loginRequest 登录请求
     * @return {@link LoginInfoDTO}
     */
    @ApiOperation("用户登录")
    @ApiImplicitParam(name = "loginRequest", value = "登录请求参数", required = true, dataType = "LoginRequestDTO", paramType = "body")
    @PostMapping("/login")
    public R<LoginInfoDTO> login(@RequestBody LoginRequestDTO loginRequest)
    {
        return success(tenantService.login(loginRequest));
    }


    /**
     * 根据接入客户端获取应用
     *
     * @param clientId 客户机id
     * @return {@link ApplicationDTO}
     */
    @ApiOperation("根据接入客户端获取应用")
    @ApiImplicitParam(name = "clientId", value = "客户端id", required = true, dataType = "String", paramType = "path")
    @GetMapping("/getApplicationDTOByClientId/{clientId}")
    public R<ApplicationDTO> getApplicationDTOByClientId(@PathVariable String clientId)
    {
        return success(tenantService.getApplicationDTOByClientId(clientId));
    }

}
