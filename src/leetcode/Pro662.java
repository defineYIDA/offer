package leetcode;

import tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zl
 * @Date: 2019/8/21 9:40
 */
public class Pro662 {
    /**
     * 解法一，有点超时，基本思路就是层序遍历，然后判断同一层内的左右
     * 有效节点，
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int l = 0, r = 0;
            boolean empty = true;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
                //该层中第一个有效节点
                if (empty && node != null) {
                    empty = false;
                    l = i;
                    r = i;
                } else if (!empty && node != null) {
                    r = i;
                } else if (!empty) {
                    queue.add(null);
                    queue.add(null);
                }
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    /**
     *
     */
    private int maxW = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public int widthOfBinaryTree1(TreeNode root) {
        dfs(root, 1, 1);
        return maxW;
    }
    private void dfs(TreeNode r, int level, int index) {
        if (r == null) return;
        if (!map.containsKey(level))
            map.put(level,index);
        maxW = Math.max(maxW, index-map.get(level)+1);
        dfs(r.left,level+1,index*2);
        dfs(r.right,level+1,index*2+1);
    }
}
