package mao.sms_entity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.sms_entity.entity.ConfigEntity;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.mapper
 * Interface(接口名): ConfigMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:46
 * Version(版本): 1.0
 * Description(描述)： 配置表
 */

public interface ConfigMapper extends BaseMapper<ConfigEntity>
{
    /**
     * 根据签名与模板 获取适配的通道配置信息
     *
     * @param params 签名id 、模板id
     * @return 配置集合
     */
    List<ConfigEntity> findByTemplateSignature(Map<?,?> params);
}
