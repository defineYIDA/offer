package leetcode;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zl
 * @Date: 2019/7/2 11:42
 */
public class Pro103 {
    //基本和层序遍历不变（插入节点顺序left->right），只需要判断单双层，然后从左或者从右插
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        int i = 1;//单数 左->右；双 右->左
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sub = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (i % 2 == 1) {
                    //左->右, list从左往右插
                    sub.add(node.val);
                } else {
                    //右->左，list从右往左插
                    sub.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            i++;
            list.add(sub);
        }
        return list;
    }
}
