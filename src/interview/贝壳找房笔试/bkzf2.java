package interview.贝壳找房笔试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/8/11 8:52
 */
public class bkzf2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine().trim());
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            long temp = Long.valueOf(br.readLine().trim());
            nums[i] = temp;
        }

        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            long max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        System.out.println(Arrays.stream(dp).max().orElse(0));
    }
}
