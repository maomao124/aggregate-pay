package mao.sms_api.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SmsEncryptionUtilsTest
{
    /**
     * Method under test: {@link SmsEncryptionUtils#encode(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEncode()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.StringIndexOutOfBoundsException: String index out of range: 36
        //       at java.lang.String.charAt(String.java:658)
        //       at mao.sms_api.utils.SmsEncryptionUtils.encode(SmsEncryptionUtils.java:34)
        //   In order to prevent encode(String, String, String)
        //   from throwing StringIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   encode(String, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        SmsEncryptionUtils.encode("Timestamp", "EXAMPLEakiAIOSFODNN7", "EXAMPLEakiAIOSFODNN7");
    }

    /**
     * Method under test: {@link SmsEncryptionUtils#encode(String, String, String)}
     */
    @Test
    void testEncode2()
    {
        assertEquals("58b3ce731530180950766ba5e89b332a",
                SmsEncryptionUtils.encode("42", "EXAMPLEakiAIOSFODNN7", "EXAMPLEakiAIOSFODNN7"));
    }

    /**
     * Method under test: {@link SmsEncryptionUtils#encode(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEncode3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.StringIndexOutOfBoundsException: String index out of range: 4
        //       at java.lang.String.charAt(String.java:658)
        //       at mao.sms_api.utils.SmsEncryptionUtils.encode(SmsEncryptionUtils.java:35)
        //   In order to prevent encode(String, String, String)
        //   from throwing StringIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   encode(String, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        SmsEncryptionUtils.encode("42", "EXAMPLEakiAIOSFODNN7", "MD5");
    }
}

