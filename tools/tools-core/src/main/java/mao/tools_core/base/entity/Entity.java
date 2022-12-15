package mao.tools_core.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.base.entity
 * Class(类名): Entity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 13:00
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Getter
@Setter
@Accessors(chain = true)
@ToString(callSuper = true)
public class Entity<T> extends SuperEntity<T>
{
    public static final String UPDATE_TIME = "updateTime";
    public static final String UPDATE_USER = "updateUser";

    @ApiModelProperty(value = "最后修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;

    @ApiModelProperty(value = "最后修改人ID")
    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    protected T updateUser;

    /**
     * 实体
     *
     * @param id         id
     * @param createTime 创建时间
     * @param createUser 创建用户
     * @param updateTime 更新时间
     * @param updateUser 更新用户
     */
    public Entity(T id, LocalDateTime createTime, T createUser, LocalDateTime updateTime, T updateUser)
    {
        super(id, createTime, createUser);
        this.updateTime = updateTime;
        this.updateUser = updateUser;
    }

    public Entity()
    {

    }

}
