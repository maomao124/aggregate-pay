package mao.auth_entity.dto.auth;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import mao.auth_entity.entity.auth.User;

import java.io.Serializable;
import java.util.List;

/**
 * 用户角色DTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "UserRoleDTO", description = "用户角色DTO")
public class UserRoleDTO implements Serializable
{
    @ApiModelProperty(value = "用户id")
    private List<Long> idList;

    @ApiModelProperty(value = "用户信息")
    private List<User> userList;
}
