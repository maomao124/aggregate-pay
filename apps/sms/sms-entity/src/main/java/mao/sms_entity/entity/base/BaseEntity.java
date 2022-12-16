package mao.sms_entity.entity.base;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.entity.base
 * Class(类名): BaseEntity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/16
 * Time(创建时间)： 21:14
 * Version(版本): 1.0
 * Description(描述)： 基础实体类
 */

@Data
public class BaseEntity
{
    /**
     * id
     */
    @TableId
    @ApiModelProperty(value = "主键")
    private String id;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 创建用户
     */
    @ApiModelProperty(value = "创建人")
    private String createUser = "0";

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    /**
     * 更新用户
     */
    @ApiModelProperty(value = "修改人")
    private String updateUser;

    /**
     * 是否为逻辑删除
     */
    @ApiModelProperty(value = "逻辑删除：0删除")
    private Integer isDelete;

}
