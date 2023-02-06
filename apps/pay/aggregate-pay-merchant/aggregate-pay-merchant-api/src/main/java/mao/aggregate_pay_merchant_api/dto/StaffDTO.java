package mao.aggregate_pay_merchant_api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.dto
 * Class(类名): StaffDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 15:06
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@ApiModel(value="StaffDTO", description="员工")
public class StaffDTO  implements Serializable
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
     * 商户ID
     */
    @ApiModelProperty(value = "商户ID")
    private Long merchantId;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String fullName;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String fullname;

    /**
     * 职位
     */
    @ApiModelProperty(value = "职位")
    private String position;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名(关联统一用户)")
    private String username;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号(关联统一用户)")
    private String mobile;

    /**
     * 员工所属门店
     */
    @ApiModelProperty(value = "员工所属门店")
    private Long storeId;

    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后一次登录时间")
    private LocalDateTime lastLoginTime;

    /**
     * 员工状态
     */
    @ApiModelProperty(value = "0表示禁用，1表示启用")
    private Boolean staffStatus;


    public String getFullname()
    {
        return fullname;
    }

    public void setFullname(String fullname)
    {
        this.fullname = fullname;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }
}
