package mao.sms_entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.dto
 * Class(类名): SmsBatchParamsDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 14:25
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel( description = "短信批量发送参数")
public class SmsBatchParamsDTO extends BaseParamsDTO
{
    /**
     * 手机号集合
     */
    @ApiModelProperty("手机号集合")
    private List<String> mobile = new ArrayList<>();

    /**
     * 模板编码集合
     */
    @ApiModelProperty("模板编码集合")
    private List<String> template = new ArrayList<>();

    /**
     * 签名编码集合
     */
    @ApiModelProperty("签名编码集合")
    private List<String> signature = new ArrayList<>();

    /**
     * 参数集合
     */
    @ApiModelProperty("参数集合")
    private List<LinkedHashMap<String, String>> params = new ArrayList<>();

    /**
     * 批次编码
     */
    @ApiModelProperty("批次编码")
    private String batchCode;
}
