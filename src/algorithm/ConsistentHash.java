package algorithm;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

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
        return virtualNode;
        //return virtualNode.substring(0, virtualNode.indexOf("vir"));
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
        //地址无关，由伪随机生成器生成，确保每一个对象的该值相同,明显indenttity不满足该要求
        //int h = System.identityHashCode(key);
        //业务相关
        int h = key.hashCode();
        //高位运算增加随机性
        h = h ^ (h >>> 16);
        return h & 0x7fffffff;
    }

    /**
     * hash 运算
     *CRC32_HASH、FNV1_32_HASH、KETAMA_HASH
     */
    public Long hashPlus(String value) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 not supported", e);
        }
        md5.reset();
        byte[] keyBytes = value.getBytes(StandardCharsets.UTF_8);

        md5.update(keyBytes);
        byte[] digest = md5.digest();

        // hash code, Truncate to 32-bits
        long hashCode = ((long) (digest[3] & 0xFF) << 24)
                | ((long) (digest[2] & 0xFF) << 16)
                | ((long) (digest[1] & 0xFF) << 8)
                | (digest[0] & 0xFF);

        return hashCode & 0xffffffffL;
    }

    public static void main(String[] args) {
        List<String> values = new ArrayList<>();
        values.add("127.0.0.1");
        values.add("127.0.0.3");
        values.add("10.0.0.1");
        values.add("198.0.0.1");

        ConsistentHash consistentHash = new ConsistentHash();
        System.out.println(consistentHash.process(values, "key1"));
        System.out.println(consistentHash.process(values, "key2"));
    }
}
