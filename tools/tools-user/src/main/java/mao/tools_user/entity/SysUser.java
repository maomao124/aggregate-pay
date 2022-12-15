package mao.tools_user.entity;

import lombok.*;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.entity
 * Class(类名): SysUser
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:30
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
@Builder
public class SysUser
{
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 组织ID
     * #pd_core_org
     */
    private Long orgId;

    /**
     * 岗位ID
     * #pd_core_station
     */
    private Long stationId;


    /**
     * 手机
     * 启用条件： LoginUser.isFull = true || LoginUser.isUser = true
     */
    private String mobile;

    /**
     * 照片
     * 启用条件： LoginUser.isFull = true || LoginUser.isUser = true
     */
    private String photo;

    /**
     * 工作描述
     * 比如：  市长、管理员、局长等等   用于登陆展示
     * 启用条件： LoginUser.isFull = true || LoginUser.isUser = true
     */
    private String workDescribe;

    /**
     * 登录次数
     * 一直累计，记录了此账号总共登录次数
     * 启用条件： LoginUser.isFull = true || LoginUser.isUser = true
     */
    private Integer loginCount;

    /**
     * 当前登录用户的角色编码
     * 启用条件： LoginUser.isFull = true || LoginUser.isRole = true
     */
    private List<SysRole> roles;
    /**
     * 当前登录用户的组织架构
     * 启用条件： LoginUser.isFull = true || LoginUser.isOrg = true
     */
    private SysOrg org;
    /**
     * 当前登录用户的 岗位
     * 启用条件： LoginUser.isFull = true || LoginUser.isStation = true
     */
    private SysStation station;
}
