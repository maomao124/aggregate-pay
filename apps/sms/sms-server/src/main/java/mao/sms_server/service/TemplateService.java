package mao.sms_server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.entity.TemplateEntity;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.service
 * Interface(接口名): TemplateService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/30
 * Time(创建时间)： 20:00
 * Version(版本): 1.0
 * Description(描述)： 模板
 */

public interface TemplateService extends IService<TemplateEntity>
{
    /**
     * 通过code得到TemplateEntity
     *
     * @param template 模板
     * @return {@link TemplateEntity}
     */
    TemplateEntity getByCode(String template);

    /**
     * 通过template的code得到Config的Code
     *
     * @param id       id
     * @param template 模板
     * @return {@link String}
     */
    String getConfigCodeByCode(String id, String template);
}
