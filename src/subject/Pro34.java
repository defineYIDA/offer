package subject;

import tree.TreeNode;

import java.util.ArrayList;

/**
 * @Author: zl
 * @Date: 2019/5/19 17:28
 */
public class Pro34 {
    /**
     *二叉树中某一值的路径(从树的根节点到叶节点称为一条路径)
     *    思路：先序遍历，栈中存节点
     *         当栈时计算值
     *
     */
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);//到这里移除，回退效果
        return listAll;
    }
}
