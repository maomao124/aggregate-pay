package mao.aggregate_pay_merchant_application.service;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.service
 * Interface(接口名): FileService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/11
 * Time(创建时间)： 20:13
 * Version(版本): 1.0
 * Description(描述)： 文件服务
 */

public interface FileService
{
    /**
     * 上传文件
     *
     * @param bytes    文件字节数组
     * @param fileName 文件名
     * @return 文件访问路径（绝对的url）
     */
    String upload(byte[] bytes, String fileName);
}
