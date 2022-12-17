package mao.sms_entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mao.sms_entity.entity.SendLogEntity;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.vo
 * Class(类名): SendLogVO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 20:15
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "发送日志")
public class SendLogVO extends SendLogEntity
{

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

    /**
     * 平台id
     */
    @ApiModelProperty("接入平台id")
    private String platformId;

    /**
     * 平台名称
     */
    @ApiModelProperty("接入平台名称")
    private String platformName;
}
