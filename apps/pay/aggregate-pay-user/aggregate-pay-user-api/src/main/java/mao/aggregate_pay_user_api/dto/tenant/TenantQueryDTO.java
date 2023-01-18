package mao.aggregate_pay_user_api.dto.tenant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.tenant
 * Class(类名): TenantQueryDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:36
 * Version(版本): 1.0
 * Description(描述)： 租户查询条件
 */

@Data
@ApiModel(value = "TenantQueryDTO", description = "租户查询条件")
public class TenantQueryDTO implements Serializable
{

    /**
     * 租户名称
     */
    @ApiModelProperty("租户名称")
    private String name;

    /**
     * 租户类型
     */
    @ApiModelProperty("租户类型")
    private String tenantTypeCode;


}
