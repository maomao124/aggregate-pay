package mao.aggregate_pay_merchant_application.service.Impl;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.BusinessException;
import mao.aggregate_pay_common.domain.CommonErrorCode;
import mao.aggregate_pay_common.utils.QiniuUtils;
import mao.aggregate_pay_merchant_application.config.QNFileConfigurationProperties;
import mao.aggregate_pay_merchant_application.service.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.service.Impl
 * Class(类名): FileServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/11
 * Time(创建时间)： 20:30
 * Version(版本): 1.0
 * Description(描述)： 文件服务
 */

@Slf4j
@Service
public class FileServiceImpl implements FileService
{
    @Resource
    private QNFileConfigurationProperties qnFileConfigurationProperties;

    @Override
    public String upload(byte[] bytes, String fileName)
    {
        try
        {
            //调用工具类
            QiniuUtils.upload2qiniu(qnFileConfigurationProperties.getAccessKey(),
                    qnFileConfigurationProperties.getSecretKey(), qnFileConfigurationProperties.getBucket(), bytes, fileName);
            //上传成功返回文件的访问地址
            return qnFileConfigurationProperties.getUrl() + fileName;
        }
        catch (RuntimeException e)
        {
            //抛出异常
            throw new BusinessException(CommonErrorCode.E_100106);
        }
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 FileServiceImpl ， bucket：" + qnFileConfigurationProperties.getBucket());
    }
}
