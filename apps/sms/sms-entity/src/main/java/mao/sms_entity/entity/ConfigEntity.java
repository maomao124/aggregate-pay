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
 * Class(类名): ConfigEntity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/16
 * Time(创建时间)： 21:16
 * Version(版本): 1.0
 * Description(描述)： 通道配置实体类
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("config")
@ApiModel(description = "配置实体类")
public class ConfigEntity extends BaseEntity
{
    /**
     * 名字
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 平台
     */
    @ApiModelProperty(value = "平台")
    private String platform;

    /**
     * 域名
     */
    @ApiModelProperty(value = "域名")
    private String domain;

    /**
     * 访问密钥id
     */
    @ApiModelProperty(value = "秘钥id")
    private String accessKeyId;

    /**
     * 秘钥值
     */
    @ApiModelProperty(value = "秘钥值")
    private String accessKeySecret;

    /**
     * 其他配置
     */
    @ApiModelProperty(value = "其他配置 json格式")
    private String other;

    /**
     * 是否可用
     */
    @ApiModelProperty(value = "是否可用：0不可用")
    private Integer isActive;

    /**
     * 是否开启
     */
    @ApiModelProperty(value = "是否开启：0未开启")
    private Integer isEnable;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 级别，这个字段会动态地调节级别
     */
    @ApiModelProperty(value = "级别")
    private Integer level;

    /**
     * 通道类型
     */
    @ApiModelProperty(value = "通道类型，1：文字，2：语音，3：推送")
    private Integer channelType;
}
