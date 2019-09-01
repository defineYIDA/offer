package leetcode;

import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/9/1 9:55
 */
public class Pro692 {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        int len;
        if (words == null || (len = words.length) == 0) {
            return list;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        //遍历map，拿到top k
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue().equals(e2.getValue())) {
                    return e2.getKey().compareTo(e1.getKey());
                }
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(e);
            } else if (minHeap.comparator().compare(e, minHeap.peek()) > 0) {
                minHeap.poll();
                minHeap.add(e);
            }
        }
        //minHeap.addAll(map.entrySet());
        while (!minHeap.isEmpty()) {
            list.add(0, minHeap.poll().getKey());
        }
        //不能使用这种方式，要使用poll来保持出队时的顺序
        /*for (Map.Entry<String, Integer> e : minHeap) {
            list.add(e.getKey());
        }*/
        return list;
    }
    /**
     * 最大堆
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent1(String[] words, int k) {
        List<String> list = new ArrayList<>();
        int len;
        if (words == null || (len = words.length) == 0) {
            return list;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        //遍历map，拿到top k
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue().equals(e2.getValue())) {
                    return e1.getKey().compareTo(e2.getKey());
                }
                //最大堆无脑插入
                return e2.getValue() - e1.getValue();
            }
        });

        minHeap.addAll(map.entrySet());
        List<String> res=new ArrayList<>(k);
        for (int i=0;i<k;i++)
        {
            res.add(minHeap.poll().getKey());
        }
        return res;
    }
}
