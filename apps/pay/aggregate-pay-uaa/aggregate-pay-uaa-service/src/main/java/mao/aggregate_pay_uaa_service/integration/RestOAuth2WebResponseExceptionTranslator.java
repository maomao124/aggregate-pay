package mao.aggregate_pay_uaa_service.integration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.DefaultThrowableAnalyzer;
import org.springframework.security.oauth2.common.exceptions.InsufficientScopeException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.web.util.ThrowableAnalyzer;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import java.io.IOException;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.integration
 * Class(类名): RestOAuth2WebResponseExceptionTranslator
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 13:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class RestOAuth2WebResponseExceptionTranslator implements WebResponseExceptionTranslator
{
    /**
     * throwable分析仪
     */
    private ThrowableAnalyzer throwableAnalyzer = new DefaultThrowableAnalyzer();


    /**
     * 翻译
     *
     * @param e e
     * @return {@link ResponseEntity}<{@link OAuth2Exception}>
     * @throws Exception 异常
     */
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception
    {
        Throwable[] causeChain = this.throwableAnalyzer.determineCauseChain(e);
        Exception ase = (OAuth2Exception) this.throwableAnalyzer.getFirstThrowableOfType(OAuth2Exception.class, causeChain);
        if (ase != null)
        {
            return this.handleOAuth2Exception((OAuth2Exception) ase);
        }
        ase = (AuthenticationException) this.throwableAnalyzer.getFirstThrowableOfType(AuthenticationException.class, causeChain);
        if (ase != null)
        {
            return this.handleOAuth2Exception(new UnauthorizedException(e.getMessage(), e));
        }
        ase = (AccessDeniedException) this.throwableAnalyzer.getFirstThrowableOfType(AccessDeniedException.class, causeChain);
        if (ase instanceof AccessDeniedException)
        {
            return this.handleOAuth2Exception(new ForbiddenException(ase.getMessage(), ase));
        }

        ase = (HttpRequestMethodNotSupportedException) this.throwableAnalyzer.getFirstThrowableOfType(HttpRequestMethodNotSupportedException.class, causeChain);
        return ase instanceof HttpRequestMethodNotSupportedException ? this.handleOAuth2Exception(new MethodNotAllowed(ase.getMessage(), ase)) : this.handleOAuth2Exception(new ServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e));

    }

    /**
     * 处理oauth2异常
     *
     * @param e e
     * @return {@link ResponseEntity}<{@link OAuth2Exception}>
     * @throws IOException ioexception
     */
    private ResponseEntity<OAuth2Exception> handleOAuth2Exception(OAuth2Exception e) throws IOException
    {
        int status = e.getHttpErrorCode();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cache-Control", "no-store");
        headers.set("Pragma", "no-cache");
        if (status == HttpStatus.UNAUTHORIZED.value() || e instanceof InsufficientScopeException)
        {
            headers.set("WWW-Authenticate", String.format("%s %s", "Bearer", e.getSummary()));
        }
        //OAuth2Exception 转换restResponse过程
        RestOAuth2Exception restOAuth2Exception = new RestOAuth2Exception(e.getMessage(), e);

        ResponseEntity<OAuth2Exception> response = new ResponseEntity(restOAuth2Exception, headers, HttpStatus.valueOf(status));
        return response;
    }

    /**
     * 设置throwable分析仪
     *
     * @param throwableAnalyzer throwable分析仪
     */
    public void setThrowableAnalyzer(ThrowableAnalyzer throwableAnalyzer)
    {
        this.throwableAnalyzer = throwableAnalyzer;
    }

    /**
     * 方法不允许
     */
    private static class MethodNotAllowed extends OAuth2Exception
    {
        public MethodNotAllowed(String msg, Throwable t)
        {
            super(msg, t);
        }

        /**
         * 得到oauth2错误代码
         *
         * @return {@link String}
         */
        public String getOAuth2ErrorCode()
        {
            return "method_not_allowed";
        }

        /**
         * 得到http错误代码
         *
         * @return int
         */
        public int getHttpErrorCode()
        {
            return 405;
        }
    }

    /**
     * 未经授权异常
     */
    private static class UnauthorizedException extends OAuth2Exception
    {
        /**
         * 未经授权异常
         *
         * @param msg 消息
         * @param t   t
         */
        public UnauthorizedException(String msg, Throwable t)
        {
            super(msg, t);
        }

        /**
         * 得到oauth2错误代码
         *
         * @return {@link String}
         */
        public String getOAuth2ErrorCode()
        {
            return "unauthorized";
        }

        /**
         * 得到http错误代码
         *
         * @return int
         */
        public int getHttpErrorCode()
        {
            return 401;
        }
    }

    /**
     * 服务器错误异常
     */
    private static class ServerErrorException extends OAuth2Exception
    {
        /**
         * 服务器错误异常
         *
         * @param msg 消息
         * @param t   t
         */
        public ServerErrorException(String msg, Throwable t)
        {
            super(msg, t);
        }

        /**
         * 得到oauth2错误代码
         *
         * @return {@link String}
         */
        public String getOAuth2ErrorCode()
        {
            return "server_error";
        }

        /**
         * 得到http错误代码
         *
         * @return int
         */
        public int getHttpErrorCode()
        {
            return 500;
        }
    }

    private static class ForbiddenException extends OAuth2Exception
    {
        /**
         * 被禁止异常
         *
         * @param msg 消息
         * @param t   t
         */
        public ForbiddenException(String msg, Throwable t)
        {
            super(msg, t);
        }

        /**
         * 得到oauth2错误代码
         *
         * @return {@link String}
         */
        public String getOAuth2ErrorCode()
        {
            return "access_denied";
        }

        /**
         * 得到http错误代码
         *
         * @return int
         */
        public int getHttpErrorCode()
        {
            return 403;
        }
    }

}
