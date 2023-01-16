package mao.aggregate_pay_transaction_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.CommonErrorCode;
import mao.aggregate_pay_transaction_api.dto.PayChannelParamDTO;
import mao.aggregate_pay_transaction_service.entity.AppPlatformChannel;
import mao.aggregate_pay_transaction_service.entity.PayChannelParam;
import mao.aggregate_pay_transaction_service.mapper.PayChannelParamMapper;
import mao.aggregate_pay_transaction_service.service.AppPlatformChannelService;
import mao.aggregate_pay_transaction_service.service.PayChannelParamService;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.toolsdozer.utils.DozerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service.impl
 * Class(类名): PayChannelParamServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/16
 * Time(创建时间)： 20:09
 * Version(版本): 1.0
 * Description(描述)： 原始的支付聚道参数服务实现类
 */

@Slf4j
@Service
public class PayChannelParamServiceImpl extends ServiceImpl<PayChannelParamMapper, PayChannelParam> implements PayChannelParamService
{

    @Resource
    private AppPlatformChannelService appPlatformChannelService;

    @Resource
    private DozerUtils dozerUtils;


    @Override
    public R<Boolean> savePayChannelParam(PayChannelParamDTO payChannelParam)
    {
        //去掉id
        payChannelParam.setId(null);
        //根据appid和服务类型查询应用与服务类型绑定id
        Long appPlatformChannelId = selectIdByAppPlatformChannel(payChannelParam.getAppId(),
                payChannelParam.getPlatformChannelCode());
        //判断是否为空
        if (appPlatformChannelId == null)
        {
            //应用未绑定该服务类型不可进行支付渠道参数配置
            throw new BizException("应用没有绑定服务类型");
        }
        //根据应用与服务类型绑定id和支付渠道查询参数信息
        PayChannelParam payChannelParam1 = this.getOne(Wraps.<PayChannelParam>lbQ()
                .eq(PayChannelParam::getAppPlatformChannelId, appPlatformChannelId)
                .eq(PayChannelParam::getPayChannel, payChannelParam.getPayChannel()));
        //判断是否为空
        if (payChannelParam1 == null)
        {
            log.debug("添加支付聚道参数");
            //转换
            PayChannelParam payChannelParam2 = dozerUtils.map(payChannelParam, PayChannelParam.class);
            payChannelParam2.setAppPlatformChannelId(appPlatformChannelId);
            //插入
            this.save(payChannelParam2);
            //返回
            return R.success();
        }
        else
        {
            log.debug("更新支付聚道参数");
            payChannelParam1.setChannelName(payChannelParam.getChannelName());
            //设置参数
            payChannelParam1.setParam(payChannelParam.getParam());
            //更新
            this.updateById(payChannelParam1);
            //返回
            return R.success();
        }

    }


    /**
     * 根据appid和服务类型查询应用与服务类型绑定id
     *
     * @param appId               应用程序id
     * @param platformChannelCode 平台渠道代码
     * @return {@link Long}
     */
    private Long selectIdByAppPlatformChannel(String appId, String platformChannelCode)
    {
        //查询中间表
        AppPlatformChannel appPlatformChannel = appPlatformChannelService.getOne(Wraps.<AppPlatformChannel>lbQ()
                .eq(AppPlatformChannel::getPlatformChannel, platformChannelCode)
                .eq(AppPlatformChannel::getAppId, appId));
        //返回id
        if (appPlatformChannel != null)
        {
            return appPlatformChannel.getId();
        }
        return null;
    }
}
