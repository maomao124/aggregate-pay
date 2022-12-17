package mao.sms_entity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mao.sms_entity.dto.TemplateDTO;
import mao.sms_entity.entity.TemplateEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.mapper
 * Interface(接口名): TemplateMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:52
 * Version(版本): 1.0
 * Description(描述)： 模板表
 */

@Mapper
public interface TemplateMapper extends BaseMapper<TemplateEntity>
{
    /**
     * 自定义分页
     *
     * @param page   页面
     * @param params 参数个数
     * @return {@link IPage}<{@link TemplateDTO}>
     */
    IPage<TemplateDTO> custom(Page<TemplateDTO> page, @Param("params") Map<?, ?> params);

    /**
     * 自定义分页
     *
     * @param params 参数个数
     * @return {@link List}<{@link TemplateDTO}>
     */
    List<TemplateDTO> custom(@Param("params") Map<?, ?> params);
}
