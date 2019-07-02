package subject;

import util.TreeLinkNode;

/**
 * @Author: zl
 * @Date: 2019/7/2 17:50
 */
public class Pro8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode next = null;
        //如果不存在右子树，则向上寻找
        //这里分为两种情况：1）该节点为父节点的左节点即下一节点为父节点
        //               2）该节点为父节点的右节点，则一直向上寻找到第一个是它父节点的右节点的节点
        if (pNode.right == null && isLeft(pNode)) {
            next = pNode.next;
        } else if (pNode.right == null && !isLeft(pNode)) {
            next = parentLeftNode(pNode.next);
        }else {
            //如果存在右子树则下一个节点肯定在右节点中
            next = findFirst(pNode.right);
        }
        return next;
    }
    //寻找前序遍历第一个节点
    private TreeLinkNode findFirst(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode left = root.left;
            if (left == null) {
                return root;
            }
            root = left;
        }
        return null;
    }
    private boolean isLeft(TreeLinkNode node) {
        if (node == null) {
            return false;
        }
        TreeLinkNode parent = node.next;
        return parent == null ? false : parent.left == node;
    }
    //向上寻找第一个为第一个是它父节点的右节点的节点
    private TreeLinkNode parentLeftNode(TreeLinkNode node) {
        while (node != null) {
            if (isLeft(node))
                return node.next;
            node = node.next;
        }
        return null;
    }
}
