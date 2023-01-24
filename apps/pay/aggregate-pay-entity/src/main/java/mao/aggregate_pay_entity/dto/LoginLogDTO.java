package mao.aggregate_pay_entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_entity.dto
 * Class(类名): LoginLogDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/24
 * Time(创建时间)： 15:21
 * Version(版本): 1.0
 * Description(描述)： LoginLogDTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
@Accessors(chain = true)
@ApiModel(value = "LoginLogDTO", description = "登录日志DTO")
public class LoginLogDTO
{

    /**
     * 登录IP
     */
    @ApiModelProperty(value = "登录IP")
    @TableField(value = "request_ip", condition = LIKE)
    private String requestIp;


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
