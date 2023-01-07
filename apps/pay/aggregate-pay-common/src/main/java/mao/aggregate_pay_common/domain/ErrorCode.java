package mao.aggregate_pay_common.domain;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.domain
 * Interface(接口名): ErrorCode
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 14:42
 * Version(版本): 1.0
 * Description(描述)： 错误代码接口
 */

public interface ErrorCode
{
    /**
     * 获取错误代码值
     *
     * @return int
     */
    int getCode();

    /**
     * 得到描述信息
     *
     * @return {@link String}
     */
    String getDesc();
}
