package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/9/15 9:22
 */
public class Pro448 {
    //好方法
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return list;
        }
        for (int i = 0; i < len; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
    //排序+比较的方式，复杂度nlogn，需要处理的临界条件多
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return list;
        }
        Arrays.sort(nums);
        int count = 1;
        for (int i = 0; i < len && count <= len; i++) {
            if (count == nums[i]) {
                count++;
            } else if (count - 1 == nums[i]) {
                //重复
            } else if (nums[i] > len) {
                //大于范围
                list.add(nums[i]);
            } else {
                //跳跃
                int t = nums[i];
                while (t != count && count <= len) {
                    list.add(count);
                    count++;
                }
                count++;
            }
        }
        if (count <= len) {
            while (count <= len) {
                list.add(count);
                count++;
            }
        }
        return list;
    }
}
