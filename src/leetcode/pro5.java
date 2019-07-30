package leetcode;

/**
 * @Author: zl
 * @Date: 2019/7/30 11:40
 */
public class pro5 {
    //思路：暴力：时间复杂度为n^2
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        //记录最长回文子串的左右边界
        int left_m = 0;
        int right_m = 0;
        int cur = 0;
        while (cur < s.length()) {
            int l1 = aroundPoint(s, cur, cur);
            int l2 = aroundPoint(s, cur, cur + 1);
            int len = Math.max(l1, l2);
            if ((right_m - left_m ) < len) {
                if ((len & 1) == 1) {//奇数
                    left_m = cur - (len - 1) / 2;
                    right_m = cur + (len - 1) / 2;
                } else {
                    left_m = cur - len / 2 + 1;
                    right_m = cur + len / 2;
                }
            }
            cur++;
        }
        return s.substring(left_m, right_m + 1);
    }

    private int aroundPoint(String s, int left, int right) {
        //计算回文长度
        int len = s.length();
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
