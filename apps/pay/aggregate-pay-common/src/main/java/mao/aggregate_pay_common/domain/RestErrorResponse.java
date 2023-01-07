package mao.aggregate_pay_common.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.domain
 * Class(类名): RestErrorResponse
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 14:49
 * Version(版本): 1.0
 * Description(描述)： 错误响应参数包装类
 */

@Data
@ApiModel(value = "RestErrorResponse", description = "错误响应参数包装")
public class RestErrorResponse
{
    /**
     * 错误代码
     */
    private String errCode;

    /**
     * 错误消息
     */
    private String errMessage;

    /**
     * 错误响应参数包装
     *
     * @param errCode    错误代码
     * @param errMessage 错误消息
     */
    public RestErrorResponse(String errCode, String errMessage)
    {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }
}
