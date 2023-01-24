package mao.aggregate_pay_entity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import mao.tools_common.enums.HttpMethod;

import java.io.Serializable;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_entity.entity
 * Class(类名): LoginLog
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/24
 * Time(创建时间)： 15:10
 * Version(版本): 1.0
 * Description(描述)： 登录日志
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
@Accessors(chain = true)
@TableName("login_log")
@ApiModel(value = "LoginLog", description = "登录日志")
public class LoginLog implements Serializable
{
    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "主键")
    private Long id;


    /**
     * 登录IP
     */
    @ApiModelProperty(value = "登录IP")
    @TableField(value = "request_ip", condition = LIKE)
    private String requestIp;


    /**
     * 登录人ID
     */
    @ApiModelProperty(value = "登录人ID")
    @TableField(value = "user_id", condition = LIKE)
    private Long userId;


    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @TableField(value = "username")
    private String username;


    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @TableField(value = "mobile")
    private String mobile;


    /**
     * 账号所属的多个租户id，json数据保存
     */
    @ApiModelProperty(value = "账号所属的多个租户id，json数据保存")
    @TableField(value = "tenants")
    private String tenants;


    /**
     * 登录时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "登录时间")
    @TableField("login_date")
    private LocalDateTime loginDate;


    /**
     * 登录地点
     */
    @ApiModelProperty(value = "登录地点")
    @TableField("location")
    private String location;
}
