package mao.aggregate_pay_merchant_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_merchant_service.entity.Store;
import mao.aggregate_pay_merchant_service.mapper.StoreMapper;
import mao.aggregate_pay_merchant_service.service.StoreService;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.service.impl
 * Class(类名): StoreServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/22
 * Time(创建时间)： 23:00
 * Version(版本): 1.0
 * Description(描述)： 门店服务实现类
 */

@Slf4j
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService
{

}
