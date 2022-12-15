package mao.tools_databases.mybatis.conditions.update;

import com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper;
import com.baomidou.mybatisplus.core.conditions.SharedString;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import mao.tools_databases.mybatis.typehandler.BaseLikeTypeHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.mybatis.conditions.update
 * Class(类名): LbuWrapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 13:43
 * Version(版本): 1.0
 * Description(描述)： 修改构造器
 */

public class LbuWrapper<T> extends AbstractLambdaWrapper<T, LbuWrapper<T>> implements Update<LbuWrapper<T>, SFunction<T, ?>>
{
    /**
     * SQL 更新字段内容，例如：name='1', age=2
     */
    private final List<String> sqlSet;

    /**
     * 不建议直接 new 该实例，使用 Wrappers.lambdaUpdate()
     */
    public LbuWrapper()
    {
        // 如果无参构造函数，请注意实体 NULL 情况 SET 必须有否则 SQL 异常
        this(null);
    }

    /**
     * 不建议直接 new 该实例，使用 Wrappers.lambdaUpdate(entity)
     */
    public LbuWrapper(T entity)
    {
        super.setEntity(entity);
        super.initNeed();
        this.sqlSet = new ArrayList<>();
    }

    /**
     * 不建议直接 new 该实例，使用 Wrappers.lambdaUpdate(...)
     */
    private LbuWrapper(T entity, List<String> sqlSet, AtomicInteger paramNameSeq,
                       Map<String, Object> paramNameValuePairs, MergeSegments mergeSegments,
                       SharedString lastSql, SharedString sqlComment)
    {
        super.setEntity(entity);
        this.sqlSet = sqlSet;
        this.paramNameSeq = paramNameSeq;
        this.paramNameValuePairs = paramNameValuePairs;
        this.expression = mergeSegments;
        this.lastSql = lastSql;
        this.sqlComment = sqlComment;
    }

    @Override
    public LbuWrapper<T> set(boolean condition, SFunction<T, ?> column, Object val)
    {
        if (condition)
        {
            this.sqlSet.add(String.format("%s=%s", this.columnToString(column), this.formatSql("{0}", val)));
        }
        return this.typedThis;
    }

    @Override
    public LbuWrapper<T> setSql(boolean condition, String sql)
    {
        if (condition && StringUtils.isNotEmpty(sql))
        {
            this.sqlSet.add(sql);
        }
        return this.typedThis;
    }

    @Override
    public String getSqlSet()
    {
        if (CollectionUtils.isEmpty(this.sqlSet))
        {
            return null;
        }
        return String.join(StringPool.COMMA, this.sqlSet);
    }

    @Override
    protected LbuWrapper<T> instance()
    {
        return new LbuWrapper<>(this.entity, this.sqlSet, this.paramNameSeq, this.paramNameValuePairs, new MergeSegments(),
                SharedString.emptyString(), SharedString.emptyString());
    }

    /**
     * 空值校验
     * 传入空字符串("")时， 视为： 字段名 = ""
     *
     * @param val 参数值
     */
    private static boolean checkCondition(Object val)
    {
        return val != null;
    }

    @Override
    public LbuWrapper<T> eq(SFunction<T, ?> column, Object val)
    {
        return super.eq(checkCondition(val), column, val);
    }

    @Override
    public LbuWrapper<T> ne(SFunction<T, ?> column, Object val)
    {
        return super.ne(checkCondition(val), column, val);
    }

    @Override
    public LbuWrapper<T> gt(SFunction<T, ?> column, Object val)
    {
        return super.gt(checkCondition(val), column, val);
    }

    @Override
    public LbuWrapper<T> ge(SFunction<T, ?> column, Object val)
    {
        return super.ge(checkCondition(val), column, val);
    }

    @Override
    public LbuWrapper<T> lt(SFunction<T, ?> column, Object val)
    {
        return super.lt(checkCondition(val), column, val);
    }

    @Override
    public LbuWrapper<T> le(SFunction<T, ?> column, Object val)
    {
        return super.le(checkCondition(val), column, val);
    }

    @Override
    public LbuWrapper<T> like(SFunction<T, ?> column, Object val)
    {
        return super.like(checkCondition(val), column, BaseLikeTypeHandler.likeConvert(val));
    }

    @Override
    public LbuWrapper<T> notLike(SFunction<T, ?> column, Object val)
    {
        return super.notLike(checkCondition(val), column, BaseLikeTypeHandler.likeConvert(val));
    }

    @Override
    public LbuWrapper<T> likeLeft(SFunction<T, ?> column, Object val)
    {
        return super.likeLeft(checkCondition(val), column, BaseLikeTypeHandler.likeConvert(val));
    }

    @Override
    public LbuWrapper<T> likeRight(SFunction<T, ?> column, Object val)
    {
        return super.likeRight(checkCondition(val), column, BaseLikeTypeHandler.likeConvert(val));
    }

    @Override
    public LbuWrapper<T> in(SFunction<T, ?> column, Collection<?> coll)
    {
        return super.in(coll != null && !coll.isEmpty(), column, coll);
    }

    @Override
    public LbuWrapper<T> in(SFunction<T, ?> column, Object... values)
    {
        return super.in(values != null && values.length > 0, column, values);
    }

}
