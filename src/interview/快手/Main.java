package interview.快手;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/9/28 20:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.valueOf(sc.nextLine());
        String lib = sc.nextLine();
        pro1(k, lib);
    }

    private static void pro1(int k, String lib) {
        if (k <= 0 || lib == null || "".equals(lib)) {
            return;
        }
        int l = 0, r = 0;
        int count = lib.charAt(l) == '1' ? 1 : 0;
        int res = 0;
        //双指针，窗口内1的个数小于k，r++,
        //窗口内1个数大于k，l++
        while (r < lib.length()) {
            if (count < k) {
                r++;
                if (r < lib.length() && lib.charAt(r) == '1') {
                    count++;
                }
            } else if (count > k) {
                if (lib.charAt(l) == '1') {
                    count--;
                }
                l++;
            } else {
                res++;
                r++;
                if (r < lib.length() && lib.charAt(r) == '1') {
                    count++;
                }
                while (l < r && lib.charAt(l) == '0') {
                    res++;
                    l++;
                }
            }
        }
        //处理最后区间
        while (count >= k && l < lib.length()) {
            if (lib.charAt(l) == '1') {
                count--;
                l++;
            } else {
                l++;

            }
            if (count == k)
                res++;
        }
        System.out.println(res);
    }
}
