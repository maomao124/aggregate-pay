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
 * Class(类名): AppPlatformChannel
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/13
 * Time(创建时间)： 22:25
 * Version(版本): 1.0
 * Description(描述)： 中间表，应用-平台支付渠道
 */

@Data
@TableName("app_platform_channel")
public class AppPlatformChannel implements Serializable
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
     * 应用id
     */
    @TableField("APP_ID")
    private String appId;

    /**
     * 平台支付渠道
     */
    @TableField("PLATFORM_CHANNEL")
    private String platformChannel;
}
