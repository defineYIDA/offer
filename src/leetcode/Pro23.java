package leetcode;

import link.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zl
 * @Date: 2019/6/21 22:12
 */
public class Pro23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val == l2.val)
                    return 0;
                else if (l1.val > l2.val)
                    return 1;
                else
                    return -1;

            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                minHeap.add(lists[i]);
        }
        ListNode dummy = new ListNode(-1);
        ListNode pNode = dummy;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            pNode.next = node;
            if (node.next != null)
                minHeap.add(node.next);
            pNode = pNode.next;
        }
        return dummy.next;
    }
}
