package mao.sms_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.dto.TemplateDTO;
import mao.sms_entity.entity.TemplateEntity;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service
 * Interface(接口名): TemplateService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/20
 * Time(创建时间)： 19:10
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface TemplateService extends IService<TemplateEntity>
{
    /**
     * 得到下一个代码
     *
     * @return {@link String}
     */
    String getNextCode();

    /**
     * 自定义分页
     *
     * @param page   页面
     * @param params 参数
     * @return {@link IPage}<{@link TemplateDTO}>
     */
    IPage<TemplateDTO> customPage(Page<TemplateDTO> page, Map<?,?> params);

    /**
     * 自定义列表
     *
     * @param params 参数
     * @return {@link List}<{@link TemplateDTO}>
     */
    List<TemplateDTO> customList(Map<?,?> params);

    /**
     * 通过代码得到TemplateEntity
     *
     * @param code 代码
     * @return {@link TemplateEntity}
     */
    TemplateEntity getByCode(String code);

    /**
     * 通过名字得到TemplateEntity
     *
     * @param name 名字
     * @return {@link TemplateEntity}
     */
    TemplateEntity getByName(String name);
}
