package LRU;

/**
 * @Author: zl
 * @Date: 2019/8/14 0:52
 */
public class Main {

    public static void main(String[] args) {
        //LRUCache<String, String> cache = new LRUCache<>(5);
        LRULinkHashMap<String, String> cache = new LRULinkHashMap<>(5);
        cache.put("g1", "1");
        cache.put("g2", "2");
        cache.put("g3", "3");
        cache.put("g4", "4");
        cache.put("g5", "5");
        cache.get("g3");
        cache.get("g1");
        cache.put("g6", "6");
        System.out.println(cache.toString());
    }
}
