package leetcode;

/**
 * @Author: zl
 * @Date: 2019/9/13 9:12
 */
public class Pro283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return ;
        }
        int zeroCount = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                if (zeroCount != 0) {
                    nums[i - zeroCount] = nums[i];
                    nums[i] = 0;
                }
            }
        }
        return ;
    }
}
