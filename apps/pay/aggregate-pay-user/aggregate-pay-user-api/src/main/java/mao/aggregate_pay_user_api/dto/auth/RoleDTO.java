package mao.aggregate_pay_user_api.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.auth
 * Class(类名): RoleDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:08
 * Version(版本): 1.0
 * Description(描述)： 角色信息
 */

@Data
@ApiModel(value = "RoleDTO", description = "角色信息")
public class RoleDTO implements Serializable
{

    /**
     * id
     */
    @ApiModelProperty("角色id")
    private Long id;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String name;

    /**
     * 角色编码
     */
    @ApiModelProperty("角色编码")
    private String code;

    /**
     * 角色所属租户
     */
    @ApiModelProperty("角色所属租户")
    private Long tenantId;

    /**
     * 角色包含权限列表
     */
    @ApiModelProperty("角色包含权限列表")
    private List<String> privilegeCodes = new ArrayList<>();
}
