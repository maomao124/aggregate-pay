package mao.tools_core.exception;

/**
 * Project name(项目名称)：jwt_spring_boot_starter
 * Package(包名): mao.tools_jwt.exception
 * Interface(接口名): BaseExceptionCode
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/2
 * Time(创建时间)： 22:32
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface BaseExceptionCode
{
    /**
     * 异常编码
     *
     * @return int
     */
    int getCode();

    /**
     * 异常消息
     *
     * @return String
     */
    String getMsg();
}
