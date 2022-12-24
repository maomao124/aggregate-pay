package mao.sms_entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.dto
 * Class(类名): SmsParamsDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 14:26
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel( description = "短信发送参数")
public class SmsParamsDTO  extends BaseParamsDTO
{
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 模板编码
     */
    @ApiModelProperty("模板编码")
    private String template;

    /**
     * 签名编码
     */
    @ApiModelProperty("签名编码")
    private String signature;

    /**
     * 参数
     */
    @ApiModelProperty("参数")
    private Map<String, String> params;
}
