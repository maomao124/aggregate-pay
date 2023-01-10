package mao.aggregate_pay_merchant_application.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.vo
 * Class(类名): MerchantRegisterVO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/10
 * Time(创建时间)： 21:18
 * Version(版本): 1.0
 * Description(描述)： 商户注册vo
 */
@Data
@ApiModel(value = "MerchantRegisterVO", description = "商户注册信息")
public class MerchantRegisterVO implements Serializable
{
    /**
     * 商户手机号
     */
    @ApiModelProperty("商户手机号")
    private String mobile;

    /**
     * 商户用户名
     */
    @ApiModelProperty("商户用户名")
    private String username;

    /**
     * 商户密码
     */
    @ApiModelProperty("商户密码")
    private String password;

    /**
     * 验证码的key
     */
    @ApiModelProperty("验证码的key")
    private String verifiykey;

    /**
     * 验证码
     */
    @ApiModelProperty("验证码")
    private String verifiyCode;
}
