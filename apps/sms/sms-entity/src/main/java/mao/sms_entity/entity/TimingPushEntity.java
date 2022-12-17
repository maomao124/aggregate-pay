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
 * Class(类名): TimingPushEntity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:22
 * Version(版本): 1.0
 * Description(描述)： 定时发送实体类
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("timing_push")
@ApiModel("定时发送实体类")
public class TimingPushEntity extends BaseEntity
{
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
     * 参数
     */
    @ApiModelProperty("参数json")
    private String request;

    /**
     * 状态
     */
    @ApiModelProperty("状态 0:未处理 1:已处理")
    private Integer status;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 发送时间
     */
    @ApiModelProperty("发送时间")
    private String timing;
}
