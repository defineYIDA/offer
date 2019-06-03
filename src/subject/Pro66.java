package subject;

/**
 * @Author: zl
 * @Date: 2019/6/3 11:18
 */
public class Pro66 {
    /**
     *题：构建乘积数组
     *       思路：如果使用粗暴的方法，时间复杂度为n*n
     *            则可以将B[i]分为两部分：
     *            C[i] = A[0]*A[1]*...*A[i-1] = C[i-1]*A[i-1]
     *            D[i] = A[i+1]*A[i+2]*...*A[n-1] = D[i+1]*A[i+1]
     *即实际还是通过记录前面的计算结果，来减少重复计算
     */
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        if (A == null) {
            return B;
        }
        B[0] = 1;
        //第一步的结果为：C[i]
        for (int i = 1; i < n; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        //第二步的结果：C[i] * D[i]
        //从后往前遍历，temp的累乘的结果为D[i]
        for (int i = n - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }
}
