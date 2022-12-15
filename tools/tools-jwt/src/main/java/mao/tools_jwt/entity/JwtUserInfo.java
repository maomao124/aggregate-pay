package mao.tools_jwt.entity;

import java.io.Serializable;

/**
 * Project name(项目名称)：jwt_spring_boot_starter
 * Package(包名): mao.tools_jwt.entity
 * Class(类名): JwtUserInfo
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/2
 * Time(创建时间)： 22:12
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class JwtUserInfo implements Serializable
{
    /**
     * 账号id
     */
    private Long userId;
    /**
     * 账号
     */
    private String account;
    /**
     * 姓名
     */
    private String name;

    /**
     * 当前登录人单位id
     */
    private Long orgId;

    /**
     * 当前登录人岗位ID
     */
    private Long stationId;

    /**
     * Instantiates a new Jwt user info.
     */
    public JwtUserInfo()
    {

    }

    /**
     * Instantiates a new Jwt user info.
     *
     * @param userId    the user id
     * @param account   the account
     * @param name      the name
     * @param orgId     the org id
     * @param stationId the station id
     */
    public JwtUserInfo(Long userId, String account, String name, Long orgId, Long stationId)
    {
        this.userId = userId;
        this.account = account;
        this.name = name;
        this.orgId = orgId;
        this.stationId = stationId;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public Long getUserId()
    {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    /**
     * Gets account.
     *
     * @return the account
     */
    public String getAccount()
    {
        return account;
    }

    /**
     * Sets account.
     *
     * @param account the account
     */
    public void setAccount(String account)
    {
        this.account = account;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets org id.
     *
     * @return the org id
     */
    public Long getOrgId()
    {
        return orgId;
    }

    /**
     * Sets org id.
     *
     * @param orgId the org id
     */
    public void setOrgId(Long orgId)
    {
        this.orgId = orgId;
    }

    /**
     * Gets station id.
     *
     * @return the station id
     */
    public Long getStationId()
    {
        return stationId;
    }

    /**
     * Sets station id.
     *
     * @param stationId the station id
     */
    public void setStationId(Long stationId)
    {
        this.stationId = stationId;
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("JwtUserInfo{");
        sb.append("userId=").append(userId);
        sb.append(", account='").append(account).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", orgId=").append(orgId);
        sb.append(", stationId=").append(stationId);
        sb.append('}');
        return sb.toString();
    }
}
