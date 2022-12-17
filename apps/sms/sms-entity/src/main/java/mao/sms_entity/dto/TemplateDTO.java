package mao.sms_entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mao.sms_entity.entity.TemplateEntity;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.dto
 * Class(类名): TemplateDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:32
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "模板表")
public class TemplateDTO extends TemplateEntity
{
    /**
     * 是否选中
     */
    @ApiModelProperty("是否选中")
    private boolean selected;

    /**
     * 配置模板代码
     */
    @ApiModelProperty(value = "通道模板  可能为空")
    private String configTemplateCode;

    /**
     * 通道id
     */
    @ApiModelProperty(value = "通道id")
    private String configId;
}
