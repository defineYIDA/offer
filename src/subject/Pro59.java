package subject;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: zl
 * @Date: 2019/5/30 15:43
 */
public class Pro59 {
    /**
     *题：滑动窗口的最大值
     *      思路：采用一个双端队列，作为窗口，队列里存最大值和可能的最大值(对应下一个窗口而言)
     *           注意的是队列里存数字下标值，当前处理的下标和数字里的数字下标值大于等于窗口大小
     *           时将数字滑出。
     *
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> maxList = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) {
            return maxList;
        }
        //使用数组来代替两边开口的队列
        Deque<Integer> queue = new LinkedList<>();
        //填充第一个窗口
        for (int i = 0; i < size && i < num.length; i++) {
            //将队列中的小于当前值的全部移除
            while (queue.size() != 0 && num[i] >= num[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        for (int i = size; i < num.length; i++) {
            //将队列首部的最大值存储
            maxList.add(num[queue.getFirst()]);
            //将队列中的小于当前值的全部移除
            while (queue.size() != 0 && num[i] >= num[queue.getLast()]) {
                queue.removeLast();
            }
            //删除已经滑出窗口的数据对应的下标
            if (queue.size() != 0 && queue.getFirst() <= (i - size)) {
                queue.removeFirst();
            }
            queue.addLast(i);
        }
        //最后一个窗口的最大值
        maxList.add(num[queue.getFirst()]);
        return maxList;
    }
}
