package subject;

import stack.Stack;

/**
 * @Author: zl
 * @Date: 2019/6/6 16:46
 */
public class Pro68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        while (root != null) {
            if (root.val == p.val || root.val == q.val) {
                return root;
            } else if(isExist(root.left, p, q)) {
                root = root.left;
            } else if (isExist(root.right, p, q)) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
    //判断子树中是否存在node节点
    private boolean isExist(TreeNode root, TreeNode node, TreeNode node1) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean e = false;
        boolean e1 = false;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur.right);
                if (cur.val == node.val) {
                    e = true;
                }
                if (cur.val == node1.val) {
                    e1 = true;
                }
                cur = cur.left;
            } else {
                cur = stack.pop();
            }
        }
        return e && e1;
    }
}
