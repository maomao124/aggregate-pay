package mao.aggregate_pay_merchant_api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.dto
 * Class(类名): StoreDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 15:07
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@ApiModel(value="StoreDTO", description="门店")
public class StoreDTO implements Serializable
{
    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "门店id")
    @JsonSerialize(using= ToStringSerializer.class)//进行json转换的时候 ，转成string
    private Long id;

    /**
     * 门店名称
     */
    @ApiModelProperty(value = "门店名称")
    private String storeName;

    /**
     * 门店编号
     */
    @ApiModelProperty(value = "门店编号")
    private Long storeNumber;

    /**
     * 所属商户
     */
    @ApiModelProperty(value = "所属商户")
    private Long merchantId;

    /**
     * 父门店
     */
    @ApiModelProperty(value = "父门店")
    private Long parentId;

    /**
     * 门店状态
     */
    @ApiModelProperty(value = "0表示禁用，1表示启用")
    private Boolean storeStatus;

    /**
     * 门店地址
     */
    @ApiModelProperty(value = "门店地址")
    private String storeAddress;
}
