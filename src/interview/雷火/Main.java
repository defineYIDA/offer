package interview.雷火;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/9/15 13:56
 */
public class Main {
   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.valueOf(sc.nextLine());
        int[] arr = new int[len];
        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.valueOf(strArr[i]);
        }
        int k = Integer.valueOf(sc.nextLine());
        pro1(arr, k);
    }
    private static void pro1(int[][] arr) {

    }
    //static int count = 0;
    private static void pro1(int[] arr, int k) {
        //bfs
        int count = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int z = j + 1; z < len; z++) {
                    int m = arr[i] + arr[j] + arr[z];
                    if (m < k) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
    private static void core(int[] arr, int k, int l, int r) {

        for (int i = 0; l < arr.length; i++) {

        }
    }*/


    private static void pro2(int[] arr) {
        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }
        int count = 0, l = 0, r = arr.length - 1;
        int flag = 0;
        while (l <= r) {
            //每一次拿最大值
            if (arr[l] == arr[r]) {
                if (flag % 2 == 0) {
                    count += arr[r];
                }
                r--;
            } else if (arr[l] < arr[r]) {
                if (flag % 2 == 0) {
                    count += arr[r];
                }
                r--;
            } else {
                if (flag % 2 == 0) {
                    count += arr[l];
                }
                l++;
            }
            flag++;
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.valueOf(sc.nextLine());
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            String str = sc.nextLine();
            String[] strArr = str.split(" ");
            arr[i][0] = Integer.valueOf(strArr[0]);
            arr[i][1] = Integer.valueOf(strArr[1]);
        }
        pro1(arr);
    }
    private static void pro1(int[][] arr) {
        if (arr.length == 0) {
            System.out.println(0 + " " + 0);
            return;
        }
        long heapMax = arr[0][1];
        long lastTime = arr[0][0];
        long lastThing = arr[0][1];
        int total = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            long diff = arr[i][0] - lastTime;//时间间隔
            long temp = lastThing - diff + arr[i][1];
            heapMax = Math.max(heapMax, temp);
            lastTime = arr[i][0];
            lastThing = temp > 0 ? temp : arr[i][1];
            total += arr[i][1];
        }
        lastTime += lastThing;
        //
        int max = Math.max(arr[arr.length - 1][0] + arr[arr.length - 1][1], total + arr[0][0]);
        System.out.println(lastTime + " " + heapMax);
    }
}
