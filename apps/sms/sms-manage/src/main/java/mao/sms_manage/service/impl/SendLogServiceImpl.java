package mao.sms_manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_entity.entity.SendLogEntity;
import mao.sms_dao.mapper.SendLogMapper;
import mao.sms_entity.vo.MarketingStatisticsCountVO;
import mao.sms_entity.vo.SendLogPageVO;
import mao.sms_entity.vo.SendLogVO;
import mao.sms_entity.vo.StatisticsCountVO;
import mao.sms_manage.service.SendLogService;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service.impl
 * Class(类名): SendLogServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/21
 * Time(创建时间)： 20:41
 * Version(版本): 1.0
 * Description(描述)： 发送日志
 */

@Slf4j
@Service
public class SendLogServiceImpl extends ServiceImpl<SendLogMapper, SendLogEntity> implements SendLogService
{

    @Override
    public Page<SendLogVO> pageLog(Page<SendLogVO> page, Map<String, Object> params)
    {
        IPage<SendLogVO> sendLogVOIPage = this.baseMapper.selectLogPage(page, params);
        page.setRecords(sendLogVOIPage.getRecords());
        return page;
    }

    @Override
    public List<StatisticsCountVO> trend(Map<?, ?> params)
    {
        return this.baseMapper.trend(params);
    }

    @Override
    public Page<StatisticsCountVO> countPage(Page<StatisticsCountVO> page, Map<String, Object> params)
    {
        IPage<StatisticsCountVO> countPage = this.baseMapper.countPage(page, params);
        countPage.getRecords().stream().peek(item ->
        {
            item.setFail(item.getCount() - item.getSuccess());
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance();
            //精确几位小数
            decimalFormat.setMaximumFractionDigits(2);
            //模式 例如四舍五入
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            double accuracy_num = (double) item.getSuccess() / (double) item.getCount() * 100;
            item.setSuccessRate(decimalFormat.format(accuracy_num));
        }).collect(Collectors.toList());
        page.setRecords(countPage.getRecords());
        return page;
    }

    @Override
    public List<Map<?, ?>> countForConfig(Map<?, ?> params)
    {
        return this.baseMapper.countForConfig(params);
    }

    @Override
    public List<Map<?, ?>> rateForConfig(Map<?, ?> params)
    {
        List<Map<?, ?>> mapList = this.baseMapper.countForConfig(params);
        for (Map map : mapList)
        {
            int count = Integer.parseInt(map.get("count").toString());
            int success = Integer.parseInt(map.get("value").toString());
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance();
            //精确几位小数
            decimalFormat.setMaximumFractionDigits(2);
            //模式 例如四舍五入
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            double accuracy_num = (double) success / (double) count * 100;
            map.put("value", decimalFormat.format(accuracy_num));
        }
        return mapList;
    }

    @Override
    public MarketingStatisticsCountVO getMarketingCountByBusinessId(String id)
    {
        Map params = new HashMap();
        params.put("business", id);
        MarketingStatisticsCountVO marketingStatisticsCountVO = this.baseMapper.getMarketingCount(params);
        marketingStatisticsCountVO.setFail(marketingStatisticsCountVO.getCount() - marketingStatisticsCountVO.getSuccess());
        if (marketingStatisticsCountVO.getCount() > 0)
        {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance();
            //精确几位小数
            decimalFormat.setMaximumFractionDigits(2);
            //模式 例如四舍五入
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            double accuracy_num = (double) marketingStatisticsCountVO.getSuccess() / (double) marketingStatisticsCountVO.getCount() * 100;
            marketingStatisticsCountVO.setSuccessRate(decimalFormat.format(accuracy_num));
        }
        else
        {
            marketingStatisticsCountVO.setSuccessRate("100");
        }
        return marketingStatisticsCountVO;
    }

    @Override
    public Page<SendLogPageVO> sendLogPage(Page<SendLogPageVO> page, SendLogPageVO sendLogPageVO)
    {
        IPage<SendLogPageVO> sendLogPageVOIPage = this.baseMapper.sendLogPage(page, sendLogPageVO);
        page.setRecords(sendLogPageVOIPage.getRecords());
        return page;
    }
}
