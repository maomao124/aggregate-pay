package mao.tools_core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.model
 * Interface(接口名): ITreeNode
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 22:00
 * Version(版本): 1.0
 * Description(描述)： 树接口
 */

public interface ITreeNode<T, I extends Serializable>
{
    /**
     * 添加
     *
     * @param node
     */
//    void add(T node);

    /**
     * 获取id
     *
     * @return
     */
    I getId();

    /**
     * 获取父id
     *
     * @return
     */
    I getParentId();

    /**
     * 获取子类
     *
     * @return
     */
    List<T> getChildren();

    /**
     * 设置子类
     *
     * @param children
     */
    void setChildren(List<T> children);

    /**
     * 初始化子类
     */
    default void initChildren()
    {
        if (getChildren() == null)
        {
            this.setChildren(new ArrayList<>());
        }
    }
}
