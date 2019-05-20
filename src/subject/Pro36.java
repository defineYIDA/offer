package subject;

/**
 * @Author: zl
 * @Date: 2019/5/20 17:25
 */
public class Pro36 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode pLastNodeInLink = null;//双向链表的最后一个元素
        pLastNodeInLink = convertNode(pRootOfTree, pLastNodeInLink);

        TreeNode pHeadNodeInLink = pLastNodeInLink;//双向链表的最后一个元素
        while (pHeadNodeInLink != null && pHeadNodeInLink.left != null) {
            pHeadNodeInLink = pHeadNodeInLink.left;
        }
        return pHeadNodeInLink;
    }
    //先序遍历构建链表
    private TreeNode convertNode(TreeNode pRootOfTree, TreeNode pLastNodeInLink) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode pCurrent = pRootOfTree;
        if (pCurrent.left != null) {
            //传递最后一个处理的指针
            pLastNodeInLink = convertNode(pCurrent.left, pLastNodeInLink);
        }
        //连接链表
        pCurrent.left = pLastNodeInLink;//指向前
        if (pLastNodeInLink != null) {
            pLastNodeInLink.right = pCurrent;
        }
        pLastNodeInLink = pCurrent;

        if (pCurrent.right != null) {
            pLastNodeInLink = convertNode(pCurrent.right, pLastNodeInLink);
        }
        return pLastNodeInLink;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
