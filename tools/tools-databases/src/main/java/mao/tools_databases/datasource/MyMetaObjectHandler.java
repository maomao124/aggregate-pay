package mao.tools_databases.datasource;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import lombok.extern.slf4j.Slf4j;
import mao.tools_core.base.entity.Entity;
import mao.tools_core.base.entity.SuperEntity;
import mao.tools_core.base.id.IdGenerate;
import mao.tools_core.context.BaseContextHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.datasource
 * Class(类名): MyMetaObjectHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 14:06
 * Version(版本): 1.0
 * Description(描述)：
 * <p>
 * MyBatis Plus 元数据处理类
 * 用于自动 注入 id, createTime, updateTime, createUser, updateUser 等字段
 */

@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler
{
    /**
     * id类型判断符
     */
    private final static String ID_TYPE = "java.lang.String";
    /**
     * 实体类型判断符
     */
    private final IdGenerate<Long> idGenerator;

    public MyMetaObjectHandler(IdGenerate<Long> idGenerator)
    {
        super();
        this.idGenerator = idGenerator;
    }

    /**
     * 所有的继承了Entity、SuperEntity的实体，在insert时，
     * id： 会通过IdGenerate生成唯一ID
     * createUser, updateUser: 自动赋予 当前线程上的登录人id
     * createTime, updateTime: 自动赋予 服务器的当前时间
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject)
    {
        boolean flag = true;
        if (metaObject.getOriginalObject() instanceof SuperEntity)
        {
            Object oldId = ((SuperEntity) metaObject.getOriginalObject()).getId();
            if (oldId != null)
            {
                flag = false;
            }

            SuperEntity entity = (SuperEntity) metaObject.getOriginalObject();
            if (entity.getCreateTime() == null)
            {
                this.setFieldValByName(Entity.CREATE_TIME, LocalDateTime.now(), metaObject);
            }
            if (entity.getCreateUser() == null || entity.getCreateUser().equals(0))
            {
                if (ID_TYPE.equals(metaObject.getGetterType(SuperEntity.CREATE_USER).getName()))
                {
                    this.setFieldValByName(Entity.CREATE_USER, String.valueOf(BaseContextHandler.getUserId()), metaObject);
                }
                else
                {
                    this.setFieldValByName(Entity.CREATE_USER, BaseContextHandler.getUserId(), metaObject);
                }
            }
        }

        if (flag)
        {
            Long id = idGenerator.generate();
            if (ID_TYPE.equals(metaObject.getGetterType(SuperEntity.FIELD_ID).getName()))
            {
                this.setFieldValByName(SuperEntity.FIELD_ID, String.valueOf(id), metaObject);
            }
            else
            {
                this.setFieldValByName(SuperEntity.FIELD_ID, id, metaObject);
            }
        }

        if (metaObject.getOriginalObject() instanceof Entity)
        {
            Entity entity = (Entity) metaObject.getOriginalObject();
            update(metaObject, entity);
        }
    }

    /**
     * 更新
     *
     * @param metaObject 元对象
     * @param entity     实体
     * @param et         等
     */
    private void update(MetaObject metaObject, Entity entity, String et)
    {
        if (entity.getUpdateUser() == null || entity.getUpdateUser().equals(0))
        {
            if (ID_TYPE.equals(metaObject.getGetterType(et + Entity.UPDATE_USER).getName()))
            {
                this.setFieldValByName(Entity.UPDATE_USER, String.valueOf(BaseContextHandler.getUserId()), metaObject);
            }
            else
            {
                this.setFieldValByName(Entity.UPDATE_USER, BaseContextHandler.getUserId(), metaObject);
            }
        }
        if (entity.getUpdateTime() == null)
        {
            this.setFieldValByName(Entity.UPDATE_TIME, LocalDateTime.now(), metaObject);
        }
    }

    /**
     * 更新
     *
     * @param metaObject 元对象
     * @param entity     实体
     */
    private void update(MetaObject metaObject, Entity entity)
    {
        update(metaObject, entity, "");
    }

    /**
     * 所有的继承了Entity、SuperEntity的实体，在update时，
     * updateUser: 自动赋予 当前线程上的登录人id
     * updateTime: 自动赋予 服务器的当前时间
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject)
    {
        log.debug("start update fill ....");
        if (metaObject.getOriginalObject() instanceof Entity)
        {
            Entity entity = (Entity) metaObject.getOriginalObject();
            update(metaObject, entity);
        }
        else
        {
            //updateById updateBatchById update(T entity, Wrapper<T> updateWrapper);
            Object et = metaObject.getValue(Constants.ENTITY);
            if (et instanceof Entity)
            {
                Entity entity = (Entity) et;
                update(metaObject, entity, Constants.ENTITY + ".");
            }
        }
    }
}
