package subject;

/**
 * @Author: zl
 * @Date: 2019/7/6 10:39
 */
public class Pro55 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int max = -1;
        if (root.left != null) {
            max = Math.max(maxDepth(root.left), max);
        }
        if (root.right != null) {
            max = Math.max(maxDepth(root.right), max);
        }
        return max + 1;
    }
}
