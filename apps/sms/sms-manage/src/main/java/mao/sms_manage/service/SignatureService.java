package mao.sms_manage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.dto.SignatureDTO;
import mao.sms_entity.entity.SignatureEntity;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service
 * Interface(接口名): SignatureService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/20
 * Time(创建时间)： 19:08
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface SignatureService extends IService<SignatureEntity>
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
     * @return {@link IPage}<{@link SignatureDTO}>
     */
    IPage<SignatureDTO> customPage(Page<SignatureDTO> page, Map<?,?> params);

    /**
     * 自定义列表
     *
     * @param params 参数
     * @return {@link List}<{@link SignatureDTO}>
     */
    List<SignatureDTO> customList(Map<?,?> params);

    /**
     * 通过代码得到SignatureEntity
     *
     * @param code 代码
     * @return {@link SignatureEntity}
     */
    SignatureEntity getByCode(String code);

    /**
     * 通过名字得到SignatureEntity
     *
     * @param name 名字
     * @return {@link SignatureEntity}
     */
    SignatureEntity getByName(String name);
}
