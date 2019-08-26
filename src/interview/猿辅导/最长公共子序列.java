package interview.猿辅导;

/**
 * @Author: zl
 * @Date: 2019/8/26 9:51
 */
public class 最长公共子序列 {
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
