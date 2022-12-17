package mao.sms_manage.config;

import cn.hutool.core.util.ArrayUtil;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.p6spy.engine.spy.P6DataSource;
import lombok.extern.slf4j.Slf4j;
import mao.tools_databases.datasource.BaseDatabaseConfiguration;
import mao.tools_databases.properties.DatabaseProperties;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.Advisor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.config
 * Class(类名): SmsManageDatabaseAutoConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 20:50
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@Slf4j
@Configuration
@MapperScan(
        basePackages = {"mao"},
        sqlSessionFactoryRef = SmsManageDatabaseAutoConfiguration.DATABASE_PREFIX + "SqlSessionFactory")
@EnableConfigurationProperties({MybatisPlusProperties.class, DatabaseProperties.class})
public class SmsManageDatabaseAutoConfiguration extends BaseDatabaseConfiguration
{
    /**
     * 每个数据源配置不同即可
     */
    final static String DATABASE_PREFIX = "master";

    /**
     * 短信管理数据库自动配置
     *
     * @param properties                              属性
     * @param databaseProperties                      数据库属性
     * @param interceptorsProvider                    拦截器供应商
     * @param typeHandlersProvider                    类型处理程序提供者
     * @param languageDriversProvider                 语言驱动程序提供商
     * @param resourceLoader                          资源加载器
     * @param databaseIdProvider                      数据库id提供商
     * @param configurationCustomizersProvider        配置定制提供者
     * @param mybatisPlusPropertiesCustomizerProvider mybatis +属性编辑器提供者
     * @param applicationContext                      应用程序上下文
     */
    public SmsManageDatabaseAutoConfiguration(MybatisPlusProperties properties,
                                              DatabaseProperties databaseProperties,
                                              ObjectProvider<Interceptor[]> interceptorsProvider,
                                              ObjectProvider<TypeHandler[]> typeHandlersProvider,
                                              ObjectProvider<LanguageDriver[]> languageDriversProvider,
                                              ResourceLoader resourceLoader,
                                              ObjectProvider<DatabaseIdProvider> databaseIdProvider,
                                              ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider,
                                              ObjectProvider<List<MybatisPlusPropertiesCustomizer>> mybatisPlusPropertiesCustomizerProvider,
                                              ApplicationContext applicationContext)
    {
        super(properties, databaseProperties, interceptorsProvider, typeHandlersProvider,
                languageDriversProvider, resourceLoader, databaseIdProvider,
                configurationCustomizersProvider, mybatisPlusPropertiesCustomizerProvider, applicationContext);
    }

    /**
     * 获得sql会话模板
     *
     * @param sqlSessionFactory sql会话工厂
     * @return {@link SqlSessionTemplate}
     */
    @Bean(DATABASE_PREFIX + "SqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier(DATABASE_PREFIX + "SqlSessionFactory") SqlSessionFactory sqlSessionFactory)
    {
        ExecutorType executorType = this.properties.getExecutorType();
        if (executorType != null)
        {
            return new SqlSessionTemplate(sqlSessionFactory, executorType);
        }
        else
        {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

    /**
     * 数据源信息
     *
     * @return {@link DataSource}
     */
    @Bean(name = DATABASE_PREFIX + "DruidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = DATABASE_PREFIX + "DataSource")
    public DataSource dataSource(@Qualifier(DATABASE_PREFIX + "DruidDataSource") DataSource dataSource)
    {
        if (ArrayUtil.contains(DEV_PROFILES, this.profiles))
        {
            return new P6DataSource(dataSource);
        }
        else
        {
            return dataSource;
        }
    }

    /**
     * mybatis Sql Session 工厂
     *
     * @param dataSource 数据源
     * @return {@link SqlSessionFactory}
     * @throws Exception 异常
     */
    @Bean(DATABASE_PREFIX + "SqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier(DATABASE_PREFIX + "DataSource") DataSource dataSource)
            throws Exception
    {
        return super.sqlSessionFactory(dataSource);
    }

    /**
     * 数据源事务管理器
     *
     * @param dataSource 数据源
     * @return {@link DataSourceTransactionManager}
     */
    @Bean(name = DATABASE_PREFIX + "TransactionManager")
    public DataSourceTransactionManager dsTransactionManager(@Qualifier(DATABASE_PREFIX + "DataSource") DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 事务拦截器
     *
     * @param transactionManager 事务管理器
     * @return {@link TransactionInterceptor}
     */
    @Bean(DATABASE_PREFIX + "TransactionInterceptor")
    public TransactionInterceptor transactionInterceptor(@Qualifier(DATABASE_PREFIX + "TransactionManager") PlatformTransactionManager transactionManager)
    {
        return new TransactionInterceptor(transactionManager, this.transactionAttributeSource());
    }

    /**
     * 事务 Advisor
     *
     * @param transactionManager 事务管理器
     * @param ti                 TransactionInterceptor
     * @return {@link Advisor}
     */
    @Bean(DATABASE_PREFIX + "Advisor")
    public Advisor getAdvisor(@Qualifier(DATABASE_PREFIX + "TransactionManager") PlatformTransactionManager transactionManager,
                              @Qualifier(DATABASE_PREFIX + "TransactionInterceptor") TransactionInterceptor ti)
    {
        return super.txAdviceAdvisor(ti);
    }


    @PostConstruct
    public void init()
    {
        log.info("初始化 SmsManageDatabaseAutoConfiguration 数据库配置");
    }
}
