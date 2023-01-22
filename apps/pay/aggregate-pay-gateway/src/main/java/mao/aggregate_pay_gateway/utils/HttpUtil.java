package mao.aggregate_pay_gateway.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import mao.aggregate_pay_common.domain.RestResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_gateway.utils
 * Class(类名): HttpUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/22
 * Time(创建时间)： 19:58
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class HttpUtil
{
    public static void writerError(RestResponse restResponse, HttpServletResponse response) throws IOException
    {
        response.setContentType("application/json,charset=utf-8");
        response.setStatus(restResponse.getCode());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), restResponse);
    }
}
