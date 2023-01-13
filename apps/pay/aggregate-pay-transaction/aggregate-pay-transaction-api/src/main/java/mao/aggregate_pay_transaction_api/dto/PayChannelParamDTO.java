package mao.aggregate_pay_transaction_api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_api.dto
 * Class(类名): PayChannelParamDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/13
 * Time(创建时间)： 21:55
 * Version(版本): 1.0
 * Description(描述)： 商户原始支付渠道参数配置DTO
 */

@Data
@ApiModel(value = "PayChannelParamDTO", description = "商户原始支付渠道参数配置")
public class PayChannelParamDTO implements Serializable
{
    /**
     * id
     */
    @ApiModelProperty("参数配置id,新增时无需")
    private Long id;

    /**
     * 应用程序id
     */
    @ApiModelProperty("应用的appId,是业务id")
    private String appId;

    /**
     * 应用绑定的服务类型对应的code
     */
    @ApiModelProperty("应用绑定的服务类型对应的code")
    private String platformChannelCode;

    /**
     * 参数配置名称
     */
    @ApiModelProperty("参数配置名称")
    private String channelName;

    /**
     * 商户id
     */
    @ApiModelProperty("商户id")
    private Long merchantId;

    /**
     * 原始支付渠道编码
     */
    @ApiModelProperty("原始支付渠道编码")
    private String payChannel;

    /**
     * 参数
     */
    @ApiModelProperty("原始支付渠道参数配置内容，json格式")
    private String param;

    /**
     * 应用绑定的服务类型Id
     */
    @ApiModelProperty("应用绑定的服务类型Id")
    private Long appPlatformChannelId;
}
