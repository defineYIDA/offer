package leetcode;

/**
 * @Author: zl
 * @Date: 2019/7/22 10:29
 */
public class Pro8 {
    public int myAtoi(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        str = str.trim();//去掉首尾空格
        char[] strArr = str.toCharArray();
        boolean flag = true;//+-
        int cur = 0;
        //trim后的字符串可能为空
        if ("".equals(str)) {
            return 0;
        }
        if (strArr[0] == '-' || strArr[0] == '+') {
            flag = (strArr[0] != '-');
            cur++;
        }
        int res = 0;
        if (cur < strArr.length) {
            res = strToInt(strArr, cur, flag);
        }
        return res;
    }
    private int strToInt(char[] strArr, int cur, boolean flag) {
        long num = 0;
        while (cur < strArr.length) {
            if ('0' <= strArr[cur] && strArr[cur] <= '9') {
                int f = flag ? 1 : -1;
                num = num * 10 + f * (strArr[cur] - '0');
                //check range
                if (flag && num >= 0x7FFFFFFF) {
                    return Integer.MAX_VALUE;
                }
                if (!flag && num <= 0x80000000) {
                    return Integer.MIN_VALUE;
                }
            } else {
                return (int)num;
            }
            cur++;
        }
        return (int)num;
    }
}
