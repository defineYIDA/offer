

import java.util.ArrayList;
import java.util.Stack;
/**
 * @Author: zl
 * @Date: 2019/3/14 0:12
 */
public class Link {

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 打印链表，使用栈(最优解)
     */
    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> al=new ArrayList<>();//结果集
            if(null==listNode){
                return al;
            }
            Stack<Integer> stack=new Stack<Integer>();
            while(listNode!=null){
                stack.push(listNode.val);
                listNode=listNode.next;
            }
            while(!stack.isEmpty()){
                al.add(stack.pop());
            }
            return al;
        }
    }

    /**
     * 打印链表，递归版本
     */
    public class Solution1{
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            if(listNode!=null){
                this.printListFromTailToHead(listNode.next);
                arrayList.add(listNode.val);
            }
            return arrayList;
        }
    }

    /**
     * 扩展方法
     */
    public class Solution2 {

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> arr=new ArrayList<Integer>();
            while(listNode!=null){
                arr.add(0,listNode.val);//处理
                listNode=listNode.next;
            }
            return arr;
        }
    }
}
