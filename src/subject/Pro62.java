package subject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/6/2 21:33
 */
public class Pro62 {
    /*
     *题：圆圈中最后剩下的数
     *       思路：使用链表或者list代替圆圈
     *
     */
    public static int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int current = 0;
        while (list.size() != 0) {
            //删除第m个元素
            for (int i = 1; i < m; i++) {
                //判断list是否到达末尾,
                //不是末尾：++
                //末尾：= 0；
                if (current == list.size() - 1) {
                    current = 0;
                } else
                    current++;
            }
            int size = list.size();
            //删除第m个元素
            list.remove(current);
            if (current == size - 1) {
                current = 0;
            }
            //判断是否只有一个元素
            if (list.size() == 1) {
                return list.get(0);
            }
        }
        return -1;
    }

    public static void main(String[] var) {
        LastRemaining_Solution(5, 3);
    }

    /**
     * 使用归纳法：
     * 0                                   n = 1
     *  [f(n - 1, m) + m]%n       n > 1
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 要删除元素的位置
        int idx = 0;
        while (list.size() > 1) {
            // 只要移动m-1次就可以移动到下一个要删除的元素上
            for (int i = 1; i < m; i++) {
                idx = (idx + 1) % list.size();
            }
            list.remove(idx);
        }
        return list.get(0);
    }
}
