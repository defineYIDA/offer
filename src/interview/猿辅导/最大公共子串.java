package interview.猿辅导;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/8/13 10:05
 */
public class 最大公共子串 {

    /**
     * 思路1）：暴力法，以一个字符串为基础判断以该位置为起点的最大长度
     * <p>
     * <p>
     * 动态规划
     * 状态量为：
     *
     * 可以优化为一维
     *
     * @return
     */
    static int findLongest(String A, int n, String B, int m) {
        if (n == 0 || m == 0)
            return 0;
        int rs = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)//初始状态
            dp[i][0] = 0;
        for (int i = 0; i <= m; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    rs = Math.max(rs, dp[i][j]);//每次更新记录最大值
                } else//不相等的情况
                    dp[i][j] = 0;
            }
        return rs;//返回的结果为rs
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //char[] a = sc.nextLine().toCharArray();
        //char[] b = sc.nextLine().toCharArray();
        String s1 = "HelloWorld";
        String s2 = "loop";
        System.out.println(findLongest1(s1, s1.length(), s2, s2.length() ));
    }

    /**
     *最长公共子序列
     * @return
     */
    static int findLongest1(String A, int n, String B, int m) {
        if (n == 0 || m == 0)
            return 0;
        int rs = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)//初始状态
            dp[i][0] = 0;
        for (int i = 0; i <= m; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    //rs = Math.max(rs, dp[i][j]);//每次更新记录最大值
                } else//不相等的情况
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        return dp[n][m];//返回的结果为rs
    }

}
