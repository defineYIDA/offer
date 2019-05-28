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
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = 0;
        int length2 = 0;
        ListNode pNode1 = pHead1;
        ListNode pNode2 = pHead2;
        while (pNode1 != null) {
            length1++;
            pNode1 = pNode1.next;
        }
        while (pNode2 != null) {
            length2++;
            pNode2 = pNode2.next;
        }
        if (length1 > length2) {
            int i = length1 - length2;
            while (i > 0) {
                pHead1 = pHead1.next;
                i--;
            }
        } else {
            int i = length2 - length1;
            while (i > 0) {
                pHead2 = pHead2.next;
                i--;
            }
        }
        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }
}
