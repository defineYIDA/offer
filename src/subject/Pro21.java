package subject;

/**
 * @Author: zl
 * @Date: 2019/6/14 21:19
 */
public class Pro21 {
    /**
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     *
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     *
     * 你可以返回任何满足上述条件的数组作为答案。
     *
     * 考虑可扩展情况将条件交换条件移出
     * @param A
     * @return
     */
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
