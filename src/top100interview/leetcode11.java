package top100interview;

/**
 * @Author: zl
 * @Date: 2019/8/29 10:01
 */
public class leetcode11 {
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        //向内移到长板面积只能不变或者变小
        //向内移动短板面积可能变大
        while (l < r) {
            if (height[l] < height[r]) {
                max = Math.max(max, height[l] * (r - l));
                l++;
            } else {
                max = Math.max(max, height[r] * (r - l));
                r--;
            }
        }
        return max;
    }
}
