package mao.aggregate_pay_user_api.dto.tenant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.tenant
 * Class(类名): AccountQueryDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:16
 * Version(版本): 1.0
 * Description(描述)： 无
 */
@Data
@ApiModel(value = "AccountQueryDTO", description = "账号查询条件")
public class AccountQueryDTO implements Serializable
{

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 所属租户
     */
    @ApiModelProperty("所属租户")
    private Long tenantId;


}
