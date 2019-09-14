package leetcode;

import link.ListNode;

/**
 * @Author: zl
 * @Date: 2019/9/10 16:30
 */
public class Pro234 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        isPalindrome(n1);
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode pNode = head;
        int len = 0;
        while (pNode != null) {
            pNode = pNode.next;
            len++;
        }
        int mid = len >> 1;
        if (len == 1) {
            return true;
        }
        pNode = head;
        //找到中间mid的节点
        ListNode prev = null;
        while (mid > 0) {
            ListNode next = pNode.next;
            pNode.next = prev;
            prev = pNode;
            pNode = next;
            mid--;
        }
        //奇数，中间的那个元素不判断
        if ((len & 1) == 1) {
            pNode = pNode.next;
        }
        while (prev != null && pNode != null) {
            if (prev.val != pNode.val) {
                return false;
            }
            prev = prev.next;
            pNode = pNode.next;
        }
        return prev == null && pNode == null;
    }
}
