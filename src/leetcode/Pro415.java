package leetcode;

/**
 * @Author: zl
 * @Date: 2019/7/29 10:14
 */
public class Pro415 {
    //字符串相加
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, flag = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = n1 + n2 + flag;
            flag = temp / 10;
            sb.append(temp % 10);
            i--;
            j--;
        }
        if (flag != 0)
            sb.append(flag);
        //反转输出
        return sb.reverse().toString();
    }
}
