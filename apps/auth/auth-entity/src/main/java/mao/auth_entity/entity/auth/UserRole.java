package mao.auth_entity.entity.auth;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import mao.tools_core.base.entity.SuperEntity;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 实体类
 * 角色分配
 * 账号角色绑定
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("auth_user_role")
@ApiModel(value = "UserRole", description = "角色分配")
public class UserRole extends SuperEntity<Long>
{

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     *
     */
    @ApiModelProperty(value = "角色ID")
    @NotNull(message = "角色ID不能为空")
    @TableField("role_id")
    private Long roleId;

    /**
     * 用户ID
     *
     */
    @ApiModelProperty(value = "用户ID")
    @NotNull(message = "用户ID不能为空")
    @TableField("user_id")
    private Long userId;


    /**
     * 用户角色
     *
     * @param id         id
     * @param createUser 创建用户
     * @param createTime 创建时间
     * @param roleId     角色id
     * @param userId     用户id
     */
    @Builder
    public UserRole(Long id, Long createUser, LocalDateTime createTime,
                    Long roleId, Long userId)
    {
        this.id = id;
        this.createUser = createUser;
        this.createTime = createTime;
        this.roleId = roleId;
        this.userId = userId;
    }

}
