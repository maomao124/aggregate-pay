package mao.aggregate_pay_user_service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.entity
 * Class(类名): Bundle
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 20:36
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@TableName("bundle")
public class Bundle implements Serializable
{

    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value="ID",type = IdType.AUTO)
    private Long id;

    /**
     * 套餐名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 套餐编码
     */
    @TableField("CODE")
    private String code;

    /**
     * 租户类型编码
     */
    @TableField("TENANT_TYPE_CODE")
    private String tenantTypeCode;

    /**
     * 套餐包含功能描述,JSON格式的角色与权限
     */
    @TableField("ABILITY")
    private String ability;

    /**
     * API调用次数/月
     */
    @TableField("NUMBER_OF_INVOCATION")
    private Integer numberOfInvocation;

    /**
     * 并发数/秒
     */
    @TableField("NUMBER_OF_CONCURRENT")
    private Integer numberOfConcurrent;

    /**
     * 允许创建应用数量
     */
    @TableField("NUMBER_OF_APP")
    private Integer numberOfApp;

    /**
     * 套餐说明
     */
    @TableField("COMMENT")
    private String comment;

    /**
     * 是否为初始化套餐
     */
    @TableField("INITIALIZE")
    private Boolean initialize;

}
