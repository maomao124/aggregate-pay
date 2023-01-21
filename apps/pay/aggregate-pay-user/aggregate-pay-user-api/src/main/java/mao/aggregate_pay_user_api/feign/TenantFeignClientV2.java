package mao.aggregate_pay_user_api.feign;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.dto.tenant.*;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.feign
 * Interface(接口名): TenantFeignClientV2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/21
 * Time(创建时间)： 14:52
 * Version(版本): 2.0
 * Description(描述)： feign接口
 */

@FeignClient(value = "aggregate-pay-user-service", path = "/v2")
public interface TenantFeignClientV2
{

    /**
     * 创建租户
     *
     * @param createTenantRequest 创建租户请求
     * @return {@link TenantDTO}
     */
    @ApiOperation("创建租户")
    @ApiImplicitParam(name = "createTenantRequest", value = "创建租户参数信息", required = true, dataType = "CreateTenantRequestDTO", paramType = "body")
    @PostMapping("/tenants")
    R<TenantDTO> createTenantAndInit(@RequestBody CreateTenantRequestDTO createTenantRequest);


    /**
     * 创建租户并关联账号
     *
     * @param createTenantRequest 创建租户请求
     * @return {@link TenantDTO}
     */
    @ApiOperation("创建租户并关联账号")
    @ApiImplicitParam(name = "createTenantRequest", value = "创建租户参数信息", required = true, dataType = "CreateTenantRequestDTO", paramType = "body")
    @PostMapping("/tenantRelateAccount")
    R<TenantDTO> createTenantRelateAccount(@RequestBody CreateTenantRequestDTO createTenantRequest);


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
    R<TenantDTO> getTenant(@PathVariable Long id);


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
    R<PageVO<TenantDTO>> queryTenants(@RequestBody TenantQueryDTO tenantQuery,
                                      @RequestParam Integer pageNo, Integer pageSize,
                                      @RequestParam String sortBy, @RequestParam String order);


    /**
     * 查询某租户类型的套餐列表
     *
     * @param tenantType 租客类型
     * @return {@link List}<{@link BundleDTO}>
     */
    @ApiOperation("查询某租户类型的套餐列表(不包含初始化套餐)")
    @ApiImplicitParam(name = "tenantType", value = "租户类型", required = true, dataType = "String", paramType = "path")
    @GetMapping("/bundles/tenant-types/{tenantType}/bundle-list")
    R<List<BundleDTO>> queryBundleByTenantType(@PathVariable String tenantType);


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
    R<BundleDTO> getBundle(@PathVariable String bundleCode);


    /**
     * 查询所有套餐
     *
     * @return {@link List}<{@link BundleDTO}>
     */
    @ApiOperation("查询所有套餐")
    @GetMapping("/bundles/bundle-list")
    R<List<BundleDTO>> queryAllBundle();


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
    R<Boolean> changeBundle(@PathVariable Long tenantId, @PathVariable String bundleCode);


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
    R<Boolean> initBundle(@PathVariable Long tenantId, @PathVariable String bundleCode);


    /**
     * 新增套餐
     *
     * @param bundleDTO 包dto
     */
    @ApiOperation("新增套餐")
    @ApiImplicitParam(name = "bundleDTO", value = "套餐信息", required = true, dataType = "BundleDTO", paramType = "body")
    @PostMapping("/bundles")
    R<Boolean> createBundle(@RequestBody BundleDTO bundleDTO);


    /**
     * 更新套餐
     *
     * @param bundleDTO 包dto
     */
    @ApiOperation("更新套餐")
    @ApiImplicitParam(name = "bundleDTO", value = "套餐信息", required = true, dataType = "BundleDTO", paramType = "body")
    @PutMapping("/bundles")
    R<Boolean> modifyBundle(@RequestBody BundleDTO bundleDTO);


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
    R<AccountDTO> createAccount(@RequestBody CreateAccountRequestDTO createAccountRequest);


