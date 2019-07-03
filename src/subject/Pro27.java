package subject;

import stack.Stack;
import tree.TreeNode;

/**
 * @Author: zl
 * @Date: 2019/5/17 11:02
 */
public class Pro27 {
    /**
     *镜像二叉树
     *思路：1）交换处理非叶子节点的子节点
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        //翻转
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归
        if (root.left != null) {
            root.left = invertTree(root.left);
        }
        if (root.right != null) {
            root.right = invertTree(root.right);
        }
        return root;//返回根节点
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode pNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                if (pNode.left != null || pNode.right != null) {
                    TreeNode temp = pNode.left;
                    pNode.left = pNode.right;
                    pNode.right = temp;
                }
                stack.push(pNode.right);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
            }
        }
        return root;
    }
}
