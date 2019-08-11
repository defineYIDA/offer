package leetcode;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/8/11 9:40
 */
public class Pro300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        //定义状态为以nums[i]结尾的最大上升序列的长度
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}
