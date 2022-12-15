package mao.auth_server.service.core.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.core.StationPageDTO;
import mao.auth_entity.entity.core.Station;
import mao.auth_server.dao.core.StationMapper;
import mao.auth_server.service.core.StationService;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.core.impl
 * Class(类名): StationServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 20:41
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class StationServiceImpl extends ServiceImpl<StationMapper, Station> implements StationService
{
    @Resource
    private DozerUtils dozerUtils;

    @Override
    public IPage<Station> findStationPage(Page page, StationPageDTO data)
    {
        //转换到Station
        Station station = dozerUtils.map(data, Station.class);
        LbqWrapper<Station> wrapper = Wraps.lbQ();
        wrapper.like(Station::getName, station.getName())
                .like(Station::getDescribe, station.getDescribe())
                .eq(Station::getOrgId, station.getOrgId())
                .eq(Station::getStatus, station.getStatus())
                .geHeader(Station::getCreateTime, data.getStartCreateTime())
                .leFooter(Station::getCreateTime, data.getEndCreateTime());
        wrapper.orderByDesc(Station::getId);
        return baseMapper.findStationPage(page, wrapper);
    }
}
