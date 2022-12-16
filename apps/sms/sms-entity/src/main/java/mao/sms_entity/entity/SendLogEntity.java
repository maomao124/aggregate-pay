package mao.sms_entity.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mao.sms_entity.entity.base.BaseEntity;
import mao.sms_entity.exception.SmsException;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.entity
 * Class(类名): SendLogEntity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/16
 * Time(创建时间)： 21:40
 * Version(版本): 1.0
 * Description(描述)： 发送日志实体类
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("send_log")
@ApiModel(description = "发送日志实体类")
public class SendLogEntity extends BaseEntity
{
    /**
     * 配置主键
     */
    @ApiModelProperty(value = "配置主键")
    private String configId;

    /**
     * 配置平台
     */
    @ApiModelProperty(value = "配置平台")
    private String configPlatform;

    /**
     * 配置名称
     */
    @ApiModelProperty(value = "配置名称")
    private String configName;

    /**
     * 模板
     */
    @ApiModelProperty(value = "模板")
    private String template;

    /**
     * 签名
     */
    @ApiModelProperty(value = "签名")
    private String signature;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;

    /**
     * 请求参数
     */
    @ApiModelProperty(value = "请求参数")
    private String request;

    /**
     * 返回参数
     */
    @ApiModelProperty(value = "返回参数")
    private String response;

    /**
     * 错误信息
     */
    @ApiModelProperty(value = "错误信息")
    private String error;

    /**
     * 耗时
     */
    @ApiModelProperty(value = "耗时")
    private Long useTime;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态：0失败，1成功")
    private Integer status;

    /**
     * 日志id
     */
    @ApiModelProperty(value = "日志id")
    private String apiLogId;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;


    /**
     * 检查响应
     *
     * @param response 响应
     */
    public void checkResponse(String response)
    {
        if (response.startsWith("FAIL@#@"))
        {
            String[] responseArray = response.split("@#@");
            this.response = responseArray[2];
            throw new SmsException(responseArray[1]);
        }
        else
        {
            this.response = response;
        }
    }
}
