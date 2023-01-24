package mao.aggregate_pay_uaa_service.config;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_uaa_service.interceptor.IPHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.config
 * Class(类名): MvcConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/24
 * Time(创建时间)： 17:40
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter
{
    //@Resource
    //private IPHandlerInterceptor ipHandlerInterceptor;


//    @Override
//    public void addInterceptors(InterceptorRegistry registry)
//    {
//        registry.addInterceptor(ipHandlerInterceptor).addPathPatterns("/**").order(0);
//        super.addInterceptors(registry);
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        //registry.addViewController("/login").setViewName("login");
        registry.addViewController("/confirm_access").setViewName("oauth_approval");
        registry.addViewController("/oauth_error").setViewName("oauth_error");
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 MvcConfig");
    }
}
