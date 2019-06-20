package subject;

import link.ListNode;

/**
 * @Author: zl
 * @Date: 2019/6/20 10:16
 */
public class Pro25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pNode = new ListNode(-1);
        ListNode prev = pNode;
        while (l1 != null && l2  != null) {
            if (l2.val >= l1.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return pNode.next;
    }

}
