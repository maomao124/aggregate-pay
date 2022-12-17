package mao.sms_entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mao.sms_entity.entity.ConfigEntity;

import java.util.List;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.dto
 * Class(类名): ConfigDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:28
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "配置表")
public class ConfigDTO extends ConfigEntity
{

    /**
     * 最近一小时成功的数量
     */
    private int lastSuccessNumInAnHour;

    /**
     * 最后成功数量
     */
    private int lastSuccessNum;

    /**
     * 签名信息
     */
    @ApiModelProperty("签名信息")
    private List<SignatureDTO> signatureDTOS;

    /**
     * 签名id集合
     */
    @ApiModelProperty("签名id集合")
    private List<String> signatureIds;

    /**
     * 模板信息
     */
    @ApiModelProperty("模板信息")
    private List<TemplateDTO> templateDTOS;

    /**
     * 模板id集合
     */
    @ApiModelProperty("模板id集合")
    private List<String> templateIds;

    /**
     * 平台dto
     */
    @ApiModelProperty("测试")
    private PlatformDTO platformDTO;
}
