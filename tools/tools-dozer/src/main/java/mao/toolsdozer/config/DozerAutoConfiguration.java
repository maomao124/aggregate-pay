package mao.toolsdozer.config;

import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.spring.DozerBeanMapperFactoryBean;
import mao.toolsdozer.utils.DozerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.core.io.Resource;


import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Project name(项目名称)：dozer_starter_demo
 * Package(包名): mao.toolsdozer.config
 * Class(类名): DozerAutoConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/28
 * Time(创建时间)： 22:03
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Configuration
public class DozerAutoConfiguration
{

    private static final Logger log = LoggerFactory.getLogger(DozerAutoConfiguration.class);

    /*public DozerBeanMapperFactoryBean dozerMapper(@Value("classpath:dozer/*.xml") Resource[] resources)
            throws IOException
    {
        DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
        dozerBeanMapperFactoryBean.setMappingFiles(resources);
        return dozerBeanMapperFactoryBean;
    }*/

    @Autowired
    private Mapper mapper;

    @Bean
    public DozerUtils getDozerUtils() throws IOException
    {
        return new DozerUtils(mapper);
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 DozerAutoConfiguration");
    }
}
