package mao.aggregate_pay_transaction_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_transaction_api.dto.PlatformChannelDTO;
import mao.aggregate_pay_transaction_service.entity.PayChannel;
import mao.aggregate_pay_transaction_service.entity.PlatformChannel;
import mao.aggregate_pay_transaction_service.mapper.PlatformChannelMapper;
import mao.aggregate_pay_transaction_service.service.PlatformChannelService;
import mao.tools_core.base.R;
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
}
