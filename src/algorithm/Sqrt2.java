package algorithm;

/**
 * @Author: zl
 * @Date: 2019/8/30 9:56
 */
public class Sqrt2 {
    public static void main(String[] args) {
        sqrt2(10);
        sqrt(10, 0.01f);
    }
    // ctr 精度
    private static void sqrt2(int ctr) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < ctr; i++) {
            int temp = a;
            a = a + b;
            b = 2 * temp + b;
            double res = b * 1.0 / a;
            System.out.println(res);
        }
    }
    //开平方，牛顿迭代法
    private static void sqrt(int n, double m) {
        double k = 1.0;
        while (Math.abs(k * k - n) > m) {
            k = (k + n / k) / 2;
        }
        System.out.println(k);
    }
}
