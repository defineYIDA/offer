package leetcode;

/**
 * @Author: zl
 * @Date: 2019/6/15 0:52
 */
public class Pro713 {
    //思路：双指针(窗口)，当窗口内的乘积大于k是左边界加一右边界等于左边界
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int right = 0;
        int cur = 0;
        int count = 0;
        int res = 1;//缓存乘积防止重复计算
        while (left < len) {
            while (cur < len && cur <= right) {
                if (res == 1) {
                    for (int i = left; i <= cur; i++) {
                        res *= nums[i];
                    }
                } else {
                    res *= nums[cur];
                }
                if (res < k) {
                    count++;
                    cur++;
                } else {
                    //有两种退出方式：1）出现大于k的乘积；2）窗口内全部满足
                    cur = -1;
                    break;
                }
            }
            if (right < len - 1 && cur != -1) {
                right++;
            } else {
                left++;
                right = left;
                cur = left;
                res = 1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Pro713 p = new Pro713();
        int[] a = {10, 5, 2, 6};
        p.numSubarrayProductLessThanK(a, 100);
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int n=nums.length;
        int l=0,r=0;
        int ans=0;
        int sum=1;
        while(r<n){
            sum*=nums[r++];
            while(l<r && sum>=k){
                sum/=nums[l++];
            }
            ans+=r-l;
        }
        return ans;
    }
}
