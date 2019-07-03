package subject;

import tree.TreeNode;

/**
 * @Author: zl
 * @Date: 2019/5/17 10:46
 */
public class Pro26 {

    /**
     * 非递归
     *<href> leetcode.Pro572</>
     */
    public boolean HasSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return false;
        boolean result = false;
        if (s.val == t.val) {
            result = equals(s, t);
        }
        if (!result) {
            //遍历左子树
            result = HasSubtree(s.left, t);
        }
        if (!result) {
            //遍历右子树
            result = HasSubtree(s.right, t);
        }
        return result;
    }
    public boolean equals(TreeNode s, TreeNode t) {
        if (t == null) {
            //如果子结构的条件为完全相等，leetcode https://leetcode-cn.com/problems/subtree-of-another-tree/submissions/
            /*if (s == null) {
                return true;
            } else {
                return false;
            }*/
            return true;
        }
        if (s == null) {
            return false;
        }
        if (s.val == t.val) {
            return equals(s.left, t.left) && equals(s.right, t.right);//这种Boolean值的传递很重要
        } else {
            return false;
        }
    }
}
