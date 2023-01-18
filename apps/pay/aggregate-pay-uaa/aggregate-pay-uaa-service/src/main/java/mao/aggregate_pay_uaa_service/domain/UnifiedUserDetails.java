package mao.aggregate_pay_uaa_service.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.domain
 * Class(类名): UnifiedUserDetails
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 14:16
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class UnifiedUserDetails implements UserDetails
{
    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 2L;

    /**
     * 授予政府
     */
    protected List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 移动
     */
    private String mobile;

    /**
     * 有效载荷
     */
    private Map<Long, Object> payload = new HashMap<>();

    /**
     * 租户
     */
    private Map<String, Object> tenant = new HashMap<>();


    /**
     * 统一用户详细信息
     *
     * @param username 用户名
     * @param password 密码
     */
    public UnifiedUserDetails(String username, String password)
    {
        this.username = username;
        this.password = password;
    }


    /**
     * 统一用户详细信息
     *
     * @param username 用户名
     * @param password 密码
     * @param payload  有效载荷
     */
    public UnifiedUserDetails(String username, String password, Map<Long, Object> payload)
    {
        this.username = username;
        this.password = password;
        this.payload = payload;
    }


    /**
     * 得到当局
     *
     * @return {@link Collection}<{@link GrantedAuthority}>
     */
    @Override
    public Collection<GrantedAuthority> getAuthorities()
    {
        return this.grantedAuthorities;
    }

    /**
     * 得到密码
     *
     * @return {@link String}
     */
    @Override
    public String getPassword()
    {
        return password;
    }

    /**
     * 获得用户名
     *
     * @return {@link String}
     */
    @Override
    public String getUsername()
    {
        return username;
    }

    /**
     * 得到有效载荷
     *
     * @return {@link Map}<{@link Long}, {@link Object}>
     */
    public Map<Long, Object> getPayload()
    {
        return payload;
    }

    /**
     * 设置有效载荷
     *
     * @param payload 有效载荷
     */
    public void setPayload(Map<Long, Object> payload)
    {
        this.payload = payload;
    }


    /**
     * 账户是否未过期
     *
     * @return boolean
     */
    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    /**
     * 账户是否未锁定
     *
     * @return boolean
     */
    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    /**
     * 密码是否未过期
     *
     * @return boolean
     */
    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    /**
     * 账户是否启用,默认true
     *
     * @return boolean
     */
    @Override
    public boolean isEnabled()
    {
        return true;
    }


    /**
     * 得到移动
     *
     * @return {@link String}
     */
    public String getMobile()
    {
        return mobile;
    }

    /**
     * 设置手机
     *
     * @param mobile 移动
     */
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    /**
     * 让租户
     *
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    public Map<String, Object> getTenant()
    {
        return tenant;
    }

    /**
     * 设置租户
     *
     * @param tenant 租户
     */
    public void setTenant(Map<String, Object> tenant)
    {
        this.tenant = tenant;
    }
}
