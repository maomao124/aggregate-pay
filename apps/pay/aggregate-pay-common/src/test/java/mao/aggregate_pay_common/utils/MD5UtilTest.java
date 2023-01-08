package mao.aggregate_pay_common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MD5UtilTest
{
    /**
     * Method under test: {@link MD5Util#getMd5(String)}
     */
    @Test
    void testGetMd5()
    {
        assertEquals("0e9c20d9b237aecc65de77a491061be5", MD5Util.getMd5("27c7cf400229103e00c6d8830029e29b"));
    }
}

