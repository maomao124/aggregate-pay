package mao.sms_entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.dto
 * Class(类名): BaseParamsDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 14:24
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
public class BaseParamsDTO implements Serializable
{
    /**
     * 接入key
     */
    @ApiModelProperty("接入key")
    private String accessKeyId;

    /**
     * 认证值
     */
    @ApiModelProperty("认证值")
    private String encryption;

    /**
     * 发送时间戳
     */
    @ApiModelProperty("发送时间戳")
    private String timestamp;

    /**
     * 定时时间
     */
    @ApiModelProperty("定时时间 yyyy-MM-dd HH:mm")
    private String sendTime;
}
