package mao.tools_jwt.utils;

import mao.tools_core.constants.BaseContextConstants;
import mao.tools_core.exception.BizException;

import mao.tools_core.exception.ExceptionCode;
import mao.tools_core.utils.DateUtils;
import mao.tools_core.utils.NumberHelper;
import mao.tools_core.utils.StrHelper;
import mao.tools_jwt.entity.JwtUserInfo;
import mao.tools_jwt.entity.Token;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Project name(项目名称)：jwt_spring_boot_starter
 * Package(包名): mao.tools_jwt.utils
 * Class(类名): JwtHelper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/2
 * Time(创建时间)： 22:24
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class JwtHelper
{
    private static final RsaKeyHelper RSA_KEY_HELPER = new RsaKeyHelper();

    private static final Logger log = LoggerFactory.getLogger(JwtHelper.class);

    /**
     * 生成用户令牌
     *
     * @param jwtInfo    jwt信息
     * @param priKeyPath 私钥路径
     * @param expire     到期时间
     * @return {@link Token}
     * @throws BizException 业务异常
     */
    public static Token generateUserToken(JwtUserInfo jwtInfo, String priKeyPath, int expire) throws BizException
    {
        JwtBuilder jwtBuilder = Jwts.builder()
                //设置主题
                .setSubject(String.valueOf(jwtInfo.getUserId()))
                .claim(BaseContextConstants.JWT_KEY_ACCOUNT, jwtInfo.getAccount())
                .claim(BaseContextConstants.JWT_KEY_NAME, jwtInfo.getName())
                .claim(BaseContextConstants.JWT_KEY_ORG_ID, jwtInfo.getOrgId())
                .claim(BaseContextConstants.JWT_KEY_STATION_ID, jwtInfo.getStationId());
        return generateToken(jwtBuilder, priKeyPath, expire);
    }


    /**
     * 获取token中的用户信息
     *
     * @param token      令牌
     * @param pubKeyPath 公钥路径
     * @return {@link JwtUserInfo}
     * @throws BizException 业务异常
     */
    public static JwtUserInfo getJwtFromToken(String token, String pubKeyPath) throws BizException
    {
        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        Claims body = claimsJws.getBody();
        String strUserId = body.getSubject();
        String account = StrHelper.getObjectValue(body.get(BaseContextConstants.JWT_KEY_ACCOUNT));
        String name = StrHelper.getObjectValue(body.get(BaseContextConstants.JWT_KEY_NAME));
        String strOrgId = StrHelper.getObjectValue(body.get(BaseContextConstants.JWT_KEY_ORG_ID));
        String strDepartmentId = StrHelper.getObjectValue(body.get(BaseContextConstants.JWT_KEY_STATION_ID));
        Long userId = NumberHelper.longValueOf0(strUserId);
        Long orgId = NumberHelper.longValueOf0(strOrgId);
        Long departmentId = NumberHelper.longValueOf0(strDepartmentId);
        return new JwtUserInfo(userId, account, name, orgId, departmentId);
    }


    /**
     * 生成token
     *
     * @param builder    构建器
     * @param priKeyPath 私钥路径
     * @param expire     到期时间
     * @return {@link Token}
     * @throws BizException 业务异常
     */
    protected static Token generateToken(JwtBuilder builder, String priKeyPath, int expire) throws BizException
    {
        try
        {
            //返回的字符串便是我们的jwt串了
            String compactJws = builder.setExpiration(DateUtils.localDateTime2Date(LocalDateTime.now().plusSeconds(expire)))
                    //设置算法（必须）
                    .signWith(SignatureAlgorithm.RS256, RSA_KEY_HELPER.getPrivateKey(priKeyPath))
                    //这个是全部设置完成后拼成jwt串的方法
                    .compact();
            return new Token(compactJws, expire);
        }
        catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e)
        {
            log.error("errcode:{}, message:{}", ExceptionCode.JWT_GEN_TOKEN_FAIL.getCode(), e.getMessage());
            throw new BizException(ExceptionCode.JWT_GEN_TOKEN_FAIL.getCode(), ExceptionCode.JWT_GEN_TOKEN_FAIL.getMsg());
        }
    }


    /**
     * 公钥解析token
     *
     * @param token      令牌
     * @param pubKeyPath 公钥路径
     * @return {@link Jws}<{@link Claims}>
     * @throws BizException 业务异常
     */
    private static Jws<Claims> parserToken(String token, String pubKeyPath) throws BizException
    {
        try
        {
            return Jwts.parser().setSigningKey(RSA_KEY_HELPER.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        }
        catch (ExpiredJwtException ex)
        {
            //过期
            throw new BizException(ExceptionCode.JWT_TOKEN_EXPIRED.getCode(), ExceptionCode.JWT_TOKEN_EXPIRED.getMsg());
        }
        catch (SignatureException ex)
        {
            //签名错误
            throw new BizException(ExceptionCode.JWT_SIGNATURE.getCode(), ExceptionCode.JWT_SIGNATURE.getMsg());
        }
        catch (IllegalArgumentException ex)
        {
            //token 为空
            throw new BizException(ExceptionCode.JWT_ILLEGAL_ARGUMENT.getCode(), ExceptionCode.JWT_ILLEGAL_ARGUMENT.getMsg());
        }
        catch (Exception e)
        {
            log.error("errcode:{}, message:{}", ExceptionCode.JWT_PARSER_TOKEN_FAIL.getCode(), e.getMessage());
            throw new BizException(ExceptionCode.JWT_PARSER_TOKEN_FAIL.getCode(), ExceptionCode.JWT_PARSER_TOKEN_FAIL.getMsg());
        }
    }
}
