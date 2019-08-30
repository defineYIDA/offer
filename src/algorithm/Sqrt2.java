package algorithm;

/**
 * @Author: zl
 * @Date: 2019/8/30 9:56
 */
public class Sqrt2 {
    public static void main(String[] args) {
        sqrt2(10);
    }
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
}
