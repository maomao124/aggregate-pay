package mao.tools_jwt.utils;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Project name(项目名称)：jwt_spring_boot_starter
 * Package(包名): mao.tools_jwt.utils
 * Class(类名): RsaKeyHelper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/2
 * Time(创建时间)： 22:19
 * Version(版本): 1.0
 * Description(描述)： Rsa key 帮助类
 */

public class RsaKeyHelper
{

    /**
     * 获取公钥,用于解析token
     *
     * @param filename 文件名
     * @return {@link PublicKey}
     * @throws IOException              ioexception
     * @throws NoSuchAlgorithmException 没有这样算法异常
     * @throws InvalidKeySpecException  无效关键规范异常
     */
    public PublicKey getPublicKey(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
    {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
        if (inputStream == null)
        {
            throw new IOException("获取公钥时获取失败，可能是公钥文件不存在。当前路径：" + filename);
        }
        try (DataInputStream dataInputStream = new DataInputStream(inputStream))
        {
            byte[] keyBytes = new byte[inputStream.available()];
            dataInputStream.readFully(keyBytes);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(x509EncodedKeySpec);
        }
    }


    /**
     * 获取私钥 用于生成token
     *
     * @param filename 文件名
     * @return {@link PrivateKey}
     * @throws IOException              ioexception
     * @throws NoSuchAlgorithmException 没有这样算法异常
     * @throws InvalidKeySpecException  无效关键规范异常
     */
    public PrivateKey getPrivateKey(String filename)
            throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
    {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
        if (inputStream == null)
        {
            throw new IOException("获取私钥时获取失败，可能是私钥文件不存在。当前路径：" + filename);
        }
        try (DataInputStream dataInputStream = new DataInputStream(inputStream))
        {
            byte[] keyBytes = new byte[inputStream.available()];
            dataInputStream.readFully(keyBytes);

            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        }
    }
}
