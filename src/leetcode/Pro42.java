package leetcode;

/**
 * @Author: zl
 * @Date: 2019/7/28 10:12
 */
public class Pro42 {
    //思路：某个位置雨水的深度，是两边最大高度的最小值减去当前高度
    //所以可以有多种解法：
    //1）既然知道左右最大高度二者间的最小值，就可以暴力：O(n^2)的方式来解决
    //2）采用2n的空间来记录一次遍历的最大值，达到时间复杂度O(n)
    //3）双指针法，同时开始遍历，如果left_max > right_max那么水深就完全取决于right_max
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 1) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        int left_max = height[0];
        int right_max = height[len - 1];
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < left_max) {
                    ans += (left_max - height[left]);
                } else {
                    left_max = height[left];
                }
                left++;
            } else {
                if (height[right] < right_max) {
                    ans += (right_max - height[right]);
                } else {
                    right_max = height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
