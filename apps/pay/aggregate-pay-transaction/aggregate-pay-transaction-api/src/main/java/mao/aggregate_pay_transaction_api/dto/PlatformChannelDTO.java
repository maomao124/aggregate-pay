package mao.aggregate_pay_transaction_api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_api.dto
 * Class(类名): PlatformChannelDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/13
 * Time(创建时间)： 22:00
 * Version(版本): 1.0
 * Description(描述)： 平台支付渠道DTO
 */
@Data
@ApiModel(value = "PlatformChannelDTO", description = "平台支付渠道")
public class PlatformChannelDTO implements Serializable
{
    /**
     * id
     */
    @ApiModelProperty("支付渠道ID")
    private Long id;

    /**
     * 支付渠道名称
     */
    @ApiModelProperty("支付渠道名称")
    private String channelName;

    /**
     * 支付渠道编码
     */
    @ApiModelProperty("支付渠道编码")
    private String channelCode;
}
