package mao.aggregate_pay_uaa_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_uaa_service.service.OauthClientDetailsService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.controller
 * Class(类名): UAAControllerV2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/22
 * Time(创建时间)： 19:12
 * Version(版本): 2.0
 * Description(描述)： 认证和授权
 */

@Slf4j
@RestController
@RequestMapping("/v2")
@Api(value = "认证和授权V2.0", tags = "认证和授权V2.0")
public class UAAControllerV2 extends BaseController
{

    /**
     * 授权服务器令牌服务
     */
    @Autowired
    private AuthorizationServerTokenServices tokenService;

    /**
     * 访问令牌转换器
     */
    @Resource
    private AccessTokenConverter accessTokenConverter;


    /**
     * oauth端细节服务
     */
    @Resource
    private OauthClientDetailsService oauthClientDetailsService;


    /**
     * 检查令牌
     *
     * @param value 令牌
     * @return {@link Map}<{@link String}, {@link ?}>
     */
    @PostMapping(value = "/oauth/check_token")
    @ApiOperation(value = "检查令牌")
    public R<Map<String, ?>> checkToken(@RequestParam("token") String value)
    {
        DefaultTokenServices tokenServices = (DefaultTokenServices) tokenService;

        OAuth2AccessToken token = tokenServices.readAccessToken(value);
        if (token == null)
        {
            throw new InvalidTokenException("Token was not recognised");
        }

        if (token.isExpired())
        {
            throw new InvalidTokenException("Token has expired");
        }
        OAuth2Authentication authentication = tokenServices.loadAuthentication(token.getValue());
        //返回
        return success(accessTokenConverter.convertAccessToken(token, authentication));
    }


    /**
     * 创建客户细节
     *
     * @param map 地图
     */
    @ApiOperation(value = "创建客户细节")
    @PostMapping("/oauth/createClientDetails")
    public R<Boolean> createClientDetails(@RequestBody Map<String, String> map)
    {
        oauthClientDetailsService.createClientDetails(map);
        return success();
    }


    /**
     * 根据appId查询client信息  appId也就是client_id
     *
     * @param appId 应用程序id
     * @return {@link Map}<{@link String},{@link String}>
     */
    @ApiOperation(value = "根据client_id查询client信息")
    @GetMapping("/oauth/getClientDetailsByClientId")
    public R<Map<String, String>> getClientDetailsByClientId(@RequestParam String appId)
    {
        return success(oauthClientDetailsService.getClientDetailsByClientId(appId));
    }


}
