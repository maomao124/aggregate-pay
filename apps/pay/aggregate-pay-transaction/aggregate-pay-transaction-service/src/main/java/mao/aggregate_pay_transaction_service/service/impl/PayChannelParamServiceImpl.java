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
import mao.tools_redis_cache.entity.RedisData;
import mao.tools_redis_cache.utils.RedisUtils;
import mao.toolsdozer.utils.DozerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


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

        //让缓存过期
        String redisKey1 = payChannelParam.getAppId() + "__" + payChannelParam.getPlatformChannelCode();
        String redisKey2 = payChannelParam.getAppId() + "__" + payChannelParam.getPlatformChannelCode() + "__" + payChannelParam.getPayChannel();
        stringRedisTemplate.delete("pay:List_PayChannelParamDTO:query1:" + redisKey1);
        stringRedisTemplate.delete("pay:PayChannelParamDTO:query2:" + redisKey2);

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

    @Override
    public R<List<PayChannelParamDTO>> queryPayChannelParamByAppAndPlatform(String appId, String platformChannel)
    {
        //redisKey
        String redisKey = appId + "__" + platformChannel;
        //查询
        RedisData redisData = redisUtils.query("pay:List_PayChannelParamDTO:query1:"
                , "pay:List_PayChannelParamDTO:query1:lock:"
                , redisKey, RedisData.class, new Function<String, RedisData>()
                {
                    @Override
                    public RedisData apply(String s)
                    {
                        //查询数据库
                        List<PayChannelParamDTO> payChannelParamDTOList = queryPayChannelParamByAppAndPlatformByDatabase(appId, platformChannel);
                        //封装
                        RedisData redisData = new RedisData();
                        redisData.setData(payChannelParamDTOList);
                        //返回
                        return redisData;
                    }
                }, 300L, TimeUnit.MINUTES, 120);

        List<PayChannelParamDTO> payChannelParamDTOList = (List<PayChannelParamDTO>) redisData.getData();
        //返回
        return R.success(payChannelParamDTOList);
    }


    /**
     * 获取指定应用指定服务类型下所包含的原始支付渠道参数列表，从数据库里查询
     *
     * @param appId           应用id
     * @param platformChannel 平台通道
     * @return {@link List}<{@link PayChannelParamDTO}>
     */
    private List<PayChannelParamDTO> queryPayChannelParamByAppAndPlatformByDatabase(String appId, String platformChannel)
    {
        //查出应用id和服务类型代码在app_platform_channel主键
        Long appPlatformChannelId = selectIdByAppPlatformChannel(appId, platformChannel);
        if (appPlatformChannelId == null)
        {
            //应用未绑定该服务类型不可进行支付渠道参数配置
            throw new BizException("应用没有绑定服务类型");
        }
        //查询
        List<PayChannelParam> payChannelParamList = this.list(Wraps.<PayChannelParam>lbQ()
                .eq(PayChannelParam::getAppPlatformChannelId, appPlatformChannelId));
        //转换
        return dozerUtils.mapList(payChannelParamList, PayChannelParamDTO.class);
    }


    @Override
    public R<PayChannelParamDTO> queryParamByAppPlatformAndPayChannel(String appId, String platformChannel, String payChannel)
    {
        //redisKey
        String redisKey = appId + "__" + platformChannel + "__" + payChannel;
        //查询
        PayChannelParamDTO payChannelParamDTO = redisUtils.query("pay:PayChannelParamDTO:query2:"
                , "pay:PayChannelParamDTO:query2:lock:"
                , redisKey, PayChannelParamDTO.class, new Function<String, PayChannelParamDTO>()
                {
                    @Override
                    public PayChannelParamDTO apply(String s)
                    {
                        //查询数据库
                        return queryParamByAppPlatformAndPayChannelBydatabase(appId, platformChannel, payChannel);
                    }
                }, 300L, TimeUnit.MINUTES, 120);

        //返回
        return R.success(payChannelParamDTO);
    }


    /**
     * 获取指定应用指定服务类型下所包含的某个原始支付参数，从数据库里查询
     *
     * @param appId           应用程序id
     * @param platformChannel 平台通道
     * @param payChannel      支付通道
     * @return {@link R}<{@link PayChannelParamDTO}>
     */
    private PayChannelParamDTO queryParamByAppPlatformAndPayChannelBydatabase(String appId, String platformChannel, String payChannel)
    {
        //查出应用id和服务类型代码在app_platform_channel主键
        Long appPlatformChannelId = selectIdByAppPlatformChannel(appId, platformChannel);
        if (appPlatformChannelId == null)
        {
            //应用未绑定该服务类型不可进行支付渠道参数配置
            throw new BizException("应用没有绑定服务类型");
        }
        //查询
        PayChannelParam payChannelParam = this.getOne(Wraps.<PayChannelParam>lbQ()
                .eq(PayChannelParam::getAppPlatformChannelId, appPlatformChannelId)
                .eq(PayChannelParam::getPayChannel, payChannel));
        if (payChannelParam == null)
        {
            return null;
        }
        //转换
        return dozerUtils.map(payChannelParam, PayChannelParamDTO.class);
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
