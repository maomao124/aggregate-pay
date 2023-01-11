package mao.aggregate_pay_common.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): QiniuUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 21:15
 * Version(版本): 1.0
 * Description(描述)： 七牛云工具类
 */

public class QiniuUtils
{
    private static final Logger log = LoggerFactory.getLogger(QiniuUtils.class);

    /**
     * 文件上传的工具方法
     *
     * @param fileName  外部传进来，七牛云上的文件名称和此保持一致
     * @param accessKey 访问密钥
     * @param secretKey 秘密密钥
     * @param bucket    桶
     * @param bytes     字节
     * @throws RuntimeException 运行时异常
     */
    public static void upload2qiniu(String accessKey, String secretKey, String bucket, byte[] bytes, String fileName)
            throws RuntimeException
    {

        //构造一个带指定 Region 对象的配置类，指定存储区域，和存储空间选择的区域一致
        Configuration cfg = new Configuration(Region.huanan());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;
        try
        {

            //认证
            Auth auth = Auth.create(accessKey, secretKey);
            //认证通过后得到token（令牌）
            String upToken = auth.uploadToken(bucket);
            try
            {
                //上传文件,参数：字节数组，key，token令牌
                //key: 建议我们自已生成一个不重复的名称
                Response response = uploadManager.put(bytes, key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                //System.out.println(putRet.key);
                //System.out.println(putRet.hash);
                log.info("上传文件到七牛云：" + putRet.key);
            }
            catch (QiniuException ex)
            {
                Response r = ex.response;
                System.err.println(r.toString());
                log.error("上传文件到七牛：{}", ex.getMessage());
                try
                {
                    log.error(r.bodyString());
                }
                catch (QiniuException ex2)
                {
                    //ignore
                }
                throw new RuntimeException(r.bodyString());
            }
        }
        catch (Exception ex)
        {
            log.error("上传文件到七牛：{}", ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
    }
}
