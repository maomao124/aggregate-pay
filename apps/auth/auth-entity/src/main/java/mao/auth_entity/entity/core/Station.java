package mao.auth_entity.entity.core;

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
 * 岗位
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("core_station")
@ApiModel(value = "Station", description = "岗位实体类")
public class Station extends Entity<Long>
{
    private static final long serialVersionUID = 1L;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @NotEmpty(message = "名称不能为空")
    @Length(max = 255, message = "名称长度不能超过255")
    @TableField(value = "name", condition = LIKE)
    private String name;

    /**
     * 组织ID
     * #core_org
     */
    @ApiModelProperty(value = "组织ID")
    @TableField("org_id")
    private Long orgId;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Boolean status;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @Length(max = 255, message = "描述长度不能超过255")
    @TableField(value = "describe_", condition = LIKE)
    private String describe;

    /**
     * 构造方法
     *
     * @param id         id
     * @param createTime 创建时间
     * @param createUser 创建用户
     * @param updateTime 更新时间
     * @param updateUser 更新用户
     * @param name       名字
     * @param orgId      org id
     * @param status     状态
     * @param describe   描述
     */
    @Builder
    public Station(Long id, LocalDateTime createTime, Long createUser, LocalDateTime updateTime, Long updateUser,
                   String name, Long orgId, Boolean status, String describe)
    {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.name = name;
        this.orgId = orgId;
        this.status = status;
        this.describe = describe;
    }
}
