package mao.aggregate_pay_user_api.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.resource
 * Class(类名): ApplicationDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:11
 * Version(版本): 1.0
 * Description(描述)： 应用信息
 */

@Data
@ApiModel(value = "ApplicationDTO", description = "应用信息")
public class ApplicationDTO implements Serializable
{
    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 应用名称
     */
    @ApiModelProperty("应用名称")
    private String name;

    /**
     * 应用编码
     */
    @ApiModelProperty("应用编码,跨租户唯一")
    private String code;

    /**
     * 应用所属租户
     */
    @ApiModelProperty("应用所属租户")
    private Long tenantId;

}
