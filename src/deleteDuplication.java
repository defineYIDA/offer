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
}
