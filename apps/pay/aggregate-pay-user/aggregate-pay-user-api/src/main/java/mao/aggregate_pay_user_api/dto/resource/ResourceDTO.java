package mao.aggregate_pay_user_api.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.resource
 * Class(类名): ResourceDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:14
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@ApiModel(value = "ResourceDTO", description = "应用资源")
public class ResourceDTO implements Serializable
{

    /**
     * 应用程序代码
     */
    @ApiModelProperty("应用编码")
    String applicationCode;


    /**
     * 应用程序名称
     */
    @ApiModelProperty("应用名称")
    String applicationName;

    /**
     * 按资源类型分包括菜单等资源信息 如  menu:JSONObject
     */
    @ApiModelProperty("应用包含资源，按资源类型分包括菜单等资源信息 如  menu:JSONObject")
    Map<String, Object> appRes = new HashMap<>();


}
