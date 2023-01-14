package mao.aggregate_pay_entity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import mao.tools_common.enums.HttpMethod;


import java.io.Serializable;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_log.entity
 * Class(类名): OptLog
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 14:08
 * Version(版本): 1.0
 * Description(描述)： 操作日志
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
@Accessors(chain = true)
@TableName("opt_log")
@ApiModel(value = "OptLog", description = "系统日志")
public class OptLog implements Serializable
{
    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "主键")
    private Long id;


    /**
     * 操作IP
     */
    @ApiModelProperty(value = "操作IP")
    @TableField(value = "request_ip", condition = LIKE)
    private String requestIp;

    /**
     * 日志类型
     * #LogType{OPT:操作类型;EX:异常类型}
     */
    @ApiModelProperty(value = "日志类型")
    @TableField("type")
    private LogType type;

    /**
     * 操作人
     */
    @ApiModelProperty(value = "操作人(商户id)")
    @TableField(value = "user_name", condition = LIKE)
    private Long userName;

    /**
     * 操作描述
     */
    @ApiModelProperty(value = "操作描述")
    @TableField(value = "description", condition = LIKE)
    private String description;

    /**
     * 类路径
     */
    @ApiModelProperty(value = "类路径")
    @TableField(value = "class_path", condition = LIKE)
    private String classPath;

    /**
     * 请求方法
     */
    @ApiModelProperty(value = "请求方法")
    @TableField(value = "action_method", condition = LIKE)
    private String actionMethod;

    /**
     * 请求地址
     */
    @ApiModelProperty(value = "请求地址")
    @TableField(value = "request_uri", condition = LIKE)
    private String requestUri;

    /**
     * 请求类型
     * #HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}
     */
    @ApiModelProperty(value = "请求类型")
    @TableField("http_method")
    private HttpMethod httpMethod;

    /**
     * 请求参数
     */
    @ApiModelProperty(value = "请求参数")
    @TableField("params")
    private String params;

    /**
     * 返回值
     */
    @ApiModelProperty(value = "返回值")
    @TableField("result")
    private String result;

    /**
     * 异常详情信息
     */
    @ApiModelProperty(value = "异常详情信息")
    @TableField("ex_desc")
    private String exDesc;

    /**
     * 异常描述
     */
    @ApiModelProperty(value = "异常描述")
    @TableField("ex_detail")
    private String exDetail;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    @TableField("start_time")
    private LocalDateTime startTime;

    /**
     * 完成时间
     */
    @ApiModelProperty(value = "完成时间")
    @TableField("finish_time")
    private LocalDateTime finishTime;

    /**
     * 消耗时间
     */
    @ApiModelProperty(value = "消耗时间")
    @TableField("consuming_time")
    private Long consumingTime;

    /**
     * 浏览器
     */
    @ApiModelProperty(value = "浏览器")
    @TableField(value = "ua", condition = LIKE)
    private String ua;

}
