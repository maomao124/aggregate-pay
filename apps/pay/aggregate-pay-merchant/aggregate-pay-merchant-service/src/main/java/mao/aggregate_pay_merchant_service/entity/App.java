package mao.aggregate_pay_merchant_service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.entity
 * Class(类名): App
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 14:30
 * Version(版本): 1.0
 * Description(描述)： 应用程序
 */

@Data
@EqualsAndHashCode
@Builder
@TableName("app")
public class App implements Serializable
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
     * 应用程序id
     */
    @TableField("APP_ID")
    private String appId;

    /**
     * 商店名称
     */
    @TableField("APP_NAME")
    private String appName;

    /**
     * 所属商户
     */
    @TableField("MERCHANT_ID")
    private Long merchantId;

    /**
     * 应用公钥(RSAWithSHA256)
     */
    @TableField("PUBLIC_KEY")
    private String publicKey;

    /**
     * 授权回调地址
     */
    @TableField("NOTIFY_URL")
    private String notifyUrl;
}
