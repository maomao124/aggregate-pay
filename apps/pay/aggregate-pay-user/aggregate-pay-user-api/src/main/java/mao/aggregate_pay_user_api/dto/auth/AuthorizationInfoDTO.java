package mao.aggregate_pay_user_api.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.auth
 * Class(类名): AuthorizationInfoDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:04
 * Version(版本): 1.0
 * Description(描述)： 授权信息
 */

@Data
@ApiModel(value = "AuthorizationInfoDTO", description = "授权信息,包括角色与权限")
public class AuthorizationInfoDTO
{
    /**
     * 角色-权限列表 映射
     */
    @ApiModelProperty("授权信息，角色-权限关系,key为角色编码，value为权限集合")
    private Map<String, List<String>> rolePrivilegeMap = new HashMap<>();
}
