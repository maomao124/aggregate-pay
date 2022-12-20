package mao.sms_manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.entity.BlackListEntity;
import mao.tools_core.base.R;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service
 * Interface(接口名): BlackListService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/20
 * Time(创建时间)： 18:52
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface BlackListService extends IService<BlackListEntity>
{
    /**
     * 上传
     *
     * @param file 文件
     * @return {@link R}<{@link Boolean}>
     */
    R<Map<String, Object>> upload(MultipartFile file);
}
