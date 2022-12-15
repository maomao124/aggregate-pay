package mao.tools_user.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_user.feign.UserResolveApi;
import mao.tools_user.interceptor.ContextHandlerInterceptor;
import mao.tools_user.resolver.ContextArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.config
 * Class(类名): LoginArgResolverConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:40
 * Version(版本): 1.0
 * Description(描述)： 公共配置类, 一些公共工具配置
 */

@Slf4j
@Configuration
public class LoginArgResolverConfig implements WebMvcConfigurer
{
    @Lazy
    @Autowired
    private UserResolveApi userResolveApi;

    /**
     * Token参数解析
     *
     * @param argumentResolvers 解析类
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers)
    {
        argumentResolvers.add(new ContextArgumentResolver(userResolveApi));
    }

    /**
     * 注册 拦截器
     *
     * @param registry InterceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        if (getHandlerInterceptor() != null)
        {
            String[] commonPathPatterns = getExcludeCommonPathPatterns();
            registry.addInterceptor(getHandlerInterceptor())
                    .addPathPatterns("/**")
                    .order(10)
                    .excludePathPatterns(commonPathPatterns);
            WebMvcConfigurer.super.addInterceptors(registry);
        }
    }

    protected HandlerInterceptor getHandlerInterceptor()
    {
        return new ContextHandlerInterceptor();
    }

    /**
     * auth-client 中的拦截器需要排除拦截的地址
     */
    protected String[] getExcludeCommonPathPatterns()
    {
        String[] urls =
                {
                        "/error",
                        "/login",
                        "/v2/api-docs",
                        "/v2/api-docs-ext",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/",
                        "/csrf",
                        "/META-INF/resources/**",
                        "/resources/**",
                        "/static/**",
                        "/public/**",
                        "classpath:/META-INF/resources/**",
                        "classpath:/resources/**",
                        "classpath:/static/**",
                        "classpath:/public/**",
                        "/cache/**",
                        "/swagger-ui.html**",
                        "/doc.html**"
                };
        return urls;
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 LoginArgResolverConfig");
    }
}