    /**
     * 创建账户
     *
     * @param accountPwdRequest 账户pwd请求
     * @return {@link Boolean}
     */
    @ApiOperation("创建账号")
    @ApiImplicitParam(name = "accountPwdRequest", value = "修改账号请求参数", required = true, dataType = "ChangeAccountPwdDTO", paramType = "body")
    @PostMapping("/accounts/password")
    R<Boolean> createAccount(@RequestBody ChangeAccountPwdDTO accountPwdRequest);


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
    R<Boolean> createAccountInTenant(@RequestBody CreateAccountRequestDTO createAccountRequest, @PathVariable Long tenantId);


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
    R<Boolean> bindTenant(@PathVariable Long tenantId, @PathVariable String username);


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
    R<Boolean> unbindTenant(@PathVariable Long tenantId, @PathVariable String username);


    /**
     * 根据用户名判断账号是否存在
     *
     * @param username 用户名
     * @return boolean
     */
    @ApiOperation("根据用户名判断账号是否存在")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path")
    @GetMapping("/exist/accounts/name/{username}")
    R<Boolean> isExistAccountByUsername(@PathVariable String username);


    /**
     * 根据手机号判断账号是否存在
     *
     * @param mobile 移动
     * @return boolean
     */
    @ApiOperation("根据手机号判断账号是否存在")
    @ApiImplicitParam(name = "mobile", value = "手机号", required = true, dataType = "String", paramType = "path")
    @GetMapping("/exist/accounts/mobile/{mobile}")
    R<Boolean> isExistAccountByMobile(@PathVariable String mobile);


    /**
     * 根据用户名获取账号信息
     *
     * @param username 用户名
     * @return {@link AccountDTO}
     */
    @ApiOperation("根据用户名获取账号信息")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path")
    @GetMapping("/account-information/name/{username}")
    R<AccountDTO> getAccountByUsername(@PathVariable String username);


    /**
     * 根据手机号获取账号信息
     *
     * @param mobile 移动
     * @return {@link AccountDTO}
     */
    @ApiOperation("根据手机号获取账号信息")
    @ApiImplicitParam(name = "mobile", value = "手机号", required = true, dataType = "String", paramType = "path")
    @GetMapping("/accounts-information/mobile/{mobile}")
    R<AccountDTO> getAccountByMobile(@PathVariable String mobile);


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
    R<Boolean> isExistAccountInTenantByUsername(@PathVariable Long tenantId, @PathVariable String username);


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
    R<Boolean> isExistAccountInTenantByMobile(@PathVariable Long tenantId, @PathVariable String mobile);


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
    R<PageVO<AccountDTO>> queryAccount(@RequestBody AccountQueryDTO accountQuery, @RequestParam Integer pageNo,
                                       Integer pageSize, @RequestParam String sortBy, @RequestParam String order);


    /**
     * 查询某账号所属租户列表
     *
     * @param username 用户名
     * @return {@link List}<{@link TenantDTO}>
     */
    @ApiOperation("查询某账号所属租户列表")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path")
    @GetMapping("/accounts/tenant-list/{username}")
    R<List<TenantDTO>> queryAccountInTenant(@PathVariable String username);


    /**
     * 发送短信验证码
     *
     * @param phone 电话
     * @return {@link String}
     */
    @ApiOperation("发送短信验证码")
    @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getMessage")
    R<String> sendMessage(@RequestParam String phone);


    /**
     * 身份验证
     *
     * @param authenticationInfo 身份验证信息
     * @return {@link AccountDTO}
     */
    @ApiOperation("用户认证")
    @ApiImplicitParam(name = "authenticationInfo", value = "认证信息", required = true, dataType = "AuthenticationInfo", paramType = "body")
    @PostMapping("/authentication")
    R<AccountDTO> authentication(@RequestBody AuthenticationInfo authenticationInfo);


    /**
     * 登录
     *
     * @param loginRequest 登录请求
     * @return {@link LoginInfoDTO}
     */
    @ApiOperation("用户登录")
    @ApiImplicitParam(name = "loginRequest", value = "登录请求参数", required = true, dataType = "LoginRequestDTO", paramType = "body")
    @PostMapping("/login")
    R<LoginInfoDTO> login(@RequestBody LoginRequestDTO loginRequest);


    /**
     * 根据接入客户端获取应用
     *
     * @param clientId 客户机id
     * @return {@link ApplicationDTO}
     */
    @ApiOperation("根据接入客户端获取应用")
    @ApiImplicitParam(name = "clientId", value = "客户端id", required = true, dataType = "String", paramType = "path")
    @GetMapping("/getApplicationDTOByClientId/{clientId}")
    R<ApplicationDTO> getApplicationDTOByClientId(@PathVariable String clientId);

}
