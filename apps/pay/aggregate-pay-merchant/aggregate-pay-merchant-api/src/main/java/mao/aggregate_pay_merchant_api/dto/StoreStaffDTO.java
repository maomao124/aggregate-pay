package mao.aggregate_pay_merchant_api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.dto
 * Class(类名): StoreStaffDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 15:09
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@ApiModel(value="StoreStaffDTO", description="")
public class StoreStaffDTO implements Serializable
{
    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 存储id
     */
    @ApiModelProperty(value = "门店标识")
    private Long storeId;

    /**
     * 员工id
     */
    @ApiModelProperty(value = "员工标识")
    private Long staffId;
}
