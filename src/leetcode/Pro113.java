package leetcode;

import stack.Stack;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/7/4 20:28
 */
public class Pro113 {
    public static void main(String[] var) {
        Pro113 p = new Pro113();
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        node.left = left;
        node.right = right;
        p.pathSum(node, 3);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> subList = new ArrayList<>();//path

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        list.add(null);
        list.add(null);
        int total = 0;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                total += root.val;
                subList.add(root.val);//记录路径
                if (total == sum && root.left == null && root.right == null) {
                    list.add(new ArrayList<>(subList));
                }
                numStack.push(total);
                stack.push(root.right);
                root = root.left;
            } else {
                root = stack.pop();
                total = numStack.pop();
                subList.remove(subList.size() - 1);
            }
        }
        return list;
    }
}
