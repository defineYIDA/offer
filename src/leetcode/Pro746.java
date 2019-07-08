package leetcode;

/**
 * @Author: zl
 * @Date: 2019/7/8 15:11
 */
public class Pro746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] minCost = new int[len + 1];
        minCost[0] = 0;
        minCost[1] = cost[0];
        //分别以第一和第二为起点
        for (int i = 2; i < len + 1; i++) {
            minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
        }
        int[] minCostS = new int[len + 1];
        minCostS[1] = 0;
        minCostS[2] = cost[1];
        for (int i = 3; i < len + 1; i++) {
            minCostS[i] = Math.min(minCostS[i - 1] + cost[i - 1], minCostS[i - 2] + cost[i - 2]);
        }
        return Math.min(minCost[len], minCostS[len]);
    }
}
