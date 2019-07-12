package leetcode;

/**
 * @Author: zl
 * @Date: 2019/7/12 10:39
 */
public class Pro151 {
    public String reverseWords(String s) {
        if (s == null) {
            return "";
        }
        String[] strArr = s.split(" ");
        if (strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            //注意以空格分割多个连续的空格为""
            if (!"".equals(strArr[i])) {
                sb.append(strArr[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
