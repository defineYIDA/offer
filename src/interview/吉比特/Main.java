package interview.吉比特;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/9/5 19:56
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String[] arr = string.split(" ");
        int m = Integer.valueOf(arr[1]);
        int[][] in = new int[m][3];
        //第二题
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] sArr = s.split(" ");
            in[i][0] = Integer.valueOf(sArr[0]);
            in[i][1] = Integer.valueOf(sArr[1]);
            in[i][2] = Integer.valueOf(sArr[2]);
        }
        System.out.println(minCount(Integer.valueOf(arr[0]), in));
        //第一题
        //System.out.println(findMaxIndex(arr[0], arr[1]));

    }

    private static int minCount(int m, int[][] arr) {
        return 0;
    }


    private static int findMaxIndex(String p, String s) {
        if (p == null || s == null || s.length() > p.length()) {
            throw new IllegalArgumentException();
        }
        //主串从右往左遍历
        for (int i = p.length() - 1; i >= 0; i--) {
            //找到字符和子串第一个字符相等
            if (p.charAt(i) == s.charAt(0) && isSub(p, s, i)) {
                return i + 1;
            }
        }
        //不存在该子串
        return -1;
    }

    //判断是否是子串。从主串的i位置开始向后寻找
    private static boolean isSub(String p, String s, int i) {
        int cur = 0;
        for (; i < p.length(); i++) {
            if (s.charAt(cur) == p.charAt(i)) {
                cur++;
            }
        }
        return cur == s.length();
    }
}
