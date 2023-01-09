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
 * Class(类名): Store
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 14:33
 * Version(版本): 1.0
 * Description(描述)： 门店实体类
 */

@Data
@EqualsAndHashCode
@Builder
@TableName("store")
public class Store implements Serializable
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
     * 门店名称
     */
    @TableField("STORE_NAME")
    private String storeName;

    /**
     * 门店编号
     */
    @TableField("STORE_NUMBER")
    private Long storeNumber;

    /**
     * 所属商户
     */
    @TableField("MERCHANT_ID")
    private Long merchantId;

    /**
     * 父门店
     */
    @TableField("PARENT_ID")
    private Long parentId;

    /**
     * 0表示禁用，1表示启用
     */
    @TableField("STORE_STATUS")
    private Boolean storeStatus;

    /**
     * 门店地址
     */
    @TableField("STORE_ADDRESS")
    private String storeAddress;
}
