package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zl
 * @Date: 2019/7/18 10:26
 */
public class Pro560 {
    public static void main(String[] args){
        Pro560 p = new Pro560();
        int[] arr = {28,54,7,-70,22,65,-6};
        p.subarraySum(arr, 100);
    }
    //思路滑动窗口,不行，带负号不好滑
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //注意put(0,1)思考刚好相等的情况[1,2,3],6
        map.put(0, 1);
        int sum = 0, ret = 0;
        //公式：
        //arr[i] = nums[0] + nums[1] + nums[2] + ... + nums[i];
        //arr[j] = nums[0] + nums[1] + nums[2] + ... + nums[j];
        //如果：k = arr[j] - arr[i] 就代表在窗口[i, j]的连续数组里满足等于k
        //arr[j] 为当前的累计和sum
        //则如果存在：arr[i] = sums - k;就代表存在满足的子序列
        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if(map.containsKey(sum-k))
                ret += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ret;
    }
}
