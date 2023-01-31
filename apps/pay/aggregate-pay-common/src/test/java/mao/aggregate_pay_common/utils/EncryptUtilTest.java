package mao.aggregate_pay_common.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;

import com.alibaba.fastjson.JSON;
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

    @Test
    void test3()
    {
        String s = "W3siaWQiOjEyNzIsInByZSI6bnVsbCwidGl0bGUiOiLoja/niankvZznlKjnmoTln7rmnKzooajnjrDmmK/mmK/mnLrkvZPlmaj" +
                "lrpjnu4Tnu4fvvJoiLCJhIjoiQS7lip/og73ljYfpq5jmiJblhbTlpYsiLCJiIjoiQi7lip/og73pmY3kvY7miJbmipHliLYiLCJj" +
                "IjoiQy7lhbTlpYvlkowv5oiW5oqR5Yi2IiwiZCI6IkQu5Lqn55Sf5paw55qE5Yqf6IO9IiwiZSI6IkUuQeWSjEQiLCJhbnN3ZXIiO" +
                "iJDIiwibm90ZSI6IiIsInF0eXBlIjoxfSx7ImlkIjoxMjczLCJwcmUiOm51bGwsInRpdGxlIjoi6I2v54mp55qE5Ymv5Y+N5bqU5p" +
                "iv5LiO5rK755aX5pWI5bqU5ZCM5pe25Y+R55Sf55qE5LiN6Imv5Y+N5bqU77yM5q2k5pe255qE6I2v54mp5YmC6YeP5piv77yaIiw" +
                "iYSI6IkEu5aSn5LqO5rK755aX6YePIiwiYiI6IkIu5bCP5LqO5rK755aX6YePIiwiYyI6IkMu5rK755aX5YmC6YePIiwiZCI6IkQu" +
                "5p6B6YePIiwiZSI6IkUu5Lul5LiK6YO95LiN5a+5IiwiYW5zd2VyIjoiQyIsIm5vdGUiOiIiLCJxdHlwZSI6MX0seyJpZCI6MTI3N" +
                "CwicHJlIjpudWxsLCJ0aXRsZSI6IuWNiuaVsOacieaViOmHj+aYr+aMh++8miIsImEiOiJBLuS4tOW6iuacieaViOmHjyIsImIiO" +
                "iJCLkxENTAiLCJjIjoiQy7lvJXotbc1MCXpmLPmgKflj43lupTnmoTliYLph48iLCJkIjoiRC7mlYjlupTlvLrluqYiLCJlIjoiR" +
                "S4g5Lul5LiK6YO95LiN5pivIiwiYW5zd2VyIjoiQyIsIm5vdGUiOiIiLCJxdHlwZSI6MX0seyJpZCI6MTI3NSwicHJlIjpudWxsL" +
                "CJ0aXRsZSI6IuiNr+eJqeWNiuaVsOiHtOatu+mHj++8iExENTDvvInmmK/mjIfvvJoiLCJhIjoiQS7oh7Tmrbvph4/nmoTkuIDlj" +
                "YoiLCJiIjoiQi7kuK3mr5Lph4/nmoTkuIDljYoiLCJjIjoiQy7mnYDmrbvljYrmlbDnl4Xljp/lvq7nlJ/niannmoTliYLph48iL" +
                "CJkIjoiRC7mnYDmrbvljYrmlbDlr4TnlJ/omavnmoTliYLph48iLCJlIjoiRS7lvJXotbfljYrmlbDliqjnianmrbvkuqHnmoTli" +
                "YLph48iLCJhbnN3ZXIiOiJFIiwibm90ZSI6IiIsInF0eXBlIjoxfSx7ImlkIjoxMjc2LCJwcmUiOm51bGwsInRpdGxlIjoi6I2v54" +
                "mp55qE5p6B6YeP5piv5oyH77yaIiwiYSI6IkEu5LiA5qyh6YePIiwiYiI6IkIu5LiA5pel6YePIiwiYyI6IkMu55aX56iL5oC76Y" +
                "ePIiwiZCI6IkQu5Y2V5L2N5pe26Ze05YaF5rOo5YWl6YePIiwiZSI6IkUuIOS7peS4iumDveS4jeWvuSIsImFuc3dlciI6IkUiLCJ" +
                "ub3RlIjoi5p6B6YeP77ya5byV6LW35pyA5aSn5pWI5bqU6ICM5LiN5Y+R55Sf5Lit5q+S55qE5YmC6YeP44CCIiwicXR5cGUiOjF" +
                "9LHsiaWQiOjEyNzcsInByZSI6bnVsbCwidGl0bGUiOiLoja/niannmoTmsrvnlpfmjIfmlbDmmK/vvJoiLCJhIjoiQS5FRDUwL0x" +
                "ENTAiLCJiIjoiQi5MRDUwL0VENTAiLCJjIjoiQy5MRDUvRUQ5NSIsImQiOiJELkVEOTkvTEQxIiwiZSI6IkUuRUQ5NS9MRDUiLCJ" +
                "hbnN3ZXIiOiJCIiwibm90ZSI6Iuayu+eWl+aMh+aVsO+8muiNr+eJqeeahOWNiuaVsOiHtOatu+mHj++8iExENTDvvInlkozljYr" +
                "mlbDmnInmlYjph4/vvIhFRDUw77yJ55qE5q+U5YC877yM5pei6I2v54mp5rK755aX5oyH5pWw5piv5oyH6I2v54mp55qE5pyA5L2" +
                "O5Lit5q+S5rWT5bqm5LiO5pyA5L2O5pyJ5pWI5rWT5bqm5LmL5q+U5YC877yM5Luj6KGo6I2v54mp55qE5a6J5YWo5oCn77yM5q2k" +
                "5pWw5YC86LaK5aSn6LaK5a6J5YWo44CCIiwicXR5cGUiOjF9LHsiaWQiOjEyNzgsInByZSI6bnVsbCwidGl0bGUiOiLoja/niank" +
                "uI7lj5fkvZPnu5PlkIjlkI7vvIzlj6/mv4Dliqjlj5fkvZPvvIzkuZ/lj6/pmLvmlq3lj5fkvZPvvIzlj5blhrPkuo7vvJoiLCJh" +
                "IjoiQS7oja/nianmmK/lkKblhbfmnInkurLlkozlipsiLCJiIjoiQi7oja/nianmmK/lkKblhbfmnInlhoXlnKjmtLvmgKciLCJj" +
                "IjoiQy7oja/niannmoTphbjnorHluqYiLCJkIjoiRC7oja/niannmoTohILmurbmgKciLCJlIjoiRS7oja/niannmoTmnoHmgKfl" +
                "pKflsI8iLCJhbnN3ZXIiOiJCIiwibm90ZSI6IiIsInF0eXBlIjoxfSx7ImlkIjoxMjc5LCJwcmUiOm51bGwsInRpdGxlIjoi56ue" +
                "5LqJ5oCn5ouu5oqX5YmC55qE54m554K55piv77yaIiwiYSI6IkEu5peg5Lqy5ZKM5Yqb77yM5peg5YaF5Zyo5rS75oCnIiwiYiI6" +
                "IkIu5pyJ5Lqy5ZKM5Yqb77yM5peg5YaF5Zyo5rS75oCnIiwiYyI6IkMu5pyJ5Lqy5ZKM5Yqb77yM5pyJ5YaF5Zyo5rS75oCnIiwi" +
                "ZCI6IkQu5peg5Lqy5ZKM5Yqb77yM5pyJ5YaF5Zyo5rS75oCnIiwiZSI6IkUu5Lul5LiK5Z2H5LiN5pivIiwiYW5zd2VyIjoiQiIs" +
                "Im5vdGUiOiIiLCJxdHlwZSI6MX0seyJpZCI6MTI4MCwicHJlIjpudWxsLCJ0aXRsZSI6IuiNr+eJqeS9nOeUqOeahOWPjOmHjeaA" +
                "p+aYr+aMh++8miIsImEiOiJBLuayu+eWl+S9nOeUqOWSjOWJr+S9nOeUqCIsImIiOiJCLuWvueWboOayu+eWl+WSjOWvueeXh+ay" +
                "u+eWlyIsImMiOiJDLuayu+eWl+S9nOeUqOWSjOavkuaAp+S9nOeUqCIsImQiOiJELuayu+eWl+S9nOeUqOWSjOS4jeiJr+WPjeW6" +
                "lCIsImUiOiJFLuWxgOmDqOS9nOeUqOWSjOWQuOaUtuS9nOeUqCIsImFuc3dlciI6IkQiLCJub3RlIjoi6I2v54mp55qE5L2c55So" +
                "5YW35pyJ5Y+M6YeN5oCnOjEu5rK755aX5L2c55So77ya5LiO55So6I2v55uu55qE55u456ym44CB5pyJ5Yip5LqO5oKj55eF5py6" +
                "5L2T55qE5L2c55SoOzIu5LiN6Imv5Y+N5bqU77ya5LiN56ym5ZCI55So6I2v55uu55qE5bm257uZ5oKj6ICF5bim5p2l5LiN6YCC" +
                "5oiW55eb6Ium55qE5Y+N5bqU57uf56ew5Li65LiN6Imv5Y+N5bqU44CCIiwicXR5cGUiOjF9LHsiaWQiOjEyODEsInByZSI6bnVs" +
                "bCwidGl0bGUiOiLlsZ7kuo7lkI7pgZfmlYjlupTnmoTmmK/vvJoiLCJhIjoiQS7pnZLpnInntKDov4fmlY/mgKfkvJHlhYsiLCJi" +
                "IjoiQi7lnLDpq5jovpvlvJXotbfnmoTlv4PlvovmgKflpLHluLgiLCJjIjoiQy7lkYvloZ7nsbPmiYDoh7TnmoTlv4PlvovlpLHl" +
                "uLgiLCJkIjoiRC7kv53ms7Dmnb7miYDoh7TnmoTogp3ogr7mjZ/lrrMiLCJlIjoiRS7lt7Tmr5TlpqXnsbvoja/lgqznnKDlkI7m" +
                "iYDoh7TnmoTmrKHmmajlrr/phonnjrDosaEiLCJhbnN3ZXIiOiJFIiwibm90ZSI6IiIsInF0eXBlIjoxfSx7ImlkIjoxMjgyLCJw" +
                "cmUiOm51bGwsInRpdGxlIjoi6YeP5pWI5puy57q/5Y+v5Lul5Li655So6I2v5o+Q5L6b5LiL5YiX5ZOq56eN5Y+C6ICD77yfIiwi" +
                "YSI6IkEu6I2v54mp55qE5a6J5YWo6IyD5Zu0IiwiYiI6IkIu6I2v54mp55qE55aX5pWI5aSn5bCPIiwiYyI6IkMu6I2v54mp55qE" +
                "5q+S5oCn5oCn6LSoIiwiZCI6IkQu6I2v54mp55qE5L2T5YaF6L+H56iLIiwiZSI6IkUu6I2v54mp55qE57uZ6I2v5pa55qGIIiwi" +
                "YW5zd2VyIjoiRSIsIm5vdGUiOiIiLCJxdHlwZSI6MX0seyJpZCI6MTI4MywicHJlIjpudWxsLCJ0aXRsZSI6IuiNr+eJqeeahOWG" +
                "heWcqOa0u+aAp++8iOaViOW6lOWKm++8ieaYr+aMh++8miIsImEiOiJBLuiNr+eJqeepv+mAj+eUn+eJqeiGnOeahOiDveWKmyIs" +
                "ImIiOiJCLuiNr+eJqeWvueWPl+S9k+eahOS6suWQiOiDveWKmyIsImMiOiJDLuiNr+eJqeawtOa6tuaAp+Wkp+WwjyIsImQiOiJE" +
                "LuWPl+S9k+a/gOWKqOaXtueahOWPjeW6lOW8uuW6piIsImUiOiJFLuiNr+eJqeiEgua6tuaAp+Wkp+WwjyIsImFuc3dlciI6IkQi" +
                "LCJub3RlIjoiIiwicXR5cGUiOjF9LHsiaWQiOjEyODQsInByZSI6IiIsInRpdGxlIjoi5a6J5YWo6IyD5Zu05piv5oyH77yaIiwi" +
                "YSI6IkEu5pyJ5pWI5YmC6YeP55qE6IyD5Zu0IiwiYiI6IkIu5pyA5bCP5Lit5q+S6YeP5LiO5rK755aX6YeP6Ze055qE6Led56a7" +
                "IiwiYyI6IkMu5pyA5bCP5rK755aX6YeP6Iez5pyA5bCP6Ie05q276YeP6Ze055qE6Led56a7IiwiZCI6IkQuRUQ5NeS4jkxENemX" +
                "tOeahOi3neemuyIsImUiOiJFLuacgOWwj+ayu+eWl+mHj+S4juacgOWwj+S4reavkumHj+mXtOeahOi3neemuyIsImFuc3dlciI6" +
                "IkQiLCJub3RlIjoiIiwicXR5cGUiOjF9LHsiaWQiOjEyODUsInByZSI6bnVsbCwidGl0bGUiOiLlia/kvZznlKjmmK/lnKjkuIvo" +
                "v7Dlk6rnp43liYLph4/ml7bkuqfnlJ/nmoTkuI3oia/lj43lupTvvJ8iLCJhIjoiQS7kuK3mr5Lph48iLCJiIjoiQi7msrvnlpfp" +
                "h48iLCJjIjoiQy7ml6DmlYjph48iLCJkIjoiRC7mnoHph48iLCJlIjoiRS7oh7Tmrbvph48iLCJhbnN3ZXIiOiJCIiwibm90ZSI6" +
                "IiIsInF0eXBlIjoxfSx7ImlkIjoxMjg2LCJwcmUiOm51bGwsInRpdGxlIjoi5Y+v55So5LqO6KGo56S66I2v54mp5a6J5YWo5oCn" +
                "55qE5Y+C5pWw77yaIiwiYSI6IkEu6ZiI5YmC6YePIiwiYiI6IkIu5pWI6IO9IiwiYyI6IkMu5pWI5Lu35by65bqmIiwiZCI6IkQu" +
                "5rK755aX5oyH5pWwIiwiZSI6IkUuTEQ1MCIsImFuc3dlciI6IkQiLCJub3RlIjoiIiwicXR5cGUiOjF9LHsiaWQiOjEyODcsInBy" +
                "ZSI6bnVsbCwidGl0bGUiOiLoja/ljp/mgKfnlr7nl4XmmK/vvJoiLCJhIjoiQS7kuKXph43nmoTkuI3oia/lj43lupQiLCJiIjoi" +
                "Qi7lgZzoja/lj43lupQiLCJjIjoiQy7lj5jmgIHlj43lupQiLCJkIjoiRC7ovoPpmr7mgaLlpI3nmoTkuI3oia/lj43lupQiLCJl" +
                "IjoiRS7nibnlvILotKjlj43lupQiLCJhbnN3ZXIiOiJEIiwibm90ZSI6IiIsInF0eXBlIjoxfSx7ImlkIjoxMjg4LCJwcmUiOiIi" +
                "LCJ0aXRsZSI6IuiNr+eJqeeahOacgOWkp+aViOiDveWPjeaYoOiNr+eJqeeahO+8miIsImEiOiJBLuWGheWcqOa0u+aApyIsImIiOiJ" +
                "CLuaViOW6lOW8uuW6piIsImMiOiJDLuS6suWSjOWKmyIsImQiOiJELumHj+aViOWFs+ezuyIsImUiOiJFLuaXtuaViOWFs+ezuyIsIm" +
                "Fuc3dlciI6IkEiLCJub3RlIjoiIiwicXR5cGUiOjF9LHsiaWQiOjEyODksInByZSI6bnVsbCwidGl0bGUiOiLogr7kuIrohbrntKD" +
                "lj5fkvZPlsZ7kuo7vvJoiLCJhIjoiQS5H6JuL55m95YG26IGU5Y+X5L2TIiwiYiI6IkIu5ZCr56a75a2Q6YCa6YGT55qE5Y+X5L2T" +
                "IiwiYyI6IkMu5YW35pyJ6YWq5rCo6YW45r+A6YW25rS75oCn55qE5Y+X5L2TIiwiZCI6IkQu57uG6IOe5YaF5Y+X5L2TIiwiZSI6I" +
                "kUu5Lul5LiK5Z2H5LiN5pivIiwiYW5zd2VyIjoiQSIsIm5vdGUiOiIiLCJxdHlwZSI6MX0seyJpZCI6MTI5MCwicHJlIjpudWxsLC" +
                "J0aXRsZSI6IuaLruaKl+WPguaVsHBBMueahOWumuS5ieaYr++8miIsImEiOiJBLuS9v+a/gOWKqOWJgueahOaViOW6lOWinuWKoDH" +
                "lgI3ml7bnq57kuonmgKfmi67mipfliYLmtZPluqbnmoTotJ/lr7nmlbAiLCJiIjoiQi7kvb/mv4DliqjliYLnmoTliYLph4/lop7l" +
                "iqAx5YCN5pe256ue5LqJ5oCn5ouu5oqX5YmC5rWT5bqm55qE6LSf5a+55pWwIiwiYyI6IkMu5L2/5r+A5Yqo5YmC55qE5pWI5bqU5" +
                "aKe5YqgMeWAjeaXtua/gOWKqOWJgua1k+W6pueahOi0n+WvueaVsCIsImQiOiJELuS9v+a/gOWKqOWJgueahOaViOW6lOS4jeWPmO" +
                "aXtuernuS6ieaAp+aLruaKl+WJgua1k+W6pueahOi0n+WvueaVsCIsImUiOiJFLuS9v+a/gOWKqOWJgueahOaViOW6lOWinuWKoDH" +
                "lgI3ml7bpnZ7nq57kuonmgKfmi67mipfliYLmtZPluqbnmoTotJ/lr7nmlbAiLCJhbnN3ZXIiOiJCIiwibm90ZSI6IiIsInF0eXBl" +
                "IjoxfSx7ImlkIjoxMjkxLCJwcmUiOm51bGwsInRpdGxlIjoi6I2v55CG5pWI5bqU5piv77yaIiwiYSI6IkEu6I2v54mp55qE5Yid5" +
                "aeL5L2c55SoIiwiYiI6IkIu6I2v54mp5L2c55So55qE57uT5p6cIiwiYyI6IkMu6I2v54mp55qE54m55byC5oCnIiwiZCI6IkQu6I" +
                "2v54mp55qE6YCJ5oup5oCnIiwiZSI6IkUu6I2v54mp55qE5Li05bqK55aX5pWIIiwiYW5zd2VyIjoiQiIsIm5vdGUiOiIiLCJxdHl" +
                "wZSI6MX0seyJpZCI6MTI5MiwicHJlIjpudWxsLCJ0aXRsZSI6IuWCqOWkh+WPl+S9k+aYr++8miIsImEiOiJBLuiNr+eJqeacque7" +
                "k+WQiOeahOWPl+S9kyIsImIiOiJCLuiNr+eJqeS4jee7k+WQiOeahOWPl+S9kyIsImMiOiJDLuS4juiNr+eJqee7k+WQiOi/h+eah" +
                "OWPl+S9kyIsImQiOiJELuiNr+eJqemavue7k+WQiOeahOWPl+S9kyIsImUiOiJFLuS4juiNr+eJqeino+emu+S6hueahOWPl+S9ky" +
                "IsImFuc3dlciI6IkEiLCJub3RlIjoiIiwicXR5cGUiOjF9LHsiaWQiOjEyOTMsInByZSI6bnVsbCwidGl0bGUiOiJwRDLmmK/vvJo" +
                "iLCJhIjoiQS7op6PnprvluLjmlbDnmoTotJ/lr7nmlbAiLCJiIjoiQi7mi67mipfluLjmlbDnmoTotJ/lr7nmlbAiLCJjIjoiQy7o" +
                "p6PnprvluLjmlbAiLCJkIjoiRC7mi67mipfluLjmlbAiLCJlIjoiRS7lubPooaHluLjmlbAiLCJhbnN3ZXIiOiJBIiwibm90ZSI6I" +
                "iIsInF0eXBlIjoxfSx7ImlkIjoxMjk0LCJwcmUiOiIiLCJ0aXRsZSI6IuWFs+S6juWPl+S9k+S6jOaAgeaooeWei+WtpuivtOeahO" +
                "WPmei/sO+8jOS4i+WIl+WTqumhueaYr+mUmeivr+eahO+8nyIsImEiOiJBLuaLruaKl+iNr+WvuVLlj4pSKueahOS6suWSjOWKm+S" +
                "4jeetiSIsImIiOiJCLuWPl+S9k+ibi+eZveacieWPr+S7peS6kuWPmOeahOaehOWei+eKtuaAgeOAguWNs+mdmeaBr+aAge+8iFLv" +
                "vInlkozmtLvliqjmgIHvvIhSKu+8iSIsImMiOiJDLumdmeaBr+aXtuW5s+ihoei2i+WKv+WQkeS6jlIiLCJkIjoiRC7mv4Dliqjoj" +
                "a/lj6rkuI5SKuaciei+g+Wkp+S6suWSjOWKmyIsImUiOiJFLumDqOWIhua/gOWKqOiNr+S4jlLlj4pSKumDveiDvee7k+WQiO+8jO" +
                "S9huWvuVIq55qE5Lqy5ZKM5Yqb5aSn5LqO5a+5UueahOS6suWSjOWKmyIsImFuc3dlciI6IkEiLCJub3RlIjoiIiwicXR5cGUiOjF" +
                "9LHsiaWQiOjEyOTUsInByZSI6bnVsbCwidGl0bGUiOiLotKjlj43lupTnmoTntK/liqDmm7Lnur/mmK/vvJoiLCJhIjoiQS7lr7nn" +
                "p7BT5Z6L5puy57q/IiwiYiI6IkIu6ZW/5bC+U+Wei+absue6vyIsImMiOiJDLuebtOe6vyIsImQiOiJELuWPjOabsue6vyIsImUiO" +
                "iJFLuato+aAgeWIhuW4g+absue6vyIsImFuc3dlciI6IkEiLCJub3RlIjoiIiwicXR5cGUiOjF9LHsiaWQiOjEyOTYsInByZSI6bn" +
                "VsbCwidGl0bGUiOiLku47kuIvliJdwRDLlgLzkuK3lj6/nn6XvvIzkuI7lj5fkvZPkurLlkozlipvmnIDlsI/nmoTmmK/vvJoiLCJ" +
                "hIjoiQS4xIiwiYiI6IkIuMiIsImMiOiJDLjQiLCJkIjoiRC41IiwiZSI6IkUuNiIsImFuc3dlciI6IkEiLCJub3RlIjoiIiwicXR5" +
                "cGUiOjF9LHsiaWQiOjEyOTcsInByZSI6bnVsbCwidGl0bGUiOiLku47kuIvliJdwQTLlgLzlj6/nn6Xmi67mipfkvZznlKjmnIDlv" +
                "LrnmoTmmK/vvJoiLCJhIjoiQS4wLjEiLCJiIjoiQi4wLjUiLCJjIjoiQy4xLjAiLCJkIjoiRC4xLjUiLCJlIjoiRS4xLjYiLCJhbn" +
                "N3ZXIiOiJFIiwibm90ZSI6IiIsInF0eXBlIjoxfSx7ImlkIjoxMjk4LCJwcmUiOm51bGwsInRpdGxlIjoi5p+Q6ZmN5Y6L6I2v5YG" +
                "c6I2v5ZCO6KGA5Y6L5Ymn54OI5Zue5Y2H77yM5q2k56eN546w6LGh56ew5Li677yaIiwiYSI6IkEu5Y+Y5oCB5Y+N5bqUIiwiYi" +
                "I6IkIu5YGc6I2v5Y+N5bqUIiwiYyI6IkMu5ZCO6YGX5pWI5bqUIiwiZCI6IkQu54m55byC6LSo5Y+N5bqUIiwiZSI6IkUu5q+S5o" +
                "Cn5Y+N5bqUIiwiYW5zd2VyIjoiQiIsIm5vdGUiOiIiLCJxdHlwZSI6MX0seyJpZCI6MTI5OSwicHJlIjpudWxsLCJ0aXRsZSI6I" +
                "uS4i+WIl+WFs+S6jua/gOWKqOiNr+eahOaPj+i/sO+8jOmUmeivr+eahOaYr++8miIsImEiOiJBLuacieWGheWcqOa0u+aApyIsI" +
                "mIiOiJCLuS4juWPl+S9k+acieS6suWSjOWKmyIsImMiOiJDLumHj+aViOabsue6v+WRiF" +
                "PlnosiLCJkIjoiRC5wQTLlgLzotorlpKfkvZznlKjotorlvLoiLCJlIjoiRS7kuI7lj5fkvZPov4XpgJ/op6PnprsiLCJhbnN3ZXI" +
                "iOiJEIiwibm90ZSI6IiIsInF0eXBlIjoxfSx7ImlkIjoxMzAwLCJwcmUiOm51bGwsInRpdGxlIjoi5Li" +
                "L5YiX5YWz5LqO5Y+X5L2T55qE5Y+Z6L+w77yM5q2j56Gu55qE5piv77yaIiwiYSI6IkEu5Y+X5L2T5piv6aaW5YWI5LiO6I2v54mp5" +
                "7uT5ZCI5bm26LW35Y+N5bqU55qE57uG6IOe5oiQ5YiGIiwiYiI6IkIu5Y+X5L2T6YO95piv57uG6IOe" +
                "6Iac5LiK55qE6JuL55m96LSoIiwiYyI6IkMu5Y+X5L2T5piv6YGX5Lyg5Z+65Zug55Sf5oiQ55qE77yM5YW25YiG5biD5a+G5bqm5p" +
                "iv5Zu65a6a5LiN5Y+Y55qEIiwiZCI6IkQu5Y+X5L2T5LiO6YWN5Z+65oiW5r+A5Yqo6I2v57uT5ZCI5ZCO6Y" +
                "O95byV6LW35YW05aWL5oCn5pWI5bqUIiwiZSI6IkUu6I2v54mp6YO95piv6YCa6L+H5r+A5Yqo5oiW5oqR5Yi255u45bqU5Y+X5L2" +
                "T6ICM5Y+R5oyl5L2c55So55qEIiwiYW5zd2VyIjoiQSIsIm5vdGUiOiIiLCJxdHlwZSI6MX0seyJpZCI6MTMwMSwicHJl" +
                "IjpudWxsLCJ0aXRsZSI6IuacieWFs+mHj+aViOWFs+ezu+eahOaPj+i/sO+8jOato+ehrueahOaYr++8miIsImEiOiJBLuWcqOS4g" +
                "OWumuiMg+WbtOWGhe+8jOiNr+eQhuaViOW6lOW8uuW6puS4juihgOa1huiNr+eJqea1k+W6puWRiOato+ebuOWFsyIsImIiOiJCLu" +
                "mHj+WPjeW6lOeahOmHj+aViOWFs+ezu+eahuWRiOW4uOaAgeWIhuW4g+absue6vyIsImMiOiJDLui0q" +
                "OWPjeW6lOeahOmHj+aViOWFs+ezu+eahuWRiOW4uOaAgeWIhuW4g+absue6vyIsImQiOiJELkxENTDkuI5FRDUw5Z2H5piv6YeP5Y+" +
                "N5bqU5Lit5Ye6546w55qE5YmC6YePIiwiZSI6IkUu6YeP5pWI5puy57q/5Y+v5Lul5Y+N5pig6I2v5" +
                "4mp5pWI6IO95ZKM5pWI5Lu35by65bqmIiwiYW5zd2VyIjoiQUUiLCJub3RlIjoiIiwicXR5cGUiOjJ9LHsiaWQiOjEzMDIsInByZSI" +
                "6bnVsbCwidGl0bGUiOiLotKjlj43lupTnmoTnibnngrnmnInvvJoiLCJhIjoiQS7popHmlbDliIbluIPmm7Lnur/kuLrmraPmgIHliI" +
                "bluIPmm7Lnur8iLCJiIjoiQi7ml6Dms5XorqHnrpflh7pFRDUwIiwiYyI6IkMu55So5YWo5oiW5peg44CB6Ziz5oCn5oiW6Zi05oCn" +
                "6KGo56S6IiwiZCI6IkQu5Y+v55So5q275Lqh5LiO55Sf5a2Y44CB5oOK5Y6l5LiO5LiN5oOK5Y6l6KGo56S6IiwiZSI6IkUu57Sv5Y" +
                "qg6YeP5pWI5puy57q/5Li6U+Wei+mHj+aViOabsue6vyIsImFuc3dlciI6IkFDREUiLCJub3RlIjoiIiwicXR5cGUiOjJ9LHsiaWQi" +
                "OjEzMDMsInByZSI6bnVsbCwidGl0bGUiOiLoja/niankvZznlKjljIXmi6zvvJoiLCJhIjoiQS7lvJXotbfmnLrkvZPlip/og73miJ" +
                "blvaLmgIHmlLnlj5giLCJiIjoiQi7lvJXotbfmnLrkvZPkvZPmtrLmiJDliIbmlLnlj5giLCJjIjoiQy7mipHliLbmiJbmnYDnga3lhaXkvrXnmoTnl4Xljp/lvq7nlJ/nianmiJblr4TnlJ" +
                "/omasiLCJkIjoiRC7mlLnlj5jmnLrkvZPnmoTlj43lupTmgKciLCJlIjoiRS7ooaXlhYXkvZPlhoXokKXlhbvnianotKjmiJbmv4Dn" +
                "tKDnmoTkuI3otrMiLCJhbnN3ZXIiOiJBQkNERSIsIm5vdGUiOiIiLCJ" +
                "xdHlwZSI6Mn0seyJpZCI6MTMwNCwicHJlIjpudWxsLCJ0aXRsZSI6IuiNr+eJqeS4juWPl+S9k+e7k+WQiOeahOeJueaAp+acie+8m" +
                "iIsImEiOiJBLumrmOW6pueJueW8guaApyIsImIiOiJCLumrmOW6puS6suWSjOWKmyIsImMiO" +
                "iJDLuWPr+mAhuaApyIsImQiOiJELumlseWSjOaApyIsImUiOiJFLumrmOW6puaViOW6lOWKmyIsImFuc3dlciI6IkFCQ0QiLCJub3R" +
                "lIjoiIiwicXR5cGUiOjJ9LHsiaWQiOjEzMDUsInByZSI6bnVsbCwidGl0bGUiOiLkuIvliJfmraPnoa7nmoTmj4/ov7DmmK/vvJoiL" +
                "CJhIjoiQS7oja/nianlj6/pgJrov4flj5fkvZPlj5HmjKXmlYjlupQiLCJiIjoiQi7oja/nianmv4Dliqjl" +
                "j5fkvZPljbPooajnjrDkuLrlhbTlpYvmlYjlupQiLCJjIjoiQy7lronmhbDliYLkuI3kvJrkuqfnlJ/msrvnlpfkvZznlKgiLCJkIj" +
                "oiRC7oja/nianljJblrabnu5PmnoTnm7jkvLzvvIzliJnkvZznlKjnm7jkvLwiLCJlIjoiRS7oja/mlYjkuI7ooqvljaDpoobnmo" +
                "Tlj5fkvZPmlbDnm67miJDmraPmr5QiLCJhbnN3ZXIiOiJBRSIsIm5vdGUiOiIiLCJxdHlwZ" +
                "SI6Mn0seyJpZCI6MTMwNiwicHJlIjpudWxsLCJ0aXRsZSI6IuS4i+WIl+acieWFs+S6su" +
                "WSjOWKm+eahOaPj+i/sO+8jOato+ehrueahOaYr++8miIsImEiOiJBLuS6suWSjOWKm+aYr+iNr+eJqeS4juWPl+S9k+e7k+WQiOea" +
                "hOiDveWKmyIsImIiOiJCLuS6suWSjOWKm+aYr+iNr+eJqeS4juWPl+S9k+e7k+WQiOWQjuW8lei1t+aViOW6lOeahOiDveWKmyIsIm" +
                "MiOiJDLuS6suWSjOWKm+i2iuWkp++8jOWImeiNr+eJqeaViOS7t+i2iuW8uiIsImQiOiJELuS6suWSjOWKm+i2iuWkp++8jOWImeiN" +
                "r+eJqeaViOiDvei2iuW8uiIsImUiOiJFLuS6suWSjOWKm+i2iuWkp++8jOWImeiNr+eJqeS9nOeUqOe7tOaMgeaXtumXtOi2iumVvy" +
                "IsImFuc3dlciI6IkFDIiwibm90ZSI6IiIsInF0eXBlIjoyfSx7ImlkIjoxMzA3LCJwcmUiOm51bGwsInRpdGxlIjoi6I2v5pWI5Yq" +
                "o5Yqb5a2m55qE5YaF5a655YyF5ous77yaIiwiYSI6IkE" +
                "u6I2v54mp55qE5L2c55So5LiO5Li05bqK55aX5pWIIiwiYiI6IkIu57uZ6I2v5pa55rOV5ZKM55So6YePIiwiYyI6IkMu6I2v54mp" +
                "55qE5YmC6YeP5LiO6YeP5pWI5YWz57O7IiwiZCI6IkQu6I2v54mp55qE5L2c55So5py65Yi2IiwiZSI6IkUu6I2v54mp55qE5LiN6" +
                "Imv5Y+N5bqU5ZKM56aB5b+M55eHIiwiYW5zd2VyIjoiQUNERSIsIm5vdGUiOiIiLCJxdHlwZSI6Mn0seyJpZCI6MTMwOCwicHJlIj" +
                "pudWxsLCJ0aXRsZSI6IuernuS6ieaAp+aLruaKl+WJgueahOeJueeCueacie+8miIsImEiOiJBLuacrOi6q+WPr+S6p+eUn+aViOW" +
                "6lCIsImIiOiJCLumZjeS9jua/gOWKqOWJgueahOaViOS7tyIsImMiOiJDLumZjeS9jua/gOWKqOWJgueahOaViOiDvSIsImQiOiJEL" +
                "uWPr+S9v+a/gOWKqOWJgueahOmHj+aViOabsue6v+W5s+ihjOWPs+enuyIsImUiOiJFLuWPr+S9v+a/g" +
                "OWKqOWJgueahOmHj+aViOabsue6v+W5s+ihjOW3puenuyIsImFuc3dlciI6IkJEIiwibm90ZSI6IiIsInF0eXBlIjoyfSx7ImlkIj" +
                "oxMzA5LCJwcmUiOm51bGwsInRpdGxlIjoi5Y+v5L2c5Li655So6I2v5a6J5YWo5oCn55qE5oyH5qCH5pyJ77yaIiwiYSI6IkEuVEQ" +
                "1MC9FRDUwIiwiYiI6IkIu5p6B6YePIiwiYyI6IkMuRUQ5NX5URDXkuYvpl7TnmoTot53nprsiLCJkIjoiRC5UQzUwL0VDNTAiLCJl" +
                "IjoiRS7luLjnlKjliYLph4/ojIPlm7QiLCJhbnN3ZXIiOiJBQ0QiLCJub3RlIjoiIiwicXR5cGUiOjJ9XQ==";

        String decoded = null;
        byte[] bytes = Base64.getDecoder().decode(s);

        try
        {
            decoded = new String(bytes, "utf-8");
            System.out.println(decoded);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
    }

}

