

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
        ArrayList<Integer> arrayList=new ArrayList<>();
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            if(listNode!=null){
                this.printListFromTailToHead(listNode.next);
                arrayList.add(listNode.val);
            }
            return arrayList;
        }
        public ListNode deleteDuplication(ListNode pHead){
            //基线条件
            if(null==pHead||null==pHead.next){
                return pHead;
            }
            pHead.next=deleteDuplication(pHead.next);
            arrayList.add(pHead.val);
            return pHead;
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
    int count=1;
    int del=8;
    //遍历链表删除倒数第n=8个元素
    public ListNode removeNode(ListNode head){
        if(null==head||null==head.next){
            return null;
        }
        removeNode(head.next);
        //归途中进行计数，并且删除目标元素
        count++;
        if(del==count){
            head.val=head.next.val;
            head.next=head.next.next;
        }else if(del==1&&count==2){//这里增加一次特殊处理
            head.next=null;
        }
        return head;

    }

}
