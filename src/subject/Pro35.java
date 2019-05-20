package subject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zl
 * @Date: 2019/5/20 17:22
 */
public class Pro35 {
    /**
     *复制链表：
     *    思路
     *       1）先遍历原始链表N，将主链表复制N'
     *       2）再复制随机指针<N -> S>(这里因为要寻找S',所以需要每一个节点N'都需要遍历整个节点寻找S',时间复杂度为O(n*n))
     *       a,使用O(n)的辅助空间来解决，存储<N, N'>的映射，时间复杂度为O(n)
     *       b，采用拼接链表的方式来实现不开辅助空间的O(n)的复制
     */
    public Node copyRandomList(Node head) {

        //return copyRandomList1(head);
        return copyRandomList2(head);
    }
    //法a,时间复杂度O(n),空间复杂度O(n)
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        Node oldNode = head;
        Node newHead = null;//new head

        Node newNode = null;

        Map<Node, Node> map = new HashMap<>();

        //遍历主链表
        while (oldNode != null) {
            if (newHead == null) { //head node
                newHead = createNode(oldNode.val);
                newNode = newHead;
            } else {
                newNode.val = oldNode.val;
            }
            map.put(oldNode, newNode);
            oldNode = oldNode.next;
            //这里注意得先判断原链表是否遍历完毕
            if (oldNode != null) {
                Node node = new Node();
                newNode.next = node;
                newNode = node;
            }
        }

        Node newNode1 = newHead;
        //遍历负责随机指针
        while (head != null) {
            if (head.random != null) {
                Node randomNode = head.random;
                Node newRandomNode = map.get(randomNode);
                newNode1.random = newRandomNode;
            }
            head = head.next;
            newNode1 = newNode1.next;
        }
        return newHead;
    }

    private Node createNode(int val) {
        Node copy = new Node();
        copy.val = val;
        return copy;
    }


    //法b,时间复杂度O(n),空间复杂度O(1)
    public Node copyRandomList2(Node head) {
        Node oldHead = head;
        oldHead = cloneNodes(oldHead);
        oldHead = connectRandom(oldHead);
        return getNewNode(oldHead);
    }
    private Node cloneNodes(Node head) {
        Node oldNode = head;

        //将复制链表连接到主链表后：N1->N'1-N2->N'2->.....
        while (oldNode != null) {
            Node copy = createNode(oldNode.val);
            copy.next = oldNode.next;
            copy.random = null;

            oldNode.next = copy;
            oldNode = copy.next;
        }
        return head;
    }
    //连接随机指针
    private Node connectRandom(Node head) {
        Node oldNode = head;
        while (oldNode != null) {
            Node copy = oldNode.next;
            if (oldNode.random != null) {
                copy.random = oldNode.random.next;
            }
            oldNode = copy.next;
        }
        return head;
    }
    //根据奇偶获取节点
    //注意不能打乱原始的链表，因为可能测试用例会依赖这个链表
    private Node getNewNode(Node head) {
        Node pNode = head;
        Node newHead = null;//new head

        Node newNode = null;

        if (pNode != null) {
            newHead = pNode.next;
            newNode = newHead;
            pNode.next = newNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            newNode.next = pNode.next;
            newNode = newNode.next;
            pNode.next = newNode.next;
            pNode = pNode.next;
        }
        return newHead;
    }

}
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
