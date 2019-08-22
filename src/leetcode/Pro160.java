package leetcode;

import link.ListNode;

/**
 * @Author: zl
 * @Date: 2019/8/22 8:53
 */
public class Pro160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pNodeA = headA, pNodeB = headB;
        int lenA = 0, lenB = 0;
        while (pNodeA != null) {
            lenA++;
            pNodeA = pNodeA.next;
        }
        while (pNodeB != null) {
            lenB++;
            pNodeB = pNodeB.next;
        }
        pNodeA = headA;
        pNodeB = headB;
        int diff = lenA - lenB;
        if (lenA > lenB) {
            while (diff > 0) {
                pNodeA = pNodeA.next;
                diff--;
            }
        } else {
            diff = -diff;
            while (diff > 0) {
                pNodeB = pNodeB.next;
                diff--;
            }
        }
        while (pNodeA != null && pNodeB != null) {
            if (pNodeA == pNodeB) {
                return pNodeA;
            }
            pNodeA = pNodeA.next;
            pNodeB = pNodeB.next;
        }
        return null;
    }
}
