package mao.aggregate_pay_user_api.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.dto.auth
 * Class(类名): PrivilegeTreeDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:06
 * Version(版本): 1.0
 * Description(描述)： 权限树结构
 */


@Data
@ApiModel(value = "PrivilegeTreeDTO", description = "权限树信息")
public class PrivilegeTreeDTO implements Serializable
{
    /**
     * 权限组使用id,权限使用code，约束code不能为纯数值保证不重复
     */
    @ApiModelProperty("节点唯一标识，权限组使用id，权限使用code，约束code不能为纯数值保证不重复。")
    private String id;

    /**
     * 节点名称
     */
    @ApiModelProperty("节点名称")
    private String name;

    /**
     * 一定是权限组id，权限没有结构
     */
    @ApiModelProperty("父节点标识")
    private String parentId;//父级id

    /**
     * 同层排序,不排序都为0
     */
    @ApiModelProperty("排序")
    private Integer sort;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Integer status;

    /**
     * 是否为权限组
     */
    @ApiModelProperty("是否为权限组")
    private boolean isGroup = true;

    /**
     * 子节点集合
     */
    @ApiModelProperty("子节点集合")
    private List<PrivilegeTreeDTO> children = new ArrayList<>();
}
