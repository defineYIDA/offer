package subject;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/6/11 10:08
 *
 * 数组中存在重复元素的题
 *
 */
public class Pro3 {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length != length) {
            return false;
        }
        //int[] nums = new int[length];
        //使用自身来存储遍历结果：
        //遍历将 第<i>个元素的值num，以num为下标的值加上length，作为标识
        //如果出现 index == num，对应的值大于length，即代表遍历过
        //也可以通过-length，恢复
        for (int i = 0; i < length; i++) {
            int num = numbers[i];
            if (num >= length) {
                num -= length;
            }
            if (numbers[num] >= length) {
                duplication[0] = num;
                return true;
            }
            numbers[num] += length;
        }
        return false;
    }
    public static void main(String[] strings) {
        Pro3 p = new Pro3();
        int[] a = {-1,2147483647};
        p.containsNearbyAlmostDuplicate(a, 1, 2147483647);
    }
    //思路：使用滑动窗口进行计算
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 1 || k == 0) {
            return false;
        }
        int left = 0;
        int right = 0;
        int len = nums.length;
        //滑动窗口算法
        while (right < len) {
            int size = right - left;
            if (size < k) {
                right++;
            } else {
                left++;
                right++;
            }
            if (right == len) {
                return false;
            }
            if (judgeAbs(nums, t, left, right)) {
                return true;
            }
        }
        return false;

    }
    //判断窗口内的值是否满足绝对值大于小于t
    private boolean judgeAbs(int[] nums, int t, int left, int right) {
        long[] temp = new long[right - left + 1];
        //或的窗口中的最小差的绝对值,肯定发生在排序好的的相邻元素
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[left];
            left++;
        }
        Arrays.sort(temp);
        long min = Math.abs(temp[1] - temp[0]);
        for (int i = 2; i < temp.length; i++) {
            long diff = Math.abs(temp[i] - temp[i - 1]);
            if (diff < min) {
                min = diff;
            }
        }
        return min <= t;
    }
}
