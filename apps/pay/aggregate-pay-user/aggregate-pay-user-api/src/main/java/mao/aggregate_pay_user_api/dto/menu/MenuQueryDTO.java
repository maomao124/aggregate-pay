package mao.aggregate_pay_user_api.dto.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.menu
 * Class(类名): MenuQueryDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:10
 * Version(版本): 1.0
 * Description(描述)： 菜单查询参数
 */

@Data
@ApiModel(value = "MenuQueryDTO", description = "菜单查询参数")
public class MenuQueryDTO implements Serializable
{
    /**
     * 所属应用
     */
    @ApiModelProperty("所属应用")
    private String applicationCode;

    /**
     * 菜单标题
     */
    @ApiModelProperty("菜单标题")
    private String title;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Integer status;


}
