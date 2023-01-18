package mao.aggregate_pay_user_api.dto.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.menu
 * Class(类名): MenuDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:09
 * Version(版本): 1.0
 * Description(描述)： 菜单信息
 */


@Data
@ApiModel(value = "MenuDTO", description = "菜单信息")
public class MenuDTO implements Serializable
{

    /**
     * id
     */
    @ApiModelProperty("菜单id")
    private Long id;

    /**
     * 菜单父级id
     */
    @ApiModelProperty("菜单父级id")
    private Long parentId;

    /**
     * 标题
     */
    @ApiModelProperty("菜单标题")
    private String title;

    /**
     * 菜单跳转url
     */
    @ApiModelProperty("菜单跳转url")
    private String url;

    /**
     * 页面标识
     */
    @ApiModelProperty("页面标识")
    private String code;

    /**
     * 图标
     */
    @ApiModelProperty("菜单图标")
    private String icon;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;

    /**
     * 说明
     */
    @ApiModelProperty("说明")
    private String comment;

    /**
     * 所属应用编码
     */
    @ApiModelProperty("所属应用编码")
    private String applicationCode;

    /**
     * 所属应用
     */
    @ApiModelProperty("所属应用")
    private String application;
    /**
     * 绑定的权限编码
     */
    @ApiModelProperty("绑定的权限编码")
    private String privilegeCode;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Integer status;


}

