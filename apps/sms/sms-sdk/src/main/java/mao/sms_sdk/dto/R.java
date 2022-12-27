package mao.sms_sdk.dto;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_sdk.dto
 * Class(类名): R
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/27
 * Time(创建时间)： 19:51
 * Version(版本): 1.0
 * Description(描述)： 前后端统一数据交互格式的类
 */

@Getter
@Setter
@SuppressWarnings({"AlibabaClassNamingShouldBeCamel"})
@Accessors(chain = true)
public class R<T>
{
    public static final String DEF_ERROR_MESSAGE = "系统繁忙，请稍候再试";
    public static final String HYSTRIX_ERROR_MESSAGE = "请求超时，请稍候再试";
    public static final int SUCCESS_CODE = 0;
    public static final int FAIL_CODE = -1;
    public static final int TIMEOUT_CODE = -2;
    /**
     * 统一参数验证异常
     */
    public static final int VALID_EX_CODE = -9;
    public static final int OPERATION_EX_CODE = -10;
    /**
     * 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode]
     */
    private int code;

    /**
     * 调用结果
     */
    private T data;

    /**
     * 结果消息，如果调用成功，消息通常为空T
     */
    private String msg = "ok";

    /**
     * 路径
     */
    private String path;
    /**
     * 附加数据
     */
    private Map<String, Object> extra;

    /**
     * 响应时间
     */
    private long timestamp = System.currentTimeMillis();

    private R()
    {
        super();
    }

    /**
     * r
     *
     * @param code 代码
     * @param data 数据
     * @param msg  消息
     */
    public R(int code, T data, String msg)
    {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 结果
     *
     * @param code 代码
     * @param data 数据
     * @param msg  消息
     * @return {@link R}<{@link E}>
     */
    public static <E> R<E> result(int code, E data, String msg)
    {
        return new R<>(code, data, msg);
    }

    /**
     * 请求成功消息
     *
     * @param data 结果
     * @return RPC调用结果
     */
    public static <E> R<E> success(E data)
    {
        return new R<>(SUCCESS_CODE, data, "ok");
    }

    public static R<Boolean> success()
    {
        return new R<>(SUCCESS_CODE, true, "ok");
    }

    /**
     * 请求成功方法 ，data返回值，msg提示信息
     *
     * @param data 结果
     * @param msg  消息
     * @return RPC调用结果
     */
    public static <E> R<E> success(E data, String msg)
    {
        return new R<>(SUCCESS_CODE, data, msg);
    }

    /**
     * 失败
     * 请求失败消息
     *
     * @param code 代码
     * @param msg  消息
     * @return {@link R}<{@link E}>
     */
    public static <E> R<E> fail(int code, String msg)
    {
        return new R<>(code, null, (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg);
    }

    /**
     * 失败
     *
     * @param msg 消息
     * @return {@link R}<{@link E}>
     */
    public static <E> R<E> fail(String msg)
    {
        return fail(OPERATION_EX_CODE, msg);
    }

    /**
     * 失败
     *
     * @param msg  消息
     * @param args 参数
     * @return {@link R}<{@link E}>
     */
    public static <E> R<E> fail(String msg, Object... args)
    {
        String message = (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg;
        return new R<>(OPERATION_EX_CODE, null, String.format(message, args));
    }


    /**
     * 逻辑处理是否成功
     *
     * @return 是否成功
     */
    public Boolean getIsSuccess()
    {
        return this.code == SUCCESS_CODE || this.code == 200;
    }

    /**
     * 得到是错误
     * 逻辑处理是否失败
     *
     * @return {@link Boolean}
     */
    public Boolean getIsError()
    {
        return !getIsSuccess();
    }

    @Override
    public String toString()
    {
        return JSONObject.toJSONString(this);
    }
}
