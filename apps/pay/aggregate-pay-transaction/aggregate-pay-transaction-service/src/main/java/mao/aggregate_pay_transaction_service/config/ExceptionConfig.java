package mao.aggregate_pay_transaction_service.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_common.handler.DefaultGlobalExceptionHandler;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.tools_core.utils.StrPool;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.config
 * Class(类名): ExceptionConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/13
 * Time(创建时间)： 22:08
 * Version(版本): 1.0
 * Description(描述)： 全局异常配置类
 */

@Slf4j
@Configuration
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
public class ExceptionConfig extends DefaultGlobalExceptionHandler
{
    /**
     * 业务异常
     *
     * @param ex      业务异常
     * @param request 请求
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler(BizException.class)
    public R<String> bizException(BizException ex, HttpServletRequest request)
    {
        log.warn("BizException:", ex);
        R<String> r = R.result(ex.getCode(), StrPool.EMPTY, ex.getMessage()).setPath(request.getRequestURI());
        r.setData(null);
        return r;
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 ExceptionConfig 全局异常配置");
    }
}
