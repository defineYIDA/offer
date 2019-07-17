package leetcode;

import link.ListNode;

/**
 * @Author: zl
 * @Date: 2019/7/17 11:11
 */
public class Pro876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pNode = head;
        int len = 0;
        while (pNode != null) {
            pNode = pNode.next;
            len++;
        }
        int mid = len >> 1;
        //偶数要求是后1位，所以mid前移
        if ((len & 1) == 0) {
            mid--;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null) {
            if (mid < 0) {
                p1 = p1.next;
            }
            p2 = p2.next;
            mid--;

        }
        return p1;
    }
}
