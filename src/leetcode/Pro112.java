package leetcode;

import tree.TreeNode;

/**
 * @Author: zl
 * @Date: 2019/7/4 16:05
 */
public class Pro112 {
    //思路：
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSumCore(root, sum, 0);
    }
    private boolean hasPathSumCore(TreeNode root, int sum, int tol) {
        if (root == null) {
            return false;
        }
        tol += root.val;
        if (sum == tol && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSumCore(root.right, sum, tol) || hasPathSumCore(root.left, sum, tol);
    }
}
