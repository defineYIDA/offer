package leetcode;

/**
 * @Author: zl
 * @Date: 2019/7/29 11:05
 */
public class pro43 {
    //大数相乘
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n1 = num1.length() - 1, n2 = num2.length() - 1;
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        //长度：i + j + 1可保证结果长度在这个范围内
        //那么遍历时的当前元素是：i + j，进位到：i + j + 1
        int[] mul = new int[n1 + n2 + 2];

        for (int i = n1; i >= 0; i--) {
            for (int j = n2; j >= 0; j--) {
                int bitMul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                bitMul += mul[i + j + 1];
                mul[i + j] += bitMul / 10;//记录进位
                mul[i + j + 1] = bitMul % 10;
            }
        }
        int i = 0;
        while (i < mul.length && mul[i] == 0) {
            i++;
        }
        for (; i < mul.length; i++) {
            sb.append(mul[i]);
        }
        return sb.toString();
    }
}
