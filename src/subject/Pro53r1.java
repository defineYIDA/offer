package subject;

/**
 * @Author: zl
 * @Date: 2019/5/28 10:50
 */
public class Pro53r1 {
    public static void main(String[]  v) {
        int[] array = {3,3,3,3,4,5};
        System.out.println(getMiss());
    }
    /**
     * 获得排序数组中缺失的数字
     * 0~n-1  ，长度为n-1
     *              思考：
     *              合理的利用排序的条件
     */
    public static int getMiss() {
        int[] nums = {0,1,2,3,5,6,7};//缺失5
        int start = 0;
        int end = nums.length;
        int index = -1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (mid == start || mid == end) {
                index = nums[start] != start ? start : nums[end] != end ? end : 0;
                break;
            }
            if (nums[mid] == mid) { //还未发生乱序
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return index;
    }
}
