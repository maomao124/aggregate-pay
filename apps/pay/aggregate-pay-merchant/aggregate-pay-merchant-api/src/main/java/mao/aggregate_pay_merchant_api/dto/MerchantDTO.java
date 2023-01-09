package mao.aggregate_pay_merchant_api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.dto
 * Class(类名): MerchantDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 15:04
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@ApiModel(value="MerchantDTO", description="商户")
public class MerchantDTO implements Serializable
{
    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 商户名称
     */
    @ApiModelProperty(value = "商户名称")
    private String merchantName;

    /**
     * 企业编号
     */
    @ApiModelProperty(value = "企业编号")
    private Long merchantNo;

    /**
     * 企业地址
     */
    @ApiModelProperty(value = "企业地址")
    private String merchantAddress;

    /**
     * 商户类型
     */
    @ApiModelProperty(value = "商户类型")
    private String merchantType;

    /**
     * 营业执照img
     */
    @ApiModelProperty(value = "营业执照（企业证明）")
    private String businessLicensesImg;

    /**
     * 法人身份证正面照片
     */
    @ApiModelProperty(value = "法人身份证正面照片")
    private String idCardFrontImg;

    /**
     * 法人身份证反面照片
     */
    @ApiModelProperty(value = "法人身份证反面照片")
    private String idCardAfterImg;

    /**
     * 联系人姓名
     */
    @ApiModelProperty(value = "联系人姓名")
    private String username;

    /**
     * 联系人手机号
     */
    @ApiModelProperty(value = "联系人手机号(关联统一账号)")
    private String mobile;

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    private String password;

    /**
     * 联系人地址
     */
    @ApiModelProperty(value = "联系人地址")
    private String contactsAddress;

    /**
     * 审核状态
     */
    @ApiModelProperty(value = "审核状态 0-未申请,1-已申请待审核,2-审核通过,3-审核拒绝")
    private String auditStatus;

    /**
     * 租户ID
     */
    @ApiModelProperty(value = "租户ID,关联统一用户")
    private Long tenantId;
}
