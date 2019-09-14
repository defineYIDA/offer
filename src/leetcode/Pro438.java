package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/9/14 9:17
 */
public class Pro438 {
    public static void main(String[] args) {
        Pro438 p = new Pro438();
        p.findAnagrams("cbaebabacd", "abc");
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if ("".equals(s) || "".equals(p) || p.length() > s.length()) {
            return list;
        }
        //窗口
        int left = 0;
        int right = p.length() - 1;
        while (right < s.length()) {
            if (anagrams(s, p, left, right)) {
                list.add(left);
            }
            left++;
            right++;
        }
        return list;
    }
    private boolean anagrams(String s, String p, int l, int r) {
        int cur = 0;
        int[] a = new int[128];
        while (l <= r) {
            a[s.charAt(l)]++;
            l++;
        }
        while (cur < p.length()) {
            if (a[p.charAt(cur)] == 0) {
                return false;
            }
            a[p.charAt(cur)]--;
            cur++;
        }
        return true;
    }
}
