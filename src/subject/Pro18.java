package subject;

import link.ListNode;

/**
 * @Author: zl
 * @Date: 2019/7/13 9:41
 */
public class Pro18 {

    /**
     * 删除链表的重复节点
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode prev = dummy;
        while (pHead != null) {
            ListNode next = pHead.next;
            if (next != null && pHead.val == next.val) {
                while (pHead != null && pHead.val == next.val) {
                    pHead = pHead.next;
                }
                prev.next = pHead;
            } else {
                prev = pHead;
                pHead = next;
            }
        }
        return dummy.next;
    }

    /**
     * 题目二：给定val，将其删除
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }

    /**
     * 题目一：给定节点将其删除
     * 软删除
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
