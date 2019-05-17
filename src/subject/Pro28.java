package subject;

import tree.TreeNode;

/**
 * @Author: zl
 * @Date: 2019/5/17 11:25
 */
public class Pro28 {
    /**
     *对称二叉树
     *思路：1）使用对称遍历法：DRL
     *      2)如果 DRL == DLR ,就代表对称
     *      3）引入null值对特殊情况进行处理，例如只有一个子节点
     */
    public boolean isSymmetric(TreeNode root) {
        return isSym(root, root);
    }

    public boolean isSym(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null) {
            return true;
        } else if (root == null || root1 == null) {
            return false;
        }
        if (root.val != root1.val) {
            return false;
        }
        //思考isSym递归的含义，先判断D的相等情况，如果相等就判断左子树和右子树的根的相等情况
        return isSym(root.left, root1.right) && isSym(root.right, root1.left);
    }
}
