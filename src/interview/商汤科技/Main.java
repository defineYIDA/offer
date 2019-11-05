package interview.商汤科技;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/9/21 19:25
 */
public class Main {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arr = line.split(" ");
        pro1(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));
    }
    static int count = 0;
    public static void pro1(int m, int n) {
        //dfs(0, 0, m - 1, n - 1);
        int[][] dp = init(m, n);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }
    private static int[][] init(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        dp[0][0] = 0;
        return dp;
    }
    private static void dfs(int i, int j, int m, int n) {
        if (i > m || j > n) {
            return;
        }
        if (i == m && j == n) {
            count++;
            return;
        }
        dfs(i + 1, j, m, n);
        dfs(i, j + 1, m, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String line1 = sc.nextLine();
        String[] arr = line1.split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(arr[i]);
        }
        pro2(nums, n);
    }
    public static void pro2(int[] nums, int n) {
        //找到最小负数
        int index = -1, minVal = 0, total = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 && minVal > nums[i]) {
                index = i;
                minVal = nums[i];
            }
            total += nums[i];
        }
        //全为正数
        if (index == -1) {
            System.out.println(total);
            return;
        }
        //从最小负数开始dp
        int cur = (index + 1) >= n ? (index + 1 - n) : (index + 1);
        int[] dp = new int[n];
        int i = 0, max = Integer.MIN_VALUE;
        dp[0] = minVal;
        i++;
        while (cur != index) {
            int val = nums[cur];
            dp[i] = Math.max(val, dp[i - 1] + val);
            cur = (cur + 1) >= n ? (cur + 1 - n) : (cur + 1);
            max = Math.max(max, dp[i]);
            i++;
        }
        System.out.println(max);
    }
}
