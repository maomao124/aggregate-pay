package mao.aggregate_pay_common.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

class EncryptUtilTest
{
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link EncryptUtil#encodeBase64(byte[])}
     *   <li>{@link EncryptUtil#decodeBase64(String)}
     * </ul>
     */
    @Test
    void testEncodeBase64() throws UnsupportedEncodingException
    {
        byte[] bytes = "AAAAAAAA".getBytes("UTF-8");
        assertArrayEquals(bytes, EncryptUtil.decodeBase64(EncryptUtil.encodeBase64(bytes)));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link EncryptUtil#encodeUTF8StringBase64(String)}
     *   <li>{@link EncryptUtil#decodeUTF8StringBase64(String)}
     * </ul>
     */
    @Test
    void testEncodeUTF8StringBase64()
    {
        assertEquals("Str", EncryptUtil.decodeUTF8StringBase64(EncryptUtil.encodeUTF8StringBase64("Str")));
    }

    @Test
    void test1()
    {

        String PayOrderDTOJson = "{" +
                "\"subject\":\"测试\"," +
                "\"body\":\"测试商品\"" +
                "}";
        System.out.println(EncryptUtil.encodeUTF8StringBase64(PayOrderDTOJson));
    }

    @Test
    void test2()
    {
        String s = "JTdCJTIyc3ViamVjdCUyMiUzQSUyMiVFNiVCNSU4QiVFOCVBRiU5NSUyMiUyQyUyMmJvZHklMjIlM0ElMjIlRTYlQjUlOEIlRTglQUYlOTUlRTUlOTUlODYlRTUlOTMlODElMjIlN0Q=";
        System.out.println(EncryptUtil.decodeUTF8StringBase64(s));
    }
}

