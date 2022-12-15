package mao.auth_entity.entity.auth;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import mao.tools_core.base.entity.SuperEntity;

import java.time.LocalDateTime;

/**
 * <p>
 * 实体类
 * 角色组织关系
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("auth_role_org")
@ApiModel(value = "RoleOrg", description = "角色组织关系")
public class RoleOrg extends SuperEntity<Long>
{

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     * #auth_role
     */
    @ApiModelProperty(value = "角色ID")
    @TableField("role_id")
    private Long roleId;

    /**
     * 部门ID
     * #core_org
     */
    @ApiModelProperty(value = "部门ID")
    @TableField("org_id")
    private Long orgId;


    /**
     * 组织角色
     *
     * @param id         id
     * @param createTime 创建时间
     * @param createUser 创建用户
     * @param roleId     角色id
     * @param orgId      org id
     */
    @Builder
    public RoleOrg(Long id, LocalDateTime createTime, Long createUser,
                   Long roleId, Long orgId)
    {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.roleId = roleId;
        this.orgId = orgId;
    }

}
