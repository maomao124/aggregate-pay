package mao.tools_jwt.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Project name(项目名称)：jwt_spring_boot_starter
 * Package(包名): mao.tools_jwt.entity
 * Class(类名): Token
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/2
 * Time(创建时间)： 22:15
 * Version(版本): 1.0
 * Description(描述)： 无
 */
public class Token implements Serializable
{
    private static final long serialVersionUID = -8482946147572784305L;

    /**
     * token
     */
    @ApiModelProperty(value = "token")
    private String token;
    /**
     * 有效时间：单位：秒
     */
    @ApiModelProperty(value = "token的有效期")
    private Integer expire;

    /**
     * Instantiates a new Token.
     */
    public Token()
    {

    }

    /**
     * Instantiates a new Token.
     *
     * @param token  the token
     * @param expire the expire
     */
    public Token(String token, Integer expire)
    {
        this.token = token;
        this.expire = expire;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken()
    {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token)
    {
        this.token = token;
    }

    /**
     * Gets expire.
     *
     * @return the expire
     */
    public Integer getExpire()
    {
        return expire;
    }

    /**
     * Sets expire.
     *
     * @param expire the expire
     */
    public void setExpire(Integer expire)
    {
        this.expire = expire;
    }
}
