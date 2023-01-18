package mao.aggregate_pay_user_api.dto.tenant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.tenant
 * Class(类名): TenantDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:34
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@ApiModel(value = "TenantDTO", description = "租户信息")
public class TenantDTO implements Serializable
{

    /**
     * 租户id
     */
    @ApiModelProperty("租户id")
    private Long id;

    /**
     * 租户名称
     */
    @ApiModelProperty("租户名称")
    private String name;

    /**
     * 租户类型编码
     */
    @ApiModelProperty("租户类型编码")
    private String tenantTypeCode;

    /**
     * 套餐编码
     */
    @ApiModelProperty("套餐编码")
    private String bundleCode;


}
