package mao.auth_entity.entity.auth;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import mao.tools_core.base.entity.Entity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * <p>
 * 实体类
 * 菜单
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("auth_menu")
@ApiModel(value = "Menu", description = "菜单")
public class Menu extends Entity<Long>
{

    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称")
    @NotEmpty(message = "菜单名称不能为空")
    @Length(max = 20, message = "菜单名称长度不能超过20")
    @TableField(value = "name", condition = LIKE)
    private String name;

    /**
     * 功能描述
     */
    @ApiModelProperty(value = "功能描述")
    @Length(max = 200, message = "功能描述长度不能超过200")
    @TableField(value = "describe_", condition = LIKE)
    private String describe;

    /**
     * 是否公开菜单
     * 就是无需分配就可以访问的。所有人可见
     */
    @ApiModelProperty(value = "是否公开菜单")
    @TableField("is_public")
    private Boolean isPublic;

    /**
     * 对应路由path
     */
    @ApiModelProperty(value = "对应路由path")
    @Length(max = 255, message = "对应路由path长度不能超过255")
    @TableField(value = "path", condition = LIKE)
    private String path;

    /**
     * 对应路由组件component
     */
    @ApiModelProperty(value = "对应路由组件component")
    @Length(max = 255, message = "对应路由组件component长度不能超过255")
    @TableField(value = "component", condition = LIKE)
    private String component;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用")
    @TableField("is_enable")
    private Boolean isEnable;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @TableField("sort_value")
    private Integer sortValue;

    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标")
    @Length(max = 255, message = "菜单图标长度不能超过255")
    @TableField(value = "icon", condition = LIKE)
    private String icon;

    /**
     * 菜单分组
     */
    @ApiModelProperty(value = "菜单分组")
    @Length(max = 20, message = "菜单分组长度不能超过20")
    @TableField(value = "group_", condition = LIKE)
    private String group;

    /**
     * 父级菜单id
     */
    @ApiModelProperty(value = "父级菜单id")
    @TableField("parent_id")
    private Long parentId;



    /**
     * 菜单
     *
     * @param id         id
     * @param createUser 创建用户
     * @param createTime 创建时间
     * @param updateUser 更新用户
     * @param updateTime 更新时间
     * @param name       名字
     * @param describe   描述
     * @param isPublic   是公共
     * @param path       路径
     * @param component  组件
     * @param isEnable   是使
     * @param sortValue  排序值
     * @param icon       图标
     * @param group      集团
     * @param parentId   父id
     */
    @Builder
    public Menu(Long id, Long createUser, LocalDateTime createTime, Long updateUser, LocalDateTime updateTime,
                String name, String describe, Boolean isPublic, String path, String component,
                Boolean isEnable, Integer sortValue, String icon, String group, Long parentId)
    {
        this.id = id;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.name = name;
        this.describe = describe;
        this.isPublic = isPublic;
        this.path = path;
        this.component = component;
        this.isEnable = isEnable;
        this.sortValue = sortValue;
        this.icon = icon;
        this.group = group;
        this.parentId = parentId;
    }

}
