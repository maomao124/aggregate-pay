package mao.aggregate_pay_merchant_application.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.vo
 * Class(类名): MerchantDetailVO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/11
 * Time(创建时间)： 21:26
 * Version(版本): 1.0
 * Description(描述)： 资质申请信息
 */

@Data
@ApiModel(value = "MerchantDetailVO", description = "商户资质申请信息")
public class MerchantDetailVO implements Serializable
{
    /**
     * 企业名称
     */
    @ApiModelProperty("企业名称")
    private String merchantName;

    /**
     * 企业编号
     */
    @ApiModelProperty("企业编号")
    private String merchantNo;

    /**
     * 企业地址
     */
    @ApiModelProperty("企业地址")
    private String merchantAddress;

    /**
     * 行业类型
     */
    @ApiModelProperty("行业类型")
    private String merchantType;

    /**
     * 营业执照图片
     */
    @ApiModelProperty("营业执照")
    private String businessLicensesImg;

    /**
     * 法人身份证正面
     */
    @ApiModelProperty("法人身份证正面")
    private String idCardFrontImg;

    /**
     * 法人身份证反面
     */
    @ApiModelProperty("法人身份证反面")
    private String idCardAfterImg;

    /**
     * 联系人
     */
    @ApiModelProperty("联系人")
    private String username;

    /**
     * 联系人地址
     */
    @ApiModelProperty("联系人地址")
    private String contactsAddress;
}
