package mao.aggregate_pay_user_api.dto.tenant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.tenant
 * Class(类名): TenRolePrivilegeDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:37
 * Version(版本): 1.0
 * Description(描述)： 租户角色权限信息
 */

@Data
@ApiModel(value = "TenRolePrivilegeDTO", description = "租户角色权限信息")
public class TenRolePrivilegeDTO implements Serializable
{
    /**
     * 租户id
     */
    @ApiModelProperty("租户id")
    private Long tenantId;

    /**
     * 角色编码
     */
    @ApiModelProperty("角色编码")
    private String roleCode;

    /**
     * 权限编码
     */
    @ApiModelProperty("权限编码")
    private String privilegeCode;
}
