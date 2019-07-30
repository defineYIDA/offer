package leetcode;

import link.ListNode;

/**
 * @Author: zl
 * @Date: 2019/7/30 9:33
 */
public class Pro2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;//表示进位
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (p1 != null || p2 != null) {
            int num1 = p1 != null ? p1.val : 0;
            int num2 = p2 != null ? p2.val : 0;
            int temp = num1 + num2 + flag;
            ListNode node = new ListNode(temp % 10);
            prev.next = node;
            prev = node;
            flag = temp / 10;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (flag > 0) {
            prev.next = new ListNode(flag);
        }
        return dummy.next;
    }
}
