package leetcode;

import stack.Stack;
import tree.TreeNode;

/**
 * @Author: zl
 * @Date: 2019/7/3 23:11
 */
public class Pro572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (s != null || !stack.isEmpty()) {
            if (s != null) {
                stack.push(s.right);
                if (s.val == t.val && equals(s, t)) {
                    return true;
                }
                s = s.left;
            } else {
                s = stack.pop();
            }
        }
        return false;
    }
    //judge equals
    private boolean equals(TreeNode s, TreeNode t) {
        if (t == null ) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        //前序遍历
        while (s != null || !stack.isEmpty()) {
            if (s != null) {
                stack.push(s.right);
                if (t == null || s.val != t.val) {
                    return false;
                }
                stack1.push(t.right);
                s = s.left;
                t = t.left;
            } else {
                s = stack.pop();
                if (t != null) {
                    return false;
                }
                t = stack1.pop();
            }
        }
        return t == null;
    }
}
