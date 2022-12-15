package mao.auth_entity.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

/**
 * 登录参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "LoginParamDTO", description = "登录参数")
public class LoginParamDTO
{
    /**
     * 验证码KEY
     */
    @ApiModelProperty(value = "验证码KEY")
    @NotEmpty(message = "验证码KEY不能为空")
    private String key;

    /**
     * 验证码
     */
    @ApiModelProperty(value = "验证码")
    @NotEmpty(message = "验证码不能为空")
    private String code;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    @NotEmpty(message = "账号不能为空")
    private String account;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;
}
