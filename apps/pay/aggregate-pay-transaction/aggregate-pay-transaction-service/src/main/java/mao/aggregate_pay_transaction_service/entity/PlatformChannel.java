package mao.aggregate_pay_transaction_service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.entity
 * Class(类名): PlatformChannel
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/13
 * Time(创建时间)： 22:39
 * Version(版本): 1.0
 * Description(描述)： 平台支付渠道
 */

@Data
@TableName("platform_channel")
public class PlatformChannel implements Serializable
{
    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "ID", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 平台支付渠道名称
     */
    @TableField("CHANNEL_NAME")
    private String channelName;

    /**
     * 平台支付渠道编码
     */
    @TableField("CHANNEL_CODE")
    private String channelCode;
}
