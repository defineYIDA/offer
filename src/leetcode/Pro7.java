package leetcode;

/**
 * @Author: zl
 * @Date: 2019/8/1 9:26
 */
public class Pro7 {
    public int reverse(int x) {
        String s = String.valueOf(x);
        char[] arr = s.toCharArray();
        boolean flag = true;//+
        int cur = 0;
        if (arr[0] == '-') {
            flag = false;
            cur++;
        }
        //reverse
        char[] out = new char[arr.length];
        int oCur = arr.length - 1;
        while (cur < arr.length) {
            out[oCur] = arr[cur];
            oCur--;
            cur++;
        }
        if (!flag) {
            int i = 0;
            while (i < out.length && (out[i] == '0' || out[i] == ' ')) {
                i++;
            }
            int j = i == 0 ? 0 : --i;
            out[j] = '-';
        }
        s = String.valueOf(out);
        Integer res;
        try {
            res = Integer.valueOf(s);
        } catch (Exception e) {
            return 0;
        }
        return res;
    }
    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
