package mao.sms_entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.dto
 * Class(类名): ConfigUpdateOtherDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:29
 * Version(版本): 1.0
 * Description(描述)： 通道修改关联中的其他配置
 */

@Data
@ApiModel(description = "通道修改关联中的其他配置")
public class ConfigUpdateOtherDTO
{
    /**
     * 签名id
     */
    @ApiModelProperty("签名id")
    private String signatureId;

    /**
     * 三方通道签名
     */
    @ApiModelProperty("三方通道签名")
    private String configSignatureCode;

    /**
     * 模板id
     */
    @ApiModelProperty("模板id")
    private String templateId;

    /**
     * 三方通道模板
     */
    @ApiModelProperty("三方通道模板")
    private String configTemplateCode;

    /**
     * 通道id
     */
    @ApiModelProperty("通道id")
    private String configId;
}
