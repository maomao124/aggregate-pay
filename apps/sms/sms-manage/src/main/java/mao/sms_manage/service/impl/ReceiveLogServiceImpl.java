package mao.sms_manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_entity.entity.ReceiveLogEntity;
import mao.sms_entity.mapper.ReceiveLogMapper;
import mao.sms_entity.vo.ReceiveLogVO;
import mao.sms_entity.vo.StatisticsCountVO;
import mao.sms_manage.service.ReceiveLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service.impl
 * Class(类名): ReceiveLogServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/21
 * Time(创建时间)： 20:39
 * Version(版本): 1.0
 * Description(描述)： 接收日志
 */

@Slf4j
@Service
public class ReceiveLogServiceImpl extends ServiceImpl<ReceiveLogMapper, ReceiveLogEntity> implements ReceiveLogService
{

    @Override
    public Page<ReceiveLogVO> pageLog(Page<ReceiveLogVO> page, Map<String, Object> params)
    {
        IPage<ReceiveLogVO> receiveLogVOPage = this.baseMapper.selectLogPage(page, params);
        page.setRecords(receiveLogVOPage.getRecords());
        return page;
    }

    @Override
    public List<StatisticsCountVO> top10(Map<?, ?> params)
    {
        return this.baseMapper.top10(params);
    }

    @Override
    public List<StatisticsCountVO> trend(Map<?, ?> params)
    {
        return this.baseMapper.trend(params);
    }
}
