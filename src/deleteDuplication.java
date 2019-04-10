/**
 * @Author: zl
 * @Date: 2019/3/15 23:51
 */
public class deleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 删除链表中重复元素
     * 即处理链表题的常用方法：
     *                pPreNode：存储当前节点的前一个节点；当处理第一个节点的时候为null，所有在后续处理得防止NPE
     *                pNode:当前节点；
     *                pNextNode:下一个节点；
     *                pHead:
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(null==pHead){
            return null;
        }
        ListNode preNode = null;//用来当前节点的上一个节点
        ListNode node = pHead;
        while(null!=node){
            boolean isDele=false;//标识是否删除
            ListNode nextNode=node.next;//下个节点
            if(nextNode!=null&&nextNode.val==node.val){
                isDele=true;
            }
            if(isDele){
                int value = node.val;
                ListNode toBeDel = node;
                while(nextNode!=null&&value==nextNode.val){
                    nextNode = toBeDel.next;
                    toBeDel=nextNode;
                    if(preNode==null){
                        pHead = nextNode;
                    }else{
                        preNode.next=nextNode;
                    }
                    node = nextNode;
                }
            }else{
                preNode=node;
                node=node.next;
            }
        }
        return pHead;
    }

    /**
     * 将重复结点全部删除
     */
    public class Solution {
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
                return pHead;
            }
            if (pHead.val == pHead.next.val) { // 当前结点是重复结点
                ListNode pNode = pHead.next;
                while (pNode != null && pNode.val == pHead.val) {
                    // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                    pNode = pNode.next;
                }
                return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
            } else { // 当前结点不是重复结点
                pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
                return pHead;
            }
        }
    }

    /**
     * 重复结点保留一个
     */
    class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            if(null==head||null==head.next){
                return head;
            }
            if(head.val==head.next.val){
                ListNode pNode=head.next;
                while(pNode!=null&&pNode.next!=null&&head.val==pNode.next.val){
                    pNode=pNode.next;
                }
                return deleteDuplicates(pNode);
            }else{
                head.next=deleteDuplicates(head.next);
                return head;
            }

        }
    }
}
