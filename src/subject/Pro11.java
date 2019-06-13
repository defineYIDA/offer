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
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        if (len == 0 || len % 2 != 0) {
            return A;
        }
        int[] nums = A;
        int p1 = 0;
        int p2 = 1;
        //一个指针（p1）遍历奇数项，一个指针（p2）遍历偶数项
        while (p1 < len && p2 < len) {
            if (nums[p1] % 2 == 1 && nums[p2] % 2 == 0) {
                //交换
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
                p1 += 2;
                p2 += 2;
            }
            if (p1 < len &&nums[p1] % 2 == 0) {
                p1 += 2;
            }
            if (p2 < len &&nums[p2] % 2 == 1) {
                p2 += 2;
            }
        }
        return nums;
    }
}
