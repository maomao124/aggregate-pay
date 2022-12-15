package mao.tools_core.base.id;

import java.io.Serializable;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.base.id
 * Interface(接口名): IdGenerate
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 13:03
 * Version(版本): 1.0
 * Description(描述)： 主键（id）生成器，用于生成唯一id号
 * 1、注意：在写主键生成器时，请考虑主键不会重复。
 * 2、尤其需要考虑在短时间内大量调用生成器，也保证不要出现重复
 * 3、实现类必须是线程安全的，因为会应用在多线程环境中去
 */

@FunctionalInterface
public interface IdGenerate<T extends Serializable>
{
    /**
     * id 生成器
     *
     * @return {@link T}
     */
    T generate();
}
