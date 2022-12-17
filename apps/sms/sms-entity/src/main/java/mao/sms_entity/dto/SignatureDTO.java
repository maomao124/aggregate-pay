package mao.sms_entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import mao.sms_entity.entity.SignatureEntity;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.dto
 * Class(类名): SignatureDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:31
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@ApiModel(description = "签名表")
public class SignatureDTO extends SignatureEntity
{
    /**
     * 是否选中
     */
    @ApiModelProperty("是否选中")
    private boolean selected;

    /**
     * 三方通道签名
     */
    @ApiModelProperty(value = "三方通道签名")
    private String configSignatureCode;

    /**
     * 通道id
     */
    @ApiModelProperty(value = "通道id")
    private String configId;
}
