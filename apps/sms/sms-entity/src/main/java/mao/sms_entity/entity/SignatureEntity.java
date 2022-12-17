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
 * Class(类名): SignatureEntity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:21
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("signature")
@ApiModel(description = "签名实体类")
public class SignatureEntity extends BaseEntity
{
    /**
     * 签名名称
     */
    @ApiModelProperty(value = "签名名称")
    private String name;

    /**
     * 签名编码
     */
    @ApiModelProperty(value = "签名编码")
    private String code;

    /**
     * 签名内容
     */
    @ApiModelProperty(value = "签名内容")
    private String content;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
}