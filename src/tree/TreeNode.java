package tree;

import stack.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zl
 * @Date: 2019/4/15 10:28
 * 二叉树的六种遍历，重点为：
 *                      DLR:先序遍历
 *                      LDR:中序遍历
 *                      LRD:后序遍历
 * 递归实现和非递归实现方式
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x){
        val=x;
    }
//-----------------------------------------------------------LDR_START
    /**
     * LDR递归算法
     */
    List<Integer> list=new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(null==root){
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    /**
     * 基于栈的中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack= new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                //入栈节点为：当前节点
                //入栈顺序为：
                stack.push(cur);
                cur=cur.left;
            }else{//到达最左的节点，则出栈
                //重点：出栈顺序和操作
                cur=stack.pop();
                list.add(cur.val);
                cur=cur.right;
            }
        }
        return list;
    }
//-----------------------------------------------------------LDR_END
//-----------------------------------------------------------DLR_START
    public List<Integer> preorderTraversal(TreeNode root) {
        if(null==root){
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
    //基于栈的前序遍历
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        //遍历到深度最大节点,其实是一种深度优先dfs算法
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){//未到达深度时入栈记录路径
                //入栈节点为：右子树
                //入栈顺序为：深度最浅(根节点)的右子树，到最深的右子数
                stack.push(cur.right);
                list.add(cur.val);
                cur=cur.left;
            }else{//到达最深处后出栈，执行逻辑
                cur=stack.pop();//出栈处理
            }
        }
        return list;
    }
    //-----------------------------------------------------------DLR_END
    // -----------------------------------------------------------LRD_START
    public List<Integer> postorderTraversal(TreeNode root) {
        if(null==root){
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    /**
     * 推荐用ArrayList代替，Stack
     * ```
     * LinkedList<TreeNode> stack = new LinkedList<>();
     * stack.addLast(root);//push
     * TreeNode top = stack.getLast(); //peek
     * lastNodeVistited = stack.removeLast(); //pop
     * ```
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode lastNodeVistited = null; //保存上一个遍历过的节点
        TreeNode cur=root;
        //遍历到深度最大节点,其实是一种深度优先dfs算法
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                TreeNode top = stack.peek(); //获取栈顶节点，不出栈
                //如果栈顶节点没有右孩子，或者已经遍历过了它的右孩子，就遍历该节点
                if (top.right == null || lastNodeVistited == top.right) {
                    list.add(top.val);
                    lastNodeVistited = stack.pop(); //更新最近遍历的节点，出栈
                } else { //否则，准备将栈顶节点的右孩子入栈
                    cur = top.right;
                }

            }
        }
        return list;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();//记录当前队列长度，让队列保存遍历完后只包含一层结点
            List<Integer> list = new ArrayList<Integer>();
            while(count > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                count--;
            }
            res.add(list);
        }
        return res;

    }


//-----------------------------------------------------------LRD_END




}
