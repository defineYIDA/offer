package LRU;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Author: zl
 * @Date: 2019/8/13 22:51
 */
public class LRUCache<K, V> {
    private Hashtable<K, LRUNode<K, V>> map;

    private int capacity;

    private LRUNode<K, V> head;

    private LRUNode<K, V> tail;

    private static final int DEFAULT_CAP = 5;

    public LRUCache(int capacity) {
        if (capacity < 1) {
            capacity = DEFAULT_CAP;
        }
        this.capacity = capacity;
        map = new Hashtable<>();
    }

    public void put(K key, V value) {
        LRUNode<K, V> node = map.get(key);
        if (node == null) {
            //判断容量
            if (currentSize() >= capacity) {
                //删除掉尾部，最不常使用的节点
                if (tail != null) {
                    //从map中删除
                    map.remove(tail.key);
                    //从链表中删除
                    removeTail();
                }
            }
            node = new LRUNode<>(key, value);
        } else {
            //更新value值
            node.value = value;
            //也先把节点给删除掉，然后再统一连接到链表头
            remove(node);
        }

        //添加/更新value到map
        map.put(key, node);
        //添加到链表头部
        setHead(node);
    }

    public V get(K key) {
        LRUNode<K, V> node = map.get(key);
        if (node != null) {
            //在链表中删除该节点，再将该节点添加到头
            remove(node);
            setHead(node);
            return node.value;
        }
        return null;
    }

    /**
     * 清除尾部(最少使用的节点)
     */
    private void removeTail() {
        if (tail != null) {
            if (tail.prev != null) {
                tail.prev.next = null;
            } else {
                head = null;
            }
            tail = tail.prev;
        }
    }

    /**
     * 删除对应key的节点,注意头尾
     *
     * @param node
     */
    public void remove(LRUNode<K, V> node) {
        if (node == null) {
            return;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        //如果删除的是尾
        if (tail == node) {
            tail = node.prev;
        }
        //如果删除的是头部
        if (head == node) {
            head = node.next;
        }
    }

    /**
     * 添加到链表头部,注意头尾
     *
     * @param node
     */
    private void setHead(LRUNode<K, V> node) {
        if (node == null) {
            return;
        }
        //防止出现循环链表
        node.prev = null;
        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
        //如果链表之前为空，那么得设置尾
        if (tail == null) {
            tail = node;
        }
    }

    private int currentSize() {
        return map.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (head != null) {
            sb.append("head:" + head.toString());
            LRUNode node = head.next;
            while (node != null) {
                sb.append(node.toString());
                node = node.next;
            }
            return sb.toString();
        }
        return "-";
    }
}
