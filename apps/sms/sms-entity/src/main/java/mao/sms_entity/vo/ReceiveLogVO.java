package mao.sms_entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mao.sms_entity.entity.ReceiveLogEntity;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.vo
 * Class(类名): ReceiveLogVO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:55
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "接收日志表")
public class ReceiveLogVO extends ReceiveLogEntity
{
    /**
     * 通道名称
     */
    @ApiModelProperty("通道名称")
    private String configName;

    /**
     * 签名名字
     */
    @ApiModelProperty("签名名称")
    private String signatureName;

    /**
     * 模板名称
     */
    @ApiModelProperty("模板名称")
    private String templateName;
}
