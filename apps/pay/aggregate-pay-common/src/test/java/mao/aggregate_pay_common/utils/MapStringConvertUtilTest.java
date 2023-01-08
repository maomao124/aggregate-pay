package mao.aggregate_pay_common.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class MapStringConvertUtilTest
{
    /**
     * Method under test: {@link MapStringConvertUtil#getMapToString(java.util.Map)}
     */
    @Test
    void testGetMapToString()
    {
        assertEquals(StringUtil.EMPTY, MapStringConvertUtil.getMapToString(new HashMap<>()));
    }

    /**
     * Method under test: {@link MapStringConvertUtil#getMapToString(java.util.Map)}
     */
    @Test
    void testGetMapToString2()
    {
        HashMap<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("foo", "foo");
        assertEquals("foo:foo", MapStringConvertUtil.getMapToString(stringStringMap));
    }

    /**
     * Method under test: {@link MapStringConvertUtil#getMapToString(java.util.Map)}
     */
    @Test
    void testGetMapToString3()
    {
        HashMap<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put(":", ":");
        stringStringMap.put("foo", "foo");
        assertEquals(":::,foo:foo", MapStringConvertUtil.getMapToString(stringStringMap));
    }

    /**
     * Method under test: {@link MapStringConvertUtil#getMapToString(java.util.Map)}
     */
    @Test
    void testGetMapToString4()
    {
        HashMap<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("foo", StringUtil.EMPTY);
        assertEquals(StringUtil.EMPTY, MapStringConvertUtil.getMapToString(stringStringMap));
    }

    /**
     * Method under test: {@link MapStringConvertUtil#getStringToMap(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetStringToMap()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: 1
        //       at mao.aggregate_pay_common.utils.MapStringConvertUtil.getStringToMap(MapStringConvertUtil.java:84)
        //   In order to prevent getStringToMap(String)
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getStringToMap(String).
        //   See https://diff.blue/R013 to resolve this issue.

        MapStringConvertUtil.getStringToMap("Str");
    }

    /**
     * Method under test: {@link MapStringConvertUtil#getStringToMap(String)}
     */
    @Test
    void testGetStringToMap2()
    {
        assertNull(MapStringConvertUtil.getStringToMap(null));
    }

    /**
     * Method under test: {@link MapStringConvertUtil#getStringToMap(String)}
     */
    @Test
    void testGetStringToMap3()
    {
        assertNull(MapStringConvertUtil.getStringToMap((String) StringUtil.EMPTY));
    }

    /**
     * Method under test: {@link MapStringConvertUtil#getStringToMap(String)}
     */
    @Test
    void testGetStringToMap4()
    {
        assertTrue(MapStringConvertUtil.getStringToMap(StringUtil.COMMA).isEmpty());
    }

    /**
     * Method under test: {@link MapStringConvertUtil#getStringToMap(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetStringToMap5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: 0
        //       at mao.aggregate_pay_common.utils.MapStringConvertUtil.getStringToMap(MapStringConvertUtil.java:84)
        //   In order to prevent getStringToMap(String)
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getStringToMap(String).
        //   See https://diff.blue/R013 to resolve this issue.

        MapStringConvertUtil.getStringToMap(":");
    }

    /**
     * Method under test: {@link MapStringConvertUtil#getStringToMap(String)}
     */
    @Test
    void testGetStringToMap6()
    {
        Map<String, String> actualStringToMap = MapStringConvertUtil.getStringToMap(":Str");
        assertEquals(1, actualStringToMap.size());
        assertEquals("Str", actualStringToMap.get(StringUtil.EMPTY));
    }
}

