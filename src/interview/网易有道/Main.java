package interview.网易有道;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/9/21 14:57
 */
public class Main {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String len = sc.nextLine();
        for (int i = 0; i < Integer.valueOf(len); i++) {
            pro1(Integer.valueOf(sc.nextLine()));
        }
    }
    public static void pro1(int x) {
        if (x < 10) {
            System.out.println(x);
            return;
        }
        //将x分隔为1到9数字的相加，不使用0
        int len = x / 9 + 1, cur = len - 1;
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            if (x >= 9) {
                sb.append(9);
                x -= 9;
            } else {
                sb.append(x);
                x = 0;
            }
        }
        System.out.println(sb.reverse().toString());
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String len = sc.nextLine();
        for (int i = 0; i < Integer.valueOf(len); i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            pro2(Long.valueOf(arr[0]), Long.valueOf(arr[1]), Long.valueOf(arr[2]), Long.valueOf(arr[3]));
        }
    }
    public static void pro2(long a, long b, long p, long q) {
        if (b < a) {
            System.out.println(0);
            return;
        }
        //p,q 大于0，且q大于2，即q * p是增加操作
        long diff = b - a;
        int c = 0;
        while (diff > 0) {
            if (diff <= p) {
                c++;
                break;
            }
            p *= q;
            c++;
        }
        System.out.println(c);
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        String len = sc.nextLine();
        for (int i = 0; i < Integer.valueOf(len); i++) {
            int l = Integer.valueOf(sc.nextLine());
            String[] s2 = sc.nextLine().split(" ");
            int[] arr = new int[l];
            for (int j = 0; j < l; j++) {
                arr[j] = Integer.valueOf(s2[j]);
            }
            pro3(arr, l);
        }
    }
    public static void pro3(int[] arr, int len) {
        int max = 1;
        int[] dp = new int[len];
        int[] temp = new int[len];
        dp[0] = 1;
        temp[0] = arr[0];
        for (int i = 1; i < len; i++) {
            if (temp[i - 1] <= arr[i]) {
                temp[i] = temp[i - 1] + arr[i];
                dp[i] = dp[i - 1] + 1;
                max = Math.max(max, dp[i]);
            } else {
                temp[i] = arr[i];
                dp[i] = 1;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.valueOf(sc.nextLine());
        String[] s2 = sc.nextLine().split(" ");
        int[] arr = new int[len];
        for (int j = 0; j < len; j++) {
            arr[j] = Integer.valueOf(s2[j]);
        }
        pro4(arr, len);
    }
    //思路归并排序
    public static void pro4(int[] arr, int l) {

    }

}
