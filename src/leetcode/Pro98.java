package leetcode;

import stack.Stack;
import tree.TreeNode;

/**
 * @Author: zl
 * @Date: 2019/7/23 9:51
 */
public class Pro98 {
    //解法一：迭代
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        //List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root != null) {
                    if (prev != null && prev >= root.val) {
                        return false;
                    } else {
                        prev = root.val;
                    }
                }
                root = root.right;
            }
        }
        return true;
    }
    //解法二：递归
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return iss(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean iss(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return iss(node.left, min, node.val) && iss(node.right, node.val, max);
    }
}
