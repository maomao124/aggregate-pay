package mao.aggregate_pay_common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.domain
 * Class(类名): RestResponse
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 14:51
 * Version(版本): 1.0
 * Description(描述)： 响应通用参数包装类
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "RestResponse<T>", description = "响应通用参数包装")
public class RestResponse<T>
{
    /**
     * 响应错误编码
     */
    @ApiModelProperty("响应错误编码,0为正常")
    private int code;

    /**
     * 响应错误信息
     */
    @ApiModelProperty("响应错误信息")
    private String msg;

    /**
     * 响应内容
     */
    @ApiModelProperty("响应内容")
    private T result;

    /**
     * 成功
     *
     * @return {@link RestResponse}<{@link T}>
     */
    public static <T> RestResponse<T> success()
    {
        return new RestResponse<T>();
    }

    /**
     * 成功
     *
     * @param result 结果
     * @return {@link RestResponse}<{@link T}>
     */
    public static <T> RestResponse<T> success(T result)
    {
        RestResponse<T> response = new RestResponse<T>();
        response.setResult(result);
        return response;
    }

    /**
     * 失败
     *
     * @param msg 消息
     * @return {@link RestResponse}<{@link T}>
     */
    public static <T> RestResponse<T> validfail(String msg)
    {
        RestResponse<T> response = new RestResponse<T>();
        response.setCode(-2);
        response.setMsg(msg);
        return response;
    }

    /**
     * 构造方法
     */
    public RestResponse()
    {
        this(0, "");
    }

    /**
     * 构造方法
     *
     * @param code 代码
     * @param msg  消息
     */
    public RestResponse(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取代码
     *
     * @return int
     */
    public int getCode()
    {
        return code;
    }

    /**
     * 设置代码
     *
     * @param code 代码
     */
    public void setCode(int code)
    {
        this.code = code;
    }

    /**
     * 得到消息
     *
     * @return {@link String}
     */
    public String getMsg()
    {
        return msg;
    }

    /**
     * 设置消息
     *
     * @param msg 消息
     */
    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    /**
     * 得到结果
     *
     * @return {@link T}
     */
    public T getResult()
    {
        return result;
    }

    /**
     * 设置结果
     *
     * @param result 结果
     */
    public void setResult(T result)
    {
        this.result = result;
    }

    @Override
    public String toString()
    {
        return "RestResponse [code=" + code + ", msg=" + msg + ", result="
                + result + "]";
    }

}
