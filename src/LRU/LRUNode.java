package LRU;

/**
 * @Author: zl
 * @Date: 2019/8/13 22:52
 */
public class LRUNode<K, V> {
    K key;

    V value;

    LRUNode<K, V> prev;

    LRUNode<K, V> next;

    public LRUNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public LRUNode() {
        this(null, null);
    }

    @Override
    public String toString() {
        return "【" +
                "key=" + key +
                ", value=" + value +
                '】';
    }
}
