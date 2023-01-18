package mao.aggregate_pay_uaa_service.integration;

import com.alibaba.fastjson.JSON;
import mao.aggregate_pay_uaa_service.domain.AuthPrincipal;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.integration
 * Class(类名): IntegrationUserDetailsAuthenticationProvider
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:53
 * Version(版本): 1.0
 * Description(描述)： 统一用户认证处理，集成了网页(简化模式、授权码模式用户登录)认证  与  password模式认证
 */

public class IntegrationUserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider
{

    private IntegrationUserDetailsAuthenticationHandler authenticationHandler = null;

    public IntegrationUserDetailsAuthenticationProvider(IntegrationUserDetailsAuthenticationHandler authenticationHandler)
    {
        this.authenticationHandler = authenticationHandler;
    }

    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException
    {
        //仅在父类中验证用户的状态
    }


    protected final UserDetails retrieveUser(String username,
                                             UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException
    {
        try
        {

            UserDetails loadedUser = authenticationUser(authentication);
            if (loadedUser == null)
            {
                throw new InternalAuthenticationServiceException(
                        "UserDetailsService returned null, which is an interface contract violation");
            }
            return loadedUser;
        }
        catch (UsernameNotFoundException | InternalAuthenticationServiceException ex)
        {
            throw ex;
        }
        catch (Exception ex)
        {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex);
        }
    }

    private UserDetails authenticationUser(UsernamePasswordAuthenticationToken authentication)
    {

        if (authentication.getPrincipal() == null)
        {
            throw new BadCredentialsException("username is blank");
        }
        String username = authentication.getName();

        if (authentication.getCredentials() == null)
        {
            throw new BadCredentialsException("Credentials is blank");
        }
        String credentials = authentication.getCredentials().toString();

        AuthPrincipal authPrincipal = null;

        try
        {
            authPrincipal = JSON.parseObject(username, AuthPrincipal.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new BadCredentialsException("username parseObject error");
        }

        if (authentication.getDetails() instanceof Map)
        {
            Map detailsMap = (Map) authentication.getDetails();
            authPrincipal.getPayload().putAll(detailsMap);
        }

        return authenticationHandler.authentication(authPrincipal, credentials);
    }

}
