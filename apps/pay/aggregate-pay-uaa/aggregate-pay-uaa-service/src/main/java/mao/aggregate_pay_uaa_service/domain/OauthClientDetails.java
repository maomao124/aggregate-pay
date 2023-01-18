package mao.aggregate_pay_uaa_service.domain;

import mao.aggregate_pay_common.utils.DateUtil;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.domain
 * Class(类名): OauthClientDetails
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 14:14
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class OauthClientDetails implements Serializable
{

    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = -1L;

    /**
     * 创建时间
     */
    private LocalDateTime createTime = DateUtil.now();

    /**
     * 存档
     */
    private boolean archived = false;
    /**
     * 客户机id
     */
    private String clientId;

    /**
     * 资源id
     */
    private String resourceIds;

    /**
     * 客户秘密
     */
    private String clientSecret;

    /**
     * 范围
     */
    private String scope;

    /**
     * 授权授权类型
     */
    private String authorizedGrantTypes = "authorization_code,refresh_token";

    /**
     * web服务器uri重定向
     */
    private String webServerRedirectUri;

    /**
     * 当局
     */
    private String authorities;

    /**
     * 访问令牌有效性
     */
    private Integer accessTokenValidity;

    /**
     * 刷新令牌有效性
     */
    private Integer refreshTokenValidity;

    /**
     * 额外信息
     */
    private String additionalInformation;

    /**
     * 受信任
     */
    private boolean trusted = false;

    /**
     * 自动批准
     */
    private String autoApprove;

    /**
     * oauth客户详细信息
     */
    public OauthClientDetails()
    {
    }

    /**
     * 自动批准
     *
     * @return {@link String}
     */
    public String autoApprove()
    {
        return autoApprove;
    }

    /**
     * 自动批准
     *
     * @param autoApprove 自动批准
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails autoApprove(String autoApprove)
    {
        this.autoApprove = autoApprove;
        return this;
    }

    /**
     * 受信任
     *
     * @return boolean
     */
    public boolean trusted()
    {
        return trusted;
    }

    /**
     * 创建时间
     *
     * @return {@link LocalDateTime}
     */
    public LocalDateTime createTime()
    {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @param createTime 创建时间
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails createTime(LocalDateTime createTime)
    {
        this.createTime = createTime;
        return this;
    }

    /**
     * 存档
     *
     * @return boolean
     */
    public boolean archived()
    {
        return archived;
    }

    /**
     * 客户机id
     *
     * @return {@link String}
     */
    public String clientId()
    {
        return clientId;
    }

    /**
     * 资源id
     *
     * @return {@link String}
     */
    public String resourceIds()
    {
        return resourceIds;
    }

    /**
     * 客户秘密
     *
     * @return {@link String}
     */
    public String clientSecret()
    {
        return clientSecret;
    }

    /**
     * 范围
     *
     * @return {@link String}
     */
    public String scope()
    {
        return scope;
    }

    /**
     * 授权授权类型
     *
     * @return {@link String}
     */
    public String authorizedGrantTypes()
    {
        return authorizedGrantTypes;
    }

    /**
     * web服务器uri重定向
     *
     * @return {@link String}
     */
    public String webServerRedirectUri()
    {
        return webServerRedirectUri;
    }

    /**
     * 当局
     *
     * @return {@link String}
     */
    public String authorities()
    {
        return authorities;
    }

    /**
     * 访问令牌有效性
     *
     * @return {@link Integer}
     */
    public Integer accessTokenValidity()
    {
        return accessTokenValidity;
    }

    /**
     * 刷新令牌有效性
     *
     * @return {@link Integer}
     */
    public Integer refreshTokenValidity()
    {
        return refreshTokenValidity;
    }

    /**
     * 额外信息
     *
     * @return {@link String}
     */
    public String additionalInformation()
    {
        return additionalInformation;
    }


    /**
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder();
        sb.append("OauthClientDetails");
        sb.append("{createTime=").append(createTime);
        sb.append(", archived=").append(archived);
        sb.append(", clientId='").append(clientId).append('\'');
        sb.append(", resourceIds='").append(resourceIds).append('\'');
        sb.append(", clientSecret='").append(clientSecret).append('\'');
        sb.append(", scope='").append(scope).append('\'');
        sb.append(", authorizedGrantTypes='").append(authorizedGrantTypes).append('\'');
        sb.append(", webServerRedirectUri='").append(webServerRedirectUri).append('\'');
        sb.append(", authorities='").append(authorities).append('\'');
        sb.append(", accessTokenValidity=").append(accessTokenValidity);
        sb.append(", refreshTokenValidity=").append(refreshTokenValidity);
        sb.append(", additionalInformation='").append(additionalInformation).append('\'');
        sb.append(", trusted=").append(trusted);
        sb.append('}');
        return sb.toString();
    }

    /**
     * 客户机id
     *
     * @param clientId 客户机id
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails clientId(String clientId)
    {
        this.clientId = clientId;
        return this;
    }

    /**
     * 客户秘密
     *
     * @param clientSecret 客户秘密
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails clientSecret(String clientSecret)
    {
        this.clientSecret = clientSecret;
        return this;
    }

    /**
     * 资源id
     *
     * @param resourceIds 资源id
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails resourceIds(String resourceIds)
    {
        this.resourceIds = resourceIds;
        return this;
    }

    /**
     * 授权授权类型
     *
     * @param authorizedGrantTypes 授权授权类型
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails authorizedGrantTypes(String authorizedGrantTypes)
    {
        this.authorizedGrantTypes = authorizedGrantTypes;
        return this;
    }

    /**
     * 范围
     *
     * @param scope 范围
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails scope(String scope)
    {
        this.scope = scope;
        return this;
    }

    /**
     * web服务器uri重定向
     *
     * @param webServerRedirectUri web服务器uri重定向
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails webServerRedirectUri(String webServerRedirectUri)
    {
        this.webServerRedirectUri = webServerRedirectUri;
        return this;
    }

    /**
     * 当局
     *
     * @param authorities 当局
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails authorities(String authorities)
    {
        this.authorities = authorities;
        return this;
    }

    /**
     * 访问令牌有效性
     *
     * @param accessTokenValidity 访问令牌有效性
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails accessTokenValidity(Integer accessTokenValidity)
    {
        this.accessTokenValidity = accessTokenValidity;
        return this;
    }

    /**
     * 刷新令牌有效性
     *
     * @param refreshTokenValidity 刷新令牌有效性
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails refreshTokenValidity(Integer refreshTokenValidity)
    {
        this.refreshTokenValidity = refreshTokenValidity;
        return this;
    }

    /**
     * 受信任
     *
     * @param trusted 受信任
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails trusted(boolean trusted)
    {
        this.trusted = trusted;
        return this;
    }

    /**
     * 额外信息
     *
     * @param additionalInformation 额外信息
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails additionalInformation(String additionalInformation)
    {
        this.additionalInformation = additionalInformation;
        return this;
    }

    /**
     * 存档
     *
     * @param archived 存档
     * @return {@link OauthClientDetails}
     */
    public OauthClientDetails archived(boolean archived)
    {
        this.archived = archived;
        return this;
    }
}
