package mao.sms_api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_api.service.ConfigService;
import mao.sms_dao.mapper.ConfigMapper;
import mao.sms_entity.entity.ConfigEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.service.impl
 * Class(类名): ConfigServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 20:33
 * Version(版本): 1.0
 * Description(描述)： 通道配置
 */

@Slf4j
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, ConfigEntity> implements ConfigService
{

    @Override
    public List<ConfigEntity> findByTemplateSignature(String template, String signature)
    {
        Map<String,String> params = new HashMap<>();
        params.put("template", template);
        params.put("signature", signature);
        return baseMapper.findByTemplateSignature(params);
    }
}
