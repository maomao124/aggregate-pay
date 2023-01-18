package mao.aggregate_pay_user_api.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.auth
 * Class(类名): PrivilegeDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:05
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@ApiModel(value = "PrivilegeDTO", description = "权限信息")
public class PrivilegeDTO implements Serializable
{
    /**
     * 权限id
     */
    @ApiModelProperty("权限id")
    private Long id;

    /**
     * 权限名称
     */
    @ApiModelProperty("权限名称")
    private String name;

    /**
     * 权限编码
     */
    @ApiModelProperty("权限编码")
    private String code;

    /**
     * 所属权限组id
     */
    @ApiModelProperty("所属权限组id")
    private Long privilegeGroupId;
}
