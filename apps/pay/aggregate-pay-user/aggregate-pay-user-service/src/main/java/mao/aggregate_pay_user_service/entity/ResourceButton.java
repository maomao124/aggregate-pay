package mao.aggregate_pay_user_service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.entity
 * Class(类名): ResourceButton
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 20:37
 * Version(版本): 1.0
 * Description(描述)： 菜单
 */

@Data
@TableName("resource_button")
public class ResourceButton implements Serializable
{

    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 父id
     */
    @TableField("PARENT_ID")
    private Long parentId;

    /**
     * 按钮标题
     */
    @TableField("TITLE")
    private String title;

    /**
     * 链接url
     */
    @TableField("URL")
    private String url;

    /**
     * 图标
     */
    @TableField("ICON")
    private String icon;

    /**
     * 排序
     */
    @TableField("SORT")
    private Integer sort;

    /**
     * 说明
     */
    @TableField("COMMENT")
    private String comment;

    /**
     * 状态
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 所属应用编码
     */
    @TableField("APPLICATION_CODE")
    private String applicationCode;

    /**
     * 绑定权限
     */
    @TableField("PRIVILEGE_CODE")
    private String privilegeCode;

}

