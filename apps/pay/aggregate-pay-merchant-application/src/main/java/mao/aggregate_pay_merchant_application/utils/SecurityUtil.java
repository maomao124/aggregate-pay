package mao.aggregate_pay_merchant_application.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import mao.aggregate_pay_common.utils.EncryptUtil;
import mao.aggregate_pay_entity.entity.LoginUser;
import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_api.feign.MerchantFeignClient;
import mao.aggregate_pay_merchant_application.handler.AssertResult;
import mao.tools_core.base.R;
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
     * 取得商户id
     *
     * @return {@link Long}
     */
    public static Long getMerchantId()
    {
        MerchantFeignClient merchantFeignClient = ApplicationContextHelper.getBean(MerchantFeignClient.class);
        //远程调用
        R<MerchantDTO> r = merchantFeignClient.getById(getUser().getTenantId());
        //断言结果
        AssertResult.handler(r);
        //取数据
        MerchantDTO merchant = r.getData();
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
     * 取得当前登录的MerchantDTO
     *
     * @return {@link MerchantDTO}
     */
    public static MerchantDTO getMerchant()
    {
        MerchantFeignClient merchantFeignClient = ApplicationContextHelper.getBean(MerchantFeignClient.class);
        //远程调用
        R<MerchantDTO> r = merchantFeignClient.getById(getUser().getTenantId());
        //断言结果
        AssertResult.handler(r);
        //取数据
        MerchantDTO merchant = r.getData();
        if (merchant != null)
        {
            //查询到了，返回
            return merchant;
        }
        //查询不到，返回空
        return null;
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
