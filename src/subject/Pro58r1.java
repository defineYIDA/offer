package subject;

/**
 * @Author: zl
 * @Date: 2019/5/30 10:50
 */
public class Pro58r1 {
    /**
     *题：左旋转字符串
     *      思路：将字符串分为两部分，先分别旋转两部分，再旋转整字符串
     *
     */
    public String LeftRotateString(String str,int n) {
        int length = str.length();
        if (str == null || str == "") {
            return str;
        }
        if (n >= length) {
            return str;
        }

        char[] strArr = str.toCharArray();
        //三次次翻转
        reverse(strArr, 0, n - 1);
        reverse(strArr, n, length - 1);
        reverse(strArr, 0, length - 1);
        return String.valueOf(strArr);
    }


    private void reverse(char[] str, int s, int e) {
        if (s == e) {
            return;
        }
        while (s < e) {
            char temp = str[s];
            str[s] = str[e];
            str[e] = temp;
            s++;
            e--;
        }
    }
}
