package mao.auth_entity.entity.auth;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import mao.auth_entity.enumeration.auth.Sex;
import mao.tools_core.base.entity.Entity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * <p>
 * 实体类
 * 用户
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("auth_user")
@ApiModel(value = "User", description = "用户")
public class User extends Entity<Long>
{

    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    @NotEmpty(message = "账号不能为空")
    @Length(max = 30, message = "账号长度不能超过30")
    @TableField(value = "account", condition = LIKE)
    private String account;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @NotEmpty(message = "姓名不能为空")
    @Length(max = 50, message = "姓名长度不能超过50")
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
     * 岗位ID
     * #core_station
     */
    @ApiModelProperty(value = "岗位ID")
    @TableField("station_id")
    private Long stationId;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @Length(max = 255, message = "邮箱长度不能超过255")
    @TableField(value = "email", condition = LIKE)
    private String email;

    /**
     * 手机
     */
    @ApiModelProperty(value = "手机")
    @Length(max = 20, message = "手机长度不能超过20")
    @TableField(value = "mobile", condition = LIKE)
    private String mobile;

    /**
     * 性别
     * #Sex{W:女;M:男;N:未知}
     */
    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private Sex sex;

    /**
     * 启用状态 1启用 0禁用
     */
    @ApiModelProperty(value = "启用状态 1启用 0禁用")
    @TableField("status")
    private Boolean status;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @Length(max = 255, message = "头像长度不能超过255")
    @TableField(value = "avatar", condition = LIKE)
    private String avatar;

    /**
     * 工作描述
     * 比如：  市长、管理员、局长等等   用于登陆展示
     */
    @ApiModelProperty(value = "工作描述")
    @Length(max = 255, message = "工作描述长度不能超过255")
    @TableField(value = "work_describe", condition = LIKE)
    private String workDescribe;

    /**
     * 最后一次输错密码时间
     */
    @ApiModelProperty(value = "最后一次输错密码时间")
    @TableField("password_error_last_time")
    private LocalDateTime passwordErrorLastTime;

    /**
     * 密码错误次数
     */
    @ApiModelProperty(value = "密码错误次数")
    @TableField("password_error_num")
    private Integer passwordErrorNum;

    /**
     * 密码过期时间
     */
    @ApiModelProperty(value = "密码过期时间")
    @TableField("password_expire_time")
    private LocalDateTime passwordExpireTime;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    @Length(max = 64, message = "密码长度不能超过64")
    @TableField(value = "password", condition = LIKE)
    private String password;

    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间")
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;


    /**
     * 用户
     *
     * @param id                    id
     * @param createUser            创建用户
     * @param createTime            创建时间
     * @param updateUser            更新用户
     * @param updateTime            更新时间
     * @param account               账户
     * @param name                  名字
     * @param orgId                 org id
     * @param stationId             站id
     * @param email                 电子邮件
     * @param mobile                移动
     * @param sex                   性
     * @param status                状态
     * @param avatar                《阿凡达》
     * @param workDescribe          工作描述
     * @param passwordErrorLastTime 上次密码错误
     * @param passwordErrorNum      密码错误num
     * @param passwordExpireTime    密码到期时间
     * @param password              密码
     * @param lastLoginTime         最后登录时间
     */
    @Builder
    public User(Long id, Long createUser, LocalDateTime createTime, Long updateUser, LocalDateTime updateTime,
                String account, String name, Long orgId, Long stationId, String email,
                String mobile, Sex sex, Boolean status, String avatar, String workDescribe, LocalDateTime passwordErrorLastTime,
                Integer passwordErrorNum, LocalDateTime passwordExpireTime, String password, LocalDateTime lastLoginTime)
    {
        this.id = id;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.account = account;
        this.name = name;
        this.orgId = orgId;
        this.stationId = stationId;
        this.email = email;
        this.mobile = mobile;
        this.sex = sex;
        this.status = status;
        this.avatar = avatar;
        this.workDescribe = workDescribe;
        this.passwordErrorLastTime = passwordErrorLastTime;
        this.passwordErrorNum = passwordErrorNum;
        this.passwordExpireTime = passwordExpireTime;
        this.password = password;
        this.lastLoginTime = lastLoginTime;
    }

}
