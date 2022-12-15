package mao.tools_databases.datasource;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import mao.tools_core.base.id.IdGenerate;
import mao.tools_core.base.id.SnowflakeIdGenerate;
import mao.tools_databases.mybatis.typehandler.FullLikeTypeHandler;
import mao.tools_databases.mybatis.typehandler.LeftLikeTypeHandler;
import mao.tools_databases.mybatis.typehandler.RightLikeTypeHandler;
import mao.tools_databases.parsers.TenantWebMvcConfigurer;
import mao.tools_databases.properties.DatabaseProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.datasource
 * Class(类名): BaseMybatisConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 14:03
 * Version(版本): 1.0
 * Description(描述)： Mybatis 常用重用拦截器
 */

public abstract class BaseMybatisConfiguration
{
    private final DatabaseProperties databaseProperties;

    public BaseMybatisConfiguration(DatabaseProperties databaseProperties)
    {
        this.databaseProperties = databaseProperties;
    }

    /**
     * 分页插件，自动识别数据库类型
     */
    @Bean
    public PaginationInterceptor paginationInterceptor()
    {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        List<ISqlParser> sqlParserList = new ArrayList<>();

        if (this.databaseProperties.getIsBlockAttack())
        {
            // 攻击 SQL 阻断解析器 加入解析链
            sqlParserList.add(new BlockAttackSqlParser());
        }

        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }


    /**
     * Mybatis Plus 注入器
     *
     * @param idGenerate id生成
     * @return {@link MetaObjectHandler}
     */
    @Bean("myMetaObjectHandler")
    public MetaObjectHandler getMyMetaObjectHandler(@Qualifier("snowflakeIdGenerate") IdGenerate<Long> idGenerate)
    {
        return new MyMetaObjectHandler(idGenerate);
    }

    /**
     * id生成 机器码， 单机配置1即可。 集群部署，每个实例自增1即可。
     *
     * @param machineCode 机器代码
     * @return {@link IdGenerate}
     */
    @Bean("snowflakeIdGenerate")
    public IdGenerate getIdGenerate(@Value("${id-generator.machine-code:1}") Long machineCode)
    {
        return new SnowflakeIdGenerate(machineCode);
    }

    /**
     * 租户信息拦截器
     *
     * @return {@link TenantWebMvcConfigurer}
     */
    @Bean
    @ConditionalOnProperty(name = "database.isMultiTenant", havingValue = "true", matchIfMissing = true)
    public TenantWebMvcConfigurer getTenantWebMvcConfigurer()
    {
        return new TenantWebMvcConfigurer();
    }

    /**
     * Mybatis 自定义的类型处理器
     * 用于左模糊查询时使用
     * <p>
     * eg：
     * and name like #{name,typeHandler=leftLike}
     *
     * @return {@link LeftLikeTypeHandler}
     */
    @Bean
    public LeftLikeTypeHandler getLeftLikeTypeHandler()
    {
        return new LeftLikeTypeHandler();
    }

    /**
     * Mybatis 自定义的类型处理器
     * 用于右模糊查询时使用
     * <p>
     * eg：
     * and name like #{name,typeHandler=rightLike}
     *
     * @return {@link RightLikeTypeHandler}
     */
    @Bean
    public RightLikeTypeHandler getRightLikeTypeHandler()
    {
        return new RightLikeTypeHandler();
    }

    /**
     * Mybatis 自定义的类型处理器
     * 用于全模糊查询时使用
     * <p>
     * eg：
     * and name like #{name,typeHandler=fullLike}
     *
     * @return {@link FullLikeTypeHandler}
     */
    @Bean
    public FullLikeTypeHandler getFullLikeTypeHandler()
    {
        return new FullLikeTypeHandler();
    }
}
