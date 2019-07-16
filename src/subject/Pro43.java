package subject;

/**
 * @Author: zl
 * @Date: 2019/5/22 22:06
 */
public class Pro43 {
    public class Solution {
        public int NumberOf1Between1AndN_Solution(int n) {
            int num = 0;
            for(int i = 0; i <= n; i++) {
                num += numOf(i);
            }
            return num;
        }
        public int numOf(int n) {
            int num = 0;
            while (n != 0) {
                if (n % 10 == 1) {
                    num++;
                }
                n = n / 10;
            }
            return num;
        }
    }
    //---
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        //将数字转化为数组处理
        String val = n + "";
        int len = val.length();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = val.charAt(i) - '0';
        }
        return numberOf1(nums, 0);
    }
    private int numberOf1(int[] nums, int index) {
        if (nums == null || index >= nums.length || index < 0) {
            return 0;
        }
        //每一次都计算最高位上的1的个数
        int first = nums[index];
        int len = nums.length - index;
        //只有一位，且不为0
        if (len == 1 && first > 0) {
            return 1;
        }
        int c1 = 0;
        //最高位大于1，如21345，最高位的1出现在[10000, 19999]中出现次数为，10^4
        if (first > 1) {
            c1 = (int)Math.pow(10, len - 1);
        }
        //最高位等于1，如12345，最高位1出现在[10000， 12345]中出现次数为，2345 + 1
        else if (first == 1) {
            c1 = atoi(nums, index + 1) + 1;
        }
        //计算其他位数中1的个数,[1346, 21345],进一步分为两部分：[1345, 11345] [11345, 21345]
        //每一部分10000个数，排列组合：2 * 4 * C10取1^3 = 8000
        int c2 = first * (len - 1) * (int)Math.pow(10, len - 2);
        //计算[0, 1345] ,这一部分使用递归进行解决
        int c3 = numberOf1(nums, index + 1);
        return c1 + c2 + c3;
    }
    private int atoi(int[] nums, int index) {
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = res * 10 + nums[i];
        }
        return res;
    }
}
