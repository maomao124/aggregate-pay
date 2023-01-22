package mao.aggregate_pay_gateway.config;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

import java.util.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_gateway.config
 * Class(类名): ClientDefaultAccessTokenConverter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/22
 * Time(创建时间)： 20:00
 * Version(版本): 1.0
 * Description(描述)： 令牌格式json与spring OAuth2Authentication的转换   增加jwt对client Authorities的支持
 */

public class ClientDefaultAccessTokenConverter implements AccessTokenConverter
{
    private UserAuthenticationConverter userTokenConverter = new DefaultUserAuthenticationConverter();

    private boolean includeGrantType;

    /**
     * Converter for the part of the data in the token representing a user.
     *
     * @param userTokenConverter the userTokenConverter to set
     */
    public void setUserTokenConverter(UserAuthenticationConverter userTokenConverter)
    {
        this.userTokenConverter = userTokenConverter;
    }

    /**
     * Flag to indicate the the grant type should be included in the converted token.
     *
     * @param includeGrantType the flag value (default false)
     */
    public void setIncludeGrantType(boolean includeGrantType)
    {
        this.includeGrantType = includeGrantType;
    }

    public static final String CLIENT_AUTHORITIES = "client_authorities";

    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication)
    {
        Map<String, Object> response = new HashMap<String, Object>();
        OAuth2Request clientToken = authentication.getOAuth2Request();

        if (!authentication.isClientOnly())
        {
            response.putAll(userTokenConverter.convertUserAuthentication(authentication.getUserAuthentication()));

            ///增加对client Authorities支持
            if (clientToken.getAuthorities() != null && !clientToken.getAuthorities().isEmpty())
            {
                response.put(CLIENT_AUTHORITIES,
                        AuthorityUtils.authorityListToSet(authentication.getOAuth2Request().getAuthorities()));
            }
            ///结束增加对client Authorities支持
        }
        else
        {
            if (clientToken.getAuthorities() != null && !clientToken.getAuthorities().isEmpty())
            {
                response.put(UserAuthenticationConverter.AUTHORITIES,
                        AuthorityUtils.authorityListToSet(clientToken.getAuthorities()));
            }
        }

        if (token.getScope() != null)
        {
            response.put(SCOPE, token.getScope());
        }
        if (token.getAdditionalInformation().containsKey(JTI))
        {
            response.put(JTI, token.getAdditionalInformation().get(JTI));
        }

        if (token.getExpiration() != null)
        {
            response.put(EXP, token.getExpiration().getTime() / 1000);
        }

        if (includeGrantType && authentication.getOAuth2Request().getGrantType() != null)
        {
            response.put(GRANT_TYPE, authentication.getOAuth2Request().getGrantType());
        }

        response.putAll(token.getAdditionalInformation());

        response.put(CLIENT_ID, clientToken.getClientId());
        if (clientToken.getResourceIds() != null && !clientToken.getResourceIds().isEmpty())
        {
            response.put(AUD, clientToken.getResourceIds());
        }

        return response;
    }

    /**
     * 获取访问令牌
     *
     * @param value 价值
     * @param map   地图
     * @return {@link OAuth2AccessToken}
     */
    public OAuth2AccessToken extractAccessToken(String value, Map<String, ?> map)
    {
        DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(value);
        Map<String, Object> info = new HashMap<String, Object>(map);
        info.remove(EXP);
        info.remove(AUD);
        info.remove(CLIENT_ID);
        info.remove(SCOPE);
        if (map.containsKey(EXP))
        {
            token.setExpiration(new Date((Long) map.get(EXP) * 1000L));
        }
        if (map.containsKey(JTI))
        {
            info.put(JTI, map.get(JTI));
        }
        token.setScope(extractScope(map));
        token.setAdditionalInformation(info);
        return token;
    }

    /**
     * 提取身份验证
     *
     * @param map 地图
     * @return {@link OAuth2Authentication}
     */
    public OAuth2Authentication extractAuthentication(Map<String, ?> map)
    {
        Map<String, String> parameters = new HashMap<String, String>();
        Set<String> scope = extractScope(map);
        Authentication user = userTokenConverter.extractAuthentication(map);
        String clientId = (String) map.get(CLIENT_ID);
        parameters.put(CLIENT_ID, clientId);
        if (includeGrantType && map.containsKey(GRANT_TYPE))
        {
            parameters.put(GRANT_TYPE, (String) map.get(GRANT_TYPE));
        }
        Set<String> resourceIds = new LinkedHashSet<String>(map.containsKey(AUD) ? getAudience(map)
                : Collections.<String>emptySet());

        Collection<? extends GrantedAuthority> authorities = null;
        if (user == null && map.containsKey(AUTHORITIES))
        {
            @SuppressWarnings("unchecked")
            String[] roles = ((Collection<String>) map.get(AUTHORITIES)).toArray(new String[0]);
            authorities = AuthorityUtils.createAuthorityList(roles);
        }
        ///增加对client Authorities支持
        if (user != null && map.containsKey(CLIENT_AUTHORITIES))
        {
            String[] clentRoles = ((Collection<String>) map.get(CLIENT_AUTHORITIES)).toArray(new String[0]);
            authorities = AuthorityUtils.createAuthorityList(clentRoles);
            ///增加额外属性
            parameters.put("mobile", (String) map.get("mobile"));
            parameters.put("payload", JSON.toJSONString(map.get("payload")));
            ///结束增加额外属性
        }
        ///结束增加对client Authorities支持


        OAuth2Request request = new OAuth2Request(parameters, clientId, authorities, true, scope, resourceIds, null, null,
                null);
        return new OAuth2Authentication(request, user);
    }

    /**
     * getAudience
     *
     * @param map 地图
     * @return {@link Collection}<{@link String}>
     */
    private Collection<String> getAudience(Map<String, ?> map)
    {
        Object auds = map.get(AUD);
        if (auds instanceof Collection)
        {
            @SuppressWarnings("unchecked")
            Collection<String> result = (Collection<String>) auds;
            return result;
        }
        return Collections.singleton((String) auds);
    }

    /**
     * 提取范围
     *
     * @param map 地图
     * @return {@link Set}<{@link String}>
     */
    private Set<String> extractScope(Map<String, ?> map)
    {
        Set<String> scope = Collections.emptySet();
        if (map.containsKey(SCOPE))
        {
            Object scopeObj = map.get(SCOPE);
            if (String.class.isInstance(scopeObj))
            {
                scope = new LinkedHashSet<String>(Arrays.asList(String.class.cast(scopeObj).split(" ")));
            }
            else if (Collection.class.isAssignableFrom(scopeObj.getClass()))
            {
                @SuppressWarnings("unchecked")
                Collection<String> scopeColl = (Collection<String>) scopeObj;
                scope = new LinkedHashSet<String>(scopeColl);    // Preserve ordering
            }
        }
        return scope;
    }
}
