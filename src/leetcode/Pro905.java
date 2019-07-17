package leetcode;

/**
 * @Author: zl
 * @Date: 2019/7/17 11:22
 */
public class Pro905 {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        if (len == 0) {
            return A;
        }
        int l = 0;
        int r = len -1;
        while (l < r) {
            //A[r]为偶数
            while (l < r && (A[r] & 1) != 0) {
                r--;
            }
            //A[l]不为偶数
            while (l < r && (A[l] & 1) == 0) {
                l++;
            }
            swap(A, r, l);
        }
        return A;
    }
    private void swap(int[] A, int l, int r) {
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }
}
