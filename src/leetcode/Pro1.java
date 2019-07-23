package leetcode;

import java.util.HashMap;

/**
 * @Author: zl
 * @Date: 2019/7/23 9:10
 */
public class Pro1 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[2];
        if (len < 2) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                res[0] = index;
                res[1] = i;
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
