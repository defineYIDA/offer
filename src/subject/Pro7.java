package subject;

/**
 * @Author: zl
 * @Date: 2019/7/2 16:40
 */
public class Pro7 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return reBuilidCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
    private TreeNode reBuilidCore(int [] pre, int pL, int pR, int [] in, int iL, int iR) {
        if (pL > pR) {
            return null;
        }
        //前序遍历的第一个节点为根节点
        int rootVal = pre[pL];
        TreeNode root = new TreeNode(rootVal);
        //找到根节点值在后序遍历的位置
        int index = indexOfIn(in, rootVal);
        //获得左/右子树节点个数
        int leftSize = index - iL;
        int rightSize = iR - index;
        //存在左子树
        if (iL != index) {
            root.left = reBuilidCore(pre, pL + 1, pL + leftSize, in, iL, index - 1);
        }
        //存在右子树
        if (iR != index) {
            root.right = reBuilidCore(pre, pL + leftSize + 1, pR, in, index + 1, iR);
        }
        return root;
    }
    private int indexOfIn(int [] in, int val) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == val) {
                return i;
            }
        }
        return 0;//error
    }
}
