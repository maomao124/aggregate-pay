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
 * Class(类名): ReceiveLogEntity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/16
 * Time(创建时间)： 21:38
 * Version(版本): 1.0
 * Description(描述)： 接收日志实体类
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("receive_log")
@ApiModel("接收日志实体类")
public class ReceiveLogEntity extends BaseEntity
{
    /**
     * 接入平台id
     */
    @ApiModelProperty("接入平台id")
    private String platformId;

    /**
     * 接入平台名称
     */
    @ApiModelProperty("接入平台名称")
    private String platformName;

    /**
     * 业务信息
     */
    @ApiModelProperty("业务信息 由平台方自定义")
    private String business;

    /**
     * 配置主键集合
     */
    @ApiModelProperty("配置主键集合")
    private String configIds;

    /**
     * 模板
     */
    @ApiModelProperty("模板")
    private String template;

    /**
     * 签名
     */
    @ApiModelProperty("签名")
    private String signature;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 请求参数
     */
    @ApiModelProperty("请求参数")
    private String request;

    /**
     * 错误信息
     */
    @ApiModelProperty("错误信息")
    private String error;

    /**
     * 耗时
     */
    @ApiModelProperty("耗时")
    private Long useTime;

    /**
     * 日志id
     */
    @ApiModelProperty(value = "日志id")
    private String apiLogId;

    @ApiModelProperty("状态：0失败，1成功")
    private int status;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

}
