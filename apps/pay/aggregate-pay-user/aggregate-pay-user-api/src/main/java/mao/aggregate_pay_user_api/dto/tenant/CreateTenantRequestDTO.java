package mao.aggregate_pay_user_api.dto.tenant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.tenant
 * Class(类名): CreateTenantRequestDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:33
 * Version(版本): 1.0
 * Description(描述)： 创建租户请求信息
 */

@Data
@ApiModel(value = "CreateTenantRequestDTO", description = "创建租户请求信息")
public class CreateTenantRequestDTO implements Serializable
{

    /**
     * 租户名称
     */
    @ApiModelProperty("租户名称")
    private String name;

    /**
     * 租户类型编码
     */
    @ApiModelProperty("租户类型编码")
    private String tenantTypeCode;

    /**
     * 初始化套餐编码
     */
    @ApiModelProperty("初始化套餐编码，用于初始化套餐 ABILITY，若为空则使用该租户类型的初始化套餐")
    private String bundleCode;

    /**
     * 租户管理员登录手机号
     */
    @ApiModelProperty("租户管理员登录手机号")
    private String mobile;

    /**
     * 租户管理员登录密码
     */
    @ApiModelProperty("租户管理员登录密码")
    private String password;

    /**
     * 租户管理员登录用户名
     */
    @ApiModelProperty("租户管理员登录用户名")
    private String username;


}
