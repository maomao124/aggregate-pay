package mao.sms_api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.entity.ConfigEntity;

import java.util.List;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.service
 * Interface(接口名): ConfigService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 14:46
 * Version(版本): 1.0
 * Description(描述)： 配置
 */

public interface ConfigService extends IService<ConfigEntity>
{
    /**
     * 模板和签名找到配置
     *
     * @param template  模板
     * @param signature 签名
     * @return {@link List}<{@link ConfigEntity}>
     */
    List<ConfigEntity> findByTemplateSignature(String template, String signature);
}
