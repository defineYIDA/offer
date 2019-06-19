package leetcode;

import link.ListNode;

/**
 * @Author: zl
 * @Date: 2019/6/19 11:49
 */
public class Pro92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        //以1->2->3->4->5, m = 2, n=4 为例:
        //反转部分的头部节点2，
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        head = pre.next;
        //反转区间n--m的元素
        for (int i = m; i < n; i++) {
            //重要！！！！
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }

        return dummy.next;
    }
}
