package mao.aggregate_pay_gateway.config;

import mao.aggregate_pay_common.domain.RestResponse;
import mao.aggregate_pay_gateway.utils.HttpUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_gateway.config
 * Class(类名): RestAccessDeniedHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/22
 * Time(创建时间)： 22:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class RestAccessDeniedHandler implements AccessDeniedHandler
{
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex)
            throws IOException, ServletException
    {
        RestResponse restResponse = new RestResponse(HttpStatus.FORBIDDEN.value(), "没有权限");
        HttpUtil.writerError(restResponse, response);
    }
}
