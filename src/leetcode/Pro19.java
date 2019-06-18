package leetcode;

import link.ListNode;

/**
 * @Author: zl
 * @Date: 2019/6/18 11:38
 */
public class Pro19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //使用哑节点来避免极端情况，NB
        //则原先删除的是倒数第n个节点，也就是，index == L-n 的节点
        //加了哑节点后，为删除：index == L - n + 1 的节点！
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        //第一次遍历：获得链表长度
        while (first != null) {
            length++;
            first = first.next;
        }
        //L - n 为原先要删除元素的index
        length -= n;
        //第二次遍历：到要删除元素的前一个节点
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        //删除元素
        first.next = first.next.next;
        return dummy.next;
    }
}
