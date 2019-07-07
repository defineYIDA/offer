package subject;

/**
 * @Author: zl
 * @Date: 2019/7/7 9:28
 */
public class Pro5 {
    private String TARGET = "%20";
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        String s = str.toString();
        char[] arr = s.toCharArray();
        //str.charAt(i);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                sb.append(TARGET);
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
