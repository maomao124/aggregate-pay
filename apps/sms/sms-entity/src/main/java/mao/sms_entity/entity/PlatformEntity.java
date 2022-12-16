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
 * Class(类名): PlatformEntity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/16
 * Time(创建时间)： 21:24
 * Version(版本): 1.0
 * Description(描述)： 接入平台实体类
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("platform")
@ApiModel(description = "接入平台实体类")
public class PlatformEntity extends BaseEntity
{
    /**
     * 名称"
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 访问密钥id
     */
    @ApiModelProperty("认证 key")
    private String accessKeyId;

    /**
     * 认证 秘钥
     */
    @ApiModelProperty("认证 秘钥")
    private String accessKeySecret;

    /**
     * ip地址
     */
    @ApiModelProperty("ip地址")
    private String ipAddr;

    /**
     * 需要身份验证
     */
    @ApiModelProperty("是否需要鉴权 0 不需要")
    private Integer needAuth;

    /**
     * 是否可用
     */
    @ApiModelProperty("是否可用：0不可用")
    private Integer isActive;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 等级
     */
    @ApiModelProperty("等级")
    private Integer level;
}
