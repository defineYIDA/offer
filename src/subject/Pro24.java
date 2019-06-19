package subject;

import link.ListNode;

/**
 * @Author: zl
 * @Date: 2019/6/19 10:47
 */
public class Pro24 {
    //迭代
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode prev = null;//前一个节点
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
    //递归：
    //p1-->p2-->p3-->p4-->null
    //递归停止在p4处，记录新链表的头节点：pNode = p4
    //now：当前节点：head = p3；下一节点：pNode = p4
    // head.next.next == p4.next = p3
    //set：p3.next = null
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pNode = reverseList(head.next);
        //本节点的下节点的下节点 = 本节点
        head.next.next = head;
        //必须设置为null，因为是从后往前处理，例如：
        head.next = null;
        return pNode;
    }
}
