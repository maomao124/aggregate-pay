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
 * Class(类名): ManualProcessEntity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/16
 * Time(创建时间)： 21:22
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("manual_process")
@ApiModel("人工处理任务实体类")
public class ManualProcessEntity extends BaseEntity
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
     * 请求
     */
    @ApiModelProperty("请求参数")
    private String request;

    /**
     * 通道id集合
     */
    @ApiModelProperty("通道id集合")
    private String configIds;

    /**
     * 状态
     */
    @ApiModelProperty("状态 0新建，1处理中，2处理成功，3处理失败")
    private int status;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}
