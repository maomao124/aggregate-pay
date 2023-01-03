package mao.sms_api.config;

import lombok.extern.slf4j.Slf4j;
import mao.sms_entity.exception.SmsException;
import mao.tools_common.handler.DefaultGlobalExceptionHandler;
import mao.tools_core.base.R;
import mao.tools_core.utils.StrPool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.config
 * Class(类名): ExceptionConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 14:15
 * Version(版本): 1.0
 * Description(描述)： 全局异常处理
 */


@Slf4j
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
public class ExceptionConfiguration extends DefaultGlobalExceptionHandler
{
    /**
     * 短信平台异常
     *
     * @param ex      SmsException
     * @param request HttpServletRequest
     * @return {@link R}<{@link String}>
     */
    @ExceptionHandler(SmsException.class)
    public R<String> smsException(SmsException ex, HttpServletRequest request)
    {
        log.warn("SmsException:", ex);
        return R.result(ex.getCode(), StrPool.EMPTY, ex.getMessage()).setPath(request.getRequestURI());
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 ExceptionConfiguration");
    }
}
