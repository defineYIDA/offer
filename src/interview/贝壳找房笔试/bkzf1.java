package interview.贝壳找房笔试;

/**
 * @Author: zl
 * @Date: 2019/8/11 8:36
 */
public class bkzf1 {
    public static void main(String[] args) {
        long[] arr = {1111111, 2, 3, 5, 7, 9, 11, 2, 34, 56, 7, 9, 1111};
        long[] res = find(arr, arr.length);

        System.out.println(res[0] + "-" + res[1]);
    }

    public static long[] find(long[] arr, int len) {
        long[] res = new long[2];
        if (len < 2) {
            return res;
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            long abs;
            if (i + 1 < len && (abs = Math.abs(arr[i + 1] - arr[i])) > max) {
                max = abs;
                res[0] = arr[i];
                res[1] = arr[i + 1];
            }
        }
        return res;
    }
}
