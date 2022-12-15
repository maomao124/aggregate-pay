package mao.tools_core.utils;

import mao.tools_core.model.ITreeNode;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.utils
 * Class(类名): TreeUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 21:58
 * Version(版本): 1.0
 * Description(描述)： list列表 转换成tree列表
 */

public class TreeUtil
{

    /**
     * 复杂度O(N^2)<br/>
     * 建立多个根节点树
     * 保证构造后的树中，同一级的节点间的相互顺序与在传入数据中的相互顺序保持一致。
     *
     * @param treeNodes treeNodes
     * @return {@link List}<{@link T}>
     */
    public static <T extends ITreeNode<T, ? extends Serializable>> List<T> build(List<T> treeNodes)
    {
        if (CollectionUtils.isEmpty(treeNodes))
        {
            return treeNodes;
        }
        //记录自己是自己的父节点的id集合
        List<Serializable> selfIdEqSelfParent = new ArrayList<>();
        // 为每一个节点找到子节点集合
        for (T parent : treeNodes)
        {
            Serializable id = parent.getId();
            for (T children : treeNodes)
            {
                if (parent != children)
                {
                    //parent != children 这个来判断自己的孩子不允许是自己，因为有时候，根节点的parent会被设置成为自己
                    if (id.equals(children.getParentId()))
                    {
//                        if (parent.getChildren() == null) {
//                            parent.setChildren(new ArrayList<T>());
//                        }
                        parent.initChildren();
                        parent.getChildren().add(children);
                    }
                }
                else if (id.equals(parent.getParentId()))
                {

                    selfIdEqSelfParent.add(id);
                }
            }
        }
        // 找出根节点集合
        List<T> trees = new ArrayList<>();

        List<Serializable> allIds = new ArrayList<>();
        for (T baseNode : treeNodes)
        {
            allIds.add(baseNode.getId());
        }

//        List<? extends Serializable> allIds = treeNodes.stream().map(node -> node.getId()).collect(Collectors.toList());
        for (T baseNode : treeNodes)
        {
            if (!allIds.contains(baseNode.getParentId()) || selfIdEqSelfParent.contains(baseNode.getParentId()))
            {
                trees.add(baseNode);
            }
        }
        return trees;
    }
}
