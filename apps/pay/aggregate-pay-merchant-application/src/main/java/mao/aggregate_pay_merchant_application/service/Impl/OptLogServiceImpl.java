package mao.aggregate_pay_merchant_application.service.Impl;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_entity.entity.OptLog;
import mao.aggregate_pay_merchant_application.feign.log.OptLogFeignClient;
import mao.aggregate_pay_merchant_application.service.OptLogService;
import mao.aggregate_pay_merchant_application.utils.SecurityUtil;
import mao.tools_core.base.R;
import mao.tools_log.entity.OptLogDTO;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.service.Impl
 * Class(类名): OptLogServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 16:29
 * Version(版本): 1.0
 * Description(描述)： 操作日志服务实现类
 */

@Slf4j
@Service
public class OptLogServiceImpl implements OptLogService
{

    @Resource
    private DozerUtils dozerUtils;

    @Resource
    private OptLogFeignClient optLogFeignClient;

    @Override
    public void save(OptLogDTO optLogDTO)
    {
        //转换对象
        OptLog optLog = dozerUtils.map(optLogDTO, OptLog.class);
        //设置商户id，也就是用户
        Long merchantId = SecurityUtil.getMerchantId();
        optLog.setUserName(merchantId);
        //打印日志
        log.info("商户id：" + optLog.getUserName() + "  请求：" + optLog.getRequestUri() + "  描述："
                + optLog.getDescription() + "  ip：" + optLog.getRequestIp() + "  耗时：" + optLog.getConsumingTime() + "ms");
        //远程调用，保存
        R<Boolean> r = optLogFeignClient.save(optLog);
        if (r.getIsError())
        {
            //错误，只打印警告信息
            log.warn("日志保存失败！ 信息：" + r.getMsg());
        }
        //保存成功，什么都不做，抛出异常可能就是服务宕机，不在同一线程，不会影响服务
    }
}
