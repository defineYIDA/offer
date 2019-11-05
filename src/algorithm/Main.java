package algorithm;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/8/30 18:53
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] arr = line1.split(" ");
        if (arr.length != 2) {
            throw new IllegalArgumentException();
        }
        int len = Integer.valueOf(arr[0]);//路长
        int count = Integer.valueOf(arr[1]);//D的个数
        int[] in = new int[count];
        for (int i = 0; i < count; i++) {
            String line = scanner.nextLine();
            in[i] = Integer.valueOf(line);
        }
        len = 10;
        in = new int[]{5,2,6};
        System.out.println(beginCount(len, in));
    }

    //10 3
    //5
    //2
    //6
    private static int beginCount(int len, int[] arr) {
        if (arr.length < 2 || len < 1) {
            return 0;
        }
        end = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            count(len, arr, i, 0);
        }
        int count = 0;
        for (int i = 1; i < len + 1; i++) {
            if (end[i] != 0) {
                count++;
            }
        }
        return count;
    }
    static int[] end;
    private static boolean count(int len, int[] arr, int cur, int c) {
        if (c >= arr.length) {
            if (cur >= 0 && cur < len + 1 && end[cur] == 0) {
                end[cur]++;
            }
            return true;
        }
        boolean res = false;
        //左移
        if (cur + arr[c] <= len) {
            res = count(len, arr, cur + arr[c], c + 1);
        }
        if (cur - arr[c] > 0) {
            res = count(len, arr, cur - arr[c], c + 1);
        }
        return res;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(findSubString(line));
    }

    private static int findSubString(String str) {
        if ("".equals(str)) {
            return 0;
        }
        int[] hash = new int[128];
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i)]++;
            max = Math.max(max, hash[str.charAt(i)]);
        }
        return max;

    }
}
