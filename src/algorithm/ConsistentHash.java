package algorithm;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author: zl
 * @Date: 2019/8/30 10:25
 */
public class ConsistentHash {
    private TreeMap<Long, String> treeMap = new TreeMap<>();

    /**
     * 虚拟节点数
     */
    private static final int VIRTUAL_NODE_SIZE = 4;

    protected void add(long key, String value) {
        //添加虚拟节点
        for (int i = 0; i < VIRTUAL_NODE_SIZE; i++) {
            Long hash = hash("vir" + key + i);
            treeMap.put(hash, value);
        }
    }



    private String getFirstNodeValue(String value) {
        long hash = hash(value);
        System.out.println("value=" + value + " hash = " + hash);

        //此映射的部分视图，其键大于（或等于，如果 inclusive 为 true）fromkey
        SortedMap<Long, String> last = treeMap.tailMap(hash);
        String virtualNode;
        if (!last.isEmpty()) {
            virtualNode = last.get(last.firstKey());
        } else {
            virtualNode = treeMap.firstEntry().getValue();
        }
        return virtualNode.substring(0, virtualNode.indexOf("vir"));
    }

    public String process(List<String> values, String key) {

        for (String value : values) {
            add(hash(value), value);
        }

        return getFirstNodeValue(key);
    }

    /**
     *hash值的要求范围（0，2^32 - 1）
     * 即正数，在一定范围内
     */
    private long hash(String key) {
        return key.hashCode() & 0x7fffffff;
    }

    public static void main(String[] args) {

    }
}
