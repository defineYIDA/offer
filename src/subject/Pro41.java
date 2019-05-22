package subject;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: zl
 * @Date: 2019/5/22 20:58
 */
public class Pro41 {


    //题目41：数据流中的中位数
    //    思路：需要考虑是存储数据的容器的问题
    //    插入的时间复杂度和得到中位数的时间复杂度
    //    +-------------------------------------------+
    //    |    数据结构     |    insert    | getMedian |
    //    |--------------------------------------------|
    //    |  没有排序的数组  |     O(1)    |    O(n)    |
    //    |   排序数组       |     O(n)    |     O(1)   |
    //    |    排序链表      |     O(n)    |    O(1)    |
    //    |      BST        | O(logn)O(n) |  O(logn)O(n |
    //    |      AVL        |     O(logn) |    O(1)     |
    //    |  max堆andmin堆  | O(logn)     |     O(1)    |
    //    +---------------------------------------------+
    //
    //    采用堆的原因：
    //           1）插入时间 O(log n) , 获得中位数时间 O(1)
    //           2）平衡的
    //           3）
    private PriorityQueue<Integer> maxHeap;//最大堆
    private PriorityQueue<Integer> minHeap;//最小堆
    private int total = 0;

    /** initialize your data structure here. */
    public Pro41() {
        //小根堆，存放后n/2个数
        minHeap = new PriorityQueue<>();
        //大根堆，存放前n/2或n/2 - 1个数(奇的情况中位数在堆顶)
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public void addNum(int num) {
        //如果小/大根堆为空,将值放入最大堆
        //代表，第一个数存max，第二个数存也存max，然后触发平衡算法
        //到达：min一个元素max一个元素
        if (maxHeap.size() == 0 || minHeap.size() == 0) {
            maxHeap.add(num);
        } else {
            //和大根堆堆顶比较，小于堆顶放入大根堆
            if (num <= (Integer)maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
        total++;
        //比较两堆大小，调整元素使堆平衡,
        //将元素个数较多的堆顶元素移动到另一个堆
        //这里会在min元素个数大于max的时候，和max-min大于1的时候进行调整，确保max元素大于或等于min
        while (maxHeap.size() - minHeap.size() != 0 && maxHeap.size() - minHeap.size() != 1) {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            } else {
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public Double findMedian() {
        if ((total & 1) == 0) {//偶
            return ((Integer)maxHeap.peek() + (Integer)minHeap.peek()) / 2.0;
        } else {
            //因为max大于或等于min，所以奇的情况元素在max的堆顶
            return Double.valueOf(maxHeap.peek());
        }
    }

}
