package mao.sms_entity.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import mao.sms_entity.entity.base.BaseEntity;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.entity
 * Class(类名): BlackListEntity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/16
 * Time(创建时间)： 21:13
 * Version(版本): 1.0
 * Description(描述)： 黑名单实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@TableName("black_list")
@ApiModel(description = "黑名单实体类")
public class BlackListEntity extends BaseEntity
{
    /**
     * 类型
     */
    @ApiModelProperty("类型：1短信、2邮件、3微信")
    private String type;

    /**
     * 内容，手机号
     */
    @ApiModelProperty("内容：手机号")
    private String content;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}
