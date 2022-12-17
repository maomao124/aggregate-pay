package mao.sms_entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.dto
 * Class(类名): SmsSendDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:36
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@ApiModel(description = "短信发送")
public class SmsSendDTO
{
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 模板编码
     */
    @ApiModelProperty("模板编码")
    private String template;

    /**
     * 签名编码
     */
    @ApiModelProperty("签名编码")
    private String signature;

    /**
     * 参数
     */
    @ApiModelProperty("参数")
    private Map<String, String> params;

    /**
     * 通道配置编码
     */
    @ApiModelProperty("通道配置编码")
    private List<String> configIds;

    /**
     * 定时时间
     */
    @ApiModelProperty("定时时间 yyyy-MM-dd HH:mm")
    private String sendTime;

    /**
     * 日志id
     */
    @ApiModelProperty("日志主键")
    private String logId;

    /**
     * 批次编码
     */
    @ApiModelProperty("批次编码")
    private String batchCode;
}
