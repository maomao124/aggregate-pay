package mao.tools_databases.parsers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.parsers
 * Class(类名): TenantWebMvcConfigurer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 13:59
 * Version(版本): 1.0
 * Description(描述)： Web Mvc配置
 */

public class TenantWebMvcConfigurer implements WebMvcConfigurer
{
    @Value("${mysql.database:auth}")
    private String databaseName;

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
                    .order(9)
                    .excludePathPatterns(commonPathPatterns);
            WebMvcConfigurer.super.addInterceptors(registry);
        }
    }

    protected HandlerInterceptor getHandlerInterceptor()
    {
        return new TenantContextHandlerInterceptor(databaseName);
    }

    /**
     * auth-client 中的拦截器需要排除拦截的地址
     *
     * @return {@link String[]}
     */
    protected String[] getExcludeCommonPathPatterns()
    {
        String[] urls = {
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
}
