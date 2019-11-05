package interview.度小满;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/9/21 17:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < count; i++) {
            pro1(Integer.valueOf(sc.nextLine()));
        }
    }
    public static void pro1(int n) {
        if (n < 2) {
            return;
        }
        long all = 0, t = n - 1;
        while (t >0) {
            all += t;
            t--;
        }
        long total = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (judge(i, j)) {
                    total += (i * j);
                }
            }
        }
        socre(total, all);
    }
    private static void socre(long total, long all) {
        long num = getNum(total, all);
        if ((total % all) == 0) {
            System.out.println(total / num);
        } else {
            System.out.println(total / num + "/" + all / num);
        }
    }
    //最大公约数
    private static long getNum(long a, long b) {
        if (b == 0) {
            return a;
        }
        return getNum(b, a % b);
    }
    //判断互质
    private static boolean judge(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int c;
        while ((c = a % b) != 0) {
            a = b;
            b = c;
        }
        return b == 1;
    }
}
