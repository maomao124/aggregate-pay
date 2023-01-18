package mao.aggregate_pay_uaa_service.integration;

import mao.aggregate_pay_uaa_service.domain.UnifiedUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.integration
 * Class(类名): UnifiedUserAuthenticationConverter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 14:23
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class UnifiedUserAuthenticationConverter implements UserAuthenticationConverter
{
    /**
     * 默认当局
     */
    private Collection<? extends GrantedAuthority> defaultAuthorities;

    /**
     * 用户详细信息服务
     */
    private UserDetailsService userDetailsService;

    /**
     * 设置用户详细信息服务
     * Optional {@link UserDetailsService} to use when extracting an {@link Authentication} from the incoming map.
     *
     * @param userDetailsService the userDetailsService to set
     */
    public void setUserDetailsService(UserDetailsService userDetailsService)
    {
        this.userDetailsService = userDetailsService;
    }

    /**
     * Default value for authorities if an Authentication is being created and the input has no data for authorities.
     * Note that unless this property is set, the default Authentication created by {@link #extractAuthentication(Map)}
     * will be unauthenticated.
     *
     * @param defaultAuthorities the defaultAuthorities to set. Default null.
     */
    public void setDefaultAuthorities(String[] defaultAuthorities)
    {
        this.defaultAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils
                .arrayToCommaDelimitedString(defaultAuthorities));
    }

    /**
     * 将用户身份验证
     *
     * @param authentication 身份验证
     * @return {@link Map}<{@link String}, {@link ?}>
     */
    public Map<String, ?> convertUserAuthentication(Authentication authentication)
    {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put(USERNAME, authentication.getName());
        if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty())
        {
            response.put(AUTHORITIES, AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
        }

        if (authentication.getPrincipal() instanceof UnifiedUserDetails)
        {
            UnifiedUserDetails unifiedUserDetails = (UnifiedUserDetails) authentication.getPrincipal();
            response.put("mobile", unifiedUserDetails.getMobile());
            response.put("payload", unifiedUserDetails.getPayload());
        }
        return response;
    }

    /**
     * 提取身份验证
     *
     * @param map 地图
     * @return {@link Authentication}
     */
    public Authentication extractAuthentication(Map<String, ?> map)
    {
        if (map.containsKey(USERNAME))
        {
            Object principal = map.get(USERNAME);
            Collection<? extends GrantedAuthority> authorities = getAuthorities(map);
            if (userDetailsService != null)
            {
                UserDetails user = userDetailsService.loadUserByUsername((String) map.get(USERNAME));
                authorities = user.getAuthorities();
                principal = user;
            }

            UnifiedUserDetails unifiedUserDetails = new UnifiedUserDetails((String) map.get(USERNAME), "N/A", (Map<Long, Object>) map.get("payload"));
            unifiedUserDetails.setMobile((String) map.get("mobile"));

            return new UsernamePasswordAuthenticationToken(unifiedUserDetails, "N/A", authorities);
        }
        return null;
    }

    /**
     * 得到当局
     *
     * @param map 地图
     * @return {@link Collection}<{@link ?} {@link extends} {@link GrantedAuthority}>
     */
    private Collection<? extends GrantedAuthority> getAuthorities(Map<String, ?> map)
    {
        if (!map.containsKey(AUTHORITIES))
        {
            return defaultAuthorities;
        }
        Object authorities = map.get(AUTHORITIES);
        if (authorities instanceof String)
        {
            return AuthorityUtils.commaSeparatedStringToAuthorityList((String) authorities);
        }
        if (authorities instanceof Collection)
        {
            return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils
                    .collectionToCommaDelimitedString((Collection<?>) authorities));
        }
        throw new IllegalArgumentException("Authorities must be either a String or a Collection");
    }
}
