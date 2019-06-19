package subject;

import link.ListNode;

/**
 * @Author: zl
 * @Date: 2019/6/19 10:28
 */
public class Pro22 {
    public ListNode detectCycle(ListNode head) {
        ListNode cycle = hasCycle(head);
        if (cycle == null) {
            //无环
            return null;
        }
        int k = cycleSize(cycle);
        ListNode p1 = head;
        ListNode p2 = head;
        while (k > 0) {
            p1 = p1.next;
            k--;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    //返回环中节点
    private ListNode hasCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return fast;
            }
        }
        return null;
    }
    private int cycleSize(ListNode node) {
        ListNode temp = node;
        node = node.next;
        int k = 1;
        while (node != temp) {
            k++;
            node = node.next;
        }
        return k;
    }
}
