package leetcode;

import tree.TreeNode;

/**
 * @Author: zl
 * @Date: 2019/9/13 9:40
 */
public class Pro437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Sum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }
    private int count = 0;
    private void Sum(TreeNode root, int sum) {
        if (root == null) {
            return ;
        }
        sum -= root.val;
        if (sum == 0) {
            count++;
        }
        Sum(root.left, sum);
        Sum(root.right, sum);
    }
}
