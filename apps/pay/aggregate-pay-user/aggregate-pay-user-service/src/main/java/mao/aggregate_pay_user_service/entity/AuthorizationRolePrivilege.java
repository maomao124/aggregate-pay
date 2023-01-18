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
 * Class(类名): AuthorizationRolePrivilege
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 20:35
 * Version(版本): 1.0
 * Description(描述)： 角色-权限关系
 */

@Data
@TableName("authorization_role_privilege")
public class AuthorizationRolePrivilege implements Serializable
{

    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 角色id
     */
    @TableField("ROLE_ID")
    private Long roleId;

    /**
     * 权限id
     */
    @TableField("PRIVILEGE_ID")
    private Long privilegeId;


}
