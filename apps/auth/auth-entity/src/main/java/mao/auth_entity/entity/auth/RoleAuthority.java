package mao.auth_entity.entity.auth;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import mao.auth_entity.enumeration.auth.AuthorizeType;
import mao.tools_core.base.entity.SuperEntity;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 实体类
 * 角色的资源
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("auth_role_authority")
@ApiModel(value = "RoleAuthority", description = "角色的资源")
public class RoleAuthority extends SuperEntity<Long>
{

    private static final long serialVersionUID = 1L;

    /**
     * 资源id
     * #auth_resource
     * #auth_menu
     */
    @ApiModelProperty(value = "资源id")
    @NotNull(message = "资源id不能为空")
    @TableField("authority_id")
    private Long authorityId;

    /**
     * 权限类型
     * #AuthorizeType{MENU:菜单;RESOURCE:资源;}
     */
    @ApiModelProperty(value = "权限类型")
    @NotNull(message = "权限类型不能为空")
    @TableField("authority_type")
    private AuthorizeType authorityType;

    /**
     * 角色id
     * #auth_role
     */
    @ApiModelProperty(value = "角色id")
    @NotNull(message = "角色id不能为空")
    @TableField("role_id")
    private Long roleId;


    /**
     * 角色权限
     *
     * @param id            id
     * @param createTime    创建时间
     * @param createUser    创建用户
     * @param authorityId   授权id
     * @param authorityType 权威类型
     * @param roleId        角色id
     */
    @Builder
    public RoleAuthority(Long id, LocalDateTime createTime, Long createUser,
                         Long authorityId, AuthorizeType authorityType, Long roleId)
    {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.authorityId = authorityId;
        this.authorityType = authorityType;
        this.roleId = roleId;
    }

}
