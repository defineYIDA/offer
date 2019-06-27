package subject;
import link.ListNode;

/**
 * @Author: zl
 * @Date: 2019/5/28 9:53
 */
public class Pro52 {
    /**
     *题51：两个链表的公共节点
     *    思路：遍历得到元素的长度，长链表-短链表 = 长链表先走的步数
     *
     */
    //遍历链表得到长度，较长链表减去短链表是先走的步数
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        ListNode node1 = pHead1;//s
        ListNode node2 = pHead2;//l
        int diff = length2 - length1;
        if (length1 > length2) {
            diff = length1 - length2;
            node1 = pHead2;
            node2 = pHead1;
        }
        while (diff > 0) {
            node2 = node2.next;
            diff--;
        }
        while (node1 != null && node2 != null) {
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }
    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
