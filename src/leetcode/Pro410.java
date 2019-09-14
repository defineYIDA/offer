package leetcode;

/**
 * @Author: zl
 * @Date: 2019/9/5 10:59
 */
public class Pro410 {
    public static int splitArray(int[] nums, int m) {
        long l = nums[0], h = 0;
        for (int i = 0; i < nums.length; i++) {
            h += nums[i];
            l = Math.max(l, nums[i]);
        }
        while (l < h) {
            long mid = (l + h) >> 1;
            long temp = 0;
            //初始值为1，意为划分结果为大于mid的数组+剩余数组
            int cnt = 1;
            for (int i = 0; i < nums.length; i++) {
                temp += nums[i];
                if (temp > mid) {
                    temp = nums[i];
                    cnt++;
                }
            }
            if (cnt > m) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return (int)l;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        splitArray(nums, 2);
    }
}
