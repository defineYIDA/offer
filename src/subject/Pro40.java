package subject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zl
 * @Date: 2019/5/21 16:20
 */
public class Pro40 {
    /**
     *找最小的k个数
     *      思路：使用一个数组，用作容器来存储次数,这里考虑用定长数组是错的，那种
     方式仅适用于知道数据范围，就是需要处理的数值处于一个区间

     *
     *
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        //使用堆的目的，O(1)找到堆中最大的数
        //可以处理海量数据，就是数据一次性不能全部加入硬盘
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {//降序
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}
