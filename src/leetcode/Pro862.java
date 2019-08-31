package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zl
 * @Date: 2019/8/31 10:03
 */
public class Pro862 {
    public int shortestSubarray(final int[] A, int K) {
        int len = A.length;
        int sum = 0, begin = 0, res = -1;
        for (int i = 0; i < len; i++) {
            //单个值大于K时返回1
            if (A[i] >= K) return 1;
            //累加为负的直接跳过
            sum += A[i];
            if (sum < 1) {
                sum = 0;
                begin = i + 1;
                continue;
            }
            //使得数组全为正数或者是0，通过判断当前值是否小于0，小于0则先前累加
            //1，2，3，-1，-1，-1，-1，2，3
            //1，1，0，0，0，0，0，2，3
            for (int j = i - 1; A[j + 1] < 0; j--) {
                A[j] = A[j + 1] + A[j];
                A[j + 1] = 0;
            }
            //经过处理现在数组全为非负数了
            //那么累加值是一个单调递增的过程
            if (sum >= K) {
                while (sum - A[begin] >= K || A[begin] <= 0)
                    sum -= A[begin++];
                int length = i - begin + 1;
                if (res < 0 || res > length)
                    res = length;
            }
        }
        return res;
    }
    /**
     * 超时
     * @return
     */
    public int shortestSubarray1(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }
        //累计和，index
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, min = 0x7fffffff;
        map.put(0, -1);
        for (int i = 0; i < A.length; i++) {
            if (A[i] > K) {
                return 1;
            }
            sum += A[i];
            int t = sum - K;//临界点
            //判断是否存在小于k的连续数组
            while (t >= 0) {
                if (map.containsKey(t)) {
                    min = Math.min(min, i - map.get(t));
                }
                t--;
            }
            map.put(sum, i);
        }
        return min == 0x7fffffff ? -1 : min;
    }
}
