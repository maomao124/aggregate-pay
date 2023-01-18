package mao.aggregate_pay_user_api.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.resource
 * Class(类名): ApplicationQueryParams
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:12
 * Version(版本): 1.0
 * Description(描述)： 应用查询参数
 */

@Data
@ApiModel(value = "ApplicationQueryParams", description = "应用查询参数")
public class ApplicationQueryParams
{
    /**
     * 应用名称
     */
    @ApiModelProperty("应用名称(模糊匹配)")
    private String name;

}
