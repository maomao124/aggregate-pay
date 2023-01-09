package mao.aggregate_pay_merchant_api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.dto
 * Class(类名): AppDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 15:02
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@ApiModel(value="AppDTO", description="应用程序")
public class AppDTO implements Serializable
{
    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 1L;

    /**
     * 应用程序id
     */
    private String appId;

    /**
     * 商店名称
     */
    @ApiModelProperty(value = "商店名称")
    private String appName;

    /**
     * 所属商户
     */
    @ApiModelProperty(value = "所属商户")
    private Long merchantId;

    /**
     * 公钥
     */
    @ApiModelProperty(value = "应用公钥(RSAWithSHA256)")
    private String publicKey;

    /**
     * 授权回调地址
     */
    @ApiModelProperty(value = "授权回调地址")
    private String notifyUrl;
}
