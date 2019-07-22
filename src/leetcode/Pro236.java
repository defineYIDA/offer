package leetcode;

import stack.Stack;
import tree.TreeNode;

/**
 * @Author: zl
 * @Date: 2019/7/22 16:01
 */
public class Pro236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        root.left = node1;
        TreeNode node2 = new TreeNode(1);
        root.right = node2;
        TreeNode node4 = new TreeNode(6);
        node1.left = node4;
        TreeNode node5 = new TreeNode(2);
        node1.right = node5;
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node5.left = node8;
        node5.right = node9;
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        node2.left = node6;
        node2.right = node7;
        Pro236 p = new Pro236();
        Stack<TreeNode> stack = new Stack<>();
        p.searchNode(root, stack, node9);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val);
        }
        //System.out.println(p.lowestCommonAncestor(root, node8, node7).val);
    }
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        getPathToTarget(root, p.val, stack1);
        getPathToTarget(root, q.val, stack2);
        if (stack1.size() > stack2.size()) {
            int dif = stack1.size() - stack2.size();
            while (dif > 0) {
                stack1.pop();
                dif--;
            }
        }
        if (stack1.size() < stack2.size()) {
            int dif = stack2.size() - stack1.size();
            while (dif > 0) {
                stack2.pop();
                dif--;
            }
        }
        while (!stack1.isEmpty()) {
            Integer node = stack1.pop();
           *//* if (node.val == stack2.pop().val) {
                return node;
            }*//*
        }
        return null;
    }*/
    //工具类算法：求某个值对应的路径，对比 【二叉树的路径和等于某一个值的路经】
    //使用迭代会很麻烦需要保存一个路径的栈和遍历的stack同步压入和弹出
    //所以这种类型的题还是优先使用递归比较清晰。
    //
    private void getPathToTarget(TreeNode root, int val, Stack<Integer> stack) {
        if (root == null) {
            return ;
        }
        stack.push(root.val);
        if (root.val == val) {
            return;
        }
        getPathToTarget(root.left, val, stack);
        getPathToTarget(root.right, val, stack);
        stack.pop();
        return;
    }
    public  boolean searchNode(TreeNode root,Stack<TreeNode> s,TreeNode node) {
        if(root == null) return false;
        s.push(root);
        if(root.val == node.val) return true;
        boolean b = false;
        //先去左子树找
        if(root.left != null) b = searchNode(root.left,s,node);
        //左子树找不到并且右子树不为空的情况下才去找
        if(!b && root.right != null) b = searchNode(root.right,s,node);
        //左右都找不到，弹出栈顶元素
        if(!b) s.pop();
        return b;
    }
}
