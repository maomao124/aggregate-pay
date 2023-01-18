package mao.aggregate_pay_user_api.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.auth
 * Class(类名): PrivilegeGroupDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:07
 * Version(版本): 1.0
 * Description(描述)： 权限组信息
 */

@Data
@ApiModel(value = "PrivilegeGroupDTO", description = "权限组信息")
public class PrivilegeGroupDTO implements Serializable
{

    /**
     * 权限组id
     */
    @ApiModelProperty("权限组id")
    private Long id;

    /**
     * 权限组父id
     */
    @ApiModelProperty("权限组父id")
    private Long parentId;

    /**
     * 权限组名称
     */
    @ApiModelProperty("权限组名称")
    private String name;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;


}
