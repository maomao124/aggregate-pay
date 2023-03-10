package mao.aggregate_pay_merchant_application.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SecurityUtilTest
{
    /**
     * Method under test: {@link SecurityUtil#getUser()}
     */
    @Test
    void testGetUser()
    {
        assertTrue(SecurityUtil.getUser().getPayload().isEmpty());
    }

    /**
     * Method under test: {@link SecurityUtil#getMerchantId()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetMerchantId()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantId(SecurityUtil.java:105)
        //   In order to prevent getMerchantId()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getMerchantId().
        //   See https://diff.blue/R013 to resolve this issue.

        SecurityUtil.getMerchantId();
    }

    /**
     * Method under test: {@link SecurityUtil#getMerchantIdThrowsException()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetMerchantIdThrowsException()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantIdThrowsException(SecurityUtil.java:124)
        //   In order to prevent getMerchantIdThrowsException()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getMerchantIdThrowsException().
        //   See https://diff.blue/R013 to resolve this issue.

        SecurityUtil.getMerchantIdThrowsException();
    }

    /**
     * Method under test: {@link SecurityUtil#getMerchant()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetMerchant()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchant(SecurityUtil.java:145)
        //   In order to prevent getMerchant()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getMerchant().
        //   See https://diff.blue/R013 to resolve this issue.

        SecurityUtil.getMerchant();
    }

    /**
     * Method under test: {@link SecurityUtil#getMerchantThrowsException()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetMerchantThrowsException()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantThrowsException(SecurityUtil.java:164)
        //   In order to prevent getMerchantThrowsException()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getMerchantThrowsException().
        //   See https://diff.blue/R013 to resolve this issue.

        SecurityUtil.getMerchantThrowsException();
    }

    /**
     * Method under test: {@link SecurityUtil#convertTokenToLoginUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConvertTokenToLoginUser()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: syntax error, pos 3, line 1, column 4 ??????
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1510)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1390)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:181)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:191)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:147)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:252)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.convertTokenToLoginUser(SecurityUtil.java:184)
        //   In order to prevent convertTokenToLoginUser(String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   convertTokenToLoginUser(String).
        //   See https://diff.blue/R013 to resolve this issue.

        SecurityUtil.convertTokenToLoginUser("ABC123");
    }

    /**
     * Method under test: {@link SecurityUtil#convertTokenToLoginUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConvertTokenToLoginUser2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: syntax error, pos 1, line 1, column 2~???
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1510)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1390)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:181)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:191)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:147)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:252)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.convertTokenToLoginUser(SecurityUtil.java:184)
        //   In order to prevent convertTokenToLoginUser(String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   convertTokenToLoginUser(String).
        //   See https://diff.blue/R013 to resolve this issue.

        SecurityUtil.convertTokenToLoginUser("foo");
    }

    /**
     * Method under test: {@link SecurityUtil#convertTokenToLoginUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConvertTokenToLoginUser3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Last unit does not have enough valid bits
        //       at java.util.Base64$Decoder.decode0(Base64.java:734)
        //       at java.util.Base64$Decoder.decode(Base64.java:526)
        //       at java.util.Base64$Decoder.decode(Base64.java:549)
        //       at mao.aggregate_pay_common.utils.EncryptUtil.decodeUTF8StringBase64(EncryptUtil.java:87)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.convertTokenToLoginUser(SecurityUtil.java:182)
        //   In order to prevent convertTokenToLoginUser(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   convertTokenToLoginUser(String).
        //   See https://diff.blue/R013 to resolve this issue.

        SecurityUtil.convertTokenToLoginUser("Token");
    }

    /**
     * Method under test: {@link SecurityUtil#convertTokenToLoginUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConvertTokenToLoginUser4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: syntax error, pos 1, line 1, column 2???
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1510)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1390)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:181)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:191)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:147)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:252)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.convertTokenToLoginUser(SecurityUtil.java:184)
        //   In order to prevent convertTokenToLoginUser(String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   convertTokenToLoginUser(String).
        //   See https://diff.blue/R013 to resolve this issue.

        SecurityUtil.convertTokenToLoginUser("42");
    }

    /**
     * Method under test: {@link SecurityUtil#convertTokenToLoginUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConvertTokenToLoginUser5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.convertTokenToLoginUser(SecurityUtil.java:185)
        //   In order to prevent convertTokenToLoginUser(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   convertTokenToLoginUser(String).
        //   See https://diff.blue/R013 to resolve this issue.

        SecurityUtil.convertTokenToLoginUser("");
    }

    /**
     * Method under test: {@link SecurityUtil#convertTokenToLoginUser(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConvertTokenToLoginUser6()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.alibaba.fastjson.JSONException: syntax error, pos 1, line 1, column 2N?????? B???m
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1507)
        //       at com.alibaba.fastjson.parser.DefaultJSONParser.parse(DefaultJSONParser.java:1390)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:181)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:191)
        //       at com.alibaba.fastjson.JSON.parse(JSON.java:147)
        //       at com.alibaba.fastjson.JSON.parseObject(JSON.java:252)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.convertTokenToLoginUser(SecurityUtil.java:184)
        //   In order to prevent convertTokenToLoginUser(String)
        //   from throwing JSONException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   convertTokenToLoginUser(String).
        //   See https://diff.blue/R013 to resolve this issue.

        SecurityUtil.convertTokenToLoginUser("TokenABC123");
    }
}

