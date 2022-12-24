package mao.sms_api.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class MD5UtilsTest
{

    /**
     * Method under test: {@link MD5Utils#getMD5(String)}
     */
    @Test
    void testGetMD5() throws UnsupportedEncodingException
    {
        assertEquals("0e9c20d9b237aecc65de77a491061be5", MD5Utils.getMD5("27c7cf400229103e00c6d8830029e29b"));
        assertNull(MD5Utils.getMD5((String) null));
        assertNull(MD5Utils.getMD5(""));
        assertEquals("aee9e38cb4d40ec2794542567539b4c8", MD5Utils.getMD5("AAAAAAAA".getBytes("UTF-8")));
        assertNull(MD5Utils.getMD5(new byte[]{}));
    }

    /**
     * Method under test: {@link MD5Utils#getMD5toUpperCase(String)}
     */
    @Test
    void testGetMD5toUpperCase() throws UnsupportedEncodingException
    {
        assertEquals("0E9C20D9B237AECC65DE77A491061BE5", MD5Utils.getMD5toUpperCase("27c7cf400229103e00c6d8830029e29b"));
        assertNull(MD5Utils.getMD5toUpperCase((String) null));
        assertEquals("AEE9E38CB4D40EC2794542567539B4C8", MD5Utils.getMD5toUpperCase("AAAAAAAA".getBytes("UTF-8")));
        assertNull(MD5Utils.getMD5toUpperCase((byte[]) null));
        assertNull(MD5Utils.getMD5toUpperCase(new byte[]{}));
    }

    /**
     * Method under test: {@link MD5Utils#getMD5toUpperCase(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetMD5toUpperCase2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.util.Objects.requireNonNull(Objects.java:203)
        //       at mao.sms_api.utils.MD5Utils.getMD5toUpperCase(MD5Utils.java:129)
        //   In order to prevent getMD5toUpperCase(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getMD5toUpperCase(String).
        //   See https://diff.blue/R013 to resolve this issue.

        MD5Utils.getMD5toUpperCase("");
    }

}

