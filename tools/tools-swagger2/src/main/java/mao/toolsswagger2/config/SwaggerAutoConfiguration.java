package mao.toolsswagger2.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Project name(项目名称)：tools-swagger2
 * Package(包名):
 * Class(类名): SwaggerAutoConfiguration
 * Author(作者）: mao.toolsswagger2.config
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/27
 * Time(创建时间)： 13:40
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties
@Import(SwaggerConfigurationProperties.class)
public class SwaggerAutoConfiguration implements BeanFactoryAware
{

    /*

    配置文件示例：

swagger:
  # 是否启用swagger
  enabled: true
  title: 在线文档
  group: 默认组
  version: 1.0
  contact:
    name: mao
    url: https://github.com/maomao124/
    email: 1234@qq.com
  base-package: mao.swagger_knife4j_demo
  # 分组文档
#  docket:
#    user:
#      title: 用户模块
#      base-package:
#    menu:
#      title: 菜单模块
#      base-package:



spring:
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher



http://localhost:8080/swagger-ui.html
http://localhost:8080/doc.html
     */


    @Autowired
    private SwaggerConfigurationProperties swaggerConfigurationProperties;

    private static final Logger log = LoggerFactory.getLogger(SwaggerAutoConfiguration.class);

    /**
     * bean工厂
     */
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException
    {
        this.beanFactory = beanFactory;
    }


    @Bean
    @ConditionalOnMissingBean
    @SuppressWarnings("all")
    public List<Docket> createRestApi()
    {
        ConfigurableBeanFactory configurableBeanFactory =
                (ConfigurableBeanFactory) beanFactory;
        List<Docket> docketList = new LinkedList<>();
        // 没有分组的情况
        if (swaggerConfigurationProperties.getDocket().isEmpty())
        {
            Docket docket = createDocket(swaggerConfigurationProperties);
            configurableBeanFactory.registerSingleton(swaggerConfigurationProperties.getTitle(),
                    docket);
            docketList.add(docket);
            return docketList;
        }
        // 分组创建
        for (String groupName : swaggerConfigurationProperties.getDocket().keySet())
        {
            SwaggerConfigurationProperties.DocketInfo docketInfo =
                    swaggerConfigurationProperties.getDocket().get(groupName);
            ApiInfo apiInfo = new ApiInfoBuilder()
                    //页面标题
                    .title(docketInfo.getTitle())
                    //创建人
                    .contact(new Contact
                            (
                                    docketInfo.getContact().getName(),
                                    docketInfo.getContact().getUrl(),
                                    docketInfo.getContact().getEmail()))
                    //版本号
                    .version(docketInfo.getVersion())
                    //描述
                    .description(docketInfo.getDescription())
                    .build();

            // base-path处理
            // 当没有配置任何path的时候，解析/**
            if (docketInfo.getBasePath().isEmpty())
            {
                docketInfo.getBasePath().add("/**");
            }
            List<Predicate<String>> basePath = new ArrayList<>();
            for (String path : docketInfo.getBasePath())
            {
                basePath.add(PathSelectors.ant(path));
            }

            // exclude-path处理
            List<Predicate<String>> excludePath = new ArrayList<>();
            for (String path : docketInfo.getExcludePath())
            {
                excludePath.add(PathSelectors.ant(path));
            }

            Docket docket = new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo)
                    .groupName(docketInfo.getGroup())
                    .select()
                    //为当前包路径
                    .apis(RequestHandlerSelectors.basePackage(docketInfo.getBasePackage()))
                    .paths(Predicates.and(Predicates.not(Predicates.or(excludePath)), Predicates.or(basePath)))
                    .build();
            configurableBeanFactory.registerSingleton(groupName, docket);
            docketList.add(docket);
        }
        return docketList;
    }

    /**
     * 构建 api文档的详细信息
     *
     * @param swaggerConfigurationProperties 配置属性
     * @return {@link ApiInfo}
     */
    private ApiInfo apiInfo(SwaggerConfigurationProperties swaggerConfigurationProperties)
    {
        return new ApiInfoBuilder()
                //页面标题
                .title(swaggerConfigurationProperties.getTitle())
                //创建人
                .contact(new Contact
                        (
                                swaggerConfigurationProperties.getContact().getName(),
                                swaggerConfigurationProperties.getContact().getUrl(),
                                swaggerConfigurationProperties.getContact().getEmail()
                        )
                )
                //版本号
                .version(swaggerConfigurationProperties.getVersion())
                //描述
                .description(swaggerConfigurationProperties.getDescription())
                .build();
    }


    /**
     * 创建接口文档对象
     *
     * @param swaggerConfigurationProperties 配置属性
     * @return {@link Docket}
     */
    @SuppressWarnings("all")
    private Docket createDocket(SwaggerConfigurationProperties swaggerConfigurationProperties)
    {
        //API 基础信息
        ApiInfo apiInfo = apiInfo(swaggerConfigurationProperties);

        // base-path处理
        // 当没有配置任何path的时候，解析/**
        if (swaggerConfigurationProperties.getBasePath().isEmpty())
        {
            swaggerConfigurationProperties.getBasePath().add("/**");
        }
        List<Predicate<String>> basePath = new ArrayList<>();
        for (String path : swaggerConfigurationProperties.getBasePath())
        {
            basePath.add(PathSelectors.ant(path));
        }

        // exclude-path处理
        List<Predicate<String>> excludePath = new ArrayList<>();
        for (String path : swaggerConfigurationProperties.getExcludePath())
        {
            excludePath.add(PathSelectors.ant(path));
        }

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .groupName(swaggerConfigurationProperties.getGroup())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerConfigurationProperties.getBasePackage()))
                .paths(Predicates.and(Predicates.not(Predicates.or(excludePath)), Predicates.or(basePath)))
                .build();
    }


    @PostConstruct
    public void init()
    {
        log.info("初始化swagger接口文档");
        log.info("\n" + swaggerConfigurationProperties.toString());
    }

}
