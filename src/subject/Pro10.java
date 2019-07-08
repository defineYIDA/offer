package subject;

/**
 * @Author: zl
 * @Date: 2019/7/8 9:54
 */
public class Pro10 {
    //方法一：暴力法dfs
    //时间复杂度：2^n；空间复杂度：n
    private int climCore(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return climCore(n - 1) + climCore(n - 2);
    }

    //方法二：动态规划法
    //时间复杂度：n；空间复杂度：n
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] mem = new int[n + 1];
        mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n];
    }
    //方法三：斐波那契数
    //时间复杂度：n；空间复杂度：1
    public int climbStairs1(int n) {
        int frist = 1;
        int second = 2;
        for (int i = 3; i < n + 1; i++) {
            int temp = second;
            second = frist + second;
            frist = temp;
        }
        return second;
    }
}
