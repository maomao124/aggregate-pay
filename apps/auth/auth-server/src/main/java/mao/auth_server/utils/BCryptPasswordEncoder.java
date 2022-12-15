package mao.auth_server.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.utils
 * Class(类名): BCryptPasswordEncoder
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 20:40
 * Version(版本): 1.0
 * Description(描述)： BCrypt
 */


public class BCryptPasswordEncoder
{
    private final Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2(a|y|b)?\\$(\\d\\d)\\$[./0-9A-Za-z]{53}");

    private final Log logger = LogFactory.getLog(getClass());

    private final int strength;

    private final BCryptVersion version;

    private final SecureRandom random;

    /**
     * Instantiates a new B crypt password encoder.
     */
    public BCryptPasswordEncoder()
    {
        this(-1);
    }

    /**
     * Instantiates a new B crypt password encoder.
     *
     * @param strength the log rounds to use, between 4 and 31
     */
    public BCryptPasswordEncoder(int strength)
    {
        this(strength, null);
    }

    /**
     * Instantiates a new B crypt password encoder.
     *
     * @param version the version of bcrypt, can be 2a,2b,2y
     */
    public BCryptPasswordEncoder(BCryptVersion version)
    {
        this(version, null);
    }

    /**
     * Instantiates a new B crypt password encoder.
     *
     * @param version the version of bcrypt, can be 2a,2b,2y
     * @param random  the secure random instance to use
     */
    public BCryptPasswordEncoder(BCryptVersion version, SecureRandom random)
    {
        this(version, -1, random);
    }

    /**
     * Instantiates a new B crypt password encoder.
     *
     * @param strength the log rounds to use, between 4 and 31
     * @param random   the secure random instance to use
     */
    public BCryptPasswordEncoder(int strength, SecureRandom random)
    {
        this(BCryptVersion.$2A, strength, random);
    }

    /**
     * Instantiates a new B crypt password encoder.
     *
     * @param version  the version of bcrypt, can be 2a,2b,2y
     * @param strength the log rounds to use, between 4 and 31
     */
    public BCryptPasswordEncoder(BCryptVersion version, int strength)
    {
        this(version, strength, null);
    }

    /**
     * Instantiates a new B crypt password encoder.
     *
     * @param version  the version of bcrypt, can be 2a,2b,2y
     * @param strength the log rounds to use, between 4 and 31
     * @param random   the secure random instance to use
     */
    public BCryptPasswordEncoder(BCryptVersion version, int strength, SecureRandom random)
    {
        if (strength != -1 && (strength < BCrypt.MIN_LOG_ROUNDS || strength > BCrypt.MAX_LOG_ROUNDS))
        {
            throw new IllegalArgumentException("Bad strength");
        }
        this.version = version;
        this.strength = (strength == -1) ? 10 : strength;
        this.random = random;
    }


    /**
     * Encode string.
     *
     * @param rawPassword the raw password
     * @return the string
     */
    public String encode(CharSequence rawPassword)
    {
        if (rawPassword == null)
        {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        String salt = getSalt();
        return BCrypt.hashpw(rawPassword.toString(), salt);
    }

    private String getSalt()
    {
        if (this.random != null)
        {
            return BCrypt.gensalt(this.version.getVersion(), this.strength, this.random);
        }
        return BCrypt.gensalt(this.version.getVersion(), this.strength);
    }


    /**
     * Matches boolean.
     *
     * @param rawPassword     the raw password
     * @param encodedPassword the encoded password
     * @return the boolean
     */
    public boolean matches(CharSequence rawPassword, String encodedPassword)
    {
        if (rawPassword == null)
        {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        if (encodedPassword == null || encodedPassword.length() == 0)
        {
            this.logger.warn("Empty encoded password");
            return false;
        }
        if (!this.BCRYPT_PATTERN.matcher(encodedPassword).matches())
        {
            this.logger.warn("Encoded password does not look like BCrypt");
            return false;
        }
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }


    /**
     * Upgrade encoding boolean.
     *
     * @param encodedPassword the encoded password
     * @return the boolean
     */
    public boolean upgradeEncoding(String encodedPassword)
    {
        if (encodedPassword == null || encodedPassword.length() == 0)
        {
            this.logger.warn("Empty encoded password");
            return false;
        }
        Matcher matcher = this.BCRYPT_PATTERN.matcher(encodedPassword);
        if (!matcher.matches())
        {
            throw new IllegalArgumentException("Encoded password does not look like BCrypt: " + encodedPassword);
        }
        int strength = Integer.parseInt(matcher.group(2));
        return strength < this.strength;
    }

    /**
     * Stores the default bcrypt version for use in configuration.
     *
     * @author Lin Feng
     */
    public enum BCryptVersion
    {

        /**
         * 2 a b crypt version.
         */
        $2A("$2a"),

        /**
         * 2 y b crypt version.
         */
        $2Y("$2y"),

        /**
         * 2 b b crypt version.
         */
        $2B("$2b");

        private final String version;

        BCryptVersion(String version)
        {
            this.version = version;
        }

        /**
         * Gets version.
         *
         * @return the version
         */
        public String getVersion()
        {
            return this.version;
        }

    }

}



