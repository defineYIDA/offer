import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zl
 * @Date: 2019/5/4 17:06
 */
public class test1 {
    public static class User {
        Integer age;
        String name;

        public User(Integer age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    public static void main (String[] var) {
        Integer age = 1111;
        User user =new User(1111,"abc");
        System.out.println(user.age.equals(1111));
        Integer num1=new Integer(11);
        Integer num2=new Integer(11);
        System.out.println(num1==num2);
    }
    public static Node copyRandomList(Node head) {

        return copyRandomList1(head);
    }
    public static Node copyRandomList1(Node head) {
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
                newNode = createNode(oldNode.val);
            }
            map.put(oldNode, newNode);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        if (newHead == null) {
            return null;
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

    private static Node createNode(int val) {
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

    public  Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}