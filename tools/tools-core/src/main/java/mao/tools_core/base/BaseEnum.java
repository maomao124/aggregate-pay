package mao.tools_core.base;

import mao.tools_core.utils.MapHelper;

import java.util.Arrays;
import java.util.Map;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.base
 * Interface(接口名): BaseEnum
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 13:53
 * Version(版本): 1.0
 * Description(描述)： 枚举类型基类
 */

public interface BaseEnum
{
    /**
     * 将制定的枚举集合转成 map
     * key -> name
     * value -> desc
     *
     * @param list 列表
     * @return {@link Map}<{@link String}, {@link String}>
     */
    static Map<String, String> getMap(BaseEnum[] list)
    {
        return MapHelper.uniqueIndex(Arrays.asList(list), BaseEnum::getCode, BaseEnum::getDesc);
    }


    /**
     * 编码重写
     *
     * @return {@link String}
     */
    default String getCode()
    {
        return toString();
    }

    /**
     * 描述
     *
     * @return {@link String}
     */
    String getDesc();
}
