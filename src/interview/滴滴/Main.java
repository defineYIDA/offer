package interview.滴滴;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/9/19 19:28
 */
public class Main {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] strArr = line1.split(" ");
        int[][] limit = new int[Integer.valueOf(strArr[1])][2];
        for (int i = 0; i < Integer.valueOf(strArr[1]); i++) {
            String s = sc.nextLine();
            String[] sArr = s.split(" ");
            limit[i][0] = Integer.valueOf(sArr[0]);
            limit[i][1] = Integer.valueOf(sArr[1]);
        }
        pro(Integer.valueOf(strArr[0]), limit);
    }*/
    private static void pro(int n, int[][] limit) {
        if (n < 1) {
            System.out.println(0);
            return;
        }
        HashSet<Integer> car1 = new HashSet<>();
        HashSet<Integer> car2 = new HashSet<>();
        int[] flag = new int[n + 1];
        for (int i = 0; i < limit.length; i++) {
            if (car1.contains(limit[i][0])) {
                car1.add(limit[i][0]);
            } else {
                car2.add(limit[i][0]);
            }
            if (car1.contains(limit[i][1])) {
                car2.add(limit[i][1]);
            } else {
                car1.add(limit[i][1]);
            }

            flag[limit[i][0]] = 1;
            flag[limit[i][1]] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (flag[i] == 0) {
                if (car1.size() > car2.size()) {
                    car2.add(i);
                } else
                    car1.add(i);
            }
        }
        System.out.println(2 * Math.min(car1.size(), car2.size()));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] strArr = line1.split(" ");
        int[] arr = new int[Integer.valueOf(strArr[0])];
        String line2 = sc.nextLine();
        String[] sArr = line2.split(" ");
        for (int i = 0; i < sArr.length; i++) {
            arr[i] = Integer.valueOf(sArr[i]);
        }
        pro1(arr, Integer.valueOf(strArr[1]));
    }
    private static void pro1(int[] a, int m) {
        if (a.length == 0 || m == 0 || a.length < m) {
            System.out.println(0);
            return;
        }
        int l = 0, r = m - 1;
        int min = 0;
        for (int i = 0; i < m; i++) {
            min += a[i];
        }
        int cur = min;
        while (r < a.length) {
            cur += a[r];
            cur -= a[l];
            l++;
            r++;
            min = Math.min(min, cur);
        }
        System.out.println(min);
    }
}
