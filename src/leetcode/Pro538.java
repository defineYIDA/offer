package leetcode;

import tree.TreeNode;

import java.util.Stack;

/**
 * @Author: zl
 * @Date: 2019/9/15 9:51
 */
public class Pro538 {
    public TreeNode convertBST(TreeNode root) {
        //后序遍历
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, lastNode = null;
        int tol = 0;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.add(node);
                node = node.right;
            } else {
                node = stack.pop();
                tol += node.val;
                node.val = tol;
                node = node.left;
            }
        }
        return root;
    }
}
