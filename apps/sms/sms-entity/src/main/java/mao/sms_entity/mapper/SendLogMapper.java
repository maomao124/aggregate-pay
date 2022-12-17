package mao.sms_entity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mao.sms_entity.entity.SendLogEntity;
import mao.sms_entity.vo.MarketingStatisticsCountVO;
import mao.sms_entity.vo.SendLogPageVO;
import mao.sms_entity.vo.SendLogVO;
import mao.sms_entity.vo.StatisticsCountVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.mapper
 * Interface(接口名): SendLogMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:51
 * Version(版本): 1.0
 * Description(描述)： 发送日志
 */

@Mapper
public interface SendLogMapper extends BaseMapper<SendLogEntity>
{
    /**
     * 分页查询日志
     *
     * @param page   页面
     * @param params 参数
     * @return {@link IPage}<{@link SendLogVO}>
     */
    IPage<SendLogVO> selectLogPage(Page<SendLogVO> page, @Param("params") Map<String, Object> params);

    /**
     * 趋势
     *
     * @param params 参数
     * @return {@link List}<{@link StatisticsCountVO}>
     */
    List<StatisticsCountVO> trend(@Param("params") Map<?, ?> params);

    /**
     * 分页统计
     *
     * @param page   页面
     * @param params 参数
     * @return {@link IPage}<{@link StatisticsCountVO}>
     */
    IPage<StatisticsCountVO> countPage(Page<StatisticsCountVO> page, @Param("params") Map<?, ?> params);

    /**
     * 配置计数
     *
     * @param params 参数
     * @return {@link List}<{@link Map}<{@link ?},{@link ?}>>
     */
    List<Map<?, ?>> countForConfig(@Param("params") Map<?, ?> params);

    /**
     * 获得营销计数
     *
     * @param params 参数
     * @return {@link MarketingStatisticsCountVO}
     */
    MarketingStatisticsCountVO getMarketingCount(@Param("params") Map<?, ?> params);

    /**
     * 分页查询发送日志
     *
     * @param page          页面
     * @param sendLogPageVO {@link SendLogPageVO}
     * @return {@link IPage}<{@link SendLogPageVO}>
     */
    IPage<SendLogPageVO> sendLogPage(Page<SendLogPageVO> page, @Param("params") SendLogPageVO sendLogPageVO);
}
