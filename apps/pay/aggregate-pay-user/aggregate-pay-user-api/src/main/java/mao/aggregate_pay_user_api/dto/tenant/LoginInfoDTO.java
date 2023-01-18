package mao.aggregate_pay_user_api.dto.tenant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import mao.aggregate_pay_user_api.dto.auth.AuthorizationInfoDTO;
import mao.aggregate_pay_user_api.dto.resource.ResourceDTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.tenant
 * Class(类名): LoginInfoDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:33
 * Version(版本): 1.0
 * Description(描述)： 登录响应信息
 */

@Data
@ApiModel(value = "LoginInfoDTO", description = "登录响应信息")
public class LoginInfoDTO implements Serializable
{

    /**
     * 账号id
     */
    @ApiModelProperty("账号id")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 账号所属多个租户
     */
    @ApiModelProperty("账号所属多个租户")
    private List<TenantDTO> tenants;

    /**
     * 账号所属多个租户下的权限
     */
    @ApiModelProperty("账号所属多个租户下的权限")
    private Map<Long, AuthorizationInfoDTO> tenantAuthorizationInfoMap  = new HashMap<>();

    /**
     * 资源
     */
    @ApiModelProperty("账号所属多个租户下，不同应用的资源，如：{租户A:[{应用1权限信息},{应用2权限信息}],租户B:[{},{}...]}")
    Map<Long, List<ResourceDTO>> resources = new HashMap<>();


}
