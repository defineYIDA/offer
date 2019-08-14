package LRU;

/**
 * @Author: zl
 * @Date: 2019/8/14 0:52
 */
public class Main {

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(5);
        cache.set("g1", "1");
        cache.set("g2", "2");
        cache.set("g3", "3");
        cache.set("g4", "4");
        cache.set("g5", "5");
        cache.get("g3");
        cache.get("g1");
        cache.set("g6", "6");
        System.out.println(cache.toString());
    }
}
