package leetcode;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zl
 * @Date: 2019/7/6 0:48
 */
public class Pro297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serializeCore(root, sb);
        return sb.toString();
    }
    private void serializeCore(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(" " + ",");
            return;
        }
        sb.append(root.val + ",");
        serializeCore(root.left, sb);
        serializeCore(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] strArr = data.split(",");
        int len = strArr.length;
        Queue<Integer> queue = new LinkedList<>();
        //放入队列中
        for (int i = 0; i < len; i++) {
            if (" ".equals(strArr[i])) {
                queue.add(null);
            } else {
                queue.add(Integer.valueOf(strArr[i]));
            }
        }
        return deserializeCore(queue);
    }

    private TreeNode deserializeCore(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        Integer val = queue.poll();
        if (val == null) {
            return null;
        }
        TreeNode root = new TreeNode(val);
        root.left = deserializeCore(queue);
        root.right = deserializeCore(queue);
        return root;
    }
}
