package leetcode;

import tree.TreeNode;

/**
 * @Author: zl
 * @Date: 2019/7/6 10:25
 */
public class Pro111 {
    //重点在于{1，2}的测试用例，深度的概念是根节点到叶子节点的路径
    //所以返回的当前深度：
    //1）左右子树为空的即叶子节点返回1
    //2）左右节点一个为空，返回不为空节点的深度
    //3）左右节点都不为空，对比得到最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }
}
