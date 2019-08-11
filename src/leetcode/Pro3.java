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
}
