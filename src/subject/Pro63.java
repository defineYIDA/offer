package subject;

/**
 * @Author: zl
 * @Date: 2019/6/2 22:11
 */
public class Pro63 {
    /**
     * 题：股票的最大利润
     *        思路：每一次记录前面遍历过的最小值和最大利润
     * @param nums
     * @return
     */
    public static int maxDiff(int[] nums) {
        if (nums.length < 2)
            return -1;
        int min = nums[0];
        int maxDiff = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            int diff = nums[i] - min;
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }
    public static void main(String[] var) {
        int[] nums = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maxDiff(nums));
    }
}
