package subject;

import java.util.Collection;
import java.util.Collections;

/**
 * @Author: zl
 * @Date: 2019/7/11 9:39
 */
public class Pro20 {
    public boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        //小数点前面是有符号，后面是无符号，e后面是有符号
        int n = scanInteger(str, 0);
        int tmp = n;
        n = scanUnsignInteger(str, n);
        boolean isNum = (tmp != n );
        if (n < str.length && str[n] == '.') {
            n++;
            int tmp1 = n;
            n = scanUnsignInteger(str, n);
            // -.123 /-1. 算数字
            isNum = isNum || (tmp1 != n);
        }
        if (n < str.length && (str[n] == 'e' || str[n] == 'E')) {
            n++;
            n = scanInteger(str, n);
            int tmp2 = n;
            n = scanUnsignInteger(str, n);
            isNum = isNum && (tmp2 != n);
        }
        return isNum && (n == str.length);
    }
    private int scanInteger(char[] str, int n) {
        if (n < str.length && (str[n] == '+' || str[n] == '-')) {
            n++;
        }
        return n;
    }
    private int scanUnsignInteger(char[] str, int n) {
        while (n < str.length && str[n] >= '0' && str[n] <= '9') {
            n++;
        }
        return n;
    }
}
