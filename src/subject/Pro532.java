package subject;

/**
 * @Author: zl
 * @Date: 2019/5/28 11:04
 */
public class Pro532 {
    public static void main(String[]  v) {
        int[] array = {3,3,3,3,4,5};
        System.out.println(getSameValAndIndex());
    }
    public static int getSameValAndIndex() {
        int[] nums = {-1,0,1,2,3,5,6,7};
        int start = 0;
        int end = nums.length;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == mid) {
                return mid;
            }
            if (nums[mid] > mid) {//如果mid大于val代表目标值在左边
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
