package leetcode;

import stack.Stack;
import tree.TreeNode;

/**
 * @Author: zl
 * @Date: 2019/7/5 23:22
 */
public class pro449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //前序遍历，逗号分隔，进行序列化
        if (root == null) {
            return "";
        }
        String enStr = "";
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                enStr += root.val + ",";
                stack.push(root.right);
                root = root.left;
            } else {
                root = stack.pop();
            }
        }
        return enStr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] dataArr = data.split(",");
        return deserializeCore(dataArr, 0, dataArr.length - 1);

    }
    private TreeNode deserializeCore(String[] dataArr, int l, int r) {
        if (l > r) {
            return null;
        }
        int rootVal = Integer.valueOf(dataArr[l]);
        TreeNode root = new TreeNode(rootVal);
        int m = l;
        for (;m <= r; m++) {
            if (rootVal < Integer.valueOf(dataArr[m])) {
                break;
            }
        }
        if (m - l > 1) {
            root.left = deserializeCore(dataArr, l + 1, m - 1);
        }
        if (r - m >= 0) {
            root.right = deserializeCore(dataArr, m , r);
        }
        return root;
    }
}

