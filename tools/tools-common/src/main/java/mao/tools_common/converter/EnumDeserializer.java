package mao.tools_common.converter;

import cn.hutool.core.util.ReflectUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.converter
 * Class(类名): EnumDeserializer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 20:45
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class EnumDeserializer extends StdDeserializer<Enum<?>>
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(EnumDeserializer.class);

    /**
     * 实例
     */
    public final static EnumDeserializer INSTANCE = new EnumDeserializer();
    /**
     * 所有枚举字符串转换方法
     */
    private final static String ALL_ENUM_STRING_CONVERT_METHOD = "get";
    /**
     * 所有enum关键字段
     */
    private final static String ALL_ENUM_KEY_FIELD = "code";

    public EnumDeserializer()
    {
        super(Enum.class);
    }

    /**
     * 反序列化
     *
     * @param p    JsonParser
     * @param ctxt DeserializationContext
     * @return {@link Enum}<{@link ?}>
     * @throws IOException             ioexception
     * @throws JsonProcessingException json处理异常
     */
    @Override
    public Enum<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException
    {
        JsonToken token = p.getCurrentToken();
        String value = null;
        while (!token.isStructEnd())
        {
            if (ALL_ENUM_KEY_FIELD.equals(p.getText()))
            {
                p.nextToken();
                value = p.getValueAsString();
            }
            else
            {
                p.nextToken();
            }
            token = p.getCurrentToken();
        }
        if (value == null || "".equals(value))
        {
            return null;
        }

        Object obj = p.getCurrentValue();
        if (obj == null)
        {
            return null;
        }
        Field field = ReflectUtil.getField(obj.getClass(), p.getCurrentName());
        //找不到字段
        if (field == null)
        {
            return null;
        }
        Class<?> fieldType = field.getType();
        try
        {
            Method method = fieldType.getMethod(ALL_ENUM_STRING_CONVERT_METHOD, String.class);
            return (Enum<?>) method.invoke(null, value);
        }
        catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e)
        {
            log.warn("解析枚举失败", e);
            return null;
        }
    }

}
