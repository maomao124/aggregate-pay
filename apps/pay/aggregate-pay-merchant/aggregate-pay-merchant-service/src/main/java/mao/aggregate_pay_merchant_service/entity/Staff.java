package mao.aggregate_pay_merchant_service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.entity
 * Class(类名): Staff
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 14:32
 * Version(版本): 1.0
 * Description(描述)： 员工实体类
 */

@Data
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("staff")
public class Staff implements Serializable
{
    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 商户ID
     */
    @TableField("MERCHANT_ID")
    private Long merchantId;

    /**
     * 姓名
     */
    @TableField("FULL_NAME")
    private String fullName;

    /**
     * 职位
     */
    @TableField("POSITION")
    private String position;

    /**
     * 用户名(关联统一用户)
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 手机号(关联统一用户)
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 员工所属门店
     */
    @TableField("STORE_ID")
    private Long storeId;

    /**
     * 最后一次登录时间
     */
    @TableField("LAST_LOGIN_TIME")
    private LocalDateTime lastLoginTime;

    /**
     * 0表示禁用，1表示启用
     */
    @TableField("STAFF_STATUS")
    private Boolean staffStatus;

}
