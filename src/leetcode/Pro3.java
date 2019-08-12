package leetcode;

import java.util.ArrayList;

/**
 * @Author: zl
 * @Date: 2019/8/11 10:09
 */
public class Pro3 {
    /**
     * 解法一：
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return -1;
        }
        char[] arr = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < arr.length) {
            if (!list.contains(arr[r])) {
                list.add(arr[r]);
                r++;
                max = max > list.size() ? max : list.size();
            } else {
                list.remove(0);
            }
        }
        return max;
    }
    public int lengthOfLongestSubstring1(String s) {
        if (s == null) {
            return -1;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        int l = 0;
        for (int i = 0; i < len; i++) {
            //当前位置的前面是否存在重复字符
            if (s.substring(l, i).indexOf(s.charAt(i)) != -1) {
                //从l开始第一个s.charAt(i)，即找到重复字符的为位置
                l = s.indexOf(s.charAt(i), l) + 1;
            }
            //状态转移方程：dp[i + 1] = Math.max(dp[i] + 当前位置的最长不重复子串);
            dp[i + 1] = Math.max(dp[i], i - l + 1);
        }
        return dp[len];
    }
}
