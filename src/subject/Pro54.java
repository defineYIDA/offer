package subject;

/**
 * @Author: zl
 * @Date: 2019/5/28 16:16
 */
public class Pro54 {
    public static void main(String[]  v) {
        TreeNode node = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2= new TreeNode(5);
        TreeNode node3 = new TreeNode(7);
        node.left = node1;
        node1.left = node2;
        node1.right = node3;
        System.out.println(KthNode(node, 2).val);
    }
    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k < 0) {
            return null;
        }
        //将k的值传递转化为引用传递，是下层对k的更改传递到上层
        int[] tmp = {k};
        return KthNodeCore(pRoot, tmp);
    }
    public static TreeNode KthNodeCore(TreeNode pRoot, int[] k) {
        TreeNode target = null;
        if (pRoot.left != null) {
            target = KthNodeCore(pRoot.left, k);
        }
        if (target == null) {
            //停止递归的条件
            if (k[0] == 1) {
                target = pRoot;
            } else {
                k[0]--;
            }
        }
        if (target == null && pRoot.right != null) {
            target = KthNodeCore(pRoot.right, k);
        }
        return target;
    }
}
