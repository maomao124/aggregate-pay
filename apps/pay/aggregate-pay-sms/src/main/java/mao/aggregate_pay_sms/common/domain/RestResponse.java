package mao.aggregate_pay_sms.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "RestResponse<T>", description = "响应通用参数包装")
public class RestResponse<T>
{

	/**
	 * 代码
	 */
	@ApiModelProperty("响应错误编码,0为正常")
    private int code;

	/**
	 * 消息
	 */
	@ApiModelProperty("响应错误信息")
    private String msg;

	/**
	 * 结果
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
	 * validfail
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
	 * 其他反应
	 */
	public RestResponse()
    {
        this(0, "");
    }

	/**
	 * 其他反应
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
	 * 集消息
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
	 * 组结果
	 *
	 * @param result 结果
	 */
	public void setResult(T result)
    {
        this.result = result;
    }

	/**
	 * 是成功
	 *
	 * @return {@link Boolean}
	 */
	@JsonIgnore
    public Boolean isSuccessful()
    {
        return this.code == 0;
    }

	/**
	 * 字符串
	 *
	 * @return {@link String}
	 */
	@Override
    public String toString()
    {
        return "RestResponse [code=" + code + ", msg=" + msg + ", result="
                + result + "]";
    }

}
