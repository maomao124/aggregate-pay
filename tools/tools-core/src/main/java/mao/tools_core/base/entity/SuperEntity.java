package mao.tools_core.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import mao.tools_core.exception.BizException;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.base.entity
 * Class(类名): SuperEntity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 12:57
 * Version(版本): 1.0
 * Description(描述)： 超类基础实体
 */

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class SuperEntity<T> implements Serializable, Cloneable
{
    public static final String FIELD_ID = "id";
    public static final String CREATE_TIME = "createTime";
    public static final String CREATE_USER = "createUser";

    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "主键")
    @NotNull(message = "id不能为空", groups = SuperEntity.Update.class)
    protected T id;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    @ApiModelProperty(value = "创建人ID")
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    protected T createUser;

    @Override
    public Object clone()
    {
        //支持克隆  提高性能  仅仅是浅克隆
        try
        {
            return super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            return new BizException("克隆失败");
        }
    }

    /**
     * 保存和缺省验证组
     */
    public interface Save extends Default
    {

    }

    /**
     * 更新和缺省验证组
     */
    public interface Update extends Default
    {

    }
}
