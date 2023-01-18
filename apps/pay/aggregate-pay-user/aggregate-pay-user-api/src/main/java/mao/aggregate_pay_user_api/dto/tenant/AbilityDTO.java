package mao.aggregate_pay_user_api.dto.tenant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.tenant
 * Class(类名): AbilityDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:15
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@ApiModel(value = "AbilityDTO", description = "套餐包含功能描述,JSON格式的角色与权限")
public class AbilityDTO implements Serializable
{

    /**
     * 角色名
     */
    @ApiModelProperty("角色名称")
    private String roleName;

    /**
     * 角色代码
     */
    @ApiModelProperty("角色编码")
    private String roleCode;

    /**
     * 权限
     */
    @ApiModelProperty("权限（数组）")
    private String[] privileges;

}
