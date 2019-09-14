package leetcode;

/**
 * @Author: zl
 * @Date: 2019/9/6 9:52
 */
public class Pro14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        while (cur < strs[0].length()) {
            char c = strs[0].charAt(cur);
            for (int i = 1; i < strs.length; i++) {
                String s = strs[i];
                if ("".equals(s)) {
                    break;
                }
                if (cur >= s.length() || c != s.charAt(cur)) {
                    break;
                }
            }
            cur++;
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        longestCommonPrefix(s);
    }
}
