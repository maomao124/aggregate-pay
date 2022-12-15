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
 * 资源
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("auth_resource")
@ApiModel(value = "Resource", description = "资源")
public class Resource extends Entity<Long>
{

    private static final long serialVersionUID = 1L;

    /**
     * 资源编码
     * 规则：
     * 链接：
     * 数据列：
     * 按钮：
     */
    @ApiModelProperty(value = "资源编码")
    @Length(max = 255, message = "资源编码长度不能超过255")
    @TableField(value = "code", condition = LIKE)
    private String code;

    /**
     * 接口名称
     */
    @ApiModelProperty(value = "接口名称")
    @NotEmpty(message = "接口名称不能为空")
    @Length(max = 255, message = "接口名称长度不能超过255")
    @TableField(value = "name", condition = LIKE)
    private String name;

    /**
     * 菜单ID
     * #auth_menu
     */
    @ApiModelProperty(value = "菜单ID")
    @TableField("menu_id")
    private Long menuId;

    /**
     * 接口描述
     */
    @ApiModelProperty(value = "接口描述")
    @Length(max = 255, message = "接口描述长度不能超过255")
    @TableField(value = "describe_", condition = LIKE)
    private String describe;

    @ApiModelProperty(value = "请求方式")
    //@Length(max = 255, message = "接口描述长度不能超过255")
    @TableField(value = "method")
    private String method;

    @ApiModelProperty(value = "请求url地址")
    //@Length(max = 255, message = "接口描述长度不能超过255")
    @TableField(value = "url")
    private String url;


    /**
     * 资源
     *
     * @param id         id
     * @param createUser 创建用户
     * @param createTime 创建时间
     * @param updateUser 更新用户
     * @param updateTime 更新时间
     * @param code       代码
     * @param name       名字
     * @param menuId     菜单id
     * @param describe   描述
     * @param method     方法
     * @param url        url
     */
    @Builder
    public Resource(Long id, Long createUser, LocalDateTime createTime, Long updateUser, LocalDateTime updateTime,
                    String code, String name, Long menuId, String describe, String method, String url)
    {
        this.id = id;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.code = code;
        this.name = name;
        this.menuId = menuId;
        this.describe = describe;
        this.method = method;
        this.url = url;
    }

}
