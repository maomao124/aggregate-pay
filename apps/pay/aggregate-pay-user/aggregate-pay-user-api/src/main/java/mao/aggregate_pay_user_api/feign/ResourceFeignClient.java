package mao.aggregate_pay_user_api.feign;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.auth.AuthorizationInfoDTO;
import mao.aggregate_pay_user_api.dto.menu.MenuDTO;
import mao.aggregate_pay_user_api.dto.menu.MenuQueryDTO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationQueryParams;
import mao.aggregate_pay_user_api.dto.resource.ResourceDTO;
import mao.aggregate_pay_user_api.fallback.AuthorizationFeignClientV2FallbackFactory;
import mao.aggregate_pay_user_api.fallback.ResourceFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.feign
 * Interface(接口名): ResourceFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/21
 * Time(创建时间)： 14:40
 * Version(版本): 1.0
 * Description(描述)： feign接口
 */

@FeignClient(value = "aggregate-pay-user-service", path = "/user", fallbackFactory = ResourceFeignClientFallbackFactory.class)
public interface ResourceFeignClient
{
    /**
     * 创建应用
     * 会关联创建uaa服务中的接入客户端，其中code为clientId
     *
     * @param application 应用程序
     */
    @ApiOperation("创建应用")
    @ApiImplicitParam(name = "application", value = "创建应用信息", required = true, dataType = "ApplicationDTO", paramType = "body")
    @PostMapping("/apps")
    void createApplication(@RequestBody ApplicationDTO application);


    /**
     * 修改应用程序
     *
     * @param application 应用程序
     */
    @ApiOperation("修改应用")
    @ApiImplicitParam(name = "application", value = "应用信息", required = true, dataType = "ApplicationDTO", paramType = "body")
    @PutMapping("/apps")
    void modifyApplication(@RequestBody ApplicationDTO application);


    /**
     * 删除应用程序
     *
     * @param applicationCode 应用程序代码
     */
    @ApiOperation("删除应用")
    @ApiImplicitParam(name = "application", value = "应用信息", required = true, dataType = "String", paramType = "path")
    @DeleteMapping("/apps/{applicationCode}")
    void removeApplication(@PathVariable String applicationCode);


    /**
     * 查询应用程序
     *
     * @param applicationCode 应用程序代码
     * @return {@link ApplicationDTO}
     */
    @ApiOperation("根据应用编码查找应用")
    @ApiImplicitParam(name = "applicationCode", value = "应用信息", required = true, dataType = "String", paramType = "path")
    @GetMapping("/apps/{applicationCode}")
    ApplicationDTO queryApplication(@PathVariable String applicationCode);


    /**
     * 分页条件查找应用
     *
     * @param query    查询
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return {@link PageVO}<{@link ApplicationDTO}>
     */
    @ApiOperation("分页条件查找应用")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "query", value = "租户检索参数", required = true, dataType = "ApplicationQueryParams", paramType = "body"),
                    @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "int", paramType = "query")
            })
    @PostMapping("/apps/page")
    PageVO<ApplicationDTO> pageApplicationByConditions(@RequestBody ApplicationQueryParams query, @RequestParam Integer pageNo, @RequestParam Integer pageSize);


    /**
     * 根据权限加载指定应用的资源
     *
     * @param privileageCodes privileage代码
     * @param applicationCode 应用程序代码
     * @return {@link List}<{@link ResourceDTO}>
     */
    @ApiOperation("根据权限加载指定应用的资源")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "privileageCodes", value = "权限集合", required = true, allowMultiple = true, dataType = "String", paramType = "query"),
                    @ApiImplicitParam(name = "applicationCode", value = "应用的编码", required = true, dataType = "String", paramType = "path")
            })
    @GetMapping("/apps/privileges/resources/{applicationCode}")
    List<ResourceDTO> loadResources(@RequestParam List<String> privileageCodes, @PathVariable String applicationCode);


    /**
     * 获取多个租户下权限所对应的的资源信息，并按应用拆分
     *
     * @param tenantAuthorizationInfoMap 承租人授权信息地图
     * @return {@link Map}<{@link Long}, {@link List}<{@link ResourceDTO}>>
     */
    @ApiOperation("获取多个租户下权限所对应的的资源信息，并按应用拆分")
    @ApiImplicitParam(name = "tenantAuthorizationInfoMap", value = "多个租户下的资源信息", required = true, dataType = "Map<Long, AuthorizationInfoDTO>", paramType = "body")
    @PostMapping("/tenants/apps/privileges/resources")
    Map<Long, List<ResourceDTO>> loadResources(@RequestBody Map<Long, AuthorizationInfoDTO> tenantAuthorizationInfoMap);


    /**
     * 查询菜单
     *
     * @param id id
     * @return {@link MenuDTO}
     */
    @ApiOperation("根据ID查询菜单")
    @ApiImplicitParam(name = "id", value = "菜单Id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/menus/{id}")
    MenuDTO queryMenu(@PathVariable Long id);


    /**
     * 根据应用编码查询菜单列表
     *
     * @param applicationCode 应用程序代码
     * @return {@link List}<{@link MenuDTO}>
     */
    @ApiOperation("根据应用编码查询菜单列表")
    @ApiImplicitParam(name = "applicationCode", value = "应用编码", required = true, dataType = "String", paramType = "path")
    @GetMapping("/menus/{applicationCode}/menu-list")
    List<MenuDTO> queryMenuByApplicationCode(@PathVariable String applicationCode);


    /**
     * 根据条件查询菜单列表
     *
     * @param params   参数
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return {@link PageVO}<{@link MenuDTO}>
     */
    @ApiOperation("根据条件查询菜单列表")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "params", value = "查询菜单参数", required = true, dataType = "MenuQueryDTO", paramType = "body"),
                    @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType = "int", paramType = "query")
            })
    @PostMapping("/menus/page")
    PageVO<MenuDTO> queryMenu(@RequestBody MenuQueryDTO params, @RequestParam Integer pageNo, @RequestParam Integer pageSize);


    /**
     * 根据权限编码列表获取菜单
     *
     * @param privileges 特权
     * @return {@link List}<{@link MenuDTO}>
     */
    @ApiOperation("根据权限编码列表获取菜单")
    @ApiImplicitParam(name = "privileges", value = "权限编码", required = true, allowMultiple = true, dataType = "String", paramType = "query")
    @GetMapping("/menus/privileges")
    List<MenuDTO> queryMenuByPrivileges(@RequestParam String[] privileges);
}
