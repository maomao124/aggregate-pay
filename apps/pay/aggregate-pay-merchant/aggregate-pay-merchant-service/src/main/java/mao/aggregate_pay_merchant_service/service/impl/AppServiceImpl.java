package mao.aggregate_pay_merchant_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.utils.RandomUuidUtil;
import mao.aggregate_pay_merchant_api.dto.AppDTO;
import mao.aggregate_pay_merchant_service.entity.App;
import mao.aggregate_pay_merchant_service.entity.Merchant;
import mao.aggregate_pay_merchant_service.mapper.AppMapper;
import mao.aggregate_pay_merchant_service.service.AppService;
import mao.aggregate_pay_merchant_service.service.MerchantService;
import mao.tools_core.base.R;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.service.impl
 * Class(类名): AppServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/12
 * Time(创建时间)： 14:59
 * Version(版本): 1.0
 * Description(描述)： 应用
 */

@Slf4j
@Service
public class AppServiceImpl extends ServiceImpl<AppMapper, App> implements AppService
{

    @Resource
    private DozerUtils dozerUtils;

    @Resource
    private MerchantService merchantService;

    @Override
    public R<AppDTO> createApp(Long merchantId, AppDTO app)
    {
        //查询商户
        Merchant merchant = merchantService.getOne(Wraps.<Merchant>lbQ().eq(Merchant::getId, merchantId));
        if (merchant == null)
        {
            return R.fail("商户不存在");
        }
        //商户存在，查询审核状态，审核状态： 0-未申请,1-已申请待审核,2-审核通过,3-审核拒绝
        if (!"2".equals(merchant.getAuditStatus()))
        {
            //状态不为2
            return R.fail("商户资质申请未通过");
        }
        //app名字是否存在
        int count = this.count(Wraps.<App>lbQ().eq(App::getAppName, app.getAppName()));
        if (count > 0)
        {
            //存在
            return R.fail("应用名称已被使用");
        }
        //设置id
        app.setAppId(RandomUuidUtil.getUUID());
        //设置商户id
        app.setMerchantId(merchantId);
        //转换
        App app1 = dozerUtils.map(app, App.class);
        //保存
        boolean save = this.save(app1);
        if (!save)
        {
            return R.fail("保存失败");
        }
        //保存成功，主要是返回主键
        return R.success(dozerUtils.map(app1, AppDTO.class));
    }
}
