package mao.sms_entity.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mao.sms_entity.entity.base.BaseEntity;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.entity
 * Class(类名): ConfigTemplateEntity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/16
 * Time(创建时间)： 21:21
 * Version(版本): 1.0
 * Description(描述)： 配置—模板 实体类
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("config_template")
@ApiModel(description = "配置—模板 实体类")
public class ConfigTemplateEntity extends BaseEntity
{
    /**
     * 配置id
     */
    @ApiModelProperty(value = "配置主键")
    private String configId;

    /**
     * 模板id
     */
    @ApiModelProperty(value = "模板主键")
    private String templateId;

    /**
     * 配置模板代码
     */
    @ApiModelProperty(value = "通道模板代码  可能为空")
    private String configTemplateCode;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
}
