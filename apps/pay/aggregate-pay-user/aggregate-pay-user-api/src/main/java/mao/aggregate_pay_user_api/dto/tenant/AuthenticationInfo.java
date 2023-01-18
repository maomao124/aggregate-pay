package mao.aggregate_pay_user_api.dto.tenant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.tenant
 * Class(类名): AuthenticationInfo
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:39
 * Version(版本): 1.0
 * Description(描述)： 认证请求信息
 */

@Data
@ApiModel(value = "AuthenticationInfo", description = "认证请求信息")
public class AuthenticationInfo implements Serializable
{

    /**
     * 认证主体:如用户名，手机号等
     */
    @ApiModelProperty("认证主体:如用户名，手机号等")
    private String principal;

    /**
     * 凭证:如密码，短信认证码等
     */
    @ApiModelProperty("凭证:如密码，短信认证码等")
    private String certificate;

    /**
     * 认证类型：短信快捷认证、用户名密码认证、二维码认证等
     */
    @ApiModelProperty("认证类型：短信快捷认证、用户名密码认证、二维码认证等")
    private String authenticationType;

    /**
     * 短信认证时需要传key到短信微服务校验
     */
    @ApiModelProperty("短信认证时需要传key到短信微服务校验")
    private String smsKey;

}
