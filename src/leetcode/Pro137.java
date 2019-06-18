package leetcode;

/**
 * @Author: zl
 * @Date: 2019/6/18 0:22
 */
public class Pro137 {
    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = nums[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                //将元素的每一个bit位进行计数
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }
}
