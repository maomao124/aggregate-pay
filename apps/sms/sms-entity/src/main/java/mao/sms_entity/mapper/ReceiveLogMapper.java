package mao.sms_entity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mao.sms_entity.entity.ReceiveLogEntity;
import mao.sms_entity.vo.ReceiveLogVO;
import mao.sms_entity.vo.StatisticsCountVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.mapper
 * Interface(接口名): ReceiveLogMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:50
 * Version(版本): 1.0
 * Description(描述)： 接收日志
 */

@Mapper
public interface ReceiveLogMapper extends BaseMapper<ReceiveLogEntity>
{
    /**
     * 分页查询日志
     *
     * @param page   页面对象
     * @param params 参数
     * @return {@link IPage}<{@link ReceiveLogVO}>
     */
    IPage<ReceiveLogVO> selectLogPage(Page<ReceiveLogVO> page, @Param("params") Map<String, Object> params);

    /**
     * 查询前10个
     *
     * @param params 参数
     * @return {@link List}<{@link StatisticsCountVO}>
     */
    List<StatisticsCountVO> top10(@Param("params") Map<?, ?> params);

    /**
     * 查询趋势
     *
     * @param params 参数
     * @return {@link List}<{@link StatisticsCountVO}>
     */
    List<StatisticsCountVO> trend(@Param("params") Map<?, ?> params);
}
