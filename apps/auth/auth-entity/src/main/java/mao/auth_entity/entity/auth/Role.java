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
 * 角色
 * </p>
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("auth_role")
@ApiModel(value = "Role", description = "角色")
public class Role extends Entity<Long>
{

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    @NotEmpty(message = "角色名称不能为空")
    @Length(max = 30, message = "角色名称长度不能超过30")
    @TableField(value = "name", condition = LIKE)
    private String name;

    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    @Length(max = 20, message = "角色编码长度不能超过20")
    @TableField(value = "code", condition = LIKE)
    private String code;

    /**
     * 功能描述
     */
    @ApiModelProperty(value = "功能描述")
    @Length(max = 100, message = "功能描述长度不能超过100")
    @TableField(value = "describe_", condition = LIKE)
    private String describe;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Boolean status;

    /**
     * 是否内置角色
     */
    @ApiModelProperty(value = "是否内置角色")
    @TableField("readonly")
    private Boolean readonly;


    /*@ApiModelProperty(value = "数据权限类型")
    @NotNull(message = "数据权限类型不能为空")
    @TableField("ds_type")
    private DataScopeType dsType;*/


    /**
     * 角色
     * 数据权限类型
     * #DataScopeType{ALL:1,全部;THIS_LEVEL:2,本级;THIS_LEVEL_CHILDREN:3,本级以及子级;CUSTOMIZE:4,自定义;SELF:5,个人;}
     *
     * @param id         id
     * @param createUser 创建用户
     * @param createTime 创建时间
     * @param updateUser 更新用户
     * @param updateTime 更新时间
     * @param name       名字
     * @param code       代码
     * @param describe   描述
     * @param status     状态
     * @param readonly   只读
     */
    @Builder
    public Role(Long id, Long createUser, LocalDateTime createTime, Long updateUser, LocalDateTime updateTime,
                String name, String code, String describe, Boolean status, Boolean readonly) {
        this.id = id;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.name = name;
        this.code = code;
        this.describe = describe;
        this.status = status;
        this.readonly = readonly;
        //this.dsType = dsType;
    }

}
