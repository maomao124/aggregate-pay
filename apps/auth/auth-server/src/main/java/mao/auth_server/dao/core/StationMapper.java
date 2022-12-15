package mao.auth_server.dao.core;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mao.auth_entity.entity.core.Station;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.core
 * Interface(接口名): StationMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 21:13
 * Version(版本): 1.0
 * Description(描述)： 岗位
 */

@Mapper
public interface StationMapper extends BaseMapper<Station>
{

    /**
     * 分页查询岗位信息（含角色）
     *
     * @param page         页面
     * @param queryWrapper 查询包装
     * @return {@link IPage}<{@link Station}>
     */
    IPage<Station> findStationPage(Page page, @Param(Constants.WRAPPER) Wrapper<Station> queryWrapper);
}
