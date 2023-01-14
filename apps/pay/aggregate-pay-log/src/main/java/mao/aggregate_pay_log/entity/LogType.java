package mao.aggregate_pay_log.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mao.tools_core.base.BaseEnum;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_log.entity
 * Class(类名): LogType
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 14:12
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "LogType", description = "日志类型-枚举")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LogType implements BaseEnum
{

    /**
     * OPT="操作类型"
     */
    OPT("正常"),
    /**
     * EX="异常类型"
     */
    EX("异常"),
    ;

    @ApiModelProperty(value = "描述")
    private String desc;


    public static LogType match(String val, LogType def)
    {
        for (LogType enm : LogType.values())
        {
            if (enm.name().equalsIgnoreCase(val))
            {
                return enm;
            }
        }
        return def;
    }

    public static LogType get(String val)
    {
        return match(val, null);
    }

    public boolean eq(String val)
    {
        return this.name().equalsIgnoreCase(val);
    }

    public boolean eq(LogType val)
    {
        if (val == null)
        {
            return false;
        }
        return eq(val.name());
    }

    @Override
    @ApiModelProperty(value = "编码", allowableValues = "OPT,EX", example = "OPT")
    public String getCode()
    {
        return this.name();
    }

}
