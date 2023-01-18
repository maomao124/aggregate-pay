package mao.aggregate_pay_user_api.dto.resource;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.resource
 * Class(类名): ResourceAPPDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:13
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@Data
public class ResourceAPPDTO implements Serializable
{

    /**
     * 应用名称
     */
    @ApiModelProperty("应用名称")
    private String name;

    /**
     * 应用编码
     */
    @ApiModelProperty("应用编码,跨租户唯一")
    private String code;



    /**
     * 父id
     */
    @ApiModelProperty("父id")
    private Long parentId;

    /**
     * 菜单标题
     */
    @ApiModelProperty("菜单标题")
    private String title;

    /**
     * 链接url
     */
    @ApiModelProperty("链接url")
    private String url;

    /**
     * 图标
     */
    @ApiModelProperty("图标")
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
     * 状态
     */
    @ApiModelProperty("状态")
    private Integer status;

    /**
     * 所属应用编码
     */
    @ApiModelProperty("所属应用编码")
    private String applicationCode;

    /**
     * 绑定权限
     */
    @ApiModelProperty("绑定权限")
    private String privilegeCode;
}

