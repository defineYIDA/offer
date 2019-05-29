package subject;

import java.util.ArrayList;

/**
 * @Author: zl
 * @Date: 2019/5/29 11:53
 */
public class Pro57 {
    /**
     *题：和为s的数字
     *      思路：
     *          O(n*n)的暴力法不太完美，使用一个指向头和尾的指针，可以很好的
     *          解决问题
     *
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<> ();
        if (array == null) {
            return list;
        }
        int length = array.length;
        int pHead = 0;
        int pEnd = length - 1;
        while (pHead < pEnd) {
            int head = array[pHead];
            int end = array[pEnd];
            int mix = array[pHead] + array[pEnd];
            if (mix == sum) {
                if (head > end) {
                    list.add(end);
                    list.add(head);
                } else {
                    list.add(head);
                    list.add(end);
                }
                return list;
            } else if (mix < sum) {
                pHead++;
            } else {
                pEnd--;
            }
        }
        return list;
    }
}
