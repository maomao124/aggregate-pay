package mao.auth_server.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.utils
 * Class(测试类名): BCryptPasswordEncoderTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 20:43
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


class BCryptPasswordEncoderTest
{

    /**
     * Encode 1.
     */
    @Test
    void encode1()
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }

    /**
     * Encode 2.
     */
    @Test
    void encode2()
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }

    /**
     * Encode 3.
     */
    @Test
    void encode3()
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }

    /**
     * Encode 4.
     */
    @Test
    void encode4()
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }

    /**
     * Encode 5.
     */
    @Test
    void encode5()
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456789");
        System.out.println(encode);
    }

    /**
     * Encode 6.
     */
    @Test
    void encode6()
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("abc123456");
        System.out.println(encode);
    }

    /**
     * Matches 1.
     */
    @Test
    void matches1()
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean b = bCryptPasswordEncoder.matches("12345",
                "$2a$10$CA2o1euRv0d1nI03Mve5zeVOW0LzBk2v7U6uLpgf6Q6zVFKgflSuq");
        System.out.println(b);
    }

    /**
     * Matches 2.
     */
    @Test
    void matches2()
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean b = bCryptPasswordEncoder.matches("123456",
                "$2a$10$CA2o1euRv0d1nI03Mve5zeVOW0LzBk2v7U6uLpgf6Q6zVFKgflSuq");
        System.out.println(b);
    }

    /**
     * Matches 3.
     */
    @Test
    void matches3()
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean b = bCryptPasswordEncoder.matches("123456",
                "$2a$10$Wdh6AAnlJ7HaQ/L4oIx7GO.heGidYhXh4.jELt/ZC/qbkJY5ZrTla");
        System.out.println(b);
    }

    /**
     * Matches 4.
     */
    @Test
    void matches4()
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean b = bCryptPasswordEncoder.matches("123456",
                "$2a$10$8XNdknAP1YTh.JqH7oBpI.g9hW7igF75LrZEaHUvkf9ABZmww1VNa");
        System.out.println(b);
    }

}