package mao.sms_manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_entity.dto.TemplateDTO;
import mao.sms_entity.entity.TemplateEntity;
import mao.sms_entity.mapper.TemplateMapper;
import mao.sms_manage.service.TemplateService;
import mao.sms_manage.utils.StringUtils;
import mao.tools_databases.mybatis.conditions.Wraps;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service.impl
 * Class(类名): TemplateServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/21
 * Time(创建时间)： 20:58
 * Version(版本): 1.0
 * Description(描述)： 模板
 */

@Slf4j
@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateMapper, TemplateEntity> implements TemplateService
{

    @Override
    public String getNextCode()
    {
        TemplateEntity templateEntity = this.getOne(Wraps.<TemplateEntity>lbQ()
                .orderByDesc(TemplateEntity::getCreateTime).last(" limit 1"));
        if (templateEntity != null)
        {
            String code = templateEntity.getCode();
            if (code.startsWith("DXMB"))
            {
                String numStr = code.split("_")[1];
                int num = Integer.parseInt(numStr) + 1;
                return "DXMB_" + StringUtils.autoGenericCode(num, 9);
            }
        }
        return "DXMB_000000001";

    }

    @Override
    public IPage<TemplateDTO> customPage(Page<TemplateDTO> page, Map<?, ?> params)
    {
        IPage<TemplateDTO> templateDTOIPage = this.baseMapper.custom(page, params);
        page.setRecords(templateDTOIPage.getRecords());
        return templateDTOIPage;
    }

    @Override
    public List<TemplateDTO> customList(Map<?, ?> params)
    {
        return this.baseMapper.custom(params);
    }

    @Override
    public TemplateEntity getByCode(String code)
    {
        return this.getOne(Wraps.<TemplateEntity>lbQ().eq(TemplateEntity::getCode, code));
    }

    @Override
    public TemplateEntity getByName(String name)
    {
        return this.getOne(Wraps.<TemplateEntity>lbQ().eq(TemplateEntity::getName, name));
    }
}
