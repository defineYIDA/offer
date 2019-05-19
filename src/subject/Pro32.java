package subject;

import stack.Stack;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zl
 * @Date: 2019/5/19 14:58
 */
public class Pro32 {
    /**
     *层序遍历：
     *      思路：使用一个队列来存储节点
     *       要想做到分层，还得需要两个辅助变量
     *       nowLevel 当前层的节点数
     *       nextLevel 下一层的节点数(可优化)
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {

        Queue<TreeNode> que = new LinkedList<TreeNode>();

        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        int nowLevel = 1;
        int nextLevel = 0;
        que.add(root);
        while (!que.isEmpty()) {
            //注意在对list填充一个成员引用类型时可能会出现的问题，会导致和预期结果不一致
            //list里持有的是全局变量的引用，后期的更改会体现到list里
            //并且clear的操作慎用
            ArrayList<Integer> cil = new ArrayList<Integer>();
            while (nowLevel > 0) {
                TreeNode node = que.poll();
                cil.add(node.val);
                nowLevel--;
                if (node.left != null) {
                    que.add(node.left);
                    nextLevel++;
                }
                if (node.right != null) {
                    que.add(node.right);
                    nextLevel++;
                }
            }
            //这里可以优化，在每一次while循环是通过获得queue的长度获得该层的节点个数
            res.add(cil);
            nowLevel = nextLevel;
            nextLevel = 0;
        }
        return res;
    }
    /**
     *之字型遍历：
     *      思路：使用两个栈来存储节点
     *       stack1出栈将节点放在stack2，但是注意左右节点的顺序问题
     *       每一个栈存储一个层
     *       一个栈为空就访问另一个栈
     *       stack1的入栈顺序是节点的 R-->L (根节点入栈的栈)
     *       stack1的入栈顺序是节点的 L-->R
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        Stack<TreeNode> stackL = new Stack<>();//左栈，对应stack1
        Stack<TreeNode> stackR = new Stack<>();//右栈，对应stack2
        if (pRoot == null) {
            return res;
        }
        stackL.push(pRoot);//将根节点压入左栈
        while (!stackL.isEmpty() || !stackR.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            while (!stackL.isEmpty()) {
                TreeNode node = stackL.pop();
                list.add(node.val);
                if (node.left != null) {
                    stackR.push(node.left);//先左节点
                }
                if (node.right != null) {
                    stackR.push(node.right);//再右节点
                }
            }
            if (list.size() != 0) {
                res.add(list);
            }
            ArrayList<Integer> list1 = new ArrayList<>();
            while (!stackR.isEmpty()) {
                TreeNode node = stackR.pop();
                list1.add(node.val);
                if (node.right != null) {
                    stackL.push(node.right);//先右节点
                }
                if (node.left != null) {
                    stackL.push(node.left);//再左节点
                }
            }
            if (list1.size() != 0) {
                res.add(list1);
            }
        }
        return res;
    }
}
