package mao.auth_entity.dto.auth;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import mao.tools_jwt.entity.Token;

import java.io.Serializable;
import java.util.List;

/**
 * 登录返回信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "LoginDTO", description = "登录信息")
public class LoginDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * 用户信息
     */
    @ApiModelProperty(value = "用户信息")
    private UserDTO user;

    /**
     * token令牌
     */
    @ApiModelProperty(value = "token")
    private Token token;

    /**
     * 权限列表
     */
    @ApiModelProperty(value = "权限列表")
    private List<String> permissionsList;
}
