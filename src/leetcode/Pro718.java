package leetcode;

/**
 * @Author: zl
 * @Date: 2019/9/2 9:17
 */
public class Pro718 {
    public int findLength(int[] A, int[] B) {
        int la = A.length, lb = B.length;
        if (la == 0 || lb == 0) {
            return 0;
        }
        //状态量：dp[i, j]当前位置的公共子串长度
        //状态方程：dp[i, j] = dp[i - 1, j - 1] + 1;
        int[][] dp = new int[la][lb];
        int max = 0;
        for (int i = 0; i < la; i++) {
            for (int j = 0; j < lb; j++) {
                if (A[i] == B[j]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
