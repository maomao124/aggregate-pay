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
 * Class(类名): ConfigSignatureEntity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/16
 * Time(创建时间)： 21:20
 * Version(版本): 1.0
 * Description(描述)： 配置—签名 实体类
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("config_signature")
@ApiModel(description = "配置—签名 实体类")
public class ConfigSignatureEntity extends BaseEntity
{
    /**
     * 配置id
     */
    @ApiModelProperty(value = "配置主键")
    private String configId;

    /**
     * 签名id
     */
    @ApiModelProperty(value = "签名主键")
    private String signatureId;

    /**
     * 配置签名代码
     */
    @ApiModelProperty(value = "通道签名代码")
    private String configSignatureCode;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
}
