package subject;

/**
 * @Author: zl
 * @Date: 2019/6/13 11:17
 */
public class Pro11 {
    /**
     *两个指针开始二分查找
     *
     */
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (mid == left || mid == right) {
                return nums[right] > nums[left] ? nums[left] : nums[right];
            }
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[left]) {
                left = mid;
            }
        }
        return nums[right];
    }
    /**
     *两个指针开始二分查找
     *
     */
    public int findMin1(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (nums[left] == nums[right]) {
            if (left >= right) {
                return nums[left];
            }
            left++;
        }
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (mid == left || mid == right) {
                return nums[right] > nums[left] ? nums[left] : nums[right];
            }
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else if (nums[mid] >= nums[left]) {
                left = mid;
            }
        }
        return nums[right];
    }
}
