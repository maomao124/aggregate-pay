package mao.sms_manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_entity.dto.SignatureDTO;
import mao.sms_entity.entity.SignatureEntity;
import mao.sms_entity.entity.base.BaseEntity;
import mao.sms_dao.mapper.SignatureMapper;
import mao.sms_manage.service.SignatureService;
import mao.sms_manage.utils.StringUtils;
import mao.tools_databases.mybatis.conditions.Wraps;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service.impl
 * Class(类名): SignatureServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/21
 * Time(创建时间)： 20:49
 * Version(版本): 1.0
 * Description(描述)： 签名
 */

@Slf4j
@Service
public class SignatureServiceImpl extends ServiceImpl<SignatureMapper, SignatureEntity> implements SignatureService
{

    @Override
    public String getNextCode()
    {
        SignatureEntity signatureEntity = this.baseMapper.selectOne(Wraps.<SignatureEntity>lbQ().orderByDesc(BaseEntity::getCreateTime)
                .last(" limit 1"));
        if (signatureEntity != null)
        {
            String code = signatureEntity.getCode();
            if (code.startsWith("DXQM"))
            {
                String numStr = code.split("_")[1];
                int num = Integer.parseInt(numStr) + 1;
                return "DXQM_" + StringUtils.autoGenericCode(num, 9);
            }
        }
        return "DXQM_000000001";
    }

    @Override
    public IPage<SignatureDTO> customPage(Page<SignatureDTO> page, Map<?, ?> params)
    {
        IPage<SignatureDTO> signatureDTOIPage = this.baseMapper.custom(page, params);
        page.setRecords(signatureDTOIPage.getRecords());
        return signatureDTOIPage;
    }

    @Override
    public List<SignatureDTO> customList(Map<?, ?> params)
    {
        return this.baseMapper.custom(params);
    }

    @Override
    public SignatureEntity getByCode(String code)
    {
        return this.getOne(Wraps.<SignatureEntity>lbQ().eq(SignatureEntity::getCode, code));
    }

    @Override
    public SignatureEntity getByName(String name)
    {
        return this.getOne(Wraps.<SignatureEntity>lbQ().eq(SignatureEntity::getName, name));
    }
}
