package mao.toolsdozer.utils;

import com.github.dozermapper.core.Mapper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：dozer_starter_demo
 * Package(包名): mao.toolsdozer.utils
 * Class(类名): DozerUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/28
 * Time(创建时间)： 21:57
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class DozerUtils
{
    private final Mapper mapper;

    public DozerUtils(Mapper mapper)
    {
        this.mapper = mapper;
    }

    public Mapper getMapper()
    {
        return this.mapper;
    }

    /**
     * 地图
     * Constructs new instance of destinationClass and performs mapping between from source
     *
     * @param source           源
     * @param destinationClass 目标类
     * @return {@link T}
     */
    public <T> T map(Object source, Class<T> destinationClass)
    {
        if (source == null)
        {
            return null;
        }
        return mapper.map(source, destinationClass);
    }

    /**
     * map2
     *
     * @param source           源
     * @param destinationClass 目标类
     * @return {@link T}
     */
    public <T> T map2(Object source, Class<T> destinationClass)
    {
        if (source == null)
        {
            try
            {
                return destinationClass.newInstance();
            }
            catch (Exception ignored)
            {
            }
        }
        return mapper.map(source, destinationClass);
    }

    /**
     * 地图
     * Performs mapping between source and destination objects
     *
     * @param source      源
     * @param destination 目地
     */
    public void map(Object source, Object destination)
    {
        if (source == null)
        {
            return;
        }
        mapper.map(source, destination);
    }

    /**
     *
     * Constructs new instance of destinationClass and performs mapping between from source
     *
     * @param source           源
     * @param destinationClass 目标类
     * @param mapId            mapId
     * @return {@link T}
     */
    public <T> T map(Object source, Class<T> destinationClass, String mapId)
    {
        if (source == null)
        {
            return null;
        }
        return mapper.map(source, destinationClass, mapId);
    }

    /**
     *
     * Performs mapping between source and destination objects
     *
     * @param source      源
     * @param destination 目标
     * @param mapId       mapId
     */
    public void map(Object source, Object destination, String mapId)
    {
        if (source == null)
        {
            return;
        }
        mapper.map(source, destination, mapId);
    }

    /**
     *
     * 将集合转成集合
     * List<A> -->  List<B>
     *
     * @param sourceList       源集合
     * @param destinationClass 待转类型
     * @return {@link List}<{@link T}>
     */
    public <T, E> List<T> mapList(Collection<E> sourceList, Class<T> destinationClass)
    {
        return mapPage(sourceList, destinationClass);
    }


    public <T, E> List<T> mapPage(Collection<E> sourceList, Class<T> destinationClass)
    {
        if (sourceList == null || sourceList.isEmpty() || destinationClass == null)
        {
            return Collections.emptyList();
        }
        return sourceList.stream()
                .filter(Objects::nonNull)
                .map((sourceObject) -> mapper.map(sourceObject, destinationClass))
                .collect(Collectors.toList());
    }

    public <T, E> Set<T> mapSet(Collection<E> sourceList, Class<T> destinationClass)
    {
        if (sourceList == null || sourceList.isEmpty() || destinationClass == null)
        {
            return Collections.emptySet();
        }
        return sourceList.stream().map((sourceObject) -> mapper.map(sourceObject, destinationClass)).collect(Collectors.toSet());
    }
}
