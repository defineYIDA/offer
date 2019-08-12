package interview.贝壳找房笔试;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/8/12 9:26
 */
public class bkzf4 {
    public static long minSum(int n, long[] nums) {
        if (n == 1)
            return 0;
        if (n == 2 && nums[0] == nums[1])
            return 1;
        if (n == 2 && nums[0] != nums[1])
            return 0;

        long[] temp = Arrays.copyOf(nums, n);

        int i = 0;
        while (i < n - 1 && nums[i] < nums[i + 1])
            i++;
        int j = n - 1;
        while (j > 0 && nums[j] < nums[j - 1])
            j--;

        while (i < j) {
            if (nums[i] < nums[j]) {
                if (nums[i + 1] < nums[i] + 1)
                    nums[i + 1] = nums[i] + 1;
                i++;
            } else {
                if (nums[j - 1] < nums[j] + 1)
                    nums[j - 1] = nums[j] + 1;
                j--;
            }
        }
        return Arrays.stream(nums).sum() - Arrays.stream(temp).sum();
    }
}