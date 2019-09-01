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
                    return e1.getKey().compareTo(e2.getKey());
                }
                return e2.getValue() - e1.getValue();
            }
        });
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (minHeap.size() != k) {
                minHeap.add(e);
            } else if (e.getValue() >= minHeap.peek().getValue()) {
                //minHeap.poll();
                minHeap.add(e);
            }
        }
        //minHeap.addAll(map.entrySet());
        for (Map.Entry<String, Integer> e : minHeap) {
            list.add(e.getKey());
        }
        return list;
    }
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
