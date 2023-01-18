package mao.aggregate_pay_user_api.dto.tenant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.tenant
 * Class(类名): BundleDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:31
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@ApiModel(value = "BundleDTO", description = "套餐信息")
public class BundleDTO implements Serializable
{

    /**
     * id
     */
    @ApiModelProperty("主键，套餐id")
    private Long id;

    /**
     * 套餐名称
     */
    @ApiModelProperty("套餐名称")
    private String name;

    /**
     * 套餐编码
     */
    @ApiModelProperty("套餐编码")
    private String code;

    /**
     * 租户类型编码
     */
    @ApiModelProperty("租户类型编码")
    private String tenantTypeCode;

    /**
     * 套餐包含功能描述
     */
    @ApiModelProperty("套餐包含功能描述,JSON格式的角色与权限")
    private String ability;

    /**
     * API调用次数
     */
    @ApiModelProperty("API调用次数/月")
    private Integer numberOfInvocation;

    /**
     * 并发数
     */
    @ApiModelProperty("并发数/秒")
    private Integer numberOfConcurrent;

    /**
     * 允许创建应用数量
     */
    @ApiModelProperty("允许创建应用数量")
    private Integer numberOfApp;

    /**
     * 套餐说明
     */
    @ApiModelProperty("套餐说明")
    private String comment;

    /**
     * 是否为初始化套餐
     */
    @ApiModelProperty("是否为初始化套餐,1表示是初始化套餐，0表示不是")
    private Boolean initialize;

}
