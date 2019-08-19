package subject;

/**
 * @Author: zl
 * @Date: 2019/8/19 12:01
 */
public class RectCover {
    //如果用1*m的方块覆盖m*n区域，递推关系式为f(n) = f(n-1) + f(n-m)，(n > m)
    public int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        int[] dp = new int[target];
        if (target <= 2) {
            return target;
        }
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target - 1];
    }
}
