package mao.aggregate_pay_transaction_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_transaction_api.dto.PlatformChannelDTO;
import mao.aggregate_pay_transaction_service.entity.AppPlatformChannel;
import mao.aggregate_pay_transaction_service.entity.PayChannel;
import mao.aggregate_pay_transaction_service.entity.PlatformChannel;
import mao.aggregate_pay_transaction_service.mapper.AppPlatformChannelMapper;
import mao.aggregate_pay_transaction_service.mapper.PlatformChannelMapper;
import mao.aggregate_pay_transaction_service.service.PlatformChannelService;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_redis_cache.entity.RedisData;
import mao.tools_redis_cache.utils.RedisUtils;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service.impl
 * Class(类名): PlatformChannelServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 22:56
 * Version(版本): 1.0
 * Description(描述)： 服务类型 服务实现类
 */

@Slf4j
@Service
public class PlatformChannelServiceImpl extends ServiceImpl<PlatformChannelMapper, PlatformChannel> implements PlatformChannelService
{
    @Resource
    private DozerUtils dozerUtils;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private AppPlatformChannelMapper appPlatformChannelMapper;

    @Override
    public R<List<PlatformChannelDTO>> queryAll()
    {
        RedisData redisData = redisUtils.query("pay:List_PlatformChannelDTO:queryAll:",
                "pay:List_PlatformChannelDTO:queryAll:lock", -1,
                RedisData.class, new Function<Integer, RedisData>()
                {
                    @Override
                    public RedisData apply(Integer integer)
                    {
                        //查询所有
                        List<PlatformChannel> platformChannelList = list();
                        //转换
                        List<PlatformChannelDTO> platformChannelDTOList = dozerUtils.mapList(platformChannelList, PlatformChannelDTO.class);
                        //返回
                        RedisData redisData1 = new RedisData();
                        redisData1.setData(platformChannelDTOList);
                        return redisData1;
                    }
                }, 60L, TimeUnit.MINUTES, 60);
        //返回
        List<PlatformChannelDTO> platformChannelDTOList = (List<PlatformChannelDTO>) redisData.getData();
        return R.success(platformChannelDTOList);

    }

    @Override
    public void bindPlatformChannelForApp(String appId, String platformChannelCodes)
    {
        //查询平台服务类型code是否存在
        int count = this.count(Wraps.<PlatformChannel>lbQ().eq(PlatformChannel::getChannelCode, platformChannelCodes));
        if (count <= 0)
        {
            throw BizException.wrap("平台服务类型码不存在");
        }
        //根据appId和平台服务类型code查询app_platform_channel
        AppPlatformChannel appPlatformChannel = appPlatformChannelMapper.selectOne(Wraps.<AppPlatformChannel>lbQ()
                .eq(AppPlatformChannel::getAppId, appId)
                .eq(AppPlatformChannel::getPlatformChannel, platformChannelCodes));
        //判断是否已绑定
        if (appPlatformChannel == null)
        {
            //目前还没有绑定
            //绑定
            appPlatformChannel = new AppPlatformChannel();
            appPlatformChannel.setAppId(appId);
            appPlatformChannel.setPlatformChannel(platformChannelCodes);
            //插入
            int insert = appPlatformChannelMapper.insert(appPlatformChannel);
            if (insert <= 0)
            {
                throw BizException.wrap("绑定失败");
            }
        }
        //已经绑定了，什么都不做
    }
}
