package mao.aggregate_pay_user_api.dto.tenant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.tenant
 * Class(类名): ChangeAccountPwdDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:32
 * Version(版本): 1.0
 * Description(描述)： 重置账号密码
 */

@Data
@ApiModel(value = "ChangeAccountPwdDTO", description = "重置账号密码")
public class ChangeAccountPwdDTO implements Serializable
{

    /**
     * 帐户id
     */
    @ApiModelProperty("账号Id")
    private Long accountId;

    /**
     * 用户名
     */
    @ApiModelProperty("账号名")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

}
