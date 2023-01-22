package mao.aggregate_pay_uaa_service.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_uaa_service.domain.OauthClientDetails;
import mao.aggregate_pay_uaa_service.repository.OauthRepository;
import mao.aggregate_pay_uaa_service.service.OauthClientDetailsService;
import mao.aggregate_pay_uaa_service.utils.WebUtils;
import mao.tools_core.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.service.impl
 * Class(类名): OauthClientDetailsServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 20:07
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class OauthClientDetailsServiceImpl implements OauthClientDetailsService
{
    @Resource
    private OauthRepository oauthRepository;

    @Override
    public void createClientDetails(Map<String, String> map)
    {
        log.info("OauthClientDetailsServiceImpl createClientDetails map:{}", map);
        OauthClientDetails clientDetails = new OauthClientDetails()
                .clientId(map.get("clientId").toString())
                .clientSecret(map.get("clientSecret").toString())
                .resourceIds("aggregate-pay-resource")
                .authorizedGrantTypes("client_credentials,password,authorization_code,implicit,refresh_token")
                .scope("read")
                .webServerRedirectUri(null)
                .authorities("ROLE_API")
                .accessTokenValidity(7200)
                .refreshTokenValidity(259200)
                .additionalInformation(null)
                .createTime(LocalDateTime.now())
                .archived(false)
                .trusted(false);

        oauthRepository.saveOauthClientDetails(clientDetails);
        log.info("{} | Save OauthClientDetails: {}", WebUtils.getIp(), clientDetails);
    }

    @Override
    public Map<String, String> getClientDetailsByClientId(String appId)
    {
        OauthClientDetails oauthClientDetails = oauthRepository.findOauthClientDetails(appId);
        if (oauthClientDetails == null)
        {
            throw BizException.wrap("查询结果为空");
        }
        log.info("getClientDetailsByClientId param appId:{} ret:{}", appId, JSON.toJSONString(oauthClientDetails));
        Map<String, String> map = new HashMap<>();
        map.put("client_id", oauthClientDetails.clientId());
        map.put("client_secret", oauthClientDetails.clientSecret());
        return map;
    }
}
