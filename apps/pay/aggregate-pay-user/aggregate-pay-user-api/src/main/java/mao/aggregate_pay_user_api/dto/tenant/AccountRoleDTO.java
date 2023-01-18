package mao.aggregate_pay_user_api.dto.tenant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.tenant
 * Class(类名): AccountRoleDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:17
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@Data
@ApiModel(value = "AccountDTO", description = "账号信息")
public class AccountRoleDTO
{

    /**
     * 账号名称
     */
    @ApiModelProperty("账号名称")
    private String username;

    /**
     * 角色编码
     */
    @ApiModelProperty("角色编码")
    private String roleCode;

    /**
     * 租户id
     */
    @ApiModelProperty("租户id")
    private Long tenantId;
}
