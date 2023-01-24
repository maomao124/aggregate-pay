package mao.aggregate_pay_merchant_application.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.utils.EncryptUtil;
import mao.aggregate_pay_entity.entity.LoginUser;
import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_api.feign.MerchantFeignClient;
import mao.aggregate_pay_merchant_application.handler.AssertResult;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.utils
 * Class(类名): SecurityUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/23
 * Time(创建时间)： 22:12
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class SecurityUtil
{
    /**
     * 获取用户
     *
     * @return {@link LoginUser}
     */
    public static LoginUser getUser()
    {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();

        if (servletRequestAttributes != null)
        {
            HttpServletRequest request = servletRequestAttributes.getRequest();

            Object jwt = request.getAttribute("jsonToken");
            if (jwt instanceof LoginUser)
            {
                return (LoginUser) jwt;
            }
        }
        return new LoginUser();
    }


    /**
     * 根据TenantId查询商户
     *
     * @param tenantId tenantId
     * @return {@link MerchantDTO}
     */
    private static MerchantDTO queryMerchantDtoByTenantId(Long tenantId)
    {
        StringRedisTemplate stringRedisTemplate = ApplicationContextHelper.getBean(StringRedisTemplate.class);
        //redisKey
        String redisKey = "pay:MerchantDTO:getMerchantByTenantId:" + tenantId;
        //从分布式缓存里取数据
        String json = stringRedisTemplate.opsForValue().get(redisKey);
        log.debug("从分布式缓存里取商户数据：" + json);
        //如果为空
        if (StringUtils.isBlank(json))
        {
            //缓存里不存在
            //发起远程调用查询
            MerchantFeignClient merchantFeignClient = ApplicationContextHelper.getBean(MerchantFeignClient.class);
            log.debug("租户id：" + tenantId);
            R<MerchantDTO> r = merchantFeignClient.getMerchantByTenantId(tenantId);
            //断言结果
            AssertResult.handler(r);
            //取数据
            MerchantDTO merchant = r.getData();
            //返回
            return merchant;
        }
        //不为空，转换成对象
        MerchantDTO merchantDTO = JSON.parseObject(json, MerchantDTO.class);
        //返回
        return merchantDTO;
    }


    /**
     * 取得商户id
     *
     * @return {@link Long}
     */
    public static Long getMerchantId()
    {
        //查询
        MerchantDTO merchant = queryMerchantDtoByTenantId(getUser().getTenantId());
        Long merchantId = null;
        if (merchant != null)
        {
            //查询到了，返回
            merchantId = merchant.getId();
        }
        //查询不到，返回空
        return merchantId;
    }

    /**
     * 取得商户id，如果查询结果为空，抛出异常
     *
     * @return {@link Long}
     */
    public static Long getMerchantIdThrowsException()
    {
        //查询
        MerchantDTO merchant = queryMerchantDtoByTenantId(getUser().getTenantId());
        Long merchantId = null;
        if (merchant != null)
        {
            //查询到了，返回
            merchantId = merchant.getId();
            return merchantId;
        }
        //查询不到，抛出异常
        throw BizException.wrap("查询不到当前登录的商户信息");
    }


    /**
     * 取得当前登录的MerchantDTO
     *
     * @return {@link MerchantDTO}
     */
    public static MerchantDTO getMerchant()
    {
        //查询
        MerchantDTO merchant = queryMerchantDtoByTenantId(getUser().getTenantId());
        if (merchant != null)
        {
            //查询到了，返回
            return merchant;
        }
        //查询不到，返回空
        return null;
    }


    /**
     * 取得当前登录的MerchantDTO
     *
     * @return {@link MerchantDTO}
     */
    public static MerchantDTO getMerchantThrowsException()
    {
        //查询
        MerchantDTO merchant = queryMerchantDtoByTenantId(getUser().getTenantId());
        if (merchant != null)
        {
            //查询到了，返回
            return merchant;
        }
        //查询不到，抛出异常
        throw BizException.wrap("查询不到当前登录的商户信息");
    }

    /**
     * 转换明文jsonToken为用户对象
     *
     * @param token 令牌
     * @return {@link LoginUser}
     */
    public static LoginUser convertTokenToLoginUser(String token)
    {
        token = EncryptUtil.decodeUTF8StringBase64(token);
        LoginUser user = new LoginUser();
        JSONObject jsonObject = JSON.parseObject(token);
        String payload = jsonObject.getString("payload");
        Map<String, Object> payloadMap = JSON.parseObject(payload, Map.class);
        user.setPayload(payloadMap);
        user.setClientId(jsonObject.getString("client_id"));
        user.setMobile(jsonObject.getString("mobile"));
        user.setUsername(jsonObject.getString("user_name"));
        return user;
    }
}
