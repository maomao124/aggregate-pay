package mao.auth_server.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_common.handler.DefaultGlobalExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.config
 * Class(类名): ExceptionConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 12:45
 * Version(版本): 1.0
 * Description(描述)： 权限服务中使用的全局异常处理配置类
 */

@Slf4j
@Configuration
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
public class ExceptionConfiguration extends DefaultGlobalExceptionHandler
{
    @PostConstruct
    public void init()
    {
        log.info("初始化 ExceptionConfiguration");
    }
}
