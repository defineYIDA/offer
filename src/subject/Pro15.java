package subject;

/**
 * @Author: zl
 * @Date: 2019/7/10 10:54
 */
public class Pro15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
