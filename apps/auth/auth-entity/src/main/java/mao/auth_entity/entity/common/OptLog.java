package mao.auth_entity.entity.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import mao.auth_entity.enumeration.common.LogType;
import mao.tools_common.enums.HttpMethod;
import mao.tools_core.base.entity.SuperEntity;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * <p>
 * 实体类
 * 系统日志
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("common_opt_log")
@ApiModel(value = "OptLog", description = "系统日志")
public class OptLog extends SuperEntity<Long>
{

    private static final long serialVersionUID = 1L;

    /**
     * 操作IP
     */
    @ApiModelProperty(value = "操作IP")
    @Length(max = 50, message = "操作IP长度不能超过50")
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
    @ApiModelProperty(value = "操作人")
    @Length(max = 50, message = "操作人长度不能超过50")
    @TableField(value = "user_name", condition = LIKE)
    private String userName;

    /**
     * 操作描述
     */
    @ApiModelProperty(value = "操作描述")
    @Length(max = 255, message = "操作描述长度不能超过255")
    @TableField(value = "description", condition = LIKE)
    private String description;

    /**
     * 类路径
     */
    @ApiModelProperty(value = "类路径")
    @Length(max = 255, message = "类路径长度不能超过255")
    @TableField(value = "class_path", condition = LIKE)
    private String classPath;

    /**
     * 请求方法
     */
    @ApiModelProperty(value = "请求方法")
    @Length(max = 50, message = "请求方法长度不能超过50")
    @TableField(value = "action_method", condition = LIKE)
    private String actionMethod;

    /**
     * 请求地址
     */
    @ApiModelProperty(value = "请求地址")
    @Length(max = 50, message = "请求地址长度不能超过50")
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
    @Length(max = 500, message = "浏览器长度不能超过500")
    @TableField(value = "ua", condition = LIKE)
    private String ua;


    /**
     * 构造方法
     *
     * @param id            id
     * @param createTime    创建时间
     * @param createUser    创建用户
     * @param requestIp     请求ip
     * @param type          类型
     * @param userName      用户名
     * @param description   描述
     * @param classPath     类路径
     * @param actionMethod  操作方法
     * @param requestUri    请求uri
     * @param httpMethod    http方法
     * @param params        参数个数
     * @param result        结果
     * @param exDesc        desc交货
     * @param exDetail      详细交货
     * @param startTime     开始时间
     * @param finishTime    完成时间
     * @param consumingTime 消耗时间
     * @param ua            ua
     */
    @Builder
    public OptLog(Long id, LocalDateTime createTime, Long createUser,
                  String requestIp, LogType type, String userName, String description, String classPath,
                  String actionMethod, String requestUri, HttpMethod httpMethod, String params, String result, String exDesc,
                  String exDetail, LocalDateTime startTime, LocalDateTime finishTime, Long consumingTime, String ua)
    {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.requestIp = requestIp;
        this.type = type;
        this.userName = userName;
        this.description = description;
        this.classPath = classPath;
        this.actionMethod = actionMethod;
        this.requestUri = requestUri;
        this.httpMethod = httpMethod;
        this.params = params;
        this.result = result;
        this.exDesc = exDesc;
        this.exDetail = exDetail;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.consumingTime = consumingTime;
        this.ua = ua;
    }

}
